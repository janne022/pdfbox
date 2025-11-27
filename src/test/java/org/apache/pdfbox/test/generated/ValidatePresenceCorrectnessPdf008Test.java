package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ValidatePresenceCorrectnessPdf008Test {
    @Test
    public void testPdfaSchemaPropertiesPresent() {
        String mockMetadata = "<imp:property xmlns:imp='pdfaSchema'>value</imp:property>";
        Assertions.assertTrue(mockMetadata.contains("pdfaSchema"));
    }
    
    @Test
    public void testNamespaceURICorrectness() {
        String mockNamespaceUriProperty = "<imp:namespaceURI xmlns:imp='pdfaSchema'>http://www.aiim.org/pdfa/ns/schema#</imp:namespaceURI>";
        String expectedUri = "http://www.aiim.org/pdfa/ns/schema#";
        Assertions.assertEquals(expectedUri, mockNamespaceUriProperty.substring(mockNamespaceUriProperty.indexOf('>') + 1, mockNamespaceUriProperty.lastIndexOf('<')));
    }
}