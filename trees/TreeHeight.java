package hackerrank.trees;

public class TreeHeight {

    public static void main(String[] args){
        Node root = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 =  new Node(4);
        Node n5 =  new Node(5);

        root.left = n2;
        root.right = n3;
        n2.right = n4;
        n4.left = n5;

        System.out.println("height: " + height(root));
    }

    // Recursive:
    static int height(Node n){
        if(n == null)
            return -1;

        int left = height(n.left);
        int right = height(n.right);

        if(left>right)
            return 1+left;
        else
            return 1+right;
    }

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }
}
