package edu.ncsu.csc316.dsa.sorter;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the MergeSorter Class.
 *
 * @author Teddy Zhang
 */
public class MergeSorterTest {

  private Integer[] dataAscending = { 1, 2, 3, 4, 5 };
  private Integer[] dataDescending = { 5, 4, 3, 2, 1 };
  private Integer[] dataRandom = { 4, 1, 5, 3, 2 };

  private MergeSorter<Integer> integerSorter;

  @Before
public void setUp() {
    integerSorter = new MergeSorter<Integer>();
  }

  /**
   * Tests sorting integers using merge sort.
   */
  @Test
public void testSortIntegers() {
    integerSorter.sort(dataAscending);
    assertEquals(Integer.valueOf(1), dataAscending[0]);
    assertEquals(Integer.valueOf(2), dataAscending[1]);
    assertEquals(Integer.valueOf(3), dataAscending[2]);
    assertEquals(Integer.valueOf(4), dataAscending[3]);
    assertEquals(Integer.valueOf(5), dataAscending[4]);

    integerSorter.sort(dataDescending);
    assertEquals(Integer.valueOf(1), dataDescending[0]);
    assertEquals(Integer.valueOf(2), dataDescending[1]);
    assertEquals(Integer.valueOf(3), dataDescending[2]);
    assertEquals(Integer.valueOf(4), dataDescending[3]);
    assertEquals(Integer.valueOf(5), dataDescending[4]);

    integerSorter.sort(dataRandom);
    assertEquals(Integer.valueOf(1), dataRandom[0]);
    assertEquals(Integer.valueOf(2), dataRandom[1]);
    assertEquals(Integer.valueOf(3), dataRandom[2]);
    assertEquals(Integer.valueOf(4), dataRandom[3]);
    assertEquals(Integer.valueOf(5), dataRandom[4]);
  }

  /**
 * Tests sorting students using merge sort.
 */
  @Test
public void testSortStudent() {
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
