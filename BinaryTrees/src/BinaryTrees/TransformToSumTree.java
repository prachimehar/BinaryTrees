package BinaryTrees;

public class TransformToSumTree {
    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
        }
    }

    public static class BT {
        static int index = -1;
        public static Node BuildTree(int[] nodes) {
            index++;
            if (index >= nodes.length || nodes[index] == -1) return null;
            Node newNode = new Node(nodes[index]);
            newNode.left = BuildTree(nodes);
            newNode.right = BuildTree(nodes);
            return newNode;
        }
    }
    public static int toSumTree(Node root) {
        if (root == null) return 0;

        int leftSum = toSumTree(root.left);
        int rightSum = toSumTree(root.right);

        int oldValue = root.data;
        root.data = leftSum + rightSum;

        return root.data + oldValue;
    }

    public static void printpreorder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        printpreorder(root.left);
        printpreorder(root.right);
    }

    public static void main(String[] args) {
        int[] nodes = {10, -2, 8, -1, -1, -4, -1, -1, 6, 7, -1, -1, 5, -1, -1};
        BT bt = new BT();
        Node root = bt.BuildTree(nodes);
        System.out.println("Original tree before converted to sum tree:");
        printpreorder(root);
        System.out.println("\nOriginal tree converted to sum tree:");
        toSumTree(root);
        printpreorder(root); // Output after conversion
    }
}
