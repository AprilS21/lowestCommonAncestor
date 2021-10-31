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
    public void testLowestCommonAncestorBST(){
        BST bst = new BST();
        bst.put("f",1); //       f
        bst.put("a",2); //    e     k
        bst.put("k",3); //   a        x
        bst.put("x",4); //
        bst.put("e",5); //
         String a = "x";
         String b = "a";
         System.out.println("The LCA of these two values is : "+ bst.lowestCommonAncestor(a, b));
         assertEquals("f",bst.lowestCommonAncestor(a, b));
        a = "m";                                //element not in BST
        assertEquals("LCA does not exist for these two values",bst.lowestCommonAncestor(a, b));

    }


    @Test
    public void testAddEdgeDAG() {
        DAG dag = new DAG(10);
        assertEquals("0: \n1: \n2: \n3: \n4: \n5: \n6: \n7: \n8: \n9: \n", dag.toString());
        dag.addEdge(0, 9);
        dag.addEdge(0, 4);
        dag.addEdge(2, 9);
        assertEquals("0: 9 4 \n1: \n2: 9 \n3: \n4: \n5: \n6: \n7: \n8: \n9: \n", dag.toString());

        //add edge between 0 and non-existent vertex.
        dag.addEdge(0, 10);
        assertEquals("0: 9 4 \n1: \n2: 9 \n3: \n4: \n5: \n6: \n7: \n8: \n9: \n", dag.toString());
    }

    @Test
    public void testAddCycleDAG() {
        //Add edge that would result in a cycle in a bidirectional graph. Should successfully add.
        DAG dag = new DAG(10);//    1
        dag.addEdge(1, 3);  //    /  \
        dag.addEdge(3, 7);  //   3   5
        dag.addEdge(1, 5);  //    \ /
        dag.addEdge(5, 7);  //     7
        dag.addEdge(7, 9);  //     |
                            //     9

        //add edge to make cycle.
        dag.addEdge(0, 4);
        dag.addEdge(4, 6);
        dag.addEdge(6, 0);  //cycle 0->4->6->0
        assertEquals("0: 4 \n1: 3 5 \n2: \n3: 7 \n4: 6 \n5: 7 \n6: \n7: 9 \n8: \n9: \n", dag.toString());
    }

    @Test
    public void testLowestCommonAncestorDAG() {
        DAG dag = new DAG(10);

        dag.addEdge(0, 3);  //     0
        dag.addEdge(0, 5);  //    / \
        dag.addEdge(3, 7);  //   3   5
        dag.addEdge(5, 7);  //    \ / \
        dag.addEdge(7, 8);  //     7   9
        dag.addEdge(5, 9);  //     |   |
        dag.addEdge(9, 4);  //     8   4

        assertEquals(null, dag.lowestCommonAncestors(-1, 3)); //vertex not in graph

        assertEquals("[]", dag.lowestCommonAncestors(6, 4).toString());
        assertEquals("[2]", dag.lowestCommonAncestors(2, 2).toString());
        assertEquals("[5]", dag.lowestCommonAncestors(7, 9).toString());
        assertEquals("[5]", dag.lowestCommonAncestors(8, 4).toString());
        assertEquals("[0]", dag.lowestCommonAncestors(3, 4).toString());

      dag = new DAG(10);
      dag.addEdge(0, 4);
      dag.addEdge(0, 6);
      dag.addEdge(3, 4);
      dag.addEdge(3, 6);
      assertEquals("[0, 3]", dag.lowestCommonAncestors(4, 6).toString());
    }

    

}
