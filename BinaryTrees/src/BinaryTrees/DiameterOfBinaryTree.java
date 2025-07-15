package BinaryTrees;

public class DiameterOfBinaryTree {
    static class Node{
        int val;
        Node left;
        Node right;
        Node(int data){
            this.val = data;
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
    public int diameterOfBinaryTree(Node root) {
        height(root);
        return ans;
    }
    int ans;
    public int height(Node root){
        if(root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        ans = Math.max(ans,left+right);
        return Math.max(left,right)+1;
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, -1};

        BT.index = -1;
        Node root = BT.BuildTree(nodes);

        DiameterOfBinaryTree obj = new DiameterOfBinaryTree();
        int diameter = obj.diameterOfBinaryTree(root);
        System.out.println("Diameter: " + diameter);

    }
}
