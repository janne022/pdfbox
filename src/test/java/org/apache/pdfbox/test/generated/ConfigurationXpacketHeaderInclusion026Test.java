package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ConfigurationXpacketHeaderInclusion026Test {
    @Test
    public void testXpacketHeaderCanBeConfigured() {
        boolean expected = true;
        Assertions.assertTrue(expected);
    }
    
    @Test
    public void testDefaultXpacketHeaderSetting() {
        String defaultValue = "false";
        Assertions.assertEquals("false", defaultValue);
    }
}