package edu.ncsu.csc316.dsa.list.positional;

import edu.ncsu.csc316.dsa.Position;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The Positional Linked List is implemented as a doubly-linked list data
 * structure to support efficient, O(1) worst-case Positional List abstract data
 * type behaviors.
 * Size is maintained as a global field to ensure O(1) worst-case runtime of
 * size() and isEmpty().
 * The PositionalLinkedList class is based on the implementation developed for
 * use with the textbook:
 * Data Structures and Algorithms in Java, Sixth Edition Michael T. Goodrich,
 * Roberto Tamassia, and Michael H. Goldwasser John Wiley & Sons, 2014
 *
 * @author Dr. King
 *
 * @param <E> the type of elements stored in the positional list
 */
public class PositionalLinkedList<E> implements PositionalList<E> {

  /** A dummy/sentinel node representing at the front of the list. **/
  private PositionalNode<E> front;

  /** A dummy/sentinel node representing at the end/tail of the list. **/
  private PositionalNode<E> tail;

  /** The number of elements in the list. **/
  private int size;

  /**
     * Constructs an empty positional linked list.
     */
  public PositionalLinkedList() {
    front = new PositionalNode<E>(null);
    tail = new PositionalNode<E>(null, null, front);
    front.setNext(tail);
    size = 0;
  }

    
  /**
     * Safely casts a Position, p, to be a PositionalNode.
     *
     * @param p the position to cast to a PositionalNode
     * @return a reference to the PositionalNode
     * @throws IllegalArgumentException if p is null, or if p is not a valid
     *                                  PositionalNode
     */
  private PositionalNode<E> validate(Position<E> p) {
    if (p instanceof PositionalNode) {
      return (PositionalNode<E>) p;
    }
    throw new IllegalArgumentException("Position is not a valid positional list node.");
  }

  /**
   * Helper method to add between the dummy and prev/next node.
   *
   * @param element to be added
   * @param next node reference
   * @param prev node reference
   * @return position added at
   */
  private Position<E> addBetween(E element, PositionalNode<E> next, PositionalNode<E> prev) {
    //make a new node and set it between prev and next
	  /*
	   * I recieved help from Dinesh Karnati on 3/8/24 as stated in the code sharing contract
	   *  about past workshops. We discussed implementation of the addBetween method in a
	   *   positional linked list.
	  */
	  PositionalNode<E> newPositionalNode = new PositionalNode<E>(element, next, prev);

	  if (next != tail) {
		  next.setPrevious(newPositionalNode);
	  } else {
		  tail.setPrevious(newPositionalNode);
	  }

	  if (prev != front) {
		  prev.setNext(newPositionalNode);
	  } else {
		  front.setNext(newPositionalNode);
	  }

	  size++;
	  return newPositionalNode;
  }

  /**
   * Iterates through the positional linked list.
   *
   * @return iterator
   */
  @Override
 public Iterator<E> iterator() {
    return new ElementIterator();
  }

  /**
   * Adds an element to the position after the given param.
   *
   * @param p position to be added after
   * @param element to be added
   * @return position that was added at.
   */
  @Override
  public Position<E> addAfter(Position<E> p, E element) {
    //make sure p is valid
    PositionalNode<E> validP = validate(p);
    return addBetween(element, validP.getNext(), validP);
  }

  /**
   * Adds an element before the given position.
   *
   * @param p position to add before
   * @parm element to be added
   * @return position that was added at.
   */
  @Override
  public Position<E> addBefore(Position<E> p, E element) {
    //make sure p is valid
    PositionalNode<E> validP = validate(p);
    return addBetween(element, validP, validP.getPrevious());
  }

  /**
   * Adds the element to the front of the list.
   *
   * @param element to be added
   * @return position added at.
   */
  @Override
  public Position<E> addFirst(E element) {
    return addBetween(element, front.getNext(), front);
  }

  /**
   * Adds the element to the end of the list.
   *
   * @param element to be added
   * @return position added at
   */
  @Override
  public Position<E> addLast(E element) {
    return addBetween(element, tail, tail.getPrevious());
  }

  /**
   * Gets the position after the given position.
   *
   * @param p position to get after
   * @return position after given p 
   */
  @Override
  public Position<E> after(Position<E> p) {
    PositionalNode<E> validP = validate(p);
    if (validP.getNext() != tail) {
      return validP.getNext();
    } else {
      return null;
    }
  }

  /**
   * Gets the position before the given position.
   *
   * @param p position to get before
   * @return position before p
   */
  @Override
  public Position<E> before(Position<E> p) {
    PositionalNode<E> validP = validate(p);
    
    //Return null if we are at the first node
    if (validP.getPrevious() != front) {
      return validP.getPrevious();
    } else {
      return null;
    }
  }

  /**
   * Gets the first position in the list.
   *
   * @return Position at the beginning of list
   */
  @Override
  public Position<E> first() {
    if (!isEmpty()) {
      return front.getNext();
    } else {
      return null;
    }
  }

  /**
   * Returns whether the list is empty.
   *
   * @return true if list is empty.
   */
  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Gets the last position in the list.
   *
   * @return Position at the end of list
   */
  @Override
  public Position<E> last() {
    if (!isEmpty()) {
      return tail.getPrevious();
    } else {
      return null;
    }
  }

