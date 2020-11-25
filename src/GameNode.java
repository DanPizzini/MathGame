
import java.util.Random;

/**
 * This class controls the nodes in the game. It constructs the list and adds nodes on to the end of
 * the list
 * 
 * @author Dante Pizzini, Joseph Cambio
 *
 */
public class GameNode {

  private int number; // the number held within this node
  private GameNode next; // the next GameNode in the list, or null for the last node

  /**
   * creates a random number and puts it inside of a new node.
   * 
   * @param rng
   */
  public GameNode(Random rng) {// initializes number to random 1-9 value, and next to null
    int randInt = rng.nextInt(8); // create new random integer 0-8
    this.number = randInt + 1; // adds 1 so 1-9 is no accessible
    this.next = null; // sets the tail to point to null
  }

  /**
   * // accessor for the number field
   * 
   * @return
   */
  public int getNumber() {
    return this.number;
  }

  /**
   * // accessor for the next field
   * 
   * @return
   */
  public GameNode getNext() {
    return this.next;
  }

  /**
   * mutator for the next field
   * 
   * @param next
   */
  public void setNext(GameNode next) {
    this.next = next;
  }

  /**
   * this method applies implements the gameOperator
   * 
   * @param operator
   */
  public void applyOperator(GameOperator operator) {// (described below)
    if (getNext() != null) { // making sure we are not at the end of the list
      this.number = operator.apply(getNumber(), getNext().getNumber()); // applies the operator
      setNext(getNext().getNext()); // setNext is the node after the getNext node


    } else {
      throw new NullPointerException(); // throws a NullPointerException
    }
  }

}
