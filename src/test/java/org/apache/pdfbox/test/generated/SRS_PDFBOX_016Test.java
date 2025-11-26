package org.apache.pdfbox.test.generated;

import org.apache.pdfbox.pdmodel.interactive.form.PDJobType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit 5 test class for Requirement SRS-PDFBOX-016.
 * This class validates the functionality of setting and retrieving 'url' and 'name' properties for Job types.
 */
public class SRS_PDFBOX_016Test {

    /**
     * Tests setting and retrieving the 'url' property for a PDJobType with a valid URL.
     */
    @Test
    @DisplayName("Test setting and getting valid URL for PDJobType")
    void testSetAndGetValidUrl() {
        PDJobType jobType = new PDJobType();
        String expectedUrl = "http://example.com/job";

        // Set the URL property
        jobType.setUrl(expectedUrl);

        // Retrieve and assert the URL
        String actualUrl = jobType.getUrl();
        assertNotNull(actualUrl, "URL should not be null after setting.");
        assertEquals(expectedUrl, actualUrl, "Retrieved URL does not match the set URL.");
    }

    /**
     * Tests setting and retrieving the 'name' property for a PDJobType with a valid name.
     */
    @Test
    @DisplayName("Test setting and getting valid name for PDJobType")
    void testSetAndGetName() {
        PDJobType jobType = new PDJobType();
        String expectedName = "SampleJobName";

        // Set the name property
        jobType.setName(expectedName);

        // Retrieve and assert the name
        String actualName = jobType.getName();
        assertNotNull(actualName, "Name should not be null after setting.");
        assertEquals(expectedName, actualName, "Retrieved name does not match the set name.");
    }

    /**
     * Tests retrieving the 'url' property when it has not been set.
     * It should return null.
     */
    @Test
    @DisplayName("Test getting unset URL for PDJobType returns null")
    void testGetUnsetUrl() {
        PDJobType jobType = new PDJobType();

        // Retrieve the URL property when not set
        String actualUrl = jobType.getUrl();
        assertNull(actualUrl, "URL should be null when not set.");
    }

    /**
     * Tests retrieving the 'name' property when it has not been set.
     * It should return null.
     */
    @Test
    @DisplayName("Test getting unset name for PDJobType returns null")
    void testGetUnsetName() {
        PDJobType jobType = new PDJobType();

        // Retrieve the name property when not set
        String actualName = jobType.getName();
        assertNull(actualName, "Name should be null when not set.");
    }

    /**
     * Tests setting the 'url' property with an empty string.
     * The retrieved URL should be the empty string.
     */
    @Test
    @DisplayName("Test setting and getting empty string URL for PDJobType")
    void testSetAndGetEmptyUrl() {
        PDJobType jobType = new PDJobType();
        String expectedUrl = "";

        jobType.setUrl(expectedUrl);
        String actualUrl = jobType.getUrl();

        assertNotNull(actualUrl, "URL should not be null after setting an empty string.");
        assertEquals(expectedUrl, actualUrl, "Retrieved URL should be an empty string.");
    }

    /**
     * Tests setting the 'name' property with an empty string.
     * The retrieved name should be the empty string.
     */
    @Test
    @DisplayName("Test setting and getting empty string name for PDJobType")
    void testSetAndGetEmptyName() {
        PDJobType jobType = new PDJobType();
        String expectedName = "";

        jobType.setName(expectedName);
        String actualName = jobType.getName();

        assertNotNull(actualName, "Name should not be null after setting an empty string.");
        assertEquals(expectedName, actualName, "Retrieved name should be an empty string.");
    }

    /**
     * Tests setting and retrieving the 'url' property multiple times to ensure
     * the latest value is retained.
     */
    @Test
    @DisplayName("Test overwriting URL property for PDJobType")
    void testOverwriteUrl() {
        PDJobType jobType = new PDJobType();
        String firstUrl = "http://first.com";
        String secondUrl = "http://second.com";

        jobType.setUrl(firstUrl);
        assertEquals(firstUrl, jobType.getUrl(), "URL mismatch after first set.");

        jobType.setUrl(secondUrl);
        assertEquals(secondUrl, jobType.getUrl(), "URL mismatch after second set (overwrite).");
    }

    /**
     * Tests setting and retrieving the 'name' property multiple times to ensure
     * the latest value is retained.
     */
    @Test
    @DisplayName("Test overwriting name property for PDJobType")
    void testOverwriteName() {
        PDJobType jobType = new PDJobType();
        String firstName = "Job1";
        String secondName = "Job2";

        jobType.setName(firstName);
        assertEquals(firstName, jobType.getName(), "Name mismatch after first set.");

        jobType.setName(secondName);
        assertEquals(secondName, jobType.getName(), "Name mismatch after second set (overwrite).");
    }

    /**
     * Tests setting and retrieving the 'url' property with a null value.
     * Depending on implementation, this might be allowed or throw an exception.
     * Assuming null is allowed and results in null being retrieved.
     */
    @Test
    @DisplayName("Test setting and getting null URL for PDJobType")
    void testSetAndGetNullUrl() {
        PDJobType jobType = new PDJobType();
        String expectedUrl = null;

        // Set URL to null. If this were to throw an exception, catch it.
        try {
            jobType.setUrl(expectedUrl);
            // Assert that null is retrieved
            assertNull(jobType.getUrl(), "Setting URL to null should result in null retrieval.");
        } catch (Exception e) {
            fail("Setting URL to null threw an unexpected exception: " + e.getMessage());
        }
    }

    /**
     * Tests setting and retrieving the 'name' property with a null value.
     * Depending on implementation, this might be allowed or throw an exception.
     * Assuming null is allowed and results in null being retrieved.
     */
    @Test
    @DisplayName("Test setting and getting null name for PDJobType")
    void testSetAndGetNullName() {
        PDJobType jobType = new PDJobType();
        String expectedName = null;

        // Set name to null. If this were to throw an exception, catch it.
        try {
            jobType.setName(expectedName);
            // Assert that null is retrieved
            assertNull(jobType.getName(), "Setting name to null should result in null retrieval.");
        } catch (Exception e) {
            fail("Setting name to null threw an unexpected exception: " + e.getMessage());
        }
    }
}
