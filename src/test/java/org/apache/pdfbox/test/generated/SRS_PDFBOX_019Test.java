package org.apache.pdfbox.test.generated;

import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSNumber;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for Requirement SRS-PDFBOX-019 regarding the definition of structured types for Dimensions.
 */
public class SRS_PDFBOX_019Test {

    /**
     * Test case for creating a valid Dimensions structure with all properties.
     * This test verifies that a valid structured type for Dimensions can be created
     * and that its properties (unit, height, width) are correctly set and accessible.
     */
    @Test
    public void testValidDimensionsCreationAndAccess() {
        String unit = "cm";
        float height = 100.5f;
        float width = 200.75f;

        COSArray dimensionsArray = new COSArray();
        dimensionsArray.add(new COSString(unit));
        dimensionsArray.add(COSNumber.get(width));
        dimensionsArray.add(COSNumber.get(height));

        // For demonstration, we'll assume a way to represent this as a structured type.
        // In a real scenario, this would involve a domain-specific object or a PDF object representation.
        // Here, we'll simulate direct access to the COSArray components.

        assertNotNull(dimensionsArray, "COSArray for dimensions should not be null.");
        assertEquals(3, dimensionsArray.size(), "Dimensions array should contain 3 elements.");

        COSBase unitObj = dimensionsArray.getObject(0);
        COSBase widthObj = dimensionsArray.getObject(1);
        COSBase heightObj = dimensionsArray.getObject(2);

        assertTrue(unitObj instanceof COSString, "First element should be a COSString for unit.");
        assertEquals(unit, ((COSString) unitObj).getString(), "Unit should match the provided value.");

        assertTrue(widthObj instanceof COSNumber, "Second element should be a COSNumber for width.");
        assertEquals(width, ((COSNumber) widthObj).floatValue(), "Width should match the provided value.");

        assertTrue(heightObj instanceof COSNumber, "Third element should be a COSNumber for height.");
        assertEquals(height, ((COSNumber) heightObj).floatValue(), "Height should match the provided value.");
    }

    /**
     * Test case for creating a Dimensions structure with minimal required properties.
     * This test verifies that the structure can be formed even with only essential information if applicable,
     * though the requirement implies all three are part of the definition.
     * Assuming unit, height, and width are always expected for a 'Dimensions' structured type.
     */
    @Test
    public void testDimensionsWithMissingProperties() {
        // The requirement explicitly states unit, height, and width properties.
        // This test checks if the structure gracefully handles partial definitions.
        // However, a strictly compliant implementation should likely enforce all properties.

        String unit = "in";
        float height = 50.0f;
        // Missing width

        COSArray dimensionsArray = new COSArray();
        dimensionsArray.add(new COSString(unit));
        dimensionsArray.add(COSNumber.get(height));
        // Missing width

        assertNotNull(dimensionsArray, "COSArray for dimensions should not be null.");
        assertEquals(2, dimensionsArray.size(), "Dimensions array should contain 2 elements when width is missing.");

        COSBase unitObj = dimensionsArray.getObject(0);
        COSBase heightObj = dimensionsArray.getObject(1);

        assertTrue(unitObj instanceof COSString, "First element should be a COSString for unit.");
        assertEquals(unit, ((COSString) unitObj).getString(), "Unit should match the provided value.");

        assertTrue(heightObj instanceof COSNumber, "Second element should be a COSNumber for height.");
        assertEquals(height, ((COSNumber) heightObj).floatValue(), "Height should match the provided value.");

        // Attempting to access a non-existent width property would likely result in an error or null
        // depending on the actual implementation of the structured type wrapper.
        // For this test, we check the size explicitly.
    }

    /**
     * Test edge case: Dimensions with zero values for height and width.
     * This test ensures that zero values for numerical properties are handled correctly.
     */
    @Test
    public void testDimensionsWithZeroValues() {
        String unit = "px";
        float height = 0.0f;
        float width = 0.0f;

        COSArray dimensionsArray = new COSArray();
        dimensionsArray.add(new COSString(unit));
        dimensionsArray.add(COSNumber.get(width));
        dimensionsArray.add(COSNumber.get(height));

        assertNotNull(dimensionsArray, "COSArray for dimensions should not be null.");
        assertEquals(3, dimensionsArray.size(), "Dimensions array should contain 3 elements.");

        COSBase unitObj = dimensionsArray.getObject(0);
        COSBase widthObj = dimensionsArray.getObject(1);
        COSBase heightObj = dimensionsArray.getObject(2);

        assertTrue(unitObj instanceof COSString, "First element should be a COSString for unit.");
        assertEquals(unit, ((COSString) unitObj).getString(), "Unit should match the provided value.");

        assertTrue(widthObj instanceof COSNumber, "Second element should be a COSNumber for width.");
        assertEquals(width, ((COSNumber) widthObj).floatValue(), "Width should be 0.0.");

        assertTrue(heightObj instanceof COSNumber, "Third element should be a COSNumber for height.");
        assertEquals(height, ((COSNumber) heightObj).floatValue(), "Height should be 0.0.");
    }

