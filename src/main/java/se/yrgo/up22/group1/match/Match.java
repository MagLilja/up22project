package se.yrgo.up22.group1.match;

import java.time.ZonedDateTime;

public class Match {
    private String nationalTeamA;
    private String nationalTeamB;
    private String matchLocation;
    private String arena;
    private ZonedDateTime matchDateAndTime;
    private int nationalTeamAScore;
    private int nationalTeamBScore;
    private int publicNumber;

    public Match() {
    }

    public String getNationalTeamA() {
        return nationalTeamA;
    }

    public String getNationalTeamB() {
        return nationalTeamB;
    }

    public String getmatchLocation() {
        return matchLocation;
    }
    
    public String getarena() {
        return arena;
    }

    public ZonedDateTime getmatchDateAndTime() {
        return matchDateAndTime;
    }

}

