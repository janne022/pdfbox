package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class XmpGuidDataType025Test {
    @Test
    public void testGuidDataTypeSupport() {
        String guid = "a1b2c3d4-e5f6-7890-1234-567890abcdef";
        Assertions.assertTrue(guid.matches("[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}"));
    }

    @Test
    public void testGuidDataTypeInvalidFormat() {
        String invalidGuid = "not-a-guid";
        Assertions.assertFalse(invalidGuid.matches("[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}"));
    }
}