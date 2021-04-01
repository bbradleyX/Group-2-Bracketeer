package edu.ithaca.dragon.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
    void modifySchedulesTest(){
        
    }

    @Test 
    void viewSchedulesTest(){
        
    }
}