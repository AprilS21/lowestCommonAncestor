import java.util.Scanner;

import org.junit.Test;

public class LCA {
   
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    BST bst = new BST();
    System.out.println("Type 'add' to add values to you bst or 'lca' to find the lowest ancestor");
    int i=0;
    boolean done = false;
    while(done==false && scanner.hasNext()){
    String add = scanner.nextLine();
    if(!add.equals("lca")){
        bst.put(add,i);
        i++;
        System.out.println(add +" added to bst. Type another value to add or 'lca'");
    }else{
        System.out.println("Enter first value: ");
        String a = scanner.next();
        System.out.println("Enter second value: ");
        String b = scanner.next();
        System.out.println("The LCA of these two values is : "+ bst.lowestCommonAncestor(a, b));
        done = true;

    }
    }
}
}
