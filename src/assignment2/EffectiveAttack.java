package assignment2;

public enum EffectiveAttack
{
    FIRE("GRASS"),
    WATER("FIRE"),
    GRASS("WATER");

    private final String type;

    EffectiveAttack(String type) {
        this.type = type;
    }

    public String toString() {
        return this.type;
    }
}