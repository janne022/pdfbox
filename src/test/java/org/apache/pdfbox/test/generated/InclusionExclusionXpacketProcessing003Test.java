package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class InclusionExclusionXpacketProcessing003Test {
    @Test
    public void testIncludeXpacketInstruction() {
        boolean includeXpacket = true;
        Assertions.assertTrue(includeXpacket, "XPacket instruction should be included");
    }
    
    @Test
    public void testExcludeXpacketInstruction() {
        boolean includeXpacket = false;
        Assertions.assertEquals(false, includeXpacket, "XPacket instruction should be excluded");
    }
}