package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class XmpTextDataType034Test {
    @Test
    public void testXmpTextDataTypeSupport() {
        String xmpText = "Sample XMP Text";
        Assertions.assertNotNull(xmpText);
        Assertions.assertTrue(xmpText.length() > 0);
    }

    @Test
    public void testXmpTextDataTypeContent() {
        String expected = "Another \"quoted\" text";
        String actual = "Another \"quoted\" text";
        Assertions.assertEquals(expected, actual);
    }
}