/*
 * ZHLinkedBinarySearchTree.java
 */
package zhstructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class implementing the ZHBinarySearchTree interface as a ZHBinaryTreeStructure.
 * 
 * @author J. Andrew Holey and Lynn Ziegler
 * @version October 27, 2008
 */
public class ZHLinkedBinarySearchTree<ElementType extends Comparable<ElementType>>
  extends ZHBinaryTreeStructure<ElementType, ZHLinkedBinarySearchTree<ElementType>>
  implements ZHBinarySearchTree<ElementType> {
  
  private int count;
  
  private ElementType largerSmallest, smallerLargest;
  
  
  /**
   * Creates a new empty tree.
   */
  public ZHLinkedBinarySearchTree() {
    super();
    largerSmallest=null;
    smallerLargest=null;
    count=0;
  }
  
  public int size() {
    return(count);
  }
  
  /* (non-Javadoc)
   * @see zhstructures.ZHBinarySearchTree#contains(java.lang.Comparable)
   */
  @Override
  public boolean contains(ElementType element) {
    switch(this.state) {
      case EMPTY: return(false);
      case NOT_EMPTY: {
        int comparator=this.element.compareTo(element);
        if(comparator==0) return(true);
        else if(comparator<0) return(rightChild.contains(element));
        else return(leftChild.contains(element));
      }
      default: throw new IllegalStateException();
    }
  }
  
  /**
   * get(element) returns the version of this element that is actually
   * in the tree. It is almost identical to contains except that it 
   * returns null if the element is not in the tree and the actual 
   * element currently in the tree if the element matches one in the 
   * tree. This is useful for a tree map structure since the comparison
   * is done by a subpart of element and the other parts may differ.
   */
  public ElementType get(ElementType element) {
    switch(this.state) {
      case EMPTY: return(null);
      case NOT_EMPTY: {
        int comparator=this.element.compareTo(element);
        if(comparator==0) return(this.element);
        else if(comparator<0) return(rightChild.get(element));
        else return(leftChild.get(element));
      }
      default: throw new IllegalStateException();
    }
  }
  
  
  /* (non-Javadoc)
   * @see zhstructures.ZHBinarySearchTree#iterator()
   */
  @Override
  public Iterator<ElementType> iterator() {
    return this.inorderIterator();
  }
  
  /* (non-Javadoc)
   * @see zhstructures.ZHBinarySearchTree#add(java.lang.Comparable)
   */
  @Override
  public boolean add(ElementType element) {
    switch(this.state) {
      case EMPTY: { 
        this.state=ZHComponentState.NOT_EMPTY;
        this.element=element;
        this.leftChild=new ZHLinkedBinarySearchTree<ElementType>();
        this.rightChild=new ZHLinkedBinarySearchTree<ElementType>();
        count++;
        return(true);
      }
      case NOT_EMPTY: {
        int comparator=this.element.compareTo(element);
        if(comparator==0) return(false);
        else if(comparator<0){
          
          return(rightChild.add(element));
        }
        else{
          
          return(leftChild.add(element));
        }
      }
      default: throw new IllegalStateException();
    }
  }
  
  public ElementType getSL(){
    return smallerLargest; 
  }
  
  public ElementType getLS(){
    return largerSmallest; 
  }
  
  /**
   * put(element) is almost identical to add except that if a put 
   * is done and the element is already in the tree it is replaced. 
   * Instead of returning true or false, it returns the actual 
   * element that was added or the replaced value if a replacement
   * occurs.
   */
  
  //NOT Available!!!!!!
  public ElementType put(ElementType element) {
    switch(this.state) {
      case EMPTY: {
        //like add's EMPTY case except return null.
      }
      case NOT_EMPTY: {
        int comparator=this.element.compareTo(element);
        if(comparator==0) {
          /* Be sure to save the element currently in this tree
           * and, then, replace it with element. Finally, return
           * that element you have saved. */
          return(null);
        }
        /* The only changes from add in the other two cases are
         * that add is replaced with put. */
        else if(comparator<0) return(rightChild.put(element));
        else return(leftChild.put(element));
      }
      default: throw new IllegalStateException();
    }
  }
  
  /* (non-Javadoc)
   * @see zhstructures.ZHBinarySearchTree#remove(java.lang.Comparable)
   */
  @Override
  public boolean remove(ElementType element) {
    switch(this.state) {
      case EMPTY: return(false);
      case NOT_EMPTY: {
        int comparator=this.element.compareTo(element);
        if(comparator==0) {
          count--;
          if(leftChild.isEmpty()) {
            copyNodeToThis(rightChild);
          }
          else if(rightChild.isEmpty()) {
            copyNodeToThis(leftChild);
          }
          else { //both subtrees
            this.element=rightChild.removeAndReturnLeftmost();
          }
          return(true);
        }
        else if(comparator<0) 
          return(rightChild.remove(element));
        else //comparator>0
          return(leftChild.remove(element));
      }
      default: throw new IllegalStateException();
    }
  }
  
  /**
   * Removes and returns the leftmost element in this structure.
   * 
   * @return the former leftmost element in this structure
   * @throws NoSuchElementException if this structure is empty
   */
  protected ElementType removeAndReturnLeftmost() {
    switch(this.state) {
      case EMPTY: { //this should never occur
        throw new NoSuchElementException();
      }
      case NOT_EMPTY: {
        if(leftChild.isEmpty()) {
          this.state=ZHComponentState.EMPTY;
          ElementType temp=this.element;
          copyNodeToThis(rightChild);
          return(temp);
        }
        else return(leftChild.removeAndReturnLeftmost());
      }
      default: throw new IllegalStateException();
    }
  }
  
  /**
   * leftMost() returns the smallest item in this tree.
   */
  public ElementType leftMost() {
    switch(this.state) {
      case EMPTY: { //this should never occur
        throw new NoSuchElementException();
      }
      case NOT_EMPTY: {
        if(leftChild.isEmpty()) {
          return(this.element);
        }
        else return (leftChild.leftMost());
      }
      default: throw new IllegalStateException();
    }
  }
  /**
   * leftLargest() return the Largest item among those are smaller than the given item
   */
  public ElementType leftLargest(ElementType e){
    switch(this.state){
      case EMPTY:{
        throw new NoSuchElementException(); 
      }
      case NOT_EMPTY: {
        int comparator=this.element.compareTo(e);
        if(comparator==0){
          if(leftChild.isEmpty()){
           return smallerLargest; 
          }
          else{
           return leftChild.rightMost();
          }
        }
        else if(comparator<0) {
          smallerLargest=this.element;
          return(rightChild.leftLargest(e));
        }
        else {//comparator>0
          
          return(leftChild.leftLargest(e));
        }
      }
      default: throw new IllegalStateException();
    }
  }
  
  /**
   * rightSmallest() return the Smallest item among those are larger than given item
   */
  
  public ElementType rightSmallest(ElementType e){
    switch(this.state){
      case EMPTY:{
        throw new NoSuchElementException(); 
      }
      case NOT_EMPTY: {
        int comparator=this.element.compareTo(e);
        if(comparator==0){
          System.out.println(0);
          if(rightChild.isEmpty()){
            System.out.println("0"+largerSmallest);
           return largerSmallest; 
          }
          else{
           return rightChild.leftMost();
          }
        }
        else if(comparator<0){
          
          return(rightChild.rightSmallest(e));
        }
        else {//comparator>0
          System.out.println(this.element);
          largerSmallest=this.element;
          System.out.println(largerSmallest);
          return(leftChild.rightSmallest(e));
        }
      }
      default: throw new IllegalStateException();
    }
  }
  
  /**
   * rightMost() returns the largest item in this tree.
   */
  public ElementType rightMost() {
    switch(this.state) {
      case EMPTY: { //this should never occur
        throw new NoSuchElementException();
      }
      case NOT_EMPTY: {
        if(rightChild.isEmpty()) {
          return(this.element);
        }
        else return (rightChild.rightMost());
      }
      default: throw new IllegalStateException();
    }
  }
  protected void copyNodeToThis(ZHLinkedBinarySearchTree<ElementType> otherNode) {
    this.element    = otherNode.element;
    this.leftChild  = otherNode.leftChild;
    this.rightChild = otherNode.rightChild;
    this.state      = otherNode.state;
  }
  
}
