package Cards;

public class NumberCard extends ColoredCard {
    private final CardValue cardValue ;
    public NumberCard(CardType cardType, int score, CardColor cardColor , CardValue cardValue) {
        super(cardType, score, cardColor);
        this.cardValue = cardValue ;
    }

    public CardValue getCardValue() {
        return cardValue;
    }

    @Override
    public String toString() {
        return getCardColor().toString() + "-"+cardValue.toString() ;
    }
}
