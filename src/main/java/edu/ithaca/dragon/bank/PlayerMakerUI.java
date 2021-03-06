package edu.ithaca.dragon.bank;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PlayerMakerUI {
    
    private static String newID;
    private static String newName;
    private static double startTime;
    private static double endTime;

    /**
     * Check if user input correct name  
     */
    public static boolean isNameVaild(String name) {
        while( name.length() < 1 ) //must be a name consisting of at least 1 character, number, or symbol
        {return false;}
        return true;
    }

    /**
     * Check if user input correct If  
     */
    public static boolean isIDVaild(String ID) {
        while(ID.length() != 4) //allow a four digit ID
        {return false;}
        return true;
    }

    /**
     * Check if user input correct If must be a double greater than 0 
     * and less than 24, using increments of 0.25 for 15 minute blocks of time
     */
    public static boolean isStartTimeVaild(double startTime) {
        while((startTime < 0.0) || (startTime > 24.0)) //can only have 24 hours
        {return false;}
        return true;
    }

    /**
     * Check if user input correct If must be a double greater than 0 
     * and less than 24, using increments of 0.25 for 15 minute blocks of time
     */
    public static boolean isEndTimeVaild(double endTime) {
        if((endTime < 0.0) || (endTime > 24.0))
        {return false;}
        return true;
    }

    public static Player runUI(Scanner scanner){
        System.out.println("You are now creating player\n");
        //Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        
            System.out.println("Please enter your name:\n");
            String name = scanner.next();
            while(PlayerMakerUI.isNameVaild(name) != true){
                System.out.println("Please enter your name again:\n");
                name = scanner.next();
            }
            newName = name;
            
            System.out.println("Please enter your ID number\n");
            String ID = scanner.next();
            while(PlayerMakerUI.isIDVaild(ID) != true){
                System.out.println("Please only enter four digit for your ID:\n"); 
                ID = scanner.next();
            }
            newID = ID;
            
            
            double startTime = -1;
            while (PlayerMakerUI.isStartTimeVaild(startTime) != true){
                try {
                    System.out.println("Please enter the time to start\n");
                    startTime = scanner.nextDouble();
                }
                catch (InputMismatchException e)
                {
                    System.out.println("Your start time must be a double greater than 0 and less than 24, using increments of 0.25 for 15 minute blocks of time. Please enter it again:\n"); 
                    scanner.next();}
            }
            double newStartTime = startTime;
            
            double endTime = -1;
            while( PlayerMakerUI.isEndTimeVaild(endTime) != true){
                try{
                    System.out.println("Please enter the time to end\n");
                    endTime = scanner.nextDouble();
                }
                catch (InputMismatchException e){
                    System.out.println("Your end time must be a double greater than 0 and less than 24, using increments of 0.25 for 15 minute blocks of time. Please enter it again:\n");
                    scanner.next();
                }
            }
            double newEndTime = endTime;

            System.out.println("\n");
            System.out.println("----------");
            System.out.println(newName + ", you are now a player.\n" + "Your ID is " + newID + "\nYou will start at " +newStartTime + "\n" + "You will end at " + endTime + "\n");
            Player player1 = new Player(newName, newID, newStartTime, newEndTime);
        
            return (player1);
        
    }

    protected static void runModifyScheduleUI(Scanner scanner, Player player){        
        System.out.println("Would you like to change your time? (yes or no)\n");
        String answer = scanner.next();
         
        while(!(answer.equalsIgnoreCase("yes"))  || !(answer.equalsIgnoreCase("no"))){
            System.out.println("Please enter yes or no\n");
            answer = scanner.next();

            if(answer.equalsIgnoreCase("yes")){
                startTime = -1;
               while (PlayerMakerUI.isStartTimeVaild(startTime) != true){
                    try {
                        System.out.println("Please enter the new time to start\n");
                        startTime = scanner.nextDouble();
                    }
                    catch (InputMismatchException e)
                    {
                        System.out.println("Your start time must be a double greater than 0 and less than 24, using increments of 0.25 for 15 minute blocks of time. Please enter it again:\n"); 
                        scanner.next();}
                }
                double newStartTimeTwo = startTime;
            
                endTime = -1;
                while( PlayerMakerUI.isEndTimeVaild(endTime) != true){
                    try{
                        System.out.println("Please enter the new time to end\n");
                        endTime = scanner.nextDouble();
                    }
                    catch (InputMismatchException e){
                        System.out.println("Your end time must be a double greater than 0 and less than 24, using increments of 0.25 for 15 minute blocks of time. Please enter it again:\n");
                        scanner.next();
                    }
                }
                double newEndTimeTwo = endTime;

                //Player player2 = new Player(newName, newID, newStartTimeTwo, newEndTimeTwo); 

                System.out.println("\n");
                System.out.println("----------");
                System.out.println(player.getName() + ", your schedule has been modified" + "\nYour new start time is at " +newStartTimeTwo + "\n" + "Your new end time is at " + newEndTimeTwo);
                player.modifySchedule(newStartTimeTwo, newEndTimeTwo);
                break;
            }
            if(answer.equalsIgnoreCase("no")){
                System.out.println("Have a great game!\n");
                break;
            }
        }
    }
}