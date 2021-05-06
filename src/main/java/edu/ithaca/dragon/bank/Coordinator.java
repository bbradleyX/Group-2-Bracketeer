package edu.ithaca.dragon.bank;

import java.util.ArrayList;
import java.util.HashMap;

import org.javatuples.Pair;

public class Coordinator {
    private String ID;
<<<<<<< HEAD
    private HashMap<String, Tournament> eventTracker; 
=======
    private ArrayList<Tournament> tournaments;
>>>>>>> origin/coordinator
    private boolean timeConflict;
    private PlayerMakerUI playerobj;
    private TeamMakerUI teamobj;

    //working 
    /**
     * Constructor for the Coordinator class
     * @param ID must be a string of 4 numbers
     * @throws IllegalArgumentException for any arguments that violate the above rules
     */

    public Coordinator(String ID) throws IllegalArgumentException {
        this.ID = ID;
<<<<<<< HEAD
        this.eventTracker= new HashMap<String, Tournament>();
        this.playerobj = null;
        this.teamobj = null;
        this.timeConflict = false;
=======
        tournaments = new ArrayList<Tournament>();
>>>>>>> origin/coordinator
    }

    public String getID() {
        return ID;
    }

<<<<<<< HEAD
    public HashMap<String,Tournament> getEventTracker() {
        return eventTracker;
    }

    public PlayerMakerUI getPlayerMakerObject() {
        return playerobj;
    }

    public TeamMakerUI getTeamMakerObject() {
        return teamobj;
    }

    public boolean getTimeCOnflict() {
        return timeConflict;
    }

    //This uses a TeamMakerUI object to add a team to the Event Tracker map. might need an additional parameter for teamlist or some connection to team in diagram
    public void addTeam(Team team) {
    }

    //Removes a team from the the Event Tracker map.
    public void removeTeam() {
    }

    //This method creates a tournament and adds it to the list. Calls Tournament and Game constructors
    public void createTournament(String tournamentName, String gameName) {
    }

     //This method removes a tournament and adds it to the list. Needs parameter for selecting which tournament to remove
    public void removeTournament() {
    }

      //This methods checks if there is a time conflict from a player within a team based on the start time of a tournament
    public boolean isTimeconflict(double tournTime) {
        return false;
    }

    //This method removes a tournament and adds it to the list. Needs parameter for selecting which tournament to remove
    public String showTournament(String teamName) {
        return null;
    }

    //This method removes a tournament and adds it to the list. Needs parameter for selecting which tournament to remove
    public String showTeams(String tournamentID) {
        return null;
    }

    //This method removes a tournament and adds it to the list. Needs parameter for selecting which tournament to remove
    public String showAllTournaments() {
        return null;
    }

    //This method shows all active teams that are in a tournament
    public String showAllTeams() {
        return null;
=======
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
    public void createTeam(String tournamentName, String teamName) throws IllegalArgumentException{
        ;
    }

    /**
     * Removes a team from a tournament
     * @param tournamentName name of the tournament that contains the desired team to be removed
     * @param teamName name of the team to be removed
     */
    public void removeTeam(String tournamentName, String teamName){
        for(int i = 0; i < tournaments.size(); i++){
            if (tournamentName.equalsIgnoreCase(tournaments.get(i).getName())){
                if(tournaments.get(i).getTeams().size() > 0){
                    for(int j = 0; j < tournaments.get(i).getTeams().size(); j++){
                        if(tournaments.get(i).getTeams().get(j).getTeamName().equalsIgnoreCase(teamName)){
                            tournaments.get(i).getTeams().remove(j);
                            System.out.println("Team removed successfully!");
                        }
                    }
                }
                else{
                    System.out.println("Can't remove a team from a tournament without teams.");
                }
            }
            else{
                System.out.println("No such team exists within this tournament.");
            }
        }
    }

       //this method creates a bracket for a tournament
    public Void createBracket(Tournament tournament) {
        return null;
    }

      //This methods sees if any players have a time conflict
      public boolean isTimeconflict(Pair<Double, Double> playerTime, double tournTime) {
          if(tournTime < 0){
              return false;
            }
          if(tournTime >= playerTime.getValue0() && tournTime <= playerTime.getValue1()){
              return true;
            }
        else{
            return false;
        }
    }

    public ArrayList<Tournament> getTournaments(){
        return tournaments;
>>>>>>> origin/coordinator
    }

}