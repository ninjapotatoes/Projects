/**
 * Package location of sorter.
 */

package edu.ncsu.csc316.dsa.sorter;

import java.util.Comparator;

/**
 * BubbleSorter uses the bubble sort algorithm to sort data.
 *
 * @author Teddy Zhang
 *
 * @param <E> the generic type of data to sort
 */
public class BubbleSorter<E extends Comparable<E>> extends AbstractComparisonSorter<E> {

  /**
 * Initializes parameterless bubble sorter.
 */
  public BubbleSorter() {
    this(null);
  }
    
  /**
  * Initializes bubble sorter with the given comparator.
  *
  * @param comparator used to determine what order to order elements
  */
  public BubbleSorter(Comparator<E> comparator) {
    super(comparator);
  }

  /**
     * Sorts the elements using selection sort.
     *
     * @param data list of elements to be sorted.
     */
  public void sort(E[] data) {
    boolean r = true;
    while (r) {
      r = false;
      for (int i = 1; i <= data.length - 1; i++) {
        if (super.compare(data[i], data[i - 1]) < 0) {
          E x = data[i - 1];
          data[i - 1] = data[i];
          data[i] = x;
          r = true;
        }
      }
    }
  }
}
