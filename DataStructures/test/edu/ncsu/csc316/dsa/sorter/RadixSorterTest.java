/**
 * Location of sorter in the project.
 */

package edu.ncsu.csc316.dsa.sorter;

import static org.junit.Assert.assertEquals;

import edu.ncsu.csc316.dsa.data.Student;
import org.junit.Before;
import org.junit.Test;


/**
 * Tests the radixSorterClass.
 *
 * @author Teddy Zhang
 */
public class RadixSorterTest {

  private Student sone;
  private Student stwo;
  private Student sthree;
  private Student sfour;
  private Student sfive;

  private RadixSorter<Student> sorter;

  /**
   * Sets up the students information.
   */
  @Before
public void setUp() {
    sone = new Student("OneFirst", "OneLast", 1, 1, 1.0, "oneUnityID");
    stwo = new Student("TwoFirst", "TwoLast", 2, 2, 2.0, "twoUnityID");
    sthree = new Student("ThreeFirst", "ThreeLast", 3, 3, 3.0, "threeUnityID");
    sfour = new Student("FourFirst", "FourLast", 4, 4, 4.0, "fourUnityID");
    sfive = new Student("FiveFirst", "FiveLast", 5, 5, 5.0, "fiveUnityID");

    sorter = new RadixSorter<Student>();
  }

  /**
 * Tests sorting a student using radix sort.
 */
  @Test
public void testSortStudent() {
    Student[] original = { stwo, sone, sfour, sthree, sfive };
    sorter.sort(original);
    assertEquals(sone, original[0]);
    assertEquals(stwo, original[1]);
    assertEquals(sthree, original[2]);
    assertEquals(sfour, original[3]);
    assertEquals(sfive, original[4]);
  }

  /**
 * Testing if the array is empty.
 */
  @Test
public void testSortEmptyArray() {
    Student[] empty = {};
    sorter.sort(empty);
    assertEquals(0, empty.length);
  }
    
  /**
 * Testing using an array that is already sorted.
 */
  @Test
public void testSortAlreadySortedArray() {
    Student[] sorted = { sone, stwo, sthree, sfour, sfive };
    sorter.sort(sorted);
    assertEquals(sone, sorted[0]);
    assertEquals(stwo, sorted[1]);
    assertEquals(sthree, sorted[2]);
    assertEquals(sfour, sorted[3]);
    assertEquals(sfive, sorted[4]);
  }

  /**
 * Testing using array in reverse order.
 */
  @Test
public void testSortReverseSortedArray() {
    Student[] reverse = { sfive, sfour, sthree, stwo, sone };
    sorter.sort(reverse);
    assertEquals(sone, reverse[0]);
    assertEquals(stwo, reverse[1]);
    assertEquals(sthree, reverse[2]);
    assertEquals(sfour, reverse[3]);
    assertEquals(sfive, reverse[4]);
  }

}
