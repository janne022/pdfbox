package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class SourcePhotoshopSchemaProperty030Test {
    @Test
    public void testSourcePropertyExists() {
        String sourcePropertyName = "Source";
        Assertions.assertNotNull(sourcePropertyName);
        Assertions.assertEquals("Source", sourcePropertyName);
    }
    
    @Test
    public void testSourcePropertyValueType() {
        String propertyValue = "Photoshop";
        Assertions.assertTrue(propertyValue instanceof String);
        Assertions.assertEquals("Photoshop", propertyValue);
    }
}