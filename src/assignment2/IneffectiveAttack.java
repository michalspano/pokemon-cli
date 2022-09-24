package assignment2;

public enum IneffectiveAttack
{
    GRASS("FIRE"),
    FIRE("WATER"),
    WATER("GRASS");

    private final String type;

    IneffectiveAttack(String type) {
        this.type = type;
    }

    public String toString() {
        return this.type;
    }
}