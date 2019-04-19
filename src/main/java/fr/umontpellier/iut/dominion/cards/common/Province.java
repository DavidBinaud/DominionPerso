package fr.umontpellier.iut.dominion.cards.common;

import fr.umontpellier.iut.dominion.Player;

/**
 * Carte Province
 *
 * 6 VP
 */
public class Province extends Victory {
    public Province() {
        super("Province", 8);
    }

    @Override
    public int getVictoryValue(Player p) {
        return 6;
    }
}