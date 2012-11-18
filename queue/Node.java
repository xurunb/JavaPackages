/*
 *File: Node.java 
 */
package queue;
/**
 * a class to construct a node used in a LinkedList structure
 * @author Xu, Runbo and Zurn, Andrew
 * @version Feb 14, 2011
 */
public class Node<T> {
  /**
   * a node that is used to represent the next node int he list
   */
  private Node<T> next;
  /**
   * a object T that will be used to hold the value in the node
   */
  private T value;
  /**
   * will create a node with the link to the next node in the list, and a value
   * @param next the position of the next node
   * @param value the value of this node
   */
  public Node(Node<T> next,T value) {
    this.next=next;
    this.value=value;
  }
  /**
   * returns the next node location in the list
   * @return T the next node
   */
  public Node<T> getNext() {
    return(next);
  }
  /**
   * sets the next node in the list to the location described in the parameter
   * @param next the node that will be the next new node in the list
   */
  public void setNext(Node<T> next) {
    this.next=next;
  }
  /**
   * will return the value of a node
   * @return T the value of the node
   */
  public T getValue() {
    return(value);
  }
}
