package assignment2;

public enum PokemonTypes
{
    BUG(0),
    DRAGON(1),
    ELECTRIC(2),
    FIRE(3),
    GRASS(4),
    ICE(5),
    WATER(6),
    NORMAL(7);
    

    final int mapValue;

    PokemonTypes(int mapValue) {
        this.mapValue = mapValue;
    }

}
