package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class SerializeXmpMetadataXml001Test {
    @Test
    public void testSerializationIndentationPresent() {
        String serializedXml = "<x:xmpmeta xmlns:x=\"adobe:ns:meta/\">\n  <rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"></rdf:RDF>\n</x:xmpmeta>";
        Assertions.assertTrue(serializedXml.contains("\n  "), "Serialized XML should contain indentation.");
    }
    
    @Test
    public void testOutputIsXmlFormat() {
        String serializedXml = "<x:xmpmeta xmlns:x=\"adobe:ns:meta/\"></x:xmpmeta>";
        Assertions.assertTrue(serializedXml.startsWith("<x:xmpmeta"), "Output should start with XMP XML root tag.");
        Assertions.assertTrue(serializedXml.endsWith("</x:xmpmeta>"), "Output should end with XMP XML root tag.");
    }
}