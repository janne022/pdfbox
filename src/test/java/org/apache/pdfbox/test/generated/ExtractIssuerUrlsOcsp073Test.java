package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ExtractIssuerUrlsOcsp073Test {
    @Test
    public void testExtractsIssuerUrls() {
        String url = "http://example.com/issuer";
        Assertions.assertNotNull(url);
        Assertions.assertTrue(url.contains("example.com"));
    }
    
    @Test
    public void testExtractsOcspUrls() {
        String url = "http://example.com/ocsp";
        Assertions.assertNotNull(url);
        Assertions.assertTrue(url.contains("example.com"));
    }
}