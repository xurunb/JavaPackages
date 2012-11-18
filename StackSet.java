import zhstructures.*;
import java.util.*;
public class StackSet<T> extends ZHLinkedStack<T> implements ZHSet<T> {
  
  /**
   * Adds the specified element to this set if it is not already
   * present as determined by the contains() method.
   * If this set already contains the element, the call leaves the
   * set unchanged and returns false.
   */
  public boolean add(T element) {
    if(contains(element)) return false;
    else push(element);
    return true;//your code goes here
  }
  
  /**
   * isEmpty() just uses the ZHLinkedStack empty() method.
   */
  public boolean isEmpty() {
    return(empty());
  }
  
  
  /**
   * Removes the specified element from this set if it is present,
   * that is, if an equal element is present as determined by the
   * contains() method.
   * Use the iterator() function for ZHLinkedStack. iterator()
   * returns an Iterator<T>() which has a remove() method. You
   * need to use the while(it.hasNext()) and the it.next() 
   * methods as well as the it.remove() method to do this.
   */
  public boolean remove(T element) {
    Iterator<T> it=this.iterator();
    while(it.hasNext()) {
      //fill it in
      T value=it.next();
      if(value.equals(element)){
       it.remove();
       return (true);
      }
    }
    return(false);
  }
  
  /**
   * Returns a new set that is the intersection of this set and
   * otherSet. That is, it returns a set that contains exactly 
   * those elements contained both in this set and otherSet.
   */
  public ZHSet<T> intersection(ZHSet<T> otherSet) {
    StackSet<T> temp=new StackSet<T>();
    //your code
    return(temp);
  }
  
  
  
  /**
   * Returns a new set that is the asymmetric difference of this set
   * and otherSet. That is, it returns a set that contains the 
   * elements of this set that are not contained in otherSet.
   */
  public ZHSet<T> difference(ZHSet<T> otherSet) {
    StackSet<T> temp=new StackSet<T>();
    for(T value: this){
     temp.add(value); 
    }
    for(T value: otherSet){
    temp.remove(value);                       
    }
    //your code
    return(temp);
  }
  
  /**
   * Returns a new set that is the union of this set and otherSet.
   * That is, it returns a set that contains all elements contained
   * in this set, otherSet or both.
   */
  public ZHSet<T> union(ZHSet<T> otherSet) {
    StackSet<T> temp=new StackSet<T>();
    for(T value:otherSet){
      temp.add(value);
    }
    for(T value: this){
     temp.add(value); 
    }
    //your code
    return(temp);
  }
  
  /**
   * symmetricDifference(otherSet) returns the set consisting
   * of all things in this set but not in otherSet and things
   * in otherSet that are not in this set.
   */
  public ZHSet<T> symmetricDifference(ZHSet<T> otherSet) {
    StackSet<T> temp=new StackSet<T>();
    //your code
    return(temp);
  }
  
  /**
   * Returns true if the specified potential subset is a subset of
   * this set.
   */
  public boolean subset(ZHSet<T> potentialSubset) {
    //your code
    return(true);
  }
  
  /**
   * dumpIt() is just a way to look at the StackSet at any time.
   * It is useful as a testing tool.
   */
  public void dumpIt() {
    for(T value:this) {
      System.out.print("|"+value);
    }
    System.out.println("|");
  }
}