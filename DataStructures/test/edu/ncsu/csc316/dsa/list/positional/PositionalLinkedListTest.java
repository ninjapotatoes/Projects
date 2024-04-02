package edu.ncsu.csc316.dsa.list.positional;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.Position;

/**
 * Test class for PositionalLinkedList.
 * Checks the expected outputs of the Positional List abstract data type behaviors when using
 * an doubly-linked positional list data structure
 *
 * @author Dr. King
 *
 */
public class PositionalLinkedListTest {

  private PositionalList<String> list;
    
  /**
     * Create a new instance of an positional linked list before each test case executes.
     */ 
  @Before
  public void setUp() {
    list = new PositionalLinkedList<String>();
  }
    
  /**
     * Test the output of the first() behavior, including expected exceptions.
     */
  @Test
  public void testFirst() {
    assertEquals(0, list.size());
    assertTrue(list.isEmpty());
    
    assertNull(list.first());
        
    Position<String> first = list.addFirst("one");
    assertEquals(1, list.size());
    assertEquals(first, list.first());
        
    Position<String> newFirst = list.addFirst("two");
    assertEquals(2, list.size());
    assertEquals(newFirst, list.first());
  }
    
  /**
     * Test the output of the last() behavior, including expected exceptions.
     */
  @Test
  public void testLast() {
    assertEquals(0, list.size());
    assertTrue(list.isEmpty());
    
    assertNull(list.last());
        
    Position<String> first = list.addLast("one");
    assertEquals(1, list.size());
    assertEquals(first, list.last());
        
    Position<String> newLast = list.addLast("two");
    assertEquals(2, list.size());
    assertEquals(newLast, list.last());
  }
    
  /**
     * Test the output of the addFirst(element) behavior.
     */ 
  @Test
  public void testAddFirst() {
    assertEquals(0, list.size());
    assertTrue(list.isEmpty());
    Position<String> first = list.addFirst("one");
    assertEquals(1, list.size());
    assertFalse(list.isEmpty());
    assertEquals(first, list.first());
    
    Position<String> newFirst = list.addFirst("two");
    assertEquals(2, list.size());
    assertEquals(newFirst, list.first());
  }
    
  /**
     * Test the output of the addLast(element) behavior.
     */ 
  @Test
  public void testAddLast() {
    assertEquals(0, list.size());
    assertTrue(list.isEmpty());
    Position<String> first = list.addLast("one");
    assertEquals(1, list.size());
    assertEquals(first, list.last());    
    
    Position<String> newLast = list.addLast("two");
    assertEquals(2, list.size());
    assertEquals(newLast, list.last());
  }
    
  /**
     * Test the output of the before(position) behavior, including expected exceptions.
     */ 
  @Test
  public void testBefore() {
    assertEquals(0, list.size());

    Position<String> first = list.addFirst("one");
    Position<String> second = list.addAfter(first, "two");
    final Position<String> third = list.addAfter(second, "three");

    assertEquals(3, list.size());

    //Test get the position before the first position 
    assertNull(list.before(first));

    //Test getting the position before a position in the middle
    assertEquals(first, list.before(second));

    //Test getting the position before the last position
    assertEquals(second, list.before(third));
  }
    
  /**
     * Test the output of the after(position) behavior, including expected exceptions.
     */     
  @Test
  public void testAfter() {
    assertEquals(0, list.size());

    Position<String> first = list.addFirst("one");
    Position<String> second = list.addAfter(first, "two");

    //Test get the position after the last position 
    assertNull(list.after(second));
    
    //Test getting position after the first
    assertEquals(second, list.after(first));
  }
    
  /**
     * Test the output of the addBefore(position, element) behavior, including expected exceptions.
     */     
  @Test
  public void testAddBefore() {
    Position<String> first = list.addFirst("one");
    Position<String> third = list.addLast("three");

    Position<String> second = list.addBefore(third, "two");

    assertEquals(3, list.size());
    assertEquals(first, list.before(second));
    assertEquals(second, list.before(third));
    assertEquals("two", second.getElement());
  }
    
  /**
     * Test the output of the addAfter(position, element) behavior, including expected exceptions.
   */     
  @Test
  public void testAddAfter() {
    Position<String> first = list.addFirst("one");
    Position<String> third = list.addLast("three");

    Position<String> second = list.addAfter(first, "two");

    assertEquals(3, list.size());
    assertEquals(third, list.after(second));
    assertEquals(second, list.after(first));
    assertEquals("two", second.getElement());
  }
    
  /**
   * Test the output of the set(position, element) behavior, including expected exceptions.
   */     
  @Test
  public void testSet() {
    Position<String> first = list.addFirst("one");
    Position<String> second = list.addAfter(first, "two");

    //Make sure it returns the initial value
    assertEquals("one", list.set(first, "three"));
    assertEquals("two", list.set(second, "four"));

    //Make sure the new value is stored
    assertEquals("three", first.getElement());
    assertEquals("four", second.getElement());
  }
    
  /**
     * Test the output of the remove(position) behavior, including expected exceptions.
     */     
  @Test
  public void testRemove() {
    Position<String> first = list.addFirst("one");
    Position<String> second = list.addAfter(first, "two");
    Position<String> third = list.addLast("three");

    //Remove front
    assertEquals("one", list.remove(first));
    assertEquals(second, list.first());
    assertEquals(third, list.last());
    assertEquals(2, list.size());

    //Remove back
    assertEquals("three", list.remove(third));
    assertEquals(second, list.first());
    assertEquals(second, list.last());
    assertEquals(1, list.size());
    
    //RemoveLast
    assertEquals("two", list.remove(second));
    assertTrue(list.isEmpty());
    
  }
    
  /**
   * Test the output of the iterator behavior for elements in the list, 
   * including expected exceptions.
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
      assertTrue(e instanceof IllegalStateException);
    }
    
    // Now add an element
    list.addLast("one");
    // Use accessor methods to check that the list is correct
    assertEquals(1, list.size());
    assertFalse(list.isEmpty());
        
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
    
    //Test valid remove
    try {
        it.remove();
                  
      } catch (Exception e) {
        fail("No exception should have been thrown."); 
      }
    }
    
  /**
   * Test the output of the positions() behavior to iterate through positions
   * in the list, including expected exceptions.
   */     
  @Test
  public void testPositions() {
    assertEquals(0, list.size());
    Position<String> first = list.addFirst("one");
    final Position<String> second = list.addLast("two");
    final Position<String> third = list.addLast("three");
    
    assertEquals(3, list.size());   
    
    Iterator<Position<String>> it = list.positions().iterator();
    assertTrue(it.hasNext());
    assertEquals(first, it.next());
    
    assertEquals(second, it.next());
    assertEquals(third, it.next());
    
    //Make sure nothing is left
    assertFalse(it.hasNext());
  }

}