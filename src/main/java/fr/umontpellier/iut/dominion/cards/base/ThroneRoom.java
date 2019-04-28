package fr.umontpellier.iut.dominion.cards.base;


import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

/**
 * Carte Salle du trône (Throne Room)
 *
 * Choisissez 1 carte Action de votre main.
 * Jouez-la deux fois.
 */
public class ThroneRoom extends Action {
    public ThroneRoom() {
        super("Throne Room", 4);
    }

    @Override
    public void play(Player p) {
        ListOfCards actionsCard = new ListOfCards();
        for (Card card: p.getCardsInHand()) {
            if(card.getTypes().contains(CardType.Action)){
                actionsCard.add(card);
            }

        }
        if (!actionsCard.isEmpty()) {
            Card toPlayTwice = p.getCardsInHand().getCard(p.chooseCard("carte Action a jouer deux fois", actionsCard, false));
            p.playCard(toPlayTwice.getName());
            toPlayTwice.play(p);
        }
    }
}