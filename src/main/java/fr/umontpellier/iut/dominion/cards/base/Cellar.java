package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

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

        String carteADefausser;
        int nbCardsToDraw = 0;

        while (!p.getCardsInHand().isEmpty()){
            ListOfCards cardsInHand = p.getCardsInHand();
            carteADefausser = p.chooseCard("Choisir une carte a defausser",cardsInHand,true);
            if(!carteADefausser.equals("")) {
                Card toDiscard  = cardsInHand.getCard(carteADefausser);
                p.removeFromHand(toDiscard);
                p.discardCard(toDiscard);
                nbCardsToDraw++;
            }
            else{break;}
        }

        for (int i = 0; i < nbCardsToDraw; i++) {
            p.drawToHand();
        }
    }
}