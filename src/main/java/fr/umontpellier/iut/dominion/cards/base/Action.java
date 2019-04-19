package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.cards.Card;

import java.util.List;

public abstract class Action extends Card {

    public Action(String name, int cost) {
        super(name, cost);
    }

    @Override
    public List<CardType> getTypes() {
        List<CardType> ListCardType = super.getTypes();
        ListCardType.add(CardType.Action);
        return ListCardType;
    }
}
