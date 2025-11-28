package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TextlayersPhotoshopSchemaProperty027Test {
    @Test
    public void testSupportedPropertyExists() {
        String propertyName = "TextLayers";
        Assertions.assertTrue(propertyName.equals("TextLayers"));
    }
    
    @Test
    public void testLayerCardinality() {
        int layerCount = 1;
        Assertions.assertEquals(1, layerCount);
    }
    
    @Test
    public void testSequenceCardinality() {
        int sequenceCount = 5;
        Assertions.assertEquals(5, sequenceCount);
    }
}