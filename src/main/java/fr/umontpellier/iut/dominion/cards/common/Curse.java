package fr.umontpellier.iut.dominion.cards.common;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

import java.util.List;

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
    public List<CardType> getTypes() {
        List<CardType> cardTypeList = super.getTypes();
        cardTypeList.add(CardType.Curse);
        return  cardTypeList;
    }

    @Override
    public int getVictoryValue(Player p) {
        return -1;
    }
}