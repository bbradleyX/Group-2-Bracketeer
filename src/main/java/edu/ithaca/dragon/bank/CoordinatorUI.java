/**
 * CoordinatorUI Algorithm
 * 1. Create Scanner object
 * 2. Create Coordinator object
 * 3. if (tournaments.size == 0)
 *      print("There are currently no running tournaments. Would you like to create one?")
 *      if (yes)
 *          create new tournament
 *      else
 *          close UI
 * 4. while (tournaments.size > 0)
 *      print(Select an option:)
 *      print(1. Create a new tournament)
 *      print(2. Update a tournament in progress)
 *      print(3. Close out all tournaments)
 *      scanner.nextInt
 * 5. if (Option 1)
 *      create new tournament
 *      back to menu
 * 6. if (Option 2)
 *      print list of tournaments with numbers
 *      scanner.nextInt to select desired tournament
 *      while (updateTournament == true)
 *          print(1. Create a team)
 *          print(2. Remove a team)
 *          print(3. Add players to a team)
 *          print(4. Remove players from a team)
 *          print(5. Manage time conflicts)
 *          print(6. Create a round)
 *          print(7. Update a round)
 *          print(8. Main Menu)
 *          scanner.nextInt to select desired action
 * 7. if (Option 3)
 *      close UI
 */
package edu.ithaca.dragon.bank;

import java.util.ArrayList;
import java.util.Scanner;

public class CoordinatorUI {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        Coordinator coordinator = new Coordinator("0000");

