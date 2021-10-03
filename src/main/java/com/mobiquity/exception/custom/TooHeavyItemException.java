package com.mobiquity.exception.custom;

import static com.mobiquity.constant.PackageConstants.MAX_WEIGHT_OF_ITEM;
import static com.mobiquity.exception.constant.ExceptionMessageConstants.TOO_HEAVY_ITEM;

public class TooHeavyItemException extends Exception {

    public TooHeavyItemException() {
        super(String.format(TOO_HEAVY_ITEM, MAX_WEIGHT_OF_ITEM));
    }
}
