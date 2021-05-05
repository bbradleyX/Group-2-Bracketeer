package edu.ithaca.dragon.bank;

import java.util.ArrayList;
import java.util.HashMap;

import org.javatuples.Pair;


public class Coordinator {
    private String ID;
    private HashMap<String, Tournament> eventTracker; 
    private boolean timeConflict;
    private PlayerMakerUI playerobj;
    private TeamMakerUI teamobj;

    /**
     * Constructor for the Coordinator class
     * @param ID must be a string of 4 numbers
     * @throws IllegalArgumentException for any arguments that violate the above rules
     */

    public Coordinator(String ID) throws IllegalArgumentException {
        this.ID = ID;
        this.eventTracker= new HashMap<String, Tournament>();
        this.playerobj = null;
        this.teamobj = null;
        this.timeConflict = false;
    }

    public String getID() {
        return ID;
    }

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
    }

}