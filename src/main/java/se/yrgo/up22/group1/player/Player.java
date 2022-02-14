package se.yrgo.up22.group1.player;


/**
 * This class is for players of the international football team
 * In this class there is name, age, club, matches played, goals scored
 *
 * @author Rayan Sabah Mahmod
 */

public class Player {
    private String name;
    private int age;
    private String club;
    private int playedMatches;
    private int goalsScored;

    public Player() {

    }


    @Override
    public String toString() {
        return "Player |" +
                "Name:" + name + "|" +
                " Age:" + age + "|" +
                " Club:" + club + "|" +
                " Played Matches:" + playedMatches + "|" +
                " Goals Scored:" + goalsScored +
                '|';
    }

    public void setName(String name) {
        this.name = name;
        if (name == "") {
            throw new IllegalArgumentException("Invalid name, try again ");
        }
    }

    public void setAge(int age) {
        this.age = age;
        if (age < 16) {
            throw new IllegalArgumentException("Invalid Age, try again ");
        }
    }

    public void setClub(String club) {
        this.club = club;
    }

    public void setPlayedMatches(int gamesPlayed) {
        this.playedMatches = gamesPlayed;
        if (playedMatches == 0) {
            throw new IllegalArgumentException("Invalid played matches, try again ");
        }

    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
        if (goalsScored == 0) {
            throw new IllegalArgumentException("Invalid goals , try again ");
        }
    }


    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getClub() {
        return club;
    }


    public int getPlayedMatches() {
        return playedMatches;
    }

    public int getGoalsScored() {
        return goalsScored;
    }



    public Player(String name, int age, String club, int gamesPlayed, int goalsScored) {
        this.name = name;
        this.age = age;
        this.club = club;
        this.playedMatches = gamesPlayed;
        this.goalsScored = goalsScored;
    }
}


