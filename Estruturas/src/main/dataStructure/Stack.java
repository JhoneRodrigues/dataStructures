package main.dataStructure;

// Pilha
public class Stack {
/*
    Estrutura de dados ordenada,
    aonde o último elemento a ser
    inserido será o primeiro a sair.
    Igualmente a uma pilha de pratos.
 */
    private Node top;
    private int height;

    public class Node{
        int value;
        Node next;

        Node(int value){
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public Stack (int value){
        Node node = new Node(value);
        top = node;
        height = 1;
    }

    public void getTop(){
        if (top == null) System.out.println("Empty stack.");
        else System.out.println("Topo: " + top.value);
    }

    public void getHeight(){
        System.out.println("Height: " + height);
    }

    public void print(){
        System.out.println("####################");
        Node temp = top;
        while (temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
        System.out.println("####################");
    }

    public void push(int value){
        Node newNode = new Node(value);

        if (height == 0) top = newNode;
        else {
            newNode.next = top;
            top = newNode;
        }
        height++;
    }

    public Node pop(){
        if (height == 0) return null;

        Node temp = top;
        top = top.next;
        temp.next = null;
        height--;
        return temp;
    }
}
