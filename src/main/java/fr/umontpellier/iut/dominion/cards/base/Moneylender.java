package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

/**
 * Carte Prêteur sur gages (Moneylender)
 *
 * Écartez une carte Cuivre de votre main.
 * Dans ce cas, +3 Pièces.
 */
public class Moneylender extends Action {
    public Moneylender() {
        super("Moneylender", 4);
    }

    @Override
    public void play(Player p) {
        Card c = p.getCardsInHand().getCard("Copper");
        if (c != null){
            p.removeFromHand(c);
            p.discardCard(c);
            p.incrementMoney(3);
        }
    }
}