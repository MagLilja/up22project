package se.yrgo.up22.group1.match;

import se.yrgo.up22.group1.player.Player;
import se.yrgo.up22.group1.country.Country;

import java.time.ZonedDateTime;
import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;


public class Match {
    private Country nationalTeamA;
    private Country nationalTeamB;
    private String arena;
    private ZonedDateTime matchDateAndTime;
    private int nationalTeamAScore;
    private int nationalTeamBScore;
    private int publicNumber;
    private List<Player> nationalTeamAPlayers;
    private List<Player> nationalTeamBPlayers;

    public Match(Country nationalTeamA, Country nationalTeamB, String arena, ZonedDateTime matchDateAndTime,
            int nationalTeamAScore, int nationalTeamBScore, int publicNumber, List<Player> nationTeamAPlayers,
            List<Player> nationalTeamBPlayers) {
        if (nationalTeamA == null) {
            throw new RuntimeException("Invalid nationalTeamA");
        }
        this.nationalTeamA = nationalTeamA;
        if (nationalTeamB == null) {
            throw new RuntimeException("Invalid nationalTeamB");
        }
        this.nationalTeamB = nationalTeamB;
        if (arena == null || arena.isBlank()) {
            throw new RuntimeException("Invalid arena");
        }
        this.arena = arena;
        if (matchDateAndTime == null) {
            throw new RuntimeException("Invalid matchDateAndTime");
        }
        this.matchDateAndTime = matchDateAndTime;

        this.nationalTeamAScore = nationalTeamAScore;
        this.nationalTeamBScore = nationalTeamBScore;
        
        if (publicNumber < 0) {
            throw new RuntimeException("Invalid publicNumber");
        }
        this.publicNumber = publicNumber;

        this.nationalTeamAPlayers = nationTeamAPlayers;
        this.nationalTeamBPlayers = nationalTeamBPlayers;
    }

    public Country getNationalTeamA() {
        return nationalTeamA;
    }

    public Country getNationalTeamB() {
        return nationalTeamB;
    }

    public String getarena() {
        return arena;
    }

    public ZonedDateTime getmatchDateAndTime() {
        return matchDateAndTime;
    }

    public int getnationalTeamAScore() {
        return nationalTeamAScore;
    }

    public int getnationalTeamBScore() {
        return nationalTeamBScore;
    }

    public int getpublicNumber() {
        return publicNumber;
    }

    public List<Player> nationalTeamAplayers() {
        return nationalTeamAPlayers;
    }

    public List<Player> nationalTeamBplayers() {
        return nationalTeamBPlayers;
    }
}