    /**
     * Test edge case: Dimensions with negative values for height and width.
     * This test checks how negative numerical values are handled, which might be invalid depending on context.
     * PDFBox's COS layer typically allows 'real' numbers, so this tests if the underlying layer accepts them.
     */
    @Test
    public void testDimensionsWithNegativeValues() {
        String unit = "meter";
        float height = -50.0f;
        float width = -100.0f;

        COSArray dimensionsArray = new COSArray();
        dimensionsArray.add(new COSString(unit));
        dimensionsArray.add(COSNumber.get(width));
        dimensionsArray.add(COSNumber.get(height));

        assertNotNull(dimensionsArray, "COSArray for dimensions should not be null.");
        assertEquals(3, dimensionsArray.size(), "Dimensions array should contain 3 elements.");

        COSBase unitObj = dimensionsArray.getObject(0);
        COSBase widthObj = dimensionsArray.getObject(1);
        COSBase heightObj = dimensionsArray.getObject(2);

        assertTrue(unitObj instanceof COSString, "First element should be a COSString for unit.");
        assertEquals(unit, ((COSString) unitObj).getString(), "Unit should match the provided value.");

        assertTrue(widthObj instanceof COSNumber, "Second element should be a COSNumber for width.");
        assertEquals(width, ((COSNumber) widthObj).floatValue(), "Width should accept negative values.");

        assertTrue(heightObj instanceof COSNumber, "Third element should be a COSNumber for height.");
        assertEquals(height, ((COSNumber) heightObj).floatValue(), "Height should accept negative values.");
    }

    /**
     * Test edge case: Dimensions with an empty unit string.
     * This tests the handling of an empty string for the unit property.
     */
    @Test
    public void testDimensionsWithEmptyUnit() {
        String unit = "";
        float height = 72.0f;
        float width = 72.0f;

        COSArray dimensionsArray = new COSArray();
        dimensionsArray.add(new COSString(unit));
        dimensionsArray.add(COSNumber.get(width));
        dimensionsArray.add(COSNumber.get(height));

        assertNotNull(dimensionsArray, "COSArray for dimensions should not be null.");
        assertEquals(3, dimensionsArray.size(), "Dimensions array should contain 3 elements.");

        COSBase unitObj = dimensionsArray.getObject(0);
        assertTrue(unitObj instanceof COSString, "First element should be a COSString for unit.");
        assertEquals(unit, ((COSString) unitObj).getString(), "Unit string should be empty.");

        // Also check numerical properties are set correctly
        COSBase widthObj = dimensionsArray.getObject(1);
        COSBase heightObj = dimensionsArray.getObject(2);
        assertTrue(widthObj instanceof COSNumber, "Second element should be a COSNumber for width.");
        assertTrue(heightObj instanceof COSNumber, "Third element should be a COSNumber for height.");
    }

    /**
     * Test case for verifying the structure when using PDRectangle properties.
     * This simulates how a higher-level object might use the COS representation.
     * PDRectangle itself is a structured type that can contain such dimension information.
     */
    @Test
    public void testDimensionsAsPDRectangle() {
        float lowerLeftX = 0.0f;
        float lowerLeftY = 0.0f;
        float upperRightX = 612.0f; // Corresponds to 8.5 inches at 72 dpi
        float upperRightY = 792.0f; // Corresponds to 11 inches at 72 dpi

        PDRectangle rect = new PDRectangle(lowerLeftX, lowerLeftY, upperRightX, upperRightY);

        assertNotNull(rect, "PDRectangle should not be null.");

        // PDRectangle internally uses COSArray for its representation which aligns with the requirement
        // Accessing the underlying COSArray to verify structure
        COSArray rectArray = rect.getCOSArray();
        assertNotNull(rectArray, "PDRectangle's COS Array should not be null.");
        assertEquals(4, rectArray.size(), "PDRectangle COS Array should have 4 elements.");

        // While PDRectangle's direct properties are x, y, width, height, its COS representation
        // is an array [llx, lly, urx, ury]. If a specific 'Dimensions' structured type IS NOT
        // a PDRectangle but uses its own array format [unit, width, height], this test
        // wouldn't directly apply. However, it shows PDFBox's approach to structured types.

        // For the SRS-PDFBOX-019 requirement, a direct translation might look like:
        String unit = "pt"; // points
        float width = upperRightX - lowerLeftX;
        float height = upperRightY - lowerLeftY;

        COSArray dimensionSpecArray = new COSArray();
        dimensionSpecArray.add(new COSString(unit));
        dimensionSpecArray.add(COSNumber.get(width));
        dimensionSpecArray.add(COSNumber.get(height));

        assertNotNull(dimensionSpecArray, "Custom dimension array should not be null.");
        assertEquals(3, dimensionSpecArray.size(), "Custom dimension array should have 3 elements.");

        assertEquals(unit, ((COSString) dimensionSpecArray.getObject(0)).getString(), "Unit should be points.");
        assertEquals(width, ((COSNumber) dimensionSpecArray.getObject(1)).floatValue(), "Width should match calculated width.");
        assertEquals(height, ((COSNumber) dimensionSpecArray.getObject(2)).floatValue(), "Height should match calculated height.");
    }
}