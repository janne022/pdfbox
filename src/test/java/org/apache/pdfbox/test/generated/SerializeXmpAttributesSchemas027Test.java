package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class SerializeXmpAttributesSchemas027Test {
    @Test
    public void testSerializeXmpSimpleString() {
        String xmpData = "<rdf:Description xmlns:dc=\"http://purl.org/dc/elements/1.1/\" dc:title=\"Test Title\"/>";
        Assertions.assertTrue(xmpData.contains("dc:title=\"Test Title\""));
    }
    
    @Test
    public void testSerializeXmpWithNamespace() {
        String xmpData = "<rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\" xmlns:test=\"http://example.com/test#\"><rdf:Description rdf:about=\"\" test:attribute=\"value\"/></rdf:RDF>";
        Assertions.assertTrue(xmpData.contains("test:attribute=\"value\""));
    }
}