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

    @Test
    public void should_return_1_when_given_1_2H3D5S9CKD_and_2_3D4S6CTD9D() {


        ArrayList<PokerUtil> oneList = PokerUtil.generateCard("2H3D5S9CKD");
        ArrayList<PokerUtil> twoList = PokerUtil.generateCard("3D4S6CTD9D");
        assertEquals("1", Poker.winnerJudge(oneList, twoList));

    }


    @Test
    public void should_return_2_when_given_1_2H3D5S9CKD_and_2_3D3S6CTD9D() {


        ArrayList<PokerUtil> oneList = PokerUtil.generateCard("2H3D5S9CKD");
        ArrayList<PokerUtil> twoList = PokerUtil.generateCard("3D3S6CTD9D");
        assertEquals("2", Poker.winnerJudge(oneList, twoList));

    }

    @Test
    public void should_return_2_when_given_1_3H3D5S9CKD_and_2_5D5S6CTD9D() {


        ArrayList<PokerUtil> oneList = PokerUtil.generateCard("3H3D5S9CKD");
        ArrayList<PokerUtil> twoList = PokerUtil.generateCard("5D5S6CTD9D");
        assertEquals("2", Poker.winnerJudge(oneList, twoList));

    }

    @Test
    public void should_return_1_when_given_1_3H3D5S9CKD_and_2_3D3S6CTD9D() {


        ArrayList<PokerUtil> oneList = PokerUtil.generateCard("3H3D5S9CKD");
        ArrayList<PokerUtil> twoList = PokerUtil.generateCard("3D3S6CTD9D");
        assertEquals("1", Poker.winnerJudge(oneList, twoList));

    }

    @Test
    public void should_return_2_when_given_1_3H3D5S9CKD_and_2_3D3S5C5D9D() {


        ArrayList<PokerUtil> oneList = PokerUtil.generateCard("3H3D5S9CKD");
        ArrayList<PokerUtil> twoList = PokerUtil.generateCard("3D3S5C5D9D");
        assertEquals("2", Poker.winnerJudge(oneList, twoList));

    }

    @Test
    public void should_return_2_when_given_1_3H3D5S5CKD_and_2_3D3S6C6D9D() {


        ArrayList<PokerUtil> oneList = PokerUtil.generateCard("3H3D5S5CKD");
        ArrayList<PokerUtil> twoList = PokerUtil.generateCard("3D3S6C6D9D");
        assertEquals("2", Poker.winnerJudge(oneList, twoList));

    }

    @Test
    public void should_return_2_when_given_1_5H5D3S3CKD_and_2_4D4S4C6D9D() {

        ArrayList<PokerUtil> oneList = PokerUtil.generateCard("5H5D3S3CKD");
        ArrayList<PokerUtil> twoList = PokerUtil.generateCard("4D4S4C6D9D");
        assertEquals("2", Poker.winnerJudge(oneList, twoList));

    }

    @Test
    public void should_return_2_when_given_1_5H5D3S3CKD_and_2_3D4S5C6D7D() {


        ArrayList<PokerUtil> oneList = PokerUtil.generateCard("5H5D3S3CKD");
        ArrayList<PokerUtil> twoList = PokerUtil.generateCard("3D4S5C6D7D");
        assertEquals("2", Poker.winnerJudge(oneList, twoList));

    }

    @Test
    public void should_return_2_when_given_1_3D4S5C6D7D_and_2_5D8D9D3DTD() {


        ArrayList<PokerUtil> oneList = PokerUtil.generateCard("3D4S5C6D7D");
        ArrayList<PokerUtil> twoList = PokerUtil.generateCard("5D8D9D3DTD");
        assertEquals("2", Poker.winnerJudge(oneList, twoList));

    }

    @Test
    public void should_return_2_when_given_1_5D8D9D3DTD_and_2_3H3D5S5C3D() {


        ArrayList<PokerUtil> oneList = PokerUtil.generateCard("5D8D9D3DTD");
        ArrayList<PokerUtil> twoList = PokerUtil.generateCard("3H3D5S5C3D");
        assertEquals("2", Poker.winnerJudge(oneList, twoList));

    }

    @Test
    public void should_return_2_when_given_1_3H3D5S5C3D_and_2_3H3D3S5C3D() {


        ArrayList<PokerUtil> oneList = PokerUtil.generateCard("3H3D5S5C3D");
        ArrayList<PokerUtil> twoList = PokerUtil.generateCard("3H3D3S5C3D");
        assertEquals("2", Poker.winnerJudge(oneList, twoList));

    }

    @Test
    public void should_return_2_when_given_1_3H3D3S5C3D_and_2_3H4H5H6H7H() {


        ArrayList<PokerUtil> oneList = PokerUtil.generateCard("3H3D3S5C3D");
        ArrayList<PokerUtil> twoList = PokerUtil.generateCard("3H4H5H6H7H");
        assertEquals("2", Poker.winnerJudge(oneList, twoList));

    }
}
