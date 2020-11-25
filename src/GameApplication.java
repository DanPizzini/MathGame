//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: (P06 MATH GAME)
// Files: (GameList.java, GameNode.java, GameOperator.java, GameTest.java)
// Course: (300, Fall, 2018)
//
// Author: (Dante Pizzini)
// Email: (pizzini@wisc.edu)
// Lecturer's Name: (Gary Dahl)
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: (Joseph Cambio)
// Partner Email: (jcambio@wisc.edu)
// Partner Lecturer's Name: (Gary Dahl)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// __X_ Write-up states that pair programming is allowed for this assignment.
// __X_ We have both read and understand the course Pair Programming Policy.
// __X_ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: (None)
// Online Sources: (None)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////



import java.util.Random;
import java.util.Scanner;



/**
 *
 * this is the driver for the application
 * 
 * @author Dante Pizzini, Joseph Cambio
 *
 */
public class GameApplication {
  private static Random rng;
  private static int goal;

  /**
   * the main creates the list from the methods and then runs the the game
   * 
   * @param args
   */
  public static void main(String[] args) {
    rng = new Random(); // initializes the parameters
    int i = 0;
    goal = rng.nextInt(89) + 10; // creates a random goal 1 -99
    GameList gameList = new GameList(); // creates the game list

    for (int j = 0; j < 7; j++) { // creates seven nodes and adds them to the game list
      gameList.addNode(new GameNode(rng));
    }

    Scanner userIn = new Scanner(System.in); // creates a scanner for user input

    System.out.println("Goal: " + goal + " Moves Taken: " + i); // prints out the user interface
    System.out.println("Puzzle: " + gameList.toString());
    System.out.println("Number and Operation " + GameOperator.ALL_OPERATORS + " to Apply: ");

    String command = "begin";

    while (!command.equalsIgnoreCase("quit")) { // while the user has not implemented the quit
                                                // method the while loop will run
      command = userIn.nextLine();

      if (command.equalsIgnoreCase("quit")) {
        break; // breaks out of the while loop
      }
      try {
        String operation = command.trim(); // gets rid of the spaces in the string
        char operationMath = operation.charAt(operation.length() - 1); // picks node at correct
                                                                       // index location
        int operationNumber = Integer.parseInt(operation.substring(0, operation.length() - 1));


        if (gameList.contains(operationNumber)) { // checks to see if games list has the opperations
                                                  // number
          i++; // i is incremented
          gameList.addNode(new GameNode(rng)); // adds new node to the game list
          gameList.applyOperatorToNumber(operationNumber, GameOperator.getFromChar(operationMath));
        } // applies operator to the number chosen

      }


      catch (NumberFormatException e) { // catches number format exception if a incorrect character
                                        // is entered
        System.out.println("WARNING: Invalid input, please try again."); // prints feed back to the
                                                                         // console
      }

      if (gameList.contains(goal)) { // parses the games list to see if it contains the goal
        System.out.println("Congratulations, you won in " + i + " moves."); // sends a message that
                                                                            // player one in "i"
                                                                            // many moves
        System.out.println("Solution: " + gameList.toString());
        break; // prints the solution
      }

      System.out.println("Goal: " + goal + " Moves Taken: " + i); // reprints the game lists each
                                                                  // move
      System.out.println("Puzzle: " + gameList.toString());
      System.out.println("Number and Operation " + GameOperator.ALL_OPERATORS + " to Apply: ");

    }

  }

}
