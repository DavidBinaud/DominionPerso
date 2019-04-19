package fr.umontpellier.iut.dominion.cards.common;


import fr.umontpellier.iut.dominion.Player;

/**
 * Carte Cuivre (Copper)
 *
 * 1 Pièce
 */
public class Copper extends Treasure {
    public Copper() {
        super("Copper", 0);
    }

    @Override
    public void play(Player p) {
        p.incrementMoney(1);
    }
}
