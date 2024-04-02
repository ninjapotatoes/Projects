package edu.ncsu.csc316.dsa.sorter;

import edu.ncsu.csc316.dsa.data.Identifiable;

/**
 * CountingSorter uses the counting sort algorithm to sort data.
 *
 * @author Dr. King
 *
 * @param <E> the generic type of data to sort
 */
public class CountingSorter<E extends Identifiable> implements Sorter<E> {
    
  /**
  * Sorts the list using counting sort.
 *
 * @param data list of elements to be sorted.
  */
  public void sort(E[] data) {
    if (data.length != 0) {
      E min = data[0];
      E max = data[0];
      
      for (int i = 0; i < data.length; i++) {
        min = min(data[i], min);
        max = max(data[i], max);
      }
      
      int k = max.getId() - min.getId() + 1;
      
      int[] b = new int[k];
      
      for (int i = 0; i <= data.length - 1; i++) {
        b[data[i].getId() - min.getId()]++;
      }
      
      for (int i = 1; i <= k - 1; i++) {
        b[i] = b[i - 1] + b[i];
      }
      
      @SuppressWarnings("unchecked")
      E[] f = (E[]) (new Identifiable[ data.length ]);

      for (int i = data.length - 1; i >= 0; i--) {
        f[b[data[i].getId() - min.getId()] - 1] = data[i];
        b[data[i].getId() - min.getId()]--;
      }
      
      //A <-- F
      for (int i = 0; i < data.length; i++) {
        data[i] = f[i];
      }
    }
    
  }
    
  /**
 * Helper method to find the min of two numbers.
 */
  private E min(E a, E b) {
    if (a.getId() < b.getId()) {
      return a;
    } else {
      return b;
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
