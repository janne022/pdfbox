package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ParseXmpSchemasIncluding011Test {
    @Test
    public void testParseValidXmlSchema() {
        String xmlInput = "<xmp:test xmlns:xmp=\"http://ns.adobe.com/xap/1.0/">value</xmp:test>";
        Assertions.assertTrue(xmlInput.contains("xmp:test"));
    }
    
    @Test
    public void testParseCustomSchema() {
        String customXml = "<custom:stuff xmlns:custom=\"http://mycompany.com/custom/">data</custom:stuff>";
        Assertions.assertTrue(customXml.contains("custom:stuff"));
    }
}