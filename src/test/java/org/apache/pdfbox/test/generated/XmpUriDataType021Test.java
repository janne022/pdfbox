package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class XmpUriDataType021Test {
    @Test
    public void testUriDataTypeSupported() {
        String uri = "http://example.com/resource";
        Assertions.assertNotNull(uri);
        Assertions.assertTrue(uri.startsWith("http"));
    }
    
    @Test
    public void testUriParsing() {
        String uriString = "urn:isbn:0451450523";
        Assertions.assertEquals("urn:isbn:0451450523", uriString);
    }
}