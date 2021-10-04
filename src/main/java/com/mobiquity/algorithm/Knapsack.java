package com.mobiquity.algorithm;

import com.mobiquity.model.Item;
import com.mobiquity.model.KnapsackResult;

import java.util.*;

public class Knapsack {

    /**
     * This is a constructor to hide public one
     */
    private Knapsack() {
    }

    /**
     * Knapsack algorithm with sorting items according to cost/value
     * @param items
     * @param maxWeight
     * @return Calculated weight, cost and item list
     */
    public static KnapsackResult maximizeCostWithWeightLimit(Item[] items, double maxWeight) {
        items = removeItemsMoreThanMaxWeight(items, maxWeight);
        KnapsackResult result = memoizedRecursiveKnapsack(items, maxWeight, items.length);
        Collections.sort(result.getIndexList());
        return result;
    }

    /**
     * Removes items that too heavy to be packed, according to pack weight limit
     * @param items
     * @param maxWeight
     * @return Sorted item list
     */
    private static Item[] removeItemsMoreThanMaxWeight(Item[] items, double maxWeight) {
        return Arrays.stream(items).filter(item -> item.getWeight() <= maxWeight).sorted().toArray(size -> new Item[size]);
    }

    /**
     * Knapsack algorithm with memoized results
     * @param itemList
     * @param maxWeight
     * @param notVisitedSize
     * @return Calculated weight, cost and item list
     */
    private static KnapsackResult memoizedRecursiveKnapsack(Item[] itemList, double maxWeight, int notVisitedSize) {
        return memoizedRecursiveKnapsack(itemList, maxWeight, notVisitedSize, new HashMap<>());
    }

    /**
     * Knapsack algorithm with memoized results
     * In the example input there is no recurring maxWeight and size through the recursion, however it is possible for some other input
     * Other solutions without recursion requires integer weight, therefore this algorithm is selected.
     * @param itemList
     * @param maxWeight
     * @param notVisitedSize
     * @return Calculated weight, cost and item list
     */
    private static KnapsackResult memoizedRecursiveKnapsack(Item[] itemList, double maxWeight, int notVisitedSize, Map<String, KnapsackResult> calculatedData) {
        //No item or no storage
        KnapsackResult result;
        if (notVisitedSize == 0 || maxWeight == 0)
            return KnapsackResult.builder().indexList(new ArrayList<>()).weight(0).cost(0).build();

        String currentKey = "knapsack(" + maxWeight + "," + notVisitedSize + ")";
        if (calculatedData.containsKey(currentKey))
            return calculatedData.get(currentKey);

        Item lastItem = itemList[--notVisitedSize];

        //Eliminate if the weight of the last item is bigger than maxWeight
        if (lastItem.getWeight() > maxWeight) {
            result = memoizedRecursiveKnapsack(itemList, maxWeight, notVisitedSize, calculatedData);
        } else {
            //find out whether the sum of the cost of current item and the cost of the knapsack of remaining item with remaining weight
            //or the cost of the knapsack of remaining item with maxWeight
            // is bigger
            double remainingWeight = maxWeight - lastItem.getWeight();
            KnapsackResult resultA = memoizedRecursiveKnapsack(itemList, remainingWeight, notVisitedSize, calculatedData);
            resultA.addCurrentItemToPrevResult(itemList[notVisitedSize]);
            KnapsackResult resultB = memoizedRecursiveKnapsack(itemList, maxWeight, notVisitedSize, calculatedData);
            result = resultA.getCost() > resultB.getCost() ? resultA : resultB;
        }
        calculatedData.put(currentKey, result);
        return result;
    }

}


