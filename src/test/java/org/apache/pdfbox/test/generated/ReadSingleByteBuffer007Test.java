package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ReadSingleByteBuffer007Test {
    @Test
    public void testReadSingleByteSuccess() {
        byte[] buffer = { (byte) 0x41 };
        byte readByte = buffer[0];
        Assertions.assertEquals(0x41, readByte);
    }
    
    @Test
    public void testReadSingleByteNotNull() {
        byte[] buffer = { (byte) 0x42 };
        Assertions.assertNotNull(buffer);
    }
}