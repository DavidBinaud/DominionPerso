package fr.umontpellier.iut.dominion.cards.intrigue;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.base.Action;

import java.util.Arrays;
import java.util.List;

public class Steward extends Action {
    public Steward() {
        super("Steward", 3);
    }

    @Override
    public void play(Player p) {
        List<String> choices = Arrays.asList("+2 Cards","+2 Money","Trash 2 Cards from hand");
        String input = p.chooseOption("Choose an option:",choices,false);

        if (input.equals("+2 Cards")){
            p.drawToHand();
            p.drawToHand();
        }
        else if (input.equals("+2 Money")){
            p.incrementMoney(2);
        }
        else{
            input = p.chooseCard("Card to trash:",p.getCardsInHand(),false);
            p.trashCard(p.getCardsInHand().getCard(input));

            input = p.chooseCard("Card to trash:",p.getCardsInHand(),false);
            p.trashCard(p.getCardsInHand().getCard(input));
        }
    }
}
