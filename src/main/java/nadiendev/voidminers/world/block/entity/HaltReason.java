package nadiendev.voidminers.world.block.entity;

public enum HaltReason {
    NONE("operational"),
    NO_RECIPES_IN_DIMENSION("no recipes in this dimension"),
    STRUCTURE_NOT_FOUND("multiblock structure not found"),
    TOO_MUCH_ITEM_MULTIPLIER("too much item multiplier"),
    NOT_ENOUGH_EMPTY_SLOTS("not enough empty slots in inventory"),
    NO_BEDROCK_OR_VOID_VIEW("no bedrock or void view"),
    NOT_ENOUGH_POWER("insufficient stored energy"),
    ;

    private final String description;

    HaltReason(String description) {
        this.description = description;
    }

    String description() {
        return description;
    }

    public static HaltReason getHaltReasonFromInt(int index) {
        return HaltReason.values()[index];
    }

    public static int getIntFromHaltReason(HaltReason reason) {
        return reason.ordinal();
    }
}
