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
        void constructorTest() {
            ArrayList<Team> teams = new ArrayList<Team>();
            teams.add(new Team("A"));
            teams.add(new Team("B"));
            teams.add(new Team("C"));
            teams.add(new Team("D"));
            teams.add(new Team("E"));
            
            Tournament tournament = new Tournament("tourny1", "1234", 9.0, teams);
            assertEquals("tourny1", tournament.getName());
            assertEquals("1234", tournament.getID());
            assertEquals(5, tournament.getTeams().size());
        }
    
        @Test
        void isRoundCompleteTest () {
            List<Team> teams = new ArrayList<>();
            teams.add(new Team("A"));
            teams.add(new Team("B"));
            teams.add(new Team("C"));
            teams.add(new Team("D"));
            teams.add(new Team("E"));
            Tournament tournament = new Tournament("tourny1", "1234", 9.0, teams);
            assertTrue(tournament.isRoundComplete());
            tournament.createRound();
            assertFalse(tournament.isRoundComplete());
            
        }

        @Test
        void checkTournyFinTest() {
            List<Team> teams3 = new ArrayList<>();
            Tournament tournament3 = new Tournament("tourny1", "1234", 9.0, teams3);
            assertTrue(tournament3.checkTournyFin());
            teams3.add(new Team("A"));
            teams3.add(new Team("B"));
            assertFalse(tournament3.checkTournyFin());
        }

        @Test
        void createRoundTest() {
            List<Team> teams = new ArrayList<>();
            teams.add(new Team("A"));
            teams.add(new Team("B"));
            teams.add(new Team("C"));
            teams.add(new Team("D"));
            teams.add(new Team("E"));
            Tournament tournament = new Tournament("tourny1", "1234", 9.0, teams);
            tournament.createRound();
            assertEquals(1,tournament.getTeams().size());
            assertEquals(4,tournament.getInGame().size());
            assertEquals(2,tournament.getGames().size());

            List<Team> teams2 = new ArrayList<>();
            teams2.add(new Team("F"));
            Tournament tournament2 = new Tournament("tourny1", "1234", 9.0, teams2);
            tournament2.createRound();
            assertEquals(1,tournament2.getTeams().size());
            assertEquals(0,tournament2.getInGame().size());
            assertEquals(0,tournament2.getGames().size());

            List<Team> teams3 = new ArrayList<>();
            Tournament tournament3 = new Tournament("tourny1", "1234", 9.0, teams3);
            tournament3.createRound();
            assertEquals(0,tournament3.getTeams().size());
            assertEquals(0,tournament3.getInGame().size());
            assertEquals(0,tournament3.getGames().size());
        }

        @Test
        void updateRoundTest() {
            List<Team> teams = new ArrayList<>();
            teams.add(new Team("A"));
            teams.add(new Team("B"));
            teams.add(new Team("C"));
            teams.add(new Team("D"));
            teams.add(new Team("E"));
            Tournament tournament = new Tournament("tourny1", "1234", 9.0, teams);
            //creates round 1 - 2 games of 2 and 1 bye
            tournament.createRound();
            // completes both games
            tournament.getGames().get(0).hasWon(tournament.getGames().get(0).getTeam1());
            tournament.getGames().get(1).hasWon(tournament.getGames().get(1).getTeam1());
            // updated - 0 games 2 elim 3 teams
            assertEquals(2,tournament.getGames().size());
            tournament.updateRound();
            assertEquals(0,tournament.getGames().size());
            assertEquals(2,tournament.getElim().size());
            assertEquals(3,tournament.getTeams().size());
            // creates round 2 - 1 game of 2 1 bye
            tournament.createRound();
            //completes game
            tournament.getGames().get(0).hasWon(tournament.getGames().get(0).getTeam1());
            //updated - 0 games 3 elim 2 teams
            tournament.updateRound();
            assertEquals(0,tournament.getGames().size());
            assertEquals(3,tournament.getElim().size());
            assertEquals(2,tournament.getTeams().size());
            //creates round 3 - 1 game of 2
            tournament.createRound();
            assertEquals(0,tournament.getTeams().size());
            assertEquals(1,tournament.getGames().size());
            //completes game
            tournament.getGames().get(0).hasWon(tournament.getGames().get(0).getTeam1());
            //updated 0 games 4 elim 1 player(winner)
            tournament.updateRound();
            assertTrue(tournament.checkTournyFin());
            assertEquals(1,tournament.getTeams().size());
            assertEquals(4,tournament.getElim().size());

        }


    }