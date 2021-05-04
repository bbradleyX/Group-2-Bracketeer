package edu.ithaca.dragon.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class CoordinatorTest {

    @Test
    void createBracketTest(){
    /* Player a = new Player("a","1231",0,.5);
    Player b = new Player("b","1232",0,.5); 
    Player c = new Player("c","1233",0,.5); 
    Player d = new Player("d","1234",0,.5); 
    list<Player> playerList = new arrayList<player>();;
    playerList(0) = a;
    playerList.add(b);
    playerList.add(c);
    playerList.add(d);
    */}

    @Test
    void createTeamTest(){
        Coordinator newCoord = new Coordinator("0000");
    }

    @Test
    void removeTeamTest(){
        //Create Coordinator object
        Coordinator newCoord = new Coordinator("2345");

        //Create a Tournament
        newCoord.createTournament("Hockey", "1234", new Game(), 0.0, teams);
    }

    @Test
    void isTimeConflict(){
        Player a = new Player("a", "1234", 2.0, 3.0);
        Coordinator newCoord = new Coordinator("2345");
        assertEquals(true, newCoord.isTimeconflict(a.getSchedule(), 2.0));
        assertEquals(false, newCoord.isTimeconflict(a.getSchedule(), 1.0));
        assertEquals(false, newCoord.isTimeconflict(a.getSchedule(), 5.0));
        assertEquals(false, newCoord.isTimeconflict(a.getSchedule(), 13.0));
        
    }
}