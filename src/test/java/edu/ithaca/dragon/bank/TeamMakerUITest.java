package edu.ithaca.dragon.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

 //How to Test the TeamMakeUI
 /*
    -----------------------------------Creating a Team Object--------------------------------------------
    
    For your team name: there are no Restrictions, enter anyname with Symbols.
    
*/

public class TeamMakerUITest extends TeamMakerUI{
    //Integration test the TeamMakerUI
    @Test
    static
    void runTeamMakerUITest(String TeamName,Team teamTest){
        //runTeamMakerUI method is in the TeamMakerUI class 
        assertEquals(TeamName,teamTest.getTeamName());
    }
    //This automatically runs the runTeamMakerUI as well as creates a new scanner so it multiply of scanners aren't being created
   public static void main(String args[]){
       Team teamTest = runTeamMakerUI();
        runTeamMakerUITest(teamTest.getTeamName(),teamTest);
    } 
}
