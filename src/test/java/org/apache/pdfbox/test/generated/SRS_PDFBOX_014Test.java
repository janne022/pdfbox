package org.apache.pdfbox.test.generated;

import org.apache.pdfbox.pdmodel.common.PDPDFAPropertyType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for Requirement SRS-PDFBOX-014, ensuring PDFA Property types correctly handle
 * 'description', 'category', 'valueType', and 'name' properties.
 */
class SRS_PDFBOX_014Test {

    /**
     * Tests the creation and retrieval of a PDFA Property Type with valid string values
     * for description, category, and name, and a valid value type.
     */
    @Test
    @DisplayName("Test PDFA Property Type creation and retrieval with valid data")
    void testValidPropertyTypeCreationAndRetrieval() {
        String description = "A sample description";
        String category = "SampleCategory";
        PDPDFAPropertyType.ValueType valueType = PDPDFAPropertyType.ValueType.TEXT;
        String name = "SampleName";

        PDPDFAPropertyType propertyType = new PDPDFAPropertyType(description, category, valueType, name);

        assertNotNull(propertyType, "PDFAPropertyType should not be null after creation.");
        assertEquals(description, propertyType.getDescription(), "Description should match the provided value.");
        assertEquals(category, propertyType.getCategory(), "Category should match the provided value.");
        assertEquals(valueType, propertyType.getValueType(), "ValueType should match the provided value.");
        assertEquals(name, propertyType.getName(), "Name should match the provided value.");
    }

    /**
     * Tests the handling of null values for optional properties (description, category, name)
     * during PDFA Property Type creation.
     */
    @Test
    @DisplayName("Test PDFA Property Type creation with null optional properties")
    void testPropertyTypeCreationWithNullOptionalProperties() {
        PDPDFAPropertyType.ValueType valueType = PDPDFAPropertyType.ValueType.NUMBER;

        // Test null description
        PDPDFAPropertyType propertyTypeWithNullDesc = new PDPDFAPropertyType(null, "Category", valueType, "Name");
        assertNotNull(propertyTypeWithNullDesc, "PropertyType should be created with null description.");
        assertNull(propertyTypeWithNullDesc.getDescription(), "Description should be null when provided as null.");

        // Test null category
        PDPDFAPropertyType propertyTypeWithNullCategory = new PDPDFAPropertyType("Description", null, valueType, "Name");
        assertNotNull(propertyTypeWithNullCategory, "PropertyType should be created with null category.");
        assertNull(propertyTypeWithNullCategory.getCategory(), "Category should be null when provided as null.");

        // Test null name
        PDPDFAPropertyType propertyTypeWithNullName = new PDPDFAPropertyType("Description", "Category", valueType, null);
        assertNotNull(propertyTypeWithNullName, "PropertyType should be created with null name.");
        assertNull(propertyTypeWithNullName.getName(), "Name should be null when provided as null.");

        // Test all optional properties as null
        PDPDFAPropertyType propertyTypeWithAllNullOptional = new PDPDFAPropertyType(null, null, valueType, null);
        assertNotNull(propertyTypeWithAllNullOptional, "PropertyType should be created with all optional properties as null.");
        assertNull(propertyTypeWithAllNullOptional.getDescription(), "Description should be null.");
        assertNull(propertyTypeWithAllNullOptional.getCategory(), "Category should be null.");
        assertNull(propertyTypeWithAllNullOptional.getName(), "Name should be null.");
    }