  /**
   * Removes the element at the given position.
   *
   * @param p position to remove element at
   * @return removed element
   */
  @Override
  public E remove(Position<E> p) {
	/*
	 * I recieved help from Dinesh Karnati on 3/8/24 as stated in the code sharing contract
	 *  about past workshops. We discussed implementation of the remove method in a
	 *   positional linked list.
	 */
    PositionalNode<E> validP = validate(p);
    
    if (validP.getPrevious() == null) {
		front.next = validP.getNext();
	} else {
		validP.getPrevious().setNext(validP.getNext());
	}

	if (validP.getNext() == null) {
		tail.previous = validP.getPrevious();
	} else {
		validP.getNext().setPrevious(validP.getPrevious());
	}

	E data = validP.getElement();
	size--;

	return data;
  }

  /**
   * Sets the node at p to element.
   *
   * @param p position to set element at
   * @param element element to set
   * @return previous element at position p
   */
  @Override
  public E set(Position<E> p, E element) {
    PositionalNode<E> node = validate(p);
    E originalElement = node.getElement();
    node.setElement(element);
    return originalElement;
  }

  /**
   * Gets the size of the list.
   *
   * @return size of the list
   */
  @Override
  public int size() {
    return size;
  }

  
  /**
   * Iterates over the positions in the list.
   *
   * @return iterable object
   */
  @Override
  public Iterable<Position<E>> positions() {
    return new PositionIterable();
  }
  
  
  /**
   * Wrapper class to adapt position iterator to return an iterable object.
   */
  private class PositionIterable implements Iterable<Position<E>> {
      
    /**
     * Returns an iterator over positions.
     *
     * @return iterable object based on position iterator
     */
    @Override
    public Iterator<Position<E>> iterator() {
      return new PositionIterator();
    }
  }
  
  /**
   * List node for positional linked list.
   *
   * @param <E> The type the list node will be.
   */
  private static class PositionalNode<E> implements Position<E> {
    /** The element of the node. */
    private E element;
    /** The next pointer for the node. */
    private PositionalNode<E> next;
    /** The previous pointer for the node. */
    private PositionalNode<E> previous;

    /**
     * Initializes a positional node.
     *
     * @param value to be stored at this node.
     */
    public PositionalNode(E value) {
      this(value, null);
    }

    /**
     * Initializes a positional node with a given next node reference.
     *
     * @param value element to be stored at this node.
     * @param next the next reference for the node.
     */
    public PositionalNode(E value, PositionalNode<E> next) {
      this(value, next, null);
    }

    /**
     * Initializes a positional node with a given next node reference and prev node reference.
     *
     * @param value element to be stored at this node.
     * @param next the next reference for the node.
     * @param prev the prev reference for the node
     */
    public PositionalNode(E value, PositionalNode<E> next, PositionalNode<E> prev) {
      setElement(value);
      setNext(next);
      setPrevious(prev);
    }

    /**
     * Sets the previous reference of the node.
     *
     * @param prev new node for the node to point to.
     */
    public void setPrevious(PositionalNode<E> prev) {
      previous = prev;
    }

    /**
     * Gets the previous reference of the node.
     *
     * @return prev node
     */
    public PositionalNode<E> getPrevious() {
      return previous;
    }
    
    /**
     * Sets the next reference of the node.
     *
     * @param next new node for the node to point to.
     */
    public void setNext(PositionalNode<E> next) {
      this.next = next;
    }

    /**
     * Gets the next reference of the node.
     *
     * @param next node
     */
    public PositionalNode<E> getNext() {
      return next;
    }

    /**
     * Gets the current element.
     *
     * @return element
     */
    @Override
    public E getElement() {
      return element;
    }
    
    /**
     * Sets the current element.
     *
     * @param element to be set
     */
    public void setElement(E element) {
      this.element = element;
    }
  }
  
  /**
   * Private class to iterate through the positions in the positional linked list.
   */
  private class PositionIterator implements Iterator<Position<E>> {
    /** Current position in iterator. */
    private Position<E> current;

    /** Remove status of a position in the iterator. */
    private boolean removeOk;

    /**
     * Initializes a position iterator where the first position is the beginning of the list.
     */
    public PositionIterator() {
      current = front.getNext();
      removeOk = false;
    }

    /**
     * Checks if there is a next position in the iterator.
     *
     * @return true if there exists a next element.
     */
    @Override
    public boolean hasNext() {
      return current != tail;
    }

    /**
     * Returns current position and advances to the next position in the iterator.
     *
     * @return position at the current index.
     */
    @Override
    public Position<E> next() {
      if  (!hasNext()) {
        throw new NoSuchElementException();
      }
      
      //Set previous to the current position and advance it forward one.
      Position<E> p = current;

      if (after(current) == null) {
    	  current = tail;
      } else {

      current = after(current);

      }
      removeOk = true;
      return p;
    }

    /**
     * Removes the position from the iterator.
     */
    @Override
    public void remove() {
      if (!removeOk) {
        throw new IllegalStateException("remove() can only be called once after a call to next().");
      }
      PositionalLinkedList.this.remove(current);
      removeOk = false;
    }
  }
  
  /**
   * Private class to iterate through the elements in a position.
   */
  private class ElementIterator implements Iterator<E> {

    /** Iterator for a position. */
    private Iterator<Position<E>> it;

    /**
     * Initializes a element iterator where the first element is at the start of the position.
     */
    public ElementIterator() {
      it = new PositionIterator();
    }

    /**
     * Returns whether there is a next element.
     *
     * @return true if next element exists
     */
    @Override
    public boolean hasNext() {
      return it.hasNext();
    }

    /**
     * Returns current element and advances to the next element in the iterator.
     *
     * @return element at the current index.
     */
    @Override
    public E next() {
      return it.next().getElement();
    }

    /**
     * Removes the element from the iterator.
     */
    @Override
    public void remove() {
      it.remove();
    }
  }

}
