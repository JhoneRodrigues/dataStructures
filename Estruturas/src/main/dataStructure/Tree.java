package main.dataStructure;

import java.util.LinkedList;
import java.util.Queue;

// Árvore binária
public class Tree {

    public Node root;

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value){
            this.value = value;
        }

        public boolean isLeaf(){
            return this.left == null && this.right == null;
        }
    }

    public void insert(int value){
        if (root == null) root = new Node(value);
        else {
            Node newNode = new Node(value);
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (queue.size() > 0){
                Node current = queue.remove();

                if(current.left == null){
                    current.left = newNode;
                    break;
                }
                else {queue.add(current.left);}

                if(current.right == null){
                    current.right = newNode;
                    break;
                }
                else {queue.add(current.right);}
            }
        }
    }

    public void readPreOrder (){
        preOrder(root);
    }

    private void preOrder(Node node) {
        // R E D
        if (node == null) return;
        System.out.println(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void readInOrder (){
        inOrder(root);
    }

    private void inOrder(Node node) {
        // E R D
        if (node == null) return;
        inOrder(node.left);
        System.out.println(node.value);
        inOrder(node.right);
    }

    public void readPosOrder (){
        posOrder(root);
    }

    private void posOrder(Node node) {
        // E D R
        if (node == null) return;
        posOrder(node.left);
        posOrder(node.right);
        System.out.println(node.value);
    }

    public void BFS(){
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            Node node = queue.remove();
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);

            System.out.println(node.value);
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree();

        tree.insert(37);
        tree.insert(11);
        tree.insert(66);
        tree.insert(8);
        tree.insert(17);
        tree.insert(42);
        tree.insert(72);

        System.out.println("####################");
        tree.BFS();
        System.out.println("####################");


//        System.out.println(tree.root.value);
//        System.out.println(tree.root.left.value);
//        System.out.println(tree.root.right.value);
//
//        System.out.println(tree.root.isLeaf());
//        System.out.println(tree.root.left.isLeaf());
    }
}
