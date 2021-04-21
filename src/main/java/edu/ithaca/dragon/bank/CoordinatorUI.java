package edu.ithaca.dragon.bank;

import java.util.ArrayList;
import java.util.Scanner;

public class CoordinatorUI {
    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);

        //Check to ensure Coordinator wants to run a tournament
        Boolean runTournament = true;
        while (runTournament == true){
            System.out.println("Would you like to create a tournament? (y/n)");
            String shouldRun = myScan.next();
            while (!((shouldRun.equalsIgnoreCase("y")) || (shouldRun.equalsIgnoreCase("n")))) {
                System.out.println("Invalid input! Would you like to create a tournament? (y/n)");
                shouldRun = myScan.next();
            }
            if (shouldRun.equalsIgnoreCase("n")) {
                runTournament = false;
            }

            //Coordinator wants to run a tournament
            else {
                System.out.println("Will the tournament consist of teams, or sole players only? (t/p)");
                String teamsOrPlayers = myScan.next();
                while (!((teamsOrPlayers.equalsIgnoreCase("t")) || (teamsOrPlayers.equalsIgnoreCase("p")))) {
                    System.out.println("Invalid input! Will the tournament consist of teams, or sole players only? (t/p)");
                    teamsOrPlayers = myScan.next();
                }

                //TO-DO
                //Tournament will consist of teams
                if (teamsOrPlayers.equalsIgnoreCase("t")){
                    ;
                }

                //Tournament will consist of sole players
                else if (teamsOrPlayers.equalsIgnoreCase("p")){
                    System.out.println("How many players will be in this tournament? (in whole numbers)");
                    int numPlayers = myScan.nextInt();
                    while (numPlayers <= 1){
                        System.out.println("Can't have a tournament with less than 2 players. How many players will be in this tournament? (in while numbers)");
                        numPlayers = myScan.nextInt();
                    }
                    //Add players to roster
                    ArrayList<Player> signups = new ArrayList<>();
                    int playerIndex = 1;
                    for (int i = 0; i < numPlayers; i++){
                        System.out.println("Enter name of Player " + playerIndex + ":");
                        String nameIn = myScan.next();
                        System.out.println("Enter ID of Player " + playerIndex + ":");
                        String IDIn = myScan.next();
                        System.out.println("Enter available start time of Player " + playerIndex + ":");
                        double startTimeIn = myScan.nextDouble();
                        System.out.println("Enter available end time of Player " + playerIndex + ":");
                        double endTimeIn = myScan.nextDouble();
                        if (Player.validateArguments(nameIn, IDIn, startTimeIn, endTimeIn)){
                            signups.add(new Player(nameIn, IDIn, startTimeIn, endTimeIn));
                            System.out.println("Player added successfully!");
                            playerIndex++;
                        }
                        else{
                            System.out.println("Could not add player. Please try again.");
                            i--;
                        }
                    }
                    System.out.println("All players added successfully!");

                    //Create tournament
                    System.out.println("Enter a name for the tournament.");
                    String nameIn = myScan.next();
                    System.out.println("Enter an ID for the tournament.");
                    String IDIn = myScan.next();
                    System.out.println("Enter a start time for the tournament.");
                    double startTimeIn = myScan.nextDouble();
                    while (Tournament.validateArguments(nameIn, IDIn, startTimeIn) == false){
                        System.out.println("Could not create tournament. Please try again.");
                        System.out.println("Enter a name for the tournament.");
                        nameIn = myScan.next();
                        System.out.println("Enter an ID for the tournament.");
                        IDIn = myScan.next();
                        System.out.println("Enter a start time for the tournament.");
                        startTimeIn = myScan.nextDouble();
                    }
                    Tournament tournament = new Tournament(nameIn, IDIn, startTimeIn, signups);
                    System.out.println("Tournament created successfully!");

                    //Tournament Actions
                    boolean startTournament = true;
                    while (startTournament){
                        System.out.println("What would you like to do?");
                        System.out.println("1) View Player Info");
                        System.out.println("2) End the tournament");

                        int option = myScan.nextInt();
                        if (option == 1){

                            playerIndex = 1;
                            System.out.println("Enter a player, by number, from the list below.");
                            for (int i = 0; i < tournament.getPlayers().size(); i++){
                                System.out.println(playerIndex + ") " + tournament.getPlayers().get(i).getName());
                                playerIndex++;
                            }
                            int playerSelection = myScan.nextInt();
                            while ((playerSelection < 0) || (playerSelection > tournament.getPlayers().size())){
                                System.out.println("Invalid input! Please enter one of the player's numbers above.");
                                playerSelection = myScan.nextInt();
                            }

                            System.out.println(tournament.getPlayers().get(playerSelection - 1).getName() + "'s Info:");
                            System.out.println("ID: " + tournament.getPlayers().get(playerSelection - 1).getID());
                            System.out.println("Start Time: " + tournament.getPlayers().get(playerSelection - 1).getSchedule().getValue0());
                            System.out.println("End Time: " + tournament.getPlayers().get(playerSelection - 1).getSchedule().getValue1());
                        }
                        else{
                            startTournament = false;
                        }
                    }
                    
                }
            }
        }
    }
}
