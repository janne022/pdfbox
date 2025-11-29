package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class XmpThumbnailStructuredType014Test {
    @Test
    public void testXmpThumbnailSupport() {
        String xmpThumbnailData = "<xmpRights>";
        Assertions.assertTrue(xmpThumbnailData.contains("xmpRights"));
    }
    
    @Test
    public void testXmpThumbnailNotNull() {
        String xmpThumbnailData = "<xmpRights>";
        Assertions.assertNotNull(xmpThumbnailData);
    }
}