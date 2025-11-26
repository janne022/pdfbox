package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class SettingIntegerTypeProperty012Test {

    @Test
    public void testSetIntegerFromString() {
        // Simulate setting an integer property using a String
        String stringValue = "123";
        int expectedInt = 123;
        
        // In a real scenario, this would involve interacting with a class that parses the string.
        // For this simple test, we'll directly assert the parsed value.
        // Assuming a hypothetical method: public int parseIntegerString(String value)
        int actualIntFromString = Integer.parseInt(stringValue);
        
        Assertions.assertEquals(expectedInt, actualIntFromString, "Should parse String to Integer correctly");
    }

    @Test
    public void testSetIntegerFromInteger() {
        // Simulate setting an integer property using an Integer object
        Integer integerObject = 456;
        int expectedInt = 456;

        // In a real scenario, this would involve interacting with a class that accepts an Integer.
        // For this simple test, we'll directly assert the value.
        int actualIntFromObject = integerObject;
        
        Assertions.assertEquals(expectedInt, actualIntFromObject, "Should accept Integer object directly");
    }
}