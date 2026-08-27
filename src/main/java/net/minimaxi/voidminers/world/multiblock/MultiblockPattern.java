package net.minimaxi.voidminers.world.multiblock;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.pattern.BlockInWorld;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public final class MultiblockPattern {
    private final List<MultiblockCell> cells;
    private final Map<Character, Predicate<BlockInWorld>> predicates;
    private final List<List<List<BlockState>>> previewBlocks; // null if no .block() calls were made

    MultiblockPattern(List<MultiblockCell> cells,
                      Map<Character, Predicate<BlockInWorld>> predicates,
                      List<List<List<BlockState>>> previewBlocks) {
        this.cells = List.copyOf(cells);
        this.predicates = Map.copyOf(predicates);
        this.previewBlocks = previewBlocks;
    }

    public List<BlockInWorld> matches(Level level, BlockPos anchor) {
        List<BlockInWorld> result = new ArrayList<>(cells.size());
        for (MultiblockCell cell : cells) {
            Predicate<BlockInWorld> predicate = predicates.get(cell.symbol());
            BlockInWorld block = new BlockInWorld(level, anchor.offset(cell.offset()), false);
            if (predicate == null || !predicate.test(block)) return null;
            result.add(block);
        }
        return result;
    }

    public List<List<List<BlockState>>> previewBlocks() {
        return previewBlocks;
    }
}