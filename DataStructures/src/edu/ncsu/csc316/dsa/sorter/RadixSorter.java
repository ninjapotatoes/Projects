package edu.ncsu.csc316.dsa.sorter;

import edu.ncsu.csc316.dsa.data.Identifiable;

/**
 * RadixSorter uses the radix sort algorithm to sort data.
 *
 * @author Dr. King
 *
 * @param <E> the generic type of data to sort
 */
public class RadixSorter<E extends Identifiable> implements Sorter<E> {
  /**
  * Sorts the given list using the radix sort algorithm.
  *
  * @param data list of elements to be sorted.
  */
  public void sort(E[] data) {
    if (data.length != 0) {
      E k = data[0];
      for (int i = 0; i < data.length; i++) {
        k = max(k, data[i]);
      }
      
      int x = (int) Math.ceil(Math.log(k.getId() + 1) / Math.log(10));

      int p = 1;

      for (int j = 1; j <= x; j++) {
        int[] b = new int[10];
        
        for (int i = 0; i <= data.length - 1; i++) {
          b[(data[i].getId() / p) % 10]++;
        }

        for (int i = 1; i <= 9; i++) {
          b[i] = b[i - 1] + b[i];
        }

        @SuppressWarnings("unchecked")
        E[] f = (E[]) (new Identifiable[ data.length]);

        for (int i = data.length - 1; i >= 0; i--) {
          f[b[(data[i].getId() / p) % 10] - 1] = data[i];
          b[(data[i].getId() / p) % 10]--;
        }
        
        for (int i = 0; i < data.length; i++) {
          data[i] = f[i];
        }

        p = p * 10;
      }
    }
  }

  /**
 * Helper method to find the max of two numbers.
 */
  private E max(E a, E b) {
    if (a.getId() > b.getId()) {
      return a;
    } else {
      return b;
    }
  }
}
