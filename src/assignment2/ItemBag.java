package assignment2;

import java.util.ArrayList;

public class ItemBag
{
    private final double MAX_WEIGHT;
    private double currentWeight;
    private ArrayList<Item> items;

    public ItemBag(double maxWeight)
    {
        this.MAX_WEIGHT = maxWeight;
        this.items = new ArrayList<Item>();
    }

    /* Getters
     * The bag should provide: the current number of items stored, the current
     * weight of the bag, and its maximum weight. Other operations are defined
     * below.
     */

    public int getNumOfItems() 
    {
        return this.items.size();
    }

    public double getCurrentWeight()
    {
        return this.currentWeight;
    }

    public double getMaxWeight()
    {
        return this.MAX_WEIGHT;
    }

    public int addItem(Item item)
    {
        // add the item

        /*
         * The collection of items can accept repeated items and the items are stored in
         * a specific sequence. When adding an item to the bag, the item must be placed
         * in the index where its weight is higher than the items after them and lighter
         * than those before (i.e., sorted by weight). 
         */

         // If the item we want to insert + the current weight is greater than the max weight permited
         if(this.currentWeight + item.getWeight() > this.MAX_WEIGHT)
         {
            // It's not possible to add the item
            return -1;
         }

         // TODO: replace the algorithm with a more effective approach - binary search

         for (int i = 0; i < this.items.size(); i++) {
            if (item.getWeight() >= this.items.get(i).getWeight()) {
                this.items.add(i, item);
                this.currentWeight += item.getWeight();
                return i;
            }
         }

         // incorrect index
         return -1;
    }

    public String toString() {
        return new String();
    }
}