package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.Player;


import java.util.ArrayList;
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

    public List<Player> otherPlayersNoReact(Player p){
        List<Player> otherPlayers = p.getOtherPlayers();
        List<Player> otherPlayersNoReact = new ArrayList<>();

        for (Player oPlayer : otherPlayers) {
            if (!oPlayer.reactToAttack()){
                otherPlayersNoReact.add(oPlayer);
            }
        }
        return otherPlayersNoReact;
    }
}
