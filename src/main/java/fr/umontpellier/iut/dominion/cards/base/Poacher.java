package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

/**
 * Carte Braconnier (Poacher)
 *
 * +1 Action.
 * +1 Carte.
 * +1 Pièce.
 * Défaussez une carte de votre main par pile de réserve épuisée.
 */
public class Poacher extends Action {
    public Poacher() {
        super("Poacher", 4);
    }

    @Override
    public void play(Player p){

        p.incrementActions(1);
        p.drawToHand();
        p.incrementMoney(1);

        int aDefausser = p.getGame().sizeOfSupplyStack() - p.getGame().availableSupplyCards().size();

        for(int i = 0; i < aDefausser; i++){
            Card cardToDiscard = p.getCardsInHand().getCard(p.chooseCard("Card to discard",p.getCardsInHand(),false));
            p.removeFromHand(cardToDiscard);
            p.discardCard(cardToDiscard);
        }
    }
}
