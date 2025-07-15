package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOfNodeInBT {
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
    static int getLevel(Node root, int data) {
        if(root == null) return 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int level = 1;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                Node curr = q.poll();

                if(curr.data == data) return level;

                if(curr.left != null){
                    q.add(curr.left);
                }

                if(curr.right != null) {
                    q.add(curr.right);
                }
            }
            level++;
        }

        return 0;

    }
    public static void main(String[] args) {
        int[] nodes = {3, 2, 1, -1, -1, 4, -1, -1, 5, -1, -1};
        BT.index = -1; // Reset before building
        Node root = BT.BuildTree(nodes);
        int target = 4;
        System.out.println("Level of " + target + " is: " + getLevel(root, target));


    }
}
