package BinaryTrees;

public class MaximumPathSumBinaryTree {
    static class Node {
        int val;
        Node left;
        Node right;
        Node(int data) {
            this.val = data;
            this.left = null;
            this.right = null;
        }
    }

    public static class BT {
        static int index = -1;
        public static Node BuildTree(int[] nodes) {
            index++;
            if (nodes[index] == -1) return null;
            Node newNode = new Node(nodes[index]);
            newNode.left = BuildTree(nodes);
            newNode.right = BuildTree(nodes);
            return newNode;
        }
    }
    public static int maxPathSum(Node root) {
        int[] max = {Integer.MIN_VALUE};

        findMaxPathSum(root, max);
        return max[0];
    }
    public static int findMaxPathSum(Node root,int[] max){
        if(root == null){
            return 0;
        }

        int leftMax= Math.max(0,findMaxPathSum(root.left,max));
        int rightMax = Math.max(0,findMaxPathSum(root.right,max));

        max[0] = Math.max(max[0],leftMax + rightMax + root.val);
        return Math.max(leftMax,rightMax) + root.val;
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, -1, -1, 3, -1, -1};
        BT bt = new BT();
        Node root = bt.BuildTree(nodes);
        int ans = maxPathSum(root);
        System.out.println(ans);


    }
}
