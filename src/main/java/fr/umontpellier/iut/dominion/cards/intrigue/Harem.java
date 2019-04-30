package fr.umontpellier.iut.dominion.cards.intrigue;

import fr.umontpellier.iut.dominion.Player;

public class Harem extends TreasureVictory {
    public Harem() {
        super("Harem", 6);
    }

    @Override
    public int getVictoryValue(Player p) {
        return 2;
    }

    @Override
    public void play(Player p) {
        p.incrementMoney(2);
    }
}
