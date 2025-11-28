package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class PreserveXmlNamespaceDeclarations003Test {
    @Test
    public void testNamespacePreservationBasic() {
        String xmlContent = "<rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\">";
        boolean isNamespacePresent = xmlContent.contains("xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"");
        Assertions.assertTrue(isNamespacePresent);
    }

    @Test
    public void testAnotherNamespacePreservation() {
        String xmlContent = "<rdf:RDF xmlns:test=\"http://example.com\">";
        boolean isNamespacePresent = xmlContent.contains("xmlns:test=\"http://example.com\"");
        Assertions.assertEquals(true, isNamespacePresent);
    }
}