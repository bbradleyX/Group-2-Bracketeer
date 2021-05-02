package edu.ithaca.dragon.bank;
import java.util.ArrayList;

//import jdk.internal.net.http.common.Pair;


public class Tournament {
    private String name;
    private String ID;
    private ArrayList<Team> teams;
    private double startTime;
    private Game gameType;

    /**
     * Constructor for the Player class
     * @param name must be a name consisting of at least 1 character, number, or symbol
     * @param ID must be a string of 4 numbers
     * @param gameType an object of Game that holds information on the specific game being played
     * @param startTime must be a double greater than 0 and less than 24, using increments of 0.25 for 15 minute blocks of time
     * @param teams is a list of teams in the teams participating in the event
     * @throws IllegalArgumentException for any arguments that violate the above rules
     */

    //Constructor
    public Tournament(String name, String ID, Game gameType, double startTime, ArrayList<Team> teams) throws IllegalArgumentException {
        this.name = name;
        this.ID = ID;
        this.gameType = gameType;
        this.teams = teams;
        this.startTime = startTime;
    }

    public static boolean validateArguments(String name, String ID, double startTime) {
        if (name.length() < 1) {
            System.out.println("Name must consist of at least 1 character.");
            return false;
        }
        if (ID.length() != 4) {
            System.out.println("ID must be a string of 4 numbers.");
            return false;
        }
        for (int i = 0; i < ID.length(); i++) {
            if ((ID.charAt(i) < 48) || (ID.charAt(i) > 57)) {
                System.out.println("ID must be a string of 4 numbers.");
                return false;
            }
        }
        if ((startTime < 0.0) || (startTime > 24.0)) {
            System.out.println("Start time must be a value between 0.0 and 24.0.");
            return false;
        }
        else{
            return true;
        }   
    }

    public String getName() {
        return this.name;
    }

    public String getID() {
        return this.ID;
    }

    public ArrayList<Team> getTeams(){
        return this.teams;
    }

    public double getStartTime(){
        return this.startTime;
    }

    public Game getGameType(){
        return this.gameType;
    }

    //This will need more methods but non are on the diagram as of right now.
}