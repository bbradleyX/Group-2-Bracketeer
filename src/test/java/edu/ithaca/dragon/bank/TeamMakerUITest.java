package edu.ithaca.dragon.bank;

import java.util.Scanner;

 //How to Test the TeamMakeUI
 /*
    -----------------------------------Creating a Team Object--------------------------------------------
    
    For your team name: there are no Restrictions, enter anyname with Symbols.
    
*/

public class TeamMakerUITest extends TeamMakerUI{
    //Integration test the TeamMakerUI
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        //runTeamMakerUI method is in the TeamMakerUI class 
        runTeamMakerUI(scanner);
        scanner.close();
    }
}
