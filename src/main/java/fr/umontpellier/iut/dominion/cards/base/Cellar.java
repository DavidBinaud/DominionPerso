package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.Player;

/**
 * Carte Cave (Cellar)
 *
 * +1 Action.
 * Défaussez autant de cartes que vous voulez.
 * +1 Carte par carte défaussée.
 */
public class Cellar extends Action {
    public Cellar() {
        super("Cellar", 2);
    }

    @Override
    public void play(Player p) {
        p.incrementActions(1);

        String carteADefausser = p.chooseCard("Choisir une carte a defausser",p.getCardsInHand(),true);
        while (carteADefausser != ""){
            p.discardCard(p.getCardsInHand().getCard(carteADefausser));
            p.drawToHand();
        }
    }
}