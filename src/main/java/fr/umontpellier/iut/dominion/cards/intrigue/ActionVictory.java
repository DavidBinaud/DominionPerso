package fr.umontpellier.iut.dominion.cards.intrigue;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.cards.Card;

import java.util.List;

public abstract class ActionVictory extends Card {

    public ActionVictory(String name,int cost){
        super(name,cost);
    }

    @Override
    public List<CardType> getTypes() {
        List<CardType> ListCardType = super.getTypes();
        ListCardType.add(CardType.Action);
        ListCardType.add(CardType.Victory);
        return ListCardType;
    }
}
