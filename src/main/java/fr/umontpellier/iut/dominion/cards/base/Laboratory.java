package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.Player;


/**
 * Carte Laboratoire (Laboratory)
 *
 * +2 Cartes.
 * +1 Action.
 */
public class Laboratory extends Action {
    public Laboratory() {
        super("Laboratory", 5);
    }

    @Override
    public void play(Player p) {
        p.drawToHand();
        p.drawToHand();
        p.incrementActions(1);

    }
}