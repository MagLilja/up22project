package se.yrgo.up22.group1.main.menus;

import se.yrgo.up22.group1.InitializedData;
import se.yrgo.up22.group1.country.Country;
import se.yrgo.up22.group1.main.Main;
import se.yrgo.up22.group1.main.MainUtils;

import java.nio.file.Path;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static se.yrgo.up22.group1.main.MainUtils.getMenuChoice;

/**
 * A static class for generating the menus for Country
 *
 *
 * @author Magnus Lilja
 */
public class CountryMenu {
    public static Path oneCountryMenu;
    static Path mainMenu;

    public CountryMenu() {

    }

    public static void countryMenu(Scanner scanner) {
        showCountriesList();
        System.out.println("Välj landslag [nummer] eller [0] för att gå tillbaka till huvudmenyn");
//        showCountrysPlayersList(initializedData, scanner, mainMenu);
        int userInput = getMenuChoice(scanner);
        if (userInput == 0) {
            Main.menuStart(scanner);
        } else {
            System.out.print(InitializedData.getListOfCountries().get(userInput).getName());
            oneCountryMenu(scanner);
        }

    }

    public static void oneCountryMenu(Scanner scanner) {
        readInMenu(oneCountryMenu);
        int userInput = MainUtils.getMenuChoice(scanner);
        if (userInput == 0) {
            Main.menuStart(scanner);
        }
        switch (userInput) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 0:
                break;


        }


    }

    private static void readInMenu(Path oneCountryMenu) {
    }

    public static void showCountrysPlayersList(Scanner scanner, Path mainMenu) {
        while (true) {
            System.out.println("Visa spelare för lag [nummer] eller avsluta med [0]");
            int menuChoiceNext = MainUtils.getMenuChoice(scanner);
            if (menuChoiceNext == 0) {
                Main.menuStart(scanner);
            } else if (menuChoiceNext <= InitializedData.getListOfCountries().size()) {
                System.out.println("Visar spelare för "
                        + InitializedData.getListOfCountries().get(menuChoiceNext).getName());
                System.out.println(InitializedData.getListOfCountries().get(menuChoiceNext).getPlayers());
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