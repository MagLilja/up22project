package se.yrgo.up22.group1.country;

import se.yrgo.up22.group1.player.Player;

import java.util.List;

public class CountryValidators {

    // Bounds for points taken from FIFA official doc:
    // https://digitalhub.fifa.com/m/f99da4f73212220/original/edbm045h0udbwkqew35a-pdf.pdf
    public static boolean validateFIFARankingPoints(double FIFARankingPoints) {
        if (FIFARankingPoints > 2109.09 || FIFARankingPoints <= 357) {
            return false;
        } else {
            return true;
        }
    }

    // 210 teams
    public static boolean validateFIFARanking(int FIFARanking) {
        if (FIFARanking > 210 || FIFARanking <= 0) {
            return false;
        } else {
            return true;
        }
    }

    // max 24 players in a team
    public static boolean validateMaxPlayers(Country country, List<Player> tempPlayerList) {
        if ((country.getPlayers() != null ? country.getPlayers().size() : 0) + tempPlayerList.size() > 24) {
            throw new IllegalStateException("Too many players in the team. Got: " + country.getPlayers().size() + "Trying to add: " + tempPlayerList.size());
        }
        return true;
    }
}