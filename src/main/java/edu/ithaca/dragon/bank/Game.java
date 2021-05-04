package edu.ithaca.dragon.bank;

import org.javatuples.Pair;

public class Game {
    private String name;
    private String ID;
    private int playerLimit;
    private Pair<Team,Team> players;
    private double startTime;
    private Team winner;
    private Team loser;
    private Team team1;
    private Team team2;

    /**
     * Constructor for the Player class
     * @param name must be a name consisting of at least 1 character, number, or symbol
     * @param ID must be a string of 4 numbers
     * @param startTime must be a double greater than 0 and less than 24, using increments of 0.25 for 15 minute blocks of time
     * @param endTime must be a double greater than 0 and less than 24, using increments of 0.25 for 15 minute blocks of time
     * @throws IllegalArgumentException for any arguments that violate the above rules
     */

    //Constructor - This method will need additional parameter for filling in players. and player limit
    public Game(String name, String ID, double startTime, Team team1, Team team2) throws IllegalArgumentException {
        this.name = name;
        this.ID = ID;
        this.startTime = startTime;
        this.team1 = team1;
        this.team2 = team2;
        this.winner = null;
        this.loser = null;
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

    public Double getPlayerLimit() {
        return 0.0;//return this.playerLimit;
    }

    public Team getWinner(){
        return this.winner;
    }

    public Team getLoser(){
        return this.loser;
    }

    public Team getTeam1(){
        return this.team1;
    }

    public Team getTeam2(){
        return this.team2;
    }

    //needs an input for which team has won then returns that team and (moves them through the bracket)
    //Moving through bracket will most likely occur in the tournament class
    public Void hasWon(Team win) {
       if(team1.getTeamName().equals(win.getTeamName())){
           this.winner = team1;
           this.loser = team2;
       }
       if(team2.getTeamName().equals(win.getTeamName())){
        this.winner = team2;
        this.loser = team1;
        }
       return null;
    }
}