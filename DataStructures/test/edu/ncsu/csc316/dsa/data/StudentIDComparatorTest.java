package edu.ncsu.csc316.dsa.data;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the studentIDComparatorTest.
 *
 * @author Teddy Zhang
 */
public class StudentIDComparatorTest {

  private Student sone;
  private Student stwo;
  private Student sthree;
  private Student sfour;
  private Student sfive;

  private StudentIDComparator comparator;

  /**
   * Sets up the student information.
   */
  @Before
public void setUp() {
    sone = new Student("OneFirst", "OneLast", 1, 1, 1.0, "oneUnityID");
    stwo = new Student("TwoFirst", "TwoLast", 2, 2, 2.0, "twoUnityID");
    sthree = new Student("ThreeFirst", "ThreeLast", 3, 3, 3.0, "threeUnityID");
    sfour = new Student("FourFirst", "FourLast", 4, 4, 4.0, "fourUnityID");
    sfive = new Student("FiveFirst", "FiveLast", 5, 5, 5.0, "fiveUnityID");

    comparator = new StudentIDComparator();
  }

  /**
   * Tests the compare to method.
   */
  @Test
public void testCompare() {
    assertTrue(comparator.compare(sone, stwo) < 0);
    assertFalse(comparator.compare(stwo, sone) < 0);

    sfour.setId(3);
    assertTrue(comparator.compare(sthree, sfour) == 0);

    assertTrue(comparator.compare(sone, sfive) < 0);
  }


}
