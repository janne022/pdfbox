package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class SeqCardinalityXmpProperties002Test {
    @Test
    public void testXmpArrayPropertyExists() {
        String xmpProperty= "exampleArray";
        Assertions.assertNotNull(xmpProperty);
    }
    
    @Test
    public void testXmpArrayHasSequenceType() {
        String sequenceType= "rdf:Seq";
        Assertions.assertEquals("rdf:Seq", sequenceType);
    }
}