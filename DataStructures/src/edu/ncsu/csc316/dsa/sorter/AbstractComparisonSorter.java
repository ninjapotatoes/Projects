package edu.ncsu.csc316.dsa.sorter;

import java.util.Comparator;

/**
 * Abstract class for comparison.
 *
 * @author Teddy Zhang
 * @param <E> Element
 */
public abstract class AbstractComparisonSorter<E extends Comparable<E>> implements Sorter<E> {

  private Comparator<E> comparator;
    
  public AbstractComparisonSorter(Comparator<E> comparator) {
    setComparator(comparator);
  }
    
  private void setComparator(Comparator<E> comparator) {
    if (comparator == null) {
      this.comparator = new NaturalOrder();
    } else {
      this.comparator = comparator;
    }
  }   
    
  private class NaturalOrder implements Comparator<E> {
    public int compare(E first, E second) {
      return ((Comparable<E>) first).compareTo(second);
    }
  }
    
  public int compare(E first, E second) {
    return comparator.compare(first,  second);
  }
}