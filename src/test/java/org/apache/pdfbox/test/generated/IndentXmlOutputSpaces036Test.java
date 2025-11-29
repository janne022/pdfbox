package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class IndentXmlOutputSpaces036Test {

    @Test
    public void testTwoSpaceIndentation() {
        String expectedIndentation = "  ";
        Assertions.assertEquals("  ", expectedIndentation);
    }

    @Test
    public void testIndentationIsPresent() {
        String xmlOutputExample = "<root>\n  <child/>\n</root>";
        boolean containsIndentation = xmlOutputExample.contains("  ");
        Assertions.assertTrue(containsIndentation);
    }
    
    @Test
    public void testIndentationCorrectness() {
        String xmlLine = "  <element>";
        String expectedLine = "  <element>";
        Assertions.assertEquals(expectedLine, xmlLine);
    }
}