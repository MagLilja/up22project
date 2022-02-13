package se.yrgo.up22.group1.country;

import se.yrgo.up22.group1.coach.Coach;
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

    /**
     * Class constructor specifying countrys name.
     */
    public Country(String name) {
        this.name = name;

    }

    /**
     * Class constructor specifying countrys name, taking a list of players and specifying a coach.
     */
    public Country(String name, List<Player> players, Coach coach) {
        this(name);
        addPlayer(players);
        addCoachToCountry(coach);
    }

    /**
     * Class constructor specifying countrys name, FIFA ranking and FIFA ranking points.
     */
    public Country(String name, int FIFARanking, double FIFARankingPoints) {
        this(name);
        setFIFARanking(FIFARanking);
        setFIFARankingPoints(FIFARankingPoints);
    }

    /**
     * Class constructor specifying countrys name, FIFA ranking and FIFA ranking points, taking a list of players and specifying a coach.
     */
    public Country(String name, int FIFARanking, double FIFARankingPoints,
                   List<Player> players, Coach coach) {
        this(name, players, coach);
        setFIFARanking(FIFARanking);
        setFIFARankingPoints(FIFARankingPoints);

    }

    /**
     * Registers a player to the countrys list of players. If the team does not have any players the method initializes an ArrayList.
     *
     * @param player One player
     */
    public void addPlayer(Player player) {
        List<Player> tempPlayerList = new ArrayList<>();
        tempPlayerList.add(player);
        if (this.players == null) {
            this.players = new ArrayList<>();
        }
        if (CountryValidatorService.validateMaxPlayers(this, tempPlayerList)) {
            players.addAll(tempPlayerList);
        }
    }

    /**
     * Registers a list of players to the countrys list of players. If the team does not have any players the method sets the countrys list of players to the incoming list.
     *
     * @param players A list of players
     */
    public boolean addPlayer(List<Player> players) {
        if (this.players == null) {
            if (CountryValidatorService.validateMaxPlayers(this, players)) {
                this.players = players;
            } else {
                throw new IllegalStateException("Too many players in the team. Trying to add: " + players.size());
            }
        } else {
            if (CountryValidatorService.validateMaxPlayers(this, players)) {
                this.players.addAll(players);
            } else {
                throw new IllegalStateException("Too many players in the team. Got: 0 " + getPlayers().size() + " Trying to add: " + players.size());
            }
        }
        return true;
    }

    /**
     * Registers a coach to the country. If the team does already have a coach it throws an IllegalStateException.
     *
     * @param coach One player
     */
    public void addCoachToCountry(Coach coach) {
        if (this.coach == null) {
            this.coach = coach;
        } else {
            throw new IllegalStateException("Only one coach per team allowed! Remove Coach first!");
        }
    }

    /**
     * Registers a FIFA ranking points to the country. If the team does already have an entry here it will be overwritten.
     *
     * @param FIFARankingPoints
     */
    public void setFIFARankingPoints(double FIFARankingPoints) {
        if (CountryValidatorService.validateFIFARankingPoints(FIFARankingPoints)) {
            this.FIFARankingPoints = FIFARankingPoints;
        } else {
            throw new InputMismatchException("Not a valid FIFA Ranking point");
        }
    }

    /**
     * Registers a FIFA ranking to the country. If the team does already have an entry here it will be overwritten.
     *
     * @param FIFARanking
     */
    public void setFIFARanking(int FIFARanking) {
        if (CountryValidatorService.validateFIFARanking(FIFARanking)) {
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

    /**
     * A method to clear the list of players in the country.
     *
     * @return If the list of players in the country is already empty it will return false, otherwise it will return true.
     */
    public boolean removeAllPlayersFromTeam() {
        if (players != null) {
            players.clear();
            return true;
        }
        return false;


    }


    @Override
    public String toString() {
        return name +
                ", FIFARanking = " + FIFARanking +
                ", FIFARankingPoints = " + FIFARankingPoints +
                ", coach =" + coach;
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
