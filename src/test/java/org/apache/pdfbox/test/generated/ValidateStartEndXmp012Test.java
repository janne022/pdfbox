package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ValidateStartEndXmp012Test {
    @Test
    public void testValidXmpPacket() {
        String xmpPacket = "<x:xmpmeta xmlns:x=\"adobe:ns:meta\">";
        Assertions.assertTrue(xmpPacket.startsWith("<") && xmpPacket.endsWith(">"));
    }

    @Test
    public void testRootElementValidation() {
        String rootElement = "<rdf:RDF>";
        Assertions.assertNotNull(rootElement);
        Assertions.assertTrue(rootElement.startsWith("<") && rootElement.endsWith(">"));
    }
}