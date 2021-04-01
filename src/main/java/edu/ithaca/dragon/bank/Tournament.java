package edu.ithaca.dragon.bank;

import org.javatuples.Pair;

public class Tournament {
    private String name;
    private String ID;
    private Team[] teams;
    private Player[] players;
    private double startTime;

    /**
     * Constructor for the Player class
     * @param name must be a name consisting of at least 1 character, number, or symbol
     * @param ID must be a string of 4 numbers
     * @param startTime must be a double greater than 0 and less than 24, using increments of 0.25 for 15 minute blocks of time
     * @param players is a list of players in the teams participating in the event
     * @throws IllegalArgumentException for any arguments that violate the above rules
     */

    //Constructor - This function will most likely need additional params and functionality for adding in teams and players.
    public Tournament(String name, String ID, double startTime) throws IllegalArgumentException {
        ;
    }

    public static boolean validateArguments(String name, String ID, double startTime) {
        return false;   
    }

    public String getName() {
        return " ";
    }

    public String getID() {
        return " ";
    }

    public Team[] getTeams() {
        return null;
    }

    public Player[] getPlayers(){
        return null;

    }

    //This will need more methods but non are on the diagram as of right now.
}