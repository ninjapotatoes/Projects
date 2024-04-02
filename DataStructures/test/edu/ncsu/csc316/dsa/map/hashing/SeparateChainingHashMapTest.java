package edu.ncsu.csc316.dsa.map.hashing;

import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Before;
import org.junit.Test;
import edu.ncsu.csc316.dsa.map.Map;

/**
 * Test class for SeparateChainingHashMap
 * Checks the expected outputs of the Map abstract data type behaviors when using
 * a separate chaining hash map data structure 
 *
 * @author Dr. King
 * @author // Your Name Here 
 *
 */
public class SeparateChainingHashMapTest {

    // 'Testing' Map used (no randomization) to check ordering of contents
    private Map<Integer, String> testMap;
    
    // 'Production' Map (with randomization) to check correctness of ADT behaviors
    private Map<Integer, String> prodMap;
    
    /**
     * Create a new instance of a separate chaining hash map before each test case executes
     */     
    @Before
    public void setUp() {
        // Use the "true" flag to indicate we are TESTING.
        // Remember that (when testing) alpha = 1, beta = 1, and prime = 7
        // based on our AbstractHashMap constructor.
        // That means you can draw the hash table by hand
        // if you use integer keys, since Integer.hashCode() = the integer value, itself
        // Finally, apply compression. For example:
        // for key = 1: h(1) = ( (1 * 1 + 1) % 7) % 7 = 2
        // for key = 2: h(2) = ( (1 * 2 + 1) % 7) % 7 = 3
        // for key = 3: h(3) = ( (1 * 3 + 1) % 7) % 7 = 4
        // for key = 4: h(4) = ( (1 * 4 + 1) % 7) % 7 = 5
        // for key = 5: h(5) = ( (1 * 5 + 1) % 7) % 7 = 6
        // for key = 6: h(6) = ( (1 * 6 + 1) % 7) % 7 = 0
        // etc.
        // Remember that our secondary map (an AVL tree) is a search
        // tree, which means the entries should be sorted in order within
        // that tree
        testMap = new SeparateChainingHashMap<Integer, String>(7, true);
        prodMap = new SeparateChainingHashMap<Integer, String>();
    }
    
    /**
     * Test the output of the put(k,v) behavior
     */     
    @Test
    public void testPut() {
        assertEquals(0, testMap.size());
        assertTrue(testMap.isEmpty());
        assertNull(testMap.put(3, "string3"));

        // Since our entrySet method returns the entries in the table
        // from left to right, we can use the entrySet to check
        // that our values are in the correct order in the hash table.
        // Alternatively, you could implement a toString() method if you
        // want to check that the exact index/map of each bucket is correct
        Iterator<Map.Entry<Integer, String>> it = testMap.entrySet().iterator();
        assertEquals(3, (int)it.next().getKey()); // should be in a map in index 4
        
        
        assertNull(testMap.put(4, "string4"));
        assertEquals(2, testMap.size());
        assertFalse(testMap.isEmpty());
        it = testMap.entrySet().iterator();
        assertEquals(3, (int)it.next().getKey()); // should be in a map in index 4
        assertEquals(4, (int)it.next().getKey()); // should be in a map in index 5
        
        //key 3 collide
        testMap.put(10, "string10");
        //key 10 collide
        testMap.put(17, "string17");
        assertEquals(4, testMap.size());
        
        assertEquals("string3", testMap.get(3));
        assertEquals("string4", testMap.get(4));
        assertEquals("string10", testMap.get(10));
        assertEquals("string17", testMap.get(17));
        
        //test prodMap
        prodMap.put(3, "string3");
        prodMap.put(4, "string4");
        prodMap.put(10, "string10");
        prodMap.put(17, "string17");
        assertEquals(4, prodMap.size());
        assertEquals("string3", prodMap.get(3));
        assertEquals("string4", prodMap.get(4));
        assertEquals("string10", prodMap.get(10));
        assertEquals("string17", prodMap.get(17));
    }
    
    /**
     * Test the output of the get(k) behavior
     */     
    @Test
    public void testGet() {
        assertTrue(testMap.isEmpty());
        
        testMap.put(3, "string3");
        testMap.put(4, "string4");

        assertEquals("string3", testMap.get(3));
        assertEquals("string4", testMap.get(4));
        assertNull(testMap.get(5)); // Non-existent key

        //test prodMap
        prodMap.put(3, "string3");
        prodMap.put(4, "string4");
        assertEquals("string3", prodMap.get(3));
        assertEquals("string4", prodMap.get(4));
        assertNull(prodMap.get(5)); 
    }
    
    /**
     * Test the output of the remove(k) behavior
     */     
    @Test
    public void testRemove() {
        assertTrue(testMap.isEmpty());
        
        testMap.put(3, "string3");
        testMap.put(4, "string4");

        //make sure the removed entry is null
        assertEquals("string3", testMap.remove(3));
        assertNull(testMap.get(3));
        assertEquals(1, testMap.size());

        //test prodMap
        prodMap.put(3, "string3");
        prodMap.put(4, "string4");
        assertEquals("string3", prodMap.remove(3));
        assertNull(prodMap.get(3));
    }
    
    /**
     * Test the output of the iterator() behavior, including expected exceptions
     */   
    @Test
    public void testIterator() {
    	testMap.put(3, "string3");
        testMap.put(4, "string4");
        
        Iterator<Integer> it = testMap.iterator();
        assertTrue(it.hasNext());
        assertEquals(3, (int) it.next());
        assertTrue(it.hasNext());
        assertEquals(4, (int) it.next());
        assertFalse(it.hasNext());
    }
    
    /**
     * Test the output of the entrySet() behavior
     */   
    @Test
    public void testEntrySet() {
    	testMap.put(3, "string3");
        testMap.put(4, "string4");
        
        Iterator<Map.Entry<Integer, String>> it = testMap.entrySet().iterator();        
        assertTrue(it.hasNext());
        
        Map.Entry<Integer, String> entry1 = it.next();
        assertEquals(3, (int) entry1.getKey());
        assertEquals("string3", entry1.getValue());
        assertTrue(it.hasNext());
        
        Map.Entry<Integer, String> entry2 = it.next();
        assertEquals(4, (int) entry2.getKey());
        assertEquals("string4", entry2.getValue());
        assertFalse(it.hasNext());
    }
    
    /**
     * Test the output of the values() behavior
     */   
    @Test
    public void testValues() {
    	testMap.put(3, "string3");
        testMap.put(4, "string4");
        
        Iterator<String> it = testMap.values().iterator();
        assertTrue(it.hasNext());
        assertEquals("string3", it.next());
        assertTrue(it.hasNext());
        assertEquals("string4", it.next());
        assertFalse(it.hasNext());
    }
}