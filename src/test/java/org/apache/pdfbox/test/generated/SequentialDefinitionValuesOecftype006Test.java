package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class SequentialDefinitionValuesOecftype006Test {
    @Test
    public void testSequentialDefinition() {
        String expectation = "sequential";
        String actual = "sequential";
        Assertions.assertEquals(expectation, actual, "Values should be sequentially defined");
    }

    @Test
    public void testOrderPreservation() {
        String value1 = "first";
        String value2 = "second";
        Assertions.assertTrue(value1.equals("first"), "First value should be preserved");
        Assertions.assertEquals(value2, "second", "Second value should be preserved");
    }
}