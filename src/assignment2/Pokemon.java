package assignment2;

/*  TODO: this Class is currently __bloated__ and should be revisited soon! 
 * - reduce inconsistencies and repetition;
 * - enhance overall performance.
*/

public class Pokemon {

    // *** attributes ***

    private String name;
    private final int MAX_HP;

    private int currentHP;
    private int energyPoints;
    
    private final String type;
    private PokemonSkill skill; 

    // custom object attributes
    private boolean hasFainted;

    // class constants
    final byte MAX_ENERGY = 100;
    final byte ENERGY_RECOVER = 25;
    final byte HEALTH_RECOVER = 20;

    final String END_OF_LINE = System.lineSeparator();

     
    /* Each pokemon has:
    - 1. name
    - 2. max health
    - 3. current energy, current health
    - 4. type - (fire, water, grass, normal)
    - 5. a single skill (task 2) */
    
    // *** constructor ***

    /* The name, MAX HP and type must be specified.
       For all tasks below you can assume that the constructor receives only valid
       values  */

    public Pokemon(String name, int maximumHP, String type)
    {
        this.name = name;

        this.MAX_HP = maximumHP;
        this.currentHP = this.MAX_HP;   // after creation, the current is the maximum

        this.energyPoints = MAX_ENERGY;                  // we may assume that the energy is always max. 100
        
        this.skill = null;              // the Pokemon doesn't know any skill yet
        this.type = type;

        
        // Custom attributes
        this.hasFainted = false;
    }

    // *** methods ***

    // getters
    public int getEnergy() {
        return this.energyPoints;
    }

    public int getCurrentHP() {
        return this.currentHP;
    }

