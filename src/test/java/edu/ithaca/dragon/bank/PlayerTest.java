package edu.ithaca.dragon.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    void validateArgumentsTest() {

        //valid name tests
        assertTrue(Player.validateArguments("Adam", "1234", 9.0, 5.5));
        assertFalse(Player.validateArguments("", "1234", 9.0, 5.5));

        //valid ID tests
        assertTrue(Player.validateArguments("Adam", "1234", 9.0, 5.5));
        assertFalse(Player.validateArguments("Adam", "123", 9.0, 5.5));
        assertFalse(Player.validateArguments("Adam", "123a", 9.0, 5.5));

        //valid start time tests
        assertTrue(Player.validateArguments("Adam", "1234", 9.0, 5.5));
        assertFalse(Player.validateArguments("Adam", "1234", -1, 5.5));

        //valid end time tests
        assertTrue(Player.validateArguments("Adam", "1234", 9.0, 5.5));
        assertFalse(Player.validateArguments("Adam", "1234", 9.0, 24.5));
    }

    @Test
    void getNameTest() {
        Player myPlayer = new Player("Adam", "1234", 9.0, 5.5);
        assertEquals(myPlayer.getName(), "Adam");
    }

    @Test
    void getIDTest() {
        Player myPlayer = new Player("Adam", "1234", 9.0, 5.5);
        assertEquals(myPlayer.getID(), "1234");
    }

    @Test
    void getScheduleTest() {
        Player myPlayer = new Player("Adam", "1234", 9.0, 17.5);
        assertEquals(9.0, myPlayer.getSchedule().getValue0().doubleValue());
        assertEquals(17.5, myPlayer.getSchedule().getValue1().doubleValue());
    }

    @Test 
    void modifyScheduleTest(){
        Player amber = new Player("Amber", "2468", 8.0, 10.0);
        amber.modifySchedule(4.0, 7.0);
        assertEquals(4.0, amber.getSchedule().getValue0().doubleValue());
        assertEquals(7.0, amber.getSchedule().getValue1().doubleValue());

        //testing double 
        Player amber1 = new Player("Amber", "2468", 8.0, 10.0);
        amber1.modifySchedule(4.50, 7.50);
        assertEquals(4.50, amber1.getSchedule().getValue0().doubleValue());
        assertEquals(7.50, amber1.getSchedule().getValue1().doubleValue());

        Player amber2 = new Player("Amber", "2468", 8.0, 10.0);
        amber2.modifySchedule(4.59, 7.59);
        assertEquals(4.59, amber2.getSchedule().getValue0().doubleValue());
        assertEquals(7.59, amber2.getSchedule().getValue1().doubleValue());

        Player amber3 = new Player("Amber", "2468", 8.43, 10.46);
        amber3.modifySchedule(4.00, 7.5);
        assertEquals(4.00, amber3.getSchedule().getValue0().doubleValue());
        assertEquals(7.5, amber3.getSchedule().getValue1().doubleValue());

        //zero test
        Player amber4 = new Player("Amber", "2468", 8.0, 10.0);
        amber4.modifySchedule(0, 0);
        assertEquals(0, amber4.getSchedule().getValue0().doubleValue());
        assertEquals(0, amber4.getSchedule().getValue1().doubleValue());

        //no schedule
        //Player amber5 = new Player("Amber", "2468", 0, 0);
        //amber5.modifySchedule(10.0, 20.0);
        //assertThrows(IllegalArgumentException.class, () -> amber5.getSchedule().getValue0().doubleValue());
        //assertThrows(IllegalArgumentException.class, () -> amber5.getSchedule().getValue1().doubleValue());

    }

}