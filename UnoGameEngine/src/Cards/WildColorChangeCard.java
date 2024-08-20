package Cards;

import Game.Game;

public class WildColorChangeCard extends WildCard {


    public WildColorChangeCard(CardType cardType, int score) {
        super(cardType, score);
    }

    @Override
    public Game doAction(Game game) {

        game.setCurrentPlayer((game.getCurrentPlayer() + 1 ) % game.getNumberOfPlayers());
        game.setCurrentColor(getUserColor());
        return game;
    }
    @Override
    public String toString() {
        return "Wild Change Color" ;
    }

}
