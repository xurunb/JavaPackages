/*
 * ZHLinkedBinarySearchTree.java
 */
package zhstructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class implementing the ZHBinarySearchTree interface as a ZHBinaryTreeStructure.
 * 
 * @author J. Andrew Holey and <your name here>
 * @version October 27, 2008
 */
public class ZHLinkedBinarySearchTree<ElementType extends Comparable<ElementType>>
  extends ZHBinaryTreeStructure<ElementType, ZHLinkedBinarySearchTree<ElementType>>
  implements ZHBinarySearchTree<ElementType> {
  
  /**
   * Creates a new empty tree.
   */
  public ZHLinkedBinarySearchTree() {
    super();
  }
  
  /* (non-Javadoc)
   * @see zhstructures.ZHBinarySearchTree#contains(java.lang.Comparable)
   */
  @Override
  public boolean contains(ElementType element) {
    // fill in your code here
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
    // fill in your code here
  }
  
  /* (non-Javadoc)
   * @see zhstructures.ZHBinarySearchTree#remove(java.lang.Comparable)
   */
  @Override
  public boolean remove(ElementType element) {
    // fill in your code here
  }
  
  /**
   * Removes and returns the leftmost element in this structure.
   * 
   * @return the former leftmost element in this structure
   * @throws NoSuchElementException if this structure is empty
   */
  protected ElementType removeAndReturnLeftmost() {
    // fill in your code here
  }
  
  protected void copyNodeToThis(ZHLinkedBinarySearchTree<ElementType> otherNode) {
    this.element    = otherNode.element;
    this.leftChild  = otherNode.leftChild;
    this.rightChild = otherNode.rightChild;
    this.state      = otherNode.state;
  }
  
}
