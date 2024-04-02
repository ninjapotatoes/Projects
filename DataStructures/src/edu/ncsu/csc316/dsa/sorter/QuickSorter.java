package edu.ncsu.csc316.dsa.sorter;

import java.util.Comparator;

/**
 * QuickSorter sorts arrays of comparable elements using the quicksort
 * algorithm. This implementation allows the client to specify a specific pivot
 * selection strategy: (a) use the first element as the pivot, (b) use the last
 * element as the pivot, (c) use the middle element as the pivot, or (d) use an
 * element at a random index as the pivot.
 * Using the randomized pivot selection strategy ensures O(nlogn)
 * expected/average case runtime when sorting n elements that are comparable
 *
 * @author Dr. King
 *
 * @param <E> the type of elements to sort; elements must be {@link Comparable}
 */
public class QuickSorter<E extends Comparable<E>> extends AbstractComparisonSorter<E> {

  /**
   * Defines the behaviors of a PivotSelector.
   *
   * @author Dr. King
   *
   */
  private interface PivotSelector {
    /**
     * Returns the index of the selected pivot element.
     *
     * @param low  - the lowest index to consider
     * @param high - the highest index to consider
     * @return the index of the selected pivot element
     */
    int selectPivot(int low, int high);
  }
    
  /**
   * FirstElementSelector chooses the first index of the array as the index of the
   * pivot element that should be used when sorting.
   *
   * @author Dr. King
   *
   */
  public static class FirstElementSelector implements PivotSelector {

    @Override
    public int selectPivot(int low, int high) {
      return low;
    }
  }
    
  /**
   * LastElementSelector chooses the last index of the array as the index of the
   * pivot element that should be used when sorting.
   *
   * @author Dr. King
   *
   */
  public static class LastElementSelector implements PivotSelector {

    @Override
    public int selectPivot(int low, int high) {
      return high;
    }
  }

  /**
   * MiddleElementSelector chooses the middle index of the array as the index of the
   * pivot element that should be used when sorting.
   *
   * @author Dr. King
   *
   */
  public static class MiddleElementSelector implements PivotSelector {

    @Override
    public int selectPivot(int low, int high) {
      return (low + high) / 2;
    }
  }

  /**
   * RandomElementSelector chooses a random index of the array as the index of the
   * pivot element that should be used when sorting.
   *
   * @author Dr. King
   *
   */
  public static class RandomElementSelector implements PivotSelector {

    @Override
    public int selectPivot(int low, int high) {
      return (int) (Math.random() * (high - low + 1)) + low;
    }
  }

  /**
   * Pivot selection strategy that uses the element at the first index each time a
   * pivot must be selected.
   */
  public static final PivotSelector FIRST_ELEMENT_SELECTOR = new FirstElementSelector();

  /**
   * Pivot selection strategy that uses the element at the last index each time a
   * pivot must be selected.
   */
  public static final PivotSelector LAST_ELEMENT_SELECTOR = new LastElementSelector();

  /**
   * Pivot selection strategy that uses the element at the middle index each time
   * a pivot must be selected.
   */
  public static final PivotSelector MIDDLE_ELEMENT_SELECTOR = new MiddleElementSelector();

  /**
   * Pivot selection strategy that uses the element at a randomly-chosen index
   * each time a pivot must be selected.
   */
  public static final PivotSelector RANDOM_ELEMENT_SELECTOR = new RandomElementSelector();

  /** Clients chosen pivot selector. */
  private PivotSelector selector;

  /**
   * Constructs a new QuickSorter with a provided custom Comparator and a
   * specified PivotSelector strategy.
   *
   * @param comparator a custom comparator to use when sorting
   * @param selector   the pivot selection strategy to use when selecting pivots
   */
  public QuickSorter(Comparator<E> comparator, PivotSelector selector) {
    super(comparator);
    setSelector(selector);
  }

  /**
   * Constructs a new QuickSorter using the natural ordering of elements. Pivots
   * are selected using the provided PivotSelector strategy.
   *
   * @param selector the pivot selection strategy to use when selecting pivots
   */
  public QuickSorter(PivotSelector selector) {
    this(null, selector);
  }

  /**
   * Constructs a new QuickSorter with a provided custom Comparator and the
   * default random pivot selection strategy.
   *
   * @param comparator a custom comparator to use when sorting
   */
  public QuickSorter(Comparator<E> comparator) {
    this(comparator, null);
  }

  /**
   * Constructs a new QuickSorter that uses an element's natural ordering and uses
   * the random pivot selection strategy.
   */
  public QuickSorter() {
    this(null, null);
  }

  private void setSelector(PivotSelector selector) {
    if (selector == null) {
      this.selector = new RandomElementSelector();
    } else {
      this.selector = selector;
    }
  }

  /**
   * Sorts the given list using quick sort.
   */
  @Override
  public void sort(E[] data) {
    quicksort(data, 0, data.length - 1);
  }
  
  /**
   * Sorts list using the given list and index range.
   *
   * @param data list to sort
   * @param low beginning index of array to sort
   * @param high end index of array to sort
   */
  private void quicksort(E[] data, int low, int high) {
    if  (low < high) {
      int pivotLocation = partition(data, low, high);
      quicksort(data, low, pivotLocation - 1);
      quicksort(data, pivotLocation + 1, high);
      
    }
  }
  
  /**
   * Moves values < pivots to be before the pivot index and values > pivot to
   *  be after the pivot index.
   *
   * @param data array to be sorted
   * @param low beginning index
   * @param high end index
   * @return index of pivot element
   */
  private int partition(E[] data, int low, int high) {
    int pivotIndex = selector.selectPivot(low, high);

    swap(data, pivotIndex, high);
    return partitionHelper(data, low, high);
  }
  
  /**
   * Moves values < pivot to be before the pivot index and values > pivot
   *  to be after the pivot index.
   *
   * @param data array to be sorted
   * @param low beginning index
   * @param high end index
   * @return index of pivot element
   */
  private int partitionHelper(E[] data, int low, int high) {
    E pivot = data[high];
    int separator = low;
    for (int j = low; j <= high - 1; j++) {
      if (compare(data[j], pivot) <= 0) {
        swap(data, separator, j);
        separator = separator + 1;
      }
    }
    swap(data, separator, high);
    return separator;
  }

  /**
   * Swaps the element at given indexes in the given array.
   *
   * @param data array to be modified
   * @param i index 1 of swap element
   * @param j index 2 of element to be swapped
   */
  private void swap(E[] data, int i, int j) {
    E temp = data[i];
    data[i] = data[j];
    data[j] = temp;
  }
}