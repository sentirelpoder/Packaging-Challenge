package com.mobiquity.exception.custom;

import com.mobiquity.exception.APIException;

import static com.mobiquity.constant.PackageConstants.PACKAGE_WEIGHT_LIMIT;
import static com.mobiquity.constant.ExceptionMessageConstants.CAPACITY_OVERLOAD;

public class CapacityOverloadException extends APIException {

    public CapacityOverloadException() {
        super(String.format(CAPACITY_OVERLOAD, PACKAGE_WEIGHT_LIMIT));
    }
}
