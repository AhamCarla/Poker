import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class PokerTest {
    @Test
    public void should_return_1_when_given_1_4D_2_3C() {

        PokerUtil one = new PokerUtil("4D");
        PokerUtil two = new PokerUtil("3C");

        assertEquals("1", Poker.winnerJudge(Arrays.asList(one), Arrays.asList(two)));
    }

    @Test
    public void should_return_draw_when_given_1_KD_and_2_KD() {
        PokerUtil one = new PokerUtil("KD");
        PokerUtil two = new PokerUtil("KD");

        assertEquals("draw", Poker.winnerJudge(Arrays.asList(one), Arrays.asList(two)));
    }

}
