package edu.ithaca.dragon.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import java.security.InvalidParameterException;
import org.junit.jupiter.api.Test;


public class TeamTest {
    Team createTeamForTest(String name){
        return new Team (name);
    }
    @Test
    void getTeamNameTest(){
        Team team1 = createTeamForTest("Team 1");
        Team team2 = createTeamForTest("Team2");

        //Unit Test for team names
        assertEquals("Team 1", team1.getTeamName());
        assertEquals("Team2", team2.getTeamName());

        Throwable exception = assertThrows(InvalidParameterException.class, () -> {createTeamForTest("");});
        assertEquals("Invalid Team Name", exception.getMessage());
        exception = assertThrows(InvalidParameterException.class, () -> {createTeamForTest(" ");});
        assertEquals("Invalid Team Name", exception.getMessage());

       
    }
    @Test
    //Integral Tests for getting Player Member objects and Team Info
    void getTeamTest(){
        //Invalid Team
        Team team1 = createTeamForTest("Invalid Team");
        //Valid Team
        Team team2 = createTeamForTest("Valid Team");
        
        //Add To Team Tests
        System.out.println("Add Players Tests-----------------------------------------------");
        Throwable exception = assertThrows(Error.class, () -> {team1.getTeamInfo();});
        assertEquals("Team is Empty", exception.getMessage());
        
        team2.addPlayer(new Player("Adam", "0000", 10.0, 11.0));
        assertEquals("\nTeam Info For "+"Valid Team"+ ":\n"+"Player ID: "+ "0000" +", Player Name: " + "Adam"+", PlayTime: "+ "[0.0, 0.0]" + "\n", team2.getTeamInfo());
        
        team2.addPlayer(new Player("Amber", "0001", 9.0, 15.0));
        team2.addPlayer(new Player("Bria", "0002", 18.0, 23.0));
        team2.addPlayer(new Player("Eli", "0003", 5.0, 20.0));
        team2.addPlayer(new Player("Nusi","0004", 13.0, 3.3));

        /* assertEquals("\nTeam Info For "+"Valid Team"+ ":\n"+
        "Player ID: "+ "0000" +", Player Name: " + "Adam"+", Player Time: "+ "[0.0, 0.0]" + "\n"+
        "Player ID: "+ "0001" +", Player Name: " + "Amber"+",Player Time: "+ "[0.0, 0.0]" + "\n"+
        "Player ID: "+ "0002" +", Player Name: " + "Bria"+", Player Time: "+ "[0.0, 0.0]" + "\n"+
        "Player ID: "+ "0003" +", Player Name: " + "Eli"+", Player Time: "+ "[0.0, 0.0]" + "\n"+
        "Player ID: "+ "0004" +", Player Name: " + "Nusi"+", Player Time: "+ "[0.0, 0.0]" + "\n", team2.getTeamInfo()); */

        if(("\nTeam Info For "+"Valid Team"+ ":\n"+"Player ID: "+ "0000" +", Player Name: " + "Adam"+", PlayTime: "+ "[10.0, 10.30]" + "\n"+
                "Player ID: "+ "0001" +", Player Name: " + "Amber"+", PlayTime: "+ "[0.0, 0.0]" + "\n"+
                "Player ID: "+ "0002" +", Player Name: " + "Bria"+",PlayTime: "+ "[0.0, 0.0]" + "\n"+
                "Player ID: "+ "0003" +", Player Name: " + "Eli"+", PlayTime: "+ "[0.0, 0.0]" + "\n"+
                "Player ID: "+ "0004" +", Player Name: " + "Nusi"+", PlayTime: "+ "[0.0, 0.0]" + "\n").equals(team2.getTeamInfo())){
            System.out.println("Getting Team Members for "+team2.getTeamName()+"\n"+team2.getTeamInfo());
        }
        //Invalid Player to Add
        exception = assertThrows(IllegalArgumentException.class, () -> {team2.addPlayer(new Player("Extra","0005", 1.0, 25.3));});
        assertEquals("Cannot add player with invalid credentials.", exception.getMessage());

        exception = assertThrows(InvalidParameterException.class, () -> {team2.addPlayer(new Player("Bria", "0002", 18.0, 23.0));});
        assertEquals("Player is already in team: Valid Team", exception.getMessage());
        //-------------------------------------------------------------------------------------------------------------------------

        //Remove From Team Tests
        System.out.println("Remove Players Tests-----------------------------------------------");
        exception = assertThrows(IndexOutOfBoundsException.class, () -> {team1.removePlayer("0000");});
        assertEquals("This team list is empty. There are no players in this team.", exception.getMessage());

        /* assertEquals("\nTeam Info For "+"Valid Team"+ ":\n"+
        "Player ID: "+ "0000" +", Player Name: " + "Adam"+", PlayTime: "+ "[0.0, 0.0]" + "\n"+
        "Player ID: "+ "0001" +", Player Name: " + "Amber"+", PlayTime: "+ "[0.0, 0.0]" + "\n"+
        "Player ID: "+ "0003" +", Player Name: " + "Eli"+", PlayTime: "+ "[0.0, 0.0]" + "\n"+
        "Player ID: "+ "0004" +", Player Name: " + "Nusi"+", PlayTime: "+ "[0.0, 0.0]" + "\n", team2.getTeamInfo());
        
 */
        team2.removePlayer("0002");
        if(("\nTeam Info For "+"Valid Team"+ ":\n"+
        "Player ID: "+ "0000" +", Player Name: " + "Adam"+", PlayTime: "+ "[0.0, 0.0]" + "\n"+
        "Player ID: "+ "0001" +", Player Name: " + "Amber"+", PlayTime: "+ "[0.0, 0.0]" + "\n"+
        "Player ID: "+ "0003" +", Player Name: " + "Eli"+", PlayTime: "+ "[0.0, 0.0]" + "\n"+
        "Player ID: "+ "0004" +", Player Name: " + "Nusi"+", PlayTime: "+ "[0.0, 0.0]" + "\n").equals(team2.getTeamInfo())){
            System.out.println("Removed ID 0002 from "+team2.getTeamName()+":\n"+team2.getTeamInfo());
        }

        team2.removePlayer("0000");
        team2.removePlayer("0004");

        if(("\nTeam Info For "+"Valid Team"+ ":\n"+"Player ID: "+ "0001" +", Player Name: " + "Amber"+", PlayTime: "+ "[0.0, 0.0]" + "\n"+
            "Player ID: "+ "0003" +", Player Name: " + "Eli"+", PlayTime: "+ "[0.0, 0.0]" + "\n").equals(team2.getTeamInfo())){
                System.out.println("Removed IDs 0000 and 0004 from "+team2.getTeamName()+":\n"+team2.getTeamInfo());
        }

        //Invalid Player to Remove
        exception = assertThrows(IllegalArgumentException.class, () -> {team2.removePlayer("0005");});
        assertEquals("Player Not Found", exception.getMessage());

    }

