package queue;
/**
 * an exception class to be used in the implementation of queue
 * @author Xu, Runbo and Zurn, Andrew
 * @version Feb 14, 2011
 */
public class EmptyQueueException extends RuntimeException {
  /**
   * will be thrown with a message
   * @param message the message passed back to the exception thrown
   */
  public EmptyQueueException(String message){
    super(message);
  }
  
  /**
   * will be thrown without a message
   */
    public EmptyQueueException(){
      super();
    }
}