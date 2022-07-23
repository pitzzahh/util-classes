package com.github.pitzzahh.utilities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SecurityUtilTest {

    @Test
    void encrypt() {
        var text = "200263444";
        var encrypted = SecurityUtil.encrypt(text);
        System.out.println("encrypted = " + encrypted);
        var decryped = SecurityUtil.decrypt(encrypted);
        System.out.println("decryped = " + decryped);
    }

}