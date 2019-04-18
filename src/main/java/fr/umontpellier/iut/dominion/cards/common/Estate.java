package fr.umontpellier.iut.dominion.cards.common;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

import java.util.ArrayList;
import java.util.List;

import static fr.umontpellier.iut.dominion.CardType.Victory;

/**
 * Carte Domaine (Estate)
 *
 * 1 VP
 */
public class Estate extends Card {
    public Estate() {
        super("Estate", 2);
    }


    @Override
    public int getVictoryValue(Player p) {
        return 1;
    }

}