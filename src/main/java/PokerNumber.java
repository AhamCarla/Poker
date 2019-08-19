import java.util.Arrays;

public enum PokerNumber {
    TWO(2), THERE(3), FOUR(4), FIVE(5), SIX(6),
    SEVEN(7), EIGHT(8), NIGHT(9), T(10), J(11), Q(12),
    K(13), A(14);
    private int value;

    PokerNumber(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static PokerNumber praseValue(int value) {
        return Arrays.asList(PokerNumber.values()).stream().filter(item -> item.getValue() == value).findFirst().get();
    }
}
