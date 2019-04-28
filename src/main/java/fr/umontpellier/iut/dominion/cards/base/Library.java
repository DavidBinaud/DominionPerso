package fr.umontpellier.iut.dominion.cards.base;


import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

import java.util.Arrays;
import java.util.List;

/**
 * Carte Bibliothèque (Library)
 *
 * Piochez jusqu'à ce que vous ayez 7 cartes en main. Chaque carte Action piochée peut être mise de côté.
 * Défaussez les cartes mises de côté lorsque vous avez terminé de piocher.
 */
public class Library extends Action {
    public Library() {
        super("Library", 5);
    }

    @Override
    public void play(Player p) {
        ListOfCards cardsInHand = p.getCardsInHand();

        ListOfCards asideCards = new ListOfCards();
        while (cardsInHand.size() < 7){
           Card drawedCard = p.drawCard();
           if (drawedCard.getTypes().contains(CardType.Action)){
                 List<String> choices = Arrays.asList("y", "n");
                String input = p.chooseOption("Do you want to put " + drawedCard.getName() + " aside?", choices, false);
                if (input == "y"){
                    asideCards.add(drawedCard);
                }
                else{
                    p.addToHand(drawedCard);
                }
           }
           else {
               p.addToHand(drawedCard);
           }
           cardsInHand = p.getCardsInHand();
        }

        for (Card c: asideCards) {
            p.discardCard(c);
        }
    }
}