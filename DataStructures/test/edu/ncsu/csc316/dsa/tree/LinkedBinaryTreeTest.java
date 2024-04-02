package edu.ncsu.csc316.dsa.tree;

import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Before;
import org.junit.Test;
import edu.ncsu.csc316.dsa.Position;

/**
 * Test class for LinkedBinaryTree
 * Checks the expected outputs of the BinaryTree abstract data type behaviors when using
 * a linked data structure to store elements
 *
 * @author Dr. King
 * @author // Your Name Here 
 *
 */
public class LinkedBinaryTreeTest {

    private LinkedBinaryTree<String> tree;
    private Position<String> one;
    private Position<String> two;
    private Position<String> three;
    private Position<String> four;
    private Position<String> five;
    private Position<String> six;
    private Position<String> seven;
    private Position<String> eight;
    private Position<String> nine;
    private Position<String> ten;

    /**
     * Create a new instance of a linked binary tree before each test case executes
     */       
    @Before
    public void setUp() {
        tree = new LinkedBinaryTree<String>(); 
    }
    
    /**
     * Sample tree to help with testing
     *
     * One
     * -> Two
     *   -> Six
     *   -> Ten
     *     -> Seven
     *     -> Five
     * -> Three
     *   -> Four
     *     -> Eight
     *     -> Nine
     * 
     * Or, visually:
     *                    one
     *                /        \
     *             two          three
     *            /   \            /
     *         six   ten          four
     *              /   \        /     \
     *            seven  five  eight nine    
     */  
    private void createTree() {
        one = tree.addRoot("one");
        two = tree.addLeft(one, "two");
        three = tree.addRight(one, "three");
        six = tree.addLeft(two, "six");
        ten = tree.addRight(two, "ten");
        four = tree.addLeft(three, "four");
        seven = tree.addLeft(ten, "seven");
        five = tree.addRight(ten, "five");
        eight = tree.addLeft(four, "eight");
        nine = tree.addRight(four, "nine");
    }
    
    /**
     * Test the output of the set(p,e) behavior
     */     
    @Test
    public void testSet() {
        createTree();
        
        //test set root
        tree.set(one, "eleven");
        assertEquals("eleven", one.getElement());
        //test set non root non leaf
        tree.set(two, "twelve");
        assertEquals("twelve", two.getElement());
        //test set leaf
        tree.set(eight, null);
        assertNull(eight.getElement());
        
        assertEquals("five", five.getElement());
        assertEquals("seven", seven.getElement());
    }
    
    /**
     * Test the output of the size() behavior
     */     
    @Test
    public void testSize() {
        assertEquals(0, tree.size());
        
        assertTrue(tree.isEmpty());
        createTree();     

        assertEquals(10, tree.size());
    }
    
    /**
     * Test the output of the numChildren(p) behavior
     */     
    @Test
    public void testNumChildren() {
        createTree();
        assertEquals(2, tree.numChildren(one)); // root
        assertEquals(2, tree.numChildren(two)); // 2
        assertEquals(1, tree.numChildren(three)); // 1
        assertEquals(0, tree.numChildren(eight)); // 0
    }

    /**
     * Test the output of the parent(p) behavior
     */   
    @Test
    public void testParent() {
        createTree();
        assertEquals(one, tree.parent(two)); 
        assertEquals(one, tree.parent(three));
    }

    /**
     * Test the output of the sibling behavior
     */     
    @Test
    public void testSibling() {
        createTree();
        assertEquals(three, tree.sibling(two)); 
        assertEquals(two, tree.sibling(three)); 
        assertNull(tree.sibling(one)); 
    }

    /**
     * Test the output of the isInternal behavior
     */     
    @Test
    public void testIsInternal() {
        createTree();
        assertTrue(tree.isInternal(one));
        assertFalse(tree.isInternal(six)); 
    }

