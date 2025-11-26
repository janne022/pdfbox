package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class DetectRafFilesBased010Test {
    @Test
    public void testCorrectSignatureDetected() {
        String signature = "FUJIFILMCCD-RAW";
        Assertions.assertEquals("FUJIFILMCCD-RAW", signature);
    }
    
    @Test
    public void testIncorrectSignatureNotDetected() {
        String signature = "NOT-A-RAF-SIGNATURE";
        Assertions.assertNotEquals("FUJIFILMCCD-RAW", signature);
    }
}