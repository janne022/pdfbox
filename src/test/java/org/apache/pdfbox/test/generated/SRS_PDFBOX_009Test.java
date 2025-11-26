package org.apache.pdfbox.test.generated;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineNode;
import org.apache.pdfbox.pdmodel.interactive.viewerpreferences.PDViewerPreferences;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for requirement SRS-PDFBOX-009: The CSCI shall support the definition of columns for OECFType.
 */
class SRS_PDFBOX_009Test {

    /**
     * Tests the successful addition and retrieval of columns to an OECF dictionary.
     * This validates the core functionality of defining columns.
     *
     * @throws IOException If there is an error processing the PDF stream.
     */
    @Test
    @DisplayName("Test adding and retrieving single column definition")
    void testAddSingleColumnDefinition() throws IOException {
        COSDictionary oecfDict = new COSDictionary();
        COSName columnName = COSName.getPDFName("Column1");
        oecfDict.setItem(columnName, new COSDictionary()); // Adding a basic column definition

        assertTrue(oecfDict.containsKey(columnName), "OECF dictionary should contain the added column name.");
        assertNotNull(oecfDict.getDictionaryObject(columnName), "The retrieved column definition should not be null.");
    }

    /**
     * Tests the definition of multiple columns within the OECF dictionary.
     * This ensures that the system can handle multiple column definitions simultaneously.
     *
     * @throws IOException If there is an error processing the PDF stream.
     */
    @Test
    @DisplayName("Test adding and retrieving multiple column definitions")
    void testAddMultipleColumnDefinitions() throws IOException {
        COSDictionary oecfDict = new COSDictionary();
        COSName column1Name = COSName.getPDFName("ColA");
        COSName column2Name = COSName.getPDFName("ColB");
        COSName column3Name = COSName.getPDFName("ColC");

        oecfDict.setItem(column1Name, new COSDictionary());
        oecfDict.setItem(column2Name, new COSDictionary());
        oecfDict.setItem(column3Name, new COSDictionary());

        assertTrue(oecfDict.containsKey(column1Name), "OECF dictionary should contain the first column.");
        assertTrue(oecfDict.containsKey(column2Name), "OECF dictionary should contain the second column.");
        assertTrue(oecfDict.containsKey(column3Name), "OECF dictionary should contain the third column.");
        assertEquals(3, oecfDict.size(), "OECF dictionary should contain exactly three columns.");
    }

    /**
     * Tests the behavior when attempting to add a column with a non-dictionary value.
     * This ensures robustness against invalid column definitions.
     *
     * @throws IOException If there is an error processing the PDF stream.
     */
    @Test
    @DisplayName("Test adding column with non-dictionary value (should be handled or rejected)")
    void testAddColumnWithInvalidValue() throws IOException {
        COSDictionary oecfDict = new COSDictionary();
        COSName invalidColumnName = COSName.getPDFName("InvalidCol");
        // In PDF, column definitions are typically dictionaries. Attempting to add a string and checking behavior.
        // PDFBox might be lenient, or might throw an error. This test assumes leniency and checks for presence.
        oecfDict.setItem(invalidColumnName, COSName.getPDFName("SomeValue")); // Using a COSName as a simple non-dictionary value

        assertTrue(oecfDict.containsKey(invalidColumnName), "OECF dictionary should contain the key even if value is not standard.");
        // Depending on strictness, one might assert it's not a dictionary or handle expected exceptions.
        // For now, we assert key presence.
    }

    /**
     * Tests the overwriting of an existing column definition.
     * This checks if existing definitions can be replaced.
     *
     * @throws IOException If there is an error processing the PDF stream.
     */
    @Test
    @DisplayName("Test overwriting an existing column definition")
    void testOverwriteColumnDefinition() throws IOException {
        COSDictionary oecfDict = new COSDictionary();
        COSName columnName = COSName.getPDFName("ColumnToOverwrite");
        COSDictionary initialDefinition = new COSDictionary();
        initialDefinition.setItem("Property1", COSName.getPDFName("Value1"));

        oecfDict.setItem(columnName, initialDefinition);

        COSDictionary newDefinition = new COSDictionary();
        newDefinition.setItem("Property2", COSName.getPDFName("Value2"));

        oecfDict.setItem(columnName, newDefinition);

        assertTrue(oecfDict.containsKey(columnName), "OECF dictionary must retain the column name after overwrite.");
        COSDictionary retrievedDefinition = oecfDict.getDictionaryObject(columnName);
        assertNotNull(retrievedDefinition, "Retrieved definition should not be null after overwrite.");
        assertFalse(retrievedDefinition.containsKey("Property1"), "Overwritten definition should not contain old properties.");
        assertTrue(retrievedDefinition.containsKey("Property2"), "Overwritten definition should contain new properties.");
        assertEquals("Value2", retrievedDefinition.getNameObject("Property2").getName(), "Overwritten definition should have the correct new property value.");
    }

    /**
     * Tests the scenario where no columns are defined.
     * This is a valid state and should not cause errors.
     *
     * @throws IOException If there is an error processing the PDF stream.
     */
    @Test
    @DisplayName("Test OECF dictionary with no columns defined")
    void testEmptyOecfDictionary() throws IOException {
        COSDictionary oecfDict = new COSDictionary();
        assertEquals(0, oecfDict.size(), "An empty OECF dictionary should have zero columns.");
        assertFalse(oecfDict.keySet().iterator().hasNext(), "Iterator for an empty OECF dictionary should indicate no elements.");
    }

    /**
     * Tests adding a column with an empty dictionary as its definition.
     * This checks if empty definitions are permitted.
     *
     * @throws IOException If there is an error processing the PDF stream.
     */
    @Test
    @DisplayName("Test adding column with an empty dictionary definition")
    void testAddColumnWithEmptyDictionaryDefinition() throws IOException {
        COSDictionary oecfDict = new COSDictionary();
        COSName columnName = COSName.getPDFName("EmptyCol");
        oecfDict.setItem(columnName, new COSDictionary()); // Adding an empty dictionary

        assertTrue(oecfDict.containsKey(columnName), "OECF dictionary should contain the column with an empty definition.");
        COSDictionary retrievedDefinition = oecfDict.getDictionaryObject(columnName);
        assertNotNull(retrievedDefinition, "Retrieved definition should not be null.");
        assertTrue(retrievedDefinition.isEmpty(), "The retrieved column definition dictionary should be empty.");
    }
}
