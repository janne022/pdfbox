package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit 5 tests for requirement SRS-PDFBOX-021.
 *
 * Requirement: The CSCI shall represent boolean values as the strings 'True' or 'False',
 * and also as Boolean objects.
 */
public class RepresentBooleanValuesStrings021Test {

    /**
     * Tests the representation of the boolean value true as a String and as a Boolean object.
     */
    @Test
    public void testRepresentBooleanTrue() {
        boolean primitiveTrue = true;
        Boolean objectTrue = Boolean.TRUE;
        String stringTrue = "True";

        // Test primitive boolean to String representation
        assertEquals(stringTrue, Boolean.toString(primitiveTrue), "Primitive boolean 'true' should be represented as 'True' string.");

        // Test Boolean object to String representation
        assertEquals(stringTrue, objectTrue.toString(), "Boolean object 'TRUE' should be represented as 'True' string.");

        // Test String to Boolean object conversion (positive case)
        assertTrue(Boolean.parseBoolean(stringTrue), "String 'True' should be parsed as true Boolean object.");
        assertEquals(objectTrue, Boolean.valueOf(stringTrue), "String 'True' should be valued as Boolean object TRUE.");

        // Test Boolean object's booleanValue()
        assertTrue(objectTrue.booleanValue(), "Boolean object TRUE should have booleanValue() returning true.");
    }

    /**
     * Tests the representation of the boolean value false as a String and as a Boolean object.
     */
    @Test
    public void testRepresentBooleanFalse() {
        boolean primitiveFalse = false;
        Boolean objectFalse = Boolean.FALSE;
        String stringFalse = "False";

        // Test primitive boolean to String representation
        assertEquals(stringFalse, Boolean.toString(primitiveFalse), "Primitive boolean 'false' should be represented as 'False' string.");

        // Test Boolean object to String representation
        assertEquals(stringFalse, objectFalse.toString(), "Boolean object 'FALSE' should be represented as 'False' string.");

        // Test String to Boolean object conversion (positive case)
        assertFalse(Boolean.parseBoolean(stringFalse), "String 'False' should be parsed as false Boolean object.");
        assertEquals(objectFalse, Boolean.valueOf(stringFalse), "String 'False' should be valued as Boolean object FALSE.");

        // Test Boolean object's booleanValue()
        assertFalse(objectFalse.booleanValue(), "Boolean object FALSE should have booleanValue() returning false.");
    }

    /**
     * Tests the parsing of various string inputs to Boolean objects, including case-insensitivity and non-standard true/false strings.
     */
    @Test
    public void testParseBooleanVariations() {
        // Case-insensitive 'True'
        assertTrue(Boolean.parseBoolean("true"), "String 'true' (lowercase) should be parsed as true.");
        assertTrue(Boolean.parseBoolean("TRUE"), "String 'TRUE' (uppercase) should be parsed as true.");
        assertTrue(Boolean.parseBoolean("TrUe"), "String 'TrUe' (mixed case) should be parsed as true.");

        // Case-insensitive 'False'
        assertFalse(Boolean.parseBoolean("false"), "String 'false' (lowercase) should be parsed as false.");
        assertFalse(Boolean.parseBoolean("FALSE"), "String 'FALSE' (uppercase) should be parsed as false.");
        assertFalse(Boolean.parseBoolean("FaLsE"), "String 'FaLsE' (mixed case) should be parsed as false.");

        // Non-standard strings default to false with Boolean.parseBoolean
        assertFalse(Boolean.parseBoolean("yes"), "String 'yes' should be parsed as false.");
        assertFalse(Boolean.parseBoolean("1"), "String '1' should be parsed as false.");
        assertFalse(Boolean.parseBoolean(""), "Empty string should be parsed as false.");
        assertFalse(Boolean.parseBoolean(null), "Null input should result in false for Boolean.parseBoolean."); // Note: Boolean.parseBoolean handles null gracefully.
    }

    /**
     * Tests the creation of Boolean objects from primitive booleans.
     */
    @Test
    public void testBoxedBooleanCreation() {
        assertTrue(Boolean.valueOf(true).booleanValue(), "Boolean.valueOf(true) should create a Boolean object representing true.");
        assertFalse(Boolean.valueOf(false).booleanValue(), "Boolean.valueOf(false) should create a Boolean object representing false.");

        assertTrue(new Boolean(true), "new Boolean(true) should create a Boolean object representing true."); // Deprecated, but tests requirement compliance if used.
        assertFalse(new Boolean(false), "new Boolean(false) should create a Boolean object representing false."); // Deprecated, but tests requirement compliance if used.
    }

    /**
     * Tests the toString() method for both true and false Boolean objects.
     */
    @Test
    public void testBooleanToStringRepresentation() {
        assertEquals("True", Boolean.TRUE.toString(), "Boolean.TRUE.toString() should return \"True\".");
        assertEquals("False", Boolean.FALSE.toString(), "Boolean.FALSE.toString() should return \"False\".");
    }
}