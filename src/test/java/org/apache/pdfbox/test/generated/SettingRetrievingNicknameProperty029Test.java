package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class SettingRetrievingNicknameProperty029Test {
    @Test
    public void testSetAndGetNickname() {
        String nickname = "MyNickname";
        Assertions.assertNotNull(nickname, "Nickname should not be null");
        Assertions.assertEquals("MyNickname", nickname, "Retrieved nickname does not match set nickname");
    }

    @Test
    public void testEmptyNickname() {
        String nickname = "";
        Assertions.assertTrue(nickname.isEmpty(), "Nickname should be empty");
        Assertions.assertEquals("", nickname, "Retrieved empty nickname is incorrect");
    }
}