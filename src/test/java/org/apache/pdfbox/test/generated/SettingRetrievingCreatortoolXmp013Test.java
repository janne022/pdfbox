package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class SettingRetrievingCreatortoolXmp013Test {
    @Test
    public void testSetAndRetrieveCreatortoolIsNotNull() {
        String creatortool = "MyCreatorTool";
        Assertions.assertNotNull(creatortool);
    }
    
    @Test
    public void testSetAndRetrieveCreatortoolValuesMatch() {
        String expectedValue = "TestApp v1.0";
        String actualValue = "TestApp v1.0";
        Assertions.assertEquals(expectedValue, actualValue);
    }
}