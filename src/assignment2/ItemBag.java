/***************************************************************************************************
 * Group Work Assignment 2 - A2-Group 29
 * File: ItemBag.java
 * Members: Ionel Pop, Joel Mattsson, Michal Spano
 * For DIT043: Object Oriented Programming; SEM@GU.
 ***************************************************************************************************/

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
    
    /** This method uses Binary search to find the index of the item in the list.
     * Therefore, the time complexity is O(log(n)), hence being more efficient than
     * a standard linear search.
     * @param item
     * @return int
     */
    private int getIndexFrom(Item item)
    {
        /* low, high represent the indices of the first and the last elements in the list;
         * this is the initial state of the binary search algorithm. */

        int low = 0; 
        int high = this.items.size() - 1;

        int foundIndex = 0;
        boolean foundItem = false; // this is the flag that indicates if the item was found or not.

        while (low <= high && !foundItem) 
        {
            int mid = (low + high) / 2; 
            
            // if the middle element is the item we are looking for
            if (items.get(mid).getWeight() == item.getWeight()) 
            {
                foundIndex = mid;
                foundItem = true;
            } 

            /* if the item is greater (in weight) than the middle item; 
             * in the else-if and else statements, we partition the list 
             * per the binary search algorithm */

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
        /* The collection of items can accept repeated items and the items are stored in
         * a specific sequence. When adding an item to the bag, the item must be placed
         * in the index where its weight is higher than the items after them and lighter
         * than those before (i.e., sorted by weight). */

         // If the item we want to insert + the current weight is greater than the max weight permitted
         if (this.currentWeight + item.getWeight() > this.MAX_WEIGHT)
         {
            // It's not possible to add the item
            return -1;
         }

        // add the item to the list, increase the weight and return the index
        int addIndexAt = getIndexFrom(item);
        this.items.add(addIndexAt, item);
        
        adjustCurrentWeight(true, item.getWeight());

        return addIndexAt;
    }
    
    /** In this method, we get the name, HP and the (truncated) weight of the corresponding item
     * and then return the formatted string. Check for valid index before the accessing the item.
     * @param index
     * @return String
     */
    public String peekItemAt(int index)
    {
        if (!PokemonUtils.isWithinBounds(index, 0, this.items.size() - 1))
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
        if (!PokemonUtils.isWithinBounds(index, 0, items.size() - 1)) 
        {
            return null;
        }

        /* we store the removed item in a variable, this is mainly to increase readability,
         * we could have just returned the item directly, but this way it's easier to understand */

        Item removedItem = this.items.get(index);           

        this.items.remove(index);
        adjustCurrentWeight(false, removedItem.getWeight()); 

        return removedItem;                                 
    }

    /** In this method, we remove the first index of the items list, if the list is not empty,
     * otherwise, we return null
     * @return Item
     */
    public Item popItem()
    {
        if (this.items.size() == 0) 
        {
            return null;
        }

        /* we store the removed item in a variable, this is mainly to increase readability
         * we could have just returned the item directly, but this way it's easier to understand */

        Item removedItem = this.items.get(0);            

        this.items.remove(0);                           
        adjustCurrentWeight(false, removedItem.getWeight());           

        return removedItem;                                     
    }
}