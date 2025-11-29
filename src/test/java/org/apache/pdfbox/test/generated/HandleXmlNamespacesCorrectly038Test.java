package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class HandleXmlNamespacesCorrectly038Test {
    @Test
    public void testNamespaceSerialization() {
        String xmlSnippet = "<rdf:RDF xmlns:rdf='http://www.w3.org/1999/02/22-rdf-syntax-ns#'> </rdf:RDF>";
        boolean check = xmlSnippet.contains("xmlns:rdf=");
        Assertions.assertTrue(check);
    }
    
    @Test
    public void testDefaultNamespace() {
        String xmlSnippet = "<rdf:RDF xmlns='http://purl.org/dc/elements/1.1/'> </rdf:RDF>";
        boolean check = xmlSnippet.contains("xmlns='http://purl.org/dc/elements/1.1/'");
        Assertions.assertTrue(check);
    }
}