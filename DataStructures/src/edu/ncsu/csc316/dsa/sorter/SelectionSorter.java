package edu.ncsu.csc316.dsa.sorter;

import java.util.Comparator;

/**
 * SelectionSorter uses the selection sort algorithm to sort data.
 *
 * @author Dr. King
 *
 * @param <E> the generic type of data to sort
 */
public class SelectionSorter<E extends Comparable<E>> extends AbstractComparisonSorter<E> {

  /**
 * Initializes parameterless selection sorter.
 */
  public SelectionSorter() {
    this(null);
  }

  /**
 * Initializes selection sorter with the given comparator.
 *
 * @param comparator used to determine what order to order elements
 */
  public SelectionSorter(Comparator<E> comparator) {
    super(comparator);
  }

  /**
 * Sorts the elements using selection sort.
 *
 * @param data list of elements to be sorted.
 */
  public void sort(E[] data) {
    for (int i = 0; i <= data.length - 1; i++) {
      int min = i;
      for (int j = i + 1; j <= data.length - 1; j++) {
        if (super.compare(data[j], data[min]) < 0) {
          min = j;
        }
      }
      if (!(i == min)) {
        E x = data[i];
        data[i] = data[min];
        data[min] = x;
      }
    }
  }
}
