package edu.ncsu.csc316.dsa.map.search_tree;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import edu.ncsu.csc316.dsa.map.search_tree.*;

/**
 * Test class for SplayTreeMap
 * Checks the expected outputs of the Map abstract data type behaviors when using
 * a splay tree data structure 
 *
 * @author Dr. King
 * @author Teddy Zhang
 *
 */
public class SplayTreeMapTest {

    private BinarySearchTreeMap<Integer, String> tree;
    
    /**
     * Create a new instance of a splay tree-based map before each test case executes
     */     
    @Before
    public void setUp() {
        tree = new SplayTreeMap<Integer, String>();
    }
    
    /**
     * Test the output of the put(k,v) behavior
     */     
    @Test
    public void testPut() {
        assertEquals(0, tree.size());
        assertTrue(tree.isEmpty());
        
        tree.put(5, "five");
        assertEquals(1, tree.size());
        assertEquals(5, (int)tree.root().getElement().getKey());
        
        //zig-zig
        tree.put(3, "three");
        assertEquals(2, tree.size());
        assertEquals(3, (int)tree.root().getElement().getKey());
        
        //zig-zag
        tree.put(4, "four");
        assertEquals(3, tree.size());
        assertEquals(4, (int)tree.root().getElement().getKey());
        
        //insert again
        tree.put(4, "fourUpdated");
        assertEquals(3, tree.size());
        assertEquals("fourUpdated", tree.get(4));     
    }
    
    /**
     * Test the output of the get(k) behavior
     */ 
    @Test
    public void testGet() {
    	assertNull(tree.get(10));
        
        tree.put(7, "seven");
        tree.put(5, "five");
        tree.put(9, "nine");
        
        assertEquals("seven", tree.get(7));
        
        assertEquals(7, (int)tree.root().getElement().getKey());
    }
    
    /**
     * Test the output of the remove(k) behavior
     */     
    @Test
    public void testRemove() {
    	tree.put(1, "one");
        tree.put(2, "two");
        tree.put(3, "three");
        
        assertEquals("two", tree.remove(2));
        assertEquals(2, tree.size());
        assertNull(tree.get(2)); // Node 2 is removed
        
        assertEquals("one", tree.remove(1));
        assertEquals(1, tree.size());
        assertNull(tree.get(1)); // Node 1 is removed
        
        assertEquals("three", tree.remove(3));
        assertEquals(0, tree.size());
        assertNull(tree.get(3)); // Node 3 is removed     
    }
}