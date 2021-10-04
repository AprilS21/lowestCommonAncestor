import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TestLCA {
    @Test

    public void testBST(){
         BST bst = new BST();
        bst.put(7, 7);   //        _7_
         bst.put(8, 8);   //      /     \
         bst.put(3, 3);   //    _3_      8
         bst.put(1, 1);   //  /     \
         bst.put(2, 2);   // 1       6
         bst.put(6, 6);   //  \     /
         bst.put(4, 4);   //   2   4
         bst.put(5, 5); 
         assertEquals("Checking order of constructed tree",
                 "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder()); 
        bst = new BST();
        bst.put("f",1); //       f
        bst.put("a",2); //    e     k
        bst.put("k",3); //   a        x
        bst.put("x",4); //
        bst.put("e",5); //
        assertEquals("((()a(()e()))f(()k(()x())))",bst.printKeysInOrder());


    }

    @Test
    public void testFindX(){
        BST bst = new BST();
        bst.put(7, 7);   //        _7_
         bst.put(8, 8);   //      /     \
         bst.put(3, 3);   //    _3_      8
         bst.put(1, 1);   //  /     \
         bst.put(2, 2);   // 1       6
         bst.put(6, 6);   //  \     /
         bst.put(4, 4);   //   2   4
         bst.put(5, 5); 
         BST.Node test;
         test = bst.findX(bst.root, 7);
         assertEquals(bst.getKey(test).toString(), "7");
         test = bst.findX(bst.root, 4);
         assertEquals(bst.getKey(test).toString(), "4");
         test = bst.findX(bst.root, 9);
         assertEquals(test, null);
         assertEquals(bst.getKey(test), null);

    }

    @Test
    public void testLowestCommonAncestor(){
        BST bst = new BST();
        bst.put("f",1); //       f
        bst.put("a",2); //    e     k
        bst.put("k",3); //   a        x
        bst.put("x",4); //
        bst.put("e",5); //
         String a = "x";
         String b = "a";
         System.out.println("The LCA of these two values is : "+ bst.lowestCommonAncestor(a, b));
         //assertEquals(bst.lowestCommonAncestor("1", "6"),"3");
    }
}
