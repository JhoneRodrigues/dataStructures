package main.dataStructure;

//  Lista encadeada
public class LinkedList {

/*  Cada dado é armazenado de maneira
    dinâmica em um nó e sempre lincados com o próximo nó.*/

    private Node head;
    private Node tail;
    private int length;

    class Node{
        String data;
        Node next;

        Node (String data){
            this.data = data;
        }
    }

    public LinkedList (String data){
        length = 1;
        Node newNode = new Node(data);
        head = newNode;
        tail = newNode;
    }

    public void getTail(){
        if (this.head == null) {
            System.out.println("Empty list");
        } else {
            System.out.println("Tail: " + tail.data);
        }
    }

    public void getHead(){
        if (this.head == null) {
            System.out.println("Empty list");
        } else {
            System.out.println("Head: " + head.data);
        }
    }

    public void getLength(){
        System.out.println("Length: " + length);
    }

    public void makeEmpty(){
        head = null;
        tail = null;
        length = 0;
    }

    public void print(){
        System.out.println("######################");
        Node temp = this.head;
        while (temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println("######################");
    }

    public void append(String data){
        Node newNode = new Node(data);
        if (this.length < 1){
            head = newNode;
            tail = newNode;
        } else {
             tail.next = newNode;
             tail = newNode;
        }
        length++;
    }

    public Node removeLast(){
        if (this.length < 1) return null;

        Node pre = this.head;
        Node temp;

        while (pre.next != tail){
            pre = pre.next;
        }
        temp = tail;
        tail = pre;
        tail.next = null;
        length--;
        if (length == 0){
            head = null;
            tail = null;
        }
        return temp;
    }

    public Node removeFirst(){
        if (this.length < 1) return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;

        if (length == 0){
            head = null;
            tail = null;
        }
        return temp;
    }

    public void prepend(String data){
        Node newNode = new Node(data);
        if(length < 1){
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node get(int index){
        if (index < 0 || index >= length) return null;

        Node temp = head;
        for (int i = 0; i<index;i++){
            temp = temp.next;
        }
        return temp;
    }

    public boolean insert(int index, String data){
        if (index < 0 || index > length) return false;

        if (index == 0){
            prepend(data);
            return true;
        }
        if (index == length){
            append(data);
            return true;
        }
        Node newNode = new Node(data);
        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    public boolean set(int index, String data){
        Node temp = get(index);
        if (temp != null){
            temp.data = data;
            return true;
        }
        return false;
    }

    public Node remove (int index){
        if (index < 0 || index >= length) return null;
        if (index == 0)return removeFirst();
        if (index == length)return removeLast();

        Node prev = get(index-1);
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
        length--;

        return temp;
    }
}
