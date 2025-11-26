package org.apache.pdfbox.test.generated;

import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSInteger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit 5 test class for Requirement SRS-PDFBOX-012.
 * This class tests the functionality of setting an Integer type property
 * using both String and Integer objects.
 */
class SettingIntegerTypeProperty012Test {

    private COSDictionary dictionary;

    /**
     * Initializes a new COSDictionary before each test.
     */
    @BeforeEach
    void setUp() {
        dictionary = new COSDictionary();
    }

    /**
     * Tests setting an integer property using a valid String representation of an integer.
     * The property should be successfully added as a COSInteger object.
     */
    @Test
    @DisplayName("Set Integer Property with Valid String")
    void testSetIntegerPropertyWithString_Valid() {
        String key = "TestIntegerString";
        String valueString = "12345";

        dictionary.setTheSameProperty(key, valueString);

        COSBase cosObject = dictionary.getItem(key);
        assertNotNull(cosObject, "The property should be present in the dictionary.");
        assertTrue(cosObject instanceof COSInteger, "The property should be of type COSInteger.");

        COSInteger cosInt = (COSInteger) cosObject;
        assertEquals(12345, cosInt.intValue(), "The integer value should match the input string.");
    }

    /**
     * Tests setting an integer property using a valid Integer object.
     * The property should be successfully added as a COSInteger object.
     */
    @Test
    @DisplayName("Set Integer Property with Valid Integer Object")
    void testSetIntegerPropertyWithIntegerObject_Valid() {
        String key = "TestIntegerObject";
        Integer valueInteger = 98765;

        dictionary.setTheSameProperty(key, valueInteger);

        COSBase cosObject = dictionary.getItem(key);
        assertNotNull(cosObject, "The property should be present in the dictionary.");
        assertTrue(cosObject instanceof COSInteger, "The property should be of type COSInteger.");

        COSInteger cosInt = (COSInteger) cosObject;
        assertEquals(98765, cosInt.intValue(), "The integer value should match the input Integer object.");
    }

    /**
     * Tests setting an integer property using a String that is not a valid integer representation.
     * This should ideally throw an exception or result in the property not being set as expected.
     * Note: PDFBox's setTheSameProperty for String to COSInteger might implicitly handle some cases more leniently,
     * but for a strictly compliant test, we anticipate issues with non-numeric strings.
     * Current PDFBox behavior for non-numeric strings in setTheSameProperty might lead to a NumberFormatException during parsing.
     */
    @Test
    @DisplayName("Set Integer Property with Invalid String Format Fails")
    void testSetIntegerPropertyWithString_InvalidFormat() {
        String key = "TestInvalidIntegerString";
        String invalidValueString = "abc";

        // Expecting a NumberFormatException or similar when parsing 'abc' to an integer
        assertThrows(NumberFormatException.class, () -> {
            dictionary.setTheSameProperty(key, invalidValueString);
        }, "Setting with a non-numeric string should fail.");

        // Verify that the key was not added or was added incorrectly if parse failed partially
        assertNull(dictionary.getItem(key), "Property should not be present if parsing failed.");
    }

    /**
     * Tests setting an integer property with a null value.
     * This should result in the property either not being set or being treated as null/undefined.
     */
    @Test
    @DisplayName("Set Integer Property with Null Value")
    void testSetIntegerPropertyWithNullValue() {
        String key = "TestNullInteger";
        Integer nullValue = null;

        dictionary.setTheSameProperty(key, nullValue);

        // For null, setTheSameProperty might remove the key if it exists, or do nothing.
        // Verifying it's not present is a reasonable expectation.
        assertNull(dictionary.getItem(key), "Property should not be present when null is provided.");
    }

    /**
     * Tests setting an integer property using a String representing a negative integer.
     * The property should be successfully added as a COSInteger object.
     */
    @Test
    @DisplayName("Set Integer Property with Negative String")
    void testSetIntegerPropertyWithNegativeString() {
        String key = "TestNegativeIntegerString";
        String valueString = "-500";

        dictionary.setTheSameProperty(key, valueString);

        COSBase cosObject = dictionary.getItem(key);
        assertNotNull(cosObject, "The property should be present in the dictionary.");
        assertTrue(cosObject instanceof COSInteger, "The property should be of type COSInteger.");

        COSInteger cosInt = (COSInteger) cosObject;
        assertEquals(-500, cosInt.intValue(), "The integer value should match the negative input string.");
    }

    /**
     * Tests setting an integer property using a String representing a large integer.
     * This checks for potential overflow issues if the underlying parsing or COSInteger has limitations.
     * PDFBox's COSInteger supports arbitrary precision for its value, so this checks its integration.
     */
    @Test
    @DisplayName("Set Integer Property with Large Integer String")
    void testSetIntegerPropertyWithLargeIntegerString() {
        String key = "TestLargeIntegerString";
        String valueString = "2147483647"; // Max int
        String veryLargeValueString = "98765432109876543210"; // Larger than int max

        dictionary.setTheSameProperty(key, valueString);
        COSBase cosObject1 = dictionary.getItem(key);
        assertNotNull(cosObject1);
        assertTrue(cosObject1 instanceof COSInteger);
        assertEquals(2147483647, ((COSInteger) cosObject1).intValue());

        dictionary.setTheSameProperty(key, veryLargeValueString);
        COSBase cosObject2 = dictionary.getItem(key);
        assertNotNull(cosObject2);
        assertTrue(cosObject2 instanceof COSInteger);
        // PDFBox COSInteger supports large numbers, check if it stores correctly as BigInteger internally
        assertEquals(new java.math.BigInteger(veryLargeValueString), ((COSInteger) cosObject2).getValue());
    }

    /**
     * Tests that a non-integer String is not accepted when expecting an Integer property.
     * This is a more specific test for invalid string formats. PDFBox's internal handling
     * might parse it as 0 or raise an error based on the exact method used.
     * `setTheSameProperty` is designed to handle various types, so this tests its parsing logic.
     */
    @Test
    @DisplayName("Set Integer Property with Non-Numeric String Fails Gracefully")
    void testSetIntegerPropertyWithNonNumericString() {
        String key = "TestNonNumericString";
        String nonNumericValue = "123a45";

        // The behavior here depends on PDFBox's internal parsing. Generally, it should fail.
        assertThrows(NumberFormatException.class, () -> {
            dictionary.setTheSameProperty(key, nonNumericValue);
        }, "Setting with a non-numeric string that cannot be fully parsed should throw an exception.");
        assertNull(dictionary.getItem(key), "Property should not be added if the string is not a valid integer.");
    }

    /**
     * Tests setting an integer property using a String with leading/trailing whitespace.
     * Valid integer strings with whitespace should typically be parsed correctly.
     */
    @Test
    @DisplayName("Set Integer Property with Whitespace String")
    void testSetIntegerPropertyWithWhitespaceString() {
        String key = "TestWhitespaceIntegerString";
        String valueStringWithWhitespace = "  42 ";

        dictionary.setTheSameProperty(key, valueStringWithWhitespace);

        COSBase cosObject = dictionary.getItem(key);
        assertNotNull(cosObject, "The property should be present in the dictionary.");
        assertTrue(cosObject instanceof COSInteger, "The property should be of type COSInteger.");

        COSInteger cosInt = (COSInteger) cosObject;
        // PDFBox should robustly parse strings with whitespace into integers.
        assertEquals(42, cosInt.intValue(), "The integer value should be parsed correctly despite surrounding whitespace.");
    }
}