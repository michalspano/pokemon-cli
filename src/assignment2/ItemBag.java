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
     * @param toIncrease
     * @param weight
     */
    private void adjustCurrentWeight(boolean toIncrease, double weight) 
    {
        if (toIncrease) 
            this.currentWeight += weight;
        else 
            this.currentWeight -= weight;
    } 
    
    /** 
     * @param item
     * @return int
     */
    private int binarySearch(Item item) 
    {
        int low = 0; 
        int high = this.items.size() - 1;

        int foundIndex = 0;

        while (low <= high) 
        {
            int mid = (low + high) / 2;

            if (items.get(mid).getWeight() == item.getWeight()) 
            {
                foundIndex = mid;
                break;

            } 
            else if (item.getWeight() > items.get(mid).getWeight()) 
            {
                high = mid -1;
                foundIndex = mid;

            } else {
                low = mid + 1;
                foundIndex = mid + 1;
            }
        }

        return foundIndex;
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

        int addIndexAt = binarySearch(item);
        this.items.add(addIndexAt, item);
        
        adjustCurrentWeight(true, item.getWeight());

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
        double truncatedWeight = PokemonUtils.truncateDouble(currentItem.getWeight(), 2);

        return String.format("%s heals %d HP. (%.2f)",
                        currentItem.getName(), currentItem.getHealingPower(), truncatedWeight);
    }
    
    /** 
     * @param index
     * @return Item
     */
    public Item removeItemAt(int index) {
        if (index >= items.size() || index < 0)
        {
            return null;
        }

        Item removedItem = this.items.get(index);           

        this.items.remove(index);
        adjustCurrentWeight(false, removedItem.getWeight()); 

        return removedItem;                                 
    }

    /** 
     * @return Item
     */
    public Item popItem()
    {
        if (this.items.size() == 0) 
        {
            return null;
        }

        Item removedItem = this.items.get(0);            

        this.items.remove(0);                           
        adjustCurrentWeight(false, removedItem.getWeight());           

        return removedItem;                                     
    }
}