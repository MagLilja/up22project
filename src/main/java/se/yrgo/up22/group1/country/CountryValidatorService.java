package se.yrgo.up22.group1.country;

import se.yrgo.up22.group1.player.Player;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * A service class for the Country class
 *
 * @author Magnus Lilja
 */
public class CountryValidatorService {

    // Bounds for points taken from FIFA official doc:
    // https://digitalhub.fifa.com/m/f99da4f73212220/original/edbm045h0udbwkqew35a-pdf.pdf

    /**
     * A method to validate FIFA ranking points. Taken from the current points february 2022, the maximum is 2109.09 and the minimum points a team can have is 357
     *
     * @param FIFARankingPoints
     * @return
     */
    public static boolean validateFIFARankingPoints(double FIFARankingPoints) {
        return (FIFARankingPoints <= 2109.09 && FIFARankingPoints > 357);
    }


    /**
     * A method to validate FIFA ranking. Taken from the current data, february 2022, the maximum is 210 and the minimum a team can have is 0.
     *
     * @param FIFARanking
     * @return
     */
    public static boolean validateFIFARanking(int FIFARanking) {
        return (FIFARanking <= 210 && FIFARanking > 0);
    }


    /**
     * A method to that a countrys squad size is not more than the allowed 24 players.
     *
     * @param country
     * @param tempPlayerList
     * @return
     */
    public static boolean validateMaxPlayers(Country country, List<Player> tempPlayerList) {
        int currentTeamSize;

        if (country.getPlayers() != null) {
            currentTeamSize = country.getPlayers().size();
        } else {
            currentTeamSize = 0;
        }
        return (currentTeamSize + tempPlayerList.size() <= 24);
    }
}