package BinaryTrees;

public class SymmetricTree {
    static class Node{
        int val;
        Node left;
        Node right;
        Node(int data){
            this.val = data;
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
    public boolean isSymmetric(Node root) {
        if(root == null){
            return true;
        }
        return isSymmetricOrNot(root.left,root.right);

    }
    public boolean isSymmetricOrNot(Node root1,Node root2) {
        if(root1 == null || root2 == null){
            return root1 == root2;
        }
        return (root1.val == root2.val
                &&isSymmetricOrNot(root1.left, root2.right)
                &&isSymmetricOrNot(root1.right, root2.left));
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 3, -1, -1, 4, -1, -1, 2, 4, -1, -1, 3, -1, -1};

        BT treeBuilder = new BT();
        Node root = treeBuilder.BuildTree(nodes);

        SymmetricTree tree = new SymmetricTree();
        boolean result = tree.isSymmetric(root);

        System.out.println("Is tree symmetric? " + result);

    }
}
