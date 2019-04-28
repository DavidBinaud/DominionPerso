package fr.umontpellier.iut.dominion.cards.base;


import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

/**
 * Carte Rénovation (Remodel)
 *
 * Écartez une carte de votre main.
 * Recevez une carte coûtant jusqu'à 2 Pièces de plus que la carte écartée.
 */
public class Remodel extends Action {
    public Remodel() {
        super("Remodel", 4);
    }

    @Override
    public void play(Player p) {
        Card toTrash = p.getCardsInHand().getCard(p.chooseCard("Card to trash",p.getCardsInHand(),false));
        p.removeFromHand(toTrash);
        p.getGame().trashCard(toTrash);

        Card toGain = p.getGame().getFromSupply(p.chooseCard("choisir une carte",p.getGame().availableSupplyCards(),false));
        while(toGain.getCost() > toTrash.getCost() + 2){
            toGain = p.getGame().getFromSupply(p.chooseCard("choisir une carte",p.getGame().availableSupplyCards(),false));
        }
        p.gainFromSupply(toGain.getName());
    }
}