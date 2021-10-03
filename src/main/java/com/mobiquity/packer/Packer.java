package com.mobiquity.packer;

import com.mobiquity.algorithm.model.KnapsackResult;
import com.mobiquity.exception.APIException;
import com.mobiquity.model.PackerInput;
import com.mobiquity.util.UTF8FileReader;

import java.util.List;
import java.util.stream.Collectors;

import static com.mobiquity.algorithm.Knapsack.maximizeCostWithWeightLimit;
import static com.mobiquity.constant.PackageConstants.*;

public class Packer {


    private Packer() {
    }


    /**
     * ASSIGNMENT SHEET:
     * Your API should accept as its first argument a path to a filename. The input file contains several lines. Each line is one test case.
     * <p>*
     *
     * @param filePath absolute path of file
     * @return index list of used items as String
     * @throws APIException
     */
    public static String pack(String filePath) throws APIException {

        StringBuilder indexOfPackedItems = new StringBuilder();
        try {
            /**
             * file is UTF-8 format
             */
            List<String> lines = UTF8FileReader.readLines(filePath);
            PackerInput currentInput;
            KnapsackResult knapsackResult;

            //iterate over lines
            for (String line : lines) {
                currentInput = new PackerInput(line);
                knapsackResult = maximizeCostWithWeightLimit(currentInput.getItems(), currentInput.getMaxWeight());
                addNewKnapsackResult(indexOfPackedItems, knapsackResult);
            }
        } catch (Exception exception) {
            throw new APIException(exception.getMessage(), exception);
        }

        return indexOfPackedItems.toString();
    }

    private static void addNewKnapsackResult(StringBuilder indexOfPackedItems, KnapsackResult result) {
        String newLine = !result.getIndexList().isEmpty() ? result.getIndexList().stream().map(String::valueOf).collect(Collectors.joining(ITEM_DATA_SEPARATOR)) : NO_ITEM;
        indexOfPackedItems.append(newLine);
        indexOfPackedItems.append(NEW_LINE);
    }
}
