package com.mobiquity.algorithm;

import com.mobiquity.model.Item;
import com.mobiquity.model.KnapsackResult;

import java.util.*;

public class Knapsack {

    /*To hide public one*/
    private Knapsack() {
    }

    public static KnapsackResult maximizeCostWithWeightLimit(Item[] items, double maxWeight) {
        items = removeItemsMoreThanMaxWeight(items, maxWeight);
        KnapsackResult result = memoizedRecursiveKnapsack(items, maxWeight, items.length);
        Collections.sort(result.getIndexList());
        return result;
    }


    public static Item[] removeItemsMoreThanMaxWeight(Item[] items, double maxWeight) {
        return Arrays.stream(items).filter(item -> item.getWeight() <= maxWeight).sorted().toArray(size -> new Item[size]);
    }

    private static KnapsackResult memoizedRecursiveKnapsack(Item[] itemList, double maxWeight, int notVisitedSize) {
        return memoizedRecursiveKnapsack(itemList, maxWeight, notVisitedSize, new HashMap<>());
    }

    /*In the example input there is no recurring maxWeight and size through the recursion, however it is possible for some other input */
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


