package fr.umontpellier.iut.dominion.cards.intrigue;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.base.Action;

public class Tribute extends Action {
    public Tribute() {
        super("Tribute", 5);
    }

    @Override
    public void play(Player p) {
        Player playerOnLeft = p.getPlayerOnLeft();
        if(playerOnLeft != null){
                Card drawnCard1 = playerOnLeft.drawCard();
                Card drawnCard2 = playerOnLeft.drawCard();

                playerOnLeft.discardCard(drawnCard1);
                playerOnLeft.discardCard(drawnCard2);


                if (drawnCard1 != null){

                    for (CardType cType: drawnCard1.getTypes()) {
                        if (cType.equals(CardType.Action)){
                            p.incrementActions(2);
                        }
                        else if(cType.equals(CardType.Victory)){
                            p.incrementMoney(2);
                        }
                        else if (cType.equals(CardType.Treasure)){
                            p.drawToHand();
                            p.drawToHand();
                        }

                    }

                    if (drawnCard2 != null && !drawnCard1.getName().equals(drawnCard2.getName())){

                        for (CardType cType: drawnCard2.getTypes()) {
                            if (cType.equals(CardType.Action)){
                                p.incrementActions(2);
                            }
                            else if(cType.equals(CardType.Victory)){
                                p.incrementMoney(2);
                            }
                            else if (cType.equals(CardType.Treasure)){
                                p.drawToHand();
                                p.drawToHand();
                            }

                        }
                    }
                }
        }
    }
}

