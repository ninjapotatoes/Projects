package edu.ncsu.csc316.dsa.priority_queue;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import edu.ncsu.csc316.dsa.data.Student;
import edu.ncsu.csc316.dsa.data.StudentIDComparator;

/**
 * Test class for HeapPriorityQueue
 * Checks the expected outputs of the Priorty Queue abstract data type behaviors when using
 * a min-heap data structure 
 *
 * @author Dr. King
 * @author // Your Name Here 
 *
 */
public class HeapPriorityQueueTest {

    private PriorityQueue<Integer, String> heap;
    
    /**
     * Create a new instance of a heap before each test case executes
     */     
    @Before
    public void setUp() {
        heap = new HeapPriorityQueue<Integer, String>();
    }
    
    /**
     * Test the output of the insert(k,v) behavior
     */     
    @Test
    public void testInsert() {
        assertTrue(heap.isEmpty());
        assertTrue(heap.size() == 0);
        
        heap.insert(8, "eight");
        assertEquals(1, heap.size());
        assertFalse(heap.isEmpty());
        assertEquals(8, (int)heap.min().getKey());
        
        heap.insert(7, "seven");
        assertEquals(2, heap.size());
        assertEquals(7, (int)heap.min().getKey());
        
        heap.insert(9, "nine");
        assertEquals(3, heap.size());
        assertEquals(7, (int)heap.min().getKey());
        
        heap.insert(6, "six");
        assertEquals(4, heap.size());
        assertEquals(6, (int)heap.min().getKey());
        
        heap.insert(10, "ten");
        assertEquals(5, heap.size());
        assertEquals(6, (int)heap.min().getKey());
    }
    
    /**
     * Test the output of the min behavior
     */ 
    @Test
    public void testMin() {
        assertTrue(heap.isEmpty());
        assertTrue(heap.size() == 0);
        
        assertNull(heap.min());
        
        heap.insert(8, "eight");
        assertEquals(8, (int)heap.min().getKey());
        
        heap.insert(7, "seven");
        assertEquals(7, (int)heap.min().getKey());
        
        heap.insert(9, "nine");
        assertEquals(7, (int)heap.min().getKey());
    }
    
    /**
     * Test the output of the deleteMin behavior
     */     
    @Test 
    public void deleteMin() {
        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());
        
        assertNull(heap.deleteMin());
        
        heap.insert(8, "eight");
        
        heap.insert(7, "seven");
        
        heap.insert(9, "nine");
        
        assertEquals("seven", heap.deleteMin().getValue());
        assertEquals(2, heap.size());
        
        assertEquals("eight", heap.deleteMin().getValue());
        assertEquals(1, heap.size());
        
        assertEquals("nine", heap.deleteMin().getValue());
        assertEquals(0, heap.size());
        
        assertTrue(heap.isEmpty());
    }
    
    /**
     * Test the output of the heap behavior when using arbitrary key objects to
     * represent priorities
     */ 
    @Test
    public void testStudentHeap() {
        PriorityQueue<Student, String> sHeap = new HeapPriorityQueue<Student, String>(new StudentIDComparator());
        Student s1 = new Student("J", "K", 1, 1, 1, "jk1");
        Student s2 = new Student("J", "S", 2, 1, 2, "js2");
        Student s3 = new Student("S", "H", 3, 1, 3, "sh3");
        Student s4 = new Student("J", "J", 4, 1, 4, "jj4");
        
        assertTrue(sHeap.isEmpty());
        assertEquals(0, sHeap.size());
        
        sHeap.insert(s1, "Student 1");
        assertEquals(1, sHeap.size());
        assertFalse(sHeap.isEmpty());
        assertEquals(s1, sHeap.min().getKey());
        
        sHeap.insert(s2, "Student 2");
        assertEquals(2, sHeap.size());
        assertEquals(s1, sHeap.min().getKey());
        
        sHeap.insert(s3, "Student 3");
        assertEquals(3, sHeap.size());
        assertEquals(s1, sHeap.min().getKey());
        
        sHeap.insert(s4, "Student 4");
        assertEquals(4, sHeap.size());
        assertEquals(s1, sHeap.min().getKey());

        sHeap.deleteMin();
        assertEquals(3, sHeap.size());
        assertEquals(s2, sHeap.min().getKey());
    }
}