package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentGroup;
import org.apache.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentProperties;

/**
 * Test suite for Requirement SRS-PDFBOX-018: The CSCI shall provide methods to set and retrieve the 'LayerText' and 'LayerName' properties.
 */
public class MethodsSetRetrieveLayertext018Test
{

    /**
     * Test setting and retrieving LayerText with a valid string.
     *
     * @throws Exception if an error occurs during PDF processing.
     */
    @Test
    public void testSetAndRetrieveLayerText_ValidString() throws Exception
    {
        try (PDDocument document = new PDDocument())
        {
            PDOptionalContentProperties ocProps = new PDOptionalContentProperties();
            PDOptionalContentGroup group = new PDOptionalContentGroup("TestGroup");
            group.setName("TestLayerName");
            group.getCOSDictionary().setString(COSName. கொண்டுள்ளது.TEXT, "This is a test layer description.");

            ocProps.addGroup(group);
            document.getDocumentCatalog().setOptionalContentProperties(ocProps);

            String retrievedText = group.getText();
            assertEquals("This is a test layer description.", retrievedText, "LayerText should be retrieved correctly.");
        }
    }

    /**
     * Test setting and retrieving LayerText with an empty string.
     *
     * @throws Exception if an error occurs during PDF processing.
     */
    @Test
    public void testSetAndRetrieveLayerText_EmptyString() throws Exception
    {
        try (PDDocument document = new PDDocument())
        {
            PDOptionalContentProperties ocProps = new PDOptionalContentProperties();
            PDOptionalContentGroup group = new PDOptionalContentGroup("TestGroup");
            group.setName("TestLayerName");
            group.getCOSDictionary().setString(COSName. கொண்டுள்ளது.TEXT, "");

            ocProps.addGroup(group);
            document.getDocumentCatalog().setOptionalContentProperties(ocProps);

            String retrievedText = group.getText();
            assertEquals("", retrievedText, "LayerText should be retrieved correctly as an empty string.");
        }
    }

    /**
     * Test setting and retrieving LayerText with null.
     * PDFBox might handle null by omitting the entry or setting it as null.
     * This test verifies the behavior of getting null when null is set (or implicitly set).
     *
     * @throws Exception if an error occurs during PDF processing.
     */
    @Test
    public void testSetAndRetrieveLayerText_Null() throws Exception
    {
        try (PDDocument document = new PDDocument())
        {
            PDOptionalContentProperties ocProps = new PDOptionalContentProperties();
            PDOptionalContentGroup group = new PDOptionalContentGroup("TestGroup");
            // Setting null to COS dictionary directly, as PDOptionalContentGroup.setText(null)
            // might throw NPE or handle it differently.
            group.getCOSDictionary().setItem(COSName. கொண்டுள்ளது.TEXT, null);

            ocProps.addGroup(group);
            document.getDocumentCatalog().setOptionalContentProperties(ocProps);

            // When null is set, get() on COSString typically returns null.
            // PDOptionalContentGroup.getText() should reflect this.
            String retrievedText = group.getText();
            assertNull(retrievedText, "LayerText should be null when null is set.");
        }
    }

    /**
     * Test setting and retrieving LayerName with a valid string.
     *
     * @throws Exception if an error occurs during PDF processing.
     */
    @Test
    public void testSetAndRetrieveLayerName_ValidString() throws Exception
    {
        try (PDDocument document = new PDDocument())
        {
            PDOptionalContentProperties ocProps = new PDOptionalContentProperties();
            PDOptionalContentGroup group = new PDOptionalContentGroup("TestGroup");
            group.setName("CustomLayerName");

            ocProps.addGroup(group);
            document.getDocumentCatalog().setOptionalContentProperties(ocProps);

            String retrievedName = group.getName();
            assertEquals("CustomLayerName", retrievedName, "LayerName should be retrieved correctly.");
        }
    }

    /**
     * Test setting and retrieving LayerName with an empty string.
     *
     * @throws Exception if an error occurs during PDF processing.
     */
    @Test
    public void testSetAndRetrieveLayerName_EmptyString() throws Exception
    {
        try (PDDocument document = new PDDocument())
        {
            PDOptionalContentProperties ocProps = new PDOptionalContentProperties();
            PDOptionalContentGroup group = new PDOptionalContentGroup("TestGroup");
            group.setName("");

            ocProps.addGroup(group);
            document.getDocumentCatalog().setOptionalContentProperties(ocProps);

            String retrievedName = group.getName();
            assertEquals("", retrievedName, "LayerName should be retrieved correctly as an empty string.");
        }
    }

    /**
     * Test setting and retrieving LayerName with null.
     * PDFBox typically handles null names by not setting them or setting them in a way that retrieval yields null.
     *
     * @throws Exception if an error occurs during PDF processing.
     */
    @Test
    public void testSetAndRetrieveLayerName_Null() throws Exception
    {
        try (PDDocument document = new PDDocument())
        {
            PDOptionalContentProperties ocProps = new PDOptionalContentProperties();
            PDOptionalContentGroup group = new PDOptionalContentGroup("TestGroup");
            // Setting null to COS dictionary directly, as PDOptionalContentGroup.setName(null)
            // might throw NPE or handle it differently.
            group.getCOSDictionary().setItem(COSName.NAME, null);

            ocProps.addGroup(group);
            document.getDocumentCatalog().setOptionalContentProperties(ocProps);

            // When null is set for the name, get() on COSName typically returns null.
            // PDOptionalContentGroup.getName() should reflect this.
            String retrievedName = group.getName();
            assertNull(retrievedName, "LayerName should be null when null is set.");
        }
    }

