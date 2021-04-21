package edu.ithaca.dragon.bank;

import java.util.Scanner;

public class TeamUI {
    public static void main(String args[]){

        Scanner option = new Scanner(System.in);
        System.out.println("Enter a team name: ");
        String userTeamName = option.nextLine();
        while(!(Team.isValidName(userTeamName))){
            System.out.println("You entered in an invalid name!");
            System.out.println("Try again: ");
            userTeamName = option.nextLine();
        }

        Team newTeam = new Team(userTeamName);
        System.out.println("1. Add a player");
        System.out.println("2. Remove a player");
        System.out.println("3. Get player info");
        System.out.println("4. Get team info");
        
    }
}
