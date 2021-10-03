package com.mobiquity.constant;

public class PackageConstants {

    /* To hide the public constructor*/
    private PackageConstants() {
    }

    /**
     * ASSIGNMENT SHEET:
     * 1. Max weight that a package can take is ≤ 100
     * 2. There might be up to 15 items you need to choose from
     * 3. Max weight and cost of an item is ≤ 100
     */

    public static final double PACKAGE_WEIGHT_LIMIT = 100;
    public static final int PROVIDED_ITEM_LIMIT = 15;
    public static final double MAX_WEIGHT_OF_ITEM = 100;
    public static final double MAX_COST_OF_ITEM = 100;

    public static final String PACKAGE_ITEM_SEPARATOR = ":";
    public static final String ITEM_SEPARATOR = " ";
    public static final String ITEM_DATA_SEPARATOR = ",";
    public static final String NEW_LINE = "\n";
    public static final String NO_ITEM = "-";

}
