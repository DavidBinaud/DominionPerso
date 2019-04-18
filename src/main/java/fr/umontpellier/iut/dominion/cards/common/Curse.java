package fr.umontpellier.iut.dominion.cards.common;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

import java.util.ArrayList;
import java.util.List;

import static fr.umontpellier.iut.dominion.CardType.Curse;

/**
 * Carte Malédiction (Curse)
 *
 * -1 VP
 */
public class Curse extends Card {
    public Curse() {
        super("Curse", 0);
    }


    @Override
    public int getVictoryValue(Player p) {
        return -1;
    }

}