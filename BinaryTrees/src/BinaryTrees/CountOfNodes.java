package BinaryTrees;

public class CountOfNodes {
     public static class Node{
         int data;
         Node left;
         Node right;

         Node(int data){
             this.data= data;
             this.left= null;
             this.right = null;
         }
     }
     public static class BT{
         static int index = -1;
         public static Node BuildTree(int[] nodes){
             index++;
             if(nodes[index] == -1) return null;
             Node newNode =new Node(nodes[index]);
             newNode.left = BuildTree(nodes);
             newNode.right = BuildTree(nodes);
             return newNode;
         }
     }
     public static int count(Node root){
         if(root == null) return 0;

         int left = count(root.left);
         int right = count(root.right);
         return left+right+1;
     }

    public static void main(String[] args) {
        int[] nodes = {1,2,-1,-1,3,4,-1,-1,5,-1,-1};
        BT bt = new BT();
        Node root = bt.BuildTree(nodes);
        int count = count(root);
        System.out.println(count);
    }
}
