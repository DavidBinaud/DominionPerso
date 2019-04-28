package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.Player;

/**
 * Carte Avant-coureur (Harbinger)
 *
 * +1 Carte.
 * +1 Action.
 * Regardez dans votre défausse, vous pouvez prendre une carte et la mettre sur votre deck.
 */
public class Harbinger extends Action {
    public Harbinger() {
        super("Harbinger", 3);
    }

    @Override
    public void play(Player p) {
        p.drawToHand();
        p.incrementActions(1);
    }
}
