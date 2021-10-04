package com.mobiquity.exception.custom;

import com.mobiquity.exception.APIException;

import static com.mobiquity.constant.PackageConstants.PROVIDED_ITEM_LIMIT;
import static com.mobiquity.constant.ExceptionMessageConstants.TOO_MANY_ITEMS;

public class TooManyItemsException extends APIException {

    public TooManyItemsException() {
        super(String.format(TOO_MANY_ITEMS, PROVIDED_ITEM_LIMIT));
    }
}
