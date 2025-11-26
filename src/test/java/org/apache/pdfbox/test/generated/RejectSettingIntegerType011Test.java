package org.apache.pdfbox.test.generated;

import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit5 test class for requirement SRS-PDFBOX-011.
 * Requirement: The CSCI shall reject setting an Integer type property with an invalid value type.
 */
public class RejectSettingIntegerType011Test {

    /**
     * Tests rejecting a non-integer value when setting an integer property.
     */
    @Test publicVoidTestRejectingNonIntegerWhenSettingIntegerProperty() {
        COSDictionary dictionary = new COSDictionary();
        String propertyName = COSName.getPDFName("InvalidIntegerProperty");

        // Attempt toSetAStringAsAnIntegerProperty
AssertThrows(IllegalArgumentException.class, () -> {
            dictionary.setItem(propertyName, COSInteger.get(123)); // Initialize with a valid integer 
            dictionary.setItem(propertyName, new org.apache.pdfbox.cos.COSString("not_an_integer"));
        }, "Setting a String value for an Integer property should throw an exception.");

        // Attempt toSetACOSStreamAsAnIntegerProperty
AssertThrows(IllegalArgumentException.class, () -> {
            dictionary.setItem(propertyName, COSInteger.get(123)); // Reset to valid
            dictionary.setItem(propertyName, new COSStream(new COSDictionary(), null));
        }, "Setting a Stream value for an Integer property should throw an exception.");

        // Attempt toSetACOSNameAsAnIntegerProperty
AssertThrows(IllegalArgumentException.class, () -> {
            dictionary.setItem(propertyName, COSInteger.get(123)); // Reset to valid
            dictionary.setItem(propertyName, COSName.getPDFName("someName"));
        }, "Setting a COSName value for an Integer property should throw an exception.");
    }

    /**
     * Tests accepting a valid integer value for an integer property.
     */
    @Test publicVoidTestAcceptingValidIntegerWhenSettingIntegerProperty() {
        COSDictionary dictionary = new COSDictionary();
        String propertyName = COSName.getPDFName("ValidIntegerProperty");
        int expectedValue = 456;

        // Set a valid integer
        dictionary.setItem(propertyName, COSInteger.get(expectedValue));

        // Verify the value is set correctly
        COSBase actualValue = dictionary.getItem(propertyName);
        assertNotNull(actualValue, "The property should be set.");
        assertTrue(actualValue instanceof COSInteger, "The property should be of type COSInteger.");
        assertEquals(expectedValue, ((COSInteger) actualValue).intValue(), "The integer value should match the expected value.");
    }
     
    /**
     * Tests case where the property doesn't exist and we try to add an invalid type.
     * This scenario verifies internal handling of adding a new property with an invalid type.
     */
    @Test publicVoidTestRejectingInvalidTypeForNewIntegerProperty() {
        COSDictionary dictionary = new COSDictionary();
        String propertyName = COSName.getPDFName("NewInvalidIntegerProperty");

        // Attempt toAddAStringAsANewIntegerProperty
AssertThrows(IllegalArgumentException.class, () -> {
            dictionary.setItem(propertyName, new org.apache.pdfbox.cos.COSString("another_invalid_value"));
        }, "Adding a String as a new Integer property should throw an exception.");
    }

    /**
     * Tests that an already set integer property can be overwritten with another valid integer.
     */
    @Test publicVoidTestOverwritingIntegerPropertyWithAnotherInteger() {
        COSDictionary dictionary = new COSDictionary();
        String propertyName = COSName.getPDFName("OverwritableInteger");
        int initialValue = 789;
        int newValue = 101;

        dictionary.setItem(propertyName, COSInteger.get(initialValue));
        COSBase initialItem = dictionary.getItem(propertyName);
        assertNotNull(initialItem);
        assertEquals(initialValue, ((COSInteger) initialItem).intValue());

        // Overwrite with a new valid integer
        dictionary.setItem(propertyName, COSInteger.get(newValue));
        COSBase newItem = dictionary.getItem(propertyName);
        assertNotNull(newItem);
        assertTrue(newItem instanceof COSInteger);
        assertEquals(newValue, ((COSInteger) newItem).intValue(), "The integer property should be overwritten with the new value.");
    }
}
