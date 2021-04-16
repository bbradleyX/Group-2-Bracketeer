package edu.ithaca.dragon.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.text.BreakIterator;

import org.junit.jupiter.api.Test;


public class TeamTest {
    Team createTeamForTest(String name){
        return new Team (name);
    }
    @Test
    void getTeamNameTest(){
        Team team1 = createTeamForTest("Team 1");
        Team team2 = createTeamForTest("Team2");
        Team team3 = createTeamForTest("");
        Team team4 = createTeamForTest(" ");

        //Unit Test for team names
        assertEquals("Team 1", team1.getTeamName());
        assertEquals("Team2", team2.getTeamName());
        assertEquals("Invalid Team Name", team3.getTeamName());
        assertEquals("Invalid Team Name", team4.getTeamName());
    }
    @Test
    //Integral Test for getting Player Member objects
    void getTeamMembersTest(){
        //Invalid Team
        Team team1 = createTeamForTest("Invalid Team Test");
        //Valid Team
        Team team2 = createTeamForTest("Valid Team Test");
        
        //Add To Team Tests
        assertFalse(team1.getTeamInfo());
        
        team2.addPlayer(new Player("Adam", "0000", 10.0, 11.0));
        System.out.println(team2.getTeamName());
        assertEquals("Player ID: "+ "0000" +"Player Name: " +"Adam"+"Player Schedule: "+ "10,0, 11.0" + "\n", team1.getTeamInfo());
        assertTrue(team1.getTeamInfo());

        team2.addPlayer(new Player("Amber", "0001", 9.0, 15.0));
        team2.addPlayer(new Player("Bria", "0002", 18.0, 23.0));
        team2.addPlayer(new Player("Eli", "0003", 5.0, 20.0));
        team2.addPlayer(new Player("Nusi","0004", 13.0, 3.3));

        assertEquals("Player ID: "+ "0001" +"Player Name: " +"Amber"+"Player Schedule: "+ "9,0, 15.0"+"\n" +
        "Player ID: "+ "0002" +"Player Name: " +"Bria"+"Player Schedule: "+ "18.0,0, 23.0"+"\n"+
        "Player ID: "+ "0003" +"Player Name: " +"Eli"+"Player Schedule: "+ "5.00, 20.0"+"\n"+
        "Player ID: "+ "0004" +"Player Name: " +"Nusi"+"Player Schedule: "+ "13.0, 3.0"+"\n", team1.getTeamInfo());

        
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {team2.addPlayer(new Player("Extra","0005", 1.0, 25.3));});
        assertEquals("Cannot add player with invalid credentials.", exception.getMessage());
        
        //Remove From Team Tests
        exception = assertThrows(IndexOutOfBoundsException.class, () -> {team1.removePlayer("0000");});
        assertEquals("This team list is empty. There are no players in this team.", exception.getMessage());

    }

    @Test
    void getInfoFromTeamsTest(){}

}
