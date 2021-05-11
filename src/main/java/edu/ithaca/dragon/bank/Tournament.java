package edu.ithaca.dragon.bank;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.text.StyledEditorKit.ItalicAction;

import java.io.*;

//import jdk.internal.net.http.common.Pair;
import org.javatuples.Pair;



public class Tournament {
    private String name;
    private String ID;
    private List<Team> teams;
    private List<Team> inGame;
    private List<Team> elim;
    private double startTime;
    private int group;
    private List<Game> games;

    /**
     * Constructor for the Player class
     * @param name must be a name consisting of at least 1 character, number, or symbol
     * @param ID must be a string of 4 numbers
     * @param startTime must be a double greater than 0 and less than 24, using increments of 0.25 for 15 minute blocks of time
     * @param players2 is a list of players in the teams participating in the event
     * @throws IllegalArgumentException for any arguments that violate the above rules
     */

    public Tournament(String name, String ID, double startTime) throws IllegalArgumentException {
        this.name = name;
        this.ID = ID;
        this.startTime = startTime;
        this.teams = new ArrayList<Team>();
        this.group = 0;
        this.games = new ArrayList<>();
        this.inGame = new ArrayList<>();
        this.elim = new ArrayList<>();
        ;
    }

    public static boolean validateArguments(String name, String ID, double startTime) {
        if (name.length() < 1) {
            System.out.println("Name must consist of at least 1 character.");
            return false;
        }
        if (ID.length() != 4) {
            System.out.println("ID must be a string of 4 numbers.");
            return false;
        }
        for (int i = 0; i < ID.length(); i++) {
            if ((ID.charAt(i) < 48) || (ID.charAt(i) > 57)) {
                System.out.println("ID must be a string of 4 numbers.");
                return false;
            }
        }
        if ((startTime < 0.0) || (startTime > 24.0)) {
            System.out.println("Start time must be a value between 0.0 and 24.0.");
            return false;
        }
        else{
            return true;
        }   
    }

    public String getName() {
        return this.name;
    }

    public String getID() {
        return this.ID;
    }

    public List<Team> getTeams() {
        return this.teams;
    }
    
    public List<Game> getGames(){
        return this.games;
    }

    public double getStartTime() {
        return this.startTime;
    }

    public boolean isRoundComplete(){
        if(games.isEmpty()){
            return true;
        }
        else{return false;
        }
    }

    public void updateRound(){
        int size = games.size();
        List<Game> copy = new ArrayList<>();
        for(int i=0;i<size;i++){
            if(games.get(i).getWinner()!=null){
                teams.add(games.get(i).getWinner());
                elim.add(games.get(i).getLoser());
            }
            else{
                copy.add(games.get(i));
            }
        }
        games = copy;
    }

    public boolean checkTournyFin(){
        if(teams.size()<2){
            return true;
        }
        else{return false;
        }
    }

    public void createRound(){
        if(isRoundComplete()){
            if(!checkTournyFin()){
                int i = 1;
                int index1 = 0;
                int index2 = 0;
                int num = 0;
                while(teams.size()>1){
                    Random rand = new Random();
                    if(teams.size()-2==0){
                        num = 1;
                    }
                    else{
                        num = rand.nextInt(teams.size()-2)+1;
                    }
                    games.add(new Game("game" + i, "123"+i, startTime, teams.get(0), teams.get(num)));
                    List<Team> copy = new ArrayList<>();
                    index2 = num;
                    for (int j = 0; j < teams.size(); j++) {
                        if (j != index1 && j != index2) {
                        copy.add(teams.get(j));
                        }
                        else{
                            inGame.add(teams.get(j));
                        }
                    }
                    teams = copy;
                    i++;
                    if(i>10){
                        teams.clear();
                    }
                }
            }
        }
    }

    public List<Team> getInGame(){
        return this.inGame;
    }

    public List<Team> getElim(){
        return this.elim;
    }

    public void roundRobin(){
        List<List<Team>> groups = new ArrayList<>();
        int numGrp = teams.size()/3;
        for(int j=0;j<numGrp;j++){
            List<Team> e = new ArrayList<>();
            groups.add(e);
        }
        for(int i=0; i<teams.size();i++){
            int grpNum = i%numGrp;
            groups.get(grpNum).add(teams.get(i));
        }
        for(int k = 0; k<groups.size();k++){
            for(int l = 0; l<groups.get(k).size();l++){
                for(int m=l+1; m<groups.get(k).size();m++){
                    games.add(new Game("game" + k + "-" + m + l, "1"+k+m+l, startTime, groups.get(k).get(l), groups.get(k).get(m)));
                }
            }
        }
    }

    //This methods sees if any players have a time conflict
    public boolean isTimeconflict() {
        for (int i = 0; i < teams.size(); i++){
            for (Player key : teams.get(i).getTeam().keySet()){
                if (key.getSchedule().getValue0() > startTime){
                    return true;
                }
            }
        }
        return false;
    }
    //This will need more methods but non are on the diagram as of right now.
}