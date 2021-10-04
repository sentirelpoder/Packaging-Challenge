package com.mobiquity.exception.custom;

import com.mobiquity.exception.APIException;

import static com.mobiquity.constant.ExceptionMessageConstants.NO_ITEM_TO_CHOOSE;

public class NoItemToChooseException extends APIException {

    public NoItemToChooseException() {
        super(NO_ITEM_TO_CHOOSE);
    }
}
