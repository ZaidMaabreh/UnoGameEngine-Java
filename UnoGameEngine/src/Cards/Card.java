package Cards;


public abstract class Card {
    private final CardType cardType;
    public final int score ;

    public Card(CardType cardType, int score) {
        this.cardType = cardType;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public CardType getType() {
        return cardType;
    }

    @Override
    public abstract String toString() ;
}
