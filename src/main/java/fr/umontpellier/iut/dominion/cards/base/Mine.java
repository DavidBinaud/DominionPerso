package fr.umontpellier.iut.dominion.cards.base;


import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

/**
 * Carte Mine
 *
 * Écartez une carte Trésor de votre main. Recevez une carte Trésor coûtant jusqu'à 3 Pièces de plus ;
 * ajoutez cette carte à votre main.
 */
public class Mine extends Action {
    public Mine() {
        super("Mine", 5);
    }

    @Override
    public void play(Player p) {
        ListOfCards inHand = p.getCardsInHand();
        if(!inHand.isEmpty()){
            ListOfCards treasure = new ListOfCards();
            for (Card c: inHand ) {
                if (c.getTypes().contains(CardType.Treasure)){
                    treasure.add(c);
                }
            }
            if(!treasure.isEmpty()){
                String input = p.chooseCard("choose a Treasure Card to trash",treasure,false);
                Card toTrash = treasure.getCard(input);
                p.getGame().trashCard(toTrash);
                p.removeFromHand(toTrash);
                treasure.clear();
                for (Card c: p.getGame().availableSupplyCards()) {
                    if(c.getTypes().contains(CardType.Treasure) && c.getCost() <= toTrash.getCost() + 3){
                        treasure.add(c);
                    }
                }
                input = p.chooseCard("carte trésor à gagner",treasure,false);
                p.addToHand(p.getGame().removeFromSupply(input));
            }
        }
    }
}