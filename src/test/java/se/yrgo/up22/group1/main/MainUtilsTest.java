package se.yrgo.up22.group1.main;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class MainUtilsTest {

    @Test
    void readInMenuShouldThrowAnIOExceptionOrNoSuchFileException() {
        assertDoesNotThrow(() -> MainUtils.readInMenu(Path.of("NotAfile")), "File does not exist: NotAfile");
    }

    @Test
    void getMenuChoiceShouldNotAcceptAnythingButNumbers() {
        // given

        // when

        // then
    }
}