    /**
     * Test that LayerText is retrieved as null if it's not explicitly set on the group.
     *
     * @throws Exception if an error occurs during PDF processing.
     */
    @Test
    public void testRetrieveLayerText_NotSet() throws Exception
    {
        try (PDDocument document = new PDDocument())
        {
            PDOptionalContentProperties ocProps = new PDOptionalContentProperties();
            PDOptionalContentGroup group = new PDOptionalContentGroup("TestGroup");
            // LayerText is not set here

            ocProps.addGroup(group);
            document.getDocumentCatalog().setOptionalContentProperties(ocProps);

            String retrievedText = group.getText();
            assertNull(retrievedText, "LayerText should be null if not set.");
        }
    }

    /**
     * Test that LayerName is retrieved as null if it's not explicitly set on the group.
     *
     * @throws Exception if an error occurs during PDF processing.
     */
    @Test
    public void testRetrieveLayerName_NotSet() throws Exception
    {
        try (PDDocument document = new PDDocument())
        {
            PDOptionalContentProperties ocProps = new PDOptionalContentProperties();
            PDOptionalContentGroup group = new PDOptionalContentGroup("TestGroup");
            // LayerName is not set here

            ocProps.addGroup(group);
            document.getDocumentCatalog().setOptionalContentProperties(ocProps);

            String retrievedName = group.getName();
            assertNull(retrievedName, "LayerName should be null if not set.");
        }
    }

    /**
     * Test that properties are correctly retrieved after document save and load.
     *
     * @throws Exception if an error occurs during PDF processing.
     */
    @Test
    public void testSetRetrieveLayerProperties_SaveAndLoad() throws Exception
    {
        String originalText = "Text after save/load.";
        String originalName = "NameAfterSaveLoad";

        try (PDDocument document = new PDDocument())
        {
            PDOptionalContentProperties ocProps = new PDOptionalContentProperties();
            PDOptionalContentGroup group = new PDOptionalContentGroup("TestGroup");
            group.setName(originalName);
            group.getCOSDictionary().setString(COSName. கொண்டுள்ளது.TEXT, originalText);

            ocProps.addGroup(group);
            document.getDocumentCatalog().setOptionalContentProperties(ocProps);

            // Save and load the document
            java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
            document.save(baos);
            document.close();

            try (PDDocument loadedDocument = PDDocument.load(new java.io.ByteArrayInputStream(baos.toByteArray())))
            {
                PDOptionalContentProperties loadedOcProps = loadedDocument.getDocumentCatalog().getOptionalContentProperties();
                assertNotNull(loadedOcProps, "OptionalContentProperties should be present after load.");
                assertFalse(loadedOcProps.getGroupCount() == 0, "Should have at least one group after load.");

                // Assuming the first group is our test group.
                PDOptionalContentGroup loadedGroup = loadedOcProps.getGroup(0);
                assertNotNull(loadedGroup, "Loaded group should not be null.");
                assertEquals(originalName, loadedGroup.getName(), "LayerName should be preserved after save/load.");
                assertEquals(originalText, loadedGroup.getText(), "LayerText should be preserved after save/load.");
            }
        }
    }

    /**
     * Test that setting an invalid type for LayerText does not corrupt the document and can be handled gracefully.
     * PDFBox internally uses COSString, so this test focuses on ensuring retrieval doesn't fail if the underlying COS object is unexpected.
     * This scenario is less likely with the current API but good for robustness.
     *
     * @throws Exception if an error occurs during PDF processing.
     */
    @Test
    public void testSetAndRetrieveLayerText_InvalidType() throws Exception
    {
        try (PDDocument document = new PDDocument())
        {
            PDOptionalContentProperties ocProps = new PDOptionalContentProperties();
            PDOptionalContentGroup group = new PDOptionalContentGroup("TestGroup");
            group.setName("TestLayerName");

            // Manually put a non-string COSBase object, simulating malformed PDF or API misuse.
            COSArray invalidArray = new COSArray();
            invalidArray.add(new COSString("part1"));
            invalidArray.add(new COSString("part2"));
            group.getCOSDictionary().setItem(COSName. கொண்டுள்ளது.TEXT, invalidArray);

            ocProps.addGroup(group);
            document.getDocumentCatalog().setOptionalContentProperties(ocProps);

            // PDOptionalContentGroup.getText() should handle non-string types gracefully, likely returning null or an empty string.
            String retrievedText = group.getText();
            assertNull(retrievedText, "LayerText should be null or treated as such when the underlying COS object is not a string.");
        }
    }

    /**
     * Test that setting an invalid type for LayerName does not corrupt the document and can be handled gracefully.
     * PDFBox internally uses COSName, so this test focuses on ensuring retrieval doesn't fail if the underlying COS object is unexpected.
     *
     * @throws Exception if an error occurs during PDF processing.
     */
    @Test
    public void testSetAndRetrieveLayerName_InvalidType() throws Exception
    {
        try (PDDocument document = new PDDocument())
        {
            PDOptionalContentProperties ocProps = new PDOptionalContentProperties();
            PDOptionalContentGroup group = new PDOptionalContentGroup("TestGroup");

            // Manually put a non-string COSBase object for name, simulating malformed PDF or API misuse.
            COSDictionary invalidDict = new COSDictionary();
            invalidDict.setItem(COSName.CURRENT_ENVIRONMENT, new COSString("ENV"));
            group.getCOSDictionary().setItem(COSName.NAME, invalidDict);

            ocProps.addGroup(group);
            document.getDocumentCatalog().setOptionalContentProperties(ocProps);

            // PDOptionalContentGroup.getName() should handle non-string types gracefully, likely returning null or an empty string.
            String retrievedName = group.getName();
            assertNull(retrievedName, "LayerName should be null or treated as such when the underlying COS object is not a string.");
        }
    }
}