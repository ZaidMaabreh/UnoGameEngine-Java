package Cards;

public abstract class ColoredCard extends Card {
    private final CardColor cardColor;
    public ColoredCard(CardType cardType, int score , CardColor cardColor) {
        super(cardType, score);
        this.cardColor = cardColor ;
    }

    public CardColor getCardColor() {
        return cardColor;
    }

}
