package fr.umontpellier.iut.dominion.cards;

import fr.umontpellier.iut.dominion.Game;
import fr.umontpellier.iut.dominion.IOGame;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.base.Moat;
import fr.umontpellier.iut.dominion.cards.common.Estate;
import fr.umontpellier.iut.dominion.cards.intrigue.Baron;
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
}