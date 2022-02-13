package se.yrgo.up22.group1.main.menus;

import se.yrgo.up22.group1.InitializedData;
import se.yrgo.up22.group1.country.Country;
import se.yrgo.up22.group1.main.Main;
import se.yrgo.up22.group1.main.MainUtils;
import se.yrgo.up22.group1.match.Match;
import se.yrgo.up22.group1.player.Player;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static se.yrgo.up22.group1.main.MainUtils.getAndValidateMenuChoice;
import static se.yrgo.up22.group1.main.MainUtils.readInMenu;

/**
 * A static class for generating the menus for Country
 *
 * @author Magnus Lilja
 */
public class CountryMenu {
    public static Path oneCountryMenu;
    private static Path mainMenu;

    /**
     * A static method to generate a menu for Countries
     *
     * @param scanner
     * @param mainMenuIn
     */
    public static void countryMenu(Scanner scanner, Path mainMenuIn) {
        mainMenu = mainMenuIn;
        showCountriesList();
        System.out.println("Välj landslag [nummer] eller [0] för att gå tillbaka till huvudmenyn");
//
        int countryChoice = getAndValidateMenuChoice(scanner);
        if (countryChoice == 0) {
            Main.startMenu(scanner, mainMenu);
        } else {

            oneCountryMenu(scanner, countryChoice);
        }

    }

    /**
     * A static method to generate a menu for the choosen country.
     *
     * @param scanner
     * @param countryChoice index of the choosen country
     */
    public static void oneCountryMenu(Scanner scanner, int countryChoice) {
        Country activeCountry = InitializedData.getListOfCountries().get(countryChoice);
        System.out.print("############## " + InitializedData.getListOfCountries().get(countryChoice).getName() + " ##############");
        oneCountryMenu = Path.of("CountryMenu.txt");
        if (Files.notExists(oneCountryMenu)) {
            System.err.println("The file " + oneCountryMenu + " does not exist!");
        }
        readInMenu(oneCountryMenu);

        while (true) {
            int userInput = MainUtils.getAndValidateMenuChoice(scanner);
            switch (userInput) {
                case 1:
                    showCountrysPlayersList(scanner, countryChoice);
                    break;
                case 2:
                    showCountrysMatches(scanner, activeCountry);
                    break;
                case 3:
                    System.out.println("\t\t############## Coach: " + activeCountry.getName() + " ##############");
                    String activeCountrysCoach = activeCountry.getCoach().getName();
                    System.out.println("\t\t" + activeCountrysCoach);
                    oneCountryMenu(scanner, countryChoice);
                    break;
                case 0:
                    Main.startMenu(scanner, mainMenu);
                    break;
            }

        }


    }

    /**
     * A static method to show all matches that a Country is part of in the menu.
     *
     * @param scanner
     * @param activeCountry The Choosen Country
     */
    private static void showCountrysMatches(Scanner scanner, Country activeCountry) {
        Predicate<Match> isTeamA = match -> match.getNationalTeamA().equals(activeCountry);
        Predicate<Match> isTeamB = match -> match.getNationalTeamB().equals(activeCountry);

        InitializedData.getListOfMatches().stream()
                .filter(isTeamA.or(isTeamB))
                .forEach(match -> System.out.println("\t\t" + match));
        System.out.println("\t\t" + "Återvänd med [0]");

        int menuChoiceNext = MainUtils.getAndValidateMenuChoice(scanner);
        if (menuChoiceNext == 0) {
            oneCountryMenu(scanner, InitializedData.getListOfCountries().indexOf(activeCountry));
        }

    }

    /**
     * A static method to show a Countrys list of players in the menu
     *
     * @param scanner
     * @param countryChoice index used to get the choosen country
     */
    public static void showCountrysPlayersList(Scanner scanner, int countryChoice) {
        while (true) {
            Country activeCountry = InitializedData.getListOfCountries().get(countryChoice);
            System.out.println("\t\t############## Visar spelare för " + activeCountry.getName() + " ##############");
            AtomicInteger counter = new AtomicInteger(1);
            activeCountry.getPlayers().forEach(player -> {
                System.out.print("\t\t" + counter.getAndIncrement() + ". ");
                System.out.println("\t\t" + player);
            });

            System.out.println("\t\t" + "Återvänd med [0], lägg till spelare [1], ta bort spelare [2]");
            int menuChoiceNext = MainUtils.getAndValidateMenuChoice(scanner);
            if (menuChoiceNext == 0) {
                oneCountryMenu(scanner, countryChoice);
            } else if (menuChoiceNext == 1) {
                addPlayerToActiveCountry(scanner, activeCountry);
            } else if (menuChoiceNext == 2) {
                removePlayerFromActiveCountry(scanner, activeCountry, countryChoice);

            } else {
                System.out.println("Ej giltigt alternativ!");
            }

        }
    }

    /**
     * A static method to use the menu to remove a player from the choosen Country.
     *
     * @param scanner
     * @param activeCountry The active Country
     * @param countryChoice index used to get the choosen country
     */
    private static void removePlayerFromActiveCountry(Scanner scanner, Country activeCountry, int countryChoice) {
        while (true) {
            System.out.println("\t\t############## Ta bort spelare från " + activeCountry.getName() + " ##############");
            AtomicInteger counter = new AtomicInteger(1);
            activeCountry.getPlayers().forEach(player -> {
                System.out.print("\t\t" + counter.getAndIncrement() + ". ");
                System.out.println("\t\t" + player);
            });
            if (activeCountry.getPlayers().isEmpty()) {
                System.out.println("\t\t" + "Inga spelare, återvänd med [0]");

            }
            System.out.println("\t\t" + "Ange [nummer] på spelare du vill ta bort, återvänd med [0]");
            int playerNumberChoice = MainUtils.getAndValidateMenuChoice(scanner);
            if (playerNumberChoice == 0) {
                oneCountryMenu(scanner, countryChoice);
            } else {
                if (!activeCountry.getPlayers().isEmpty()) {
                    Player choosenPlayer = activeCountry.getPlayers().get(playerNumberChoice - 1);
                    activeCountry.getPlayers().remove(choosenPlayer);
                    System.out.println(choosenPlayer.getName() + " borttagen!");
                }
            }
        }
    }

    /**
     * A static method to add a player to the active Country
     *
     * @param scanner
     * @param activeCountry The active Country
     */
    private static void addPlayerToActiveCountry(Scanner scanner, Country activeCountry) {
        System.out.println("############## Lägg till spelare för " + activeCountry.getName() + " ##############");
        System.out.println("Namn: ");
        String name = scanner.nextLine();
        System.out.println("Ålder: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Spelade matcher: ");
        int gamesPlayed = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Lagda mål: ");
        int goalsScored = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Hemmaklubb: ");
        String club = scanner.nextLine();
        Player newPLayer = new Player(name, age, club, gamesPlayed, goalsScored);
        activeCountry.addPlayer(newPLayer);
        if (activeCountry.getPlayers().contains(newPLayer)) {
            System.out.println("Spelare tillagd!");
        } else {
            System.out.println("Ej tillagd!");
        }

    }

    /**
     * A static method to show all countrys available in the data
     */
    public static void showCountriesList() {
        System.out.println("(sorterade efter FIFA-ranking)");
        AtomicInteger counter = new AtomicInteger(1);
        for (Country country : InitializedData.getListOfCountries().stream().sorted().collect(Collectors.toList())) {
            System.out.println(counter.getAndIncrement() + ". " + country);
        }
    }
}