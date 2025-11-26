package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class RequireBufferedinputstreamSupportsMark025Test {

    @Test
    public void testBufferedInputStreamHasMarkSupported() throws IOException {
        byte[] data = "sample data".getBytes();
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        BufferedInputStream bis = new BufferedInputStream(bais);
        Assertions.assertTrue(bis.markSupported(), "BufferedInputStream should support mark");
        bis.close();
    }

    @Test
    public void testMarkAndResetOperations() throws IOException {
        byte[] data = "abcdefg".getBytes();
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        BufferedInputStream bis = new BufferedInputStream(bais);

        bis.read(new byte[3]); // Read first 3 bytes
        bis.mark(10);
        int markPosition = bis.read(); // Read 'd'

        bis.read(new byte[2]); // Read 'e', 'f'
        bis.reset();
        
        int resetPosition = bis.read(); // Should read 'd' again
        
        Assertions.assertEquals('d', resetPosition, "Reset should return to the marked position");
        Assertions.assertEquals('d', markPosition, "Initial read after mark should be 'd'");
        
        bis.close();
    }
}