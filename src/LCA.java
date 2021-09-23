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
    System.out.println(bst.printKeysInOrder());
    System.out.println("Input the two values you want to find the LCA separated by commas ");
    String values2 = scanner.next();
    String[] split2 = values2.split(",");
    String a = split2[0];
    String b = split2[1];
    System.out.println("The LCA of these two values is : "+ bst.lowestCommonAncestor(a, b));
}
}