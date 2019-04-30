package fr.umontpellier.iut.dominion.cards.intrigue;

import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.base.Action;

public class Upgrade extends Action {
    public Upgrade() {
        super("Upgrade", 5);
    }

    @Override
    public void play(Player p) {
        p.drawToHand();
        p.incrementActions(1);

        ListOfCards inHand = p.getCardsInHand();
        String input = p.chooseCard("choose a card to trash",inHand,false);
        Card cardToTrash = inHand.getCard(input);
        int costPossible = cardToTrash.getCost() + 1;

        p.trashCard(cardToTrash);

        ListOfCards availableSupplyCards =p.getGame().availableSupplyCards();
        ListOfCards possibleCardsToGain = new ListOfCards();
        for (Card c: availableSupplyCards) {
            if (c.getCost() <= costPossible){
                possibleCardsToGain.add(c);
            }
        }

        input = p.chooseCard("choose a card to gain",possibleCardsToGain,false);
        p.gainFromSupply(input);
    }
}
