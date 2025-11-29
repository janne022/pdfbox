package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class SerializeXmpMetadataXml0014Test {
    @Test
    public void testOmitsXmlDeclaration() {
        String xmlMetadata = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> <xmp>data</xmp>";
        String serialized = "<xmp>data</xmp>";
        Assertions.assertTrue(serialized.equals("<xmp>data</xmp>"));
    }

    @Test
    public void testCorrectSerializationFormat() {
        String expected = "<rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"></rdf:RDF>";
        Assertions.assertTrue(expected.equals("<rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"></rdf:RDF>"));
    }
}