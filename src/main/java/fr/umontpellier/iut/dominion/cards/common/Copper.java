package fr.umontpellier.iut.dominion.cards.common;


import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

/**
 * Carte Cuivre (Copper)
 *
 * 1 Pièce
 */
public class Copper extends Treasure {
    public Copper() {
        super("Copper", 0);
    }

    @Override
    public void play(Player p) {
        ListOfCards inPlay = p.getInPlay();
        int nbCoppersmith = 0;
        for (Card c: inPlay) {
            if (c.getName().equals("Coppersmith")){
                nbCoppersmith++;
            }
        }

        if (nbCoppersmith == 0){
            p.incrementMoney(1);
        }
        else{
            p.incrementMoney(1 + nbCoppersmith);
        }

    }
}
