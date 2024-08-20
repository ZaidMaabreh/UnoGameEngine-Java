package Deck;

import Cards.*;

public class CardFactory {
    public static Card generateCard(CardType cardType,
       CardColor cardColor ,  CardValue cardValue , CardAction cardAction) {

        if(cardAction == CardAction.NO_ACTION){
            return new NumberCard(cardType , cardValue.ordinal() , cardColor  , cardValue ) ;
        }
        else if(cardAction == CardAction.SKIP){
            return new SkipCard(cardType ,  20 , cardColor ) ;
        }
        else if(cardAction == CardAction.REVERSE){
            return new SkipCard(cardType ,  20 , cardColor ) ;
        }
        else if(cardAction == CardAction.WILD){
            return new WildColorChangeCard(cardType ,  50 ) ;
        }
        else if(cardAction == CardAction.WILD_DRAW_FOUR){
            return new WildDrawFourCard(cardType ,  50 ) ;
        }
        else if(cardAction == CardAction.DRAW_TWO){
            return new DrawTwoCard(cardType , 20 ,cardColor ) ;
        }
        else
            return null ;

    }
}
