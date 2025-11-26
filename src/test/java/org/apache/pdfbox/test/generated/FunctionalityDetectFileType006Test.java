package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class FunctionalityDetectFileType006Test {
    @Test
    public void testDetectPdfTypeSimple() {
        byte[] pdfHeader = {37, 80, 68, 70, 45};
        String fileType = FunctionalityDetectFileType006.detectFileType(pdfHeader);
        Assertions.assertEquals("PDF", fileType);
    }
    
    @Test
    public void testDetectUnknownType() {
        byte[] unknownData = {1, 2, 3, 4, 5};
        String fileType = FunctionalityDetectFileType006.detectFileType(unknownData);
        Assertions.assertNull(fileType);
    }
}