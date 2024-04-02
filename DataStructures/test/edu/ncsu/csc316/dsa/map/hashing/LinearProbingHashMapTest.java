package edu.ncsu.csc316.dsa.map.hashing;

import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Before;
import org.junit.Test;
import edu.ncsu.csc316.dsa.map.Map;

/**
 * Test class for LinearProbingHashMap
 * Checks the expected outputs of the Map abstract data type behaviors when using
 * a linear probing hash map data structure 
 *
 * @author Dr. King
 * @author Teddy Zhang
 *
 */
public class LinearProbingHashMapTest {

    // 'Testing' Map used (no randomization) to check placement of entries in the hash table
    private Map<Integer, String> testMap;
    
    // 'Production' Map (with randomization) to check correctness of ADT behaviors
    private Map<Integer, String> prodMap;

    /**
     * Create a new instance of a linear probing hash map before each test case executes
     */     
    @Before
    public void setUp() {
        // Use the "true" flag to indicate we are testing.
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
        testMap = new LinearProbingHashMap<Integer, String>(7, true);
        prodMap = new LinearProbingHashMap<Integer, String>();
    }
    
    /**
     * Test the output of the put(k,v) behavior
     */     
    @Test
    public void testPut() {
       assertEquals(0, testMap.size());
       assertTrue(testMap.isEmpty());
       
       testMap.put(1, "string1");
       testMap.put(2, "string2");
       testMap.put(3, "string3");
       testMap.put(4, "string4");
       testMap.put(5, "string5");
       testMap.put(6, "string6");
        
       assertEquals(6, testMap.size());
       assertEquals("string1", testMap.get(1));
       assertEquals("string2", testMap.get(2));
       assertEquals("string3", testMap.get(3));
       assertEquals("string4", testMap.get(4));
       assertEquals("string5", testMap.get(5));
       assertEquals("string6", testMap.get(6));
        
       // Test put on prodMap
       prodMap.put(1, "string1");
       prodMap.put(2, "string2");
       prodMap.put(3, "string3");
       prodMap.put(4, "string4");
       prodMap.put(5, "string5");
       prodMap.put(6, "string6");
        
       assertEquals(6, prodMap.size());
       assertEquals("string1", prodMap.get(1));
       assertEquals("string2", prodMap.get(2));
       assertEquals("string3", prodMap.get(3));
       assertEquals("string4", prodMap.get(4));
       assertEquals("string5", prodMap.get(5));
       assertEquals("string6", prodMap.get(6));
    }
    
    /**
     * Test the output of the get(k) behavior
     */     
    @Test
    public void testGet() {
       assertTrue(testMap.isEmpty());
        
       testMap.put(1, "string1");
       testMap.put(2, "string2");
        
       assertEquals("string1", testMap.get(1));
       assertEquals("string2", testMap.get(2));
       assertNull(testMap.get(3));
        
        //prodmap
       assertTrue(prodMap.isEmpty());
        
       prodMap.put(1, "string1");
       prodMap.put(2, "string2");
        
       assertEquals("string1", prodMap.get(1));
       assertEquals("string2", prodMap.get(2));
       assertNull(prodMap.get(3));
    }
    
    /**
     * Test the output of the remove(k) behavior
     */ 
    @Test
    public void testRemove() {
       assertTrue(testMap.isEmpty());
        
       testMap.put(1, "string1");
       testMap.put(2, "string2");
        
       assertEquals("string1", testMap.remove(1));
       assertNull(testMap.get(1));
       assertEquals(1, testMap.size());
        
       //prodmap
       assertTrue(prodMap.isEmpty());
        
       prodMap.put(1, "string1");
       prodMap.put(2, "string2");
        
       assertEquals("string1", prodMap.remove(1));
       assertNull(prodMap.get(1));
       assertEquals(1, prodMap.size());
    }
    
    /**
     * Test the output of the iterator() behavior, including expected exceptions
     */     
    @Test
    public void testIterator() {
    	setUp();
    	
     	testMap.put(1, "string1");
        testMap.put(2, "string2");
         
        Iterator<Integer> it = testMap.iterator();
        assertTrue(it.hasNext());
        
        //prodmap
        assertTrue(prodMap.isEmpty());
        
        prodMap.put(1, "string1");
        prodMap.put(2, "string2");
        
        it = prodMap.iterator();
        assertTrue(it.hasNext());
    
    }
    
    /**
     * Test the output of the entrySet() behavior
     */     
    @Test
    public void testEntrySet() { 
    	setUp();
    	
    	assertTrue(testMap.isEmpty());
        
        testMap.put(1, "string1");
        testMap.put(2, "string2");
        
        Iterator<Map.Entry<Integer, String>> it = testMap.entrySet().iterator();     
        
        assertTrue(it.hasNext());
        
        //prodmap
        assertTrue(prodMap.isEmpty());
        
        prodMap.put(1, "string1");
        prodMap.put(2, "string2");
        
        it = prodMap.entrySet().iterator();
        assertTrue(it.hasNext());
    }
    
    /**
     * Test the output of the values() behavior
     */  
    @Test
    public void testValues() {
    	setUp();
    	
    	assertTrue(testMap.isEmpty());
        
        testMap.put(1, "string1");
        testMap.put(2, "string2");
        
        Iterator<String> it = testMap.values().iterator();
        
        assertTrue(it.hasNext());
        
        //prodmap
        assertTrue(prodMap.isEmpty());
        
        prodMap.put(1, "string1");
        prodMap.put(2, "string2");
        
        it = prodMap.values().iterator();
        assertTrue(it.hasNext());
    }
}