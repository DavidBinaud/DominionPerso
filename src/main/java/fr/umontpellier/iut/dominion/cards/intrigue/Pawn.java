package fr.umontpellier.iut.dominion.cards.intrigue;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.base.Action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pawn extends Action {
    public Pawn() {
        super("Pawn", 2);
    }

    @Override
    public void play(Player p) {
        List<String> choices = new ArrayList<>();
        String choixCard = "+1 Card";
        String choixAction = "+1 Action";
        String choixBuy = "+1 Buy";
        String choixMoney = "+1 Money";
        choices.add(choixCard);
        choices.add(choixAction);
        choices.add(choixBuy);
        choices.add(choixMoney);

        int nbchoices = 0;
        while (nbchoices < 2) {
            String input = p.chooseOption("choose one:", choices, false);
            if (input.equals(choixCard)){
                p.drawToHand();
                choices.remove(choixCard);
            }
            else if (input.equals(choixAction)){
                p.incrementActions(1);
                choices.remove(choixAction);

            }else if(input.equals(choixBuy)){
                p.incrementBuys(1);
                choices.remove(choixBuy);

            }else{
                p.incrementMoney(1);
                choices.remove(choixMoney);
            }
            nbchoices++;
        }
    }
}
