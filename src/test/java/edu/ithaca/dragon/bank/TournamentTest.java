package edu.ithaca.dragon.bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class TournamentTest {

    
        @Test
        void getNameTest() {
             Player Player1 = new Player("a", "1234", 9.0, 5.5);
            Player Player2 = new Player("b", "1235", 9.0, 5.5);
            Player[] playerList = new Player[2];
            playerList[0]=Player1;
            playerList[1]=Player2;
            Tournament myTourny = new Tournament("a","1234", 9.0,playerList);
            assertEquals(myTourny.getName(), "a");
        }
    
        @Test
        void getIDTest() {
            Player Player1 = new Player("a", "1234", 9.0, 5.5);
            Player Player2 = new Player("b", "1235", 9.0, 5.5);
            Player[] playerList = new Player[2];
            playerList[0]=Player1;
            playerList[1]=Player2;
            Tournament myTourny = new Tournament("a","1234", 9.0,playerList);
            assertEquals(myTourny.getID(), "1234");
        }
    
        @Test
        void getPlayerTest() {
            Player Player1 = new Player("a", "1234", 9.0, 5.5);
            Player Player2 = new Player("b", "1235", 9.0, 5.5);
            Player[] playerList = new Player[2];
            playerList[0]=Player1;
            playerList[1]=Player2;
            Tournament myTourny = new Tournament("a","1234", 9.0,playerList);
            assertEquals(myTourny.getPlayers()[0].getName(), "a");
            assertEquals(myTourny.getPlayers()[1].getName(), "b");
        }
    
    }
    //@Test