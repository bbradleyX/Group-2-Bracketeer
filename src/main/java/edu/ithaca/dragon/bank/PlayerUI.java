package edu.ithaca.dragon.bank;
import edu.ithaca.dragon.bank.Player;
import java.util.Scanner;

public class PlayerUI {
    
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

    public static void runUI(){
        System.out.println("You are now creating player\n");
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        
            System.out.println("Please enter your name:\n");
            String name = myObj.nextLine();
            while(PlayerUI.isNameVaild(name) != true){
                System.out.println("Please enter your name again:\n");
                name = myObj.nextLine();
            }
            String newName = name;
            
            System.out.println("Please enter your ID number\n");
            String ID = myObj.nextLine();
            while(PlayerUI.isIDVaild(ID) != true){
                System.out.println("Please only enter four digit for your ID:\n"); 
                ID = myObj.nextLine();
            }
            String newID = ID;
            
            System.out.println("Please enter the time to start\n");
            double startTime = myObj.nextDouble();
            while (PlayerUI.isStartTimeVaild(startTime) != true){
                System.out.println("Your start time must be a double greater than 0 and less than 24, using increments of 0.25 for 15 minute blocks of time. Please enter it again:\n");
                startTime = myObj.nextDouble();
            }
            double newStartTime = startTime;

            System.out.println("Please enter the time to end\n");
            double endTime = myObj.nextDouble();
            while( PlayerUI.isEndTimeVaild(endTime) != true){
                System.out.println("Your end time must be a double greater than 0 and less than 24, using increments of 0.25 for 15 minute blocks of time. Please enter it again:\n");
                endTime = myObj.nextDouble();
            }
            double newEndTime = endTime;
            
            System.out.println("\n");
            System.out.println("----------");
            System.out.println(newName + ", you are now a player.\n" + "Your ID is " + newID + "\nYou will start at " +newStartTime + "\n" + "You will end at " + endTime + "\n");
            Player player1 = new Player(newName, newID, newStartTime, newEndTime);
        
        //Modify user schedule
        System.out.println("Would you like to change your time? (yes or no)\n");
        String answer = myObj.nextLine();
        myObj.nextLine();   

        while(answer != "yes" || answer !="no"){
            System.out.println("Please enter yes or no\n");
            answer = myObj.nextLine();

            if(answer.equalsIgnoreCase("yes") ){
                System.out.println("Please enter the time to start\n");
                startTime = myObj.nextDouble();
                while (PlayerUI.isStartTimeVaild(startTime) != true){
                    System.out.println("Your start time must be a double greater than 0 and less than 24, using increments of 0.25 for 15 minute blocks of time. Please enter it again:\n");
                    startTime = myObj.nextDouble();
                }
                newStartTime = startTime;

                System.out.println("Please enter the time to end\n");
                endTime = myObj.nextDouble();
                while( PlayerUI.isEndTimeVaild(endTime) != true){
                    System.out.println("Your end time must be a double greater than 0 and less than 24, using increments of 0.25 for 15 minute blocks of time. Please enter it again:\n");
                    endTime = myObj.nextDouble();
                }
                newEndTime = endTime;

                System.out.println(newName + ", you are now a player.\n" + "Your ID is " + newID + "\nYour new start time is at " +newStartTime + "\n" + "Your new end time is at " + endTime);
                player1 = new Player(newName, newID, newStartTime, newEndTime);
                break;
            }
            else if(answer.equalsIgnoreCase("no")){
                System.out.println("Have a great game!\n");
                break;
                }
        } 
        myObj.close();
    }
    public static void main(String args[]){
        runUI();
    }
}


    