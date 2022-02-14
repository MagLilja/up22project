package se.yrgo.up22.group1.player;


import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.assertEquals;

//Rayan Sabah Mahmod
public class PlayerTest {
    private Player testPlayerOne;
    private Player testPlayerTwo;


    @BeforeEach
    public void setUp() {
        testPlayerOne = new Player();
        testPlayerTwo = new Player();

    }


    ////PLayer One
    /// This code is testing so you can put in Name, Age , Club, Games Played and Goal Scored
    @Test
    public void testAddPlayer() {
        String expName = "Lina Hurtig";
        testPlayerOne.setName("Lina Hurtig");
        testPlayerOne.getName();
        String result = testPlayerOne.getName();
        assertEquals(expName, result);
        /// Testing input of Age
        int expAge = 26;
        testPlayerOne.setAge(26);
        testPlayerOne.getAge();
        int ageResult = testPlayerOne.getAge();
        assertEquals(expAge, ageResult);
        /// Testing put in witch Club the player is playing in
        String expClub = "Juventus";
        testPlayerOne.setClub("Juventus");
        testPlayerOne.getClub();
        String clubResult = testPlayerOne.getClub();
        assertEquals(expClub, clubResult);
        /// Testing input of how many played matches to player has played
        int expPlayedMatches = 164;
        testPlayerOne.setPlayedMatches(164);
        testPlayerOne.getPlayedMatches();
        int playedMatchesResult = testPlayerOne.getPlayedMatches();
        assertEquals(expPlayedMatches, playedMatchesResult);
        /// Testing input of how many Goals Scored the player has
        int expGoalsScored = 49;
        testPlayerOne.setGoalsScored(49);
        testPlayerOne.getGoalsScored();
        int goalsScoredResult = testPlayerOne.getGoalsScored();
        assertEquals(expGoalsScored, goalsScoredResult);

    }


    /// Player Two
    /// This code is testing so you can put in Name, Age , Club, Games Played and Goal Scored
    @Test
    public void testAddPlayerTwo() {
        String expName = "Caroline Seger";
        testPlayerTwo.setName("Caroline Seger");
        testPlayerTwo.getName();
        String result = testPlayerTwo.getName();
        assertEquals(expName, result);
        /// Testing input of Age
        int expAge = 26;
        testPlayerTwo.setAge(26);
        testPlayerTwo.getAge();
        int ageResult = testPlayerTwo.getAge();
        assertEquals(expAge, ageResult);
        /// Testing put in witch Club the player is playing in
        String expClub = "Juventus";
        testPlayerTwo.setClub("Juventus");
        testPlayerTwo.getClub();
        String clubResult = testPlayerTwo.getClub();
        assertEquals(expClub, clubResult);
        /// Testing input of how many played matches to player has played
        int expPlayedMatches = 211;
        testPlayerTwo.setPlayedMatches(211);
        testPlayerTwo.getPlayedMatches();
        int gamesPlayedResult = testPlayerTwo.getPlayedMatches();
        assertEquals(expPlayedMatches, gamesPlayedResult);
        /// Testing input of how many Goals Scored the player has
        int expGoalsScored = 26;
        testPlayerTwo.setGoalsScored(26);
        testPlayerTwo.getGoalsScored();
        int goalsScoreResult = testPlayerTwo.getGoalsScored();
        assertEquals(expGoalsScored, goalsScoreResult);


    }

}



