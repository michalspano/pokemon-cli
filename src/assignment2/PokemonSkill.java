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

    // *** getters ***
    
    /** 
     * @return String
     */
    public String getName() 
    {
        return this.name;
    }

    /** 
     * @return int
     */
    public int getAttackPower() 
    {
        return this.attackPower;
    }

    /** 
     * @return int
     */
    public int getEnergyCost() 
    {
        return this.energyCost;
    }

    /*
    * Compare if two Pokemon Skills are the same:
    * Two skills are equal if they have the same names, APs and energy costs.
    */
    
    /** 
     * @param anotherObject
     * @return boolean
     */
    public boolean equals(Object anotherObject) 
    {    
        if (anotherObject == null) 
        {
            return false;
        }
        if (anotherObject instanceof PokemonSkill) 
        {
            // cast the Object to the desired type
            PokemonSkill anotherPokemon = (PokemonSkill) anotherObject;

            boolean checkName = this.name.equals(anotherPokemon.name);
            boolean checkAttackPower = this.attackPower == anotherPokemon.attackPower;
            boolean checkEnergyCost = this.energyCost == anotherPokemon.energyCost;

            return checkName && checkAttackPower && checkEnergyCost;
        }

        return false;
    }
    
    /** Output specified in the instructions
     * @return String
     */
    public String toString() 
    {
        return String.format("%s - AP: %d EC: %d", 
                            name, attackPower, energyCost);
    }
}