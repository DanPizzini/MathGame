import java.util.Random;

/**
 * 
 * tests the math game
 * 
 * @author Dante Pizzini, Joseph Cambio
 *
 */
public class GameTests {
  /**
   * runs each test method
   * 
   * @param args
   */
  public static void main(String[] args) {
    int fails = 0;
    if (!operandTest1()) { // each test tests a specific aspect of the game
      System.out.println(
          "Test 1 failed: GameOperators '+' and '-' have a bug in the applyOperator method");
      // prints out failure message in the console if test fails
      fails++; // counts the number of failed tests
    } else {
      System.out.println("Test 1 Passed: GameOperators '-' and '+' working correctly");
      // if tests does not fail, outputs that test passed in the console
    }
    if (!operandTest2()) {
      System.out.println(
          "Test 2 failed: GameOperators '/' and '&' have a bug in the applyOperator method");
      fails++;
    } else {
      System.out.println("Test 2 Passed: GameOperators '/' and '&' working correctly");
    }
    if (!operandTest3()) {
      System.out.println("Test 3 failed: GameOperator 'x' has a bug in the applyOperator method");
      fails++;
    } else {
      System.out.println("Test 3 Passed: GameOperator 'x' working correctly");
    }

    if (!gameNodeTest1()) {
      System.out.println(
          "Test 4 failed: GameNode is not between 1 and 9 or setNext is not properly working");
      fails++;
    } else {
      System.out
          .println("Test 4 Passed: GameNode is between 1 and 9 and setNext is properly working");
    }
    if (!gameNodeTest2()) {
      System.out.println(
          "Test 5 failed: GameNode is not between 1 and 9 or applyOperator is not properly working");
      fails++;
    } else {
      System.out.println(
          "Test 5 Passed: GameNode is between 1 and 9 and applyOperator is properly working");
    }
    if (!gameListTest1()) {
      System.out.println("Test 6 failed: GameList contains method contains an error");
      fails++;
    } else {
      System.out.println("Test 6 Passed: GameList contains method is working properly");

    }
    if (fails == 0) { // if there are no fails. all tests passed is printed on the console
      System.out.println("All Tests Passed");
    }
  }

  /**
   * Tests the operand for addition and subtraction operations
   * 
   * @return
   */
  public static boolean operandTest1() {
    GameList gameList = new GameList(); // creates 5 test nodes
    GameNode testNode1 = new GameNode(new Random());
    GameNode testNode2 = new GameNode(new Random());
    GameNode testNode3 = new GameNode(new Random());
    GameNode testNode4 = new GameNode(new Random());
    GameNode testNode5 = new GameNode(new Random());

    gameList.addNode(testNode1); // add nodes1 to list
    testNode1.setNext(testNode2); // sets the next node2

    gameList.addNode(testNode2); // adds node2 to list
    testNode2.setNext(testNode3); // sets next node3

    gameList.addNode(testNode3); // adds node3 to list
    testNode3.setNext(testNode4); // sets next node4

    gameList.addNode(testNode4); // adds node4 to list
    testNode4.setNext(testNode5); // sets next node5

    gameList.addNode(testNode5); // adds node5 to list
    testNode5.setNext(null); // sets next node as null

    gameList.applyOperatorToNumber(testNode1.getNumber(), GameOperator.getFromChar('-'));
    // implements applyOperatorToNumber method to the the test node for subtraction

    if (!gameList.contains(testNode1.getNumber())) {
      return false; // checks to see if there is a number within the test node
    }

    gameList.applyOperatorToNumber(testNode1.getNumber(), GameOperator.getFromChar('+'));
    // implements applyOperatorToNumber method to the the test node for addition
    if (!gameList.contains((testNode1.getNumber()))) {
      return false; // returns false if the correct number is in the test node
    }
    return true; // returns true if all if statements are true
  }

