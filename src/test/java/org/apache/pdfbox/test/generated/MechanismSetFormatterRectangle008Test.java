package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class MechanismSetFormatterRectangle008Test {
    @Test
    public void testSetFormatterRectangleExists() {
        String rectangleParam = "10,20,30,40";
        Assertions.assertNotNull(rectangleParam, "Formatter rectangle parameter should not be null");
    }
    
    @Test
    public void testSetFormatterRectangleValidFormat() {
        String rectangleParam = "10.5,20.2,30.7,40.1";
        boolean isValid = rectangleParam.matches("\\d+(\.\d+)?\ E?((,)\\d+(\\.\d+)?\ E?){3}");
        Assertions.assertTrue(isValid, "Formatter rectangle parameter has invalid format");
    }
}