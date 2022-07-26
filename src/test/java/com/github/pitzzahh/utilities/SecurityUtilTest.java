package com.github.pitzzahh.utilities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SecurityUtilTest {

    @Test
    void shouldDecrypt() {
        var text = "200263444";
        var encrypted = SecurityUtil.encrypt(text);
        var decryped = SecurityUtil.decrypt(encrypted);
        assertEquals("200263444", decryped);
    }

}