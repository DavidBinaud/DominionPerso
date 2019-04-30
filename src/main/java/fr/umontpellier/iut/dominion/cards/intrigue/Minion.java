package fr.umontpellier.iut.dominion.cards.intrigue;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.base.Attack;

import java.util.Arrays;
import java.util.List;

public class Minion extends Attack {
    public Minion() {
        super("Minion", 5);
    }

    @Override
    public void play(Player p) {
        p.incrementActions(1);

        List<String> choices = Arrays.asList("+2 Money","Each Player discard hand and draws 4 cards");
        String input = p.chooseOption("Choose:",choices,false);

        if (input.equals("+2 Money")){
            p.incrementMoney(2);
        }
        else {
            for (Card c: p.getHand()) {
                p.fromHandToDiscard(c);
            }
            p.drawToHand();
            p.drawToHand();
            p.drawToHand();
            p.drawToHand();

            for (Player otherPlayer: p.getOtherPlayers()) {
                if (otherPlayer.getHand().size() > 4) {
                    for (Card c : p.getHand()) {
                        p.fromHandToDiscard(c);
                    }
                    p.drawToHand();
                    p.drawToHand();
                    p.drawToHand();
                    p.drawToHand();

                }
            }
        }
    }
}


