package Cards;

import Game.Game;

public class DrawTwoCard extends ActionCard {

    public DrawTwoCard(CardType cardType, int score, CardColor cardColor) {
        super(cardType, score, cardColor);
    }

    @Override
    public Game doAction(Game game) {

        int numberOfPlayer = game.getNumberOfPlayers() ;
        int currentPlayerIndex = game.getCurrentPlayer() ;
        currentPlayerIndex = (currentPlayerIndex + 1 ) % numberOfPlayer ;

        game.setCurrentPlayer(currentPlayerIndex);

        game.getPlayers().get(currentPlayerIndex).addCardsToHand(game.getDeck().drawCard(2));

        currentPlayerIndex = (currentPlayerIndex + 1 ) % numberOfPlayer ;
        game.setCurrentPlayer((currentPlayerIndex));

        return game;

    }
    @Override
    public String toString() {
        return "Draw Two - " + getCardColor().toString() ;
    }
}
