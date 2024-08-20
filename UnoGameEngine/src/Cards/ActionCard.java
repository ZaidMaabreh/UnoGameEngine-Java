package Cards;

public abstract class ActionCard extends ColoredCard implements Action{

    public ActionCard(CardType cardType, int score, CardColor cardColor ) {
        super(cardType, score, cardColor);
    }

}
