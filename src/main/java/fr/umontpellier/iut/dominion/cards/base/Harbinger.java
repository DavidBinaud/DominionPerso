package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

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

        String input = p.chooseCard("choose a card to put onto your deck",p.getCardsInDiscard(),true);

        if(!input.equals("")){
            Card cardChoosen = p.getCardsInDiscard().getCard(input);
            p.addToDraw(cardChoosen);
            p.removeFromDiscard(cardChoosen);
        }
    }
}
