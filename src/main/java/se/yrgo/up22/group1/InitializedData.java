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

    // ######### Player #########
    // Initialize 10 players
    // Initialize a List<> of players

    // ######### Match #########
    // Initialize 10 matches
    // Initialize a List<> of matches

    // ######### Country #########
    // Initialize 10 countries
    // Initialize a List<> of countries

    List<Player> listOfPlayers = new ArrayList<>();
    List<Match> listOfMatches = new ArrayList<>();
    Coach coach = new Coach("peter");
    Country usa = new Country("USA", 1, 2109.09, listOfPlayers, coach);
    Country sweden = new Country("Sweden", 2, 2079, listOfPlayers,  coach);
    Country germany = new Country("Germany", 3, 2070, listOfPlayers, coach);
    Country france = new Country("France", 4, 2034, listOfPlayers, coach);
    Country netherlands = new Country("Netherlands", 5, 2021, listOfPlayers, coach);
    Country canada = new Country("Canada", 6, 2007, listOfPlayers, coach);
    Country brazil = new Country("Brazil", 7, 1976, listOfPlayers, coach);
    Country england = new Country("England", 8, 1974, listOfPlayers, coach);
    Country spain = new Country("Spain", 9, 1959, listOfPlayers, coach);
    Country koreaDPR = new Country("Korea DPR", 9, 1904, listOfPlayers, coach);

    List<Country> listOfCountries = new ArrayList<>();

    public InitializedData() {
        Collections.addAll(listOfCountries, sweden, usa, germany, france, netherlands, canada, brazil, england, spain, koreaDPR);
        Collections.addAll(listOfMatches, new Match(canada, sweden, "Parc des Princes", ZonedDateTime.now(), 0, 1, 10000, Collections.emptyList(), Collections.emptyList()),
        new Match(france, brazil, "Stade Océane", ZonedDateTime.now(), 2, 1, 12000, Collections.emptyList(), Collections.emptyList()), 
        new Match(spain, usa, "Stade Auguste-Delaune", ZonedDateTime.now(),1, 2, 8800, Collections.emptyList(), Collections.emptyList()),
        new Match());

    }

    public List<Country> getListOfCountries() {
        return listOfCountries;
    }
}
