package edu.ithaca.dragon.bank;

import java.io.IOException;
import java.util.Scanner;

public class ParentUI {
    static Scanner option;
    public static void main(String args[]) throws IOException {
        option = new Scanner(System.in);
        //int userOption = option.nextInt();
        
        System.out.println("Select an option or hit zero: ");
        System.out.println("1. Create a new player");
        System.out.println("2. Create a new team");
        System.out.println("3. Create a new tournament");
        int userOption = option.nextInt();

        while(userOption >= 1 && userOption <= 3){
            if( userOption == 1){
                PlayerUI.runUI(option);
            }

            else if(userOption == 2){
                System.out.println("Enter a team name: ");
                String userTeamName = option.nextLine();
                while(!(Team.isValidName(userTeamName))){
                    System.out.println("You entered in an invalid name!");
                    System.out.println("Try again: ");
                    userTeamName = option.nextLine();
                }
                Team newTeam = new Team(userTeamName);
                
            }

            else if(userOption == 3){
                CoordinatorUI.runUI(option);
            }

            System.out.println("Select an option or hit zero: ");
            System.out.println("1. Create a new player");
            System.out.println("2. Create a new team");
            System.out.println("3. Create a new tournament");
            userOption = option.nextInt();
            // System.out.println(System.in.available());
        }

        option.close();
     }
    }
