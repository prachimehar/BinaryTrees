package BinaryTrees;

public class HeightOfNodes {
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
    public static int height(Node root){
        if(root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left,right)+1;
    }

    public static void main(String[] args) {
        int[] nodes = {1,2,-1,-1,3,4,-1,-1,5,-1,-1};
        BT bt = new BT();
        Node root = bt.BuildTree(nodes);
        int height = height(root);
        System.out.println(height);
    }
}
