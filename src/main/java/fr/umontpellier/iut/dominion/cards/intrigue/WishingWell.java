package fr.umontpellier.iut.dominion.cards.intrigue;

import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.base.Action;

public class WishingWell extends Action {
    public WishingWell() {
        super("Wishing Well", 3);
    }


    @Override
    public void play(Player p) {
        p.drawToHand();
        p.incrementActions(1);

        String input = p.chooseCard("Name a card that you posses",p.getAllCards(),false);
        ListOfCards inDraw = p.getCardsInDraw();

        if (!inDraw.isEmpty()){
            Card topDeckCard = inDraw.get(0);
            if (topDeckCard.getName().equals(input)){
                p.drawToHand();
            }
        }
    }
}
