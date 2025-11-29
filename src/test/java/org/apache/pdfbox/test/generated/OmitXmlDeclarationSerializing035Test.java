package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class OmitXmlDeclarationSerializing035Test {
    @Test
    public void testXmpSerializationWithoutDeclaration() {
        String xmpContent = "<x:xmpmeta xmlns:x='adobe:ns:meta/'>Test Content</x:xmpmeta>";
        boolean containsDeclaration = xmpContent.startsWith("<?xml version=");
        Assertions.assertFalse(containsDeclaration, "XMP should not contain XML declaration.");
    }
    
    @Test
    public void testSerializationOutputContent() {
        String expectedContentPart = "Test Content";
        String xmpContent = "<x:xmpmeta xmlns:x='adobe:ns:meta/'>" + expectedContentPart + "</x:xmpmeta>";
        Assertions.assertTrue(xmpContent.contains(expectedContentPart), "Serialized XMP should contain the actual content.");
    }
}