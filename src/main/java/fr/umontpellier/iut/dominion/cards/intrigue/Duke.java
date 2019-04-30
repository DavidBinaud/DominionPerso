package fr.umontpellier.iut.dominion.cards.intrigue;

import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.common.Victory;

public class Duke extends Victory {
    public Duke() {
        super("Duke", 5);
    }

    @Override
    public int getVictoryValue(Player p) {
        int duchyNumber = 0;
        for (Card c: p.getAllCards()) {
            if(c.getName().equals("Duchy")){
                duchyNumber++;
            }
        }

        return duchyNumber;
    }
}
