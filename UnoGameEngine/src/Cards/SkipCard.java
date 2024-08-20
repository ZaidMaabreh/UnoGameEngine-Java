package Cards;

import Game.Game;

public class SkipCard extends ActionCard {


    public SkipCard(CardType cardType, int score, CardColor cardColor) {
        super(cardType, score, cardColor);
    }

    @Override
    public Game doAction(Game game) {
        game.setCurrentPlayer((game.getCurrentPlayer() + 2 ) % game.getNumberOfPlayers());
        return game;
    }
    @Override
    public String toString() {
        return "Skip - " + getCardColor().toString() ;
    }
}
