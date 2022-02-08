package se.yrgo.up22.group1.country;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import se.yrgo.up22.group1.coach.Coach;
import se.yrgo.up22.group1.player.Player;


import javax.management.ConstructorParameters;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CountryTest {
    Country sweden;
    Country usa;
    Player caroline;
    Player lina;
    Player fridolina;
    Coach peter;

    @BeforeEach
    void beforeEach() {
        sweden = new Country("Sweden");
        lina = new Player("Lina Hurtig");
        caroline = new Player("Caroline Seger");
        fridolina = new Player("Fridolina Rolfö");
        peter = new Coach("Peter Gerhardsson");
        usa = new Country("USA", 1, 2109.09);
    }


    @Test
    @DisplayName("Can add one player test to empty country team")
        // Will also assert that getName() and Country(String name) is passed.
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
    @DisplayName("add list of players to empty team")
    void addListOfPlayersWithAddPlayerMethodToEmptyTeamTest() {
        // given
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