package edu.ithaca.dragon.bank;

import java.util.Scanner;

 //How to Test the PlayerMakeUI
 /*
    -----------------------------------Making a Player--------------------------------------------
    
    For your name: there are no Restrictions, enter anyname with Symbols.
    For ID: try entering a letter or less than four number. You should received a message saying please reenter. Enter an ID with four number, like 1234.
    For startTime: try enter a number greater than 24 or a letter or negative number or zero. You should received a message saying please reenter. Enter a start time between the restrictions mentioned, like 8 or 2.23 or 4.0 
    For endTime: try enter a number greater than 24 or a letter or negative number or zero. You should received a message saying please reenter. Enter a end time between the restrictions mentioned, like 6 or 5.03 or 7.2 
    
    -----------------------------------Modify Player Schedule --------------------------------------------
    Asking you if you want to modify Schedule If you don't enter yes or no You should received a message saying please reenter.
    For startTime: try enter a number greater than 24 or a letter or negative number or zero. You should received a message saying please reenter. Enter a start time between the restrictions mentioned, like 20 or 1.11 or 4.0
    For endTime: try enter a number greater than 24 or a letter or negative number or zero. You should received a message saying please reenter. Enter a end time between the restrictions mentioned, like 23 or 10.21 or 12.4 

    */
class PlayerMakerUITest extends PlayerMakerUI{
    //Integration test the PlayerMakerUI and the Player methods
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        //runUI method is in the PlayerMakerUI class 
        runUI(scanner);
        runModifyScheduleUI(scanner);
        scanner.close();
    }
    
}