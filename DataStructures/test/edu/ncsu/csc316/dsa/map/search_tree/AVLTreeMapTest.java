package edu.ncsu.csc316.dsa.map.search_tree;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for AVLTreeMap
 * Checks the expected outputs of the Map abstract data type behaviors when using
 * an AVL tree data structure 
 *
 * @author Dr. King
 * @author // Your Name Here 
 *
 */
public class AVLTreeMapTest {

    private BinarySearchTreeMap<Integer, String> tree;
    
    /**
     * Create a new instance of an AVL tree-based map before each test case executes
     */     
    @Before
    public void setUp() {
        tree = new AVLTreeMap<Integer, String>();
    }
    
    /**
     * Test the output of the put(k,v) behavior
     */     
    @Test
    public void testPut() {
        assertEquals(0, tree.size());
        assertTrue(tree.isEmpty());
        
        tree.put(3, "three");
        tree.put(1, "one");
        tree.put(5, "five");
        tree.put(4, "four");
        tree.put(6, "six");

        assertEquals("three", tree.get(3));
        assertEquals("one", tree.get(1));
        assertEquals("five", tree.get(5));
        assertEquals("four", tree.get(4));
        assertEquals("six", tree.get(6));
        
        assertEquals("three", tree.remove(3));
        assertEquals("one", tree.remove(1));
        assertEquals("five", tree.remove(5));
        assertEquals("four", tree.remove(4));
        assertEquals("six", tree.remove(6));
        
        tree.put(3, "three");
        tree.put(2, "two");
        tree.put(1, "one");
        tree.put(4, "four");
        

    }
    
    /**
     * Test the output of the get(k) behavior
     */     
    @Test
    public void testGet() {
        assertTrue(tree.isEmpty());
        

        tree.put(3, "three");
        tree.put(1, "one");
        tree.put(5, "five");
        tree.put(4, "four");
        tree.put(6, "six");
        
        
        assertEquals("three", tree.get(3));
        assertEquals("one", tree.get(1));
        assertEquals("five", tree.get(5));
        assertEquals("four", tree.get(4));
        assertEquals("six", tree.get(6));
    }
    
    /**
     * Test the output of the remove(k) behavior
     */     
    @Test
    public void testRemove() {
        assertTrue(tree.isEmpty());
        
        tree.put(3, "three");
        tree.put(1, "one");
        tree.put(5, "five");
        tree.put(4, "four");
        tree.put(6, "six");
        
        assertEquals("three", tree.remove(3));
        assertEquals(4, tree.size());
        assertNull(tree.get(3));

        assertEquals("one", tree.remove(1));
        assertEquals(3, tree.size());
        assertNull(tree.get(1));

        assertEquals("six", tree.remove(6));
        assertEquals(2, tree.size());
        assertNull(tree.get(6));   
    }
}