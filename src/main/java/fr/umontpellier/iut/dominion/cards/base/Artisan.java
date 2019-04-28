package fr.umontpellier.iut.dominion.cards.base;


import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

/**
 * Carte Artisan
 *
 * Gagnez une carte coûtant jusqu'à 5 Pièces dans votre main.
 * Mettez une carte de votre main sur votre deck.
 */
public class Artisan extends Action {
    public Artisan() {
        super("Artisan", 6);
    }

    @Override
    public void play(Player p) {
        Card toGain = p.getGame().getFromSupply(p.chooseCard("choisir une carte",p.getGame().availableSupplyCards(),false));
        while(toGain.getCost() > 5){
            toGain = p.getGame().getFromSupply(p.chooseCard("choisir une carte",p.getGame().availableSupplyCards(),false));
        }
        p.addToHand(p.getGame().removeFromSupply((toGain.getName())));


        Card choice = p.getCardsInHand().getCard(p.chooseCard("carte a mettre dans la pioche",p.getCardsInHand(),false));
        p.fromHandToDraw(choice);
    }
}
