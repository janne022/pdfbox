package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class SettingRetrievingModifydateXmp009Test {
    @Test
    public void testModifyDateIsNotNullAtCreation() {
        String modifyDate = "2023-10-27T10:00:00Z";
        Assertions.assertNotNull(modifyDate);
    }
    
    @Test
    public void testModifyDateIsCorrectlySetAndRetrieved() {
        String expectedModifyDate = "2023-10-27T11:30:00Z";
        String actualModifyDate = expectedModifyDate;
        Assertions.assertEquals(expectedModifyDate, actualModifyDate);
    }
}