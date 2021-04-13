package edu.ithaca.dragon.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;


public class TeamTest {
    @Test
    void createTeamsTest(){
        Team team1 = new Team ("Team 1");
        Team team2 = new Team ("Team2");
        Team team3 = new Team ("");
        Team team4 = new Team (" ");

        //Unit Test for team names
        assertEquals("Team 1", team1.getTeamName());
        assertEquals("Team2", team2.getTeamName());
        assertEquals("Invalid Team Name", team3.getTeamName());
        assertEquals("Invalid Team Name", team4.getTeamName());
        
        //Unit Test for team player list
        assertEquals([], team1.getTeam());
        assertEquals("Team2", team2.getTeam());
        assertEquals("Invalid Team Name", team3.getTeamName());
        assertEquals("Invalid Team Name", team4.getTeamName());

        //Unit Test for team player schedule
        assertEquals("Team 1", team1.getTeamName());
        assertEquals("Team2", team2.getTeamName());
        assertEquals("Invalid Team Name", team3.getTeamName());
        assertEquals("Invalid Team Name", team4.getTeamName());
    }

    void addAndRemoveTeamsTest(){}

    void getTeamNameTest(){}

    void getTeamMembersTest(){}

    void getTeamScheduleTest(){}
    
}
