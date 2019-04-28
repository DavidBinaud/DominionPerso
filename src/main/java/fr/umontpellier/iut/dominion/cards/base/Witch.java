package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.Player;

/**
 * Carte Sorcière (Witch)
 *
 * +2 Cartes.
 * Tous vos adversaires recoivent une carte Curse.
 */
public class Witch extends Attack {
    public Witch() {
        super("Witch", 5);
    }

    @Override
    public void play(Player p) {
        p.drawToHand();
        p.drawToHand();

        for (Player otherPlayer: p.getOtherPlayers()) {
            otherPlayer.gainFromSupply("Curse");
        }
    }
}