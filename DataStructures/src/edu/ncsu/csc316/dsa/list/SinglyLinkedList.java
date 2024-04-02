package edu.ncsu.csc316.dsa.list;

import java.util.Iterator;

/**
 * A singly-linked list is a linked-memory representation of the List abstract
 * data type. This list maintains a dummy/sentinel front node in the list to
 * help promote cleaner implementations of the list behaviors. This list also
 * maintains a reference to the tail/last node in the list at all times to
 * ensure O(1) worst-case cost for adding to the end of the list. Size is
 * maintained as a global field to allow for O(1) size() and isEmpty()
 * behaviors.
 *
 * @author Dr. King
 *
 * @param <E> the type of elements stored in the list
 */
public class SinglyLinkedList<E> extends AbstractList<E> {

  /** A reference to the dummy/sentinel node at the front of the list. **/
  private LinkedListNode<E> front;
    
  /** A reference to the last/final node in the list. **/
  private LinkedListNode<E> tail;
    
  /** The number of elements stored in the list. **/
  private int size;
        
  /**
   * Constructs an empty singly-linked list.
  */     
  public SinglyLinkedList() {
    front = new LinkedListNode<E>(null);
    tail = null;
    size = 0;
  }
    
  /**
   * List node for singly linked list.
   *
   * @param <E> The type the list node will be.
   */
  private static class LinkedListNode<E> {
    /** The element of the node. */
    private E element;
    /** The next pointer for the node. */
    private LinkedListNode<E> next;
        
    /**
     * Initializes a LinkedListNode.
     *
     * @param element to be stored at this node
     */
    public LinkedListNode(E element) {
      this(element, null);
    }
     
    /**
     * Initializes a LinkedListNode with a given next node.
     *
     * @param element to be stored at this node.
     * @param listNode the next point for the node.
     */
    public LinkedListNode(E element, LinkedListNode<E> listNode) {
      this.element = element;
      this.next = listNode;
    }
     
    /**
     * Gets the element in the linked list node.
     *
     * @return element to in node.
     */
    public E getElement() {
      return element;
    }
    
    /**
     * Gets the next linked list node.
     *
     * @return next node
     */
    public LinkedListNode<E> getNext() {
      return next;
    }
  }

  /**
   * Adds an element at the given index.
   *
   * @param index to insert element at
   * @param element to be inserted
   */
  @Override
  public void add(int index, E element) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException();
    }

    LinkedListNode<E> temp = new LinkedListNode<>(element);
    LinkedListNode<E> current = front;

    //Step forward until we get to the right node to insert at
    for (int i = 0; i < index; i++) {
      current = current.getNext();
    }

    //Insert node
    temp.next = current.getNext();
    current.next = temp;
    
    //If we are inserting at the end make sure to make the new tail this new node.
    if (index == size) {
      tail = temp;
    }

    size++;
  }

  /**
   * Removes the element at the given index.
   *
   * @param index of element to be removed
   * @return E the element that was removed
   */
  @Override
  public E remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }

    LinkedListNode<E> current = front;

    //Step forward to the index we need
    for (int i = 0; i < index; i++) {
      current = current.getNext();
    }

    //Skip the current 
    LinkedListNode<E> temp = current.getNext();
    current.next = temp.getNext();

    //If this is the last node change tail
    if (index == size - 1) {
      tail = current;
    }

    size--;
    return temp.getElement();
  }
  
  /**
   * Gets the last element in the singly linked list.
   *
   * @return E the last element
   */
  @Override
  public E last() {
    if (isEmpty()) {
      throw new IndexOutOfBoundsException("The list is empty");
    }
    return tail.getElement();
  }

  /**
   * Adds and element to the end of the list.
   *
   * @param element element to be added
   */    
  @Override
  public void addLast(E element) {
    LinkedListNode<E> temp = new LinkedListNode<>(element);
    if (isEmpty()) {
      front.next = temp;
      tail = temp;
    } else {
      tail.next = temp;
      tail = temp;
    }
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
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }

    //Increment until we get to the index given.
    LinkedListNode<E> temp = front.getNext();
    for (int i = 0; i < index; i++) {
      temp = temp.getNext();
    }

    return temp.getElement();
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
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }

    //Increment until we get to the index given.
    LinkedListNode<E> temp = front.getNext();
    for (int i = 0; i < index; i++) {
      temp = temp.getNext();
    }

    //Store the element to return.
    E returnEle = temp.getElement();
    //Change the element to the parameter
    temp.element = element;
    return returnEle;
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
   * Iterates through the singly linked list.
   *
   * @return iterator
   */
  @Override
  public Iterator<E> iterator() {
    return new ElementIterator();
  }
  
  /**
   * Private class to iterate through the elements in the singly linked list.
   */
  private class ElementIterator implements Iterator<E> {
    /**
     * Keep track of the next node that will be processed.
     */
    private LinkedListNode<E> current;
    
    
    /**
     * Construct a new element iterator where the cursor is initialized.
     * to the beginning of the list.
     */
    public ElementIterator() {
      current = front.getNext();
    }

    /**
     * Checks if there is a next element in the iterator.
     *
     * @return true if there exists a next element.
     */
    @Override
    public boolean hasNext() {
      return current != null;
    }

    /**
     * Returns current element and advances to the next element in the iterator.
     *
     * @return E element at the current index.
     */
    @Override
    public E next() {
      if (!hasNext()) {
        throw new java.util.NoSuchElementException();
      }
      E element = current.getElement();
      current = current.getNext();
      return element;
    }
     
    /**
     * Removes the element from the iterator.
     */
    @Override    
    public void remove() {
      // DO NOT CHANGE THIS METHOD
      throw new UnsupportedOperationException(
      "This SinglyLinkedList implementation does not currently support removal of elements "
      + "when using the iterator.");
    }
  }
}

