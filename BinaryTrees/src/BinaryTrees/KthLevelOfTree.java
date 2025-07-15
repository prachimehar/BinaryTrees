package BinaryTrees;

public class KthLevelOfTree {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static class BT{
        static int index = -1;
        public static Node BuildTree(int[] nodes){
            index++;
            if(nodes[index] == -1) return null;
            Node newNode = new Node(nodes[index]);
            newNode.left = BuildTree(nodes);
            newNode.right = BuildTree(nodes);
            return newNode;
        }
    }
    static void kthLevel(Node root, int k){
        if(root == null) return;
        if(k ==1){
            System.out.print(root.data+" ");
            return;
        }
        kthLevel(root.left,k-1);
        kthLevel(root.right,k-1);

    }
    public static void main(String[] args) {
        int[] nodes = {1, 2, -1, -1, 3, -1, -1};
        int k=2;
        Node root = BT.BuildTree(nodes);
        kthLevel(root,k);
    }
}
