package edu.ithaca.dragon.bank;
import java.security.InvalidParameterException;
//import java.util.List;
import java.util.LinkedHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.management.InvalidApplicationException;

import org.javatuples.Pair;



public class Team {
    private String teamName;
    private LinkedHashMap<Player, Pair<Double, Double>> teamsMap;

    public Team(String teamName)throws InvalidParameterException{
        if (teamName == "" || teamName == " "){
            throw new InvalidParameterException("Invalid Team Name");
        }
        else{
            this.teamName = teamName;
            this.teamsMap = new LinkedHashMap<Player, Pair<Double, Double>>();
        }

    }

    public void addPlayer(Player player)throws InvalidParameterException{
        if(!teamsMap.isEmpty()){
            for ( Player key : teamsMap.keySet() ) {
                if (player.getID()==key.getID()){
                   throw new InvalidParameterException("Player is already in team: "+teamName);
                }
            }
        }
        if(teamsMap.size() < 1){
            System.out.println("Adding first new player "+ player.getName() +" to "+ teamName+ "...");
            teamsMap.put(player, player.getSchedule());
        }
        else{
            System.out.println("Adding new player "+ player.getName() +" to "+ teamName+ "...");
            teamsMap.put(player, player.getSchedule());
            }
        }

    public void removePlayer(String playerID) throws IndexOutOfBoundsException, IllegalArgumentException{
        if (teamsMap.isEmpty()){
            throw new IndexOutOfBoundsException("This team list is empty. There are no players in this team.");
        }
        else{
            Player playerToRemove = null;
            for ( Player key : teamsMap.keySet() ) {
                if (key.getID() == playerID){
                    playerToRemove = key;
                }
            }
            if(playerToRemove != null){
                teamsMap.remove(playerToRemove);
            }
            else{
                throw new IllegalArgumentException("Player Not Found");
            }

        }
    }

    public String getPlayerInfo(String playerID)throws IllegalArgumentException{
        String info = "";
        for ( Player key : teamsMap.keySet() ) {
            if (key.getID() == playerID){
                info += "Found Player "+ key.getID()+"->\t" +"Player Name: " + key.getName()+", Player Schedule: "+ key.getSchedule()+"\n";
            }
        }
        if(info.isBlank()){
            throw new IllegalArgumentException("Player Not Found");
        }
        return info;
    }


    public String getTeamName(){
        return teamName;
    }

<<<<<<< HEAD
    public void viewSchedule(Player player){

=======
    public String getTeamInfo()throws Error{
        if (teamsMap.isEmpty()){
            throw new Error("Team is Empty");
        }
        else{
            String info = "\nTeam Info For "+getTeamName()+ ":\n";
            for ( Player key : teamsMap.keySet() ) {
            Player player = key;
            info += "Player ID: "+ player.getID() +", Player Name: " + player.getName()+", Player Schedule: "+ player.getSchedule().toString() + "\n";
            }
            return info;
        }
>>>>>>> Team
    }

    public String getTeamSchedule()throws IndexOutOfBoundsException{
        String scheduleInfo = "";
        Set set = teamsMap.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry item = (Map.Entry)iterator.next();
            Player player = (Player) item.getKey();
            scheduleInfo += "Player: "+ player.getName() +", Schedule: "+ item.getValue()+ "\n";
       }
       if(scheduleInfo.isBlank()){
        throw new IndexOutOfBoundsException("This team list is empty. There are no players in this team.");

       }
       return scheduleInfo;
    }
}
