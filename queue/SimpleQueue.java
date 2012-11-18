package queue;
/**
 * a interface used to represent a simple Queue
 * @author Xu, Runbo and Zurn, Andrew
 * @version Feb 14, 2011
 */
public interface SimpleQueue<T> {
  /**
   * will return true if the queue is empty, false if it has an object in the first node
   * @return boolean true if empty, false if occupied
   */
  public boolean empty();
  /**
   * adds an object to the back position of the list
   * @param value the value to be added to the node
   */
  public void enqueue(T value);
  /**
   * will return the value of the first object in the queue
   * @return T the first value in the queue
   */
  public T peek();
  /**
   * will remove the first object in the queue and return its value
   * @return the value of the first node in the queue
   */
  public T dequeue();
  
  public int size();
}