package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSNull;

/**
 * Test class for Requirement SRS-PDFBOX-016.
 * Verifies the mechanisms to set and retrieve 'url' and 'name' properties for Job types.
 */
public class MechanismsSetRetrieveUrl016Test {

    /**
     * Tests setting and retrieving the 'url' property for a Job type when valid data is provided.
     */
    @Test publicVoidTestSetRetrieveUrl_ValidData() {
        COSDictionary jobDictionary = new COSDictionary();
        String expectedUrl = "http://example.com/job";

        jobDictionary.setString(COSName.getPDFName("url"), expectedUrl);

        COSBase urlObject = jobDictionary.getDictionaryObject(COSName.getPDFName("url"));

        assertNotNull(urlObject, "URL object should not be null.");
        assertTrue(urlObject instanceof COSStream || urlObject instanceof COSObject, "URL object should be a COSStream or COSObject.");
        assertEquals(expectedUrl, jobDictionary.getString(COSName.getPDFName("url")), "Retrieved URL should match the set URL.");
    }

    /**
     * Tests setting and retrieving the 'name' property for a Job type when valid data is provided.
     */
    @Test publicVoidTestSetRetrieveName_ValidData() {
        COSDictionary jobDictionary = new COSDictionary();
        String expectedName = "MyTestJob";

        jobDictionary.setString(COSName.getPDFName("name"), expectedName);

        COSBase nameObject = jobDictionary.getDictionaryObject(COSName.getPDFName("name"));

        assertNotNull(nameObject, "Name object should not be null.");
        assertTrue(nameObject instanceof COSStream || nameObject instanceof COSObject, "Name object should be a COSStream or COSObject.");
        assertEquals(expectedName, jobDictionary.getString(COSName.getPDFName("name")), "Retrieved name should match the set name.");
    }

    /**
     * Tests retrieving the 'url' property when it has not been set.
     */
    @Test publicVoidTestRetrieveUrl_NotSet() {
        COSDictionary jobDictionary = new COSDictionary();
        COSBase urlObject = jobDictionary.getDictionaryObject(COSName.getPDFName("url"));

        assertNull(urlObject, "URL object should be null when not set.");
        assertEquals("", jobDictionary.getString(COSName.getPDFName("url")), "Retrieved URL should be an empty string when not set.");
    }

    /**
     * Tests retrieving the 'name' property when it has not been set.
     */
    @Test publicVoidTestRetrieveName_NotSet() {
        COSDictionary jobDictionary = new COSDictionary();
        COSBase nameObject = jobDictionary.getDictionaryObject(COSName.getPDFName("name"));

        assertNull(nameObject, "Name object should be null when not set.");
        assertEquals("", jobDictionary.getString(COSName.getPDFName("name")), "Retrieved name should be an empty string when not set.");
    }

    /**
     * Tests setting a null value for the 'url' property.
     */
    @Test publicVoidTestSetUrl_NullValue() {
        COSDictionary jobDictionary = new COSDictionary();
        jobDictionary.setItem(COSName.getPDFName("url"), COSNull.COS_NULL);

        COSBase urlObject = jobDictionary.getDictionaryObject(COSName.getPDFName("url"));

        assertNotNull(urlObject, "URL object should not be null after setting to COSNull.");
        assertTrue(urlObject instanceof COSNull, "URL object should be COSNull.");
        assertEquals("", jobDictionary.getString(COSName.getPDFName("url")), "Retrieved URL should be an empty string when COSNull is set.");
    }

    /**
     * Tests setting a null value for the 'name' property.
     */
    @Test publicVoidTestSetName_NullValue() {
        COSDictionary jobDictionary = new COSDictionary();
        jobDictionary.setItem(COSName.getPDFName("name"), COSNull.COS_NULL);

        COSBase nameObject = jobDictionary.getDictionaryObject(COSName.getPDFName("name"));

        assertNotNull(nameObject, "Name object should not be null after setting to COSNull.");
        assertTrue(nameObject instanceof COSNull, "Name object should be COSNull.");
        assertEquals("", jobDictionary.getString(COSName.getPDFName("name")), "Retrieved name should be an empty string when COSNull is set.");
    }

    /**
     * Tests overwriting an existing 'url' property.
     */
    @Test publicVoidTestOverwriteUrl() {
        COSDictionary jobDictionary = new COSDictionary();
        String initialUrl = "http://initial.com";
        String newUrl = "http://new.com";

        jobDictionary.setString(COSName.getPDFName("url"), initialUrl);
        jobDictionary.setString(COSName.getPDFName("url"), newUrl);

        assertEquals(newUrl, jobDictionary.getString(COSName.getPDFName("url")), "Overwritten URL should reflect the new value.");
    }

    /**
     * Tests overwriting an existing 'name' property.
     */
    @Test publicVoidTestOverName() {
        COSDictionary jobDictionary = new COSDictionary();
        String initialName = "InitialJobName";
        String newName = "NewJobName";

        jobDictionary.setString(COSName.getPDFName("name"), initialName);
        jobDictionary.setString(COSName.getPDFName("name"), newName);

        assertEquals(newName, jobDictionary.getString(COSName.getPDFName("name")), "Overwritten name should reflect the new value.");
    }

    /**
     * Tests retrieving a property that is not 'url' or 'name'.
     */
    @Test publicVoidTestRetrieveOtherProperty() {
        COSDictionary jobDictionary = new COSDictionary();
        String someOtherProperty = "someValue";
        String key = "otherProperty";

        jobDictionary.setString(COSName.getPDFName(key), someOtherProperty);

        COSBase otherObject = jobDictionary.getDictionaryObject(COSName.getPDFName(key));
        assertNotNull(otherObject, "Other property object should not be null.");
        assertEquals(someOtherProperty, jobDictionary.getString(COSName.getPDFName(key)), "Retrieved other property should match the set value.");

        assertNull(jobDictionary.getDictionaryObject(COSName.getPDFName("url")), "URL property should be null.");
        assertNull(jobDictionary.getDictionaryObject(COSName.getPDFName("name")), "Name property should be null.");
    }
}
