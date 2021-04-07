package edu.ithaca.dragon.bank;

import org.javatuples.Pair;

public class Player {
    private String name;
    private String ID;
    private Pair<Double, Double> schedule;
   
    /**
     * Constructor for the Player class
     * @param name must be a name consisting of at least 1 character, number, or symbol
     * @param ID must be a string of 4 numbers
     * @param startTime must be a double greater than 0 and less than 24, using increments of 0.25 for 15 minute blocks of time
     * @param endTime must be a double greater than 0 and less than 24, using increments of 0.25 for 15 minute blocks of time
     * @throws IllegalArgumentException for any arguments that violate the above rules
     */
    public Player(String name, String ID, double startTime, double endTime) throws IllegalArgumentException {
        if (validateArguments(name, ID, startTime, endTime)){
            this.name = name;
            this.ID = ID;
            this.schedule = new Pair<>(startTime, endTime);
        }
        else {
            throw new IllegalArgumentException("Cannot add player with invalid credentials.");
        }
    }

    public static boolean validateArguments(String name, String ID, double startTime, double endTime) {
        if (name.length() < 1) {
            return false;
        }
        if (ID.length() != 4) {
            return false;
        }
        for (int i = 0; i < ID.length(); i++) {
            if ((ID.charAt(i) < 48) || (ID.charAt(i) > 57)) {
                return false;
            }
        }
        if ((startTime < 0.0) || (startTime > 24.0) || (endTime < 0.0) || (endTime > 24.0)) {
            return false;
        }
        else{
            return true;
        }
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    public Pair<Double, Double> getSchedule() {
        return schedule;
    }
    
    /**
     * Changes the current player Time  
     * @throws IllegalArgumentException no schedule
     */
    public void modifySchedule(double startTime, double endTime){ 
        try {
            this.schedule = new Pair<>(startTime, endTime);
        } catch (Exception e) {
            throw new IllegalArgumentException("player has no schedule");
        }
    }


    

   
}