package BinaryTrees;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePaths {
    static class Node {
        int val;
        Node left, right;
        Node(int data) {
            this.val = data;
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

    void allPath(Node root, String path, List<String> ans){
        if(root.left == null && root.right == null){
            ans.add(path+root.val);
            return;
        }
        if(root.left != null){
            allPath(root.left, path + root.val + "->", ans);
        }
        if(root.right != null){
            allPath(root.right, path + root.val + "->", ans);
        }

    }
    public List<String> binaryTreePaths(Node root) {
        List<String> ans = new LinkedList<>();
        if (root != null) {
            allPath(root, "", ans);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nodes = {1, 2, -1, -1, 3, -1, -1};  // example tree: 1->2, 1->3
        BT bt = new BT();
        Node root = bt.BuildTree(nodes);

        BinaryTreePaths btp = new BinaryTreePaths();
        List<String> paths = btp.binaryTreePaths(root);

        for (String path : paths) {
            System.out.println(path);
        }

    }
}
