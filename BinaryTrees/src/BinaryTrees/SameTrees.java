package BinaryTrees;

public class SameTrees {
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
    public static boolean isSameTree(Node p,Node q){
        if(p == null || q == null) return p == q;
        boolean left = isSameTree(p.left,q.left);
        boolean right = isSameTree(p.right,q.right);

        return left && right && p.data == q.data ;
    }

    public static void main(String[] args) {
        int[] p = {1, 2, -1, -1, 3, -1, -1};
        int[] q = {1, 2, -1, -1, 3, -1, -1};
        BT bt = new BT();
        BT.index = -1;
        Node root1 = BT.BuildTree(p);

        BT.index = -1;
        Node root2 = BT.BuildTree(q);
        boolean isSame = isSameTree(root1,root2);
        System.out.println(isSame);
    }
}
