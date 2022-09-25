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

    /*
    * Two items are equals if they have the same
    * Name, Healing Power and Weight.
    */

    public boolean equals(Object anotherObject) {
        if (anotherObject == null) {
            return false;
        }

        if (anotherObject instanceof Item) {
            Item anotherItem = (Item) anotherObject;

            return this.name.equals(anotherItem.name) &&
                   this.healingPower == anotherItem.healingPower &&
                   this.weight == anotherItem.weight;
        }

        return false;
    }

    public String toString() {
        // TODO: revisit the truncation method ?
        double truncatedWeight = Math.floor(this.weight * 100) / 100;
        return String.format("%s heals %d HP. (%.2f)", this.name, this.healingPower, truncatedWeight);
    }
    
    public int getHealingPower()
    {
        return this.healingPower;
    }

    public String getName()
    {
        return this.name;
    }

    public double getWeight()
    {
        return this.weight;
    }
}