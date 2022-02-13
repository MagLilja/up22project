package se.yrgo.up22.group1.main;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void validateMainMenuTextFileShouldThrowFileNotFoundExceptionExceptionTest() {
        // given
    Path path = Path.of("FileThatDoesntExist");
        // when
        // then
        assertThrows(FileNotFoundException.class, () -> Main.validateMainMenuTextFile(path));
    }
}