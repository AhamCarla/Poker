import java.util.ArrayList;

public class PokerUtil implements Comparable<PokerUtil> {
    private PokerColor color;
    private PokerNumber number;


    public PokerUtil(String cardValue) {
        if (Character.isDigit(cardValue.charAt(0))) {
            this.number = PokerNumber.praseValue(Integer.parseInt(cardValue.substring(0, 1)));
        } else {
            this.number = PokerNumber.valueOf(cardValue.substring(0, 1));
        }
        this.color = PokerColor.valueOf(cardValue.charAt(1) + "");
    }

    public PokerColor getColor() {
        return color;
    }

    public void setColor(PokerColor color) {
        this.color = color;
    }

    public PokerNumber getNumber() {
        return number;
    }

    public void setNumber(PokerNumber number) {
        this.number = number;
    }

    public static ArrayList<PokerUtil> generateCard(String cardNums) {
        ArrayList<PokerUtil> cardList = new ArrayList<PokerUtil>();
        for (int i = 0; i < cardNums.length(); i += 2) {
            String cardInfo = cardNums.substring(i, i + 2);
            cardList.add(new PokerUtil(cardInfo));
        }
        return cardList;
    }


    @Override
    public int compareTo(PokerUtil poker) {
        return this.number.getValue() - poker.number.getValue();
    }
}
