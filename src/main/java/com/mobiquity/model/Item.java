package com.mobiquity.model;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Item implements Comparable<Item> {

    /**
     * ASSIGNMENT SHEET:
     * Each thing you put inside the package has such parameters as index number, weight and cost.
     */

    /* There are maximum 15 packages in a line short is enough*/
    private short index;
    private double weight;
    /* The cost is integer in the examples, however there is no info about in the assignment sheet.
     * I'm going to assume that its like real life costs, so I'm using double*/
    private double cost;

    public Item(int index, double weight, double cost) {
        this.index = (short) index;
        this.weight = weight;
        this.cost = cost;
    }

    /**
     * If Cost/Value is bigger, than we have this item in the beginning of array
     */
    @Override
    public int compareTo(Item itemB) {
        double rateA = cost / weight;
        double rateB = itemB.getCost() / itemB.getWeight();
        if (rateA > rateB) return -1;
        if (rateB > rateA) return 1;
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return index == item.index && Double.compare(item.weight, weight) == 0 && Double.compare(item.cost, cost) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, weight, cost);
    }
}
