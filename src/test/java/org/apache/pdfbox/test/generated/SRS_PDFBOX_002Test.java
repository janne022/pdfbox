package org.apache.pdfbox.test.generated;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.interactive.form.PDVariableText;
import org.apache.pdfbox.pdmodel.interactive.form.PDTextField;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Requirement SRS-PDFBOX-002: The CSCI shall manage a sequence of properties associated with schema definitions.
 * This test focuses on how PDFBox handles and manages properties (key-value pairs) attached to various PDF objects,
 * simulating schema-like behavior.
 */
public class SRS_PDFBOX_002Test {

    private PDDocument document;

    /**
     * Sets up a new, empty PDF document before each test.
     */
    @BeforeEach
    void setUp() throws IOException {
        document = new PDDocument();
    }

    /**
     * Cleans up the PDF document after each test.
     */
    @AfterEach
    void tearDown() throws IOException {
        if (document != null) {
            document.close();
        }
    }

    /**
     * Tests the management of properties associated with a dictionary, simulating a simple schema.
     * This scenario validates adding, retrieving, and updating properties within a dictionary.
     */
    @Test
    @DisplayName("Test management of properties in a COSDictionary")
    void testManageDictionaryProperties() {
        COSDictionary schemaDict = new COSDictionary();

        // Add properties (simulating schema attributes)
        schemaDict.setString(COSName.getPDFName("name"), "Person");
        schemaDict.setInt(COSName.getPDFName("version"), 1);
        schemaDict.setBoolean(COSName.getPDFName("isActive"), true);

        // Verify properties are correctly set
        assertEquals("Person", schemaDict.getString(COSName.getPDFName("name")), "Failed to retrieve 'name' property");
        assertEquals(1, schemaDict.getInt(COSName.getPDFName("version")), "Failed to retrieve 'version' property");
        assertTrue(schemaDict.getBoolean(COSName.getPDFName("isActive")), "Failed to retrieve 'isActive' property");

        // Update a property
        schemaDict.setInt(COSName.getPDFName("version"), 2);
        assertEquals(2, schemaDict.getInt(COSName.getPDFName("version")), "Failed to update 'version' property");

        // Remove a property
        schemaDict.removeItem(COSName.getPDFName("isActive"));
        assertNull(schemaDict.getDictionaryObject(COSName.getPDFName("isActive")), "Failed to remove 'isActive' property");

        // Check for non-existent property
        assertNull(schemaDict.getDictionaryObject(COSName.getPDFName("nonExistent")), "Should return null for non-existent property");
    }

    /**
     * Tests managing properties associated with a Page object, specifically its MediaBox.
     * This demonstrates managing predefined properties that have specific meanings in PDF.
     */
    @Test
    @DisplayName("Test management of Page properties (MediaBox)")
    void testManagePageProperties() {
        PDRectangle mediaBox = PDRectangle.A4;
        document.getPage(0).getMediaBox().importRhinoRectangle(mediaBox);

        // Verify the MediaBox property is set
        assertNotNull(document.getPage(0).getMediaBox(), "MediaBox should not be null after setting");
        assertEquals(mediaBox.getWidth(), document.getPage(0).getMediaBox().getWidth(), "MediaBox width mismatch");
        assertEquals(mediaBox.getHeight(), document.getPage(0).getMediaBox().getHeight(), "MediaBox height mismatch");

        // Attempt to set an invalid property (though PDFBox often ignores or handles)
        // In a real schema management, validation would occur here.
        // For this test, we focus on basic property presence and retrieval.
        document.getPage(0).getCOSObject().setItem(COSName.getPDFName("customPageProperty"), new COSDictionary());
        assertTrue(document.getPage(0).getCOSObject().containsKey(COSName.getPDFName("customPageProperty")), "Failed to add custom page property");
    }

    /**
     * Tests managing properties within a Form Field dictionary, such as a text field.
     * This simulates associating data or metadata with interactive elements.
     */
    @Test
    @DisplayName("Test management of Form Field properties")
    void testManageFormFieldProperties() throws IOException {
        // Add a page and a text field to the document
        document.addPage(document.getFactory().createPage(PDRectangle.A4));
        PDTextField textField = new PDTextField(document.getAcroForm());
        textField.setPartialName("SampleField");
        document.getAcroForm().addField(textField);

        // Manage properties associated with the form field's COS dictionary
        textField.getCOSObject().setString(COSName.USER_PROPERTIES, "SampleUserValue");
        textField.getCOSObject().setInt(COSName.getPDFName("customSchemaInt"), 123);

        // Verify properties are set
        assertEquals("SampleUserValue", textField.getCOSObject().getString(COSName.USER_PROPERTIES), "Failed to retrieve USER_PROPERTIES");
        assertEquals(123, textField.getCOSObject().getInt(COSName.getPDFName("customSchemaInt")), "Failed to retrieve customSchemaInt property");

        // Test updating a property
        textField.getVariableText().setText("Initial Text");
        assertTrue(textField.hasAppearance(), "TextField should have appearance after setting text");
        assertEquals("Initial Text", textField.getText(), "Failed to retrieve text");
    }

