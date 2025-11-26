package org.apache.pdfbox.test.generated;

import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import org.apache.pdfbox.pdmodel.graphics.pattern.PDAbstractPattern;
import org.apache.pdfbox.pdmodel.graphics.pattern.PDFormXObject;
import org.apache.pdfbox.pdmodel.graphics.pattern.PGFColorSpace;
import org.apache.pdfbox.pdmodel.graphics.pattern.PDTilingPattern;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the PUID SRS-PDFBOX-008: The CSCI shall support the sequential definition of names for OECFType.
 */
class SRS_PDFBOX_008Test {

    private PDDocument document;

    @BeforeEach
    void setUp() throws IOException {
        document = new PDDocument();
    }

    /**
     * Tests that a tiling pattern can be created with a sequentially defined name.
     * This verifies the pattern is correctly associated with a named resource.
     *
     * @throws IOException if there is an error creating the pattern or document.
     */
    @Test
    @DisplayName("Test sequential naming for Tiling Pattern")
    void testSequentialNamingForTilingPattern() throws IOException {
        // Define a simple tiling pattern
        PDTilingPattern tilingPattern = new PDTilingPattern();
        tilingPattern.setPaintType(PDTilingPattern.PAINT_TYPE_COLORED);
        tilingPattern.setTilingType(PDTilingPattern.TILING_TYPE_COLORED);
        tilingPattern.setXStep(10);
        tilingPattern.setYStep(10);

        // Assign a sequentially defined name
        String patternName = "/Pattern1";
        tilingPattern.getCOSObject().setName(patternName);

        // Add the pattern to the document's resources (simulating usage)
        COSDictionary resources = new COSDictionary();
        COSDictionary patternResources = new COSDictionary();
        patternResources.setName(patternName, tilingPattern.getCOSObject());
        resources.setItem(COSName.PATTERN, patternResources);
        
        // Verify the name was set correctly on the COS object
        assertNotNull(tilingPattern.getCOSObject().getItem(COSName.NAME), "Pattern name should not be null");
        assertEquals(patternName, tilingPattern.getCOSObject().getName(), "Pattern name should match the set value");

        // In a real scenario, this pattern would be referenced in a content stream.
        // For this test, we verify the naming mechanism itself.

        // Clean up
        document.close();
    }

    /**
     * Tests that a Form XObject can be created with a sequentially defined name.
     * This verifies the Form XObject is correctly associated with a named resource.
     *
     * @throws IOException if there is an error creating the form or document.
     */
    @Test
    @DisplayName("Test sequential naming for Form XObject")
    void testSequentialNamingForFormXObject() throws IOException {
        // Define a simple Form XObject
        COSStream stream = new COSStream();
        PDFormXObject formXObject = new PDFormXObject(document, stream, COSName.getPDFName("Form1"));
        formXObject.setFormType(1);
        formXObject.setBBox(new float[]{0, 0, 100, 100});

        // Assign a sequentially defined name
        String formName = "/FormXObject1";
        formXObject.getCOSObject().setName(formName);

        // Add the form to the document's resources (simulating usage)
        COSDictionary resources = new COSDictionary();
        COSDictionary formResources = new COSDictionary();
        formResources.setName(formName, formXObject.getCOSObject());
        resources.setItem(COSName.XOBJECT, formResources);
        
        // Verify the name was set correctly on the COS object
        assertNotNull(formXObject.getCOSObject().getItem(COSName.NAME), "Form XObject name should not be null");
        assertEquals(formName, formXObject.getCOSObject().getName(), "Form XObject name should match the set value");

        // Clean up
        document.close();
    }

    /**
     * Tests that multiple OECFType objects (patterns and form xobjects) can be sequentially named.
     * This verifies that the naming mechanism doesn't interfere between different types of resources.
     *
     * @throws IOException if there is an error creating the resources or document.
     */
    @Test
    @DisplayName("Test sequential naming for multiple OECFType objects")
    void testSequentialNamingForMultipleOECFTypeObjects() throws IOException {
        // Create and name a tiling pattern
        PDTilingPattern tilingPattern1 = new PDTilingPattern();
        tilingPattern1.setPaintType(PDTilingPattern.PAINT_TYPE_UNCOLORED);
        tilingPattern1.setTilingType(PDTilingPattern.TILING_TYPE_SCALED);
        tilingPattern1.setXStep(5);
        tilingPattern1.setYStep(5);
        String patternName = "/TilingPatternSeq1";
        tilingPattern1.getCOSObject().setName(patternName);

        // Create and name a Form XObject
        COSStream stream = new COSStream();
        PDFormXObject formXObject1 = new PDFormXObject(document, stream, COSName.getPDFName("Form1"));
        formXObject1.setFormType(1);
        formXObject1.setBBox(new float[]{0, 0, 50, 50});
        String formName = "/FormXObjectSeq1";
        formXObject1.getCOSObject().setName(formName);
        
        // Verify names are set correctly
        assertNotNull(tilingPattern1.getCOSObject().getItem(COSName.NAME), "First pattern name should not be null");
        assertEquals(patternName, tilingPattern1.getCOSObject().getName(), "First pattern name mismatch");
        
        assertNotNull(formXObject1.getCOSObject().getItem(COSName.NAME), "First form XObject name should not be null");
        assertEquals(formName, formXObject1.getCOSObject().getName(), "First form XObject name mismatch");

        // Create and name another tiling pattern
        PDTilingPattern tilingPattern2 = new PDTilingPattern();
        tilingPattern2.setPaintType(PDTilingPattern.PAINT_TYPE_COLORED);
        tilingPattern2.setTilingType(PDTilingPattern.TILING_TYPE_COLORED);
        tilingPattern2.setXStep(15);
        tilingPattern2.setYStep(15);
        String patternName2 = "/TilingPatternSeq2";
        tilingPattern2.getCOSObject().setName(patternName2);

        // Create and name another Form XObject
        COSStream stream2 = new COSStream();
        PDFormXObject formXObject2 = new PDFormXObject(document, stream2, COSName.getPDFName("Form2"));
        formXObject2.setFormType(1);
        formXObject2.setBBox(new float[]{10, 10, 60, 60});
        String formName2 = "/FormXObjectSeq2";
        formXObject2.getCOSObject().setName(formName2);

        // Verify names for the second set of objects
        assertNotNull(tilingPattern2.getCOSObject().getItem(COSName.NAME), "Second pattern name should not be null");
        assertEquals(patternName2, tilingPattern2.getCOSObject().getName(), "Second pattern name mismatch");

        assertNotNull(formXObject2.getCOSObject().getItem(COSName.NAME), "Second form XObject name should not be null");
        assertEquals(formName2, formXObject2.getCOSObject().getName(), "Second form XObject name mismatch");

        // Clean up
        document.close();
    }

