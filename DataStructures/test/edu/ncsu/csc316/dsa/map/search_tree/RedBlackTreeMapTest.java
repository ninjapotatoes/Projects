package edu.ncsu.csc316.dsa.map.search_tree;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for RedBlackTreeMap
 * Checks the expected outputs of the Map abstract data type behaviors when using
 * a red-black tree data structure 
 *
 * @author Dr. King
 * @author // Your Name Here 
 *
 */
public class RedBlackTreeMapTest {

    private BinarySearchTreeMap<Integer, String> tree;
    
    /**
     * Create a new instance of a red-black tree-based map before each test case executes
     */  
    @Before
    public void setUp() {
        tree = new RedBlackTreeMap<Integer, String>();
    }
    
    /**
     * Test the output of the put(k,v) behavior
     */     
    @Test
    public void testPut() {
        assertEquals(0, tree.size());
        assertTrue(tree.isEmpty());
        
        tree.put(10, "A");
        assertFalse(tree.isEmpty());
        assertEquals(1, tree.size());
        assertEquals("A", tree.get(10));

        // Test inserting elements with different keys
        tree.put(5, "B");
        tree.put(15, "C");
        tree.put(20, "D");

        assertEquals(4, tree.size());
        assertEquals("B", tree.get(5));
        assertEquals("C", tree.get(15));
        assertEquals("D", tree.get(20));
        
        // Test updating existing key
        tree.put(10, "E");
        assertEquals("E", tree.get(10));   
        
        tree.remove(5);
        tree.remove(15);
        tree.remove(20);

    }
    
    /**
     * Test the output of the get(k) behavior
     */     
    @Test
    public void testGet() {
    	assertTrue(tree.isEmpty());
        assertEquals(0, tree.size());
        assertEquals(null, tree.get(10));

        tree.put(10, "A");
        tree.put(5, "B");
        tree.put(15, "C");
        tree.put(20, "D");

        assertEquals("A", tree.get(10));
        assertEquals("B", tree.get(5));
        assertEquals("C", tree.get(15));
        assertEquals("D", tree.get(20));
        
        assertEquals(null, tree.get(25));
    }
    
    /**
     * Test the output of the remove(k) behavior
     */     
    @Test
    public void testRemove() {
        assertTrue(tree.isEmpty());
        assertEquals(0, tree.size());
        assertTrue(tree.isEmpty());

        
        //empty remove
        assertEquals(null, tree.remove(10));
        
        //remove smthn that doenst' exist
        tree.put(10, "A");
        tree.put(5, "B");
        tree.put(15, "C");
        assertEquals(null, tree.remove(20));
        
        //remove normall
        assertEquals("A", tree.remove(10));
        assertEquals("C", tree.remove(15));
        assertEquals("B", tree.remove(5));
        
        assertEquals(0, tree.size());
        assertTrue(tree.isEmpty());         
        
        //case 1 resolve red
        tree.put(10, "A");
        tree.put(5, "B");
        tree.put(15, "C");
        tree.put(20, "D");
        tree.put(17, "E");
    }
}