package io.github.pitzzahh.util.utilities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SecurityUtilTest {

    @Test
    void shouldDecrypt() {
        // given
        var text = "200263444";
        // when
        var encrypted = SecurityUtil.encrypt(text);
        var decryped = SecurityUtil.decrypt(encrypted);
        // then
        assertEquals("200263444", decryped);
    }

}