package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class CreatingBufferBytebuffer012Test {

    @Test
    public void testCreateBufferFromValidByteBuffer() {
        byte[] data = {1, 2, 3, 4, 5};
        ByteBuffer byteBuffer = ByteBuffer.wrap(data);
        byte[] buffer = byteBuffer.array();
        Assertions.assertNotNull(buffer);
        Assertions.assertEquals(data.length, buffer.length);
    }

    @Test
    public void testCreateBufferFromEmptyByteBuffer() {
        byte[] data = {};
        ByteBuffer byteBuffer = ByteBuffer.wrap(data);
        byte[] buffer = byteBuffer.array();
        Assertions.assertNotNull(buffer);
        Assertions.assertEquals(0, buffer.length);
    }

    @Test
    public void testCreateBufferFromByteBufferWithOffsetAndLimit() {
        byte[] data = {10, 20, 30, 40, 50};
        ByteBuffer byteBuffer = ByteBuffer.wrap(data);
        byteBuffer.position(1);
        byteBuffer.limit(4);
        byte[] buffer = new byte[byteBuffer.remaining()];
        byteBuffer.get(buffer);
        Assertions.assertNotNull(buffer);
        Assertions.assertEquals(3, buffer.length);
        Assertions.assertEquals(20, buffer[0]);
        Assertions.assertEquals(30, buffer[1]);
        Assertions.assertEquals(40, buffer[2]);
    }
}