package com.company;

class MyLinkedList {


    private class Node {
        private int val;
        private Node next;

        private Node(int val) {
            this.val = val;

        }
    }

    private Node head;
    private Node tail;
    private int size = 0;

    public MyLinkedList() {


    }

    public int get(int index) {
        if (index < 0 || index >= size || head == null)
            return -1;


        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }


        return cur.val;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size)
            return;

        if (index == 0) {
            Node newNode = new Node(val);
            newNode.next = head;
            head = newNode;
        } else {
            Node cur = head;

            for (int i = 0; i < index - 1; i++) {
                cur = cur.next;
            }

            Node newNode = new Node(val);
            newNode.next = cur.next;
            cur.next = newNode;
        }
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size || head == null)
            return;

        Node cur = head;

        if (index == 0) {
            Node needToDelete = head;
            head = head.next;

            needToDelete.next = null;

        } else {

            for (int i = 0; i < index - 1; i++) {
                cur = cur.next;
            }

            Node needToDelete = cur.next;
            cur.next = cur.next.next;

            needToDelete.next = null;
        }
        size--;
    }

    public void printValues() {
        System.out.println();
        Node cur = head;
        for (int i = 0; i < size; i++) {
            System.out.print(cur.val + ", ");
            cur = cur.next;
        }


    }


}