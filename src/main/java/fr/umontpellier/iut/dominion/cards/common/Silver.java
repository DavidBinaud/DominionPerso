package fr.umontpellier.iut.dominion.cards.common;

import fr.umontpellier.iut.dominion.Player;

/**
 * Carte Argent (Silver)
 *
 * 2 Pièces
 */
public class Silver extends Treasure {
    public Silver() {
        super("Silver", 3);
    }

    @Override
    public void play(Player p) {
        p.incrementMoney(2);
    }
}