    /**
     * Test the output of the isLeaf behavior
     */     
    @Test
    public void isLeaf() {
        createTree();
        assertFalse(tree.isLeaf(one));
        assertTrue(tree.isLeaf(six)); 
    }

    /**
     * Test the output of the isRoot(p)
     */     
    @Test
    public void isRoot() {
        createTree();
        assertTrue(tree.isRoot(one)); 
        assertFalse(tree.isRoot(two));
    }
    
    /**
     * Test the output of the preOrder traversal behavior
     */     
    @Test
    public void testPreOrder() {
        createTree();
        
        // Expected pre-order: one, two, six, ten, seven, five, three, four, eight, nine
        Iterator<Position<String>> preOrderIterator = tree.preOrder().iterator();
        
        assertEquals("one", preOrderIterator.next().getElement());
        assertEquals("two", preOrderIterator.next().getElement());
        assertEquals("six", preOrderIterator.next().getElement());
        assertEquals("ten", preOrderIterator.next().getElement());
        assertEquals("seven", preOrderIterator.next().getElement());
        assertEquals("five", preOrderIterator.next().getElement());
        assertEquals("three", preOrderIterator.next().getElement());
        assertEquals("four", preOrderIterator.next().getElement());
        assertEquals("eight", preOrderIterator.next().getElement());
        assertEquals("nine", preOrderIterator.next().getElement());
        assertFalse(preOrderIterator.hasNext());
        
        try {
            preOrderIterator.remove();
            fail();
        } catch (UnsupportedOperationException e) {
            assertEquals("The remove operation is not supported yet.", e.getMessage());
        }
    }

    /**
     * Test the output of the postOrder traversal behavior
     */     
    @Test
    public void testPostOrder() {
        createTree();
        
        // Expected post-order: six, seven, five, ten, two, eight, nine, four, three, one
        Iterator<Position<String>> postOrderIterator = tree.postOrder().iterator();
        
        assertEquals("six", postOrderIterator.next().getElement());
        assertEquals("seven", postOrderIterator.next().getElement());
        assertEquals("five", postOrderIterator.next().getElement());
        assertEquals("ten", postOrderIterator.next().getElement());
        assertEquals("two", postOrderIterator.next().getElement());
        assertEquals("eight", postOrderIterator.next().getElement());
        assertEquals("nine", postOrderIterator.next().getElement());
        assertEquals("four", postOrderIterator.next().getElement());
        assertEquals("three", postOrderIterator.next().getElement());
        assertEquals("one", postOrderIterator.next().getElement());
        assertFalse(postOrderIterator.hasNext());
    }
    
    /**
     * Test the output of the inOrder traversal behavior
     */     
    @Test
    public void testInOrder() {
        createTree();
        
        // Expected In-Order: six, two, seven, ten, five, one, eight, four, nine, three
        Iterator<Position<String>> inOrderIterator = tree.inOrder().iterator();
        
        assertEquals("six", inOrderIterator.next().getElement());
        assertEquals("two", inOrderIterator.next().getElement());
        assertEquals("seven", inOrderIterator.next().getElement());
        assertEquals("ten", inOrderIterator.next().getElement());
        assertEquals("five", inOrderIterator.next().getElement());
        assertEquals("one", inOrderIterator.next().getElement());
        assertEquals("eight", inOrderIterator.next().getElement());
        assertEquals("four", inOrderIterator.next().getElement());
        assertEquals("nine", inOrderIterator.next().getElement());
        assertEquals("three", inOrderIterator.next().getElement());
        assertFalse(inOrderIterator.hasNext());
    }

    /**
     * Test the output of the Binary Tree ADT behaviors on an empty tree
     */     
    @Test
    public void testEmptyTree() {
    	assertTrue(tree.isEmpty());
        assertEquals(0, tree.size());
        assertNull(tree.root()); 
    }
    
