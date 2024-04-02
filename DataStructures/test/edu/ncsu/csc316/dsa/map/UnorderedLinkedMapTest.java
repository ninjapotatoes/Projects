package edu.ncsu.csc316.dsa.map;

import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for UnorderedLinkedMap
 * Checks the expected outputs of the Map abstract data type behaviors when using
 * an unordered link-based list data structure that uses the move-to-front heuristic for
 * self-organizing entries based on access frequency
 *
 * @author Dr. King
 *
 */
public class UnorderedLinkedMapTest {

    private Map<Integer, String> map;
    
    /**
     * Create a new instance of an unordered link-based map before each test case executes
     */     
    @Before
    public void setUp() {
        map = new UnorderedLinkedMap<Integer, String>();
    }
    
    /**
     * Test the output of the put(k,v) behavior
     */     
    @Test
    public void testPut() {
        assertEquals(0, map.size());
        assertTrue(map.isEmpty());
        assertNull(map.put(3, "string3"));
        assertEquals("UnorderedLinkedMap[3]", map.toString());
        assertEquals(1, map.size());

        // Add more elements and test put
        assertNull(map.put(1, "string1"));
        assertEquals("UnorderedLinkedMap[1, 3]", map.toString());
        //Change key that already is a thing
        assertEquals("string1", map.put(1, "newString1"));
        //Check update
        assertEquals("newString1", map.get(1)); 
    }

    /**
     * Test the output of the get(k) behavior
     */     
    @Test
    public void testGet() {
        assertTrue(map.isEmpty());
        assertNull(map.put(3, "string3"));
        assertNull(map.put(5, "string5"));
        assertNull(map.put(2, "string2"));
        assertNull(map.put(4, "string4"));
        assertNull(map.put(1, "string1"));
        assertFalse(map.isEmpty());
        assertEquals("UnorderedLinkedMap[1, 4, 2, 5, 3]", map.toString());
        
        assertEquals("string1", map.get(1));
        assertEquals("UnorderedLinkedMap[1, 4, 2, 5, 3]", map.toString());
        
        // Test accessing null
        assertNull(map.get(6));
    }
    
    /**
     * Test the output of the remove(k) behavior
     */     
    @Test
    public void testRemove() {
        assertTrue(map.isEmpty());
        assertNull(map.put(3, "string3"));
        assertNull(map.put(5, "string5"));
        assertNull(map.put(2, "string2"));
        assertNull(map.put(4, "string4"));
        assertNull(map.put(1, "string1"));
        assertFalse(map.isEmpty());
        assertEquals("UnorderedLinkedMap[1, 4, 2, 5, 3]", map.toString());
        
        //Test removing null return
        assertNull(map.remove(6));
        //Test removing with returned values
        assertEquals("string4", map.remove(4));
        assertEquals(4, map.size());
        assertEquals("UnorderedLinkedMap[1, 2, 5, 3]", map.toString());
    }

    /**
     * Test the output of the iterator behavior, including expected exceptions
     */     
    @Test
    public void testIterator() {
        assertNull(map.put(3, "string3"));
        assertNull(map.put(5, "string5"));
        assertNull(map.put(2, "string2"));
        assertNull(map.put(4, "string4"));
        assertNull(map.put(1, "string1"));

        //Get iterator
        Iterator<Integer> keys = map.iterator();
        //Make sure it is in order
        assertTrue(keys.hasNext());
        assertEquals(1, (int) keys.next());
        assertTrue(keys.hasNext());
        assertEquals(4, (int) keys.next());
        assertTrue(keys.hasNext());
        assertEquals(2, (int) keys.next());
        assertTrue(keys.hasNext());
        assertEquals(5, (int) keys.next());
        assertTrue(keys.hasNext());
        assertEquals(3, (int) keys.next());
        assertFalse(keys.hasNext());
    }

    /**
     * Test the output of the entrySet() behavior, including expected exceptions
     */     
    @Test
    public void testEntrySet() {
        assertNull(map.put(3, "string3"));
        assertNull(map.put(5, "string5"));
        assertNull(map.put(2, "string2"));
        assertNull(map.put(4, "string4"));
        assertNull(map.put(1, "string1"));
        
        //Get vals
        Iterable<Map.Entry<Integer, String>> entrySet = map.entrySet();
        
        //Check exp entries
        for (Map.Entry<Integer, String> entry : entrySet) {
            assertEquals(entry.getValue(), map.get(entry.getKey()));
        }
    }

    /**
     * Test the output of the values() behavior, including expected exceptions
     */     
    @Test
    public void testValues() {
        assertNull(map.put(3, "string3"));
        assertNull(map.put(5, "string5"));
        assertNull(map.put(2, "string2"));
        assertNull(map.put(4, "string4"));
        assertNull(map.put(1, "string1"));
        
        //Get vals
        Iterable<String> values = map.values();
        
        // Check exp vals
        Iterator<String> iterator = values.iterator();
        //for each value
        for (int i = 0; i < map.size(); i++) {
            boolean found = false;
            String value = iterator.next();
            Iterator<Map.Entry<Integer, String>> entryIterator = map.entrySet().iterator();
            
            //check the entries to check if the value is in it
            for (int j = 0; j < map.size(); j++) {
                Map.Entry<Integer, String> entry = entryIterator.next();
                if (entry.getValue().equals(value)) {
                    found = true;
                    break;
                }
            }
            assertTrue(found);
        }
    }
}
