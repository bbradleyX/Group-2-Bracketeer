import java.util.HashMap;

import jdk.internal.net.http.common.Pair;

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

    public Constructor(String ID) throws IllegalArgumentException {
        ;
    }

    public static boolean validateArguments(String name, String ID, double startTime) {
        ;   
    }

    public String getID() {
        ;
    }

    //This method creates a tournament and adds it to the list. May need additional parameters for teams participating
    public Void createTournament() {
        ;
    }

     //This method removes a tournament and adds it to the list. Needs parameter for selecting which tournament to remove
    public Void removeTournament() {
        ;
    }

      //This method makes a team? might need an additional parameter for teamlist or some connection to team in diagram
      public Void createTeam() {
        ;
    }

       //this method creates a bracket for a tournament
       public Void createBracket(Tournament tournament) {
        ;
    }

      //This methods sees if any players have a time conflict
      public boolean isTimeconflict() {
        ;
    }
}