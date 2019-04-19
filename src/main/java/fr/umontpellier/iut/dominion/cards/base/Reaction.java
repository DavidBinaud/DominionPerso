package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;


import java.util.List;

public abstract class Reaction extends Action {

    public Reaction(String name, int cost) {
        super(name, cost);
    }

    @Override
    public List<CardType> getTypes() {
        List<CardType> ListCardType = super.getTypes();
        ListCardType.add(CardType.Reaction);
        return ListCardType;
    }
}