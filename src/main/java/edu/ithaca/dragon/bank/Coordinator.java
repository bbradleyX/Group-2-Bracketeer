package edu.ithaca.dragon.bank;

import java.util.ArrayList;
import java.util.HashMap;

import org.javatuples.Pair;

public class Coordinator {
    private String ID;
    private ArrayList<Tournament> tournaments;
    private boolean timeConflict;
    //I am unsure how to initialize a hashmap. This line may need to be looked at
    private HashMap schedule;

    //working 
    /**
     * Constructor for the Coordinator class
     * @param ID must be a string of 4 numbers
     * @throws IllegalArgumentException for any arguments that violate the above rules
     */

    public Coordinator(String ID) throws IllegalArgumentException {
        this.ID = ID;
        tournaments = new ArrayList<>();
    }

    public String getID() {
        return ID;
    }

    //This method creates a tournament and adds it to the list. May need additional parameters for teams participating
    public void createTournament(String name, String ID, Game gameType, double startTime, ArrayList<Team> teams) {
        if (Tournament.validateArguments(name, ID, startTime)){
            tournaments.add(new Tournament(name, ID, gameType, startTime, teams));
        }
        else{
            System.out.println("Failed to create tournament.");
        }
    }

     //This method removes a tournament and adds it to the list. Needs parameter for selecting which tournament to remove
    public void removeTournament(String name) {
        for (int i = 0; i < tournaments.size(); i++){
            if (name.equalsIgnoreCase(tournaments.get(i).getName())){
                tournaments.remove(i);
                System.out.println("Tournament removed successfully!");
            }
        }
    }

    /**
     * Creates a team and adds them to a tournament
     * @param 
     */
    public void createTeam() {
        ;
    }

    /**
     * Removes a team from a tournament
     * @param tournamentName name of the tournament that contains the desired team to be removed
     * @param teamName name of the team to be removed
     */
    public void removeTeam(String tournamentName, String teamName){
        ;
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