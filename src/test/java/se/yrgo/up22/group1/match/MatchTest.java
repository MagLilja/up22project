package se.yrgo.up22.group1.match;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.ZonedDateTime;
import java.util.Collections;
import org.junit.jupiter.api.Test;
import se.yrgo.up22.group1.coach.Coach;
import se.yrgo.up22.group1.country.Country;

public class MatchTest {
    Country usa = new Country("usa", Collections.emptyList(), new Coach("John Smith"));
    Country sweden = new Country("sweden", Collections.emptyList(), new Coach("Svea Svensson"));

    Match nationalTeamAWins = new Match(usa, sweden, "Ullevi", ZonedDateTime.now(), 4, 3, 10589,
            Collections.emptyList(), Collections.emptyList());

    Match nationalTeamBWins = new Match(usa, sweden, "Ullevi", ZonedDateTime.now(), 2, 3, 10589,
            Collections.emptyList(), Collections.emptyList());

    Match noOneWins = new Match(usa, sweden, "Ullevi", ZonedDateTime.now(), 0, 0, 10589, Collections.emptyList(),
            Collections.emptyList());

    @Test
    public void testWinner() {
        Country winner = nationalTeamAWins.winner();
        assertEquals(usa, winner);
        winner = nationalTeamBWins.winner();
        assertEquals(sweden, winner);
        winner = noOneWins.winner();
        assertEquals(null, winner);
    }

}
