package com.mobiquity.exception.custom;

import com.mobiquity.exception.APIException;

import static com.mobiquity.constant.PackageConstants.MAX_COST_OF_ITEM;
import static com.mobiquity.constant.ExceptionMessageConstants.EXPENSIVE_ITEM;

public class ExpensiveItemException extends APIException {

    public ExpensiveItemException() {
        super(String.format(EXPENSIVE_ITEM, MAX_COST_OF_ITEM));
    }
}
