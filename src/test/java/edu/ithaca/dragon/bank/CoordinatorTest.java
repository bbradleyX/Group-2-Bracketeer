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

    @Test
    void createTeamTest() {
        //Create Coordinator
        Coordinator coordinator = new Coordinator("0000");

        //Create Tournament
        coordinator.createTournament("Tournament1", "1234", 9.0);

        //Call createTeam()
        coordinator.createTeam("Tournament1", "Team1");

        //Assert there is 1 team in the Coordinator object's list of Tournament objects
        assertEquals(1, coordinator.getTournaments().get(0).getTeams().size());

        //Assert that two teams with the same name cannot be added to the same tournament
        assertThrows(IllegalArgumentException.class, () -> coordinator.createTeam("Tournament1", "Team1"));
    }

    @Test
    void removeTeamTest() {
        //Create Coordinator
        Coordinator coordinator = new Coordinator("0000");

        //Create Tournament
        coordinator.createTournament("Tournament1", "1234", 9.0);

        //Call createTeam()
        coordinator.getTournaments().get(0).getTeams().add(new Team("Team1"));

        //Assert there is 1 team in the Coordinator object's Tournament object
        assertEquals(1, coordinator.getTournaments().get(0).getTeams().size());

        //Call removeTeam()
        coordinator.removeTeam("Tournament1", "Team1");

        //Assert there are 0 teams in the Coordinator object's Tournament object
        assertEquals(0, coordinator.getTournaments().get(0).getTeams().size());

        //Assert that it is not possible to remove a team from a tournament with 0 teams
        coordinator.removeTeam("Tournament1", "Team1");
        assertEquals(0, coordinator.getTournaments().get(0).getTeams().size());
    }
}