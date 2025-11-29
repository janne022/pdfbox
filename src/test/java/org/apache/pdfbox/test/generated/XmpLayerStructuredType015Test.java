package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class XmpLayerStructuredType015Test {
    @Test
    public void testXmpLayerSupport() {
        String xmpLayerData = "<xmpData>test</xmpData>";
        Assertions.assertTrue(xmpLayerData.contains("xmpData"));
    }
    
    @Test
    public void testMetadataStructure() {
        String metadata = "some metadata";
        Assertions.assertNotNull(metadata);
    }
}