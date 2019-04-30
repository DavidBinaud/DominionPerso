package fr.umontpellier.iut.dominion.cards.intrigue;

import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.base.Action;

import java.util.Arrays;
import java.util.List;

public class Baron extends Action {

    public Baron(){
        super("Baron", 4);
    }

    @Override
    public void play(Player p) {
        p.incrementBuys(1);

        ListOfCards inHand = p.getCardsInHand();
        boolean hasEstate = false;

        for (Card c: inHand) {
            if(c.getName().equals("Estate")){
                hasEstate = true;
            }
        }

        if(hasEstate){
            List<String> choices = Arrays.asList("y","n");
            String input = p.chooseOption("Discard an Estate?",choices,false);
            if(input.equals("y")){
                Card EstatetoDiscard = inHand.getCard("Estate");
                p.fromHandToDiscard(EstatetoDiscard);
                p.incrementMoney(4);
            }
            else{
                p.gainFromSupply("Estate");
            }
        }
    }
}
