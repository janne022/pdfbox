package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class RetrievalNamespaceUriAssociated005Test {
    @Test
    public void testRetrieveKnownNamespace() {
        String namespacePrefix = "pdf";
        String expectedUri = "http://ns.adobe.com/pdf/1.3/";
        String actualUri = expectedUri; 
        Assertions.assertNotNull(actualUri);
        Assertions.assertEquals(expectedUri, actualUri);
    }
    
    @Test
    public void testRetrieveUnknownNamespace() {
        String namespacePrefix = "unknown";
        String actualUri = null;
        Assertions.assertNull(actualUri);
    }
}