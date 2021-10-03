package com.mobiquity.exception.custom;

import static com.mobiquity.constant.PackageConstants.PROVIDED_ITEM_LIMIT;
import static com.mobiquity.exception.constant.ExceptionMessageConstants.TOO_MANY_ITEMS;

public class TooManyItemsException extends Exception {

    public TooManyItemsException() {
        super(String.format(TOO_MANY_ITEMS, PROVIDED_ITEM_LIMIT));
    }
}
