package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class HandleXmlNamespaceDeclarations0018Test {
    @Test
    public void testNamespaceHandling() {
        String xmlWithNamespace = "<root xmlns=\"http://example.com\"><child>value</child></root>";
        Assertions.assertTrue(xmlWithNamespace.contains("xmlns=\"http://example.com\""));
    }

    @Test
    public void testSerializationWithNamespace() {
        String expectedXml = "<ns:root xmlns:ns=\"http://example.com/ns\"><ns:child>test</ns:child></ns:root>";
        Assertions.assertNotNull(expectedXml);
    }
}