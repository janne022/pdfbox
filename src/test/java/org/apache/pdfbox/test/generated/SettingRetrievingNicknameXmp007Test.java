package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class SettingRetrievingNicknameXmp007Test {
    @Test
    public void testSetAndGetNickname() {
        String nickname = "MyDocumentNickname";
        Assertions.assertNotNull(nickname);
        Assertions.assertEquals("MyDocumentNickname", nickname);
    }

    @Test
    public void testEmptyNickname() {
        String nickname = "";
        Assertions.assertTrue(nickname.isEmpty());
    }
}