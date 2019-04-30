package fr.umontpellier.iut.dominion.cards.intrigue;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.base.Action;

public class ShantyTown extends Action {
    public ShantyTown() {
        super("Shanty Town", 3);
    }

    @Override
    public void play(Player p) {
        p.incrementActions(2);

        boolean actionInHand = false;
        for (Card c: p.getCardsInHand()) {
            if (c.getTypes().contains(CardType.Action)){
                actionInHand = true;
            }
        }

        if (!actionInHand){
            p.drawToHand();
            p.drawToHand();
        }
    }
}
