package edu.ithaca.dragon.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class GameTest {

    
    @Test
    void getNameTest() {
        Player Player1 = new Player("a", "1234", 9.0, 5.5);
        Player Player2 = new Player("b", "1235", 9.0, 5.5);
        Game myGame = new Game("a","1234",9.0,2,Player1,Player2);
        assertEquals(myGame.getName(), "a");
    }

    @Test
    void getIDTest() {
        Player Player1 = new Player("a", "1234", 9.0, 5.5);
        Player Player2 = new Player("b", "1235", 9.0, 5.5);
        Game myGame = new Game("a","1234",9.0,2,Player1,Player2);
        assertEquals(myGame.getID(), "1234");
    }

    @Test
    void getPlayerLimitTest() {
        Player Player1 = new Player("a", "1234", 9.0, 5.5);
        Player Player2 = new Player("b", "1235", 9.0, 5.5);
        Game myGame = new Game("a","1234",9.0,2,Player1,Player2);
        assertEquals(myGame.getPlayerLimit(),2);
    }

    @Test
    void getPlayerTest() {
        Player Player1 = new Player("a", "1234", 9.0, 5.5);
        Player Player2 = new Player("b", "1235", 9.0, 5.5);
        Game myGame = new Game("a","1234",9.0,2,Player1,Player2);
        assertEquals(myGame.getPlayer1().getName(), "a");
        assertEquals(myGame.getPlayer1().getID(), "1234");
        assertEquals(myGame.getPlayer2().getName(), "b");
        assertEquals(myGame.getPlayer2().getID(), "1235");
    }

}