package edu.ncsu.csc316.dsa.sorter;

import java.util.Comparator;

/**
 * InsertionSorter uses the insertion sort algorithm to sort data.
 *
 * @author Dr. King
 * @param <E> the type for the object
 */
public class InsertionSorter<E extends Comparable<E>> extends AbstractComparisonSorter<E> {

  /**
 * Initializes parameterless insertion sorter.
 */
  public InsertionSorter() {
    this(null);
  }
    
  /**
 * Initializes insertion sorter with the given comparator.
 *
 * @param comparator used to determine what order to order elements
 */
  public InsertionSorter(Comparator<E> comparator) {
    super(comparator);
  }

  /**
 * Sorts the elements using insertion sort.
 *
 * @param data list of elements to be sorted.
 */
  public void sort(E[] data) {
    for (int i = 1; i <= data.length - 1; i++) {
      E x = data[i];
      int j = i - 1;
      while (j >= 0 && super.compare(data[j], x) > 0) {
        data[j + 1] = data[j];
        j = j - 1;
      }
      data[j + 1] = x;
    }
  }

}
