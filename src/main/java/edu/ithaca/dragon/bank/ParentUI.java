package edu.ithaca.dragon.bank;

import java.util.Scanner;

public class ParentUI {
    public static void main(String args[]) {
        Scanner option = new Scanner(System.in);
        //int userOption = option.nextInt();
        
        System.out.println("Select an option or hit zero: ");
        System.out.println("1. Create a new player");
        System.out.println("2. Create a new team");
        System.out.println("3. Create a new tournament");
        int userOption = option.nextInt();

        while(userOption >= 1 && userOption <= 3){
            if( userOption == 1){
                PlayerUI.runUI();
            }

            else if(userOption == 2){

            }

            System.out.println("Select an option or hit zero: ");
            System.out.println("1. Create a new player");
            System.out.println("2. Create a new team");
            System.out.println("3. Create a new tournament");
            userOption = option.nextInt();
        }
     }
    }
