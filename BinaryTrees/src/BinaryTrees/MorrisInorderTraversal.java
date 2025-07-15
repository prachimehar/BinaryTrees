package BinaryTrees;

public class MorrisInorderTraversal {

    static class Node {
        int val;
        Node left, right;
        Node(int x) {
            val = x;
        }
    }

    public static void morrisInorder(Node root) {
        Node current = root;

        while (current != null) {
            if (current.left == null) {
                System.out.print(current.val + " ");
                current = current.right;
            } else {
                // Find the inorder predecessor of current
                Node predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                // Make current as right child of its inorder predecessor
                if (predecessor.right == null) {
                    predecessor.right = current;  // Create thread
                    current = current.left;
                }
                // Revert the changes (remove the thread)
                else {
                    predecessor.right = null;  // Remove thread
                    System.out.print(current.val + " ");
                    current = current.right;
                }
            }
        }
    }


    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.print("Inorder Traversal: ");
        morrisInorder(root);  // Output: 4 2 5 1 3
    }
}

