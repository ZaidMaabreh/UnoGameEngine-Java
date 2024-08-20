package Cards;

import java.util.Scanner;

public abstract class WildCard extends Card implements Action {

    public WildCard(CardType cardType, int score) {
        super(cardType, score);
    }

    public CardColor getUserColor() {
        Scanner colorReader = new Scanner(System.in);
        System.out.println("Please Choose Your Color To Change : \n 1 - Red \n 2 - Green \n 3 - Blue \n 4 - Yellow");
        while (true){
            String selctedColor = colorReader.next();
            if (selctedColor.equalsIgnoreCase("red") || selctedColor.equals("1")) {
                return CardColor.RED;
            }
            else if (selctedColor.equalsIgnoreCase("green") || selctedColor.equals("2")) {
                return CardColor.GREEN;
            }
            else if (selctedColor.equalsIgnoreCase("blue") || selctedColor.equals("3")) {
                return CardColor.BLUE;
            }
            else if (selctedColor.equalsIgnoreCase("yellow") || selctedColor.equals("4")) {
                return CardColor.YELLOW;
            }
            System.out.println("Please Enter a valid Color :");
        }
    }

}
