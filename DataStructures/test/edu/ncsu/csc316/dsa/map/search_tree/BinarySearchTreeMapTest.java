package edu.ncsu.csc316.dsa.map.search_tree;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for BinarySearchTreeMap
 * Checks the expected outputs of the Map and Tree abstract data type behaviors when using
 * an linked binary tree data structure 
 *
 * @author Dr. King
 * @author // Your Name Here 
 *
 */
public class BinarySearchTreeMapTest {

    private BinarySearchTreeMap<Integer, String> tree;
    
    /**
     * Create a new instance of a binary search tree map before each test case executes
     */
    @Before
    public void setUp() {
        tree = new BinarySearchTreeMap<Integer, String>();
    }
    
    /**
     * Test the output of the put(k,v) behavior
     */     
    @Test
    public void testPut() {
        assertEquals(0, tree.size());
        assertTrue(tree.isEmpty());
        tree.put(1, "one");
        assertEquals(1, tree.size());
        assertFalse(tree.isEmpty());
        assertEquals(1, (int)tree.root().getElement().getKey());
        
        tree.put(2, "two");
        tree.put(3, "three");
        tree.put(4, "four");
        
        assertEquals(2, (int)tree.right(tree.root()).getElement().getKey());
        assertEquals(3, (int)tree.right(tree.right(tree.root())).getElement().getKey());
        assertEquals(4, (int)tree.right(tree.right(tree.right(tree.root()))).getElement().getKey());
    }
    
    /**
     * Test the output of the get(k) behavior
     */     
    @Test
    public void testGet() {
        tree.put(1,  "one");
        assertEquals(1, tree.size());
        
        assertNull(tree.get(10));
        
        tree.put(2, "two");
        assertEquals("two", tree.get(2));
    }

    /**
     * Test the output of the remove(k) behavior
     */ 
    @Test
    public void testRemove() {
        tree.put(1,  "one");
        assertEquals(1, tree.size());
        
        assertNull(tree.remove(10));
        assertEquals(1, tree.size());
        
        assertEquals("one", tree.remove(1));
        assertEquals(0, tree.size());
        
        tree.put(1, "one");
        tree.put(2, "two");
        tree.put(3, "three");
        tree.put(4, "four");
        
        //root
        assertEquals("one", tree.remove(1));
        assertEquals(3, tree.size());
        assertEquals(2, (int)tree.root().getElement().getKey());
        
        //left child
        assertEquals("three", tree.remove(3));
        assertEquals(2, tree.size());
        assertNull(tree.right(tree.left(tree.root())));
        
        //right child
        assertEquals("four", tree.remove(4));
        assertEquals(1, tree.size());
        assertNull(tree.right(tree.right(tree.root())));
        
        //both children
        assertEquals("two", tree.remove(2));
        assertTrue(tree.isEmpty());
    }
    
    /**
     * Test the size of the tree after adding and removing elements
     */
    @Test
    public void testSize() {
        assertEquals(0, tree.size());
        assertTrue(tree.isEmpty());
        
        tree.put(1, "one");
        assertEquals(1, tree.size());
        assertFalse(tree.isEmpty());
        
        tree.put(2, "two");
        assertEquals(2, tree.size());
        
        tree.put(3, "three");
        assertEquals(3, tree.size());
        
        tree.remove(2);
        assertEquals(2, tree.size());
        
        tree.remove(3);
        tree.remove(1);
        assertEquals(0, tree.size());
        assertTrue(tree.isEmpty());
    }
    
    /**
     * Test the entry set of the tree
     */
    @Test
    public void testEntrySet() {
        tree.put(1, "one");
        tree.put(2, "two");
        tree.put(3, "three");
        //testing for coverage in binary search tree map
        int count = 0;
        for (@SuppressWarnings("unused") var entry : tree.entrySet()) {
            count++;
        }
        assertEquals(3, count);
    }
    
    
    /**
     * Test the root() method
     */
    @Test
    public void testRoot() {
        
        tree.put(1, "one");
        assertEquals(1, (int)tree.root().getElement().getKey());
        
        tree.put(2, "two");
        assertEquals(1, (int)tree.root().getElement().getKey());
    }
    
}