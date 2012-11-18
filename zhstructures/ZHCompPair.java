package zhstructures;
/**
 * ZHCompPair is a class that contains an association between
 * a key and a value. It allows you to create a key->null
 * pair or a key->value pair depending on the constructor you
 * use. It can also get either the key or the value and set
 * the value if you like. It implements Comparable so it has
 * the required compareTo method as well as an equals method.
 */
public class ZHCompPair<Key extends Comparable<Key>,Value> 
      implements Comparable<ZHCompPair<Key,Value>> {
  //key and value are the associated elements.
  private Key key;
  private Value value;
  
  /**
   * This comstructor creates a pair key->null.
   */
  public ZHCompPair(Key key) {
    this.key=key;
    this.value=null;
  }
  
  /**
   * This constructor creates a pair key->value.
   */
  public ZHCompPair(Key key, Value value) {
    this.key=key;
    this.value=value;
  }
  
  /**
   * getKey() returns the key from this pair.
   */
  public Key getKey() {
    return(this.key);
  }
  
  /**
   * getValue() returns the value from this pair.
   */
  public Value getValue() {
    return(this.value);
  }
  
  /**
   * setValue(value) changes the value of this pair to value.
   */
  public void setValue(Value value) {
    this.value=value;
  }
  
  /**
   * compareTo(pair) compares the keys of these two pairs.
   */
  public int compareTo(ZHCompPair<Key,Value> pair) {
    return(this.key.compareTo(pair.getKey()));
  }
  
  /**
   * equals(other) returns true if this pair and other
   * have equal keys.
   * 
   * @Override public boolean equals(Object other)
   */
  public boolean equals(ZHCompPair<Key,Value> other) {
    return(this.key.compareTo(other.getKey())==0);
  }
}