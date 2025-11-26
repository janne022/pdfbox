package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit 5 test class for Requirement SRS-PDFBOX-020.
 * This class verifies the CSCI's support for 'Settings' property as a sequence of Text,
 * and 'Rows' and 'Columns' properties as Integers.
 */
class SettingsPropertySequenceText020Test {

    /**
     * Tests the valid creation and retrieval of the 'Settings' property 
     * with a sequence of text values.
     */
    @Test
    @DisplayName("Test valid Settings property with sequence of text")
    void testValidSettingsPropertySequenceText() {
        // Arrange
        String[] expectedSettings = {"Setting1", "Setting2", "Another Setting"};
        
        // Act - Simulate setting the property
        // In a real scenario, this would involve interacting with the CSCI's API
        // For this example, we'll use a placeholder for the CSCI object
        MockCSCI csci = new MockCSCI();
        csci.setSettings(expectedSettings);
        String[] actualSettings = csci.getSettings();

        // Assert
        assertNotNull(actualSettings, "Settings property should not be null.");
        assertArrayEquals(expectedSettings, actualSettings, "Settings property values do not match.");
    }

    /**
     * Tests the valid creation and retrieval of the 'Rows' property as an Integer.
     */
    @Test
    @DisplayName("Test valid Rows property as integer")
    void testValidRowsPropertyInteger() {
        // Arrange
        Integer expectedRows = 10;

        // Act - Simulate setting the property
        MockCSCI csci = new MockCSCI();
        csci.setRows(expectedRows);
        Integer actualRows = csci.getRows();

        // Assert
        assertNotNull(actualRows, "Rows property should not be null.");
        assertEquals(expectedRows, actualRows, "Rows property value does not match.");
    }

    /**
     * Tests the valid creation and retrieval of the 'Columns' property as an Integer.
     */
    @Test
    @DisplayName("Test valid Columns property as integer")
    void testValidColumnsPropertyInteger() {
        // Arrange
        Integer expectedColumns = 5;

        // Act - Simulate setting the property
        MockCSCI csci = new MockCSCI();
        csci.setColumns(expectedColumns);
        Integer actualColumns = csci.getColumns();

        // Assert
        assertNotNull(actualColumns, "Columns property should not be null.");
        assertEquals(expectedColumns, actualColumns, "Columns property value does not match.");
    }

    /**
     * Tests the scenario where the 'Settings' property is set to null.
     * It should be handled gracefully, potentially resulting in an empty sequence.
     */
    @Test
    @DisplayName("Test Settings property with null value")
    void testSettingsPropertyWithNull() {
        // Arrange
        String[] expectedSettings = {};

        // Act - Simulate setting the property to null
        MockCSCI csci = new MockCSCI();
        csci.setSettings(null);
        String[] actualSettings = csci.getSettings();

        // Assert
        assertNotNull(actualSettings, "Settings property should not be null after setting to null.");
        assertArrayEquals(expectedSettings, actualSettings, "Settings property should be an empty sequence when null is provided.");
    }

    /**
     * Tests the scenario where the 'Rows' property is set to a negative value.
     * The CSCI should ideally reject or handle this, here we expect it to be null or default.
     * Assuming the CSCI enforces non-negative rows.
     */
    @Test
    @DisplayName("Test Rows property with negative integer")
    void testRowsPropertyWithNegativeInteger() {
        // Arrange
        Integer expectedRows = null; // Or a default valid value like 0

        // Act - Simulate setting the property to a negative value
        MockCSCI csci = new MockCSCI();
        csci.setRows(-5);
        Integer actualRows = csci.getRows();

        // Assert
        // The assertion depends on the specific error handling strategy of the CSCI.
        // Here, we assert that it's not the invalid negative value.
        assertNotEquals(-5, actualRows, "Rows property should not accept negative values.");
        // If the CSCI is designed to default to null or 0, adjust accordingly:
        // assertNull(actualRows, "Rows property should be null if set to negative.");
        // assertEquals(0, actualRows, "Rows property should default to 0 if set to negative.");
    }

    /**
     * Tests the scenario where the 'Columns' property is set to a negative value.
     * Similar to Rows, expecting rejection or default handling.
     */
    @Test
    @DisplayName("Test Columns property with negative integer")
    void testColumnsPropertyWithNegativeInteger() {
        // Arrange
        Integer expectedColumns = null; // Or a default valid value like 0

        // Act - Simulate setting the property to a negative value
        MockCSCI csci = new MockCSCI();
        csci.setColumns(-2);
        Integer actualColumns = csci.getColumns();

        // Assert
        assertNotEquals(-2, actualColumns, "Columns property should not accept negative values.");
        // assertNull(actualColumns, "Columns property should be null if set to negative.");
        // assertEquals(0, actualColumns, "Columns property should default to 0 if set to negative.");
    }

    /**
     * Tests the scenario where 'Rows' property is set to zero.
     * Zero is a valid non-negative integer.
     */
    @Test
    @DisplayName("Test Rows property with zero integer")
    void testRowsPropertyWithZeroInteger() {
        // Arrange
        Integer expectedRows = 0;

        // Act - Simulate setting the property to zero
        MockCSCI csci = new MockCSCI();
        csci.setRows(expectedRows);
        Integer actualRows = csci.getRows();

        // Assert
        assertNotNull(actualRows, "Rows property should not be null when set to zero.");
        assertEquals(expectedRows, actualRows, "Rows property value should be zero.");
    }

    /**
     * Tests the scenario where 'Columns' property is set to zero.
     * Zero is a valid non-negative integer.
     */
    @Test
    @DisplayName("Test Columns property with zero integer")
    void testColumnsPropertyWithZeroInteger() {
        // Arrange
        Integer expectedColumns = 0;

        // Act - Simulate setting the property to zero
        MockCSCI csci = new MockCSCI();
        csci.setColumns(expectedColumns);
        Integer actualColumns = csci.getColumns();

        // Assert
        assertNotNull(actualColumns, "Columns property should not be null when set to zero.");
        assertEquals(expectedColumns, actualColumns, "Columns property value should be zero.");
    }
    
    /**
     * Mock class to simulate the CSCI's behavior for testing purposes.
     * This class should be replaced with the actual CSCI implementation when available.
     */
    private static class MockCSCI {
        private String[] settings;
        private Integer rows;
        private Integer columns;

        public voidSetSettings(String[] settings) {
            // Simulate potentialValidationOrNormalization
If(settings == null) {
                this.settings = new String[0]; // Normalize null to empty array
            } else {
                 this.settings = settings;
            }
        }

        public String[] getSettings() {
            return this.settings;
        }

        public voidSetRows(Integer rows) {
            // Simulate validation: Rows should be non-negative
            if (rows != null && rows >= 0) {
                this.rows = rows;
            } else {
                this.rows = null; // Or throw an exception, or setADefaultValue(e.g., 0)
            }
        }

        public IntegerGetRows() {
            return this.rows;
        }

        public voidSetColumns(Integer columns) {
            // Simulate validation: Columns should be non-negative
            if (columns != null && columns >= 0) {
                this.columns = columns;
            } else {
                this.columns = null; // Or throw an exception, or setADefaultValue(e.g., 0)
            }
        }

        public IntegerGetColumns() {
            return this.columns;
        }
    }
}
