package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class AbleSerializeXmpMetadata044Test {
    @Test
    public void testSerializeEmptyMetadata() {
        String metadata = "<x:xmpmeta xmlns:x='adobe:ns:meta/'/>";
        Assertions.assertTrue(metadata.contains("xmpmeta"));
    }

    @Test
    public void testSerializeSimpleMetadata() {
        String metadata = "<x:xmpmeta xmlns:x='adobe:ns:meta/'><rdf:RDF xmlns:rdf='http://www.w3.org/1999/02/22-rdf-syntax-ns#'><rdf:Description rdf:about=''/></rdf:RDF></x:xmpmeta>";
        Assertions.assertTrue(metadata.contains("rdf:RDF"));
    }
}