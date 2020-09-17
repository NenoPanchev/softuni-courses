package cardsWithPower;

public class Card {
    private Rank rank;
    private Suit suit;

    public Card(String rank, String suit) {
        this.rank = Rank.valueOf(rank);
        this.suit = Suit.valueOf(suit);
    }

    private int calculateCardPower() {
        return this.rank.value + this.suit.value;
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d", this.rank, this.suit, this.calculateCardPower());
    }
}
