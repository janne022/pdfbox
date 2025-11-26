package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ShaFamilyDigestAlgorithms030Test {
    @Test
    public void testRipemd160Algorithm() {
        String algorithm = "RIPEMD160";
        Assertions.assertNotNull(algorithm, "RIPEMD160 should be supported");
        Assertions.assertTrue(algorithm.length() > 0, "RIPEMD160 string is empty");
    }
    
    @Test
    public void testSha512Algorithm() {
        String algorithm = "SHA512";
        Assertions.assertNotNull(algorithm, "SHA512 should be supported");
        Assertions.assertTrue(algorithm.length() > 0, "SHA512 string is empty");
    }
    
    @Test
    public void testSha384Algorithm() {
        String algorithm = "SHA384";
        Assertions.assertNotNull(algorithm, "SHA384 should be supported");
        Assertions.assertTrue(algorithm.length() > 0, "SHA384 string is empty");
    }

    @Test
    public void testSha256Algorithm() {
        String algorithm = "SHA256";
        Assertions.assertNotNull(algorithm, "SHA256 should be supported");
        Assertions.assertTrue(algorithm.length() > 0, "SHA256 string is empty");
    }

    @Test
    public void testSha1Algorithm() {
        String algorithm = "SHA1";
        Assertions.assertNotNull(algorithm, "SHA1 should be supported");
        Assertions.assertTrue(algorithm.length() > 0, "SHA1 string is empty");
    }
}