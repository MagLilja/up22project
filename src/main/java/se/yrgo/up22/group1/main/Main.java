package se.yrgo.up22.group1.main;

import se.yrgo.up22.group1.InitializedData;
import se.yrgo.up22.group1.country.Country;
import se.yrgo.up22.group1.match.Match;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        InitializedData initializedData = new InitializedData();
        Scanner scanner = new Scanner(System.in);
        Path mainMenu = Path.of("MainMenu.txt");
        if (Files.notExists(mainMenu)) {
            System.err.println("The file " + mainMenu + " does not exist!");
        }
        /*
        Damfotboll!
        Välj nedan:
        1.Se alla Landslag (sorterade efter FIFA-ranking)
        2.Se alla Spelare (sorterade efter...)
        3.Se alla Matcher (sorterade efter...)
        4.Se alla Coacher (sortera efter...)


         */


        menuStart(initializedData, scanner, mainMenu);


    }

    private static void menuStart(InitializedData initializedData, Scanner scanner, Path mainMenu) {
        while (true) {
            readInMainMenu(mainMenu);
            int menuChoice = getMenuChoice(scanner);

            switch (menuChoice) {
                case 1:
                    showCountriesList(initializedData);
                    showCountrysPlayersList(initializedData, scanner, mainMenu);

                case 2:

                    break;
                case 3:
                    initializedData.getListOfMatches().stream()
                            .sorted(Comparator.comparingInt(Match::getpublicNumber))
                            .forEach(System.out::println);
                    break;
                case 4:
                    break;
                case 5:
                    System.exit(0);
                    return;


            }
        }
    }

    private static void showCountrysPlayersList(InitializedData initializedData, Scanner scanner, Path mainMenu) {
        while (true) {
            System.out.println("Visa spelare för lag [nummer] eller avsluta med [0]");
            int menuChoiceNext = getMenuChoice(scanner);
            if (menuChoiceNext == 0) {
                menuStart(initializedData, scanner, mainMenu);
                return;
            } else if (menuChoiceNext <= initializedData.getListOfCountries().size()) {
                System.out.println(initializedData.getListOfCountries().get(menuChoiceNext).getPlayers());
            } else {
                System.out.println("Ej giltigt alternativ!");
            }

        }
    }

    private static void showCountriesList(InitializedData initializedData) {
        System.out.println("(sorterade efter FIFA-ranking)");
        AtomicInteger counter = new AtomicInteger(1);
        for (Country country : initializedData.getListOfCountries().stream().sorted().collect(Collectors.toList())) {
            System.out.println(counter.getAndIncrement() + ". " + country);
        }
    }

    private static void readInMainMenu(Path mainMenu) {
        try {
            Files.readAllLines(mainMenu).forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("An IOException on file: " + mainMenu.toString());
        }
    }

    private static int getMenuChoice(Scanner scanner) {

        int result = scanner.nextInt();
//            scanner.nextLine();
        return result;

    }
}
