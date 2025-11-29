package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class SerializeArrayPropertiesIncluding0020Test {
    @Test
    public void testSerializeEmptyArray() {
        String[] emptyArray = {};
        Assertions.assertNotNull(emptyArray);
        Assertions.assertEquals(0, emptyArray.length);
    }
    
    @Test
    public void testSerializeArrayWithElements() {
        String[] dataArray = {"element1", "element2"};
        Assertions.assertNotNull(dataArray);
        Assertions.assertEquals(2, dataArray.length);
        Assertions.assertEquals("element1", dataArray[0]);
        Assertions.assertEquals("element2", dataArray[1]);
    }
}