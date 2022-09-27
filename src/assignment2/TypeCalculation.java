package assignment2;

public class TypeCalculation {

    public static final float[][] effectiveMatrix = {
        {1,     1,      1,      0.5f,   2,      1,      1   },
        {1,     2,      1,      1,      1,      1,      1   },
        {1,     0.5f,   0.5f,   1,      0.5f,   1,      2   },
        {2,     0.5f,   1,      0.5f,   2,      2,      0.5f},
        {0.5f,  0.5f,   1,      0.5f,   0.5f,   1,      2   },
        {1,     2,      1,      0.5f,   2,      0.5f,   0.5f},
        {1,     0.5f,   1,      2,      0.5f,   1,      0.5f}
    };

    public static float getEffectiveValue(PokemonTypes attackerType, PokemonTypes targetType)
    {
        return effectiveMatrix[attackerType.mapValue][targetType.mapValue];
    }
    
}
