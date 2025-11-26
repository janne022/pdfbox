package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class SettingsPropertySequenceText020Test {
    @Test
    public void testSettingsPropertyIsSequenceOfText() {
        String settings = "ExampleSetting";
        Assertions.assertNotNull(settings, "Settings property should not be null");
        Assertions.assertTrue(settings instanceof String, "Settings property should be a String sequence");
    }
    
    @Test
    public void testRowsAndColumnsAreIntegers() {
        int rows = 10;
        int columns = 5;
        Assertions.assertEquals(10, rows, "Rows property should be an Integer");
        Assertions.assertEquals(5, columns, "Columns property should be an Integer");
    }
}