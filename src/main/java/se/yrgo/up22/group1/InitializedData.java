package se.yrgo.up22.group1;

import se.yrgo.up22.group1.coach.Coach;
import se.yrgo.up22.group1.country.Country;
import se.yrgo.up22.group1.match.Match;
import se.yrgo.up22.group1.player.Player;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InitializedData {

    // ######### Coach #########

    // Initialize 10 coaches
    // Initialize a List<> of coaches
    private static List<Coach> listOfCoaches = new ArrayList<>();

    public static List<Coach> getListOfCoaches() {
        return listOfCoaches;
    }
    // ######### Player #########
    // Initialize 10 players
    // Initialize a List<> of players

    private static List<Player> listOfPlayers = new ArrayList<>();// = List.of(new Player("Spelare"), new Player("En spelare till"));
    private static Player lina = new Player("Lina Hurtig", 26, "Juventus", 164, 49);
    private static Player hanna = new Player("Hanna Glas", 28, " FC Bayern München ", 306, 78);
    private static Player caroline = new Player("Caroline Seger", 26, " Juventus ", 211, 26);

    public static List<Player> getListOfPlayers() {
        return listOfPlayers;
    }


    // ######### Match #########
    // Initialize 10 matches
    // Initialize a List<> of matches
    private static List<Match> listOfMatches = new ArrayList<>();

    // ######### Country #########
    // Initialize 10 countries
    // Initialize a List<> of countries

    private static Coach coach = new Coach("Peter Pan");
    private static Country usa = new Country("USA", 1, 2109.09, listOfPlayers, coach);
    private static Country sweden = new Country("Sweden", 2, 2079, listOfPlayers, coach);
    private static Country germany = new Country("Germany", 3, 2070, listOfPlayers, coach);
    private static Country france = new Country("France", 4, 2034, listOfPlayers, coach);
    private static Country netherlands = new Country("Netherlands", 5, 2021, listOfPlayers, coach);
    private static Country canada = new Country("Canada", 6, 2007, listOfPlayers, coach);
    private static Country brazil = new Country("Brazil", 7, 1976, listOfPlayers, coach);
    private static Country england = new Country("England", 8, 1974, listOfPlayers, coach);
    private static Country spain = new Country("Spain", 9, 1959, listOfPlayers, coach);
    private static Country koreaDPR = new Country("Korea DPR", 9, 1904, listOfPlayers, coach);

    private static List<Country> listOfCountries = new ArrayList<>();

    public static void initializeData() {

        Collections.addAll(listOfCountries, sweden, usa, germany, france, netherlands, canada, brazil, england, spain,
                koreaDPR);

        Collections.addAll(listOfPlayers, lina, caroline, hanna);
        Collections.addAll(listOfCoaches, new Coach("Rolf Ulfsson"), new Coach("Uffe Fritzzon"));


        Collections.addAll(listOfMatches,
                new Match(canada, sweden, "Parc des Princes", ZonedDateTime.now(), 0, 1, 10000, Collections.emptyList(),
                        Collections.emptyList()),
                new Match(france, brazil, "Stade Océane", ZonedDateTime.now(), 2, 1, 12000, Collections.emptyList(),
                        Collections.emptyList()),
                new Match(spain, usa, "Stade Auguste-Delaune", ZonedDateTime.now(), 1, 2, 8800, Collections.emptyList(),
                        Collections.emptyList()),
                new Match(england, sweden, "Stade de Nice", ZonedDateTime.now(), 1, 2, 11280, Collections.emptyList(),
                        Collections.emptyList()),
                new Match(germany, netherlands, "Roazhon Park", ZonedDateTime.now(), 2, 3, 12990,
                        Collections.emptyList(), Collections.emptyList()),
                new Match(canada, koreaDPR, "Stade de Lyon", ZonedDateTime.now(), 0, 1, 7400, Collections.emptyList(),
                        Collections.emptyList()),
                new Match(france, usa, "Stade de Lyon", ZonedDateTime.now(), 1, 3, 12118, Collections.emptyList(),
                        Collections.emptyList()),
                new Match(brazil, spain, "Stade Auguste-Delaune", ZonedDateTime.now(), 0, 1, 12699,
                        Collections.emptyList(), Collections.emptyList()),
                new Match(sweden, germany, "Roazhon Park", ZonedDateTime.now(), 2, 1, 13000, Collections.emptyList(),
                        Collections.emptyList()),
                new Match(england, canada, "Stade Océane", ZonedDateTime.now(), 2, 2, 10358, Collections.emptyList(),
                        Collections.emptyList()),
                new Match(netherlands, koreaDPR, "Stade de Nice", ZonedDateTime.now(), 3, 1, 90212,
                        Collections.emptyList(), Collections.emptyList()));

    }

    public static List<Match> getListOfMatches() {
        return listOfMatches;
    }

    public static List<Country> getListOfCountries() {
        return listOfCountries;
    }
}
