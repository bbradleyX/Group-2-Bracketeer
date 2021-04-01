package edu.ithaca.dragon.bank;
import java.util.ArrayList;
//import java.util.List;

import org.javatuples.Pair;



public class Team {
    private String teamName;
    private ArrayList <Pair<Double, Double>> teamSchedule;
    private ArrayList <Player> teamPlayers;

    public Team(String teamName){
        this.teamName = teamName;
        this.teamPlayers = new ArrayList<Player>();
        this.teamSchedule = new ArrayList<Pair<Double, Double>>();

    }
    private void addPlayer(Player player){
        if (teamPlayers.isEmpty()){
            teamPlayers.add(player);
        }
        else{
            teamPlayers.add(player);

        }
    }

    private void removePlayer(Player player) throws IndexOutOfBoundsException{
        if (teamPlayers.isEmpty()){
            throw new IndexOutOfBoundsException("This team list is empty. There are no players in this team.");
        }
        else{
            teamPlayers.add(player);
        }
    }

    public String getTeamName(){
        return teamName;
    }

    public ArrayList <Player> getTeam(){
        return teamPlayers;
    }

    public ArrayList <Pair<Double, Double>> getTeamSchedule(){
        return teamSchedule;
    }

    public Pair<Double, Double> viewSchedule (Player player){
        return player.getSchedule();
    }



}
