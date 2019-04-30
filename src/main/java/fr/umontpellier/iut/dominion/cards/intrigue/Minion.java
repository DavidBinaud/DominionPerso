package fr.umontpellier.iut.dominion.cards.intrigue;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.base.Attack;

public class Minion extends Attack {
    public Minion() {
        super("Minion", 5);
    }

    @Override
    public void play(Player p) {
        p.incrementActions(1);
    }
}
