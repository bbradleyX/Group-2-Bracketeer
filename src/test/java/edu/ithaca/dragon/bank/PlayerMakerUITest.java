package edu.ithaca.dragon.bank;

import java.util.Scanner;

 //How to Test the PlayerMakeUI
 /*
    -----------------------------------Making a Player--------------------------------------------
    
    For your name: there are no Restrictions 
    For ID: try entering a letter or less than four number. You should received a message saying please reenter.
    For startTime: try enter a number greater than 24 or a letter or negative number or zero. You should received a message saying please reenter.
    For endTime: try enter a number greater than 24 or a letter or negative number or zero. You should received a message saying please reenter.
    
    -----------------------------------Modify Player Schedule --------------------------------------------
    Asking you if you want to modify Schedule If you don't enter yes or no You should received a message saying please reenter.
    For startTime: try enter a number greater than 24 or a letter or negative number or zero. You should received a message saying please reenter.
    For endTime: try enter a number greater than 24 or a letter or negative number or zero. You should received a message saying please reenter.

    */
class PlayerMakerUITest extends PlayerMakerUI{
    //Integration test the PlayerMakerUI and the Player methods
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        //runUI method is in the PlayerMakerUI class 
        runUI(scanner);
        scanner.close();
    }
    
}