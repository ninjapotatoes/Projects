package edu.ncsu.csc316.dsa.tree;

import java.util.Iterator;

import edu.ncsu.csc316.dsa.Position;
import edu.ncsu.csc316.dsa.list.List;
import edu.ncsu.csc316.dsa.list.SinglyLinkedList;
import edu.ncsu.csc316.dsa.queue.ArrayBasedQueue;
import edu.ncsu.csc316.dsa.queue.Queue;

/**
 * A skeletal implementation of the Tree abstract data type. This class provides
 * implementation for common methods that can be implemented the same no matter
 * what specific type of concrete data structure is used to implement the tree
 * abstract data type.
 * 
 * @author Dr. King
 * @author // Your Name Here 
 *
 * @param <E> the type of elements stored in the tree
 */
public abstract class AbstractTree<E> implements Tree<E> {
    
    @Override
    public boolean isInternal(Position<E> p) {
        return numChildren(p) > 0;
    }
    
    @Override
    public boolean isLeaf(Position<E> p) {
        return numChildren(p) == 0;
    }
    
    @Override
    public boolean isRoot(Position<E> p) {
        return p == root();
    }
    
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
    
    /**
     * Updates the given position to have the provided element.
     * 
     * @param p       the position for which to update the element stored at that
     *                position
     * @param value the new element that should replace the existing element in
     *                the provided position
     * @return the original element that was replaced by the new element at the
     *         provided position
     * @throws IllegalArgumentException if the position, p, does not represent a
     *                                  valid tree position
     */
    @Override
    public E set(Position<E> p, E value) {
    	AbstractTreeNode<E> node = validate(p);
    	E ret = node.getElement();
    	node.setElement(value);
    	return ret;
    }   

    @Override
    public Iterable<Position<E>> preOrder() {
        PositionCollection traversal = new PositionCollection();
        if (!isEmpty()) {
            preOrderHelper(root(), traversal);
        }
        return traversal;
    }

    private void preOrderHelper(Position<E> p, PositionCollection traversal) {
        if(p.getElement() != null) {  // do not add sentinel nodes to the traversal
            traversal.add(p);
        }
        for (Position<E> c : children(p)) {
            preOrderHelper(c, traversal);
        }
    } 
    
    @Override
    public Iterable<Position<E>> postOrder() {
    	PositionCollection traversal = new PositionCollection();
        if (!isEmpty()) {
            postOrderHelper(root(), traversal);
        }
        return traversal;
    }
    
    private void postOrderHelper(Position<E> p, PositionCollection traversal) {
    	for (Position<E> c : children(p)) {
            postOrderHelper(c, traversal);
        }
    	
        if(p.getElement() != null) {  // do not add sentinel nodes to the traversal
            traversal.add(p);
        }
        
        
    }
    
    @Override
    public Iterable<Position<E>> levelOrder() {
    	Queue<Position<E>> queue = new ArrayBasedQueue<Position <E>>();
        PositionCollection traversal = new PositionCollection();
        
        //if not empty add the root
        if (!isEmpty()) {
            queue.enqueue(root());
            while (!queue.isEmpty()) {
            	//dequeue q and add its children
                Position<E> current = queue.dequeue();
                traversal.add(current);
                for (Position<E> child : children(current)) {
                    queue.enqueue(child);
                }
            }
        }
        return traversal;
    }
    
    /**
     * Safely casts a Position, p, to be an AbstractTreeNode.
     * 
     * @param p the position to cast to a AbstractTreeNode
     * @return a reference to the AbstractTreeNode
     * @throws IllegalArgumentException if p is null, or if p is not a valid
     *                                  AbstractTreeNode
     */
    protected abstract AbstractTreeNode<E> validate(Position<E> p);
    
    protected abstract static class AbstractTreeNode<E> implements Position<E> {

        private E element;
        
        public AbstractTreeNode(E element) {
            setElement(element);
        }
        
        @Override
        public E getElement() {
            return element;
        }
        
        public void setElement(E element) {
            this.element = element;
        }
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.getClass().getSimpleName() + "[\n");
        toStringHelper(sb, "", root());
        sb.append("]");
        return sb.toString();
    }
    
    private void toStringHelper(StringBuilder sb, String indent, Position<E> root) {
        if(root == null) {
            return;
        }
        sb.append(indent).append(root.getElement()).append("\n");
        for(Position<E> child : children(root)) {
            toStringHelper(sb, indent + " ", child);
        }
    }
    
    /**
     * PositionCollection implements the {@link Iterable} interface to allow traversing
     * through the positions of the tree. PositionCollection does not allow removal
     * operations
     * 
     * @author Dr. King
     *
     */
    protected class PositionCollection implements Iterable<Position<E>> {

        private List<Position<E>> list;

        /**
         * Construct a new PositionCollection
         */
        public PositionCollection() {
            list = new SinglyLinkedList<Position<E>>();
        }

        /**
         * Add a position to the collection. Null positions are not added.
         * 
         * @param position the position to add to the collection
         */
        public void add(Position<E> position) {
            if (position != null) {
                list.addLast(position);
            }
        }

        /**
         * Return an iterator for the PositionCollection
         *
         * @return a new position iterator
         */
        public Iterator<Position<E>> iterator() {
            return new PositionSetIterator();
        }

        private class PositionSetIterator implements Iterator<Position<E>> {

            private Iterator<Position<E>> it;

            public PositionSetIterator() {
                it = list.iterator();
            }

            @Override
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override
            public Position<E> next() {
                return it.next();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("The remove operation is not supported yet.");
            }
        }
    }
}
