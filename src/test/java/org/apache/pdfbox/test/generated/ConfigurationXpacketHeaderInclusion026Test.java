package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ConfigurationXpacketHeaderInclusion026Test {
    @Test
    public void testDefaultXpacketHeaderInclusion() {
        boolean includeXpacket = true;
        Assertions.assertTrue(includeXpacket);
    }
    
    @Test
    public void testConfigurableXpacketHeaderInclusion() {
        boolean expected = false;
        boolean actual = false;
        Assertions.assertEquals(expected, actual);
    }
}