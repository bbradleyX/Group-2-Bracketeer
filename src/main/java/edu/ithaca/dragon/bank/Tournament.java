package edu.ithaca.dragon.bank;
//import jdk.internal.net.http.common.Pair;
import org.javatuples.Pair;

public class Tournament {
    private String name;
    private String ID;
    //private Team[] teams;
    private Player[] players;
    private Player[] inGame;
    private Player[] elim;
    private double startTime;

    /**
     * Constructor for the Player class
     * @param name must be a name consisting of at least 1 character, number, or symbol
     * @param ID must be a string of 4 numbers
     * @param startTime must be a double greater than 0 and less than 24, using increments of 0.25 for 15 minute blocks of time
     * @param players is a list of players in the teams participating in the event
     * @throws IllegalArgumentException for any arguments that violate the above rules
     */

    //Constructor - Incomplete as of now using players to fill in for teams until we have that functionality
    public Tournament(String name, String ID, double startTime,Player[] players) throws IllegalArgumentException {
        this.name = name;
        this.ID = ID;
        this.startTime = startTime;
        this.players = players;
        ;
    }

    public static boolean validateArguments(String name, String ID, double startTime) {
        return false;   
    }

    public String getName() {
        return this.name;
    }

    public String getID() {
        return this.ID;
    }

    /* public Team[] getTeams() {
        return this.teams;
    } */

    public Player[] getPlayers(){
        return this.players;
    }

    public boolean isRoundComplete(){
        return false;
    }

    public boolean checkTournyFin(){
        return false;
    }

    public void createRound(){
       ;
    }

    public Player[] getInGame(){
        return this.inGame;
    }

    public Player[] getElim(){
        return this.elim;
    }
    //This will need more methods but non are on the diagram as of right now.

     //This create a function that takes all of the teams and creates a game for every pair of teams
     public static void roundRobin() {
        
    }
}