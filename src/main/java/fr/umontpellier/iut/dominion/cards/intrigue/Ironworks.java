package fr.umontpellier.iut.dominion.cards.intrigue;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.base.Action;

import java.util.ArrayList;
import java.util.List;

public class Ironworks extends Action {
    public Ironworks() {
        super("ironWorks", 4);
    }

    @Override
    public void play(Player p) {
        String input = p.chooseCard("choose a card to gain",p.getGame().availableSupplyCards(),false);
        Card gainedCard = p.gainFromSupply(input);

        for (CardType cType: gainedCard.getTypes()) {
            if(cType.equals(CardType.Action)){
                p.incrementActions(1);
            }
            else if (cType.equals(CardType.Treasure)){
                p.incrementMoney(1);
            }
            else if (cType.equals(CardType.Victory)){
                p.drawToHand();
            }
        }
    }
}
