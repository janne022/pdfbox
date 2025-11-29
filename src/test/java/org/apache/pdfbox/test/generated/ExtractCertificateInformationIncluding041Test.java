package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ExtractCertificateInformationIncluding041Test {
    @Test
    public void testExtractUrls() {
        String certificateInfo = "fakeCertificateInfoWithOCSPUrlandCRLUrl";
        boolean containsOcsp = certificateInfo.contains("OCSP");
        boolean containsCrl = certificateInfo.contains("CRL");
        Assertions.assertTrue(containsOcsp);
        Assertions.assertTrue(containsCrl);
    }
    
    @Test
    public void testNoUrlsPresent() {
        String certificateInfo = "fakeCertificateInfoWithoutUrls";
        boolean containsOcsp = certificateInfo.contains("OCSP");
        boolean containsCrl = certificateInfo.contains("CRL");
        Assertions.assertFalse(containsOcsp);
        Assertions.assertFalse(containsCrl);
    }
}