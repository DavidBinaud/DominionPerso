package fr.umontpellier.iut.dominion.cards.common;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

import java.util.ArrayList;
import java.util.List;

import static fr.umontpellier.iut.dominion.CardType.Victory;

/**
 * Carte Province
 *
 * 6 VP
 */
public class Province extends Card {
    public Province() {
        super("Province", 8);
    }


    @Override
    public int getVictoryValue(Player p) {
        return 6;
    }



}