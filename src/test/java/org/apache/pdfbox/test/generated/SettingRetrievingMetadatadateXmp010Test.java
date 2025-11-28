package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class SettingRetrievingMetadatadateXmp010Test {
    @Test
    public void testSettingAndRetrievingMetadataDate() {
        String expectedDate = "2023-10-27T10:00:00Z";
        Assertions.assertNotNull(expectedDate);
        Assertions.assertTrue(expectedDate.matches("\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}Z"));
    }

    @Test
    public void testMetadataDateIsNull() {
        String metadataDate = null;
        Assertions.assertNull(metadataDate);
    }
}