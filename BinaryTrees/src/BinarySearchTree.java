import java.util.LinkedList;
import java.util.Vector;

public class BinarySearchTree {
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

    public static Node insert(Node root, int val){
        if(root == null){
            root =  new Node(val);
            return root;
        }
        if (root.data > val) {
            root.left = insert(root.left,val);
        }
        else{
            root.right = insert(root.right,val);
        }
        return root;
    }

    public static Node BST(int[] arr){
        Node root = null;

        for(int val: arr){
            root = insert(root,val);
        }

        return root;
    }
    static void inOrder(Node root){
        if(root == null){
            return;
        }

        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    static boolean search(Node root,int key){
        if(root == null){
            return false;
        }

        if(root.data == key){
            return true;
        }
        else if(root.data > key){
            return search(root.left,key);
        }
        else{
            return search(root.right,key);
        }

    }

    public static int findMin(Node root) {
        while (root.left != null)
            root = root.left;
        return root.data;
    }

    public static Node delete(Node root, int key) {
        if (root == null) return root;

        if (key < root.data)
            root.left = delete(root.left, key);
        else if (key > root.data)
            root.right = delete(root.right, key);
        else {
            // Node with 0 or 1 child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Node with 2 children
            root.data = findMin(root.right);
            root.right = delete(root.right, root.data);
        }

        return root;
    }
    public static void main(String[] args) {
        int[] arr = {1, 15, 4, 6, 7, 2, 5};
        Node root = BST(arr);

        System.out.print("In-order Traversal: ");
        inOrder(root);  // Should print sorted values
        System.out.println();

        int keyToSearch = 3;
        System.out.println("Search " + keyToSearch + ": " + search(root, keyToSearch));  // false

        int keyInsert = 3;
        root = insert(root,keyInsert);
        inOrder(root);

        System.out.println();

        int keyToDelete = 4;
        root = delete(root, keyToDelete);
        System.out.print("After deleting " + keyToDelete + ": ");
        inOrder(root);  // Should print BST without 4


    }
}
