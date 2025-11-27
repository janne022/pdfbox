package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class VariousPropertiesResourceReferences012Test {
    
    @Test
    public void testToPartProperty() {
        String propertyName = "toPart";
        String expectedValue = "Part";
        Assertions.assertEquals(expectedValue, propertyName);
    }

    @Test
    public void testVersionIDProperty() {
        String propertyName = "versionID";
        String expectedType = "Text";
        Assertions.assertTrue(propertyName.contains(expectedType));
    }

    @Test
    public void testManageUIProperty() {
        String propertyName = "manageUI";
        String expectedType = "URI";
        Assertions.assertNotNull(propertyName);
        Assertions.assertTrue(propertyName.endsWith(expectedType));
    }
}