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


}
