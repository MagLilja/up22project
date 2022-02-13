package se.yrgo.up22.group1.main;

import se.yrgo.up22.group1.InitializedData;
import se.yrgo.up22.group1.coach.Coach;
import se.yrgo.up22.group1.main.menus.CountryMenu;
import se.yrgo.up22.group1.match.Match;
import se.yrgo.up22.group1.player.Player;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.Scanner;

import static se.yrgo.up22.group1.main.MainUtils.getMenuChoice;
import static se.yrgo.up22.group1.main.MainUtils.readInMenu;

public class Main {

    static Path mainMenu;


    public static void main(String[] args) {
        InitializedData.initializeData();

        Scanner scanner = new Scanner(System.in);
        mainMenu = Path.of("MainMenu.txt");
        if (Files.notExists(mainMenu)) {
            System.err.println("The file " + mainMenu + " does not exist!");
        }

        menuStart(scanner);

    }

    public static void menuStart(Scanner scanner) {
        while (true) {
            readInMenu(mainMenu);
            int menuChoice = getMenuChoice(scanner);

            switch (menuChoice) {

                case 1:
                    CountryMenu.countryMenu(scanner);
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
