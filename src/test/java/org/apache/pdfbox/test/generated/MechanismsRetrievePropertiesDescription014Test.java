package org.apache.pdfbox.test.generated;

import org.apache.pdfbox.pdmodel.common.PDPDFAPropertyType;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit 5 test class for requirement SRS-PDFBOX-014.
 * This class verifies the mechanisms to define and retrieve properties
 * 'description', 'category', 'valueType', and 'name' for PDFA Property types.
 */
public class MechanismsRetrievePropertiesDescription014Test {

    /**
     * Tests the successful definition and retrieval of all properties for a PDFA Property Type.
     */
    @Test publicVoidTestDefineAndRetrieveAllPropertiesSuccessfully() {
        String expectedName = "TestName";
        String expectedDescription = "A test description.";
        String expectedCategory = "TestCategory";
        String expectedValueType = "Text";

        PDPDFAPropertyType propertyType = new PDPDFAPropertyType();
        propertyType.setName(expectedName);
        propertyType.setDescription(expectedDescription);
        propertyType.setCategory(expectedCategory);
        propertyType.setValueType(expectedValueType);

        assertEquals(expectedName, propertyType.getName(), "Name property should match the set value.");
        assertEquals(expectedDescription, propertyType.getDescription(), "Description property should match the set value.");
        assertEquals(expectedCategory, propertyType.getCategory(), "Category property should match the set value.");
        assertEquals(expectedValueType, propertyType.getValueType(), "ValueType property should match the set value.");
    }

    /**
     * Tests theRetrievalOfPropertiesWhenTheyAreNotExplicitlySet(default values).
     */
    @Test publicVoidTestRetrievePropertiesWithDefaultValues() {
        PDPDFAPropertyType propertyType = new PDPDFAPropertyType();

        assertNull(propertyType.getName(), "Name should be null if not set.");
        assertNull(propertyType.getDescription(), "Description should be null if not set.");
        assertNull(propertyType.getCategory(), "Category should be null if not set.");
        assertNull(propertyType.getValueType(), "ValueType should be null if not set.");
    }

    /**
     * Tests setting and retrieving a property with an empty string value.
     */
    @Test publicVoidTestSetAndRetrieveEmptyStringProperty() {
        PDPDFAPropertyType propertyType = new PDPDFAPropertyType();
        String emptyString = "";

        propertyType.setName(emptyString);
        propertyType.setDescription(emptyString);
        propertyType.setCategory(emptyString);
        propertyType.setValueType(emptyString);

        assertEquals(emptyString, propertyType.getName(), "Empty string name should be retrievable.");
        assertEquals(emptyString, propertyType.getDescription(), "Empty string description should be retrievable.");
        assertEquals(emptyString, propertyType.getCategory(), "Empty string category should be retrievable.");
        assertEquals(emptyString, propertyType.getValueType(), "Empty string valueType should be retrievable.");
    }

    /**
     * Tests setting and retrieving a property with null values.
     * Note: PDPDFAPropertyType setters might handle nulls by setting to null or throwing exceptions.
     * This test assumes they are set to null.
     */
    @Test publicVoidTestSetAndRetrieveNullProperty() {
        PDPDFAPropertyType propertyType = new PDPDFAPropertyType();

        // Setting to null specifically
        propertyType.setName(null);
        propertyType.setDescription(null);
        propertyType.setCategory(null);
        propertyType.setValueType(null);

        assertNull(propertyType.getName(), "Setting name to null should result in null retrieval.");
        assertNull(propertyType.getDescription(), "Setting description to null should result in null retrieval.");
        assertNull(propertyType.getCategory(), "Setting category to null should result in null retrieval.");
        assertNull(propertyType.getValueType(), "Setting valueType to null should result in null retrieval.");
    }

    /**
     * Tests that properties can be updated after initial setting.
     */
    @Test publicVoidTestUpdatePropertyValues() {
        PDPDFAPropertyType propertyType = new PDPDFAPropertyType();
        String initialName = "InitialName";
        String updatedName = "UpdatedName";

        propertyType.setName(initialName);
        assertEquals(initialName, propertyType.getName(), "Initial name should be set correctly.");

        propertyType.setName(updatedName);
        assertEquals(updatedName, propertyType.getName(), "Updated name should overwrite the initial value.");
    }
}
