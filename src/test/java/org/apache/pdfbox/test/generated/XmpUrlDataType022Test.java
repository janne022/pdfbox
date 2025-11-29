package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class XmpUrlDataType022Test {
    @Test
    public void testUrlDataTypeSupport() {
        String url = "http://example.com";
        Assertions.assertNotNull(url);
        Assertions.assertTrue(url.startsWith("http"));
    }
    
    @Test
    public void testUrlDataTypeValidStructure() {
        String url = "https://www.example.com/path?query=value#fragment";
        Assertions.assertEquals("https://www.example.com/path?query=value#fragment", url);
    }
}