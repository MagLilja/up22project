package se.yrgo.up22.group1.main.menus;

import se.yrgo.up22.group1.InitializedData;
import se.yrgo.up22.group1.country.Country;
import se.yrgo.up22.group1.main.Main;
import se.yrgo.up22.group1.main.MainUtils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static se.yrgo.up22.group1.main.MainUtils.getMenuChoice;
import static se.yrgo.up22.group1.main.MainUtils.readInMenu;

/**
 * A static class for generating the menus for Country
 *
 * @author Magnus Lilja
 */
public class CountryMenu {
    public static Path oneCountryMenu;
    static Path mainMenu;

    public static void countryMenu(Scanner scanner) {
        showCountriesList();
        System.out.println("Välj landslag [nummer] eller [0] för att gå tillbaka till huvudmenyn");
//
        int countryChoice = getMenuChoice(scanner);
        if (countryChoice == 0) {
            Main.menuStart(scanner);
        } else {

            oneCountryMenu(scanner, countryChoice);
        }

    }

    public static void oneCountryMenu(Scanner scanner, int countryChoice) {
        System.out.print("############## " + InitializedData.getListOfCountries().get(countryChoice).getName() + " ##############");
        oneCountryMenu = Path.of("CountryMenu.txt");
        if (Files.notExists(oneCountryMenu)) {
            System.err.println("The file " + oneCountryMenu + " does not exist!");
        }
        readInMenu(oneCountryMenu);

        while (true) {
            int userInput = MainUtils.getMenuChoice(scanner);
            if (userInput == 0) {
                Main.menuStart(scanner);
            }
            switch (userInput) {
                case 1:
                    showCountrysPlayersList(scanner, countryChoice);
                    break;
                case 2:
                    System.out.println("2");
                    break;
                case 3:
                    System.out.println("3");
                    break;
                case 4:
                    System.out.println("4");
                    break;
                case 0:
                    break;
            }

        }


    }


    public static void showCountrysPlayersList(Scanner scanner, int countryChoice) {
        while (true) {
            System.out.println("############## Visar spelare för " + InitializedData.getListOfCountries().get(countryChoice).getName() + " ##############");
            InitializedData.getListOfCountries().get(countryChoice).getPlayers().forEach(System.out::println);

            System.out.println("Återvänd med [0]");
            int menuChoiceNext = MainUtils.getMenuChoice(scanner);
            if (menuChoiceNext == 0) {
                oneCountryMenu(scanner, countryChoice);
            } else if (menuChoiceNext <= InitializedData.getListOfCountries().size()) {
            } else {
                System.out.println("Ej giltigt alternativ!");
            }

        }
    }

    public static void showCountriesList() {
        System.out.println("(sorterade efter FIFA-ranking)");
        AtomicInteger counter = new AtomicInteger(1);
        for (Country country : InitializedData.getListOfCountries().stream().sorted().collect(Collectors.toList())) {
            System.out.println(counter.getAndIncrement() + ". " + country);
        }
    }
}