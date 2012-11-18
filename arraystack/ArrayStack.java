

package arraystack;
import java.util.*;
import java.io.*;
public class ArrayStack<Type>  implements Stack<Type>{
    private ArrayList<Type> stack;
    private int count;
    
    public ArrayStack(){
     stack=new ArrayList<Type>();
     count=0;
    }
    public void push(Type value) {
      stack.add(value);
      count++;
    }
    public Type pop() throws RuntimeException{
      if(count==0){
        throw new RuntimeException("Stack is empty");
      }
      Type temp=stack.get(stack.size()-1);
      stack.remove(stack.size()-1);
      count--;
      return temp;
    }
    public Type peek() throws RuntimeException {
      if(count==0){
        throw new RuntimeException("Stack is empty");
      }
      return stack.get(stack.size()-1); 
    }
    public boolean empty() {
      return (count==0);
    }
}