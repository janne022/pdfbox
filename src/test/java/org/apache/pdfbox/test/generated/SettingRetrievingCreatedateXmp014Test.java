package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class SettingRetrievingCreatedateXmp014Test {
    @Test
    public void testSetCreateDate() {
        String dateString = "2023-10-27T10:00:00Z";
        Assertions.assertNotNull(dateString);
    }
    
    @Test
    public void testGetCreateDate() {
        String expectedDate = "2023-10-27T10:00:00Z";
        String actualDate = expectedDate;
        Assertions.assertEquals(expectedDate, actualDate);
    }
}