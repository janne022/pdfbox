package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.apache.pdfbox.persistence.layer.LayerText;
import org.apache.pdfbox.persistence.layer.LayerName;

public class MethodsSetRetrieveLayertext018Test {
    @Test
    public void testSetAndGetLayerText() {
        LayerText layerText = new LayerText();
        layerText.setText("Sample Text");
        assertNotNull(layerText.getText());
        assertEquals("Sample Text", layerText.getText());
    }

    @Test
    public void testSetAndGetLayerName() {
        LayerName layerName = new LayerName();
        layerName.setName("Sample Name");
        assertNotNull(layerName.getName());
        assertEquals("Sample Name", layerName.getName());
    }

    @Test
    public void testNullLayerText() {
        LayerText layerText = new LayerText();
        assertNull(layerText.getText());
        layerText.setText(null);
        assertNull(layerText.getText());
    }

    @Test
    public void testNullLayerName() {
        LayerName layerName = new LayerName();
        assertNull(layerName.getName());
        layerName.setName(null);
        assertNull(layerName.getName());
    }
}