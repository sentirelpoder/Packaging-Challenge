package com.mobiquity.util;

import com.mobiquity.exception.custom.NoItemToChooseException;

import static com.mobiquity.constant.PackageConstants.PACKAGE_ITEM_SEPARATOR;

public class PackageFileParser {

    /* To hide the public constructor*/
    private PackageFileParser() {
    }

    public static int getMaxWeightOfPackage(String line) {
        return Integer.valueOf(line.substring(0, line.indexOf(PACKAGE_ITEM_SEPARATOR)).trim());
    }

    public static String getItemListPartOfLine(String line) throws NoItemToChooseException {
        int indexOfPackageItemSeparator = line.indexOf(PACKAGE_ITEM_SEPARATOR);
        if (indexOfPackageItemSeparator == -1 || line.length() < line.indexOf(PACKAGE_ITEM_SEPARATOR) + 3)
            throw new NoItemToChooseException();
        return line.substring(line.indexOf(PACKAGE_ITEM_SEPARATOR) + 2);
    }
}
