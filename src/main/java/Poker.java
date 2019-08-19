import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Poker {
    public static boolean isStraightFlush(List<PokerUtil> cardList) {
        return isStraight(cardList) && isFlush(cardList);
    }

    public static boolean isFourOfAKind(List<PokerUtil> cardList) {
        return cardList.stream()
                .collect(Collectors.toMap(item -> item.getNumber().getValue(), item -> 1, Integer::sum))
                .entrySet().stream()
                .anyMatch(entry -> entry.getValue() == 4);
    }


    public static boolean isFullHouse(List<PokerUtil> cardList) {
        return cardList.stream()
                .collect(Collectors.toMap(item -> item.getNumber().getValue(), item -> 1, Integer::sum))
                .entrySet().stream()
                .anyMatch(entry -> entry.getValue() == 3) &&
                cardList.stream()
                        .collect(Collectors.toMap(item -> item.getNumber().getValue(), item -> 1, Integer::sum))
                        .entrySet().stream()
                        .anyMatch(entry -> entry.getValue() == 2);
    }

    public static boolean isFlush(List<PokerUtil> cardList) {
        return cardList.stream()
                .collect(Collectors.toMap(item -> item.getColor().getColor(), item -> 1, Integer::sum))
                .entrySet().stream()
                .anyMatch(entry -> entry.getValue() == 5);
    }

    public static boolean isStraight(List<PokerUtil> cardList) {
        for (int i = 1; i < cardList.size(); i++) {
            if (cardList.get(i).getNumber().getValue() != (cardList.get(i - 1).getNumber().getValue() + 1)) {
                return false;
            }
        }
        return true;
    }

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
        if (isStraightFlush(oneCards) != isStraightFlush(twoCards)) {
            return isStraightFlush(oneCards) ? "1" : "2";
        }
        if (isFourOfAKind(oneCards) != isFourOfAKind(twoCards)) {
            return isFourOfAKind(oneCards) ? "1" : "2";
        }
        if (isFullHouse(oneCards) != isFullHouse(twoCards)) {
            return isFullHouse(oneCards) ? "1" : "2";
        }
        if (isFlush(oneCards) != isFlush(twoCards)) {
            return isFlush(oneCards) ? "1" : "2";
        }
        if (isStraight(oneCards) != isStraight(twoCards)) {
            return isStraight(oneCards) ? "1" : "2";
        }
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
