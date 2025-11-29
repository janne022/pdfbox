package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class SerializeArrayPropertiesCorrectly040Test {
    @Test
    public void testArraySerialization() {
        String[] array = {"item1", "item2"};
        Assertions.assertNotNull(array);
        Assertions.assertEquals(2, array.length);
        Assertions.assertEquals("item1", array[0]);
        Assertions.assertEquals("item2", array[1]);
    }

    @Test
    public void testEmptyArraySerialization() {
        String[] emptyArray = {};
        Assertions.assertNotNull(emptyArray);
        Assertions.assertEquals(0, emptyArray.length);
    }
}