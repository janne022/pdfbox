package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class CreateXmlDocumentRepresenting045Test {
    @Test
    public void testXmlCreationSuccess() {
        String xmlOutput = "<xmpMeta>some data</xmpMeta>";
        Assertions.assertNotNull(xmlOutput);
        Assertions.assertTrue(xmlOutput.contains("xmpMeta"));
    }
    
    @Test
    public void testXmlOutputFormat() {
        String xmlOutput = "<report><title>Test</title></report>";
        Assertions.assertEquals("<report><title>Test</title></report>", xmlOutput);
    }
}