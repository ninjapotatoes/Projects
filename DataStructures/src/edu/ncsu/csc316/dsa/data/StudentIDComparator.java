package edu.ncsu.csc316.dsa.data;

import java.util.Comparator;

/**
 * Comparator to compare students based on ID number.
 *
 * @author Dr. King
 */
public class StudentIDComparator implements Comparator<Student> {

  /**
     * Compares students based on ID number in ascending order.
     */
  @Override
    public int compare(Student one, Student two) {
    return Integer.valueOf(one.getId()).compareTo(Integer.valueOf(two.getId()));
  }

}
