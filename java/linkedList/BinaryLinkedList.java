package linkedList;

import java.util.Random;

/**
 * @author shmilyiselephant
 * @date 07.01.20
 * @decription
 */
public class BinaryLinkedList {
    private BinaryNode head;

    public BinaryLinkedList(BinaryNode head) {
        this.head = head;
    }

    public void insertEndNode(BinaryNode node) {
        BinaryNode curr = head;

        //locate the endpoint (curr.next != null)!!!!
        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = node;
        node.prev = curr;

        System.out.println(node.data + " is inserted to end");
    }

    public void insertHeadNode(BinaryNode node) {
        node.next = head;
        head.prev = node;
        head = node; //update head
        System.out.println(node.data + " is inserted to head");
    }

    public String toString() {
        BinaryNode curr = head;
        StringBuffer res = new StringBuffer();
        while (curr != null) {
            res.append(curr);
            curr = curr.next;
        }
        return res.toString();
    }

    public void deleteNode(int data) {
        BinaryNode curr = head;
        while (curr != null) {
            if (curr.data == data) {
                if (curr.next != null) curr.next.prev = curr.prev;
                else curr.prev.next = null;
                if (curr.prev != null) curr.prev.next = curr.next;
                else {
                    curr.next.prev = null;
                    head = curr.next; //update head
                }

            }
            curr = curr.next;
        }
    }

    public void printList() {
        BinaryNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + "->");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        Random r = new Random();
        BinaryLinkedList biList = new BinaryLinkedList(new BinaryNode(r.nextInt(10)));
        biList.insertHeadNode(new BinaryNode(r.nextInt(10)));
        biList.insertHeadNode(new BinaryNode(12));
        biList.insertEndNode(new BinaryNode(r.nextInt(10)));
        biList.insertEndNode(new BinaryNode(r.nextInt(10)));
        biList.printList();
        biList.deleteNode(12);
        biList.printList();
    }
}

class BinaryNode {
    public BinaryNode next;
    public BinaryNode prev;
    public int data;

    public BinaryNode() {
    }

    public BinaryNode(int data) {
        this.data = data;
    }

    public BinaryNode(BinaryNode next, BinaryNode prev, int data) {
        this.next = next;
        this.prev = prev;
        this.data = data;
    }
}
