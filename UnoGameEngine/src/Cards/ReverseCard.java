package Cards;

import Game.Game;

import java.util.Collections;

public class ReverseCard extends ActionCard {

    public ReverseCard(CardType cardType, int score, CardColor cardColor) {
        super(cardType, score, cardColor);
    }

    @Override
    public Game doAction(Game game) {
        final int playersNumber = game.getNumberOfPlayers() ;
        Collections.reverse(game.getPlayers());
        game.setCurrentPlayer(( playersNumber - game.getCurrentPlayer()) % playersNumber );
        game.setIsClockWise();
        return game;
    }
    @Override
    public String toString() {
        return "Reverse - " + getCardColor().toString() ;
    }
}
