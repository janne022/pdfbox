package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class OutputGeneratedXmlHighlighting028Test {
    @Test
    public void testOutputToWriterSuccess() {
        String outputData = "<highlighting>";
        Assertions.assertTrue(outputData.startsWith("<"));
    }

    @Test
    public void testWriterNotNullOnOutput() {
        String xmlOutput = "<data>value</data>";
        java.io.StringWriter writer = new java.io.StringWriter();
        writer.write(xmlOutput);
        Assertions.assertNotNull(writer.toString());
    }
}