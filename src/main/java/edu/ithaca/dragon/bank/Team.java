package edu.ithaca.dragon.bank;
import java.security.InvalidParameterException;
//import java.util.List;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.javatuples.Pair;



public class Team {
    private String teamName;
    private HashMap<Player, Pair<Double, Double>> teamsMap;

    public Team(String teamName){
        this.teamName = teamName;
        this.teamsMap = new HashMap<Player, Pair<Double, Double>>();

    }

    public void addPlayer(Player player)throws InvalidParameterException{
        if(teamsMap.isEmpty()){
            System.out.println("Adding first player to "+teamName+ "...");
            teamsMap.put(player, player.getSchedule());
        }
        else if(!teamsMap.isEmpty()){
            for ( Player key : teamsMap.keySet() ) {
                if (player==key){
                   throw new InvalidParameterException("Player is already in team: "+teamName);
                }
            }
         }
        else{
            System.out.println("Adding new player to "+teamName+ "...");
            teamsMap.put(player, player.getSchedule());;

        }
    }

    public void removePlayer(String playerID) throws IndexOutOfBoundsException, IllegalArgumentException{
        if (teamsMap.isEmpty()){
            throw new IndexOutOfBoundsException("This team list is empty. There are no players in this team.");
        }
        else{
            for ( Player key : teamsMap.keySet() ) {
                Player player = key;
                if (player.getID() == playerID){
                    teamsMap.remove(key);
                }
                else{
                    throw new IllegalArgumentException("Player Not Found");
                }
            }
        }
    }

    public boolean getPlayerInfo(String playerID)throws IllegalArgumentException{
        boolean found = false;
        for ( Player key : teamsMap.keySet() ) {
            Player player = key;
            if (player.getID() == playerID){
                found = true;
                System.out.println("Found Player\t" + "Player ID: "+ player.getID() +", Player Name: " + player.getName()+", Player Schedule: "+ player.getSchedule());
            }
            else{
                found = false;
                throw new IllegalArgumentException("Player Not Found");
            }
        }
        return found;
    }


    public String getTeamName(){
        return teamName;
    }

    public boolean getTeamInfo()throws IllegalArgumentException{
        boolean found = false;
        if (teamsMap.isEmpty()){
            found = false;
            throw new IllegalArgumentException("Team Not Found");
        }
        for ( Player key : teamsMap.keySet() ) {
            found = true;
            Player player = key;
            System.out.println("Team: "+getTeamName()+ "\n");
            System.out.println("Player ID: "+ player.getID() +", Player Name: " + player.getName()+", Player Schedule: "+ player.getSchedule().toString() + "\n");
        }
        return found;
    }

    public void getTeamSchedule(){
        Set set = teamsMap.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry item = (Map.Entry)iterator.next();
            Player player = (Player) item.getKey();
            System.out.println ("Player: "+ player.getName() +", Schedule: "+ item.getValue());
        }
    }
}
