package fr.umontpellier.iut.dominion.cards.base;


import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

/**
 * Carte Milice (Militia)
 *
 * 2 Pièces.
 * Tous vos adversaires défaussent leurs cartes de façon à n'avoir que 3 cartes en main.
 */
public class Militia extends Attack {
    public Militia() {
        super("Militia", 4);
    }

    @Override
    public void play(Player p) {
        p.incrementMoney(2);

        for (Player otherPlayer: otherPlayersNoReact(p)) {
           while (otherPlayer.getCardsInHand().size() > 3){
               Card c = otherPlayer.getCardsInHand().getCard(otherPlayer.chooseCard("Carte à defausser",otherPlayer.getCardsInHand(),false));
               otherPlayer.removeFromHand(c);
               otherPlayer.discardCard(c);
           }
        }
    }
}