    @Test
    public void testLevelOrder() {
        createTree();
        
        // Expected level-order: one, two, three, six, ten, four, seven, five, eight, nine
        Iterator<Position<String>> levelOrderIterator = tree.levelOrder().iterator();
        
        assertEquals("one", levelOrderIterator.next().getElement());
        assertEquals("two", levelOrderIterator.next().getElement());
        assertEquals("three", levelOrderIterator.next().getElement());
        assertEquals("six", levelOrderIterator.next().getElement());
        assertEquals("ten", levelOrderIterator.next().getElement());
        assertEquals("four", levelOrderIterator.next().getElement());
        assertEquals("seven", levelOrderIterator.next().getElement());
        assertEquals("five", levelOrderIterator.next().getElement());
        assertEquals("eight", levelOrderIterator.next().getElement());
        assertEquals("nine", levelOrderIterator.next().getElement());
        assertFalse(levelOrderIterator.hasNext());
    }

    /**
     * Test the output of the addLeft(p,e) behavior, including expected exceptions
     */      
    @Test
    public void testAddLeft() {
        LinkedBinaryTree<String> tree2 = new LinkedBinaryTree<>();

        Position<String> root = tree2.addRoot("root");
        
        Position<String> leftChild = tree2.addLeft(root, "leftChild");
        assertEquals("leftChild", tree2.left(root).getElement());
        assertEquals("leftChild", leftChild.getElement());
        try {
            tree.addLeft(root, "left2");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Node already has a left child.", e.getMessage());
        }
    }
    
    /**
     * Test the output of the addRight(p,e) behavior, including expected exceptions
     */      
    @Test
    public void testAddRight() {
    	LinkedBinaryTree<String> tree2 = new LinkedBinaryTree<>();

        Position<String> root = tree2.addRoot("root");
        
        Position<String> rightChild = tree2.addRight(root, "rightChild");
        assertEquals("rightChild", tree2.right(root).getElement());
        assertEquals("rightChild", rightChild.getElement());
        
        try {
            tree.addRight(root, "right2");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Node already has a right child.", e.getMessage());
        }
    }   
    
    /**
     * Test the output of the remove(p) behavior, including expected exceptions
     */         
    @Test
    public void testRemove() {
        createTree();
        //0 child
        assertEquals("nine", tree.remove(nine));
        assertNull(tree.parent(nine));
        assertEquals(9, tree.size());
        
        //1 child
        assertEquals("four", tree.remove(four));
        assertEquals("eight", tree.left(three).getElement());
        assertNull(tree.parent(four));
        assertEquals(8, tree.size());
        
        //remove node with child
        assertEquals("seven", tree.remove(seven));
        assertNull(tree.parent(seven));
        assertEquals(7, tree.size());
        
        
        assertEquals("six", tree.remove(six));
        assertNull(tree.parent(six));
        assertEquals(6, tree.size());
        
        
        assertEquals("one", tree.root().getElement());
        assertEquals("two", tree.left(tree.root()).getElement());
        assertEquals("three", tree.right(tree.root()).getElement());
        assertEquals("eight", tree.left(tree.right(tree.root())).getElement());
        assertEquals("ten", tree.right(tree.left(tree.root())).getElement());
        assertEquals("five", tree.right(tree.right(tree.left(tree.root()))).getElement());
        
        assertEquals("two", tree.remove(two));
        assertEquals("ten", tree.left(one).getElement());
        assertEquals("five", tree.right(tree.left(one)).getElement());
        /*
                    	  one
     *                /        \
     *             two          three
     *            /   \            /
     *                ten          
     *              /   \        /     \
     *                  five  eight  
         */
    }
    
    /**
     * Additional test to test the two string method
     */
    @Test
    public void testToString() {
    	createTree();
    	
    	String expected = "LinkedBinaryTree[\n" +
                "one\n" +
                " two\n" +
                "  six\n" +
                "  ten\n" +
                "   seven\n" +
                "   five\n" +
                " three\n" +
                "  four\n" +
                "   eight\n" +
                "   nine\n" +
                "]";
    	
    	assertEquals(expected, tree.toString());
    }
}
