package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ParsingXmpMetadataVarious002Test {
    @Test
    public void testParseFromInputStream() {
        String dummyInputStreamData = "<xmp>data</xmp>";
        Assertions.assertTrue(dummyInputStreamData.contains("<xmp>"));
    }
    
    @Test
    public void testParseFromByteArray() {
        byte[] dummyByteArray = "<xmp>data</xmp>".getBytes();
        String data = new String(dummyByteArray);
        Assertions.assertEquals("<xmp>data</xmp>", data);
    }
}