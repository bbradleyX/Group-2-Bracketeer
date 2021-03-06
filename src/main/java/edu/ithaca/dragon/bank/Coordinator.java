package edu.ithaca.dragon.bank;

import java.util.ArrayList;
import java.util.HashMap;

import org.javatuples.Pair;

public class Coordinator {
    private String ID;
    private ArrayList<Tournament> tournaments;
    private boolean timeConflict;
    private PlayerMakerUI playerobj;
    //private TeamMakerUI teamobj;

    //working 
    /**
     * Constructor for the Coordinator class
     * @param ID must be a string of 4 numbers
     * @throws IllegalArgumentException for any arguments that violate the above rules
     */

    public Coordinator(String ID) throws IllegalArgumentException {
        this.ID = ID;
        tournaments = new ArrayList<Tournament>();
    }

    public String getID() {
        return ID;
    }

    //This method creates a tournament and adds it to the list. May need additional parameters for teams participating
    public void createTournament(String name, String ID, double startTime) {
        if (Tournament.validateArguments(name, ID, startTime)){
            tournaments.add(new Tournament(name, ID, startTime));
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
        boolean checker = false;
        for (int i = 0; i < tournaments.size(); i++){
            if (tournamentName.equalsIgnoreCase(tournaments.get(i).getName())){
                for (int j = 0; j < tournaments.get(i).getTeams().size(); j++){
                    if (tournaments.get(i).getTeams().get(j).getTeamName().equalsIgnoreCase(teamName)){
                        tournaments.get(i).getTeams().remove(j);
                        checker = true;
                    }
                }
                if (!checker){
                    System.out.println("No such team is found.");
                }
            }
            else{
                System.out.println("No such tournament exists.");
            }
        }
    }

       //this method creates a bracket for a tournament
    public Void createBracket(Tournament tournament) {
        return null;
    }

    public ArrayList<Tournament> getTournaments(){
        return this.tournaments;
    }
}