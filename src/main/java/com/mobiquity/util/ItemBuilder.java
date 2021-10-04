package com.mobiquity.util;

import com.mobiquity.constant.PackageConstants;
import com.mobiquity.model.Item;

public class ItemBuilder {

    /* To hide the public constructor*/
    private ItemBuilder() {
    }

    /**
     * Find items by separating data with space, and it removes ( and ), then it splits the remaining with ,
     * we assume that input has the format validated in packerInput constructor
     * e.g.
     * (1,2,3) (2,3,4)
     * then we have Item{1,2,3} and Item{2,3,4} as an array
     * @param itemLineOnFile
     * @return item array
     */
    public static Item[] buildItems(String itemLineOnFile) {
        String[] items = itemLineOnFile.split(PackageConstants.ITEM_SEPARATOR);
        Item[] itemList = new Item[items.length];

        String[] fields;
        Item currentItem;
        int i = 0;
        for (String item : items) {
            fields = item.substring(1, item.length() - 1).split(PackageConstants.ITEM_DATA_SEPARATOR);
            currentItem = new Item(Integer.parseInt(fields[0]), Double.parseDouble(fields[1]), Double.parseDouble(fields[2].substring(1)));
            itemList[i++] = currentItem;
        }

        return itemList;
    }

}
