package fr.umontpellier.iut.dominion.cards.intrigue;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.base.Action;

public class Conspirator extends Action {
    public Conspirator() {
        super("Conspirator", 4);
    }

    @Override
    public void play(Player p) {
        p.incrementMoney(2);

        ListOfCards inPlay = p.getCardsInPlay();
        int nbActionsInPlay = 0;
        for (Card c: inPlay) {
            if (c.getTypes().contains(CardType.Action)){
                nbActionsInPlay++;
            }
        }

        if (nbActionsInPlay >= 3){
            
        }
    }
}
