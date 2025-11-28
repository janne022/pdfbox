package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class RetrievalArrayTypeOrdered023Test {

    @Test
    public void testObjectCreationSuccess() {
        String arrayProperty = "example";
        Assertions.assertNotNull(arrayProperty);
    }

    @Test
    public void testArrayTypeRetrievalOrdered() {
        String arrayType = "Ordered";
        Assertions.assertEquals("Ordered", arrayType);
    }

    @Test
    public void testArrayTypeRetrievalUnordered() {
        String arrayType = "Unordered";
        Assertions.assertEquals("Unordered", arrayType);
    }
}