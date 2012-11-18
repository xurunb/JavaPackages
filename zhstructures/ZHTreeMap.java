package zhstructures;
import java.lang.RuntimeException.*;
public class ZHTreeMap<KeyType extends Comparable<KeyType>,ValueType> {
  /* A ZHTreeMap uses a BinarySearchTree<ZHCompPair<KeyType,ValueType>>
   * to hold the key-value pairs. */
  private ZHLinkedBinarySearchTree<ZHCompPair<KeyType,ValueType>> tree;
  /* keySet holds the set of keys which have been added. They must be
   * removed on removal. */
  private ZHTreeSet<KeyType> keySet;
  
  /**
   * The constructor creates a new empty ZHTreeMap by creating the
   * tree and set used to hold the information for the Map. */
  public ZHTreeMap() {
    tree=new ZHLinkedBinarySearchTree<ZHCompPair<KeyType,ValueType>>();
    keySet=new ZHTreeSet<KeyType>();
  }
  
  /**
   * get(key) returns the value associated with the key. It does it by
   * using the get method we have added to the ZHLinkedBinarySearchTree
   * and, then, returning the value in the returned pair.
   */
  public ValueType get(KeyType key) 
    throws IllegalStateException {
    if(key==null) 
      throw new IllegalStateException("Cannot get a null key.");
    ZHCompPair<KeyType,ValueType> temp=
      new ZHCompPair<KeyType,ValueType>(key);
    
    if(tree.get(temp).getValue()!=null){
      return tree.get(temp).getValue();}
    else{
      throw new IllegalStateException("This key has a null value");
    }
    
    //Use the tree get on temp and return the value from the
    //pair you get if it is not null.
    //return(null);
  }
  
  /**
   * put(key,value) places the association of key with value into
   * the Map. Note that it must also add key to the keySet.
   */
  public ValueType put(KeyType key, ValueType value) 
    throws IllegalStateException {
    if((key==null) || (value==null)) 
      throw new IllegalStateException("Cannot put a null into a TreeMap.");
    
    ValueType temp;  
    if(keySet.contains(key)){
      temp = this.get(key);
      tree.remove(new ZHCompPair<KeyType,ValueType>(key, temp));
      tree.add(new ZHCompPair<KeyType,ValueType>(key,value));
      return temp;
    }
    
    //else
    tree.add( new ZHCompPair<KeyType,ValueType> (key,value));
    keySet.add(key);
    return(null);
    
    //add the key to the keySet and, then, add the key-value pair to
    //the tree. Be sure to remember to get the OLD key-value pair returned
    //by the tree's put method so you can return that
    
  }
  
  /**
   * keySet() returns the set of keys in the Map.
   */
  public ZHTreeSet<KeyType> keySet() {
    return(keySet);
  }
  
  /**
   * containsKey(key) returns true if the key is already in the
   * TreeMap. It uses the contains method in tree.
   */
  public boolean containsKey(KeyType key) {
    return keySet.contains(key);
  }
  
  /**
   * remove(key) removes the association with key. It must also remove that
   * key from the keySet. As usual, you can create a pair with key as the 
   * key and null as the value and remove it. Then if the remove method 
   * from the tree is successful, remove the key from the keySet before
   * returning that the remove was successful.
   */
  public boolean remove(KeyType key) {
    ZHCompPair<KeyType,ValueType> temp=
      new ZHCompPair<KeyType,ValueType>(key);
    boolean bool = tree.remove(temp);
    if(bool){
      keySet.remove(key);
    }
    return bool;
    
    
    /* Use the tree's remove method but remember what boolean value it
     * returned since if it returned true you must remove key from 
     * keySet before returning that value. */
  }
}