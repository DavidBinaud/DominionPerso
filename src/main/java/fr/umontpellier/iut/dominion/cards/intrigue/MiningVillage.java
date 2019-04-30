package fr.umontpellier.iut.dominion.cards.intrigue;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.base.Action;

import java.util.Arrays;
import java.util.List;

public class MiningVillage extends Action {
    public MiningVillage() {
        super("Mining Village", 4);
    }

    @Override
    public void play(Player p) {
        p.drawToHand();
        p.incrementActions(2);


        // Throne Room the Mining Village doesnt allow to trash it twice
        if(p.getInPlay().contains(this)) {
            List<String> choices = Arrays.asList("y", "n");
            String input = p.chooseOption("trash the Mining Village? (+2 Money)", choices, false);
        }

    }
}