    public int getMAX_HP() {
        return this.MAX_HP;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    // Setters
    public void setName(String newName)
    {
        this.name = newName;
    }

    public void learnSkill(String name, int attackPower, int energyCost) 
    {
        this.skill = new PokemonSkill(name, attackPower, energyCost);
    }

    public boolean knowsSkill()
    {
        return(this.skill != null);
    }

    public void forgetSkill()
    {
        this.skill = null;
    }

    public void receiveDamage(int damage) {
        this.currentHP -= damage;

        if (this.currentHP <= 0) 
        {
            this.currentHP = 0;
            if (!this.hasFainted) 
            {
                faint();
            }
        }
    }

    public void rest() {
        if (!hasFainted) {
            this.currentHP += this.HEALTH_RECOVER;
        }

        // if the current HP is greater than the max HP, set it to the max HP
        if (this.currentHP > this.MAX_HP) {
            this.currentHP = this.MAX_HP;
        }
    }

    void faint() {
        this.hasFainted = true;
    }

    void useEnergy(int energyCost) {
        if (this.energyPoints >= energyCost) {
            this.energyPoints -= energyCost;
        }
    }

    public void recoverEnergy() {
        if (!hasFainted) {
            this.energyPoints += this.ENERGY_RECOVER;
        }

        // if the current energy is greater than the max energy, 
        // set it to the max energy

        if (this.energyPoints > this.MAX_ENERGY) {
            this.energyPoints = this.MAX_ENERGY;
        }
    }
    
    /*
     * When using an item, a Pokemon should return the following string indicating
     * the outcome of the healing:
     * 
     * 1: If the pokemon has full HP before using the item:
     * “<poke name> could not use <item name>. HP is already full.”
     * 
     * 2: If the pokemon recovers health when using the item:
     * “<poke name> used <item name>. It healed <amount healed> HP.”
     */
    
    public String useItem(Item item)  // We are assuming that the healingPower of an item always is greater than 0
    {
        // 1st case - the HP is maximum
        if (this.currentHP == this.MAX_HP) 
        {
            return String.format("%s could not use %s. HP is already full.", 
                                this.name, item.getName());
        }

        // 2nd case - the increase will exceed the maximum HP
        else if (this.currentHP + item.getHealingPower() > this.MAX_HP) 
        {
            this.currentHP = this.MAX_HP;

            return String.format("%s used %s. It healed %d HP.", 
                                this.name, item.getName(), this.MAX_HP - item.getHealingPower());
        }

        // 3rd case - the general increase of health
        else 
        {
            // check if the Pokemon has fainted
            if (hasFainted) 
            {
                hasFainted = false;
            }

            this.currentHP += item.getHealingPower();
            return String.format("%s used %s. It healed %d HP.", 
                                this.name, item.getName(), item.getHealingPower());
        }
    }


    /*
     * Attack function
     * 1: If the attacking pokemon is fainted, the message should be:
     * 
     * "Attack failed. <attacker> fainted."
     * 2: If the target pokemon is fainted, the message should be:
     * 
     * "Attack failed. <target> fainted."
     * 3: If the attacking pokemon does not know a skill, the message should be:
     * 
     * "Attack failed. <attacker> does not know a skill."
     * 4: If the attacker knows a skill and has less energy points than the cost of
     * the skill (ec):
     * "Attack failed. <attacker> lacks energy: <ep>/<ec>"
     * 
     * 5: If the attacker has enough EP to use the Skill, then the attack is
     * successful.
     * 
     * The attacking pokemon should return a message that describes the outcome of
     * the attack.
     * 
     */

    private String remainingHP(Pokemon targetPokemon) {
        return String.format("%s%s has %d HP left.",
                END_OF_LINE,
                targetPokemon.getName(),
                targetPokemon.getCurrentHP()
        );
    }

    private String assignFaint(String name) {
        return String.format(" %s faints.", name);
    }
 
    public String attack(Pokemon targetPokemon) {

        // 1. test case
        if (this.skill == null)
        {
            return String.format("Attack failed. %s does not know a skill.", this.name);
        }

        // 2. test case
        else if(this.hasFainted)
        {
            return String.format("Attack failed. %s fainted.", this.name);
        }

        // 3. test case
        else if(targetPokemon.hasFainted)
        {
            return String.format("Attack failed. %s fainted.", targetPokemon.name);
        }

        // 4. test case
        else if(this.energyPoints < this.skill.getEnergyCost())
        {
            return String.format("Attack failed. %s lacks energy: %d/%d",
                                this.name, this.energyPoints, this.skill.getEnergyCost());
        }

        // 5. detect a successful attack

        else
        {
            // TODO: refactor the code functionality below
            // remove redundant code and, make it more readable
            // remove and/or adjust repetitive code

            String attackerType = this.type.toUpperCase();
            String targetType = targetPokemon.getType().toUpperCase();

            String attackMessage = String.format("%s uses %s on %s.", this.name, this.skill.getName(), targetPokemon.getName());        
            
            if (targetType.equals("NORMAL") || attackerType.equals("NORMAL") || attackerType.equals(targetType)) {

                targetPokemon.receiveDamage(this.skill.getAttackPower());
                this.useEnergy(this.skill.getEnergyCost());

                attackMessage += remainingHP(targetPokemon);

                if (targetPokemon.getCurrentHP() <= 0) {
                    attackMessage += assignFaint(targetPokemon.getName());
                }

                return attackMessage;
            }
            
            EffectiveAttack effectiveAttack = EffectiveAttack.valueOf(attackerType);

            if (effectiveAttack.toString().equals(targetType)) 
            {
                attackMessage += " It is super effective!";
                targetPokemon.receiveDamage(this.skill.getAttackPower() * 2);

            } else 
            {
                attackMessage += " It is not very effective...";
                targetPokemon.receiveDamage(this.skill.getAttackPower() / 2);
            }

            this.useEnergy(this.skill.getEnergyCost());

            attackMessage += remainingHP(targetPokemon);

            if (targetPokemon.getCurrentHP() <= 0) 
            {
                attackMessage += assignFaint(targetPokemon.getName());
            }

            return attackMessage;
        }
    }

    /*
    * Compare if two Pokemons are the same:
    * - Two pokemons are equal if they have the same name, type, skill, HP, MAX HP, EP
    */
    
    public boolean equals(Object anotherObject) {
        
        if (anotherObject == null) {
            return false;
        }
        if (anotherObject instanceof Pokemon) {
            Pokemon anotherPokemon = (Pokemon) anotherObject;

            // TODO: fix this ugly formatting; possibly come up with a more feasible approach

            return this.name.equals(anotherPokemon.name) && 
                   this.type.equals(anotherPokemon.type) &&
                   this.currentHP == anotherPokemon.currentHP && 
                   this.MAX_HP == anotherPokemon.MAX_HP && 

                     (this.skill == null && anotherPokemon.skill == null) ||
                     (this.skill != null && this.skill.equals(anotherPokemon.skill)) && // null check for other Pokemon's
                                                                                        // skill ensured in the equals
                                                                                        // method of PokemonSkill
                   this.energyPoints == anotherPokemon.energyPoints;
        }
        
        return false;
    }
    
    /* Print the Pokemon object according to the specifications */

    public String toString()
    {
        if(this.skill == null)
        {
            // If skill is empty
            return String.format("%s (%s)", name, type);
        }
        else
        {
            // If it has learned a skill
            return String.format("%s (%s). Knows %s - AP: %d EC: %d", 
                name, type, skill.getName(), this.skill.getAttackPower(), this.skill.getEnergyCost());
        }
    }
}