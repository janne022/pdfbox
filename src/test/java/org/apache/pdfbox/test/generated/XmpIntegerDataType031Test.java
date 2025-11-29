package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class XmpIntegerDataType031Test {
    @Test
    public void testIntegerParsing() {
        String integerString = "123";
        int parsedInteger = Integer.parseInt(integerString);
        Assertions.assertEquals(123, parsedInteger);
    }
    
    @Test
    public void testIntegerValidation() {
        int value = 456;
        Assertions.assertTrue(value > 0);
    }
}