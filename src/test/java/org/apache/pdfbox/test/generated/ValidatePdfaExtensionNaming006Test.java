package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ValidatePdfaExtensionNaming006Test {
    @Test
    public void testValidExtensionName() {
        String extensionName = "com.example.extension1";
        Assertions.assertTrue(extensionName.matches("^[a-zA-Z0-9.]+$"));
    }
    
    @Test
    public void testInvalidExtensionName() {
        String extensionName = "com..invalid";
        Assertions.assertFalse(extensionName.matches("^[a-zA-Z0-9.]+$"));
    }

    @Test
    public void testEmptyExtensionName() {
        String extensionName = "";
        Assertions.assertFalse(extensionName.matches("^[a-zA-Z0-9.]+$"));
    }
}