package main.dataStructure;

// Árvore binária de pesquisa
public class BinarySearchTree {

    public Node root;

    public class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value){
            this.value = value;
        }
    }

    public void insert(int value){
        if (root == null){
            root = new Node(value);
        } else {
            insert(root,value);
        }
    }

    private void insert(final Node root,final int value){
        if (root == null) return;
        if (value == root.value) return;
        Node newNode = new Node(value);
        if (value > root.value){
            if (root.right == null) root.right = newNode;
            else insert(root.right, value);
        } else {
            if (root.left == null) root.left = newNode;
            else insert(root.left, value);
        }
    }

    public boolean contains(int value){
        return contains(root, value);
    }

    public boolean contains(Node root, int value){
        if (root == null) return false;
        if (root.value == value) return true;
        if (value > root.value) return contains(root.right, value);
        else return contains(root.left,value);
    }


    public void readInOrder (){
        System.out.println("###############");
        inOrder(root);
        System.out.println("###############");

    }

    private void inOrder(Node node) {
        // E R D
        if (node == null) return;
        inOrder(node.left);
        System.out.println(node.value);
        inOrder(node.right);
    }

    public int minValue (Node currentNode){
        while (currentNode.left != null){
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }

    public void deleteNode(int value){
        root = deleteNode(root,value);
    }

    public Node deleteNode(Node root, int value){
        if (root == null) return null;
        if (value < root.value){
            root.left = deleteNode(root.left, value);
        } else if (value > root.value) {
            root.right = deleteNode(root.right, value);
        } else {
            if (root.left == null && root.right == null){
                return null;
            } else if (root.left == null){
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }else {
                int minValue = minValue(root.right);
                root.value = minValue;
                root.right = deleteNode(root.right, minValue);
                return root;
            }
        }
        return root;
    }


    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(37);
        tree.insert(66);
        tree.insert(42);
        tree.insert(11);
        tree.insert(72);
        tree.insert(8);
        tree.insert(17);

        tree.deleteNode(8);
        tree.readInOrder();
    }
}
