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
 * @author Magnus Lilja
 */
public class Main {


    public static void main(String[] args) throws FileNotFoundException {
        InitializedData.initializeData();
        Scanner scanner = new Scanner(System.in);
        Path mainMenu = Path.of("MainMenu.txt");
        if (validateMainMenuTextFile(mainMenu)) {
            menuStart(scanner, mainMenu);
        }

    }

    public static boolean validateMainMenuTextFile(Path mainMenu) throws FileNotFoundException {
        if (Files.notExists(mainMenu)) {
            throw new FileNotFoundException("The file " + mainMenu + " does not exist!");
        }
        return true;
    }

    public static void menuStart(Scanner scanner, Path mainMenu) {
        while (true) {
            readInMenu(mainMenu);
            int menuChoice = getAndValidateMenuChoice(scanner);
            switch (menuChoice) {
                case 1:
                    CountryMenu.countryMenu(scanner, mainMenu);
                    break;
                case 2:
                    System.out.println("############## Alla spelare ##############");
                    InitializedData.getListOfPlayers().stream()
                            .sorted(Comparator.comparingInt(Player::getGamesPlayed))
                            .forEach(System.out::println);
                    break;
                case 3:
                    System.out.println("############## Alla matcher ##############");
                    InitializedData.getListOfMatches().stream()
                            .sorted(Comparator.comparingInt(Match::getpublicNumber))
                            .forEach(System.out::println);
                    break;
                case 4:
                    System.out.println("############## Alla tränare ##############");
                    InitializedData.getListOfCoaches().stream()
                            .forEach(System.out::println);
                    break;
                case 5:
                    System.out.println("Programmet avslutat!");
                    System.exit(0);
                    return;
            }
        }
    }


}
