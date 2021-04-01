package edu.ithaca.dragon.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


public class TeamTest {

    @Test
    void createTeamsTest(){
        //Tests for 
        Team team1 = new Team ("Team 1");
        Team team2 = new Team ("Team2");
        Team team3 = new Team ("");
        Team team4 = new Team (" ");

        //Unit Test for team names
        assertEquals("Team 1", team1.getTeamName());
        assertEquals("Team2", team2.getTeamName());
        assertTrue(team3.getTeamName().contains("Invalid Team Name"));
        assertTrue(team4.getTeamName().contains("Invalid Team Name"));

        //Unit Test for team player lists
        assertEquals([], team1.getTeam());

        //Unit Test for team player schedule

    }

    void addAndRemoveTeamsTest(){}

    void getTeamNameTest(){}

    void getTeamMembersTest(){}

    void getTeamScheduleTest(){}
    
}
