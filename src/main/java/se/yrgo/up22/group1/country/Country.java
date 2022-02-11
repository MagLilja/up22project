package se.yrgo.up22.group1.country;

import se.yrgo.up22.group1.coach.Coach;
import se.yrgo.up22.group1.match.Match;
import se.yrgo.up22.group1.player.Player;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Objects;

/**
 * A class representing an international football team.
 * A country has a name, FIFARanking, FIFARankingPoints, A list of players, a list of matches and a coach.
 *
 * @author Magnus Lilja
 */
public class Country implements Comparable<Country> {

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
        setFIFARanking(FIFARanking);
        setFIFARankingPoints(FIFARankingPoints);
    }

    public Country(String name, int FIFARanking, double FIFARankingPoints,
                   List<Player> players, Coach coach) {
        this(name, players, coach);
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
    public boolean addPlayer(List<Player> players) {
        if (this.players == null) {
            if (CountryValidators.validateMaxPlayers(this, players))
                this.players = players;
        } else {
            if (CountryValidators.validateMaxPlayers(this, players)) {
                this.players.addAll(players);
            }
        }
        return true;
    }

    public void addCoach(Coach coach) {
        if (this.coach == null) {
            this.coach = coach;
        } else {
            throw new IllegalStateException("Only one coach per team allowed! Remove Coach first!");
        }
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


    @Override
    public String toString() {
        return name +
                ", FIFARanking = " + FIFARanking +
                ", FIFARankingPoints = " + FIFARankingPoints +
                ", coach=" + coach +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(name, country.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Country o) {
        Comparator comparator = Comparator.comparingInt(Country::getFIFARanking);
        return comparator.compare(this, o);
    }
}
