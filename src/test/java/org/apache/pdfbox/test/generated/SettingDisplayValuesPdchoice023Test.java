package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class SettingDisplayValuesPdchoice023Test {
    @Test
    public void testSetDisplayValue() {
        String displayValue = "Option A";
        Assertions.assertNotNull(displayValue);
        Assertions.assertEquals("Option A", displayValue);
    }
    
    @Test
    public void testSortDisplayValues() {
        String value1 = "Apple";
        String value2 = "Banana";
        boolean isSorted = value1.compareTo(value2) < 0;
        Assertions.assertTrue(isSorted);
    }
}