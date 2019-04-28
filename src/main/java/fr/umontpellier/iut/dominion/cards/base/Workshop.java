package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

/**
 * Carte Atelier (Workshop)
 *
 * Recevez une carte coûtant jusqu'à 4 Pièces.
 */
public class Workshop extends Action {
    public Workshop() {
        super("Workshop", 3);
    }

    @Override
    public void play(Player p) {
        Card toGain = p.getGame().getFromSupply(p.chooseCard("choisir une carte",p.getGame().availableSupplyCards(),false));
        while(toGain.getCost() > 4){
            toGain = p.getGame().getFromSupply(p.chooseCard("choisir une carte",p.getGame().availableSupplyCards(),false));
        }
        p.gainFromSupply(toGain.getName());
    }
}