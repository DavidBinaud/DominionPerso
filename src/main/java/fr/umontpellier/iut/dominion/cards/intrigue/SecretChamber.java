package fr.umontpellier.iut.dominion.cards.intrigue;

import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.base.Reaction;

public class SecretChamber extends Reaction {
    public SecretChamber() {
        super("Secret Chamber", 2);
    }

    @Override
    public void play(Player p) {
        ListOfCards inHand = p.getCardsInHand();
        String cardName = p.chooseCard("Choose a card to discard.",inHand, true);
        int nbCartesDefausses = 0;

        while (!inHand.isEmpty() && cardName != "") {

            if (inHand.getCard(cardName) != null) {
                Card toDiscard = inHand.getCard(cardName);
                p.discardCard(toDiscard);
                p.removeFromHand(toDiscard);
                nbCartesDefausses++;
            }

            inHand = p.getCardsInHand();
            cardName = p.chooseCard("Choose a card to discard.", inHand, true);
        }
        for (int i=0; i<nbCartesDefausses; ++i) {
            p.drawToHand();
        }
    }
}


