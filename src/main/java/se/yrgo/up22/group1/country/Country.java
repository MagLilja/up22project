package se.yrgo.up22.group1.country;

import se.yrgo.up22.group1.coach.Coach;
import se.yrgo.up22.group1.player.Player;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Country {
    private String name;
    private int FIFARanking;
    private double FIFARankingPoints;
    private List<Player> players;
    private Coach coach;

    public Country(String name) {
        this.name = name;
    }

    public Country(String name, List<Player> players, Coach coach) {
        this(name);
        addPlayer(players);
        addCoach(coach);
    }


    public Country(String name, int FIFARanking, double FIFARankingPoints) {
        this(name);
        addFIFARanking(FIFARanking);
        addFIFARankingPoints(FIFARankingPoints);
        this.FIFARankingPoints = FIFARankingPoints;
    }

    public Country(String name, int FIFARanking, double FIFARankingPoints,
                   List<Player> players, Coach coach) {
        this(name, players, coach);
        addFIFARanking(FIFARanking);
        addFIFARankingPoints(FIFARankingPoints);
        this.FIFARankingPoints = FIFARankingPoints;
    }

    //TODO: validate amount of players
    public void addPlayer(Player player) {
        if (this.players == null) {
            this.players = new ArrayList<>();
        }
        players.add(player);
    }

    // Overloading method.
    public void addPlayer(List<Player> players) {
        if (this.players == null) {
            this.players = players;
        } else {
            this.players.addAll(players);
        }
    }

    private void addCoach(Coach coach) {

        this.coach = this.coach;
    }

    private void addFIFARankingPoints(double FIFARankingPoints) {
        if (validateFIFARankingPoints(FIFARankingPoints)) {
            this.FIFARankingPoints = this.FIFARankingPoints;
        } else {
            throw new InputMismatchException("Not a valid FIFA Ranking point");
        }
    }

    // Bounds for points taken from FIFA official doc:
    // https://digitalhub.fifa.com/m/f99da4f73212220/original/edbm045h0udbwkqew35a-pdf.pdf
    private boolean validateFIFARankingPoints(double FIFARankingPoints) {
        if (FIFARankingPoints > 2109.09 || FIFARankingPoints <= 357) {
            return false;
        } else {

            return true;
        }
    }

    private void addFIFARanking(int FIFARanking) {
        if (validateFIFARanking(FIFARanking)) {
            this.FIFARanking = this.FIFARanking;
        } else {
            throw new InputMismatchException("Not a valid FIFA Ranking");
        }
    }

    // 210 teams
    private boolean validateFIFARanking(int FIFARanking) {
        if (FIFARanking > 210 || FIFARanking <= 0) {
            return false;
        } else {
            return true;
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
        if (players == null) {
            throw new NullPointerException("Country does not have any players yet");
        }
        return players;
    }

    public Coach getCoach() {
        return coach;
    }

    public void removeAllPlayersFromTeam() {
        players.clear();
    }
}
