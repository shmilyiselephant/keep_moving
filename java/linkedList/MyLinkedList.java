package linkedList;

import java.util.List;
import java.util.Random;

public class MyLinkedList{
    public Node head;

    public MyLinkedList(Node node) {
        head = node;
    }

    public Node getHead() {
        return head;
    }


    public void insertNode(Node node) {
        for(Node tmp = head; tmp != null; tmp = tmp.next) {
            if (tmp.next == null) {
                tmp.next = node;
                break;
            }
        }
    }

    public int getLength(){
        Node curr = head;
        int length = 0;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        return length;
    }

    public void deleteNode(int value) {
        Node beforeHead = new Node(-1);
        beforeHead.next = head;
        for (Node tmp = beforeHead; tmp.next != null; tmp = tmp.next) {
            if (tmp.next.data == value)
                tmp.next = tmp.next.next;
            if (tmp.next == null) break;
        }
        head = beforeHead.next;
    }

    public void printList() {
        for (Node tmp = head; tmp != null; tmp = tmp.next) {
            System.out.printf("%d->", tmp.data);
        }
        System.out.println();
    }

    public boolean contains(int data) {
        Node curr = head;
        while (curr != null && curr.data != data) {
            curr = curr.next;
        }
        return curr != null;
    }

    public void containsAdd(int data) {
        System.out.print("ContainsAdd " + data + " ");
        if (!this.contains(data))
            this.insertNode(new Node(data));
        this.printList();
    }

    public void containsDel(int data) {
        System.out.print("ContainsDel " + data + " ");
        if (this.contains(data))
            this.deleteNode(data);
        this.printList();
    }

    public Node reverseList(Node head) {
        Node reverseHead = null; //previous node
        Node curr = head; //current node
        //current refers to the next node, and move current and previous nodes backwards
        while (curr != null) {
            Node tmpNext = curr.next;  //store the tmp node
            curr.next = reverseHead;    // current node refers to his previous node
            reverseHead = curr; // previous node move backwards
            curr = tmpNext; //current node move backwards
        }
        printList();
        return reverseHead;
    }

    public static Node mergeList(Node headA, Node headB) {
        Node newHead = new Node();
        Node currNew = newHead;
        Node currA = headA;
        Node currB = headB;
        while (currA != null && currB != null) {
            if (currA.data >= currB.data) {
                currNew.next = currB;
                currB = currB.next;
            } else {
                currNew.next = currA;
                currA = currA.next;
            }
            currNew = currNew.next;
        }
        Node curr = currA != null ? currA : currB;
        currNew.next = curr;
        return newHead.next;
    }

    public Node findMidNode() {
        Node slow = head;
        Node fast = head;
        //different condition for null
        while(fast.next != null && slow != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String args[]) {
        MyLinkedList myList = new MyLinkedList(new Node(0));
        MyLinkedList myListA = new MyLinkedList(new Node(2));
        for (int i = 0; i < 6; i++) {
            myList.insertNode(new Node(i + 1 + myList.head.data));
            myListA.insertNode(new Node(i + 1 + myListA.head.data));
        }
        myList.printList();
        myListA.printList();
        System.out.println("myList length:"+myList.getLength());
        int test = new Random().nextInt(12);
        System.out.println("myList contains " + test + " "+ myList.contains(test));
        myList.containsAdd(test);
        myList.containsDel(test);
        Node mergeHead = MyLinkedList.mergeList(myListA.head, myList.head);
        MyLinkedList mergeList = new MyLinkedList(mergeHead);
        mergeList.printList();
        System.out.println("middle node = "  + myListA.findMidNode().data);
    }
}

class Node {
    public Node next;
    public int data;

    public Node() {}

    public Node(int value) {
        data = value;
        next = null;
    }
}