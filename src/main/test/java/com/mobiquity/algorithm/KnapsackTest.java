package com.mobiquity.algorithm;

import com.mobiquity.model.KnapsackResult;
import com.mobiquity.model.Item;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.mobiquity.algorithm.Knapsack.*;
import static org.junit.jupiter.api.Assertions.*;

class KnapsackTest {

    /**
     * 81 : (1,53.38,€45) (2,88.62,€98) (3,78.48,€3) (4,72.30,€76) (5,30.18,€9) (6,46.34,€48)
     */
    @Test
    void testRecursiveKnapsackWithSixItem() {
        int maxWeight = 81;
        Item[] items = new Item[6];
        items[0] = new Item(1, 53.38, 45);
        items[1] = new Item(2, 88.62, 98);
        items[2] = new Item(3, 78.48, 3);
        items[3] = new Item(4, 72.30, 76);
        items[4] = new Item(5, 30.18, 9);
        items[5] = new Item(6, 46.34, 48);
        double maxCost = 76;
        double weight = 72.3;
        List<Short> indexList = Arrays.asList((short) 4);
        KnapsackResult result = maximizeCostWithWeightLimit(items, maxWeight);
        assertAll(() -> assertEquals(maxCost, result.getCost())
                , () -> assertIterableEquals(indexList, result.getIndexList())
                , () -> assertEquals(weight, result.getWeight()));

    }

    /**
     * 8 : (1,15.3,€34)
     */
    @Test
    void testRecursiveKnapsackWithOneItem() {
        int maxWeight = 8;
        Item[] items = new Item[1];
        items[0] = new Item(1, 15.3, 34);
        int maxCost = 0;
        int weight = 0;
        List<Short> indexList = Arrays.asList();
        KnapsackResult result = maximizeCostWithWeightLimit(items, maxWeight);
        assertAll(() -> assertEquals(maxCost, result.getCost())
                , () -> assertIterableEquals(indexList, result.getIndexList())
                , () -> assertEquals(weight, result.getWeight()));
    }

    /**
     * 75 : (1,85.31,€29) (2,14.55,€74) (3,3.98,€16) (4,26.24,€55) (5,63.69,€52) (6,76.25,€75) (7,60.02,€74) (8,93.18,€35) (9,89.95,€78)
     */
    @Test
    void testRecursiveKnapsackWithNineItem() {
        int maxWeight = 75;
        Item[] items = new Item[9];
        items[0] = new Item(1, 85.31, 29);
        items[1] = new Item(2, 14.55, 74);
        items[2] = new Item(3, 3.98, 16);
        items[3] = new Item(4, 26.24, 55);
        items[4] = new Item(5, 63.69, 52);
        items[5] = new Item(6, 76.25, 75);
        items[6] = new Item(7, 60.02, 74);
        items[7] = new Item(8, 93.18, 35);
        items[8] = new Item(9, 89.95, 78);
        double maxCost = 74 + 74;
        double weight = 14.55 + 60.02;
        List<Short> indexList = Arrays.asList((short) 2, (short) 7);
        KnapsackResult result = maximizeCostWithWeightLimit(items, maxWeight);
        assertAll(() -> assertEquals(maxCost, result.getCost())
                , () -> assertIterableEquals(indexList, result.getIndexList())
                , () -> assertEquals(weight, result.getWeight()));
    }


    /**
     * 56 : (1,90.72,€13) (2,33.80,€40) (3,43.15,€10) (4,37.97,€16) (5,46.81,€36) (6,48.77,€79) (7,81.80,€45) (8,19.36,€79) (9,6.76,€64)
     */
    @Test
    void testRecursiveKnapsackWithNineItemWithRepeatingCost() {
        int maxWeight = 56;
        Item[] items = new Item[9];
        items[0] = new Item(1, 90.72, 13);
        items[1] = new Item(2, 33.80, 40);
        items[2] = new Item(3, 43.15, 10);
        items[3] = new Item(4, 37.97, 16);
        items[4] = new Item(5, 46.81, 36);
        items[5] = new Item(6, 48.77, 79);
        items[6] = new Item(7, 81.80, 45);
        items[7] = new Item(8, 19.36, 79);
        items[8] = new Item(9, 6.76, 64);
        double maxCost = 79 + 64;
        double weight = 19.36 + 6.76;
        List<Short> indexList = Arrays.asList((short) 8, (short) 9);
        KnapsackResult result = maximizeCostWithWeightLimit(items, maxWeight);
        assertAll(() -> assertEquals(maxCost, result.getCost())
                , () -> assertEquals(indexList, result.getIndexList())
                , () -> assertEquals(weight, result.getWeight()));
    }

}