    /**
     * Tests that the constructor throws an IllegalArgumentException when the mandatory 'valueType'
     * is null.
     */
    @Test
    @DisplayName("Test PDFA Property Type creation with null mandatory valueType")
    void testPropertyTypeCreationWithNullValueType() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new PDPDFAPropertyType("Description", "Category", null, "Name"),
                "Constructor should throw IllegalArgumentException for null valueType."
        );

        assertTrue(thrown.getMessage().contains("ValueType cannot be null"), "Exception message should indicate null ValueType.");
    }

    /**
     * Tests the retrieval of properties when specific value types are used,
     * ensuring the correct enumeration is returned.
     */
    @Test
    @DisplayName("Test retrieval of different ValueTypes")
    void testValueTypeRetrieval() {
        PDPDFAPropertyType textType = new PDPDFAPropertyType("Desc", "Cat", PDPDFAPropertyType.ValueType.TEXT, "Name");
        PDPDFAPropertyType numberType = new PDPDFAPropertyType("Desc", "Cat", PDPDFAPropertyType.ValueType.NUMBER, "Name");
        PDPDFAPropertyType dateType = new PDPDFAPropertyType("Desc", "Cat", PDPDFAPropertyType.ValueType.DATE, "Name");
        PDPDFAPropertyType booleanType = new PDPDFAPropertyType("Desc", "Cat", PDPDFAPropertyType.ValueType.BOOLEAN, "Name");

        assertEquals(PDPDFAPropertyType.ValueType.TEXT, textType.getValueType(), "Should retrieve TEXT ValueType.");
        assertEquals(PDPDFAPropertyType.ValueType.NUMBER, numberType.getValueType(), "Should retrieve NUMBER ValueType.");
        assertEquals(PDPDFAPropertyType.ValueType.DATE, dateType.getValueType(), "Should retrieve DATE ValueType.");
        assertEquals(PDPDFAPropertyType.ValueType.BOOLEAN, booleanType.getValueType(), "Should retrieve BOOLEAN ValueType.");
    }

    /**
     * Tests that the 'name' property can be an empty string.
     */
    @Test
    @DisplayName("Test PDFA Property Type creation with empty name string")
    void testPropertyTypeCreationWithEmptyName() {
        String description = "A sample description";
        String category = "SampleCategory";
        PDPDFAPropertyType.ValueType valueType = PDPDFAPropertyType.ValueType.TEXT;
        String name = ""; // Empty name

        PDPDFAPropertyType propertyType = new PDPDFAPropertyType(description, category, valueType, name);

        assertNotNull(propertyType, "PDFAPropertyType should not be null with empty name.");
        assertEquals(name, propertyType.getName(), "Name should be an empty string.");
    }

    /**
     * Tests that the 'description' property can be an empty string.
     */
    @Test
    @DisplayName("Test PDFA Property Type creation with empty description string")
    void testPropertyTypeCreationWithEmptyDescription() {
        String description = ""; // Empty description
        String category = "SampleCategory";
        PDPDFAPropertyType.ValueType valueType = PDPDFAPropertyType.ValueType.TEXT;
        String name = "SampleName";

        PDPDFAPropertyType propertyType = new PDPDFAPropertyType(description, category, valueType, name);

        assertNotNull(propertyType, "PDFAPropertyType should not be null with empty description.");
        assertEquals(description, propertyType.getDescription(), "Description should be an empty string.");
    }

    /**
     * Tests that the 'category' property can be an empty string.
     */
    @Test
    @DisplayName("Test PDFA Property Type creation with empty category string")
    void testPropertyTypeCreationWithEmptyCategory() {
        String description = "A sample description";
        String category = ""; // Empty category
        PDPDFAPropertyType.ValueType valueType = PDPDFAPropertyType.ValueType.TEXT;
        String name = "SampleName";

        PDPDFAPropertyType propertyType = new PDPDFAPropertyType(description, category, valueType, name);

        assertNotNull(propertyType, "PDFAPropertyType should not be null with empty category.");
        assertEquals(category, propertyType.getCategory(), "Category should be an empty string.");
    }

    /**
     * Verifies that the PDFA Property Type can be instantiated and its properties retrieved
     * from a potentially complex or long string input.
     */
    @Test
    @DisplayName("Test PDFA Property Type with long string values")
    void testPropertyTypeWithLongStringValues() {
        String longDescription = "This is a significantly lengthy description intended to test the handling of longer text inputs for the description field of a PDFA Property Type. It should accommodate substantial amounts of text without issues.";
        String complexCategory = "Complex_Category-123!@#$%^";
        PDPDFAPropertyType.ValueType valueType = PDPDFAPropertyType.ValueType.TEXT;
        String complexName = "ComplexName_With_Symbols_And$Spaces";

        PDPDFAPropertyType propertyType = new PDPDFAPropertyType(longDescription, complexCategory, valueType, complexName);

        assertNotNull(propertyType, "PDFAPropertyType should be created with long string values.");
        assertEquals(longDescription, propertyType.getDescription(), "Long description should be correctly stored and retrieved.");
        assertEquals(complexCategory, propertyType.getCategory(), "Complex category should be correctly stored and retrieved.");
        assertEquals(valueType, propertyType.getValueType(), "ValueType should be correctly stored and retrieved.");
        assertEquals(complexName, propertyType.getName(), "Complex name should be correctly stored and retrieved.");
    }
}
