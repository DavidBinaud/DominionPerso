package fr.umontpellier.iut.dominion.cards.common;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

import java.util.ArrayList;
import java.util.List;

import static fr.umontpellier.iut.dominion.CardType.Treasure;

/**
 * Carte Cuivre (Copper)
 *
 * 1 Pièce
 */
public class Copper extends Card {

    public Copper() {
        super("Copper", 0);
    }


    @Override
    public void play(Player p) {
        p.incrementMoney(1);
    }

    @Override
    public List<CardType> getTypes() {
        List<CardType> cardTypeList = new ArrayList<>();
        cardTypeList.add(Treasure);
        return  cardTypeList;
    }
}
