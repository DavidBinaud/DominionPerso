package fr.umontpellier.iut.dominion.cards.intrigue;

import fr.umontpellier.iut.dominion.Player;

import java.util.Arrays;
import java.util.List;

public class Nobles extends ActionVictory {
    public Nobles() {
        super("Nobles", 6);
    }

    @Override
    public int getVictoryValue(Player p) {
        return 2;
    }

    @Override
    public void play(Player p) {
        List<String> choices = Arrays.asList("+3 Cards", "+2 Actions");
        String input = p.chooseOption("choose one:",choices,false);
        if (input.equals("+3 Cards")){
            p.drawToHand();
            p.drawToHand();
            p.drawToHand();
        }
        else{
            p.incrementActions(2);
        }
    }
}
