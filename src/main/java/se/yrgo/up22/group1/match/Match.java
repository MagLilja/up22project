package se.yrgo.up22.group1.match;

import se.yrgo.up22.group1.player.Player;
import se.yrgo.up22.group1.country.Country;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;

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

    public Match() {
    }

    public Match(Country nationalTeamA, Country nationalTeamB, String arena, ZonedDateTime matchDateAndTime,
            int nationalTeamAScore, int nationalTeamBScore, int publicNumber, List<Player> nationalTeamAPlayers,
            List<Player> nationalTeamBPlayers) {

        this.nationalTeamA = Objects.requireNonNull(nationalTeamA, "Invalid nationalTeamA");
        this.nationalTeamB = Objects.requireNonNull(nationalTeamB, "Invalid nationalTeamB");
        this.arena = Objects.requireNonNull(arena, "Invalid arena");
        this.matchDateAndTime = Objects.requireNonNull(matchDateAndTime, "Invalid matchDateAndTime");
        if (nationalTeamAScore < 0) {
            throw new IllegalArgumentException("Invalid nationalTeamAScore");
        }
        this.nationalTeamAScore = nationalTeamAScore;
        if (nationalTeamBScore < 0) {
            throw new IllegalArgumentException("Invalid nationalTeamBScore");
        }
        this.nationalTeamBScore = nationalTeamBScore;
        if (publicNumber < 0) {
            throw new IllegalArgumentException("Invalid publicNumber");
        }
        this.publicNumber = publicNumber;
        this.nationalTeamAPlayers = Objects.requireNonNull(nationalTeamAPlayers, "Invalid nationalTeamAPlayers");
        this.nationalTeamBPlayers = Objects.requireNonNull(nationalTeamBPlayers, "Invalid nationalTeamBPlayers");
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

    @Override
    public String toString() {
        return "Match{" +
                "nationalTeamA=" + nationalTeamA.getName() +
                ", nationalTeamB=" + nationalTeamB.getName() +
                ", arena='" + arena + '\'' +
                ", matchDateAndTime=" + matchDateAndTime +
                ", nationalTeamAScore=" + nationalTeamAScore +
                ", nationalTeamBScore=" + nationalTeamBScore +
                ", publicNumber=" + publicNumber +
                ", nationalTeamAPlayers=" + nationalTeamAPlayers +
                ", nationalTeamBPlayers=" + nationalTeamBPlayers +
                '}';
    }

    public Country winner() {
        if (nationalTeamAScore > nationalTeamBScore) {
            return nationalTeamA;
        }
        if (nationalTeamBScore > nationalTeamAScore) {
            return nationalTeamB;
        }
        return null;
    }
}
