package fr.umontpellier.iut.dominion.cards.intrigue;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.base.Action;

public class WishingWell extends Action {
    public WishingWell() {
        super("Wishing Well", 3);
    }


    @Override
    public void play(Player p) {
        p.drawToHand();
        p.incrementActions(1);
    }
}
