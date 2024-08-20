package Cards;

import Game.Game;

public class WildDrawFourCard extends WildCard {


    public WildDrawFourCard(CardType cardType, int score) {
        super(cardType, score);
    }

    @Override
    public Game doAction(Game game) {

        int numberOfPlayer = game.getNumberOfPlayers() ;
        int currentPlayerIndex = game.getCurrentPlayer() ;
        currentPlayerIndex = (currentPlayerIndex + 1 ) % numberOfPlayer ;

        game.setCurrentPlayer(currentPlayerIndex);

        game.getPlayers().get(currentPlayerIndex).addCardsToHand(game.getDeck().drawCard(4));

        currentPlayerIndex = (currentPlayerIndex + 1 ) % numberOfPlayer ;
        game.setCurrentPlayer((currentPlayerIndex));
        game.setCurrentColor(getUserColor());

        return game;


    }
    @Override
    public String toString() {
        return "Wild Draw Four" ;
    }
}