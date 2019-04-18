package fr.umontpellier.iut.dominion.cards.common;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

import java.util.ArrayList;
import java.util.List;

import static fr.umontpellier.iut.dominion.CardType.Victory;

/**
 * Carte Duché (Duchy)
 *
 * 3 VP
 */
public class Duchy extends Card {
    public Duchy() {
        super("Duchy", 5);
    }

    @Override
    public int getVictoryValue(Player p) {
        return 3;
    }

}