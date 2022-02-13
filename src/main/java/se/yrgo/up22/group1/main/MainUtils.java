package se.yrgo.up22.group1.main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.Scanner;
/**
 * Utility class for the Main class for this small international football teams application.
 * @author Magnus Lilja
 */
public class MainUtils {
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

    public static int getAndValidateMenuChoice(Scanner scanner) {
        boolean breakOut = false;
        int resultInt = 0;
        while (!breakOut) {
            String resultString = scanner.nextLine();
            if (resultString.matches("\\d+")) {
                resultInt = Integer.parseInt(resultString);
                breakOut = true;
            } else {
                System.out.println("Ej giltigt input, försök igen!");
            }
        }

        return resultInt;

    }
}