    @Test
    void getInfoFromTeamsTest(){
        //Invalid Team
        Team team1 = createTeamForTest("Invalid Team");
        //Valid Team
        Team team2 = createTeamForTest("Valid Team");

        //Get Team Player Info Tests
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {team1.getPlayerInfo("0000");});
        assertEquals("Player Not Found", exception.getMessage());

        System.out.println("Player Info Tests-----------------------------------------------");
        Player a = new Player("Adam", "0000", 10.0, 11.0);
        a.modifyPlayTime(10.0, 10.30);
        team2.addPlayer(a);
        assertEquals("Found Player "+"0000"+"->\t" +"Player Name: " + "Adam"+", PlayTime: "+ "[10.0, 10.3]"+", Player Schedule: "+ "[10.0, 11.0]"+"\n", team2.getPlayerInfo("0000"));

        
        a = new Player("Amber", "0001", 9.0, 15.0);
        a.modifyPlayTime(11.0, 12.30);
        Player b = new Player("Bria", "0002", 18.0, 23.0);
        Player e = new Player("Eli", "0003", 5.0, 20.0);
        e.modifyPlayTime(19.0, 20.0);
        Player n = new Player("Nusi","0004", 13.0, 3.3);
        n.modifyPlayTime(20.0, 1.3);
        
        team2.addPlayer(a);
        team2.addPlayer(b);
        team2.addPlayer(e);
        team2.addPlayer(n);

        System.out.println("\nFinding Player with ID: 0001\n"+team2.getPlayerInfo("0001"));
        System.out.println("Finding Player with ID: 0002\n"+team2.getPlayerInfo("0002"));
        System.out.println("Finding Player with ID: 0003\n"+team2.getPlayerInfo("0003"));
        System.out.println("Finding Player with ID: 0004\n"+team2.getPlayerInfo("0004"));

        //Invalid Player to Find
        exception = assertThrows(IllegalArgumentException.class, () -> {team2.getPlayerInfo("0005");});
        assertEquals("Player Not Found", exception.getMessage());
        //-------------------------------------------------------------------------------------------------------------------------

        //Get Schedule Info Tests
        System.out.println("Schedule Info Tests-----------------------------------------------");
        exception = assertThrows(IndexOutOfBoundsException.class, () -> {team1.getTeamSchedule();});
        assertEquals("This team list is empty. There are no players in this team.", exception.getMessage());

        assertEquals("Player: "+ "Adam" +", PlayTime: "+ "[10.0, 10.3]"+ "\n"+
                    "Player: "+ "Amber" +", PlayTime: "+ "[11.0, 12.3]"+ "\n"+
                    "Player: "+ "Bria" +", PlayTime: "+ "[0.0, 0.0]"+ "\n"+
                    "Player: "+ "Eli" +", PlayTime: "+ "[19.0, 20.0]"+ "\n"+
                    "Player: "+ "Nusi" +", PlayTime: "+ "[20.0, 1.3]"+ "\n", team2.getTeamSchedule());

        System.out.println("PlayTime Schedule for "+team2.getTeamName()+":\n"+team2.getTeamSchedule());


    }

}
