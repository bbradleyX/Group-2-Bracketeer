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
    void isTimeConflict(){
        Player a = new Player("a", "1234", 2.0, 3.0);
        Coordinator newCoord = new Coordinator("2345");
        assertEquals(true, newCoord.isTimeconflict(a.getSchedule(), 2.0)); //Border case: The time must be between the pair time for the player
        assertEquals(false, newCoord.isTimeconflict(a.getSchedule(), 1.0)); //Border case: It can't be below the pair time
        assertEquals(false, newCoord.isTimeconflict(a.getSchedule(), 5.0));
        assertEquals(false, newCoord.isTimeconflict(a.getSchedule(), 13.0)); //Border case: It can't be over 12 hour mark of the time

        Player b = new Player("b", "2345", 4.5, 8.0);
        Coordinator newCoord2 = new Coordinator("6789");
        assertEquals(false, newCoord2.isTimeconflict(b.getSchedule(), -4.5)); //Border case: The time for the tournament can't be before 0
        assertEquals(false, newCoord2.isTimeconflict(b.getSchedule(), 0)); //Border case: The time for the tournament can't be 0 
        assertEquals(true, newCoord2.isTimeconflict(b.getSchedule(), 4.5)); //Border case: The time for the tournanment can be at the exact time as the schedule
        assertEquals(true, newCoord2.isTimeconflict(b.getSchedule(), 8.0)); 
        
    }
}