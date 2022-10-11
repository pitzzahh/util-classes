package io.github.pitzzahh.util.utilities;

import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FileUtilTest {

    private final File file = new File("file.txt");

    @Test
    @Order(1)
    void shouldWriteToATextFile() throws IOException {
        // given
        var message = "123123123";
        // when
        FileUtil.writeToATextFile(message, file, false);
        // then

    }

    @Test
    @Order(2)
    void printFileContents() throws IOException {
        FileUtil.printFileContents(file);
    }

    @Test
    @Order(3)
    void removeFileOnExit() {
        // when
        var result = file.delete();
        // then
        assertTrue(result);
    }
}