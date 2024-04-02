package edu.ncsu.csc316.dsa.disjoint_set;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.Position;

/**
 * Test class for UpTreeDisjointSetForest
 * Checks the expected outputs of the Disjoint Set abstract data type 
 * behaviors when using an up-tree data structure
 *
 * @author Dr. King
 * @author Teddy Zhang
 *
 */
public class UpTreeDisjointSetForestTest {

    private DisjointSetForest<String> set;

    /**
     * Create a new instance of a up-tree forest before each test case executes
     */     
    @Before
    public void setUp() {
        set = new UpTreeDisjointSetForest<>();
    }
    
    /**
     * Test the output of the makeSet behavior
     */ 
    @Test
    public void testMakeSet() {
        Position<String> one = set.makeSet("one");
        assertEquals("one", one.getElement());
        Position<String> two = set.makeSet("two");
        assertEquals("two", two.getElement());
        
        Position<String> oneS = set.find("one");
        Position<String> twoS = set.find("two");
        assertNotEquals(oneS, twoS);
    }

    /**
     * Test the output of the union-find behaviors
     */     
    @Test
    public void testUnionFind() {
        Position<String> one = set.makeSet("one");
        Position<String> two = set.makeSet("two");
        Position<String> three = set.makeSet("three");
        Position<String> four = set.makeSet("four");
        Position<String> five = set.makeSet("five");
        Position<String> six = set.makeSet("six");
        Position<String> seven = set.makeSet("seven");
        Position<String> eight = set.makeSet("eight");
        Position<String> nine = set.makeSet("nine");
        Position<String> ten = set.makeSet("ten");
        
        assertEquals(one, set.find("one")); 
        assertEquals(two, set.find("two"));
        assertEquals(three, set.find("three"));
        assertEquals(four, set.find("four"));
        assertEquals(five, set.find("five"));
        assertEquals(six, set.find("six"));
        assertEquals(seven, set.find("seven"));
        assertEquals(eight, set.find("eight"));
        assertEquals(nine, set.find("nine"));
        assertEquals(ten, set.find("ten"));
        
        set.union(one, two);
        set.union(three, four);
        set.union(five, six);
        set.union(seven, eight);
        set.union(nine, ten);
        
        assertEquals(set.find("one"), set.find("two"));
        assertEquals(set.find("three"), set.find("four"));
        assertEquals(set.find("five"), set.find("six"));
        assertEquals(set.find("seven"), set.find("eight"));
        assertEquals(set.find("nine"), set.find("ten"));
    }
}