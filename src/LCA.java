import java.util.Scanner;


public class LCA {
   
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    BST bst = new BST();
    DAG dag = null;
    System.out.println("Type bst to create BST or dag to create DAG ");
    int i=0;
    boolean done = false;
    boolean done2 = false;
    while(done==false && scanner.hasNext()){
         String add = scanner.nextLine();
       if(!add.equals("lca") && add.equals("dag")){
            System.out.println("Enter the number of vertices in your DAG");
            int num = scanner.nextInt();
            dag = new DAG(num);
            while(!done2 ){
                int next;
                int next2;
                System.out.println("Enter a value to add to DAG or 'lca' to find the LCA\nEnter the origin vertex");
                String input = scanner.next();
                if(input.equals("lca")){
                    add =input;
                    done2=true;
                }else{
                next = Integer.parseInt(input);
                System.out.println("Enter the new vertex");
                String input2 = scanner.next();
                if(input2.equals("lca")){
                    add =input2;
                    done2=true;
                }else{
                next2 = Integer.parseInt(input2);
                dag.addEdge(next, next2);
                System.out.println("Added to DAG");
            }}
            }
       }else if(add.equals("lca") && dag != null){
        System.out.println("Enter first value: ");
        int a = scanner.nextInt();
        System.out.println("Enter second value: ");
        int b = scanner.nextInt();
        System.out.println("The LCA of these two values is : "+ dag.lowestCommonAncestors(a, b));
         done = true;
       }
       
         else if(!add.equals("lca") && add.length()>1){
            System.out.println("Please enter only one character/digit");
    }
        else if(!add.equals("lca")){
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
