package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

/**
 * Carte Chambre du conseil (Council Room)
 *
 * +4 Cartes.
 * +1 Achat.
 * Tous vos adversaires piochent 1 carte.
 */
public class CouncilRoom extends Card {
    public CouncilRoom() {
        super("Council Room", 5);
    }

    @Override
    public void play(Player p) {
        for (int i = 0; i < 4; i++) {
            p.drawCard();
        }

        p.incrementBuys(1);

        for (Player player:p.getGame().otherPlayers(p)) {
            player.drawCard();
        }
    }
}