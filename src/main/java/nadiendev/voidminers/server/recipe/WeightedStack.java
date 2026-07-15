package nadiendev.voidminers.server.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class WeightedStack {
    public ItemStack stack;
    public String weight;

    public WeightedStack(ItemStack stack, Number weight) {
        this.stack = stack;
        this.weight = String.valueOf(weight);
    }

    public WeightedStack(Item item, Number weight) {
        this.stack = item.getDefaultInstance();
        this.weight = String.valueOf(weight);
    }

    public WeightedStack(ItemStack stack, String weight) {
        this.stack = stack;
        this.weight = weight;
    }

    public WeightedStack(Item item, String weight) {
        this.stack = item.getDefaultInstance();
        this.weight = weight;
    }

    public WeightedStack copy() {
        return new WeightedStack(stack.copy(), weight);
    }

    public float getWeightAsFloat() {
        try {
            return Float.parseFloat(weight);
        } catch (NumberFormatException e) {
            return 0.0f;
        }
    }

    public double getWeightAsDouble() {
        try {
            return Double.parseDouble(weight);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    public static final Codec<WeightedStack> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    ItemStack.CODEC.fieldOf("stack").forGetter(ws -> ws.stack),
                    Codec.STRING.fieldOf("weight").forGetter(ws -> ws.weight)
            ).apply(instance, (stack, weight) -> new WeightedStack(stack, weight))
    );

    public static final StreamCodec<RegistryFriendlyByteBuf, WeightedStack> STREAM_CODEC = StreamCodec.composite(
            ItemStack.STREAM_CODEC,
            ws -> ws.stack,
            ByteBufCodecs.STRING_UTF8,
            ws -> ws.weight,
            WeightedStack::new
    );
}