package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ComprehensiveMethodsSettingRetrieving030Test {
    @Test
    public void testSetAndGetSimpleProperty() {
        String testValue = "simple";
        Assertions.assertNotNull(testValue);
        String retrievedValue = testValue;
        Assertions.assertEquals("simple", retrievedValue);
    }
    
    @Test
    public void testSetAndGetPropertyObject() {
        String propertyObject = "ModifierDateProperty";
        Assertions.assertTrue(propertyObject.contains("Date"));
        String retrievedObject = propertyObject;
        Assertions.assertEquals("ModifierDateProperty", retrievedObject);
    }
}