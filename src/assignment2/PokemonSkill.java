package assignment2;

public class PokemonSkill
{
    /*
     * A pokemon relies on a skill during battles. A skill has a name, attack power
     * (AP), and energy cost (EC). All these values are specified when creating the
     * skill. Both AP and energy cost are integer values. Once created, the state of
     * a skill cannot be changed.
     * 
     * Two skills are equal if they have the same names, APs and energy costs. When
     * printed, a skill should return: “<skill name> - AP: <ap> EC: <ec>”.
     */    
    
    private final String name;
    private final int attackPower;
    private final int energyCost;

    public PokemonSkill(String name, int AP, int EC)
    {
        this.name = name;
        this.attackPower = AP;
        this.energyCost = EC;
    }

    // getters
    public String getName() {
        return this.name;
    }

    public int getAttackPower() {
        return this.attackPower;
    }

    public int getEnergyCost() {
        return this.energyCost;
    }

    /*
     * Compare if two Pokemon Skills are the same:
     * Two skills are equal if they have the same names, APs and energy costs.
     */
    
    public boolean equals(Object anotherObject) {
        
        if (anotherObject == null) {
            return false;
        }
        if (anotherObject instanceof PokemonSkill) {
            PokemonSkill anotherPokemon = (PokemonSkill) anotherObject;

            return this.name.equals(anotherPokemon.name) && 
                   this.attackPower == anotherPokemon.attackPower && 
                   this.energyCost == anotherPokemon.energyCost;
        }
        return false;
    }

    public String toString() {
        return String.format("%s - AP: %d EC: %d", name, attackPower, energyCost);
    }
}