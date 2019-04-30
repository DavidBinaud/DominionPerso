package fr.umontpellier.iut.dominion.cards.intrigue;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.base.Attack;

public class Torturer extends Attack {
    public Torturer() {
        super("Torturer", 5);
    }

    @Override
    public void play(Player p) {
        p.drawToHand();
        p.drawToHand();
        p.drawToHand();
    }
}
