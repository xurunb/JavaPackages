package zhstructures;
/**
 * This is the interface describing the actions
 * on a simple stack.
 */
public interface ZHStack<T> {
  /**
   * empty() returns true if the Stack is empty.
   */
  public boolean empty();
  
  /**
   * push(value) adds value to the top of the stack.
   * <p><b>Postcondition<b>The stack has a new item at its top.
   * </p><br>
   */
  public void push(T value);
  
  /**
   * peek() returns the value at the top of the stack.
   * The stack is unchanged.
   * <p><b>Precondition: <b>The queue is not empty.
   * </p><br>
   */
  public T peek() throws ZHEmptyStackException;
  
  /**
   * pop() returns the value at the top of the stack.
   * and removes that value from the stack.
   * <p><b>Precondition: <b>The queue is not empty.</p><br>
   * <p><b>Postcondition: <b>The top item is removed and
   * the item pushed before the top item becomes the top
   * item.
   */
  public T pop() throws ZHEmptyStackException;
}