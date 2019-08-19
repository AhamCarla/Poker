import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Poker {


    public static String winnerJudge(List<PokerUtil> oneCards, List<PokerUtil> twoCards) {

        for (int i = oneCards.size() - 1; i >= 0; i--) {
            if (oneCards.get(i).getNumber().getValue() != twoCards.get(i).getNumber().getValue()) {
                return oneCards.get(i).getNumber().getValue() > twoCards.get(i).getNumber().getValue() ? "1" : "2";
            }
        }
        return "draw";
    }
}
