package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;


import java.util.List;

public abstract class Attack extends Action {

    public Attack(String name, int cost) {
        super(name, cost);
    }

    @Override
    public List<CardType> getTypes() {
        List<CardType> ListCardType = super.getTypes();
        ListCardType.add(CardType.Attack);
        return ListCardType;
    }
}
