package linkedList;

import java.util.Random;

/**
 * @author shmilyiselephant
 * @date 06.02.20
 * @decription
 */
public class LRULinkedList {
    //LRU linkedlist length
    private final int capacity = 10;

    //LRU currentsize
    private int currentSize;

    //data
    private MyLinkedList myLinkedList;

    //headnode
    private Node headNode;

    //constructor
    public LRULinkedList() {
        headNode = new Node(0);
        myLinkedList = new MyLinkedList(headNode);
        currentSize = 1;
    }

    //print
    public void printList() {
        Node curr = headNode;
        while(curr != null) {
            System.out.print(curr.data + "=>");
            curr = curr.next;
        }
        System.out.println();
    }

    //add
    public void add(int data) {
        if (myLinkedList.contains(data)) {
            myLinkedList.deleteNode(data);
            myLinkedList.insertNode(new Node(data));
        } else {
            if (currentSize >= capacity) {
                myLinkedList.deleteNode(headNode.data);
                this.headNode = headNode.next;
            }
            myLinkedList.insertNode(new Node(data));
            currentSize++;
        }
    }

    //search
    public boolean searchData(int data) {
        if (!myLinkedList.contains(data)) return false;
        else {
            Node curr = headNode;
            myLinkedList.deleteNode(data);
            myLinkedList.insertNode(new Node(data));
            return true;
        }
    }

    //delete
    public boolean deleteData(int data) {
        if (currentSize == 0 || !myLinkedList.contains(data)) return false;
        else {
            myLinkedList.deleteNode(data);
            currentSize--;
            return true;
        }
    }

    public static void main(String[] args) {
        LRULinkedList cache = new LRULinkedList();
        for (int i = 1; i < 15; i++) {
            cache.add(i);
        }
        cache.printList();
        System.out.println(cache.searchData(3));
        cache.printList();
        System.out.println(cache.deleteData(3));
        cache.printList();
        for (int i = 1; i < 5; i++) {
            cache.add(i);
        }
        cache.printList();
        for (int i = 1; i < 5; i++) {
            cache.deleteData(i);
        }
        cache.printList();
    }
}
