package edu.ithaca.dragon.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.BreakIterator;

import org.junit.jupiter.api.Test;


public class TeamTest {
    Team createTeamsTest(String name){
        return new Team (name);
    }
    @Test
    void getTeamNameTest(){
        Team team1 = createTeamsTest("Team 1");
        Team team2 = createTeamsTest("Team2");
        Team team3 = createTeamsTest("");
        Team team4 = createTeamsTest(" ");

        //Unit Test for team names
        assertEquals("Team 1", team1.getTeamName());
        assertEquals("Team2", team2.getTeamName());
        assertEquals("Invalid Team Name", team3.getTeamName());
        assertEquals("Invalid Team Name", team4.getTeamName());
    }
    @Test
    //Integral Test for getting Player members (objects)
    void getTeamMembersTest(){
        Team team1 = createTeamsTest("Team Test");

        team1.addPlayer(new Player("Adam", "0000", 10.0, 11.0));
        assertEquals("Player 1: Adam, 0000, 10.0, 11.0", team1.getTeam());


        team1.addPlayer(new Player("Amber", "0001", 9.0, 15.0));
        team1.addPlayer(new Player("Bria", "0002", 18.0, 23.0));
        team1.addPlayer(new Player("Eli", "0003", 5.0, 20.0));
        team1.addPlayer(new Player("Nusi","0004", 13.0, 3.3));

        assertEquals("Player 1: Adam, 0000, 10.0, 11.0; Player 2: Amber, 0001, 9.0, 15.0; Player 3: Bria, 0002, 18.0, 23.0; Player 4: Eli, 0003, 5.0, 20.0; Player 5: Nusi,0004, 13.0, 3.3; Player 6: Extra,0005, 1.0, 1.3", team1.getTeam());
 + 
        team1.addPlayer(new Player("Extra","0005", 1.0, 1.3));
        assertEquals("Player 1: Adam, 0000, 10.0, 11.0; Player 2: Amber, 0001, 9.0, 15.0; Player 3: Bria, 0002, 18.0, 23.0; Player 4: Eli, 0003, 5.0, 20.0; Player 5: Nusi,0004, 13.0, 3.3; Player 6: Extra,0005, 1.0, 1.3", team1.getTeam());

        team1.removePlayer(team1.get);
    }

    @Test
    void getTeamScheduleTest(){}

}
