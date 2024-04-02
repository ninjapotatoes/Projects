package edu.ncsu.csc316.dsa.map;

import java.util.Iterator;
import edu.ncsu.csc316.dsa.Position;
import edu.ncsu.csc316.dsa.list.positional.PositionalLinkedList;
import edu.ncsu.csc316.dsa.list.positional.PositionalList;

/**
 * An unordered link-based map is an unordered (meaning keys are not used to
 * order entries) linked-memory representation of the Map abstract data type.
 * This link-based map delegates to an existing doubly-linked positional list.
 * To help self-organizing entries to improve efficiency of lookUps, the
 * unordered link-based map implements the move-to-front heuristic: each time an
 * entry is accessed, it is shifted to the front of the internal list.
 *
 * @author Dr. King
 *
 * @param <K> the type of keys stored in the map
 * @param <V> the type of values that are associated with keys in the map
 */
public class UnorderedLinkedMap<K, V> extends AbstractMap<K, V> {

  private PositionalList<Entry<K, V>> list;
    
  public UnorderedLinkedMap() {
    this.list = new PositionalLinkedList<Entry<K, V>>();
  }
    
  private Position<Entry<K, V>> lookUp(K key) {
    if (list.isEmpty()) {
      return null;
    }
    //loop through 
    for (Position<Entry<K, V>> p : list.positions()) {
      if (p.getElement().getKey().equals(key)) {
        return p;
      }
    }
    return null;
  }

  @Override
  public V get(K key) {
    Position<Entry<K, V>> p = lookUp(key);
    
    if (p != null) {
      V val = p.getElement().getValue();
      moveToFront(p); 
      return val;
    }
    return null;
  }
  
  /**
   * Implements the move to heuristic by making the entry be at the front of the list.
   *
   * @param position of the entry
   */
  private void moveToFront(Position<Entry<K, V>> position) {
    //if the given position is not at the front of the list move to front
    if (!list.first().equals(position)) {
      Entry<K, V> entry = position.getElement();
      list.remove(position);
      list.addFirst(entry);
    }
  }

  @Override
  public V put(K key, V value) {
    Position<Entry<K, V>> p = lookUp(key);
    if (p != null) {
      //stroe prev value to return and remove and add it to front
      V prev = p.getElement().getValue();
      Entry<K, V> updatedEntry = new MapEntry<>(key, value);
      list.remove(p);
      list.addFirst(updatedEntry);
      moveToFront(list.first());
      return prev;
    } else {
      list.addFirst(new MapEntry<>(key, value));
      return null;
    }
  }
    
  @Override
  public V remove(K key) {
    Position<Entry<K, V>> p = lookUp(key);
    
    if (p != null) {
      V value = p.getElement().getValue();
      list.remove(p);
      return value;
    }
    return null;
  }
    
  @Override
  public int size() {
    return list.size();
  }
    
  @Override
  public Iterable<Entry<K, V>> entrySet() {
    EntryCollection collection = new EntryCollection();
    for (Entry<K, V> entry : list) {
      collection.add(entry);
    }
    return collection;
  }

    
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("UnorderedLinkedMap[");
    Iterator<Entry<K, V>> it = list.iterator();
    while (it.hasNext()) {
      sb.append(it.next().getKey());
      if (it.hasNext()) {
        sb.append(", ");
      }
    }
    sb.append("]");
    return sb.toString();
  }
}
