package BinaryTrees;

public class BuildTreeFromPreOrderAndInOrder {
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
    static int preIdx = 0;

    public static Node buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, inorder.length - 1);
    }

    private static Node helper(int[] preorder, int[] inorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;

        int rootVal = preorder[preIdx];
        preIdx++;

        Node root = new Node(rootVal);

        int inIdx = search(inorder, inStart, inEnd, rootVal);

        root.left = helper(preorder, inorder, inStart, inIdx - 1);
        root.right = helper(preorder, inorder, inIdx + 1, inEnd);

        return root;
    }

    private static int search(int[] inorder, int start, int end, int val) {
        for (int i = start; i <= end; i++) {
            if (inorder[i] == val) return i;
        }
        return -1;
    }
    public static void printInorder(Node root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        Node root = buildTree(preorder, inorder);

        System.out.print("Inorder Traversal of constructed tree: ");
        printInorder(root);

    }
}
