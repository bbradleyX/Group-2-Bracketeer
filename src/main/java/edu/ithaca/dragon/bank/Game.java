package edu.ithaca.dragon.bank;
//import jdk.internal.net.http.common.Pair;
import org.javatuples.Pair;

public class Game {
    private String name;
    private String ID;
    private int playerLimit;
    private Player player1;
    private Player player2;
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
    public Game(String name, String ID, double startTime, int playerLimit,Player player1, Player player2) throws IllegalArgumentException {
        this.name = name;
        this.ID = ID;
        this.startTime = startTime;
        this.player1 = player1;
        this.player2 = player2;
        this.playerLimit = playerLimit;
    }

    public static boolean validateArguments(String name, String ID, double startTime) {
        return true;   
    }

    public String getName() {
        return this.name;
    }

    public String getID() {
        return this.ID;
    }

    public int getPlayerLimit() {
       return this.playerLimit;
    }

    public Player getPlayer1(){
        return this.player1;
    }

    public Player getPlayer2(){
        return this.player2;
    }

    //needs an input for which team has won then returns that team and (moves them through the bracket)
    //Moving through bracket will most likely occur in the tournament class
    public Player hasWon(Player winner) {
       return null; //if() ;
    }
}