package se.yrgo.up22.group1.main;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MainUtilsTest {

    @Test
    void readInMenuShouldThrowAnIOExceptionOrNoSuchFileException() {
        assertDoesNotThrow(() -> MainUtils.readInMenu(Path.of("NotAfile")), "File does not exist: NotAfile");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "12324"})
    void validateInputMethodShouldReturnTrueIfInputIsNumberTest(String inputString) {
        // given
        Scanner scanner = new Scanner(System.in);
        // when
        boolean b = MainUtils.validateInput(inputString);
        // then
        assertTrue(b);
    }

    @ParameterizedTest
    @ValueSource(strings = {"zero", "1two", "12324 three"})
    void validateInputMethodShouldReturnFalseIfInputIsNotANumberTest(String inputString) {
        // given
        Scanner scanner = new Scanner(System.in);
        // when
        boolean b = MainUtils.validateInput("");
        // then
        assertFalse(b);
    }
}