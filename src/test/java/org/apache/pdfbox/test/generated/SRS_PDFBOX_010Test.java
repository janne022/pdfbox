package org.apache.pdfbox.test.generated;

import org.apache.pdfbox.pdmodel.common.PDInteger;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Requirement SRS-PDFBOX-010.
 * This class verifies that an Integer type property value is returned as both a String and an Integer object.
 */
public class SRS_PDFBOX_010Test {

    /**
     * Tests returning a positive integer value as a String and as an Integer object.
     */
    @Test
    public void testPositiveIntegerValue() {
        int expectedIntValue = 123;
        String expectedStringValue = "123";

        PDInteger pdInteger = new PDInteger(expectedIntValue);

        // Test returning as String
        String actualStringValue = pdInteger.createInstance(Integer.class).toString();
        assertNotNull(actualStringValue, "String representation should not be null.");
        assertEquals(expectedStringValue, actualStringValue, "String representation is incorrect.");

        // Test returning as Integer object
        Integer actualIntegerValue = pdInteger.createInstance(Integer.class);
        assertNotNull(actualIntegerValue, "Integer object should not be null.");
        assertEquals(expectedIntValue, actualIntegerValue.intValue(), "Integer object value is incorrect.");
    }

    /**
     * Tests returning a zero integer value as a String and as an Integer object.
     */
    @Test
    public void testZeroIntegerValue() {
        int expectedIntValue = 0;
        String expectedStringValue = "0";

        PDInteger pdInteger = new PDInteger(expectedIntValue);

        // Test returning as String
        String actualStringValue = pdInteger.createInstance(Integer.class).toString();
        assertNotNull(actualStringValue, "String representation should not be null.");
        assertEquals(expectedStringValue, actualStringValue, "String representation is incorrect.");

        // Test returning as Integer object
        Integer actualIntegerValue = pdInteger.createInstance(Integer.class);
        assertNotNull(actualIntegerValue, "Integer object should not be null.");
        assertEquals(expectedIntValue, actualIntegerValue.intValue(), "Integer object value is incorrect.");
    }

    /**
     * Tests returning a negative integer value as a String and as an Integer object.
     */
    @Test
    public void testNegativeIntegerValue() {
        int expectedIntValue = -456;
        String expectedStringValue = "-456";

        PDInteger pdInteger = new PDInteger(expectedIntValue);

        // Test returning as String
        String actualStringValue = pdInteger.createInstance(Integer.class).toString();
        assertNotNull(actualStringValue, "String representation should not be null.");
        assertEquals(expectedStringValue, actualStringValue, "String representation is incorrect.");

        // Test returning as Integer object
        Integer actualIntegerValue = pdInteger.createInstance(Integer.class);
        assertNotNull(actualIntegerValue, "Integer object should not be null.");
        assertEquals(expectedIntValue, actualIntegerValue.intValue(), "Integer object value is incorrect.");
    }

    /**
     * Tests behavior when the PDInteger object is initialized without a value.
     * Expected behavior is that it defaults to 0.
     */
    @Test
    public void testDefaultIntegerValue() {
        int expectedIntValue = 0;
        String expectedStringValue = "0";

        PDInteger pdInteger = new PDInteger(); // Should default to 0

        // Test returning as String
        String actualStringValue = pdInteger.createInstance(Integer.class).toString();
        assertNotNull(actualStringValue, "String representation should not be null.");
        assertEquals(expectedStringValue, actualStringValue, "String representation is incorrect.");

        // Test returning as Integer object
        Integer actualIntegerValue = pdInteger.createInstance(Integer.class);
        assertNotNull(actualIntegerValue, "Integer object should not be null.");
        assertEquals(expectedIntValue, actualIntegerValue.intValue(), "Integer object value is incorrect.");
    }

    /**
     * Tests that creating an instance of a type other than Integer throws an exception.
     * This verifies that the createInstance method is specific to the type stored.
     */
    @Test
    public void testCreateInstanceWrongType() {
        PDInteger pdInteger = new PDInteger(100);

        // Attempt to create an instance of String, which should throw an exception
        assertThrows(IllegalArgumentException.class, () -> {
            pdInteger.createInstance(String.class);
        }, "Should throw IllegalArgumentException when creating instance of wrong type.");
    }
}