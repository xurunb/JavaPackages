package zhstructures;
import java.lang.RuntimeException.*;
public interface ZHMap<KeyType extends Comparable<KeyType>,ValueType> {
  
  
  /**
   * get(key) returns the value associated with the key. It does it by
   * using the get method we have added to the ZHLinkedBinarySearchTree
   * and, then, returning the value in the returned pair.
   */
  public ValueType get(KeyType key) throws IllegalStateException ;

  
  /**
   * put(key,value) places the association of key with value into
   * the Map. Note that it must also add key to the keySet.
   */
  public ValueType put(KeyType key, ValueType value)
                              throws IllegalStateException ;
    
  
  /**
   * keySet() returns the set of keys in the Map.
   */
  public ZHTreeSet<KeyType> keySet() ;
  
  /**
   * containsKey(key) returns true if the key is already in the
   * TreeMap. It uses the contains method in tree.
   */
  public boolean containsKey(KeyType key);
  
  /**
   * remove(key) removes the association with key. It must also remove that
   * key from the keySet. As usual, you can create a pair with key as the 
   * key and null as the value and remove it. Then if the remove method 
   * from the tree is successful, remove the key from the keySet before
   * returning that the remove was successful.
   */
  public boolean remove(KeyType key);
}