package edu.ncsu.csc316.dsa.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the student class.
 *
 * @author Teddy Zhang
 */
public class StudentTest {

  private Student sone;
  private Student stwo;
  private Student sthree;
  private Student sfour;
  private Student sfive;

  /**
   * Sets up the information for students.
   */
  @Before
public void setUp() {
    sone = new Student("OneFirst", "OneLast", 1, 1, 1.0, "oneUnityID");
    stwo = new Student("TwoFirst", "TwoLast", 2, 2, 2.0, "twoUnityID");
    sthree = new Student("ThreeFirst", "ThreeLast", 3, 3, 3.0, "threeUnityID");
    sfour = new Student("FourFirst", "FourLast", 4, 4, 4.0, "fourUnityID");
    sfive = new Student("FiveFirst", "FiveLast", 5, 5, 5.0, "fiveUnityID");
  }

  /**
   * Tests setting the first name.
   */
  @Test
public void testSetFirst() {
    sone.setFirst("newOne");
    assertEquals("newOne", sone.getFirst());
  }

  /**
   * Tests setting the flast name.
   */
  @Test
public void testSetLast() {
    sone.setLast("newOne");
    assertEquals("newOne", sone.getLast());
  }
  
  /**
   * Tests setting the id.
   */
  @Test
public void testSetId() {
    sone.setId(100);
    assertEquals(100, sone.getId());
  }
  
  /**
   * Tests setting the gpa.
   */
  @Test
public void testSetGpa() {
    sone.setGpa(3.51);
    assertEquals(3.51, sone.getGpa(), 0.001);
  }

  /**
   * Tests setting the unity id.
   */
  @Test
public void testSetUnityId() {
    sone.setUnityId("oneUnity");
    assertEquals("oneUnity", sone.getUnityId());
  }

  /**
   * Tests the compare to method.
   */
  @Test
public void testCompareTo() {
    assertTrue(sone.compareTo(stwo) < 0);
    assertTrue(stwo.compareTo(sone) > 0);
    assertTrue(sone.compareTo(sone) == 0);
    assertTrue(stwo.compareTo(stwo) == 0);

    sfour = new Student("FourFirst", "OneLast", 1, 1, 1.0, "oneUnityID");
    assertTrue(sone.compareTo(sfour) > 0);
  }

  /**
   * Tests setting the credit hours.
   */
  @Test
public void testSetCreditHours() {
    sthree.setCreditHours(5);
    assertEquals(5, sthree.getCreditHours());
  }

  /**
   * Tests the equal method.
   */
  @Test
public void testEquals() {
    assertTrue(sone.equals(sone));
    assertFalse(sone.equals(stwo));
  }

  /**
   * Tests the toString method.
   */
  @Test
public void testToString() {
    assertEquals("FiveFirst FiveLast 5", sfive.toString());
  }


}
