package com.company.leetcode.linkedlist;

public class SortList {

    //Represent a node of the singly linked list
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    //Represent the head and tail of the singly linked list
    public Node head = null;
    public Node tail = null;

    //addNode() will add a new node to the list
    public void addNode(int data) {
        //Create a new node
        Node newNode = new Node(data);

        //Checks if the list is empty
        if (head == null) {
            //If list is empty, both head and tail will point to new node
            head = newNode;
            tail = newNode;
        } else {
            //newNode will be added after tail such that tail's next will point to newNode
            tail.next = newNode;
            //newNode will become new tail of the list
            tail = newNode;
        }
    }

    //sortList() will sort nodes of the list in ascending order
    public void sortList() {
        //Node current will point to head
        Node current = head, index = null;
        int temp;

        if (head == null) {
            return;
        } else {
            while (current != null) {
                //Node index will point to node next to current
                index = current.next;

                while (index != null) {
                    //If current node's data is greater than index's node data, swap the data between them
                    if (current.data > index.data) {
                        temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
    }

    //display() will display all the nodes present in the list
    public void display() {
        //Node current will point to head
        Node current = head;
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        while (current != null) {
            //Prints each node by incrementing pointer
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        SortList sList = new SortList();

        //Adds data to the list
        sList.addNode(1);
        sList.addNode(3);
        sList.addNode(5);
        sList.addNode(7);
        sList.addNode(9);


        SortList sList1 = new SortList();

        //Adds data to the list
        sList1.addNode(2);
        sList1.addNode(4);
        sList1.addNode(6);
        sList1.addNode(8);
        sList1.addNode(10);

        SortList sList2 = new SortList();

        //Adds data to the list
        sList2.addNode(22);
        sList2.addNode(23);
        sList2.addNode(25);
        sList2.addNode(27);
        sList2.addNode(29);

        Node node = mergeSortList(sList.head, sList1.head, sList2.head);
        sList.display();


    }

    public static Node mergeSortList(Node node1, Node node2, Node node3) {
        Node nodes12 = sortedMerge(node1, node2);
        return sortedMerge(nodes12, node3);
    }


    public static Node sortedMerge(Node lst1, Node lst2) {
        if (lst1 == null)
            return lst2;

        else if (lst2 == null)
            return lst1;

        Node result;

        if (lst1.data <= lst2.data) {
            result = lst1;
            result.next = sortedMerge(lst1.next, lst2);
        } else {
            result = lst2;
            result.next = sortedMerge(lst1, lst2.next);
        }

        return result;
    }
}
