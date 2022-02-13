package se.yrgo.up22.group1.country;

import se.yrgo.up22.group1.player.Player;

import java.util.List;
import java.util.Optional;
/**
 * A service class for the Country class
 * @author Magnus Lilja
 */
public class CountryValidatorService {

    // Bounds for points taken from FIFA official doc:
    // https://digitalhub.fifa.com/m/f99da4f73212220/original/edbm045h0udbwkqew35a-pdf.pdf
    public static boolean validateFIFARankingPoints(double FIFARankingPoints) {
        return (FIFARankingPoints <= 2109.09 && FIFARankingPoints > 357);
    }


    // 210 teams
    public static boolean validateFIFARanking(int FIFARanking) {
        return (FIFARanking <= 210 && FIFARanking > 0);
    }

    // max 24 players in a team
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