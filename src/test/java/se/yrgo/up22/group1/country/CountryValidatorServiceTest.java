package se.yrgo.up22.group1.country;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import se.yrgo.up22.group1.player.Player;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CountryValidatorServiceTest {
    Country usa;


    @BeforeEach
    void setUp() {
        usa = new Country("USA");
    }

    @ParameterizedTest
    @ValueSource(ints = {211, 0})
    void validateFIFARankingReturnsFalseTest(int ranking) {
        assertFalse(CountryValidatorService.validateFIFARanking(ranking));
    }

    @ParameterizedTest
    @ValueSource(ints = {2110, 356})
    void validateFIFARankingPointsReturnsFalseTest(int rankingPoints) {
        assertFalse(CountryValidatorService.validateFIFARankingPoints(rankingPoints));;
    }

    @Test
    void validateMaxPlayersMethodShouldReturnTrueWithLessThan25PlayersTest() {
        // given
        List<Player> listOf24Players = new ArrayList<>();
        for (int i = 1; i <= 24; i++) {
            listOf24Players.add(new Player("Magnus"));
        }
        assertTrue(CountryValidatorService.validateMaxPlayers(usa,listOf24Players));
    }

    @Test
    void validateMaxPlayersMethodShouldReturnTrueWithLessThan25PlayersAddedToTeamWithPlayersTest() {
        usa.addPlayer(new Player("Eyvind"));
        // given
        List<Player> listOf20Players = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            listOf20Players.add(new Player("Magnus"));
        }
        assertTrue(CountryValidatorService.validateMaxPlayers(usa,listOf20Players));
    }
}