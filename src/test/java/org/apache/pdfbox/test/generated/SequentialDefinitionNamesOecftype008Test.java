package org.apache.pdfbox.test.generated;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

/**
 * Test suite for SRS-PDFBOX-008: The CSCI shall support the sequential definition of names for OECFType.
 */
public class SequentialDefinitionNamesOecftype008Test {

    /**
     * Tests the sequential definition of names for OECFType when adding multiple fields.
     * This covers the positive scenario where names are expected to be generated sequentially.
     * 
     * @throws IOException If there is an error processing the PDF document.
     */
    @Test publicVoidTestSequentialNamingPositive() throws IOException {
        try (PDDocument document = new PDDocument()) {
            PDAcroForm acroForm = new PDAcroForm(document);
            document.getDocumentCatalog().setAcroForm(acroForm);

            // Add fields and verify sequential naming
            String fieldName1 = "OECFType";
            PDField field1 = PDField.createTextField(document, acroForm, fieldName1);
            acroForm.addField(field1);
            assertEquals(fieldName1, field1.getPartialName(), "First field name should match defined name.");

            String fieldName2 = "OECFType"; // Same base name for sequential generation
            PDField field2 = PDField.createTextField(document, acroForm, fieldName2);
            acroForm.addField(field2);
            // PDFBox typically appends a number to duplicate names, e.g., OECFType1
            assertTrue(field2.getPartialName().startsWith(fieldName2), "Second field name should start with OECFType.");
            assertTrue(field2.getPartialName().length() > fieldName2.length(), "Second field name should be extended sequentially.");
            assertTrue(field2.getPartialName().matches(fieldName2 + "d+"), "Second field name should follow OECFTypeN pattern.");
            
            String fieldName3 = "OECFType"; 
            PDField field3 = PDField.createTextField(document, acroForm, fieldName3);
            acroForm.addField(field3);
            assertTrue(field3.getPartialName().startsWith(fieldName2), "Third field name should start with OECFType.");
            assertTrue(field3.getPartialName().length() > fieldName2.length(), "Third field name should be extended sequentially.");
            assertTrue(field3.getPartialName().matches(fieldName2 + "d+"), "Third field name should follow OECFTypeN pattern with incremented number.");
            assertNotEquals(field2.getPartialName(), field3.getPartialName(), "Third field name should be different from the second.");
        }
    }

    /**
     * Tests the scenario where fields are added with already existing sequential names, 
     * expecting valid generation of new sequential names.
     * 
     * @throws IOException If there is an error processing the PDF document.
     */
    @Test publicVoidTestSequentialNamingWithExistingSequences() throws IOException {
        try (PDDocument document = new PDDocument()) {
            PDAcroForm acroForm = new PDAcroForm(document);
            document.getDocumentCatalog().setAcroForm(acroForm);

            // Pre-populate with some fields to establish a sequence
            String baseName = "OECFType";
            for (int i = 1; i <= 3; i++) {
                PDField field = PDField.createTextField(document, acroForm, baseName);
                acroForm.addField(field);
                assertEquals(baseName + i, field.getPartialName(), "Pre-populated field name incorrect.");
            }

            // Add a new field with the same base name, expecting it to continue the sequence
            PDField newField = PDField.createTextField(document, acroForm, baseName);
            acroForm.addField(newField);
            assertEquals(baseName + 4, newField.getPartialName(), "New field should continue the sequence.");
        }
    }

    /**
     * Tests adding a field with a null name, expecting an IllegalArgumentException.
     * This is a negative scenario to ensure robustness.
     */
    @Test publicVoidTestAddNullFieldNameNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            try (PDDocument document = new PDDocument()) {
                PDAcroForm acroForm = new PDAcroForm(document);
                document.getDocumentCatalog().setAcroForm(acroForm);
                PDField.createTextField(document, acroForm, null);
            } catch (IOException e) {
                // Catching IOException to satisfy the method signature, though not expected here.
                fail("IOException should not occur for null field name test.");
            }
        }, "Adding a field with a null name should throw IllegalArgumentException.");
    }

     /**
     * Tests adding a field with an empty string name, expecting an IllegalArgumentException.
     * This is a negative scenario to ensure robustness.
     */
    @Test publicVoidTestAddEmptyFieldNameNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            try (PDDocument document = new PDDocument()) {
                PDAcroForm acroForm = new PDAcroForm(document);
                document.getDocumentCatalog().setAcroForm(acroForm);
                PDField.createTextField(document, acroForm, "");
            } catch (IOException e) {
                // Catching IOException to satisfy the method signature, though not expected here.
                fail("IOException should not occur for empty field name test.");
            }
        }, "Adding a field with an empty name should throw IllegalArgumentException.");
    }

    /**
     * Tests adding a field with a name that already exists and is NOT part of a sequential name.
     * This verifies that the system correctly handles non-sequential name collisions.
     * 
     * @throws IOException If there is an error processing the PDF document.
     */
    @Test publicVoidTestAddConflictingNonSequentialName() throws IOException {
        try (PDDocument document = new PDDocument()) {
            PDAcroForm acroForm = new PDAcroForm(document);
            document.getDocumentCatalog().setAcroForm(acroForm);

            String existingName = "UniqueFieldName";
            PDField field1 = PDField.createTextField(document, acroForm, existingName);
            acroForm.addField(field1);
            assertEquals(existingName, field1.getPartialName(), "First field name should be unique.");

            // Attempt to add another field with the exact same unique name
            PDField field2 = PDField.createTextField(document, acroForm, existingName);
            acroForm.addField(field2);
            
            // When adding a field that conflicts with a non-sequential name, PDFBox usually appends digits.
            // We expect it to append a number, not to use the exact same name.
            assertNotEquals(existingName, field2.getPartialName(), "Second field name should not be identical to the first unique name.");
            assertTrue(field2.getPartialName().startsWith(existingName), "Second field name should start with the original name.");
            assertTrue(field2.getPartialName().matches(existingName + "d+"), "Second field name should follow the UniqueFieldNameN pattern.");
        }
    }

    /**
     * Tests that the field name generation correctly avoids overwriting existing fields when 
     * sequential naming is triggered.
     *
     * @throws IOException If there is an error processing the PDF document.
     */
    @Test publicVoidTestSequentialNamingAvoidsOverwrite() throws IOException {
        try (PDDocument document = new PDDocument()) {
            PDAcroForm acroForm = new PDAcroForm(document);
            document.getDocumentCatalog().setAcroForm(acroForm);

            String baseName = "TestField";
            
            // Create a field first that would be the target of sequential naming
            PDField existingSequentialNameField = PDField.createTextField(document, acroForm, baseName);
            acroForm.addField(existingSequentialNameField);
            assertEquals(baseName + "1", existingSequentialNameField.getPartialName(), "Initially created field name is incorrect.");

            // Now attempt to add a field that *would* have been named 'TestField1' normally, 
            // but since 'TestField1' already exists, it should generate a new sequential name.
            PDField newField = PDField.createTextField(document, acroForm, baseName);
            acroForm.addField(newField);

            // The newFieldShouldHaveANameLikeTestField2
AssertTrue(newField.getPartialName().startsWith(baseName), "New field should start with the base name.");
            assertTrue(newField.getPartialName().matches(baseName + "d+"), "New field should have a sequential name.");
            assertNotEquals(existingSequentialNameField.getPartialName(), newField.getPartialName(), "New field name should be different from the existing sequential name.");
            assertEquals(baseName + "2", newField.getPartialName(), "New field should have the next sequential name.");
        }
    }
}
