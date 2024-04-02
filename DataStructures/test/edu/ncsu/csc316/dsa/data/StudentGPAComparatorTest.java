package edu.ncsu.csc316.dsa.data;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the studentGPAComparatorTest.
 *
 * @author Teddy Zhang
 */
public class StudentGPAComparatorTest {

  private Student sone;
  private Student stwo;
  private Student sthree;
  private Student sfour;
  private Student sfive;

  private StudentGPAComparator comparator;

  /**
   * Setup student information.
   */
  @Before
  public void setUp() {
    sone = new Student("OneFirst", "OneLast", 1, 1, 1.0, "oneUnityID");
    stwo = new Student("TwoFirst", "TwoLast", 2, 2, 2.0, "twoUnityID");
    sthree = new Student("ThreeFirst", "ThreeLast", 3, 3, 3.0, "threeUnityID");
    sfour = new Student("FourFirst", "FourLast", 4, 4, 4.0, "fourUnityID");
    sfive = new Student("FiveFirst", "FiveLast", 5, 5, 5.0, "fiveUnityID");

    comparator = new StudentGPAComparator();
  }

  /**
   * Testing the compare method.
   */
  @Test
public void testCompare() {
    assertTrue(comparator.compare(stwo, sone) < 0);
    assertFalse(comparator.compare(sone, stwo) < 0);

    sfour.setGpa(3.0);
    assertTrue(comparator.compare(sthree, sfour) == 0);

    assertTrue(comparator.compare(sfive, sone) < 0);
  }

}
