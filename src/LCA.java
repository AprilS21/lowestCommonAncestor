import java.util.Scanner;

public class LCA {
   
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    BST bst = new BST();
    System.out.println("Input values for BST separated by commmas");
    String values = scanner.next();
    String[] split = values.split(",");
    for(int i=0; i < split.length; i++){
        bst.put(split[i],i);
    }
    for (Object s : bst.levelOrder()){
            System.out.println(s + " " + bst.get((String)s));

    }
    System.out.println("Input the two values in the BST you want to find the LCA of");
    String values2 = scanner.next();
    String[] split2 = values2.split(",");
   // Object lca = bst.lowestCommonAncestor(bst.root, split2[0], split2[1]);
}
}