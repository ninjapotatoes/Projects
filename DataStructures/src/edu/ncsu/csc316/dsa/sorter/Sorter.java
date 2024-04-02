package edu.ncsu.csc316.dsa.sorter;

/**
 * Interface that defines the sorting behavior.
 *
 * @author Dr. King
 * @param <E> Elements
 */
public interface Sorter<E> {
  void sort(E[] data);
}
