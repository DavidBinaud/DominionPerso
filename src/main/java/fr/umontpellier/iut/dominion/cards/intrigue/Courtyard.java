package fr.umontpellier.iut.dominion.cards.intrigue;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.base.Action;

public class Courtyard extends Action {
    public Courtyard() {
        super("Courtyard", 2);
    }

    @Override
    public void play(Player p) {
        p.drawToHand();
        p.drawToHand();
        p.drawToHand();

        String input = p.chooseCard("Choose a card to put back on top of your deck",p.getCardsInHand(),false);
        p.fromHandToDraw(p.getCardsInHand().getCard(input));
    }
}
