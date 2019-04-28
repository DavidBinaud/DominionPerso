package fr.umontpellier.iut.dominion.cards.common;

import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

import java.util.List;

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
        ListOfCards inPlay = p.getCardsInPlay();
        p.incrementMoney(2);

        if(inPlay.getCard("Merchant") != null) {
            if (inPlay.remove("Silver") != null && inPlay.getCard("Silver") == null) {
                p.incrementMoney(1);
            }
        }
    }
}
