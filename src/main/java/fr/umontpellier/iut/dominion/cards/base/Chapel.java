package fr.umontpellier.iut.dominion.cards.base;


import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

/**
 * Carte Chapelle (Chapel)
 *
 * Écartez jusqu'à 4 cartes de votre main.
 */
public class Chapel extends Action {
    public Chapel() {
        super("Chapel", 2);
    }

    @Override
    public void play(Player p) {
        int trashedCards = 0;
        while(trashedCards < 4){
            if (!p.getCardsInHand().isEmpty()) {
                String input = p.chooseCard("Cart to trash", p.getCardsInHand(), true);
                if (!input.equals("")) {
                    Card cardToThrash = p.getCardsInHand().getCard(input);
                    p.getGame().trashCard(cardToThrash);
                    p.removeFromHand(cardToThrash);
                }
                else {break;}
            }
        }
    }
}