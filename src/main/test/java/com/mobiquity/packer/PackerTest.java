package com.mobiquity.packer;

import com.mobiquity.exception.APIException;
import com.mobiquity.util.UTF8FileReader;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

class PackerTest {

    @Test
    void testPack() {
        String inputFilePath = "/Users/setenayronael/Documents/Setenay/workspaces/Backend code assignment - Mobiquity 2021/src/main/test/resources/example_input";
        String outputFilePath = "/Users/setenayronael/Documents/Setenay/workspaces/Backend code assignment - Mobiquity 2021/src/main/test/resources/example_output";

        try {
            String output = UTF8FileReader.readLines(outputFilePath).stream().collect(Collectors.joining("\n")).concat("\n");
            assertEquals(output, Packer.pack(inputFilePath));
        } catch (Exception e) {
            fail(e);
        }
    }

    @Test
    void testPackNoFileFound() {
        try {
            assertThrows(APIException.class, () -> Packer.pack("/tmp/foo.txt"));
        } catch (Exception e) {
            fail(e);
        }
    }

    @Test
    void testPackCapacityOverload() {
        String inputFilePath = "/Users/setenayronael/Documents/Setenay/workspaces/Backend code assignment - Mobiquity 2021/src/main/test/resources/example_input_capacity_overload";

        try {
            Throwable exception = assertThrows(APIException.class, () -> Packer.pack(inputFilePath));
            assertEquals("Package cannot be heavier than 100.00", exception.getMessage());
        } catch (Exception e) {
            fail(e);
        }
    }

    @Test
    void testPackExpensiveItem() {
        String inputFilePath = "/Users/setenayronael/Documents/Setenay/workspaces/Backend code assignment - Mobiquity 2021/src/main/test/resources/example_input_expensive_item";

        try {
            Throwable exception = assertThrows(APIException.class, () -> Packer.pack(inputFilePath));
            assertEquals("Item cannot cost more than €100.00", exception.getMessage());
        } catch (Exception e) {
            fail(e);
        }
    }

    @Test
    void testPackNoItem() {
        String inputFilePath = "/Users/setenayronael/Documents/Setenay/workspaces/Backend code assignment - Mobiquity 2021/src/main/test/resources/example_input_no_item";

        try {
            Throwable exception = assertThrows(APIException.class, () -> Packer.pack(inputFilePath));
            assertEquals("There is no item to pack", exception.getMessage());
        } catch (Exception e) {
            fail(e);
        }
    }

    @Test
    void testPackTooHeavy() {
        String inputFilePath = "/Users/setenayronael/Documents/Setenay/workspaces/Backend code assignment - Mobiquity 2021/src/main/test/resources/example_input_too_heavy";

        try {
            Throwable exception = assertThrows(APIException.class, () -> Packer.pack(inputFilePath));
            assertEquals("Item cannot be heavier than 100.00", exception.getMessage());
        } catch (Exception e) {
            fail(e);
        }
    }

    @Test
    void testPackTooMany() {
        String inputFilePath = "/Users/setenayronael/Documents/Setenay/workspaces/Backend code assignment - Mobiquity 2021/src/main/test/resources/example_input_too_many";

        try {
            Throwable exception = assertThrows(APIException.class, () -> Packer.pack(inputFilePath));
            assertEquals("Item pool is cannot be bigger than 15", exception.getMessage());
        } catch (Exception e) {
            fail(e);
        }
    }

}
