package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class RemoveCommentsParsedXml011Test {
    @Test
    public void shouldRemoveXmlCommentsProperly() {
        String xmlWithComment = "<root><!-- comment --><data/></root>";
        String processedXml = removeComments(xmlWithComment);
        Assertions.assertEquals("<root><data/></root>", processedXml);
    }
    
    @Test
    public void shouldHandleNoComments() {
        String xmlWithoutComment = "<root><data/></root>";
        String processedXml = removeComments(xmlWithoutComment);
        Assertions.assertEquals("<root><data/></root>", processedXml);
    }

    private String removeComments(String xml) {
        // This is a placeholder for the actual XMP processing logic
        // The real implementation would involve XML parsing and comment node removal.
        return xml.replaceAll("<!--.*?-->", "");
    }
}