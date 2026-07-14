package nadiendev.voidminers.util;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TextColor;

public class CustomColorUtil {
    private final String hexColor;
    private final TextColor textColor;
    private final ChatFormatting formatting;

    public CustomColorUtil(String hexColor) {
        this.hexColor = hexColor;
        // Fix: Parse the DataResult and get the value or default to white
        this.textColor = TextColor.parseColor(hexColor)
                .result()
                .orElse(TextColor.fromRgb(0xFFFFFF)); // Fallback to white if parsing fails
        this.formatting = ChatFormatting.WHITE;
    }

    public String getHexColor() {
        return hexColor;
    }

    public TextColor getTextColor() {
        return textColor;
    }

    public String applyColor(String text) {
        return "§x" + hexColor.substring(1).chars()
                .mapToObj(c -> "§" + c)
                .reduce("", (a, b) -> a + b) + text + "§r";
    }

    public static CustomColorUtil fromHex(String hex) {
        return new CustomColorUtil(hex);
    }
}