        boolean runProgram = true;
        while (runProgram){
            if (coordinator.getTournaments().size() == 0){
                System.out.println("There are currently no running tournaments. Would you like to create one? (yes/no)");
                String makeTournament = myScanner.next();
                while (!(makeTournament.equals("yes") || makeTournament.equals("no"))){
                    System.out.println("Invalid input. There are currently no running tournaments. Would you like to create one? (yes/no)");
                }
                if (makeTournament.equals("no")){
                    runProgram = false;
                }
                else{
                    boolean tournamentCredentialsValid = false;
                    while(tournamentCredentialsValid == false){
                        System.out.println("Enter a name for the tournament: (at least one character)");
                        String nameIn = myScanner.next();
                        System.out.println("Enter an ID for the tournament: (four digits)");
                        String IDIn = myScanner.next();
                        System.out.println("Enter a start for the tournament: (between 0.0 and 24.0, in the format x.x)");
                        double startTimeIn = myScanner.nextDouble();
                        if (Tournament.validateArguments(nameIn, IDIn, startTimeIn)){
                            coordinator.createTournament(nameIn, IDIn, startTimeIn);
                            tournamentCredentialsValid = true;
                        }
                    }
                }
                while (coordinator.getTournaments().size() > 0){
                    System.out.println("Enter the corresponding number for one of the options below:");
                    System.out.println("1. Create a new tournament");
                    System.out.println("2. Update an existing tournament");
                    System.out.println("3. Close out all tournaments");
                    int mainMenuSelection = myScanner.nextInt();
                    while (mainMenuSelection < 1 || mainMenuSelection > 3){
                        System.out.println("Invalid input.");
                        System.out.println("Enter the corresponding number for one of the options below:");
                        System.out.println("1. Create a new tournament");
                        System.out.println("2. Update an existing tournament");
                        System.out.println("3. Close out all tournaments");
                        mainMenuSelection = myScanner.nextInt();
                    }
                    if (mainMenuSelection == 1){
                        boolean tournamentCredentialsValid = false;
                        while(tournamentCredentialsValid == false){
                            System.out.println("Enter a name for the tournament: (at least one character)");
                            String nameIn = myScanner.next();
                            System.out.println("Enter an ID for the tournament: (four digits)");
                            String IDIn = myScanner.next();
                            System.out.println("Enter a start for the tournament: (between 0.0 and 24.0, in the format x.x)");
                            double startTimeIn = myScanner.nextDouble();
                            if (Tournament.validateArguments(nameIn, IDIn, startTimeIn)){
                                coordinator.createTournament(nameIn, IDIn, startTimeIn);
                                tournamentCredentialsValid = true;
                            }
                        }
                    }
                    else if (mainMenuSelection == 2){
                        System.out.println("Enter the corresponding number for one of the tournaments below:");
                        for (int i = 0; i < coordinator.getTournaments().size(); i++){
                            int menuNumber = i+1;
                            System.out.println(menuNumber + ". " + coordinator.getTournaments().get(i).getName());
                        }
                        int tournamentSelection = myScanner.nextInt();
                        while ((tournamentSelection < 1) || (tournamentSelection > coordinator.getTournaments().size())){
                            System.out.println("Invalid input. Enter the corresponding number for one of the tournaments:");
                            tournamentSelection = myScanner.nextInt();
                        }
                        int tournamentIndex = tournamentSelection - 1;
                        int actionSelection = 0;
                        while(actionSelection!=10){
                        System.out.println("Select the corresponding number for an action below:");
                        System.out.println("1. Create a team");
                        System.out.println("2. Remove a team");
                        System.out.println("3. Add players to a team");
                        System.out.println("4. Remove players from a team");
                        System.out.println("5. Manage time conflict");
                        System.out.println("6. View teams in tournament");
                        System.out.println("7. View players in tournament");
                        System.out.println("8. Create a round");
                        System.out.println("9. Update a round");
                        System.out.println("10. Main Menu");
                        actionSelection = myScanner.nextInt();
                        while (actionSelection < 1 || actionSelection > 10){
                            System.out.println("Invalid input. Select a corresponding number for an action:");
                            actionSelection = myScanner.nextInt();
                        }
                        //Create a team
                        if (actionSelection == 1){
                            coordinator.getTournaments().get(tournamentIndex).getTeams().add(TeamMakerUI.runTeamMakerUI(myScanner));
                        }
                        //Remove a team
                        else if (actionSelection == 2){
                            System.out.println("Enter the name of the team you wish to remove:");
                            String removeTeam = myScanner.next();
                            coordinator.removeTeam(coordinator.getTournaments().get(tournamentIndex).getName(), removeTeam);
                        }
                        //Add players to a team
                        else if (actionSelection == 3){
                            System.out.println("Enter the name of the team you wish to add a player to:");
                            String addPlayerTeam = myScanner.next();
                            for (int i = 0; i < coordinator.getTournaments().get(tournamentIndex).getTeams().size(); i++){
                                if (coordinator.getTournaments().get(tournamentIndex).getTeams().get(i).getTeamName().equalsIgnoreCase(addPlayerTeam)){
                                    coordinator.getTournaments().get(tournamentIndex).getTeams().get(i).addPlayer(PlayerMakerUI.runUI(myScanner));
                                }
                            }
                        }
                        //Remove players from a team
                        else if (actionSelection == 4){
                            System.out.println("Enter the name of the team you wish to remove a player from:");
                            String removePlayerTeam = myScanner.next();
                            System.out.println("Enter the ID of the player you wish to remove:");
                            String removePlayerID = myScanner.next();
                            for (int i = 0; i < coordinator.getTournaments().get(tournamentIndex).getTeams().size(); i++){
                                if (coordinator.getTournaments().get(tournamentIndex).getTeams().get(i).getTeamName().equalsIgnoreCase(removePlayerTeam)){
                                    coordinator.getTournaments().get(tournamentIndex).getTeams().get(i).removePlayer(removePlayerID.toString());
                                }
                             }
                        } 
                        //Manage time conflicts
                        else if (actionSelection == 5){
                            if (coordinator.getTournaments().get(tournamentIndex).isTimeconflict()){
                                //Loop through teams
                                for (int i = 0; i < coordinator.getTournaments().get(tournamentIndex).getTeams().size(); i++){
                                    //Loop through players
                                    for (Player key : coordinator.getTournaments().get(tournamentIndex).getTeams().get(i).getTeam().keySet()){
                                        //If player start time is later than tournament start time
                                        if (key.getSchedule().getValue0() > coordinator.getTournaments().get(tournamentIndex).getStartTime()){
                                            System.out.println(key.getName() + " has time conflict! " + key.getName() + "'s availability begins at " + key.getSchedule().getValue0() + ", but the tournament starts at " + coordinator.getTournaments().get(tournamentIndex).getStartTime());
                                            //Call runModifyScheduleUI for player
                                            PlayerMakerUI.runModifyScheduleUI(myScanner, key);
                                        }
                                    }
                                }
                            }
                        }
                        //View teams in tournament
                        else if (actionSelection == 6){
                            for (int i = 0; i < coordinator.getTournaments().get(tournamentIndex).getTeams().size(); i++){
                                System.out.println(coordinator.getTournaments().get(tournamentIndex).getTeams().get(i).getTeamName());
                            }
                        }
                        //View players in tournament
                        else if (actionSelection == 7){
                            for (int i = 0; i < coordinator.getTournaments().get(tournamentIndex).getTeams().size(); i++){
                                coordinator.getTournaments().get(tournamentIndex).getTeams().get(i).getTeam().forEach((k,v) -> System.out.println("Player Name: "+k.getName()+" Player ID: "+k.getID()+"\n"));
                            }
                        }
                        //Create a round
                        else if (actionSelection == 8){
                            if (coordinator.getTournaments().get(tournamentIndex).isTimeconflict()){
                                System.out.println("There are time conflicts! Please resolve them using option 5 in the tournament menu.");
                            }
                            else{
                                coordinator.getTournaments().get(tournamentIndex).createRound();
                            }
                        }
                        //Update a round
                        else if (actionSelection == 9){
                            int updateSelection = 1;
                            while(updateSelection!=0){
                                if(coordinator.getTournaments().get(tournamentIndex).getGames().size()==0){
                                    System.out.println("There are no games in progress");
                                }
                                else{
                                    System.out.println("Games in Progress");
                                    int roundIndex = 0;
                                    for(int i=0;i<coordinator.getTournaments().get(tournamentIndex).getGames().size();i++){
                                        roundIndex = i + 1;
                                        System.out.println("Match " + roundIndex + ": " + coordinator.getTournaments().get(tournamentIndex).getGames().get(i).getTeam1().getTeamName() + "  versus  " + coordinator.getTournaments().get(tournamentIndex).getGames().get(i).getTeam2().getTeamName());
                                    }
                                }
                                System.out.println("");
                                System.out.println("select game number to update or 0 to return to menu");
                                updateSelection = myScanner.nextInt();
                                while (updateSelection < 0 || updateSelection > coordinator.getTournaments().get(tournamentIndex).getGames().size() ){
                                    System.out.println("Invalid input. Select a corresponding number for an action:");
                                    updateSelection = myScanner.nextInt();
                                }
                                if (updateSelection!=0){
                                int updateSelection2 = 1;
                                while(updateSelection2!=0){
                                    System.out.println("Select the corresponding number for an action below:");
                                    System.out.println("0: Back");
                                    System.out.println("1: View Teams");
                                    System.out.println("2: Select Winner");
                                    updateSelection2 = myScanner.nextInt();
                                    while (updateSelection2 < 0 || updateSelection2 > 2){
                                        System.out.println("Invalid input. Select a corresponding number for an action:");
                                        updateSelection2 = myScanner.nextInt();
                                    }
                                    if (updateSelection2 == 1){
                                        System.out.println("Team1: " +  coordinator.getTournaments().get(tournamentIndex).getGames().get(updateSelection - 1).getTeam1().getTeamName());
                                        System.out.println("Team2: " + coordinator.getTournaments().get(tournamentIndex).getGames().get(updateSelection - 1).getTeam2().getTeamName());
                                    }
                                    else if (updateSelection2 == 2){
                                        int updateSelection3;
                                        System.out.println("Select the corresponding number for an action below:");
                                        System.out.println("1: " + coordinator.getTournaments().get(tournamentIndex).getGames().get(updateSelection - 1).getTeam1().getTeamName() + " wins");
                                        System.out.println("2: " + coordinator.getTournaments().get(tournamentIndex).getGames().get(updateSelection - 1).getTeam2().getTeamName() + " wins");
                                        updateSelection3 = myScanner.nextInt();
                                        while (updateSelection3 < 1 || updateSelection3 > 2){
                                            System.out.println("Invalid input. Select a corresponding number for an action:");
                                            updateSelection3 = myScanner.nextInt();
                                        }
                                        if(updateSelection3==1){
                                            coordinator.getTournaments().get(tournamentIndex).getGames().get(updateSelection - 1).hasWon(coordinator.getTournaments().get(tournamentIndex).getGames().get(updateSelection - 1).getTeam1());
                                        }
                                        else if(updateSelection3==2){
                                            coordinator.getTournaments().get(tournamentIndex).getGames().get(updateSelection - 1).hasWon(coordinator.getTournaments().get(tournamentIndex).getGames().get(updateSelection - 1).getTeam2());
                                        }
                                        updateSelection2 =  0;
                                    }
                                }
                                coordinator.getTournaments().get(tournamentIndex).updateRound();
                            }
                            
                        }   
                        coordinator.getTournaments().get(tournamentIndex).updateRound();
                        if(coordinator.getTournaments().get(tournamentIndex).checkTournyFin() && coordinator.getTournaments().get(tournamentIndex).isRoundComplete()){
                            System.out.println("");
                            System.out.println(coordinator.getTournaments().get(tournamentIndex).getTeams().get(0).getTeamName() + " has won the tournament!");
                            System.out.println("");
                        }
                    }
                        //Return to main menu
                        else if (actionSelection == 10){
                            System.out.println("Returning...");
                        }
                    }
                    }
                    else if (mainMenuSelection == 3){
                        coordinator.getTournaments().clear();
                        System.out.println("Thank you for using Bracketeer!");
                        runProgram = false;
                    }
                }
            }
        }
    }
}
