package fr.umontpellier.iut.dominion.cards.base;


import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

import java.util.Arrays;
import java.util.List;

/**
 * Carte Sentinelle (Sentry)
 *
 * +1 Carte.
 * +1 Action.
 * Regardez les 2 premières cartes de votre deck. Écartez et/ou défaussez celles que vous voulez.
 * Replacez les autres sur votre deck dans l'ordre de votre choix.
 */
public class Sentry extends Action {
    public Sentry() {
        super("Sentry", 5);
    }

    @Override
    public void play(Player p) {
        p.drawToHand();
        p.incrementActions(1);

        ListOfCards cardsDrawn = new ListOfCards();
        cardsDrawn.add(p.drawCard());
        cardsDrawn.add(p.drawCard());

        String input = "empty";
        while (!input.equals("") && !cardsDrawn.isEmpty()) {
            input = p.chooseCard("cards to trash", cardsDrawn, true);
            p.trashCard(cardsDrawn.getCard(input));
            cardsDrawn.remove(input);
        }

        input = "empty";
        while (!input.equals("") && !cardsDrawn.isEmpty()) {
            input = p.chooseCard("cards to discard", cardsDrawn, true);
            p.discardCard(cardsDrawn.getCard(input));
            cardsDrawn.remove(input);
        }


        while (!cardsDrawn.isEmpty()) {
            input = p.chooseCard("order of cards(last on top)", cardsDrawn, false);
            p.addToDraw(cardsDrawn.getCard(input));
            cardsDrawn.remove(input);
        }

    }
}

