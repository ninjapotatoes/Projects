package edu.ncsu.csc316.dsa.list;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for SinglyLinkedList.
 * Checks the expected outputs of the List abstract data type behaviors when using
 * an array-based list data structure
 *
 * @author Dr. King
 *
 */
public class SinglyLinkedListTest {

  private List<String> list;

  /**
     * Create a new instance of an array-based list before each test case executes.
     */
  @Before
    public void setUp() {
    list = new SinglyLinkedList<String>();
  }

  /**
     * Test the output of the add(index, e) behavior, including expected exceptions.
     */
  @Test
    public void testAddIndex() {
    assertEquals(0, list.size());
    assertTrue(list.isEmpty());

    list.add(0, "one");
    assertEquals(1, list.size());
    assertEquals("one", list.get(0));
    assertFalse(list.isEmpty());
        
    // Use the statements above to help guide your test cases
    // for data structures: Start with an empty data structure, then
    // add an element and check the accessor method return values.
    // Then add another element and check again. Continue to keep checking
    // for special cases. For example, for an array-based list, you should
    // continue adding until you trigger a resize operation to make sure
    // the resize operation worked as expected.
        
    try {
      list.add(15,  "fifteen");
      fail("An IndexOutOfBoundsException should have been thrown");
    } catch (Exception e) {
      assertTrue(e instanceof IndexOutOfBoundsException);
    }
        
  }

  /**
     * Test the output of the addLast behavior.
     */
  @Test
    public void testAddLast() {
    //check empty
    assertEquals(0, list.size());
    assertTrue(list.isEmpty());

    //add last
    list.addLast("a");
    assertEquals(1, list.size());
    assertEquals("a", list.get(0));
    assertFalse(list.isEmpty());

    //add one more to make sure it actually got added to end
    list.addLast("b");
    assertEquals(2, list.size());
    assertEquals("a", list.get(0));
    assertEquals("b", list.get(1));
  }

  /**
     * Test the output of the last() behavior, including expected exceptions.
     */
  @Test
    public void testLast() {
    list.addLast("a");
    assertEquals("a", list.last());

    list.addLast("b");
    assertEquals("b", list.last());
  }

  /**
     * Test the output of the addFirst behavior.
     */
  @Test
    public void testAddFirst() {
    //add first
    list.addFirst("a");
    assertEquals(1, list.size());
    assertEquals("a", list.get(0));
    assertFalse(list.isEmpty());

    //add one more to make sure it actually got added first
    list.addFirst("b");
    assertEquals(2, list.size());
    assertEquals("b", list.get(0));
    assertEquals("a", list.get(1));
  }

  /**
     * Test the output of the first() behavior, including expected exceptions.
     */
  @Test
    public void testFirst() {
    list.addFirst("a");
    assertEquals("a", list.first());

    list.addFirst("b");
    assertEquals("b", list.first());
  }

  /**
     * Test the iterator behaviors, including expected exceptions.
     */
  @Test
    public void testIterator() {
    // Start with an empty list
    assertEquals(0, list.size());
    assertTrue(list.isEmpty());
        
    // Create an iterator for the empty list
    Iterator<String> it = list.iterator();
        
    // Try different operations to make sure they work
    // as expected for an empty list (at this point)
    try {
      it.remove();
      fail("An UnsupportedOperationException should have been thrown");           
    } catch (Exception e) {
      assertTrue(e instanceof UnsupportedOperationException);
    }
    assertFalse(it.hasNext());

    // Now add an element
    list.addLast("one");
        
    // Use accessor methods to check that the list is correct
    assertEquals(1, list.size());
    assertFalse(list.isEmpty());
    assertEquals("one", list.get(0));
        
    // Create an iterator for the list that has 1 element
    it = list.iterator();
        
    // Try different iterator operations to make sure they work
    // as expected for a list that contains 1 element (at this point)
    assertTrue(it.hasNext());
    assertEquals("one", it.next());
    assertFalse(it.hasNext());
    try {
      it.next();
      fail("A NoSuchElementException should have been thrown");           
    } catch (Exception e) {
      assertTrue(e instanceof NoSuchElementException);
    }

  }

  /**
     * Test the output of the remove(index) behavior, including expected exceptions.
     */
  @Test
    public void testRemoveIndex() {
    list.addLast("a");
    list.addLast("b");
    list.addLast("c");

    //Remove at middle index
    assertEquals("b", list.remove(1));
    assertEquals(2, list.size());
    assertEquals("a", list.get(0));
    assertEquals("c", list.get(1));

    //Remove at a invalid index.
    try {
      list.remove(5);
      fail("An IndexOutOfBoundsException should have been thrown");
    } catch (IndexOutOfBoundsException e) {
      assertTrue(e instanceof IndexOutOfBoundsException);
    }
  }

  /**
     * Test the output of the removeFirst() behavior, including expected exceptions.
     */
  @Test
    public void testRemoveFirst() {
    list.addLast("a");
    list.addLast("b");

    //Remove first
    assertEquals("a", list.removeFirst());
    assertEquals(1, list.size());
    assertEquals("b", list.get(0));
  }

  /**
     * Test the output of the removeLast() behavior, including expected exceptions.
     */
  @Test
    public void testRemoveLast() {
    list.addLast("a");
    list.addLast("b");

    //Remove last
    assertEquals("b", list.removeLast());
    assertEquals(1, list.size());
    assertEquals("a", list.get(0));
  }

  /**
     * Test the output of the set(index, e) behavior, including expected exceptions.
     */
  @Test
    public void testSet() {
    list.addLast("a");
    list.addLast("b");
    list.addLast("c");

    //Set a middle one
    assertEquals("b", list.set(1, "B"));
    assertEquals(3, list.size());
    assertEquals("B", list.get(1));

    //Set out of bounds
    try {
      list.set(5, "d");
      fail("An IndexOutOfBoundsException should have been thrown");
    } catch (IndexOutOfBoundsException e) {
      assertTrue(e instanceof IndexOutOfBoundsException);
    }
  }
}
