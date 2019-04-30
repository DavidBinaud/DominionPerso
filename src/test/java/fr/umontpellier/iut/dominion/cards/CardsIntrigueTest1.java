package fr.umontpellier.iut.dominion.cards;

import fr.umontpellier.iut.dominion.Game;
import fr.umontpellier.iut.dominion.IOGame;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.base.Moat;
import fr.umontpellier.iut.dominion.cards.common.Copper;
import fr.umontpellier.iut.dominion.cards.common.Estate;
import fr.umontpellier.iut.dominion.cards.intrigue.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class CardsIntrigueTest1 {

    private IOGame game;
    private Player p0, p1, p2;


    @BeforeEach
    void disableConsole() {

        System.setOut(new PrintStream(new OutputStream() {

            @Override
            public void write(int arg0) {

            }
        }));

    }

    @BeforeEach
    void setUp() {
        String[] playerNames = new String[]{"Toto", "Titi", "Tutu"};
        game = new IOGame(playerNames, new String[0]);
        p0 = game.getPlayer(0);
        p1 = game.getPlayer(1);
        p2 = game.getPlayer(2);
    }




    @Test
    void testBaronPlaysEstate() {
        p0.getDiscard().clear();
        p0.getHand().add(new Baron());
        p0.getHand().add(new Estate());

        assertEquals(0,p0.getMoney());
        assertEquals(0,p0.getNumberOfBuys());

        game.setInput("y");
        p0.playCard("Baron");

        assertEquals(1,p0.getNumberOfBuys());
        assertEquals(4,p0.getMoney());
        assertNotNull(p0.getDiscard().getCard("Estate"));
        assertEquals(5, p0.getHand().size());
    }


    @Test
    void testBaronDoesntPlayEstate() {
        p0.getDiscard().clear();
        p0.getHand().add(new Baron());
        p0.getHand().add(new Estate());

        assertEquals(0,p0.getMoney());

        game.setInput("n");
        p0.playCard("Baron");

        assertEquals(0,p0.getMoney());
        assertEquals(1,p0.getNumberOfBuys());
        assertNotNull(p0.getDiscard().getCard("Estate"));
        assertEquals(6, p0.getHand().size());
    }

    @Test
    void testConspirator() {
        p0.getHand().add(new Conspirator());
        p0.getInPlay().add(new Baron());
        p0.getInPlay().add(new Bridge());


        p0.playCard("Conspirator");

        assertEquals(2,p0.getMoney());
        assertEquals(1,p0.getNumberOfActions());
        assertEquals(6, p0.getHand().size());


        p1.getInPlay().clear();
        p1.getHand().add(new Conspirator());
        p1.getInPlay().add(new Baron());
        p1.getInPlay().add(new Copper());

        p1.playCard("Conspirator");

        assertEquals(2,p1.getMoney());
        assertEquals(0,p1.getNumberOfActions());
        assertEquals(5, p1.getHand().size());
    }

    @Test
    void testCopperSmith() {
        p0.getHand().add(new Coppersmith());
        p0.getHand().add(new Coppersmith());
        p0.getHand().add(new Coppersmith());

        assertEquals(0,p0.getMoney());

        p0.playCard("Copper");

        assertEquals(1,p0.getMoney());

        p0.playCard("Coppersmith");
        p0.playCard("Copper");

        assertEquals(3,p0.getMoney());

        p0.playCard("Coppersmith");
        p0.playCard("Copper");

        assertEquals(6,p0.getMoney());

        p0.getHand().add(new Copper());
        p0.playCard("Coppersmith");
        p0.playCard("Copper");

        assertEquals(10,p0.getMoney());
    }



    @Test
    void testCourtyard() {
        p0.getHand().add(new Courtyard());
        p0.getHand().add(new Baron());

        assertEquals(7,p0.getHand().size());

        game.setInput("Baron");
        p0.playCard("Courtyard");


        assertEquals(8,p0.getHand().size());
        assertNotNull(p0.getDraw().getCard("Baron"));
        assertNull(p0.getHand().getCard("Baron"));
    }
}
