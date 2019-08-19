import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Poker {


    public static Map getCardListLevel(List<PokerUtil> cardList) {

        return cardList.stream()
                .collect(Collectors.toMap(item -> item.getNumber().getValue(), item -> 1, Integer::sum))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(item -> item.getKey(), item -> item.getValue()));
    }

    public static String winnerJudge(List<PokerUtil> oneCards, List<PokerUtil> twoCards) {
        oneCards.sort(PokerUtil::compareTo);
        twoCards.sort(PokerUtil::compareTo);

        Map<Integer, Integer> oneCardsMap = getCardListLevel(oneCards);
        Map<Integer, Integer> twoCardsMap = getCardListLevel(twoCards);
        int onePlayerCardMaxLevel = 0;
        int twoPlayerCardMaxLevel = 0;
        for (Integer key1 : oneCardsMap.keySet()) {
            if (oneCardsMap.get(key1) > onePlayerCardMaxLevel) {
                onePlayerCardMaxLevel = oneCardsMap.get(key1);
            }
        }
        for (Integer key2 : twoCardsMap.keySet()) {
            if (twoCardsMap.get(key2) > twoPlayerCardMaxLevel) {
                twoPlayerCardMaxLevel = twoCardsMap.get(key2);
            }
        }
        if (onePlayerCardMaxLevel != twoPlayerCardMaxLevel) {
            return onePlayerCardMaxLevel > twoPlayerCardMaxLevel ? "1" : "2";
        }
        for (Integer key1 : oneCardsMap.keySet()) {
            int value1 = oneCardsMap.get(key1);
            for (Integer key2 : twoCardsMap.keySet()) {
                if (twoCardsMap.get(key2) == value1) {
                    if (key1 != key2) {
                        return key1 > key2 ? "1" : "2";
                    }
                }
            }
        }
        for (int i = oneCards.size() - 1; i >= 0; i--) {
            if (oneCards.get(i).getNumber().getValue() != twoCards.get(i).getNumber().getValue()) {
                return oneCards.get(i).getNumber().getValue() > twoCards.get(i).getNumber().getValue() ? "1" : "2";
            }
        }
        return "draw";
    }
}