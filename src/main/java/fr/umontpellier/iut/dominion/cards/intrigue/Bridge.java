package fr.umontpellier.iut.dominion.cards.intrigue;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.base.Action;

public class Bridge extends Action {

    public Bridge() {
        super("Bridge", 4);
    }

    @Override
    public void play(Player p) {
        p.incrementBuys(1);
        p.incrementMoney(1);

    }
}
