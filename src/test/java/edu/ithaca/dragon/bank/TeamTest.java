package edu.ithaca.dragon.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import java.security.InvalidParameterException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.javatuples.Pair;
import org.junit.jupiter.api.Test;


public class TeamTest {
    Team createTeamForTest(String name){
        return new Team (name);
    }
    @Test
    void getTeamNameTest(){
        Team team1 = createTeamForTest("Team 1");
        Team team2 = createTeamForTest("Team2");
        Team team3 = createTeamForTest("Team");
        Team team4 = createTeamForTest("1234");

        //Unit Test for team names
        assertEquals("Team 1", team1.getTeamName());
        assertEquals("Team2", team2.getTeamName());
        assertEquals("Team", team3.getTeamName());
        assertEquals("1234", team4.getTeamName());

        Throwable exception = assertThrows(InvalidParameterException.class, () -> {createTeamForTest("");});
        assertEquals("Invalid Team Name", exception.getMessage());
        exception = assertThrows(InvalidParameterException.class, () -> {createTeamForTest(" ");});
        assertEquals("Invalid Team Name", exception.getMessage());

       
    }
    
    @Test
    void addPlayerTest(){
        Team team = createTeamForTest("Team");
        Player a = new Player("Player 1", "0000", 9.0, 15.0);
        Player b = new Player("Player 2", "0001", 18.0, 23.0);

        team.addPlayer(a);
        team.addPlayer(b);

        //Valid Player Addition
        assertEquals(a, team.getPlayer(a.getID()));
        assertEquals(b, team.getPlayer("0001"));

        //Invalid Player Addition
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {team.getPlayer("0002");});
        assertEquals("Player Not Found", exception.getMessage());

    }


    @Test
    void removePlayerTest(){
        Team team = createTeamForTest("Team");
        Player a = new Player("Player 1", "0000", 9.0, 15.0);
        Player b = new Player("Player 2", "0001", 18.0, 23.0);
        Player c = new Player("Player 3", "0003", 14.0, 14.5);

        team.addPlayer(a);
        team.addPlayer(b);
        team.addPlayer(c);

        //Valid Player Removal
        team.removePlayer(b.getID());
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {team.getPlayer(b.getID());});
        assertEquals("Player Not Found", exception.getMessage());

        team.removePlayer("0003");
        exception = assertThrows(IllegalArgumentException.class, () -> {team.getPlayer("0003");});
        assertEquals("Player Not Found", exception.getMessage());

        //Invalid Player Removal
        exception = assertThrows(IllegalArgumentException.class, () -> {team.removePlayer("0002");});
        assertEquals("Player Not Found", exception.getMessage());

        
    }
   
    //Unit Tests for getters
    @Test
    void getTeamTest(){
        Team team = createTeamForTest("Team");
        Player a = new Player("Player 1", "0000", 9.0, 15.0);
        Player b = new Player("Player 2", "0001", 18.0, 23.0);
        Player c = new Player("Player 3", "0003", 14.0, 14.5);
        Player d = new Player("Player 4", "0004", 10.0, 14.5);
        Player e = new Player("Player 5", "0005", 14.0, 14.5);

        team.addPlayer(a);
        team.addPlayer(b);
        team.addPlayer(c);
        team.addPlayer(d);
        team.addPlayer(e);
  
        // Go through LinkedHashMap Teammap 
        System.out.println("\nElements in Team Map : \n");
        team.getTeam().forEach((k,v) -> System.out.println("Player ID: "+k.getID()+"\tKey = "+ k + ", Value = " + v));
        System.out.println(team.getTeam());

        team.removePlayer(a.getID());
        System.out.println("\nNew Elements in Team Map : removing player ID " +a.getID()+"\n");
        team.getTeam().forEach((k,v) -> System.out.println("Player ID: "+k.getID()+"\tKey = "+ k + ", Value = " + v));
        System.out.println(team.getTeam());

        team.removePlayer(e.getID());
        System.out.println("\nNew Elements in Team Map :removing player ID " +e.getID()+"\n");
        team.getTeam().forEach((k,v) -> System.out.println("Player ID: "+k.getID()+"\tKey = "+ k + ", Value = " + v));
        System.out.println(team.getTeam());

        team.removePlayer(c.getID());
        System.out.println("\nNew Elements in Team Map :removing player ID " +c.getID()+"\n");
        team.getTeam().forEach((k,v) -> System.out.println("Player ID: "+k.getID()+"\tKey = "+ k + ", Value = " + v));
        System.out.println(team.getTeam());
        
    }

    
    //Integral Tests for getting Player Member objects and Team Info
    void getInfoFromTeamsTestPart1(){
        //Invalid Team
        Team team1 = createTeamForTest("Invalid Team");
        //Valid Team
        Team team2 = createTeamForTest("Valid Team");
        
        //Add To Team Tests
        System.out.println("Add Players Tests-----------------------------------------------");
        Throwable exception = assertThrows(Error.class, () -> {team1.getTeamInfo();});
        assertEquals("Team is Empty", exception.getMessage());
        
        team2.addPlayer(new Player("Adam", "0000", 10.0, 11.0));
        assertEquals("\nTeam Info For "+"Valid Team"+ ":\n"+"Player ID: "+ "0000" +", Player Name: " + "Adam"+", Schedule: "+ "[10.0, 11.0]" + "\n", team2.getTeamInfo());
        
        team2.addPlayer(new Player("Amber", "0001", 9.0, 15.0));
        team2.addPlayer(new Player("Bria", "0002", 18.0, 23.0));
        team2.addPlayer(new Player("Eli", "0003", 5.0, 20.0));
        team2.addPlayer(new Player("Nusi","0004", 3.0, 13.3));

        /* assertEquals("\nTeam Info For "+"Valid Team"+ ":\n"+
        "Player ID: "+ "0000" +", Player Name: " + "Adam"+", Schedule: "+ "[10.0, 11.0]" + "\n"+
        "Player ID: "+ "0001" +", Player Name: " + "Amber"+",Schedule: "+ "[9.0, 15.0]" + "\n"+
        "Player ID: "+ "0002" +", Player Name: " + "Bria"+", Schedule: "+ "[18.0, 23.0]" + "\n"+
        "Player ID: "+ "0003" +", Player Name: " + "Eli"+", Schedule: "+ "[5.0, 20.0]" + "\n"+
        "Player ID: "+ "0004" +", Player Name: " + "Nusi"+", Schedule: "+ "[3.0, 13.3]" + "\n", team2.getTeamInfo()); */

        if(("\nTeam Info For "+"Valid Team"+ ":\n"+"Player ID: "+ "0000" +", Player Name: " + "Adam"+", Schedule: "+ "[10.0, 11.0]" + "\n"+
        "Player ID: "+ "0001" +", Player Name: " + "Amber"+",Schedule: "+ "[9.0, 15.0]" + "\n"+
        "Player ID: "+ "0002" +", Player Name: " + "Bria"+", Schedule: "+ "[18.0, 23.0]" + "\n"+
        "Player ID: "+ "0003" +", Player Name: " + "Eli"+", Schedule: "+ "[5.0, 20.0]" + "\n"+
        "Player ID: "+ "0004" +", Player Name: " + "Nusi"+", Schedule: "+ "[3.0, 13.3]" + "\n").equals(team2.getTeamInfo())){
            System.out.println("Getting Team Members for "+team2.getTeamName()+"\n"+team2.getTeamInfo());
        }
        //Invalid Player to Add
        exception = assertThrows(IllegalArgumentException.class, () -> {team2.addPlayer(new Player("Extra","0005", 1.0, 25.3));});
        assertEquals("Cannot add player with invalid credentials.", exception.getMessage());

        exception = assertThrows(InvalidParameterException.class, () -> {team2.addPlayer(new Player("Bria", "0002", 18.0, 23.0));});
        assertEquals("Player is already in team: Valid Team", exception.getMessage());
        //-------------------------------------------------------------------------------------------------------------------------

        //Remove From Team Tests
        System.out.println("\nRemove Players Tests-----------------------------------------------");
        exception = assertThrows(IndexOutOfBoundsException.class, () -> {team1.removePlayer("0000");});
        assertEquals("This team list is empty. There are no players in this team.", exception.getMessage());

        /* assertEquals("\nTeam Info For "+"Valid Team"+ ":\n"+
        "Player ID: "+ "0001" +", Player Name: " + "Amber"+", Schedule: "+ "[9.0, 15.0]" + "\n"+
        "Player ID: "+ "0002" +", Player Name: " + "Bria"+", Schedule: "+ "[18.0, 23.0]" + "\n"+
        "Player ID: "+ "0003" +", Player Name: " + "Eli"+", Schedule: "+ "[5.0, 20.0]" + "\n"+
        "Player ID: "+ "0004" +", Player Name: " + "Nusi"+", Schedule: "+ "[3.0, 13.3]" + "\n", team2.getTeamInfo());
        
 */
        team2.removePlayer("0002");
        if(("\nTeam Info For "+"Valid Team"+ ":\n"+
        "Player ID: "+ "0000" +", Player Name: " + "Adam"+", Schedule: "+ "[10.0, 11.0]" + "\n"+
        "Player ID: "+ "0001" +", Player Name: " + "Amber"+", Schedule: "+ "[9.0, 15.0]" + "\n"+
        "Player ID: "+ "0003" +", Player Name: " + "Eli"+", Schedule: "+ "[5.0, 20.0]" + "\n"+
        "Player ID: "+ "0004" +", Player Name: " + "Nusi"+", Schedule: "+ "[3.0, 13.3]" + "\n").equals(team2.getTeamInfo())){
            System.out.println("Removed ID 0002 from "+team2.getTeamName()+":\n"+team2.getTeamInfo());
        }

        team2.removePlayer("0000");
        team2.removePlayer("0004");

        if(("\nTeam Info For "+"Valid Team"+ ":\n"+
        "Player ID: "+ "0001" +", Player Name: " + "Amber"+", Schedule: "+ "[9.0, 15.0]" + "\n"+
        "Player ID: "+ "0003" +", Player Name: " + "Eli"+", Schedule: "+ "[5.0, 20.0]" + "\n").equals(team2.getTeamInfo())){
                System.out.println("Removed IDs 0000 and 0004 from "+team2.getTeamName()+"\n"+team2.getTeamInfo());
        }

        //Invalid Player to Remove
        exception = assertThrows(IllegalArgumentException.class, () -> {team2.removePlayer("0005");});
        assertEquals("Player Not Found", exception.getMessage());

    }

    @Test
    void getInfoFromTeamsTestPart2(){
        //Invalid Team
        Team team1 = createTeamForTest("Invalid Team");
        //Valid Team
        Team team2 = createTeamForTest("Valid Team");

        //Get Team Player Info Tests

        //Invalid Player from empty team
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {team1.getPlayerInfo("0000");});
        assertEquals("Player Not Found", exception.getMessage());

        System.out.println("Player Info Tests-----------------------------------------------");
        Player a = new Player("Adam", "0000", 10.0, 11.0);
        team2.addPlayer(a);
        assertEquals("Found Player "+"0000"+"->\t" +"Player Name: " + "Adam"+", Player Schedule: "+ "[10.0, 11.0]"+"\n", team2.getPlayerInfo("0000"));

        
        a = new Player("Amber", "0001", 9.0, 15.0);
        Player b = new Player("Bria", "0002", 18.0, 23.0);
        Player e = new Player("Eli", "0003", 5.0, 20.0);
        Player n = new Player("Nusi","0004", 3.0, 13.3);
        
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

        assertEquals("Player: "+ "Adam" +", Schedule: "+ "[10.0, 11.0]"+ "\n"+
                    "Player: "+ "Amber" +", Schedule: "+ "[9.0, 15.0]"+ "\n"+
                    "Player: "+ "Bria" +", Schedule: "+ "[18.0, 23.0]"+ "\n"+
                    "Player: "+ "Eli" +", Schedule: "+ "[5.0, 20.0]"+ "\n"+
                    "Player: "+ "Nusi" +", Schedule: "+ "[3.0, 13.3]"+ "\n", team2.getTeamSchedule());

        System.out.println("Schedule for "+team2.getTeamName()+":\n"+team2.getTeamSchedule());


    }

}
