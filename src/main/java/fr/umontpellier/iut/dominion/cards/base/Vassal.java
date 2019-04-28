package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

import java.util.Arrays;
import java.util.List;

/**
 * Carte Vassal
 *
 * +2 Pièces.
 * Défaussez la première carte de votre deck. Si c'est une carte Action, vous pouvez la jouer.
 */
public class Vassal extends Action {
    public Vassal() {
        super("Vassal", 3);
    }

    @Override
    public void play(Player p) {
        p.incrementMoney(2);
        ListOfCards draw = p.getCardsInDraw();
        if(!draw.isEmpty()){
            Card remove = p.drawCard();
            List<String> choices = Arrays.asList("y", "n");
            if (remove.getTypes().contains(CardType.Action) && p.chooseOption("jouer la carte " + remove.getName() ,choices,false) == "y"){
                p.addToHand(remove);
                p.playCard(remove.getName());
            }
            else{p.discardCard(remove);}
        }
    }
}
