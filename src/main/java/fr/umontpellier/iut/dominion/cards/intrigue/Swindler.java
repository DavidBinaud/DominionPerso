package fr.umontpellier.iut.dominion.cards.intrigue;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.base.Attack;

public class Swindler extends Attack {
    public Swindler() {
        super("Swindler", 3);
    }

    @Override
    public void play(Player p) {
        p.incrementMoney(2);
    }
}
