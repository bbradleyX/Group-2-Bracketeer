package edu.ithaca.dragon.bank;

import java.util.Scanner;
//import edu.ithaca.dragon.bank.PlayerMakerUI;
import edu.ithaca.dragon.bank.Team;

public class TeamMakerUI {

    public static Team runTeamMakerUI(Scanner scanner){
        System.out.println("---------------------\n");
        System.out.println("You are now creating a Team\n");

        System.out.println("Enter the Team name: ");
        String name = scanner.nextLine();
        while(!(Team.isValidName(name))){
            System.out.println("Error!");
            System.out.println("Please enter your Team name again: ");
            name = scanner.nextLine();
        }
        String teamName = name;
        Team newTeam = new Team(teamName);

        return newTeam;
        

    }
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        runTeamMakerUI(scanner);
        scanner.close();
    }

}
