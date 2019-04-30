package fr.umontpellier.iut.dominion.cards.intrigue;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.base.Action;

public class TradingPost extends Action {
    public TradingPost() {
        super("Trading Post", 5);
    }

    @Override
    public void play(Player p) {

        int nbCardsInHand = p.getCardsInHand().size();
        if(nbCardsInHand >= 2) {
            String input = p.chooseCard("Choose a card to trash", p.getCardsInHand(), false);
            p.trashCard(p.getCardsInHand().getCard(input));

            input = p.chooseCard("Choose a card to trash", p.getCardsInHand(), false);
            p.trashCard(p.getCardsInHand().getCard(input));



            p.addToHand(p.getGame().removeFromSupply("Silver"));
        }
        else if (nbCardsInHand == 1){
            p.trashCard(p.getCardsInHand().get(0));
        }
    }
}
