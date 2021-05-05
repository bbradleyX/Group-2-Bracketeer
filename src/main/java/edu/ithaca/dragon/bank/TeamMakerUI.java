package edu.ithaca.dragon.bank;

import java.util.Scanner;
//import edu.ithaca.dragon.bank.PlayerMakerUI;
import edu.ithaca.dragon.bank.Team;

public class TeamMakerUI {

    //This method runs UI for teamMaker that takes in a scanner, and then returns the team object
    public static Team runTeamMakerUI(Scanner scanner){
        System.out.println("---------------------\n");
        System.out.println("You are now creating a Team\n");

        System.out.println("Enter the Team name: ");
        String name = scanner.nextLine();
        while(!(Team.isValidName(name))){//calls the method isValidName so that the user enters a valid name for the team
            System.out.println("Error!");
            System.out.println("Please enter your Team name again: ");
            name = scanner.nextLine();
        }
        String teamName = name;
        Team newTeam = new Team(teamName);//Creates a new object of team with the user's team name

        return newTeam;
        

    }
    //This automatically runs the runTeamMakerUI as well as creates a new scanner so it multiply of scanners aren't being created
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        runTeamMakerUI(scanner);
        scanner.close();
    }

}