  /**
   * test the operand of subtraction and concatenation
   * 
   * @return
   */
  public static boolean operandTest2() {
    GameList gameList = new GameList(); // creates a games list and 5 nodes
    GameNode testNode1 = new GameNode(new Random());
    GameNode testNode2 = new GameNode(new Random());
    GameNode testNode3 = new GameNode(new Random());
    GameNode testNode4 = new GameNode(new Random());
    GameNode testNode5 = new GameNode(new Random());

    gameList.addNode(testNode1); // adds each node to the list
    testNode1.setNext(testNode2); // setNext to the next new node

    gameList.addNode(testNode2);
    testNode2.setNext(testNode3);

    gameList.addNode(testNode3);
    testNode3.setNext(testNode4);

    gameList.addNode(testNode4);
    testNode4.setNext(testNode5);

    gameList.addNode(testNode5);
    testNode5.setNext(null);

    gameList.applyOperatorToNumber(testNode1.getNumber(), GameOperator.getFromChar('/'));
    //// implements applyOperatorToNumber method to the the test node for division
    if (!gameList.contains(testNode1.getNumber())) {
      return false; // returns false if not a viable number
    }

    gameList.applyOperatorToNumber(testNode1.getNumber(), GameOperator.getFromChar('&'));
    // implements applyOperatorToNumber method to the the test node for concatenation
    if (!gameList.contains((testNode1.getNumber()))) {
      return false; // returns false if not a viable number
    }
    return true; // if all tests pass, tests returns true
  }

  /**
   * test the operand multiplication
   * 
   * @return
   */
  public static boolean operandTest3() {
    GameList gameList = new GameList(); // creates a games list with 5 game nodes
    GameNode testNode1 = new GameNode(new Random());
    GameNode testNode2 = new GameNode(new Random());
    GameNode testNode3 = new GameNode(new Random());
    GameNode testNode4 = new GameNode(new Random());
    GameNode testNode5 = new GameNode(new Random());

    gameList.addNode(testNode1); // adds the nodes to the list
    testNode1.setNext(testNode2); // sets the game nodes tail to the next game node

    gameList.addNode(testNode2);
    testNode2.setNext(testNode3);

    gameList.addNode(testNode3);
    testNode3.setNext(testNode4);

    gameList.addNode(testNode4);
    testNode4.setNext(testNode5);

    gameList.addNode(testNode5);
    testNode5.setNext(null);

    gameList.applyOperatorToNumber(testNode1.getNumber(), GameOperator.getFromChar('x'));
    // implements applyOperatorToNumber method to the the test node for concatenation
    if (!gameList.contains(testNode1.getNumber())) {
      return false; // if node does not contain viable number return false
    }
    return true; // if all tests pass return true
  }

  /**
   * 
   * 
   * @return
   */
  public static boolean gameNodeTest1() {
    GameNode testNode1 = new GameNode(new Random()); // creates two test nodes
    GameNode testNode2 = new GameNode(new Random());

    if (testNode1.getNumber() < 1 || testNode1.getNumber() > 9) {
      return false; // makes sure node contains number 1-9
    }
    if (testNode2.getNumber() < 1 || testNode2.getNumber() > 9) {
      return false; // makes sure node contains number 1-9
    }

    testNode1.setNext(testNode2); // sets node two after node one

    if (testNode1.getNext() != testNode2) {
      return false; // makes sure the node 2 is after node 1 in the list
    }
    return true;
  }

  /**
   * makes sure operand subtraction works correctly
   * 
   * @return
   */
  public static boolean gameNodeTest2() {
    GameNode testNode1 = new GameNode(new Random()); // creates two nodes
    GameNode testNode2 = new GameNode(new Random());
    int testInt = testNode1.getNumber() - testNode2.getNumber(); // subtracts the two nodes

    if (testNode1.getNumber() < 1 || testNode1.getNumber() > 9) {
      return false; // makes sure nodes contain number 1-9
    }
    if (testNode2.getNumber() < 1 || testNode2.getNumber() > 9) {
      return false;
    }

    testNode1.setNext(testNode2); // sets node one after node 2
    testNode1.applyOperator(GameOperator.getFromChar('-')); // applies the operand subtraction

    if (testNode1.getNumber() != testInt) { // checks to see if the operand does the same thing as
                                            // subtraction
      return false;
    }



    return true;
  }

  /**
   * checks to see if each node in the list contains a number
   * 
   * @return
   */
  public static boolean gameListTest1() {
    GameList gameList = new GameList(); // creates games list and 3 new nodes
    GameNode testNode1 = new GameNode(new Random());
    GameNode testNode2 = new GameNode(new Random());
    GameNode testNode3 = new GameNode(new Random());


    gameList.addNode(testNode1); // adds nodes to the list
    testNode1.setNext(testNode2); // sets nodes in order

    gameList.addNode(testNode2);
    testNode2.setNext(testNode3);

    gameList.addNode(testNode3);
    testNode3.setNext(null);

    if (!gameList.contains(testNode1.getNumber())) {
      return false; // checks to see if each node actually contains a number
    }
    if (!gameList.contains(testNode2.getNumber())) {
      return false;
    }
    if (!gameList.contains(testNode3.getNumber())) {
      return false;
    }



    return true;
  }
}

