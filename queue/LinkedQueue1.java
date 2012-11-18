package queue;
import java.util.*;
import java.io.*;
public class LinkedQueue1<T> implements SimpleQueue<T> {
  private ArrayList<T> ls;
  public LinkedQueue1(){
    ls=new ArrayList<T>();
  }
  
  public void enqueue(T e){
   ls.add(e);
  }
  
  public T dequeue(){
    T temp=ls.get(0);
    ls.remove(0);
    return temp;
  }
  
  public boolean empty(){
    if(ls.size()==0){
     return true; 
    }
     return false;
  }
  
  public T peek(){
   return ls.get(0); 
  }
  
  public int size(){
   return ls.size(); 
  }
}