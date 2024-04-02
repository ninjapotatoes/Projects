package edu.ncsu.csc316.dsa.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An array-based list is a contiguous-memory representation of the List
 * abstract data type. This array-based list dynamically resizes to ensure O(1)
 * amortized cost for adding to the end of the list. Size is maintained as a
 * global field to allow for O(1) size() and isEmpty() behaviors.
 *
 * @author Dr. King
 *
 * @param <E> the type of elements stored in the list
 */
public class ArrayBasedList<E> extends AbstractList<E> {

  /**
     * The initial capacity of the list if the client does not provide a capacity.
     * when constructing an instance of the array-based list
     **/
  private static final int DEFAULT_CAPACITY = 0;

  /** The array in which elements will be stored. **/
  private E[] data;
    
  /** The number of elements stored in the array-based list data structure. **/
  private int size;

  /**
     * Constructs a new instance of an array-based list data structure with the
     * default initial capacity of the internal array.
     */
  public ArrayBasedList() {
    this(DEFAULT_CAPACITY);
  }

  /**
     * Constructs a new instance of an array-based list data structure with the
     * provided initial capacity.
     *
     * @param capacity the initial capacity of the internal array used to store the
     *                 list elements
     */
  @SuppressWarnings("unchecked")
    public ArrayBasedList(int capacity) {
    data = (E[]) (new Object[capacity]);
    size = 0;
  }

  /**
   * Adds an element at the given index.
   *
   * @param index to insert element at
   * @param element to be inserted
   */
  @Override
    public void add(int index, E element) {
    checkIndexForAdd(index);

    ensureCapacity(size + 1);

    //Loop through to shift each element right to make space.
    for (int i = size; i > index; i--) {
      data[i] = data[i - 1];
    }

    data[index] = element;
    size++;
  }

  /**
   * Gets the element at the given index.
   *
   * @param index to insert element at
   * @return E element at index
   */
  @Override
   public E get(int index) {
    checkIndex(index);
    return data[index];
  }

  /**
   * Removes an element at the given index.
   *
   * @param index to insert element at
   * @return E element at index.
   */
  @Override
    public E remove(int index) {
    checkIndex(index);

    E returnElement = data[index];

    // Shift each element left once to adjust for the one being taken out.
    for (int i = index; i < size - 1; i++) {
      data[i] = data[i + 1];
    }

    size--;
    return returnElement;
  }

  /**
   * Sets the element at the given index.
   *
   * @param index to insert element at
   * @param element to be inserted
   * @return E element previously at index.
   */
  @Override
    public E set(int index, E element) {
    checkIndex(index);

    E returnElement = data[index];
    data[index] = element;
    return returnElement;
  }

  /**
   * Returns the size of the array.
   *
   * @return size of array
   */
  @Override
    public int size() {
    return size;
  }

  /**
   * Iterates through the array based list.
   *
   * @return iterator
   */
  @Override
    public Iterator<E> iterator() {
    return new ElementIterator();
  }
  
  /**
 * To ensure amortized O(1) cost for adding to the end of the array-based list,
 * use the doubling strategy on each resize. Here, we add +1 after doubling to
 * handle the special case where the initial capacity is 0 (otherwise, 0*2 would
 * still produce a capacity of 0).
 *
 * @param minCapacity the minimum capacity that must be supported by the
 *                    internal array
 */
  private void ensureCapacity(int minCapacity) {
    int oldCapacity = data.length;
    if (minCapacity > oldCapacity) {
      int newCapacity = (oldCapacity * 2) + 1;
      if (newCapacity < minCapacity) {
        newCapacity = minCapacity;
      }
      data = Arrays.copyOf(data, newCapacity);
    }
  }
  
  /**
   * To iterate through each element in the array.
   */
  private class ElementIterator implements Iterator<E> {
    /** Current position of iterator. */
    private int position;
    /** Boolean for whether you can remove from the iterator. */
    private boolean removeOk;

    /**
     * Construct a new element iterator where the cursor is initialized 
     * to the beginning of the list.
     */
    public ElementIterator() {
      position = 0;
      removeOk = false;
    }

    /**
     * Determines whether the array has an element at the next index.
     *
     * @return true if next element exists
     */
    @Override
    public boolean hasNext() {
      return position < size;
    }

    /**
     * Returns the element at the next element in the array.
     *
     * @return element at next index
     */
    @Override
    public E next() {
      if (hasNext()) {
        //Since element at next index exists it is now okay to remove.
        removeOk = true;
        return data[position++];
      } else {
        throw new NoSuchElementException(); 
      }
    }
        
    /**
     * Removes the element at the current index.
     */
    @Override
    public void remove() {
      if (removeOk) {
        //Remove the previous index because next increments position forward 1.
        ArrayBasedList.this.remove(position - 1);
        position--;
        removeOk = false;
      } else {
        throw new IllegalStateException();
      }
    }
  }
}
