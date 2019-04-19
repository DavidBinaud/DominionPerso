package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

/**
 * Carte Marché (Market)
 *
 * +1 Carte.
 * +1 Action.
 * +1 Achat.
 * +1 Pièce.
 */
public class Market extends Card {
    public Market() {
        super("Market", 5);
    }

    @Override
    public void play(Player p) {
        p.drawCard();
        p.incrementActions(1);
        p.incrementBuys(1);
        p.incrementMoney(1);
    }
}