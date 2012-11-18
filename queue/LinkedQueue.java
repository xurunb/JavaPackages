/*
 * File:  LinkedQueue.java
 */
package queue;

/**
 * Creates an empty LinkedQueue implementing the SimpleQueue interface.
 * @author Xu, Runbo and Zurn, Andrew
 * @version Feb 14, 2011
 */
public class LinkedQueue<T> implements SimpleQueue<T> {
  private int count;
  /**
   * the first and last nodes in the queue
   */
  private Node<T> front,back;
  //private ArrayLIst< queue;
  
  /**
   * creates an empty LinkedQueue
   */
  public LinkedQueue() {
    front=null;
    back=null;
    count=0;
  }
  
  /**
   * returns a true if the queue is empty
   * @return boolean true if the first node is empty
   */
  public boolean empty() {
    return(front==null);
  }
  
  /**
   * places an object at the end of the queue
   * <b>post:</b>Will create an object in the first position of the queue, otherwise will add the object to the end of the queue
   * @param value the object to be placed at the end
   */
  public void enqueue(T value) {
    //implement enqueue with the linked nodes.
    Node<T> temp=new Node<T>(null, value);
    if(back==null){
      if(front==null){
        front=temp; 
      }
      else{
        back=temp;
        front.setNext(back);
      }
    }
    else{ 
      back.setNext(temp);
      back=temp;
    }
    count++;
  }
  
  /**
   * removes an object from the front of the queue and returns the value of its node 
   * <b>pre:</b> there must be an object within the queue, otherwise an exception will be thrown
   * <b>post:</b> will remove the front object, and move the queue forward
   * @return T the value that will be returned from the node
   * @throws EmptyQueueException thrown if the queue is empty
   */
  public T dequeue() throws EmptyQueueException {
    Node<T> temp;
    if(front==null){
      throw new EmptyQueueException();
    }
    else{
      temp=front;
      front=front.getNext();
    }
    count--;
    return temp.getValue();
    /* dequeue must remove the front thing and, then,
     * return the value that was in the front node. 
     * If the queue is empty it must throw an exception. */
  }
  
  /**
   * returns the value of the first node
   * <b>pre:</b> there must be an object within the queue, otherwise an exception will be thrown
   * @return T the value of the first node
   */
  public T peek() throws EmptyQueueException {
    /* peek must return the value that was in the front node. 
     * If the queue is empty it must throw an exception. 
     */
    if(front==null){
      throw new EmptyQueueException();
    }
    return(front.getValue());
  }
  
  public int size(){
   return count; 
  }
}