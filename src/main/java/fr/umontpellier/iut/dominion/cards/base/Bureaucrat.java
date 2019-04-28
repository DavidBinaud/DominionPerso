package fr.umontpellier.iut.dominion.cards.base;


import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.common.Silver;
import fr.umontpellier.iut.dominion.cards.common.Victory;

/**
 * Carte Bureaucrate (Bureaucrat)
 *
 * Recevez une carte Argent; placez-la sur votre deck.
 * Tous vos adversaires dévoilent une carte Victoire et la placent sur leur deck (sinon ils dévoilent leur
 * main afin que vous puissiez voir qu'ils n'ont pas de cartes Victoire).
 */
public class Bureaucrat extends Attack {
    public Bureaucrat() {
        super("Bureaucrat", 4);
    }

    @Override
    public void play(Player p) {
        p.addToDraw(new Silver());

        for (Player otherPlayer: otherPlayersNoReact(p)) {
            ListOfCards cardsInHand = otherPlayer.getCardsInHand();
            ListOfCards victoryInHand = new ListOfCards();
            for (Card c: cardsInHand) {
                if (c.getTypes().contains(CardType.Victory)){
                    victoryInHand.add(c);
                }
            }
            if(!victoryInHand.isEmpty()){
                String input = otherPlayer.chooseCard("choisir la carte a réveler",victoryInHand,false);
                otherPlayer.fromHandToDraw(victoryInHand.getCard(input));
                System.out.println(input);
            }
            else {
                for (Card c:cardsInHand  ) {
                    System.out.println(c.getName());
                }
            }

        }
    }
}