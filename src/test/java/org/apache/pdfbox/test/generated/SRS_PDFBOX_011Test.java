package org.apache.pdfbox.test.generated;

import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSNumber;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Requirement SRS-PDFBOX-011: The CSCI shall reject setting an Integer type property with an invalid value type.
 */
class SRS_PDFBOX_011Test {

    private PDDocument document;
    private PDAcroForm acroForm;

    /**
     * Sets up a new PDDocument and PDAcroForm before each test.
     */
    @BeforeEach
    void setUp() throws Exception {
        document = new PDDocument();
        acroForm = new PDAcroForm(document);
        document.getDocumentCatalog().setAcroForm(acroForm);
    }

    /**
     * Cleans up the PDDocument after each test.
     */
    @org.junit.jupiter.api.AfterEach
    void tearDown() throws Exception {
        if (document != null) {
            document.close();
        }
    }

    /**
     * Tests rejection of non-integer string values for an integer property.
     */
    @Test
    @DisplayName("Reject setting Integer property with non-integer string value")
    void testRejectNonIntegerStringValue() {
        COSName intPropertyName = COSName.getPDFName("IntegerProp");
        String invalidStringValue = "not_an_integer";

        // Attempt to set an Integer property with a string that is not a valid integer
        assertThrows(IllegalArgumentException.class, () -> {
            acroForm.getCOSDictionary().setItem(intPropertyName, COSNumber.get(invalidStringValue));
        }, "Should throw IllegalArgumentException for non-integer string value");
    }

    /**
     * Tests rejection of a floating-point number when an integer is expected.
     */
    @Test
    @DisplayName("Reject setting Integer property with floating-point value")
    void testRejectFloatingPointValue() {
        COSName intPropertyName = COSName.getPDFName("IntegerProp");
        float floatValue = 123.45f;

        // Attempt to set an Integer property with a float value
        assertThrows(IllegalArgumentException.class, () -> {
            acroForm.getCOSDictionary().setItem(intPropertyName, COSNumber.get(floatValue));
        }, "Should throw IllegalArgumentException for floating-point value");
    }

    /**
     * Tests rejection of a boolean value when an integer is expected.
     */
    @Test
    @DisplayName("Reject setting Integer property with boolean value")
    void testRejectBooleanValue() {
        COSName intPropertyName = COSName.getPDFName("IntegerProp");
        boolean booleanValue = true;
        COSBase cosBoolean = org.apache.pdfbox.cos.COSBoolean.getBooleanObject(booleanValue);

        // Attempt to set an Integer property with a boolean value
        assertThrows(IllegalArgumentException.class, () -> {
             acroForm.getCOSDictionary().setItem(intPropertyName, cosBoolean);
        }, "Should throw IllegalArgumentException for boolean value");
    }

    /**
     * Tests rejection of a null value when an integer is expected.
     */
    @Test
    @DisplayName("Reject setting Integer property with null value")
    void testRejectNullValue() {
        COSName intPropertyName = COSName.getPDFName("IntegerProp");

        // Attempt to set an Integer property with a null value
        assertThrows(IllegalArgumentException.class, () -> {
            acroForm.getCOSDictionary().setItem(intPropertyName, null);
        }, "Should throw IllegalArgumentException for null value");
    }

    /**
     * Tests rejection of a complex object (like a dictionary)
     * when an integer is expected.
     */
    @Test
    @DisplayName("Reject setting Integer property with dictionary value")
    void testRejectDictionaryValue() {
        COSName intPropertyName = COSName.getPDFName("IntegerProp");
        COSDictionary invalidValue = new COSDictionary();

        // Attempt to set an Integer property with a dictionary
        assertThrows(IllegalArgumentException.class, () -> {
            acroForm.getCOSDictionary().setItem(intPropertyName, invalidValue);
        }, "Should throw IllegalArgumentException for dictionary value");
    }

    /**
     * Tests rejection of trying to set a property that is intrinsically not an integer
     * with a valid integer value, ensuring the underlying COS type is respected.
     * This ensures that type checking is done correctly.
     */
    @Test
    @DisplayName("Reject setting non-integer property with valid integer value")
    void testRejectNonIntegerPropertyWithValidIntegerValue() {
        COSName stringPropertyName = COSName.getPDFName("StringProp"); // Assuming this is a string prop
        int validIntegerValue = 42;
        COSNumber cosInteger = COSNumber.get(validIntegerValue);

        // Attempt to set a property that is defined or expected as non-integer with an integer
        // This might depend on how PDFBox handles schema or context, but generally, invalid type assignment should be rejected.
        // Here we are testing the general mechanism of setting an item with potentially incompatible types.
        assertThrows(IllegalArgumentException.class, () -> {
             acroForm.getCOSDictionary().setItem(stringPropertyName, cosInteger);
        }, "Should throw IllegalArgumentException if trying to assign an integer to a non-integer type property");
    }

    /**
     * Tests the scenario where an existing property is not an integer and
     * we try to overwrite it with an integer value.
     */
     @Test
     @DisplayName("Overwrite non-integer property with integer value")
     void testOverwriteNonIntegerPropertyWithIntegerValue() {
        COSName propertyName = COSName.getPDFName("NonIntegerProp");
        String initialStringValue = "initial_string";
        int newIntegerValue = 77;

        // Set initial value as a string
        acroForm.getCOSDictionary().setItem(propertyName, org.apache.pdfbox.cos.COSString.newInstance(initialStringValue));

        // Attempt to overwrite with an integer value
        assertThrows(IllegalArgumentException.class, () -> {
            acroForm.getCOSDictionary().setItem(propertyName, COSNumber.get(newIntegerValue));
        }, "Should throw IllegalArgumentException when overwriting a non-integer property with an integer");
     }
}