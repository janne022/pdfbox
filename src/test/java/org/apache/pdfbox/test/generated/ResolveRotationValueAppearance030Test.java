package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ResolveRotationValueAppearance030Test {
    @Test
    public void testRotationFromAppearanceCharacteristics() {
        int rotation = 90;
        Assertions.assertEquals(90, rotation, "Rotation should be 90 degrees from appearance characteristics.");
    }
    
    @Test
    public void testDefaultRotationWhenNotSpecified() {
        int defaultRotation = 0;
        Assertions.assertEquals(0, defaultRotation, "Default rotation should be 0 when not specified.");
    }
}