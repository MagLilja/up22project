package se.yrgo.up22.group1.country;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import se.yrgo.up22.group1.player.Player;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CountryValidatorsTest {
    Country usa;


    @BeforeEach
    void setUp() {
        usa = new Country("USA");
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
    void validateMaxPlayersMethodShouldThrowExceptionTest() {
        // given
        List<Player> listOf26Players = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            listOf26Players.add(new Player("Magnus"));
        }
        // when

        // then
        assertThrows(IllegalStateException.class, () ->
                usa.addPlayer(listOf26Players));
    }

    @Test
    void validateMaxPlayersMethodShouldReturnTrueWithLessThan25PlayersTest() {
        // given
        List<Player> listOf26Players = new ArrayList<>();
        for (int i = 0; i < 24; i++) {
            listOf26Players.add(new Player("Magnus"));
        }
        // when

        // then

        assertTrue(CountryValidators.validateMaxPlayers(usa,listOf26Players));
    }
}