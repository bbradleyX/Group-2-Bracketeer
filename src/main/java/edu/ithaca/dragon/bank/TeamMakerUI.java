package edu.ithaca.dragon.bank;

import java.util.Scanner;

public class TeamMakerUI {

    public static boolean isIDVaild(String ID){
        while(ID.length() != 4){
            return false;
        }
        return true;
    }

    public static void runTeamMakerUI(Scanner scanner){
        System.out.println("---------------------\n");
        System.out.println("You are now creating a Team\n");

        System.out.println("Enter the player name: ");
        String name = scanner.nextLine();
        while(Team.isValidName(name)){
            System.out.println("Error!");
            System.out.println("Please enter your player name again: ");
         name = scanner.nextLine();
        }

        String userName = name; 

        System.out.println("Enter player's ID: ");
        String id = scanner.nextLine();
        while(TeamMakerUI.isIDVaild(id)){
            System.out.println("Error!");
            System.out.println("Please enter player's ID again: ");
            id = scanner.nextLine();
        }
        String userID = id;

    }
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        runTeamMakerUI(scanner);
        scanner.close();
    }

    public static void runTeamMakerUI(int nextInt) {
    }
}
