package edu.ithaca.dragon.bank;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class TournamentTest {


        @Test
        void validateArgumentsTest() {
            Player myPlayer = new Player("Adam", "1234", 9.0, 5.5);
            //valid name tests
            assertTrue(Player.validateArguments("Adam", "1234", 9.0, 5.5));
            assertFalse(Player.validateArguments("", "1234", 9.0, 5.5));
    
            //valid ID tests
            assertTrue(Player.validateArguments("Adam", "1234", 9.0, 5.5));
            assertFalse(Player.validateArguments("Adam", "123", 9.0, 5.5));
    
            //valid start time tests
            assertTrue(Player.validateArguments("Adam", "1234", 9.0, 5.5));
            assertFalse(Player.validateArguments("Adam", "1234", -1, 5.5));
    
            //valid end time tests
            assertTrue(Player.validateArguments("Adam", "1234", 9.0, 5.5));
            assertFalse(Player.validateArguments("Adam", "1234", 9.0, 24.5));
        }
    
        @Test
        void getNameTest() {
            List<Player> players = new ArrayList<>();
            players.add(new Player("A", "1234", 9.0, 5.5));

        }
    
        @Test
        void getIDTest() {
            Player myPlayer = new Player("Adam", "1234", 9.0, 5.5);
            assertEquals(myPlayer.getID(), "1234");
        }
    
        @Test
        void getScheduleTest() {
            Player myPlayer = new Player("Adam", "1234", 9.0, 17.5);
            //assertEquals(myPlayer.getSchedule().getKey(), 9.0);
            //assertEquals(myPlayer.getSchedule().getValue(), 17.5);
        }

        @Test
        void isRoundCompleteTest () {
            Player myPlayer = new Player("Adam", "1234", 9.0, 17.5);
            //assertEquals(myPlayer.getSchedule().getKey(), 9.0);
            //assertEquals(myPlayer.getSchedule().getValue(), 17.5);
        }

        @Test
        void checkTournyFin() {
            Player myPlayer = new Player("Adam", "1234", 9.0, 17.5);
            //assertEquals(myPlayer.getSchedule().getKey(), 9.0);
            //assertEquals(myPlayer.getSchedule().getValue(), 17.5);
        }
        
        void roundRobin(){
        
        }


    }
    //@Test