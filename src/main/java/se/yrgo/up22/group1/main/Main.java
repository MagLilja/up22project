package se.yrgo.up22.group1.main;

import se.yrgo.up22.group1.InitializedData;
import se.yrgo.up22.group1.main.menus.CountryMenu;
import se.yrgo.up22.group1.match.Match;
import se.yrgo.up22.group1.player.Player;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.Scanner;

import static se.yrgo.up22.group1.main.MainUtils.getAndValidateMenuChoice;
import static se.yrgo.up22.group1.main.MainUtils.readInMenu;

/**
 * Main class for this small international football teams application.
 *
 * @author Magnus Lilja
 */
public class Main {

    /**
     * Main method for the application.
     *
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        initializeData();
        Scanner scanner = new Scanner(System.in);
        Path mainMenu = Path.of("MainMenu.txt");
        if (validateMainMenuTextFile(mainMenu)) {
            startMenu(scanner, mainMenu);
        }

    }

    /**
     * Method where the data is initialized from the static data class
     */
    private static void initializeData() {
        InitializedData.initializeData();
    }

    /**
     * Method to validate that the the main menu file exists
     *
     * @param mainMenu
     * @return
     * @throws FileNotFoundException
     */
    public static boolean validateMainMenuTextFile(Path mainMenu) throws FileNotFoundException {
        if (Files.notExists(mainMenu)) {
            throw new FileNotFoundException("The file " + mainMenu + " does not exist!");
        }
        return true;
    }

    /**
     * Method to initialize the start menu
     *
     * @param scanner
     * @param mainMenu
     */
    public static void startMenu(Scanner scanner, Path mainMenu) {
        while (true) {
            readInMenu(mainMenu);
            int menuChoice = getAndValidateMenuChoice(scanner);
            switch (menuChoice) {
                case 1:
                    CountryMenu.countryMenu(scanner, mainMenu);
                    break;
                case 2:
                    printAllPlayersToConsole();
                    break;
                case 3:
                    printAllMatchesToConsole();
                    break;
                case 4:
                    printAllCoachesToConsole();
                    break;
                case 5:
                    System.out.println("Programmet avslutat!");
                    System.exit(0);
                    return;
            }
        }
    }

    /**
     * Method to print all the coaches in the intialized data to the console.
     */
    private static void printAllCoachesToConsole() {
        System.out.println("############## Alla tränare ##############");
        InitializedData.getListOfCoaches().stream()
                .forEach(System.out::println);
    }

    /**
     * Method to print all the matches in the intialized data to the console.
     */
    private static void printAllMatchesToConsole() {
        System.out.println("############## Alla matcher ##############");
        InitializedData.getListOfMatches().stream()
                .sorted(Comparator.comparingInt(Match::getpublicNumber))
                .forEach(System.out::println);
    }

    /**
     * Method to print all the players in the intialized data to the console.
     */
    private static void printAllPlayersToConsole() {
        System.out.println("############## Alla spelare ##############");
        InitializedData.getListOfPlayers().stream()
                .sorted(Comparator.comparingInt(Player::getPlayedMatches))
                .forEach(System.out::println);
    }


}
