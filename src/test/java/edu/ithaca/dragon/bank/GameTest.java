package edu.ithaca.dragon.bank;
import org.javatuples.Pair;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class GameTest {

    //@Test

    @Test
    void WinLoseTest() {
        Team team1 = new Team("A");
        team1.addPlayer(new Player("John", "1234", 9.0, 5.5));
        Team team2 = new Team("B");
        team2.addPlayer(new Player("Henry", "2345", 9.0, 5.5));
        Pair<Team,Team> teams = new Pair<>(team1,team2);
        Game game1 = new Game("game1", "1234",5.5 ,team1,team2);
        game1.hasWon(team1);
        assertEquals(team1.getTeamName(),game1.getWinner().getTeamName());
        assertEquals(team2.getTeamName(),game1.getLoser().getTeamName());
    }
}