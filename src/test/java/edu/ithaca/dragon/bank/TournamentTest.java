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
            List<Player> players = new ArrayList<>();
            players.add(new Player("1", "1234", 9.0, 17.5));
            players.add(new Player("2", "1235", 9.0, 17.5));
            players.add(new Player("3", "1236", 9.0, 17.5));
            players.add(new Player("4", "1237", 9.0, 17.5));
            players.add(new Player("5", "1238", 9.0, 17.5));
            Tournament tournament = new Tournament("tourny1", "1234", 9.0, players);
            assertEquals("tourny1", tournament.getName());
            assertEquals("1234", tournament.getID());
            assertEquals(5, tournament.getPlayers().size());
        }
    
        @Test
        void isRoundCompleteTest () {
            List<Player> players = new ArrayList<>();
            players.add(new Player("1", "1234", 9.0, 17.5));
            players.add(new Player("2", "1235", 9.0, 17.5));
            players.add(new Player("3", "1236", 9.0, 17.5));
            players.add(new Player("4", "1237", 9.0, 17.5));
            players.add(new Player("5", "1238", 9.0, 17.5));
            Tournament tournament = new Tournament("tourny1", "1234", 9.0, players);
            assertTrue(tournament.isRoundComplete());
            tournament.createRound();
            assertFalse(tournament.isRoundComplete());
            
        }

        @Test
        void checkTournyFinTest() {
            List<Player> players3 = new ArrayList<>();
            Tournament tournament3 = new Tournament("tourny1", "1234", 9.0, players3);
            assertTrue(tournament3.checkTournyFin());
            players3.add(new Player("1", "1234", 9.0, 17.5));
            players3.add(new Player("2", "1235", 9.0, 17.5));
            assertFalse(tournament3.checkTournyFin());
        }

        @Test
        void createRoundTest() {
            List<Player> players = new ArrayList<>();
            players.add(new Player("1", "1234", 9.0, 17.5));
            players.add(new Player("2", "1235", 9.0, 17.5));
            players.add(new Player("3", "1236", 9.0, 17.5));
            players.add(new Player("4", "1237", 9.0, 17.5));
            players.add(new Player("5", "1238", 9.0, 17.5));
            Tournament tournament = new Tournament("tourny1", "1234", 9.0, players);
            tournament.createRound();
            assertEquals(1,tournament.getPlayers().size());
            assertEquals(4,tournament.getInGame().size());
            assertEquals(2,tournament.getGames().size());

            List<Player> players2 = new ArrayList<>();
            players2.add(new Player("1", "1234", 9.0, 17.5));
            Tournament tournament2 = new Tournament("tourny1", "1234", 9.0, players2);
            tournament2.createRound();
            assertEquals(1,tournament2.getPlayers().size());
            assertEquals(0,tournament2.getInGame().size());
            assertEquals(0,tournament2.getGames().size());

            List<Player> players3 = new ArrayList<>();
            Tournament tournament3 = new Tournament("tourny1", "1234", 9.0, players3);
            tournament3.createRound();
            assertEquals(0,tournament3.getPlayers().size());
            assertEquals(0,tournament3.getInGame().size());
            assertEquals(0,tournament3.getGames().size());
        }

        @Test
        void updateRoundTest() {
            List<Player> players = new ArrayList<>();
            players.add(new Player("1", "1234", 9.0, 17.5));
            players.add(new Player("2", "1235", 9.0, 17.5));
            players.add(new Player("3", "1236", 9.0, 17.5));
            players.add(new Player("4", "1237", 9.0, 17.5));
            players.add(new Player("5", "1238", 9.0, 17.5));
            Tournament tournament = new Tournament("tourny1", "1234", 9.0, players);
            //creates round 1 - 2 games of 2 and 1 bye
            tournament.createRound();
            // completes both games
            tournament.getGames().get(0).hasWon(tournament.getGames().get(0).getPlayer1());
            tournament.getGames().get(1).hasWon(tournament.getGames().get(1).getPlayer1());
            // updated - 0 games 2 elim 3 players
            assertEquals(2,tournament.getGames().size());
            tournament.updateRound();
            assertEquals(0,tournament.getGames().size());
            assertEquals(2,tournament.getElim().size());
            assertEquals(3,tournament.getPlayers().size());
            // creates round 2 - 1 game of 2 1 bye
            tournament.createRound();
            //completes game
            tournament.getGames().get(0).hasWon(tournament.getGames().get(0).getPlayer1());
            //updated - 0 games 3 elim 2 players
            tournament.updateRound();
            assertEquals(0,tournament.getGames().size());
            assertEquals(3,tournament.getElim().size());
            assertEquals(2,tournament.getPlayers().size());
            //creates round 3 - 1 game of 2
            tournament.createRound();
            assertEquals(0,tournament.getPlayers().size());
            assertEquals(1,tournament.getGames().size());
            //completes game
            tournament.getGames().get(0).hasWon(tournament.getGames().get(0).getPlayer1());
            //updated 0 games 4 elim 1 player(winner)
            tournament.updateRound();
            assertTrue(tournament.checkTournyFin());
            assertEquals(1,tournament.getPlayers().size());
            assertEquals(4,tournament.getElim().size());

        }
    }
    //@Test