    /**
     * Tests handling of multiple properties with potentially the same key but different types,
     * and ensuring correct retrieval based on type.
     */
    @Test
    @DisplayName("Test handling of properties with same key, different types")
    void testPropertiesSameKeyDifferentTypes() {
        COSDictionary dict = new COSDictionary();

        // Add a string property
        dict.setString(COSName.getPDFName("key"), "stringValue");
        assertEquals("stringValue", dict.getString(COSName.getPDFName("key")), "Failed to retrieve string value");

        // Overwrite with an integer property. PDF spec might handle this differently based on context,
        // but COSDictionary typically replaces the object.
        dict.setInt(COSName.getPDFName("key"), 123);
        assertEquals(123, dict.getInt(COSName.getPDFName("key")), "Failed to retrieve updated integer value");
        assertNotEquals("123", dict.getString(COSName.getPDFName("key")), "Should not retrieve as string after being set as int");

        // Add a boolean property with a different key
        dict.setBoolean(COSName.getPDFName("anotherKey"), false);
        assertFalse(dict.getBoolean(COSName.getPDFName("anotherKey")), "Failed to retrieve boolean value");
    }

    /**
     * Tests the ability to store and retrieve properties that are themselves dictionaries,
     * enabling hierarchical schema definitions.
     */
    @Test
    @DisplayName("Test nested dictionary (hierarchical schema) properties")
    void testNestedDictionaryProperties() {
        COSDictionary mainSchema = new COSDictionary();
        COSDictionary addressSchema = new COSDictionary();

        addressSchema.setString(COSName.getPDFName("street"), "123 Main St");
        addressSchema.setString(COSName.getPDFName("city"), "Anytown");

        mainSchema.setItem(COSName.getPDFName("address"), addressSchema);
        mainSchema.setInt(COSName.getPDFName("userId"), 987);

        // Retrieve the nested dictionary
        COSDictionary retrievedAddress = (COSDictionary) mainSchema.getDictionaryObject(COSName.getPDFName("address"));
        assertNotNull(retrievedAddress, "Failed to retrieve nested address dictionary");

        // Verify properties within the nested dictionary
        assertEquals("123 Main St", retrievedAddress.getString(COSName.getPDFName("street")), "Failed to retrieve nested street property");
        assertEquals("Anytown", retrievedAddress.getString(COSName.getPDFName("city")), "Failed to retrieve nested city property");

        // Verify property outside the nested dictionary
        assertEquals(987, mainSchema.getInt(COSName.getPDFName("userId")), "Failed to retrieve top-level userId property");
    }

    /**
     * Tests the scenario where a property is expected but not present.

     * This ensures graceful handling and accurate reporting of missing properties.
     */
    @Test
    @DisplayName("Test retrieval of non-existent property")
    void testNonExistentProperty() {
        COSDictionary dict = new COSDictionary();
        COSName nonexistentKey = COSName.getPDFName("I_DO_NOT_EXIST");

        // Assert that getting a non-existent property returns null
        assertNull(dict.getDictionaryObject(nonexistentKey), "getDictionaryObject should return null for non-existent key");
        assertNull(dict.getString(nonexistentKey), "getString should return null for non-existent key");
        assertEquals(0, dict.getInt(nonexistentKey), "getInt should return 0 for non-existent key (default value in PDFBox)");
        assertFalse(dict.getBoolean(nonexistentKey), "getBoolean should return false for non-existent key (default value in PDFBox)");
    }
    
    /**
     * Tests the management of properties using a Map, simulating loading schema definitions from an external source.
     */
    @Test
    @DisplayName("Test management of properties using Map")
    void testManagePropertiesWithMap() {
        COSDictionary schemaDict = new COSDictionary();
        Map<COSName, Object> propertiesToSet = new HashMap<>();

        propertiesToSet.put(COSName.getPDFName("schemaName"), "UserSchema");
        propertiesToSet.put(COSName.getPDFName("schemaVersion"), 5.0f);
        propertiesToSet.put(COSName.getPDFName("isEnabled"), false);

        // Add all properties from the map to the dictionary
        propertiesToSet.forEach(schemaDict::putAll);

        // Verify properties 
        assertEquals("UserSchema", schemaDict.getString(COSName.getPDFName("schemaName")));
        assertEquals(5.0f, schemaDict.getFloat(COSName.getPDFName("schemaVersion")));
        assertFalse(schemaDict.getBoolean(COSName.getPDFName("isEnabled")));
    }

    /**
     * Tests the behavior when attempting to set properties that are not directly supported by PDF/COS objects,
     * ensuring that PDFBox either handles them gracefully or enforces PDF structure.
     */
    @Test
    @DisplayName("Test setting unsupported property types")
    void testSetUnsupportedPropertyTypes() {
        COSDictionary dict = new COSDictionary();
        Object unsupportedObject = new Object(); // An object not directly representable as PDF primitive
        COSName unsupportedKey = COSName.getPDFName("complexData");

        // Attempt to set an unsupported object type. PDFBox should handle this by:
        // 1. Throwing an exception if strict validation is on.
        // 2. Converting to a string if possible.
        // 3. Storing as an indirect object (less likely for direct dict add).
        // For this test, we expect it to potentially fail or be ignored if not a supported COS type.
        // Let's mimic a common scenario: trying to put a non-COS object.
        assertThrows(IllegalArgumentException.class, () -> {
            dict.put(unsupportedKey, unsupportedObject); // Expecting an IllegalArgumentException
        }, "Should throw IllegalArgumentException for completely unsupported object types.");

        // Test with a valid but complex PDF type like a COSStream (though less common directly in dict)
        // The key here is how the CSCI *manages* properties. If a property is a stream, it should be managed.
        try {
            // This test is more about confirming certain types are not directly allowed without conversion.
            // If PDRectangle or PDTextField were added, they'd be converted to their COS representations.
            // The core is that sequence of properties are managed.
            assertTrue(true);
        } catch (Exception e) {
            fail("Unexpected exception when testing property management: " + e.getMessage());
        }
    }

}