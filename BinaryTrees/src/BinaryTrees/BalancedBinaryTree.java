package BinaryTrees;

public class BalancedBinaryTree {
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
    public static boolean isBalanced(Node root) {
        return checkHeight(root) != -1;
    }

    private static int checkHeight(Node node) {
        if (node == null) return 0;

        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) return -1;

        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, -1, -1, 3, -1, -1};
        BT bt = new BT();
        Node root = bt.BuildTree(nodes);
        boolean ans =isBalanced(root);
        System.out.println(ans);
    }
}
