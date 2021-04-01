package edu.ithaca.dragon.bank;
import java.util.ArrayList;
import java.util.List;

import org.javatuples.Pair;



public class Team {
    private String teamName;
    private List <Pair<Double, Double>> teamSchedule;
    private List <Player> teamPlayers;

    public Team(String teamName){
        this.teamName = teamName;
        this.teamPlayers = new ArrayList<Player>();
        this.teamSchedule = new ArrayList<Pair<Double, Double>>();

    }

    public String getTeamName(){
        return teamName;
    }

    public List  <Player> getTeam(){
        return teamPlayers;
    }

    public List <Pair<Double, Double>> getTeamSchedule(){
        return teamSchedule;
    }



}
