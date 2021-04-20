package edu.ithaca.dragon.bank;

import java.util.HashMap;

import org.javatuples.Pair;


public class Coordinator {
    private String ID;
    private Tournament[] tournaments;
    private boolean timeConflict;
    //I am unsure how to initialize a hashmap. This line may need to be looked at
    private HashMap schedule;

    /**
     * Constructor for the Coordinator class
     * @param ID must be a string of 4 numbers
     * @throws IllegalArgumentException for any arguments that violate the above rules
     */

    public Coordinator(String ID) throws IllegalArgumentException {
        this.ID = ID;
    }

    public static boolean validateArguments(String name, String ID, double startTime) {
        return false;   
    }

    public String getID() {
        return ID;
    }

    //This method creates a tournament and adds it to the list. May need additional parameters for teams participating
    public Void createTournament() {
        return null;
    }

     //This method removes a tournament and adds it to the list. Needs parameter for selecting which tournament to remove
    public Void removeTournament() {
        return null;
    }

      //This method makes a team? might need an additional parameter for teamlist or some connection to team in diagram
      public Void createTeam() {
        return null;
    }

       //this method creates a bracket for a tournament
       public Void createBracket(Tournament tournament) {
        return null;
    }

      //This methods sees if any players have a time conflict
      public boolean isTimeconflict(Pair<Double, Double> playerTime, double tournTime) {
        return false;
    }

}