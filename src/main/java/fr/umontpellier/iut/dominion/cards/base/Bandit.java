package fr.umontpellier.iut.dominion.cards.base;


import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.common.Gold;

/**
 * Carte Bandit
 *
 * Gagnez un Or.
 * Chaque joueur révèle les deux premières cartes de son deck, écarte un trésor autre que Cuivre et défausse le reste.
 */
public class Bandit extends Attack {
    public Bandit() {
        super("Bandit", 5);
    }

    @Override
    public void play(Player p) {
        p.gainFromSupply("Gold");

        for (Player otherPlayer: otherPlayersNoReact(p)) {
            ListOfCards topDeck = new ListOfCards();
            topDeck.add(otherPlayer.drawCard());
            topDeck.add(otherPlayer.drawCard());

            ListOfCards topDeckTreasure = new ListOfCards();
            for (Card c: topDeck ) {
                if (c.getTypes().contains(CardType.Treasure) && !c.getName().equals("Copper")){
                    topDeckTreasure.add(c);
                }
            }
            topDeck.removeAll(topDeckTreasure);

            if(topDeckTreasure.size() > 1){
                Card treasureCardToTrash = topDeckTreasure.getCard(otherPlayer.chooseCard("Treasure card to trash",topDeckTreasure,false));
                System.out.println(topDeckTreasure.toJSON());
                otherPlayer.trashCard(treasureCardToTrash);
                topDeckTreasure.remove(treasureCardToTrash);

                otherPlayer.discardCard(topDeckTreasure.get(0));
            }
            else{
                for (Card c: topDeckTreasure) {
                    otherPlayer.trashCard(c);
                }
                for (Card c: topDeck) {
                    otherPlayer.discardCard(c);
                }
            }

        }


    }
}
