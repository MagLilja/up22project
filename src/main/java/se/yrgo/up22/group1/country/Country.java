package se.yrgo.up22.group1.country;

import se.yrgo.up22.group1.coach.Coach;
import se.yrgo.up22.group1.match.Match;
import se.yrgo.up22.group1.player.Player;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Country {
    private String name;
    private int FIFARanking;
    private double FIFARankingPoints;
    private List<Player> players;
    private List<Match> matches;
    private Coach coach;

    public Country(String name) {
        this.name = name;
    }

    public Country(String name, List<Player> players, Coach coach) {
        this(name);
        addPlayer(players);
        addCoach(coach);
    }

    public Country(String name, List<Player> players, List<Match> matches, Coach coach) {
        this(name);
        addPlayer(players);
        addMatches(matches);
        addCoach(coach);
    }


    public Country(String name, int FIFARanking, double FIFARankingPoints) {
        this(name);
        setFIFARanking(FIFARanking);
        setFIFARankingPoints(FIFARankingPoints);
    }

    public Country(String name, int FIFARanking, double FIFARankingPoints,
                   List<Player> players, List<Match> matches,Coach coach) {
        this(name, players, matches, coach);
        setFIFARanking(FIFARanking);
        setFIFARankingPoints(FIFARankingPoints);
    }


    public void addPlayer(Player player) {
        List<Player> tempPlayerList = new ArrayList<>();
        tempPlayerList.add(player);
        if (this.players == null) {
            this.players = new ArrayList<>();
            if (CountryValidators.validateMaxPlayers(this, tempPlayerList)) {
                players.addAll(tempPlayerList);
            }
        }
    }

    // Overloading method for adding a list of players
    public void addPlayer(List<Player> players) {
        if (this.players == null) {
            if (CountryValidators.validateMaxPlayers(this, players))
                this.players = players;
        } else {
            if (CountryValidators.validateMaxPlayers(this, players)) {
                this.players.addAll(players);
            }
        }
    }

    // add one match
    public void addMatch(Match match) {
        if (this.matches == null) {
            this.matches = new ArrayList<>();
        }
        matches.add(match);
    }

    // Overloading method for adding a list of matches
    public void addMatches(List<Match> matches) {
        if (this.matches == null) {
            this.matches = matches;
        } else {
            this.matches.addAll(matches);
        }
    }

    private void addCoach(Coach coach) {

        this.coach = this.coach;
    }

    public void setFIFARankingPoints(double FIFARankingPoints) {
        if (CountryValidators.validateFIFARankingPoints(FIFARankingPoints)) {
            this.FIFARankingPoints = FIFARankingPoints;
        } else {
            throw new InputMismatchException("Not a valid FIFA Ranking point");
        }
    }


    public void setFIFARanking(int FIFARanking) {
        if (CountryValidators.validateFIFARanking(FIFARanking)) {
            this.FIFARanking = FIFARanking;
        } else {
            throw new InputMismatchException("Not a valid FIFA Ranking");
        }
    }

    public String getName() {
        return name;
    }

    public int getFIFARanking() {
        return FIFARanking;
    }

    public double getFIFARankingPoints() {
        return FIFARankingPoints;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Coach getCoach() {
        return coach;
    }

    public void removeAllPlayersFromTeam() {
        players.clear();
    }
}
