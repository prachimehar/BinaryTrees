package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class BT1 {
    static class Node{
        int val;
        Node left;
        Node right;

        Node(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
   static class BT{
       static int index = -1;
       public static Node BuildTree(int[] nodes) {
           index++;
           if(nodes[index] == -1) return null;

           Node newNode = new Node(nodes[index]);

           newNode.left = BuildTree(nodes);
           newNode.right = BuildTree(nodes);

           return newNode;
       }

   }
    public static void preOrder(Node root){
        if(root == null) return;
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void inOrder(Node root){
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }
    public static void postOrder(Node root){
        if(root == null) return;
        preOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");

    }
    public static void levelOrder(Node root){
        if(root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node curr = q.poll();
            System.out.print(curr.val+" ");
            if(curr.left != null){
                q.add(curr.left);
            }
            if(curr.right != null){
                q.add(curr.right);
            }
        }
    }

    public static void levelOrderForPrintingLineWise(Node root){
        if(root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node curr = q.poll();
            if(curr == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                System.out.print(curr.val+" ");
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] nodes = {1,2,-1,-1,3,4,-1,-1,5,-1,-1};
        BT bt = new BT();
        Node root = bt.BuildTree(nodes);
        System.out.println("Pre Order traversal");
        preOrder(root);
        System.out.println("\nIn Order traversal");
        inOrder(root);
        System.out.println("\nPost Order traversal");
        postOrder(root);
        System.out.println("\nLevel Order traversal");
        levelOrder(root);
        System.out.println("\nLineWise level Order traversal");
        levelOrderForPrintingLineWise(root);




    }
}
