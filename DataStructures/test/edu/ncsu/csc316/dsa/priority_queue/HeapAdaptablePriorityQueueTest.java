package edu.ncsu.csc316.dsa.priority_queue;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.data.Student;
import edu.ncsu.csc316.dsa.data.StudentIDComparator;
import edu.ncsu.csc316.dsa.priority_queue.PriorityQueue.Entry;

/**
 * Test class for HeapAdaptablePriorityQueue
 * Checks the expected outputs of the Adaptable Priorty Queue abstract
 * data type behaviors when using a min-heap data structure 
 *
 * @author Dr. King
 * @author // Your Name Here 
 *
 */
public class HeapAdaptablePriorityQueueTest {

    private HeapAdaptablePriorityQueue<Integer, String> heap;
    
    /**
     * Create a new instance of a heap before each test case executes
     */   
    @Before
    public void setUp() {
        heap = new HeapAdaptablePriorityQueue<Integer, String>();
    }
    
    /**
     * Test the output of the replaceKey behavior
     */     
    @Test
    public void testReplaceKey() {
        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());
        
        Entry<Integer, String> e8 = heap.insert(8, "eight");
        Entry<Integer, String> e7 = heap.insert(7, "seven");
        Entry<Integer, String> e6 = heap.insert(6, "six");
        Entry<Integer, String> e5 = heap.insert(5, "five");
        Entry<Integer, String> e4 = heap.insert(4, "four");
        Entry<Integer, String> e3 = heap.insert(3, "three");
        Entry<Integer, String> e2 = heap.insert(2, "two");
        Entry<Integer, String> e1 = heap.insert(1, "one");
        Entry<Integer, String> e0 = heap.insert(0, "zero");
        assertEquals(9, heap.size());
        
        heap.replaceKey(e8,  -5);
        assertEquals(-5, (int)heap.min().getKey());
        assertEquals("eight", heap.min().getValue());
        assertEquals(9, heap.size());
        
        heap.replaceKey(e0,  10);
        assertEquals(-5, (int)heap.min().getKey());
        assertEquals("eight", heap.min().getValue());
        assertEquals(9, heap.size());
        
        heap.replaceKey(e8,  20);
        assertEquals(1, (int)heap.min().getKey());
        assertEquals("one", heap.min().getValue());
        assertEquals(9, heap.size());
        
        assertNotNull(e8);
        assertNotNull(e7);
        assertNotNull(e6);
        assertNotNull(e5);
        assertNotNull(e4);
        assertNotNull(e3);
        assertNotNull(e2);
        assertNotNull(e1);
    }
    
    /**
     * Test the output of the replaceValue behavior
     */ 
    @Test
    public void testReplaceValue() {
        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());
        
        Entry<Integer, String> e8 = heap.insert(8, "eight");
        Entry<Integer, String> e7 = heap.insert(7, "seven");
        Entry<Integer, String> e6 = heap.insert(6, "six");
        Entry<Integer, String> e5 = heap.insert(5, "five");
        Entry<Integer, String> e4 = heap.insert(4, "four");
        Entry<Integer, String> e3 = heap.insert(3, "three");
        Entry<Integer, String> e2 = heap.insert(2, "two");
        Entry<Integer, String> e1 = heap.insert(1, "one");
        Entry<Integer, String> e0 = heap.insert(0, "zero");
        assertEquals(9, heap.size());
        
        heap.replaceValue(e8,  "EIGHT");
        assertEquals(0, (int)heap.min().getKey());
        assertEquals("zero", heap.min().getValue());
        assertEquals(9, heap.size());
        assertEquals("EIGHT",  e8.getValue());
        
        heap.replaceValue(e0, "ZERO");
        assertEquals(0, (int)heap.min().getKey());
        assertEquals("ZERO", heap.min().getValue());
        assertEquals(9, heap.size());
        
        heap.replaceValue(e7, "SEVEN");
        assertEquals(0, (int)heap.min().getKey());
        assertEquals("ZERO", heap.min().getValue());
        assertEquals(9, heap.size());
        
        assertNotNull(e8);
        assertNotNull(e7);
        assertNotNull(e6);
        assertNotNull(e5);
        assertNotNull(e4);
        assertNotNull(e3);
        assertNotNull(e2);
        assertNotNull(e1);
    }

    /**
     * Test the output of the remove behavior
     */ 
    @Test
    public void testRemove() {
        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());
        
        Entry<Integer, String> e8 = heap.insert(8, "eight");
        Entry<Integer, String> e7 = heap.insert(7, "seven");
        Entry<Integer, String> e6 = heap.insert(6, "six");
        Entry<Integer, String> e5 = heap.insert(5, "five");
        Entry<Integer, String> e4 = heap.insert(4, "four");
        Entry<Integer, String> e3 = heap.insert(3, "three");
        Entry<Integer, String> e2 = heap.insert(2, "two");
        Entry<Integer, String> e1 = heap.insert(1, "one");
        Entry<Integer, String> e0 = heap.insert(0, "zero");
        assertEquals(9, heap.size());
        
        heap.remove(e0);
        assertEquals(1, (int)heap.min().getKey());
        assertEquals("one", heap.min().getValue());
        assertEquals(8, heap.size());
        
        heap.remove(e6);
        assertEquals(1, (int)heap.min().getKey());
        assertEquals("one", heap.min().getValue());
        assertEquals(7, heap.size());
        
        heap.remove(e7);
        assertEquals(1, (int)heap.min().getKey());
        assertEquals("one", heap.min().getValue());
        assertEquals(6, heap.size());
        
        assertNotNull(e8);
        assertNotNull(e7);
        assertNotNull(e5);
        assertNotNull(e4);
        assertNotNull(e3);
        assertNotNull(e2);
        assertNotNull(e1);
    }
    
    
    /**
     * Test the output of the heap behavior when using arbitrary key objects to
     * represent priorities
     */     
    @Test
    public void testStudentHeap() {
        AdaptablePriorityQueue<Student , String> sHeap = new HeapAdaptablePriorityQueue<Student, String>(new StudentIDComparator());
        Student s1 = new Student("J", "K", 1, 1, 1, "jk1");
        Student s2 = new Student("J", "S", 2, 1, 2, "js2");
        Student s3 = new Student("S", "H", 3, 1, 3, "sh3");
        Student s4 = new Student("J", "J", 4, 1, 4, "jj4");
        Student s5 = new Student("L", "B", 5, 1, 5, "lb5");
        
        assertTrue(sHeap.isEmpty());
        assertEquals(0, sHeap.size());
        
        
        Entry<Student, String> s12 = sHeap.insert(s1, "Student1");
        Entry<Student, String> s22 = sHeap.insert(s2, "Student2");
        Entry<Student, String> s32 = sHeap.insert(s3, "Student3");
        Entry<Student, String> s42 = sHeap.insert(s4, "Student4");
        Entry<Student, String> s52 = sHeap.insert(s5, "Student5");
        

        
        assertEquals(5, sHeap.size());
        

        s4.setId(6);
        sHeap.replaceKey(s42, s4);
        assertEquals(s1, sHeap.min().getKey());
        
        sHeap.replaceValue(s12, "UpdatedStudent1");
        assertEquals("UpdatedStudent1", sHeap.min().getValue());
        
        sHeap.remove(s12);
        assertEquals(4, sHeap.size());
        assertFalse(sHeap.isEmpty());
        
        assertNotNull(s12);
        assertNotNull(s22);
        assertNotNull(s32);
        assertNotNull(s52);
    }
}