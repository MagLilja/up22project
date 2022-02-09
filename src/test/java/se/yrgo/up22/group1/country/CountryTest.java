package se.yrgo.up22.group1.country;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import se.yrgo.up22.group1.coach.Coach;
import se.yrgo.up22.group1.match.Match;
import se.yrgo.up22.group1.player.Player;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CountryTest {
    Country sweden;
    Country usa;
    Country ghana;

    Player caroline;
    Player lina;
    Player fridolina;

    Match semiFinal;
    Match finale;

    Coach peter;
    List<Player> listOfPlayers = new ArrayList<>();
    List<Match> listOfMatches = new ArrayList<>();

    @BeforeEach
    void beforeEach() {

        lina = new Player("Lina Hurtig");
        caroline = new Player("Caroline Seger");
        fridolina = new Player("Fridolina Rolfö");

        listOfPlayers.add(caroline);
        listOfPlayers.add(lina);
        listOfPlayers.add(fridolina);

        semiFinal = new Match();
        finale = new Match();

        listOfMatches.add(semiFinal);
        listOfMatches.add(finale);

        peter = new Coach("Peter Gerhardsson");

        sweden = new Country("Sweden");
        usa = new Country("USA", 1, 2109.09);
    }
    @Test
    @DisplayName("Add FIFA rankings, a List of players and list of matches with constructor")
    void AddFIFAListofPlayersListofMatchesWithConstructorTest() {
        // given
        ghana = new Country("Ghana", 5, 1734, listOfPlayers,listOfMatches,peter);
        // when
        assertNotNull(ghana);
    }


    @Test
    @DisplayName("Can add one player test to empty country team")
    void addOnePlayerToEmptyTeamTest() {
        // given
        Country sweden = new Country("Sweden");
        // when
        int expectedAmountOfPlayers = 1;
        sweden.addPlayer(fridolina);
        int amountOfPlayers = sweden.getPlayers().size();
        // then
        assertEquals(expectedAmountOfPlayers, amountOfPlayers);
    }

    @Test
    @DisplayName("Can add one player to country with players test")
        // Will also assert that getName() and Country(String name) is passed.
    void addOnePlayerToTeamWithPlayersTest() {
        // given
        Country sweden = new Country("Sweden");
        // when
        int expectedAmountOfPlayers = 1;
        sweden.addPlayer(fridolina);
        sweden.addPlayer(lina);
        int amountOfPlayers = sweden.getPlayers().size();
        // then
        assertEquals(expectedAmountOfPlayers, amountOfPlayers);
    }

    @Test
    @DisplayName("add list of players to empty team")
    void addListOfPlayersWithAddPlayerMethodToEmptyTeamTest() {
        // given
        Country sweden = new Country("Sweden");
        Player fridolina = new Player("Fridolina Rolfö");
        Player lina = new Player("Lina Hurtig");
        List<Player> squad = new ArrayList<>();
        squad.add(fridolina);
        squad.add(lina);
        // when
        sweden.addPlayer(squad);
        int expectedAmountOfPlayers = 2;
        int amountOfPlayers = sweden.getPlayers().size();
        // then
        assertEquals(expectedAmountOfPlayers, amountOfPlayers);

    }

    @Test
    @DisplayName("add list of players to team with players")
    void addListOfPlayersWithAddPlayerMethodToNotEmptyTeamTest() {
        // given
        Player fridolina = new Player("Fridolina Rolfö");
        List<Player> squad = new ArrayList<>();
        squad.add(fridolina);
        List<Player> addToSquad = new ArrayList<>();
        addToSquad.add(lina);
        // when
        sweden.addPlayer(squad);
        sweden.addPlayer(addToSquad);
        int expectedAmountOfPlayers = 2;
        int amountOfPlayers = sweden.getPlayers().size();
        // then
        assertEquals(expectedAmountOfPlayers, amountOfPlayers);
    }

    @Test
    @DisplayName("Can add a list of players with constructor test")
    void addListOfPlayersWithConstructorTest() {
        // given
        List<Player> squad = new ArrayList<>();
        squad.add(lina);
        Country sweden1 = new Country("Sweden", squad, peter);
        // when
        int expectedAmountOfPlayers = 1;
        int amountOfPlayers = sweden1.getPlayers().size();
        // then
        assertEquals(expectedAmountOfPlayers, amountOfPlayers);
    }

    @Test
    void getNameTest() {
        // when
        String expectedName = "Sweden";
        String actualName = sweden.getName();
        // then
        assertEquals(expectedName, actualName);
    }

    @Test
    void getFIFARankingTest() {
        // given
        // when
        int expectedRanking = 1;
        int actualRanking = usa.getFIFARanking();
        // then
        assertEquals(expectedRanking, actualRanking);
    }

    @ParameterizedTest
    @ValueSource(ints = {211, 0})
    void validateThatsetFIFARankingThrowsInputMismatchExceptionTest(int ranking) {
        assertThrows(InputMismatchException.class, () ->
                usa.setFIFARanking(ranking));
    }

    @ParameterizedTest
    @ValueSource(ints = {2110, 356})
    void validateThatsetFIFARankingPointsThrowsInputMismatchExceptionTest(int rankingPoints) {
        assertThrows(InputMismatchException.class, () ->
                usa.setFIFARankingPoints(rankingPoints));
    }

    @Test
    void getFIFARankingPoints() {
        // given

        // when

        // then
    }

    @Test
    void getPlayers() {
        // given

        // when

        // then
    }

    @Test
    void getCoach() {
        // given

        // when

        // then
    }
}