package fr.umontpellier.iut.dominion.cards.intrigue;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.base.Action;

public class Scout extends Action {
    public Scout() {
        super("Scout", 4);
    }

    @Override
    public void play(Player p) {
        p.incrementActions(1);
    }
}
