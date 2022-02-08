package se.yrgo.up22.group1.player;

public class Player {
    private String name;
    private int age;
    private String club;
    private int gamesPlayed;
    private int goalsScored;

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


    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public Player(String name, int age, String club, int gamesPlayed, int goalsScored) {
        this.name = name;
        this.age = age;
        this.club = club;
        this.gamesPlayed = gamesPlayed;
        this.goalsScored = goalsScored;
    }
}


