package com.mobiquity.algorithm.model;

import com.mobiquity.model.Item;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class KnapsackResult {
    private List<Short> indexList;
    private double weight;
    private double cost;

    public void addCurrentItemToPrevResult(Item item) {
        this.addWeight(item.getWeight());
        this.addCost(item.getCost());
        this.getIndexList().add(item.getIndex());
    }

    private void addWeight(double weight) {
        this.weight += weight;
    }

    private void addCost(double cost) {
        this.cost += cost;
    }
}