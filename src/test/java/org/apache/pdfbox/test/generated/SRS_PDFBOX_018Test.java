package org.apache.pdfbox.test.generated;

import org.apache.pdfbox.pdmodel.graphics.layer.PDLayer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Requirement SRS-PDFBOX-018.
 * This class verifies that the CSCI provides methods to set and retrieve 'LayerText' and 'LayerName' properties.
 */
public class SRS_PDFBOX_018Test {

    /**
     * Tests setting and retrieving a valid LayerText property.
     */
    @Test
    public void testSetAndGetLayerText_Valid() {
        PDLayer layer = new PDLayer();
        String expectedText = "This is a test layer.";
        layer.setLayerText(expectedText);
        assertEquals(expectedText, layer.getLayerText(), "LayerText should be set and retrieved correctly.");
    }

    /**
     * Tests setting and retrieving an empty LayerText property.
     */
    @Test
    public void testSetAndGetLayerText_Empty() {
        PDLayer layer = new PDLayer();
        String expectedText = "";
        layer.setLayerText(expectedText);
        assertEquals(expectedText, layer.getLayerText(), "Empty LayerText should be handled correctly.");
    }

    /**
     * Tests setting and retrieving null for LayerText property.
     * PDFBox typically handles null by treating it as an empty string or not setting the property.
     * We expect it to potentially return null or an empty string depending on implementation.
     */
    @Test
    public void testSetAndGetLayerText_Null() {
        PDLayer layer = new PDLayer();
        // Setting null might not directly set it, or it might be normalized to empty.
        // Let's test for both null and empty string as potential valid outcomes.
        layer.setLayerText(null);
        String retrievedText = layer.getLayerText();
        // Depending on PDFBox's internal handling, null might be stored as null or an empty string.
        // Assert that it's not some unexpected value.
        assertNotNull(retrievedText, "LayerText should not be null after setting null if it normalizes to empty.");
        // Or, if it's allowed to be null:
        // assertNull(retrievedText, "LayerText should be null after setting null.");
        // For robust testing, let's check if it's either null or empty, as PDFBox might normalize.
        assertTrue(retrievedText == null || retrievedText.isEmpty(), "LayerText should be null or empty after setting null.");
    }

    /**
     * Tests setting and retrieving a valid LayerName property.
     */
    @Test
    public void testSetAndGetLayerName_Valid() {
        PDLayer layer = new PDLayer();
        String expectedName = "MyCustomLayer";
        layer.setLayerName(expectedName);
        assertEquals(expectedName, layer.getLayerName(), "LayerName should be set and retrieved correctly.");
    }

    /**
     * Tests setting and retrieving an empty LayerName property.
     */
    @Test
    public void testSetAndGetLayerName_Empty() {
        PDLayer layer = new PDLayer();
        String expectedName = "";
        layer.setLayerName(expectedName);
        assertEquals(expectedName, layer.getLayerName(), "Empty LayerName should be handled correctly.");
    }

    /**
     * Tests setting and retrieving null for LayerName property.
     * Similar to LayerText, null might be normalized to empty or kept as null.
     */
    @Test
    public void testSetAndGetLayerName_Null() {
        PDLayer layer = new PDLayer();
        layer.setLayerName(null);
        String retrievedName = layer.getLayerName();
        assertNotNull(retrievedName, "LayerName should not be null after setting null if it normalizes to empty.");
        // Or, if it's allowed to be null:
        // assertNull(retrievedName, "LayerName should be null after setting null.");
        assertTrue(retrievedName == null || retrievedName.isEmpty(), "LayerName should be null or empty after setting null.");
    }

    /**
     * Tests that setting and getting properties on different layer instances are independent.
     */
    @Test
    public void testLayerIndependence() {
        PDLayer layer1 = new PDLayer();
        PDLayer layer2 = new PDLayer();

        String text1 = "Layer One Text";
        String name1 = "Layer One";
        layer1.setLayerText(text1);
        layer1.setLayerName(name1);

        String text2 = "Layer Two Text";
        String name2 = "Layer Two";
        layer2.setLayerText(text2);
        layer2.setLayerName(name2);

        assertEquals(text1, layer1.getLayerText(), "Layer 1 text should match.");
        assertEquals(name1, layer1.getLayerName(), "Layer 1 name should match.");
        assertEquals(text2, layer2.getLayerText(), "Layer 2 text should match.");
        assertEquals(name2, layer2.getLayerName(), "Layer 2 name should match.");

        assertNotEquals(layer1.getLayerText(), layer2.getLayerText(), "Layer texts should be different.");
        assertNotEquals(layer1.getLayerName(), layer2.getLayerName(), "Layer names should be different.");
    }
}
