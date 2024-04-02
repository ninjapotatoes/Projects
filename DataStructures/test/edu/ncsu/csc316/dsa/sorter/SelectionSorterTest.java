/**
 * Location of the sorter.
 */

package edu.ncsu.csc316.dsa.sorter;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the selectionSorter class.
 *
 * @author Teddy Zhang
 */
public class SelectionSorterTest {

  private SelectionSorter<Integer> integerSorter;

  @Before
  public void setUp() {
    integerSorter = new SelectionSorter<Integer>();
  }
  /**
   * Test method for {@link edu.ncsu.csc316.dsa.sorter.SelectionSorter#sort(E[])}.
   */
  
  @Test
public void testSort() {
    Integer[] empty = {};
    
    //Test empty array
    integerSorter.sort(empty);
    assertEquals(0, empty.length);

    Integer[] oneElement = { 1 };
    //Test one element
    integerSorter.sort(oneElement);
    assertEquals(Integer.valueOf(1), oneElement[0]);

    Integer[] twoElement = { 1, 2 };
    //Test two element
    integerSorter.sort(twoElement);
    assertEquals(Integer.valueOf(1), twoElement[0]);
    assertEquals(Integer.valueOf(2), twoElement[1]);

    Integer[] reverseTwoElement = { 2, 1 };
    integerSorter.sort(reverseTwoElement);
    assertEquals(Integer.valueOf(1), reverseTwoElement[0]);
    assertEquals(Integer.valueOf(2), reverseTwoElement[1]);

    Integer[] duplicateElement = { 1, 3, 2, 3};
    //Test Duplicate Element
    integerSorter.sort(duplicateElement);
    assertEquals(Integer.valueOf(1), duplicateElement[0]);
    assertEquals(Integer.valueOf(2), duplicateElement[1]);
    assertEquals(Integer.valueOf(3), duplicateElement[2]);
    assertEquals(Integer.valueOf(3), duplicateElement[3]);

    Integer[] fewElementsOut = { 1, 2, 4, 6, 8, 3};
    //Test Few Elements Out of Order
    integerSorter.sort(fewElementsOut);
    assertEquals(Integer.valueOf(1), fewElementsOut[0]);
    assertEquals(Integer.valueOf(2), fewElementsOut[1]);
    assertEquals(Integer.valueOf(3), fewElementsOut[2]);
    assertEquals(Integer.valueOf(4), fewElementsOut[3]);
    assertEquals(Integer.valueOf(6), fewElementsOut[4]);
    assertEquals(Integer.valueOf(8), fewElementsOut[5]);

    Integer[] sameElements = { 1, 1, 1, 1 };
    //Test All same element array
    integerSorter.sort(sameElements);
    assertEquals(Integer.valueOf(1), sameElements[0]);
    assertEquals(Integer.valueOf(1), sameElements[1]);
    assertEquals(Integer.valueOf(1), sameElements[2]);
    assertEquals(Integer.valueOf(1), sameElements[3]);

    Integer[] negativeElement = { -1, -2, -3 };
    //Test Negative
    integerSorter.sort(negativeElement);
    assertEquals(Integer.valueOf(-3), negativeElement[0]);
    assertEquals(Integer.valueOf(-2), negativeElement[1]);
    assertEquals(Integer.valueOf(-1), negativeElement[2]);
  }

}
