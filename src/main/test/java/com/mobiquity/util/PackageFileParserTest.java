package com.mobiquity.util;

import com.mobiquity.exception.custom.NoItemToChooseException;
import org.junit.jupiter.api.Test;

import static com.mobiquity.util.PackageFileParser.getItemListPartOfLine;
import static com.mobiquity.util.PackageFileParser.getMaxWeightOfPackage;
import static org.junit.jupiter.api.Assertions.*;

class PackageFileParserTest {

    @Test
    void testGetItemListPartOfLineSixItem() {
        String line = "81 : (1,53.38,€45) (2,88.62,€98) (3,78.48,€3) (4,72.30,€76) (5,30.18,€9) (6,46.34,€48)";
        String output = "(1,53.38,€45) (2,88.62,€98) (3,78.48,€3) (4,72.30,€76) (5,30.18,€9) (6,46.34,€48)";
        double maxWeight = 81;
        try {
            assertEquals(maxWeight, getMaxWeightOfPackage(line));
            assertEquals(output, getItemListPartOfLine(line));
        } catch (Exception e) {
            fail(e);
        }

    }

    @Test
    void testGetItemListPartOfLineOneItem() {
        String line = "8 : (1,15.3,€34)";
        String output = "(1,15.3,€34)";
        double maxWeight = 8;
        try {
            assertEquals(maxWeight, getMaxWeightOfPackage(line));
            assertEquals(output, getItemListPartOfLine(line));
        } catch (Exception e) {
            fail(e);
        }
    }

    @Test
    void testGetItemListPartOfLineNineItem() {
        String line = "75 : (1,85.31,€29) (2,14.55,€74) (3,3.98,€16) (4,26.24,€55) (5,63.69,€52) (6,76.25,€75) (7,60.02,€74) (8,93.18,€35) (9,89.95,€78)";
        String output = "(1,85.31,€29) (2,14.55,€74) (3,3.98,€16) (4,26.24,€55) (5,63.69,€52) (6,76.25,€75) (7,60.02,€74) (8,93.18,€35) (9,89.95,€78)";
        double maxWeight = 75;
        try {
            assertEquals(maxWeight, getMaxWeightOfPackage(line));
            assertEquals(output, getItemListPartOfLine(line));
        } catch (Exception e) {
            fail(e);
        }
    }

    @Test
    void testGetItemListPartOfLineNineItemWithRepeatingCost() {
        String line = "56 : (1,90.72,€13) (2,33.80,€40) (3,43.15,€10) (4,37.97,€16) (5,46.81,€36) (6,48.77,€79) (7,81.80,€45) (8,19.36,€79) (9,6.76,€64)";
        String output = "(1,90.72,€13) (2,33.80,€40) (3,43.15,€10) (4,37.97,€16) (5,46.81,€36) (6,48.77,€79) (7,81.80,€45) (8,19.36,€79) (9,6.76,€64)";
        double maxWeight = 56;
        try {
            assertEquals(maxWeight, getMaxWeightOfPackage(line));
            assertEquals(output, getItemListPartOfLine(line));
        } catch (Exception e) {
            fail(e);
        }
    }

    @Test
    void testNoItemToChooseWithOnlyMaxWeight() {
        String line = "56";
        try {
            assertThrows(NoItemToChooseException.class, () -> getItemListPartOfLine(line));
        } catch (Exception e) {
            fail(e);
        }
    }

    @Test
    void testNoItemToChooseWithMaxWeightAndSemicolon() {
        String line = "56 :";
        try {
            assertThrows(NoItemToChooseException.class, () -> getItemListPartOfLine(line));
        } catch (Exception e) {
            fail(e);
        }
    }

    @Test
    void testNoItemToChooseChooseWithMaxWeightAndSemicolonWithSpace() {
        String line = "56 : ";
        try {
            assertThrows(NoItemToChooseException.class, () -> getItemListPartOfLine(line));
        } catch (Exception e) {
            fail(e);
        }
    }
}

