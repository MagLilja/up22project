package se.yrgo.up22.group1.match;

import java.time.ZonedDateTime;
import java.util.List;
import se.yrgo.up22.group1.Player.Player;

public class Match {
    private String nationalTeamA;
    private String nationalTeamB;
    private String arena;
    private ZonedDateTime matchDateAndTime;
    private int nationalTeamAScore;
    private int nationalTeamBScore;
    private int publicNumber;
    private List <Player> nationalTeamAPlayers;
    private List <Player> nationalTeamBPlayers;

    public Match(String nationalTeamA, String nationalTeamB, String arena, ZonedDateTime matchDateAndTime, int nationalTeamAScore, int nationalTeamBScore, int publicNumber, List <Player> nationTeamAPlayers, List <Player> nationalTeamBPlayers){
        this.nationalTeamA = nationalTeamA;
        this.nationalTeamB = nationalTeamB;
        this.arena = arena;
        this.matchDateAndTime = matchDateAndTime;
        this.nationalTeamAScore = nationalTeamAScore;
        this.nationalTeamBScore = nationalTeamBScore;
        this.publicNumber = publicNumber;
        this.nationalTeamAPlayers = nationTeamAPlayers;
        this.nationalTeamBPlayers = nationalTeamBPlayers; 
    }

    public String getNationalTeamA() {
        return nationalTeamA;
    }

    public String getNationalTeamB() {
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

    public List <Player> nationalTeamAplayers() {
        return nationalTeamAPlayers;
    }

    public List <Player> nationalTeamBplayers() {
        return nationalTeamBPlayers;
    }
}

