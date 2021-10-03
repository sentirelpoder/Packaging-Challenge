package com.mobiquity.exception.custom;

import static com.mobiquity.constant.PackageConstants.PACKAGE_WEIGHT_LIMIT;
import static com.mobiquity.exception.constant.ExceptionMessageConstants.CAPACITY_OVERLOAD;

public class CapacityOverloadException extends Exception {

    public CapacityOverloadException() {
        super(String.format(CAPACITY_OVERLOAD, PACKAGE_WEIGHT_LIMIT));
    }
}
