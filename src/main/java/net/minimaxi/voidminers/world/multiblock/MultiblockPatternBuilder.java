package net.minimaxi.voidminers.world.multiblock;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.pattern.BlockInWorld;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;

public final class MultiblockPatternBuilder {
    private final List<String[]> aisles = new ArrayList<>();
    private final Map<Character, Predicate<BlockInWorld>> predicates = new HashMap<>();
    private final Map<Character, Supplier<BlockState>> blockProvider = new HashMap<>();

    public static MultiblockPatternBuilder start() {
        return new MultiblockPatternBuilder();
    }

    public MultiblockPatternBuilder aisle(String... rows) {
        aisles.add(rows);
        return this;
    }

    public MultiblockPatternBuilder where(char symbol, Predicate<BlockInWorld> predicate) {
        predicates.put(symbol, predicate);
        return this;
    }

    public MultiblockPatternBuilder block(char symbol, Supplier<BlockState> stateSupplier) {
        blockProvider.put(symbol, stateSupplier);
        return this;
    }

    public MultiblockPattern build() {
        List<String[]> reversed = new ArrayList<>(aisles);
        Collections.reverse(reversed);

        int starX = -1, starY = -1, starZ = -1;
        outer:
        for (int y = 0; y < reversed.size(); y++) {
            String[] layer = reversed.get(y);
            for (int x = 0; x < layer.length; x++) {
                int z = layer[x].indexOf('*');
                if (z >= 0) { starX = x; starY = y; starZ = z; break outer; }
            }
        }
        if (starX == -1) throw new IllegalStateException("Pattern has no '*' anchor character");

        List<MultiblockCell> cells = new ArrayList<>();
        for (int y = 0; y < reversed.size(); y++) {
            String[] layer = reversed.get(y);
            for (int x = 0; x < layer.length; x++) {
                String row = layer[x];
                for (int z = 0; z < row.length(); z++) {
                    char c = row.charAt(z);
                    if (!predicates.containsKey(c)) continue;
                    cells.add(new MultiblockCell(c, new BlockPos(x - starX, y - starY, z - starZ)));
                }
            }
        }

        List<List<List<BlockState>>> preview = blockProvider.isEmpty() ? null : buildPreviewStates();

        return new MultiblockPattern(cells, predicates, preview);
    }

    private List<List<List<BlockState>>> buildPreviewStates() {
        List<List<List<BlockState>>> structure = new ArrayList<>();
        for (String[] layer : aisles) {
            List<List<BlockState>> layerStates = new ArrayList<>();
            for (String row : layer) {
                layerStates.add(getStatesForRow(row));
            }
            structure.add(layerStates);
        }
        return structure;
    }

    private List<BlockState> getStatesForRow(String row) {
        List<BlockState> states = new ArrayList<>();
        for (int i = 0; i < row.length(); i++) {
            char c = row.charAt(i);
            if (c == ' ') {
                states.add(net.minecraft.world.level.block.Blocks.AIR.defaultBlockState());
            } else if (blockProvider.containsKey(c)) {
                states.add(blockProvider.get(c).get());
            }
        }
        return states;
    }
}