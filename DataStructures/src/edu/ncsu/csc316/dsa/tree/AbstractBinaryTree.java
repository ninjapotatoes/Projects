package edu.ncsu.csc316.dsa.tree;

import edu.ncsu.csc316.dsa.Position;
import edu.ncsu.csc316.dsa.tree.AbstractTree.PositionCollection;

/**
 * A skeletal implementation of the Binary Tree abstract data type. This class
 * provides implementation for common methods that can be implemented the same
 * no matter what specific type of concrete data structure is used to implement
 * the binary tree abstract data type.
 * 
 * @author Dr. King
 * @author // Your Name Here
 *
 * @param <E> the type of elements stored in the binary tree
 */
public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {
    
    
	@Override
    public Iterable<Position<E>> inOrder() {
		PositionCollection traversal = new PositionCollection();
        if (!isEmpty()) {
            inOrderHelper(root(), traversal);
        }
        return traversal;
    }

    private void inOrderHelper(Position<E> p, PositionCollection traversal) {
    	if(p == null) {
    		return;
    	}
    	inOrderHelper(left(p), traversal);
    	if (p.getElement() != null) {
            traversal.add(p);
        }
    	inOrderHelper(right(p), traversal);
    }
    
    /**
     * Returns the number of children of the provided position
     * 
     * @param p a position for which to retrieve the number of children of the
     *          position
     * @return the number of children of the provided position
     * @throws IllegalArgumentException if the position, p, does not represent a
     *                                  valid tree position
     */
    @Override
    public int numChildren(Position<E> p) {
        AbstractTreeNode<E> node = validate(p);
        
        int counter = 0;
        
        if(left(node) != null) {
        	counter++;
        }
        
        if(right(node) != null) {
        	counter++;
        }
        
        return counter;
    }
    
    /**
     * Returns the position that is the sibling of the provided position, p
     * 
     * @param p the position for which to return the sibling of the position
     * @return the position that is the sibling of the provided position
     * @throws IllegalArgumentException if the position, p, does not represent a
     *                                  valid tree position
     */
    @Override
    public Position<E> sibling(Position<E> p) {
        AbstractTreeNode<E> node = validate(p);
        
        Position<E> parent = parent(node);
        
        if(parent == null) {
        	return null;
        }
        
        if(node == left(parent)) {
        	return right(parent);
        }
        
        if(node == right(parent)) {
        	return left(parent);
        }
        
        //if somehow neither
        return null;
    }
    
    @Override
    public Iterable<Position<E>> children(Position<E> p) {
        AbstractTreeNode<E> node = validate(p);
        PositionCollection childrenCollection = new PositionCollection();
        if (left(node) != null) {
            childrenCollection.add(left(node));
        }
        if (right(node) != null) {
            childrenCollection.add(right(node));
        }
        return childrenCollection;
    }
}
