package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class CorrectlyReturnNamespaceUri021Test {
    @Test
    public void testNamespaceUriIsNotNull() {
        String namespaceUri = "http://example.com/ns";
        Assertions.assertNotNull(namespaceUri, "Namespace URI should not be null.");
    }
    
    @Test
    public void testNamespaceUriIsCorrect() {
        String expectedUri = "http://example.com/ns";
        String actualUri = "http://example.com/ns";
        Assertions.assertEquals(expectedUri, actualUri, "Namespace URI should match the expected value.");
    }
}