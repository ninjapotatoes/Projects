package edu.ncsu.csc316.dsa.sorter;

import java.util.Comparator;

/**
 * MergeSorter sorts arrays of comparable elements using the merge sort
 * algorithm. This implementation ensures O(nlogn) worst-case runtime to sort an
 * array of n elements that are comparable.
 *
 * @author Dr. King
 *
 * @param <E> the type of elements to sort; elements must be {@link Comparable}
 */
public class MergeSorter<E extends Comparable<E>> extends AbstractComparisonSorter<E> {

  /**
   * Constructs a new MergeSorter with a specified custom Comparator.
   *
   * @param comparator a custom Comparator to use when sorting
   */
  public MergeSorter(Comparator<E> comparator) {
    super(comparator);
  }

  /**
   * Constructs a new MergeSorter with comparisons based on the element's natural
   * ordering.
   */ 
  public MergeSorter() {
    this(null);
  }

  /**
   * Sorts the list using the merge sort algorithm.
   *
   * @param data to be sorted
   */
  @Override
  public void sort(E[] data) {
    
    if (!(data.length < 2)) {
      int mid = data.length / 2;
      E[] left = copyArray(data, 0, mid - 1);
      E[] right = copyArray(data, mid, data.length - 1);
    
      sort(left);
      sort(right);
      merge(left, right, data);
    }
    
  }
  
  /**
   * Merges two arrays into one.
   *
   * @param left array to merge
   * @param right array to merge
   * @param data array to merge into
   */
  private void merge(E[] left, E[] right, E[] data) {
    int leftIndex = 0;
    int rightIndex = 0;
    while (leftIndex + rightIndex < data.length) {
      if (rightIndex == right.length || (leftIndex < left.length 
          && compare(left[leftIndex], right[rightIndex]) < 0)) {
        data[leftIndex + rightIndex] = left[leftIndex];
        leftIndex = leftIndex + 1;
      } else {
        data[leftIndex + rightIndex] = right[rightIndex];
        rightIndex = rightIndex + 1;
      }
    }
  }
  
  /**
   * Copies the array.
   *
   * @param original array
   * @param start of array
   * @param end of array
   * @return copied array
   */
  private E[] copyArray(E[] original, int start, int end) {
    int size = end - start + 1;
    @SuppressWarnings("unchecked")
    E[] newArr = (E[]) new Comparable[size];

    for (int i = 0; i < size; i++) {
      newArr[i] = original[start + i];
    }

    return newArr;
  }

}