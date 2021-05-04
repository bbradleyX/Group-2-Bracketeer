package edu.ithaca.dragon.bank;
import org.javatuples.Pair;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class GameTest {

    //@Test

    @Test
    void WinLoseTest() {
        Player player1 = new Player("A", "1234", 9.0, 5.5);
        Player player2 = new Player("B", "1234", 9.0, 5.5);
        Pair<Player,Player> players = new Pair(player1,player2);
        Game game1 = new Game("game1", "1234",5.5 ,player1,player2);
        game1.hasWon(player1);
        assertEquals(player1.getID(),game1.getWinner().getID());
        assertEquals(player2.getID(),game1.getLoser().getID());
        




    }
}