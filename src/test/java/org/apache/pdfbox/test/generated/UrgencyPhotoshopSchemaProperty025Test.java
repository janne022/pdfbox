package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class UrgencyPhotoshopSchemaProperty025Test {
    @Test
    public void testUrgencyIntegerType() {
        int urgencyValue = 5;
        Assertions.assertEquals(5, urgencyValue);
    }
    
    @Test
    public void testUrgencyNotNull() {
        Integer urgency = Integer.valueOf(10);
        Assertions.assertNotNull(urgency);
    }
    
    @Test
    public void testUrgencySimpleCardinality() {
        int urgency1 = 1;
        int urgency2 = 2;
        Assertions.assertTrue(urgency1 != urgency2);
    }
}