package com.example.demo.algortimos;

public class ReversedLinkedList {

public static  class Node{

    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
    /** Iterativo: O(n) tiempo, O(1) espacio */
    public static  Node reverseIterative(Node head){
        Node prev = null;
        Node current = head;
        while (current !=null){
            Node next = current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        return prev;
    }


    /** Recursivo: O(n) tiempo, O(n) espacio */
    public static  Node reverseRecursive(Node head){
        if (head == null || head.next == null){
            return head;
        }
        Node newHead = reverseRecursive(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }

}

}
