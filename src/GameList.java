/**
 * this is the class constructs a game list and modifies and adds new nodes to the list
 * 
 * @author Dante Pizzini, Joseph Cambio
 *
 */
public class GameList {


  private GameNode list; // reference to the first GameNode in this list

  /**
   * constructs the list as null
   * 
   */
  public GameList() {
    list = null;
  } // initializes list to start out empty

  /**
   * this methods adds nodes to the list
   * 
   * @param newNode
   */
  public void addNode(GameNode newNode) {
    if (this.list == null) { // checks to see if the instance of list is null
      this.list = newNode; // the list equals the game node newNode
    } else { // if the list is all ready full
      GameNode lastNode = this.list; // else the last node in the list = this list
      while (lastNode.getNext() != null) { // while last node is not the actual last node
        lastNode = lastNode.getNext(); // moves the node to the end of the list
      }
      lastNode.setNext(newNode); // this last node then equals the new node

      if (lastNode.getNext() == null) { // if last node
        this.list = lastNode; // the new node is now the last node
      }
    }

  } // adds the new node to the end of this list

  /**
   * this method checks if a node equals a specific number
   * 
   * @param number
   * @return
   */
  public boolean contains(int number) {
    GameNode lastNode = this.list; // initializes lastNOde
    if (lastNode.getNumber() == number) { // if lastNode equals number this method returns true
      return true;
    }
    while (lastNode.getNext() != null) { // this while loops parses through the list to find a match
      if (lastNode.getNumber() == number) {
        return true; // returns true if the last node equals the number
      }
      lastNode = lastNode.getNext(); // moves the lastNode to the next node

      if (lastNode.getNumber() == number) { // if the last node equals the number this method
                                            // returns true
        return true;
      }
    }

    return false; // returns false if the list does not contain the number

  } // only returns true when this list contains a node with the specified number

  /**
   * displays the node in the correct format
   */
  public String toString() {
    String s = ""; // initializes the string s
    GameNode displayNode = this.list; // initializes display node as this instance of list

    while (displayNode != null) { // making sure displayNode is an actual node
      s += "" + displayNode.getNumber() + ""; // displays number
      if (displayNode.getNext() != null) { // formats the arrows to make sure they point to a node
        displayNode = displayNode.getNext();
        s += " -> "; // adds to the string
      }
      if (displayNode.getNext() == null) { // once the end of the list is reached
        // the string is formated to point to the end
        s += displayNode.getNumber() + " -> END";
        return s; // returns the string
      }
    }
    return s; // return the string

  } // returns a string with each number in the list separated by " -> "s, and ending with " -> END"

  /**
   * this method applies an operator to the number selected
   * 
   * @param number
   * @param operator
   */
  public void applyOperatorToNumber(int number, GameOperator operator) {
    GameNode lastNode = this.list; // initializes

    if (lastNode.getNumber() == number) { // if first node equals number applyOperated method is
                                          // used
      lastNode.applyOperator(operator);

      this.list = lastNode; // this list is then set as lastNode after the operator is applied
      return;
    }
    while (lastNode.getNext() != null) { // parses through the list and checks for a node that
                                         // matches the number
      lastNode = lastNode.getNext(); // changes the lastNode

      if (lastNode.getNumber() == number) { // if statement checks to see if number is the same as
                                            // node
        lastNode.applyOperator(operator); // applies the operator

        return;
      }

    }
    return;
  }
}
