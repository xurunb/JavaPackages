package zhstructures;
import java.util.*;
/**
 * This is the interface describing the actions
 * on a simple queue.
 */
public interface ZHQueue<T> extends Iterable<T> {
  /**
   * empty() returns true if the Queue is empty.
   */
  public boolean empty();
  
  /**
   * getNumItems() returns the number of items in the Queue.
   */
  public int getNumItems();
  
  /**
   * enqueue(value) adds value to the back of the queue.
   * <p><b>Postcondition<b>The queue has a new item at its front.
   * </p><br>
   */
  public void enqueue(T value);
  
  /**
   * peek() returns the value at the front of the queue.
   * The queue is unchanged.
   * <p><b>Precondition: <b>The queue is not empty.
   * </p><br>
   */
  public T peek();
  
  /**
   * dequeue() returns the value at the front of the queue
   * and removes that value from the queue.
   * <p><b>Precondition: <b>The queue is not empty.</p><br>
   * <p><b>Postcondition: <b>The front item is removed and
   * the item enqueued just after the front item becomes  
   * the front item.
   */
  public T dequeue();
  
  /**
   * iterator() returns an Iterator on this queue.
   */
  public Iterator<T> iterator();
}