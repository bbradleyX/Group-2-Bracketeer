package edu.ithaca.dragon.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;


public class TeamTest {

    @Test
    void createTeamsTest(){
        
    }

    void viewSchedule(){
        List<Player> teamPlayers = new ArrayList<>();
        teamPlayers.add(new Player("Amber", "2468", 8.0, 10.0));
        teamPlayers.add(new Player("Ashley", "9324", 5.40, 9.23));
        teamPlayers.add(new Player("Sanora", "6291", 10.00, 12.30));
        
       // teamPlayers.viewSchedule( teamPlayers.getValue0().doubleValue());
     
    }
    
}
