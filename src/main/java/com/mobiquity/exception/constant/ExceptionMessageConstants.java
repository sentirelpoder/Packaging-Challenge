package com.mobiquity.exception.constant;

public class ExceptionMessageConstants {

    /*To hide the public one*/
    private ExceptionMessageConstants() {}

    public static final String CAPACITY_OVERLOAD = "Package cannot be heavier than %,.2f";
    public static final String EXPENSIVE_ITEM = "Item cannot cost more than €%,.2f";
    public static final String NO_ITEM_TO_CHOOSE = "There is no item to pack";
    public static final String TOO_HEAVY_ITEM = "Item cannot be heavier than %,.2f";
    public static final String TOO_MANY_ITEMS = "Item pool is cannot be bigger than %s";
}
