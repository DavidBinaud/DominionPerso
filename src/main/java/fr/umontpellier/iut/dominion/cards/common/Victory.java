package fr.umontpellier.iut.dominion.cards.common;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.cards.Card;

import java.util.List;

public abstract class Victory extends Card {

    public Victory(String name, int cost){
        super(name,cost);
    }

    @Override
    public List<CardType> getTypes() {
        List<CardType> cardTypeList = super.getTypes();
        cardTypeList.add(CardType.Victory);
        return  cardTypeList;
    }
}
