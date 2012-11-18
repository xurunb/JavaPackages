


package arraystack;

public interface Stack<Type>{
  public void push(Type value);
  public Type pop();
  public Type peek();
  public boolean empty();
}