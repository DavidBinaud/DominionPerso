package fr.umontpellier.iut.dominion.cards.intrigue;

import fr.umontpellier.iut.dominion.Player;

public class GreatHall extends ActionVictory {
    public GreatHall() {
        super("Great Hall", 3);
    }

    @Override
    public void play(Player p) {
        p.drawToHand();
        p.incrementActions(1);
    }

    @Override
    public int getVictoryValue(Player p) {
        return 1;
    }
}
