package edu.ncsu.csc316.dsa.stack;

import edu.ncsu.csc316.dsa.list.SinglyLinkedList;
import java.util.EmptyStackException;

/**
 * The Linked Stack is implemented as a singly-linked list data structure to
 * support efficient, O(1) worst-case Stack abstract data type behaviors.
 *
 * @author Dr. King
 *
 * @param <E> the type of elements stored in the stack
 */
public class LinkedStack<E> extends AbstractStack<E> {

  /** Delegate to our existing singly linked list class. **/
  private SinglyLinkedList<E> list;

  /**
   * Construct a new singly-linked list to use when modeling the last-in-first-out
   * paradigm for the stack abstract data type.
   */
  public LinkedStack() {
    list = new SinglyLinkedList<E>();
  }

  /**
   * Adds an element to the top of the list.
   *
   * @param element to be added 
   */
  @Override
  public void push(E element) {
    list.addFirst(element);
  }

  /**
   * Removes an element from the top of the stack.
   *
   * @return element
   * @throws EmptyStackException if the stack is empty
   */
  @Override
  public E pop() {
    if (size() == 0) {
      throw new EmptyStackException();
    }
    return list.removeFirst();
  }

  /**
   * Returns, but does not remove, the element at the top of the stack.
   *
   * @return element at top of list
   */
  @Override
  public E top() {
    if (size() == 0) {
      throw new EmptyStackException();
    }
    return list.get(0);
  }

  /**
   * Returns the number of elements in the stack.
   *
   * @return size of number of elements
   */
  @Override
  public int size() {
    return list.size();
  }

}