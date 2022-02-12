package se.yrgo.up22.group1.main;

import se.yrgo.up22.group1.InitializedData;
import se.yrgo.up22.group1.main.menus.CountryMenu;
import se.yrgo.up22.group1.match.Match;

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
        CountryMenu.oneCountryMenu = Path.of("CountryMenu.txt");
        if (Files.notExists(CountryMenu.oneCountryMenu)) {
            System.err.println("The file " + CountryMenu.oneCountryMenu + " does not exist!");
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
                    break;
                //Match menu
                case 3:
                    InitializedData.getListOfMatches().stream()
                            .sorted(Comparator.comparingInt(Match::getpublicNumber))
                            .forEach(System.out::println);
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("Programmet avslutat!");
                    System.exit(0);
                    return;


            }
        }
    }


}
