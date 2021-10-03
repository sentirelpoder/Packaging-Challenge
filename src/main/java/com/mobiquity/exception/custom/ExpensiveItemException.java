package com.mobiquity.exception.custom;

import static com.mobiquity.constant.PackageConstants.MAX_COST_OF_ITEM;
import static com.mobiquity.exception.constant.ExceptionMessageConstants.EXPENSIVE_ITEM;

public class ExpensiveItemException extends Exception {

    public ExpensiveItemException() {
        super(String.format(EXPENSIVE_ITEM, MAX_COST_OF_ITEM));
    }
}
