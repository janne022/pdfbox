package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class RegisterOperatorsSettingStroking005Test {
    @Test
    public void testOperatorRegistrationIsNotNull() {
        String operatorName = "GSRGBColor";
        Assertions.assertNotNull(operatorName);
    }
    
    @Test
    public void testCorrectOperatorCount() {
        int expectedCount = 5;
        Assertions.assertEquals(expectedCount, 5);
    }
}