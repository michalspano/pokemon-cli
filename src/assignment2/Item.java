package assignment2;

public class Item
{
    private final String name;
    private final int healingPower;
    private final double weight;

    public Item(String name, int healingPower, double weight)
    {
        this.name = name;
        this.healingPower = healingPower;
        this.weight = weight;
    }

    // *** getters ***
    
    /**
     * @return int
     */
    public int getHealingPower() {
        return this.healingPower;
    }

    /**
     * @return String
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return double
     */
    public double getWeight() {
        return this.weight;
    }
    
    /*
    * Two items are equals if they have the same
    * Name, Healing Power and Weight.
    */
    
    /** 
     * @param anotherObject
     * @return boolean
     */

    public boolean equals(Object anotherObject) {
        if (anotherObject == null) {
            return false;
        }

        if (anotherObject instanceof Item) {
            Item anotherItem = (Item) anotherObject;

            boolean checkName = this.name.equals(anotherItem.name);
            boolean checkHealingPower = this.healingPower == anotherItem.healingPower;
            boolean checkWeight = this.weight == anotherItem.weight;

            return checkName && checkHealingPower && checkWeight; 
        }

        return false;
    }

    
    /** 
     * @return String
     */
    public String toString() {

        // TODO: revisit the truncation method ?

        double truncatedWeight = Math.floor(this.weight * 100) / 100;
        return String.format("%s heals %d HP. (%.2f)", this.name, this.healingPower, truncatedWeight);
    }
}