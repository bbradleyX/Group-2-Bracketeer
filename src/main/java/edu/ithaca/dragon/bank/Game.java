package edu.ithaca.dragon.bank;
<<<<<<< HEAD

=======
//import jdk.internal.net.http.common.Pair;
import org.javatuples.Pair;
>>>>>>> origin/CreateBracket

public class Game {
    private String name;
    private String ID;
    private int playerLimit;
    private Pair<Player,Player> players;
    private double startTime;

    /**
     * Constructor for the Player class
     * @param name must be a name consisting of at least 1 character, number, or symbol
     * @param ID must be a string of 4 numbers
     * @param startTime must be a double greater than 0 and less than 24, using increments of 0.25 for 15 minute blocks of time
     * @param endTime must be a double greater than 0 and less than 24, using increments of 0.25 for 15 minute blocks of time
     * @throws IllegalArgumentException for any arguments that violate the above rules
     */

    //Constructor - This method will need additional parameter for filling in players. and player limit
    public Game(String name, String ID, double startTime,Pair<Player,Player> players) throws IllegalArgumentException {
        this.name = name;
        this.ID = ID;
        this.startTime = startTime;
        this.players = players;
    }

    public static boolean validateArguments(String name, String ID, double startTime) {
<<<<<<< HEAD
        return false;   
    }

    public String getName() {
        return " ";
    }

    public String getID() {
        return " ";
    }

    public Double getPlayerLimit() {
        return 0.0;
=======
        return true;   
    }

    public String getName() {
        return this.name;
    }

    public String getID() {
        return this.ID;
    }

    public Double getPlayerLimit() {
        return 0.0;//return this.playerLimit;
>>>>>>> origin/CreateBracket
    }

    //needs an input for which team has won then returns that team and (moves them through the bracket)
    //Moving through bracket will most likely occur in the tournament class
<<<<<<< HEAD
    public Player hasWon() {
        return null;
=======
    public Player hasWon(Player winner) {
       return null; //if() ;
>>>>>>> origin/CreateBracket
    }
}