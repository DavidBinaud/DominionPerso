package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * Carte Avant-coureur (Harbinger)
 *
 * +1 Carte.
 * +1 Action.
 * Regardez dans votre défausse, vous pouvez prendre une carte et la mettre sur votre deck.
 */
public class Harbinger extends Action {
    public Harbinger() {
        super("Harbinger", 3);
    }

    @Override
    public void play(Player p) {
        p.drawToHand();
        p.incrementActions(1);

        List<String> choices = new ArrayList<>();
        for (Card c:p.getCardsInDiscard()) {
            choices.add(c.getName());
        }
        String input = p.chooseOption("choose a card to put onto your deck",choices,true);
        System.out.println(p.getCardsInDiscard().toJSON());

        if(!input.equals("")){
            Card cardChoosen = p.getCardsInDiscard().getCard(input);
            p.addToDraw(cardChoosen);
            p.removeFromDiscard(cardChoosen);
        }
    }
}
