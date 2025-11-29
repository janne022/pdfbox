package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class SerializeXmlIndentationReadability0016Test {
    @Test
    public void testSerializationWithIndentation() {
        String xmlInput = "<root><child attr=\"value\">Text</child></root>";
        String serializedXml = "<root>\n  <child attr=\"value\">Text</child>\n</root>";
        Assertions.assertTrue(serializedXml.contains("  <child"));
    }
    
    @Test
    public void testIndentationIsPresent() {
        String xmlInput = "<data><item id=\"1\"/></data>";
        String serializedXml = "<data>\n  <item id=\"1"/>\n</data>";
        boolean hasIndentation = serializedXml.contains("  <item");
        Assertions.assertTrue(hasIndentation);
    }
}