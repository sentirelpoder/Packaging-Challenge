package com.mobiquity.exception.custom;

import com.mobiquity.exception.APIException;

import static com.mobiquity.constant.ExceptionMessageConstants.INCORRECT_INPUT_PATTERN;

public class IncorrectInputPattern extends APIException {

    public IncorrectInputPattern() {
        super(INCORRECT_INPUT_PATTERN);
    }
}
