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
    
}
}