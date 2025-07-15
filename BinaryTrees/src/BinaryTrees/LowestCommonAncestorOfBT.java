package BinaryTrees;

public class LowestCommonAncestorOfBT {
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

    public static Node findNode(Node root, int val) {
        if (root == null) return null;
        if (root.data == val) return root;
        Node left = findNode(root.left, val);
        if (left != null) return left;
        return findNode(root.right, val);
    }

    public static Node lowestCommonAncestor(Node root, Node p, Node q) {
        if (root == null || root == p || root == q) return root;

        Node leftLCA = lowestCommonAncestor(root.left, p, q);
        Node rightLCA = lowestCommonAncestor(root.right, p, q);

        if (leftLCA != null && rightLCA != null) return root;
        return (leftLCA != null) ? leftLCA : rightLCA;
    }

    public static void main(String[] args) {
        int[] nodes = {
                3, 5, 6, -1, -1, 2, 7, -1, -1, 4, -1, -1,
                1, 0, -1, -1, 8, -1, -1
        };

        BT.index = -1; // Reset before building
        Node root = BT.BuildTree(nodes);

        Node p = findNode(root, 5);
        Node q = findNode(root, 1);

        Node lca = lowestCommonAncestor(root, p, q);
        if (lca != null)
            System.out.println("LCA of " + p.data + " and " + q.data + " is: " + lca.data);
        else
            System.out.println("Nodes not found.");
    }
}
