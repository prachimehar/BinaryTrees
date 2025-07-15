package BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class BottomViewOfTree {
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
    static class Pair {
        Node node;
        int hd;

        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
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
    public static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair current = q.poll();
            int hd = current.hd;
            Node node = current.node;

            map.put(hd,node.data);

            if (node.left != null) {
                q.add(new Pair(node.left, hd - 1));
            }
            if (node.right != null) {
                q.add(new Pair(node.right, hd + 1));
            }
        }

        for (int val : map.values()) {
            result.add(val);
        }

        return result;
    }
    public static void main(String[] args) {
        int[] nodes = {1, 2, -1, -1, 3, -1, -1};
        Node root = BT.BuildTree(nodes);

        ArrayList<Integer> topViewResult = topView(root);
        System.out.println("Top View: " + topViewResult);

    }
}
