package edu.ncsu.csc316.dsa.data;

import java.util.Comparator;

/**
 * Comparator for comparing Students based on GPA.
 *
 * @author Dr. King
 */
public class StudentGPAComparator implements Comparator<Student> {

  /**
     * Compares students based on GPA in descending order.
     */
  @Override
    public int compare(Student one, Student two) {
    // Flip sign of comparison to descend order
    return -1 * Double.valueOf(one.getGpa()).compareTo(Double.valueOf(two.getGpa()));
  }

}