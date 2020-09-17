package cardSuit;

public enum  CardSuit {
    CLUBS(0),
    DIAMONDS(1),
    HEARTS(2),
    SPADES(3);

    int value;

    CardSuit(int value) {
        this.value = value;
    }
}
