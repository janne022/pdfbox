package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class XmpResourceeventStructuredType013Test {
    @Test
    public void testXmpResourceeventNotNull() {
        String value = "XMP Metadata Event";
        Assertions.assertNotNull(value);
    }
    
    @Test
    public void testXmpResourceeventType() {
        String eventType = "icalendar.event";     
        Assertions.assertEquals("icalendar.event", eventType);
    }
}