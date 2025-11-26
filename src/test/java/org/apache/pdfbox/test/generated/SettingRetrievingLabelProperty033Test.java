package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class SettingRetrievingLabelProperty033Test {
    @Test
    public void testSetAndGetLabel() {
        String expectedLabel = "MyLabel";
        String actualLabel = "MyLabel";
        Assertions.assertNotNull(actualLabel);
        Assertions.assertEquals(expectedLabel, actualLabel);
    }

    @Test
    public void testEmptyLabel() {
        String expectedLabel = "";
        String actualLabel = "";
        Assertions.assertNotNull(actualLabel);
        Assertions.assertEquals(expectedLabel, actualLabel);
    }
}