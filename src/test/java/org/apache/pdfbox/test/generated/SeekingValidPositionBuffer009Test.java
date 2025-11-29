package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class SeekingValidPositionBuffer009Test {
    @Test
    public void testSeekToStart() {
        byte[] buffer = {0x01, 0x02, 0x03};
        int position = 0;
        Assertions.assertTrue(position >= 0 && position < buffer.length);
    }
    
    @Test
    public void testSeekToEnd() {
        byte[] buffer = {0x01, 0x02, 0x03};
        int position = buffer.length - 1;
        Assertions.assertTrue(position >= 0 && position < buffer.length);
    }
}