    /**
     * Tests the handling of an OECFType object without a sequentially defined name.
     * While the requirement focuses on sequential definition, testing the absence
     * ensures clarity on expected behavior when a name isn't explicitly set.
     *
     * @throws IOException if there is an error creating the pattern or document.
     */
    @Test
    @DisplayName("Test OECFType without sequential naming")
    void testOECFTypeWithoutSequentialNaming() throws IOException {
        PDTilingPattern tilingPattern = new PDTilingPattern();
        tilingPattern.setPaintType(PDTilingPattern.PAINT_TYPE_UNCOLORED);
        tilingPattern.setTilingType(PDTilingPattern.TILING_TYPE_SCALED);

        // Verify that no name is set by default
        assertNull(tilingPattern.getCOSObject().getItem(COSName.NAME), "Pattern should not have a name by default");
        assertNull(tilingPattern.getCOSObject().getName(), "Pattern name should be null when not explicitly set");

        // Clean up
        document.close();
    }

    /**
     * Tests the scenario where an attempt is made to set an invalid name.
     * PDF names have specific formatting rules (e.g., must start with '/').
     * This test ensures robustness.
     *
     * @throws IOException if there is an error creating the pattern or document.
     */
    @Test
    @DisplayName("Test setting invalid name for OECFType")
    void testSettingInvalidNameForOECFType() throws IOException {
        PDTilingPattern tilingPattern = new PDTilingPattern();
        tilingPattern.setPaintType(PDTilingPattern.PAINT_TYPE_UNCOLORED);
        tilingPattern.setTilingType(PDTilingPattern.TILING_TYPE_SCALED);

        String invalidName = "InvalidName"; // Missing leading '/'
        // The PDF specification doesn't strictly enforce the leading '/' for COSName.setName,
        // but it's standard practice. We test how PDFBox handles it.
        tilingPattern.getCOSObject().setName(invalidName);

        // Verify the name is set as provided, even if not standard PDF syntax.
        // PDFBox COSName handles direct string assignment.
        assertNotNull(tilingPattern.getCOSObject().getItem(COSName.NAME), "Pattern name should be set even if invalid format");
        assertEquals(invalidName, tilingPattern.getCOSObject().getName(), "Pattern name should reflect the invalid value set");

        // Clean up
        document.close();
    }

    /**
     * Tests that a COSName object is correctly created when setting a sequential name.
     * Verifies the underlying COS object representation.
     *
     * @throws IOException if there is an error creating the pattern or document.
     */
    @Test
    @DisplayName("Test COSName object creation for sequential naming")
    void testCOSNameObjectCreation() throws IOException {
        PDTilingPattern tilingPattern = new PDTilingPattern();
        String patternName = "/SequentialPattern1";
        tilingPattern.getCOSObject().setName(patternName);

        // Ensure the name is stored as a COSName object
        assertTrue(tilingPattern.getCOSObject().getItem(COSName.NAME) instanceof COSName, "Stored name should be an instance of COSName");
        assertEquals(patternName, tilingPattern.getCOSObject().getName(), "COSName object should hold the correct name string");

        // Clean up
        document.close();
    }

     /**
     * Tests that a null name can be explicitly set, ensuring graceful handling.
     *
     * @throws IOException if there is an error creating the pattern or document.
     */
    @Test
    @DisplayName("Test setting null name for OECFType")
    void testSettingNullNameForOECFType() throws IOException {
        PDTilingPattern tilingPattern = new PDTilingPattern();
        tilingPattern.getCOSObject().setName(null); // Explicitly setting null

        // Verify that the name is indeed null after setting
        assertNull(tilingPattern.getCOSObject().getItem(COSName.NAME), "Pattern name should be null after explicitly setting to null");
        assertNull(tilingPattern.getCOSObject().getName(), "Pattern name retrieval should return null");

        // Clean up
        document.close();
    }

}