package BinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
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

    public static List<Integer> rightSideView(Node root) {
        List<Integer> res = new ArrayList<>();

        recursionRight(root, 0, res);

        return res;
    }
    private static void recursionRight(Node root, int level, List<Integer> res) {
        if (root == null) {
            return;
        }

        if (res.size() == level) {
            res.add(root.val);
        }
        recursionRight(root.right, level + 1, res);
        recursionRight(root.left, level + 1, res);
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, -1, -1, 3, -1, -1};  // Valid input
        BT bt = new BT();
        Node root = bt.BuildTree(nodes);
        List<Integer> ans = rightSideView(root);
        System.out.println(ans);

    }
}
