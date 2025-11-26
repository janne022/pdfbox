package org.apache.pdfbox.test.generated;

import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionJavaScript;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for Requirement SRS-PDFBOX-017: The CSCI shall provide mechanisms to set and retrieve the 'jobID' property for Job types.
 */
public class MechanismsSetRetrieveJobid017Test {

    private PDDocument document;

    /**
     * Sets up the test environment before each test method.
     * Creates a new PDF document.
     */
    @BeforeEach
    void setUp() throws IOException {
        document = new PDDocument();
        // A document needs at least one page to be saved, though not strictly necessary for this test
        PDPage page = new PDPage(PDRectangle.A4);
        document.addPage(page);
    }

    /**
     * Cleans up the test environment after each test method.
     * Closes the PDF document.
     */
    @AfterEach
    void tearDown() throws IOException {
        if (document != null) {
            document.close();
        }
    }

    /**
     * Tests setting and retrieving a valid integer jobID.
     */
    @Test
    void testSetRetrieveValidIntegerJobID() {
        // Given a PDDocument
        // When we set a valid integer jobID
        String jobIDValue = "12345";
        document.setJobID(jobIDValue);

        // Then retrieving the jobID should return the same value
        assertEquals(jobIDValue, document.getJobID(), "Retrieved jobID should match the set value.");
    }

    /**
     * Tests setting and retrieving a jobID with special characters.
     */
    @Test
    void testSetRetrieveJobIDWithSpecialCharacters() {
        // Given a PDDocument
        // When we set a jobID with special characters
        String jobIDValue = "job-abc-789!@#$";
        document.setJobID(jobIDValue);

        // Then retrieving the jobID should return the same value
        assertEquals(jobIDValue, document.getJobID(), "Retrieved jobID with special characters should match the set value.");
    }

    /**
     * Tests setting and retrieving an empty string for jobID.
     */
    @Test
    void testSetRetrieveEmptyStringJobID() {
        // Given a PDDocument
        // When we set an empty string as the jobID
        String jobIDValue = "";
        document.setJobID(jobIDValue);

        // Then retrieving the jobID should return an empty string
        assertEquals(jobIDValue, document.getJobID(), "Retrieved jobID should be an empty string.");
    }

    /**
     * Tests setting and retrieving null for jobID.
     * According to PDF spec for JobID, it should be a String, null is not explicitly disallowed, but should be handled.
     */
    @Test
    void testSetRetrieveNullJobID() {
        // Given a PDDocument
        // When we set null as the jobID
        document.setJobID(null);

        // Then retrieving the jobID should return null
        assertNull(document.getJobID(), "Retrieved jobID should be null.");
    }

    /**
     * Tests that setting a very long jobID does not cause issues.
     * While there might be practical limits, this tests if the mechanism itself breaks.
     */
    @Test
    void testSetRetrieveVeryLongJobID() {
        // Given a PDDocument
        // When we set a very long jobID
        StringBuilder longJobIDBuilder = new StringBuilder();
        for (int i = 0; i < 2000; i++) { // Significantly longer than typical IDs
            longJobIDBuilder.append('a');
        }
        String jobIDValue = longJobIDBuilder.toString();
        document.setJobID(jobIDValue);

        // Then retrieving the jobID should return the original long string
        assertEquals(jobIDValue, document.getJobID(), "Retrieved very long jobID should match the set value.");
    }

    /**
     * Tests that the jobID property is independent across different documents.
     */
    @Test
    void testJobIDIndependenceBetweenDocuments() throws IOException {
        // Given two different PDDocuments
        PDDocument document1 = new PDDocument();
        PDDocument document2 = new PDDocument();

        // When jobIDs are set differently on each document
        String jobID1 = "doc1-job-id";
        String jobID2 = "doc2-job-id";
        document1.setJobID(jobID1);
        document2.setJobID(jobID2);

        // Then retrieving jobIDs should return their respective values
        assertEquals(jobID1, document1.getJobID(), "Document 1 jobID mismatch.");
        assertEquals(jobID2, document2.getJobID(), "Document 2 jobID mismatch.");

        // Cleanup
        document1.close();
        document2.close();
    }

    /**
     * Tests that the jobID property is initially null or empty when a document is created.
     */
    @Test
    void testInitialJobIDState() {
        // Given a newly created PDDocument
        PDDocument newDocument = new PDDocument();

        // Then the jobID should be null (or empty depending on implementation detail, null is more common for unset properties)
        assertNull(newDocument.getJobID(), "Newly created document should have a null jobID.");

        // Cleanup
        try {
            newDocument.close();
        } catch (IOException e) {
            fail("Failed to close document: " + e.getMessage());
        }
    }
}