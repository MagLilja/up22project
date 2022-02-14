package se.yrgo.up22.group1.main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * Utility class for the Main class for this small international football teams application.
 *
 * @author Magnus Lilja
 */
public class MainUtils {

    /**
     * Static method to read in a menu from a .txt file and print it to the console.
     *
     * @param menu
     */
    public static void readInMenu(Path menu) {
        try {
            Files.readAllLines(menu).forEach(System.out::println);
        } catch (NoSuchFileException e) {
            e.printStackTrace();
            System.err.println("File does not exist: " + menu.toString());
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("An IOException on file: " + menu.toString());
        }
    }

    /**
     * Static method to take in input from the console using a Scanner and validating that the input is numbers only.
     *
     * @param scanner
     * @return
     */
    public static int getAndValidateMenuChoice(Scanner scanner) {
        boolean breakOut = false;
        int inputInt = 0;
        while (!breakOut) {
            String inputString = scanner.nextLine();
            if (validateInput(inputString)) {
                inputInt = Integer.parseInt(inputString);
                breakOut = true;
            } else {
                System.out.println("Ej giltigt input, försök igen!");
            }
        }

        return inputInt;

    }

    public static boolean validateInput(String resultString) {
        return resultString.matches("\\d+");
    }
}