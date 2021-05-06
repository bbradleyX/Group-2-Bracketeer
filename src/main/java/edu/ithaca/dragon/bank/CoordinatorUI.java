/**
 * CoordinatorUI Algorithm
 * 1. Create Scanner object
 * 2. Create Coordinator object
 * 3. if (tournaments.size == 0)
 *      print("There are currently no running tournaments. Would you like to create one?")
 *      if (yes)
 *          create new tournament
 *      else
 *          close UI
 * 4. while (tournaments.size > 0)
 *      print(Select an option:)
 *      print(1. Create a new tournament)
 *      print(2. Update a tournament in progress)
 *      print(3. Close out all tournaments)
 *      scanner.nextInt
 * 5. if (Option 1)
 *      create new tournament
 *      back to menu
 * 6. if (Option 2)
 *      print list of tournaments with numbers
 *      scanner.nextInt to select desired tournament
 *      while (updateTournament == true)
 *          print(1. Create a team)
 *          print(2. Remove a team)
 *          print(3. Add players to a team)
 *          print(4. Remove players from a team)
 *          print(5. Manage time conflicts)
 *          print(6. Create a round)
 *          print(7. Update a round)
 *          scanner.nextInt to select desired action
 * 7. if (Option 3)
 *      close UI
 */
package edu.ithaca.dragon.bank;

import java.util.ArrayList;
import java.util.Scanner;

public class CoordinatorUI {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        Coordinator coordinator = new Coordinator("0000");

        boolean runProgram = true;
        while (runProgram){
            if(coordinator.)
        }
    }