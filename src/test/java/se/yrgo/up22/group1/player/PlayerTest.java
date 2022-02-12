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
    @Test
    public void testAddPlayer() {
        String expName = "Lina Hurtig";
        testPlayerOne.setName("Lina Hurtig");
        testPlayerOne.getName();
        String result = testPlayerOne.getName();
        assertEquals(expName, result);
        /// Age
        int expAge = 26;
        testPlayerOne.setAge(26);
        testPlayerOne.getAge();
        int ageResult = testPlayerOne.getAge();
        assertEquals(expAge, ageResult);
        /// Club
        String expClub = "Juventus";
        testPlayerOne.setClub("Juventus");
        testPlayerOne.getClub();
        String clubResult = testPlayerOne.getClub();
        assertEquals(expClub, clubResult);
        /// Games Played
        int expGamesPlayed = 164;
        testPlayerOne.setGamesPlayed(164);
        testPlayerOne.getGamesPlayed();
        int gamesPlayedResult = testPlayerOne.getGamesPlayed();
        assertEquals(expGamesPlayed, gamesPlayedResult);
        /// Goals Scored  GoalsScored
        int expGoalsScored = 49;
        testPlayerOne.setGoalsScored(49);
        testPlayerOne.getGoalsScored();
        int goalsScoredResult = testPlayerOne.getGoalsScored();
        assertEquals(expGoalsScored, goalsScoredResult);

    }




    /// Player Two
    @Test
    public void testAddPlayerTwo() {
        String expName = "Caroline Seger";
        testPlayerTwo.setName("Caroline Seger");
        testPlayerTwo.getName();
        String result = testPlayerTwo.getName();
        assertEquals(expName, result);
        /// Age
        int expAge = 26;
        testPlayerTwo.setAge(26);
        testPlayerTwo.getAge();
        int ageResult = testPlayerTwo.getAge();
        assertEquals(expAge, ageResult);
        /// Club
        String expClub = "Juventus";
        testPlayerTwo.setClub("Juventus");
        testPlayerTwo.getClub();
        String clubResult = testPlayerTwo.getClub();
        assertEquals(expClub, clubResult);
        ///Games Played
        int expGamesPlayed = 211;
        testPlayerTwo.setGamesPlayed(211);
        testPlayerTwo.getGamesPlayed();
        int gamesPlayedResult = testPlayerTwo.getGamesPlayed();
        assertEquals(expGamesPlayed, gamesPlayedResult);
        /// Goals Scored
        int expGoalsScored = 26;
        testPlayerTwo.setGoalsScored(26);
        testPlayerTwo.getGoalsScored();
        int goalsScoreResult = testPlayerTwo.getGoalsScored();
        assertEquals(expGoalsScored, goalsScoreResult);



    }

}



