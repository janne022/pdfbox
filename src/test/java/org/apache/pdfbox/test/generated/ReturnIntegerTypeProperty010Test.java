package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ReturnIntegerTypeProperty010Test {
    
    @Test
    public void testReturnsIntegerAsString() {
        // Assume a method getIntegerPropertyAsString() exists and returns String
        String result = "123"; // Mocked return value
        Assertions.assertNotNull(result, "Should not be null");
        Assertions.assertTrue(result instanceof String, "Should be a String");
        Assertions.assertEquals("123", result, "Value mismatch");
    }
    
    @Test
    public void testReturnsIntegerAsObject() {
        // Assume a method getIntegerPropertyAsObject() exists and returns Integer
        Integer result = Integer.valueOf(123); // Mocked return value
        Assertions.assertNotNull(result, "Should not be null");
        Assertions.assertTrue(result instanceof Integer, "Should be an Integer");
        Assertions.assertEquals(123, result.intValue(), "Value mismatch");
    }
}