package Game;

import Cards.*;

import java.util.Scanner;

public class DefaultGame extends Game {

    private int playersNumber;

    public DefaultGame(){}
    final Scanner  scanner = new Scanner(System.in);
    @Override
    public void play() {
        initialize();
        drawHands(7);
        boolean isGameEnded = false ;
        while (!isGameEnded){

            System.out.println(players.get(currentPlayer).getName() + " Turn's ");
            System.out.println("The Current Color Is " + currentCardColor );
            if(!canPlay(players.get(currentPlayer))){
                players.get(currentPlayer).addCardToHand(deck.drawCard());
                System.out.println( players.get(currentPlayer).getName() + " Drow a Card Because He Dont Have Card To play");
                players.get(currentPlayer).displayHand();
                setCurrentPlayer((getCurrentPlayer() + 1 ) % getNumberOfPlayers());
                continue;
            }
            System.out.println( "Choose The Index Of The Card You Want To Play :");

            while (true) {
                players.get(currentPlayer).displayHand();
                int choosenCard = scanner.nextInt();
                Card playedCard = players.get(currentPlayer).getHand().get(choosenCard);
                if (isValidToPlay(playedCard)) {
                    playCard(playedCard , choosenCard);
                    break;
                } else
                    System.out.println("You Cant Play This Card");

            }
            for (int i = 0 ; i < playersNumber ; i++){
                if(players.get(i).numberOfHandCards() == 0){
                    System.out.println("The Winner Is " + players.get(i).getName() );
                    isGameEnded = true;
                    break;
                }
            }
        }
    }
    public boolean isValidToPlay(Card playedCard){
        if (currentCardColor == null)
            return true;
        if (playedCard instanceof ReverseCard){
            return ((ReverseCard) playedCard).getCardColor() == currentCardColor;
        }
        else if (playedCard instanceof SkipCard){
            return ((SkipCard) playedCard).getCardColor() == currentCardColor;
        }
        else if (playedCard instanceof DrawTwoCard){
            return ((DrawTwoCard) playedCard).getCardColor() == currentCardColor;
        }
        else if (playedCard instanceof NumberCard){
            return ((NumberCard) playedCard).getCardColor() == currentCardColor;
        }
        return true ;
    }

    public void playCard(Card playedCard , int choosenCard){
        players.get(currentPlayer).getHand().remove(choosenCard);
        if (playedCard instanceof ReverseCard){
           ((ReverseCard) playedCard).doAction(this);
           currentCardColor = ((ReverseCard) playedCard).getCardColor();
           System.out.println(((ReverseCard) playedCard).getCardColor());
        }
        else if (playedCard instanceof SkipCard){
           ((SkipCard) playedCard).doAction(this);
            currentCardColor = ((SkipCard) playedCard).getCardColor();
        }
        else if (playedCard instanceof DrawTwoCard){
            ((DrawTwoCard) playedCard).doAction(this);
            currentCardColor = ((DrawTwoCard) playedCard).getCardColor();
        }
        else if (playedCard instanceof NumberCard){
            setCurrentPlayer((getCurrentPlayer() + 1 ) % getNumberOfPlayers());
            currentCardColor = ((NumberCard) playedCard).getCardColor();
        }
        else if (playedCard instanceof WildColorChangeCard){
            ((WildColorChangeCard) playedCard).doAction(this);

        }
        else if (playedCard instanceof WildDrawFourCard){
            ((WildDrawFourCard) playedCard).doAction(this);
        }
    }

    @Override
    public void initialize() {
        deck.initailizeDeck();
        currentCardColor = (null);
        getPlayersNumber();
        currentPlayer = 0;
    }

    public void getPlayersNumber(){
        int numberofplayer;
        System.out.println("Please Enter The Number Of Players :");
        while (true){
            numberofplayer = scanner.nextInt();
            scanner.nextLine();
            if (numberofplayer > 1 && numberofplayer < 15 ) {
                playersNumber = numberofplayer ;
                for (int i = 0 ; i < numberofplayer ; i++ ){
                    System.out.println("Please Enter The Name Of Player " );
                    String name = (scanner.nextLine());
                    players.add(new Player(name));
                }
                break;
            }else
                System.out.println("Please Enter A Valid Number :" );
        }

    }


    @Override
    public void drawHands(int nuberOfCard) {
        for (int i = 0 ; i < players.size()  ; i++){
            players.get(i).addCardsToHand(deck.drawCard(nuberOfCard));
        }

    }

    public boolean canPlay(Player player){
        for (int i = 0 ; i < player.numberOfHandCards() ; i++){
            if(isValidToPlay(player.getHand().get(i)))
                return true;
        }
        return false ;
    }

}
