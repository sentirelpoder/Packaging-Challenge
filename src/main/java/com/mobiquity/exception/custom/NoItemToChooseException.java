package com.mobiquity.exception.custom;

import static com.mobiquity.exception.constant.ExceptionMessageConstants.NO_ITEM_TO_CHOOSE;

public class NoItemToChooseException extends Exception {

    public NoItemToChooseException() {
        super(NO_ITEM_TO_CHOOSE);
    }
}
