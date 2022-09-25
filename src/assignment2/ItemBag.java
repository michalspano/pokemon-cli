package assignment2;

import java.util.ArrayList;

public class ItemBag
{   
    private final double MAX_WEIGHT;
    private double currentWeight;

    /* Analysis:
     * In order to implement the functionality of the ItemBag, we use the data structure
     * 'ArrayList', i.e., a type of dynamic list. s*/

    private ArrayList<Item> items;

    // constructor

    public ItemBag(double maxWeight)
    {
        this.MAX_WEIGHT = maxWeight;
        this.items = new ArrayList<Item>();
    }
    
    /** 
     * @return int
     */
    public int getNumOfItems() 
    {
        return this.items.size();
    }
    
    /** 
     * @return double
     */
    public double getCurrentWeight()
    {
        return this.currentWeight;
    }
    
    /** 
     * @return double
     */
    public double getMaxWeight()
    {
        return this.MAX_WEIGHT;
    }
    
    /** 
     * @param item
     * @return int
     */
    public int addItem(Item item)
    {
        /*
         * The collection of items can accept repeated items and the items are stored in
         * a specific sequence. When adding an item to the bag, the item must be placed
         * in the index where its weight is higher than the items after them and lighter
         * than those before (i.e., sorted by weight). 
         */

         // If the item we want to insert + the current weight is greater than the max weight permitted
         if(this.currentWeight + item.getWeight() > this.MAX_WEIGHT)
         {
            // It's not possible to add the item
            return -1;
         }

         // we assume that the items are sorted by the weight; from the heaviest to the lightest
         // hence, we may implement the binary search to obtain the valid index to insert to

         // TODO: refactor the use of the algorithm
         // e.g., separate method, etc.

         int low = 0;
         int high = this.items.size() - 1;

         int addIndexAt = 0;

         while (low <= high) {
            int mid = (low + high) / 2;

            // if the weight is the same as the middle weight
            if (items.get(mid).getWeight() == item.getWeight()) {
                addIndexAt = mid;
                break;

            } else if (item.getWeight() > items.get(mid).getWeight()) {
                high = mid -1;
                addIndexAt = mid;

            } else {
                low = mid + 1;
                addIndexAt = mid + 1;
            }
        }

        this.items.add(addIndexAt, item);
        this.currentWeight += item.getWeight();

        return addIndexAt;
    }

    
    /** 
     * @param index
     * @return String
     */
    public String peekItemAt(int index)
    {
        if (index >= this.items.size() || index < 0) 
        {
            return new String();
        }

        Item currentItem = this.items.get(index);
        double truncatedWeight = Math.floor(currentItem.getWeight() * 100) / 100;

        return String.format("%s heals %d HP. (%.2f)",
                        currentItem.getName(), currentItem.getHealingPower(), truncatedWeight);
    }

    
    /** 
     * @param index
     * @return Item
     */
    public Item removeItemAt(int index) {
        // TODO: implement proper functionality
        return new Item("foo", 1, 1.0);
    }

    /** 
     * @return Item
     */
    public Item popItem() {
        // TODO: implement proper functionality
        return new Item("bar", 1, 1.0);
    }
    
    /** 
     * @return String
     */
    public String toString() {
        return new String();
    }
}