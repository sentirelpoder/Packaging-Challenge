package com.mobiquity.model;

import com.mobiquity.exception.APIException;
import com.mobiquity.exception.custom.*;
import lombok.Data;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.mobiquity.util.ItemBuilder.buildItems;
import static com.mobiquity.constant.PackageConstants.*;
import static com.mobiquity.util.PackageFileParser.getItemListPartOfLine;
import static com.mobiquity.util.PackageFileParser.getMaxWeightOfPackage;

@Data
public class PackerInput {

    private Item[] items;
    private int maxWeight;

    /**
     * While constructing items from the line, assumed that input will always same as the example_input, with same space counts and currency
     * <max_weight> : (<index>,<weight>,£<cost>) (<index>,<weight>,€<cost>)
     */
    public PackerInput(String line) throws APIException {
        validateInputPattern(line);
        this.maxWeight = getMaxWeightOfPackage(line);
        String currentItemsListOnFile = getItemListPartOfLine(line);
        items = buildItems(currentItemsListOnFile);
        validate();
    }

    /**
     * While constructing items from the line, assumed that input will always same as the example_input, with same space counts and currency
     * <max_weight> : (<index>,<weight>,£<cost>) (<index>,<weight>,€<cost>)
     * <max_weight> :
     * <max_weight>
     */
    private void validateInputPattern(String line) throws IncorrectInputPattern {
        Pattern pattern = Pattern.compile(INPUT_PATTERN);
        Matcher matcher = pattern.matcher(line);
        if (!matcher.matches())
            throw new IncorrectInputPattern();
    }

    public void validate() throws CapacityOverloadException, TooManyItemsException, ExpensiveItemException, TooHeavyItemException {
        validateMaxWeight();
        validateItems();
    }

    private void validateMaxWeight() throws CapacityOverloadException {
        if (maxWeight > PACKAGE_WEIGHT_LIMIT)
            throw new CapacityOverloadException();
    }

    private void validateItems() throws TooHeavyItemException, TooManyItemsException, ExpensiveItemException {
        if (this.items.length > PROVIDED_ITEM_LIMIT)
            throw new TooManyItemsException();
        if (getMaxCostOfItems() > MAX_COST_OF_ITEM)
            throw new ExpensiveItemException();
        if (getMaxWeightOfItems() > MAX_WEIGHT_OF_ITEM)
            throw new TooHeavyItemException();
    }

    private double getMaxCostOfItems() {
        Optional<Item> maxCostItem = Arrays.stream(items).max(Comparator.comparing(Item::getCost));
        return maxCostItem.orElse(new Item(0, 0, 0)).getCost();
    }

    private double getMaxWeightOfItems() {
        Optional<Item> maxWeightItem = Arrays.stream(items).max(Comparator.comparing(Item::getWeight));
        return maxWeightItem.orElse(new Item(0, 0, 0)).getWeight();
    }
}
