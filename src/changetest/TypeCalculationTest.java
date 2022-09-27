package changetest;

public class TypeCalculationTest {

    public static float[][] effectiveMatrix = {
        {1,     1,      1,      0.5f,   2,      1,      1   },
        {1,     2,      1,      1,      1,      1,      1   },
        {1,     0.5f,   0.5f,   1,      0.5f,   1,      2   },
        {2,     0.5f,   1,      0.5f,   2,      2,      0.5f},
        {0.5f,  0.5f,   1,      0.5f,   0.5f,   1,      2   },
        {1,     2,      1,      0.5f,   2,      0.5f,   0.5f},
        {1,     0.5f,   1,      2,      0.5f,   1,      0.5f}
    };

    public static float getEffectiveValue(TypesTest attackerType, TypesTest targetType)
    {
        return effectiveMatrix[attackerType.mapValue][targetType.mapValue];
    }

    public static void main(String[] args)
    {
        TypesTest type1 = TypesTest.FIRE;
        TypesTest type2 = TypesTest.FIRE;
        // TypesTest type3 = TypesTest.WATER;

        TypesTest attackerType = TypesTest.valueOf("NORMAL");
        // TypesTest targetType = TypesTest.valueOf("WATER");
        // String attackerType = this.type.toUpperCase();
        // String targetType = targetPokemon.getType().toUpperCase();

        // initial attack message (String)
        // String attackMessage = String.format("%s uses %s on %s.", 
        //                         "this.name", "this.skill.getName()", "targetPokemon.getName()");

        // int skillAttackPower = this.skill.getAttackPower();
        // int skillEnergyCost  = this.skill.getEnergyCost();

        // boolean isNormalAttack = targetType.equals("NORMAL") || attackerType.equals("NORMAL");
        // boolean isNormalAttack = targetType.

        System.out.println("Test " + attackerType);

        if(attackerType == TypesTest.NORMAL)
        {
            System.out.println("Equals");
        }

        // System.out.println("This test is: " + TypesTest.valueOf("FIRE"));

        // First Test

        float attack1 = getEffectiveValue(type1, type2);

        if(attack1 == 1)
        {
            System.out.printf("The type <%s> has no particular effect over <%s>", type1, type2);
        }
        else if(attack1 == 0.5f)
        {
            System.out.printf("The type <%s> is not very effective against <%s>", type1, type2);
        }
        else if(attack1 == 2f)
        {
            System.out.printf("The type <%s> is very effective against <%s>", type1, type2);
        }

        System.out.println();

    //     // Second Test

    //     float attack2 = getEffectiveValue(type1, type3);

    //     if(attack2 == 1)
    //     {
    //         System.out.printf("The type <%s> has no particular effect over <%s>", type1, type3);
    //     }
    //     else if(attack2 == 0.5f)
    //     {
    //         System.out.printf("The type <%s> is not very effective against <%s>", type1, type3);
    //     }
    //     else if(attack2 == 2f)
    //     {
    //         System.out.printf("The type <%s> is very effective against <%s>", type1, type3);
    //     }
    }
    
}
