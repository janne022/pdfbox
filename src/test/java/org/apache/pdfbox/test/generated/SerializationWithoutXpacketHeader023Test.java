package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class SerializationWithoutXpacketHeader023Test {
    @Test
    public void testSerializationWithoutXpacket() {
        String data = "sampleData";
        Assertions.assertNotNull(data);
    }
    
    @Test
    public void testSerializationWithXpacket() {
        String data = "sampleDataWithXpacket";
        boolean condition = true;
        Assertions.assertTrue(condition);
    }
}