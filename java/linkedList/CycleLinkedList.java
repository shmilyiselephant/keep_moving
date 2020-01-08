package linkedList;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Random;

/**
 * @author shmilyiselephant
 * @date 07.01.20
 * @decription
 */
public class CycleLinkedList {
    public CycleNode head;
    public CycleNode end;

    public CycleLinkedList(CycleNode head, CycleNode end) {
        head.next = end;
        this.head = head;
        end.next = head;
        this.end = end;
    }

    public void printList() {
        CycleNode curr = head.next;
        System.out.print(head.data + "->");
        while(curr != head) {
            System.out.print(curr.data + "->");
            curr = curr.next;
        }
        System.out.println();
    }

    public void printList(CycleNode head) {
        CycleNode curr = head.next;
        System.out.print(head.data + "->");
        while(curr != head) {
            System.out.print(curr.data + "->");
            curr = curr.next;
        }
        System.out.println();
    }

    public void insertHeadNode(int data){
        CycleNode newHead = new CycleNode(data);
        end.next = newHead;
        newHead.next = head;
        head = newHead;
        System.out.println("Insert new headNode " + newHead.data);
    }

    public void insertEndNode(int data) {
        CycleNode newEnd = new CycleNode(data);
        newEnd.next = head;
        end.next = newEnd;
        end = newEnd;
        System.out.println("Insert new endNode " + newEnd.data);
    }

    public void deleteHeadNode() {
        System.out.println("old head" + head.data);
        end.next = head.next;
        head = head.next;
        System.out.println("new head" + head.data);
    }

    public void deleteEndNode() {
        System.out.println("old end" + end.data);
        CycleNode curr = head;
        while(curr.next != end) {
            curr = curr.next;
        }
        curr.next = head;
        end = curr;
        System.out.println("new end" + end.data);
    }

    public void deleteNode(int data) {
        CycleNode curr = new CycleNode(-1);
        curr.next = head;
        while (curr.next != end) {
            if (curr.next.data == data && curr.next == head) deleteHeadNode();
            else if (curr.next.data == data) {
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }
        if (curr.data == data) deleteEndNode();
    }

    /*
    public void reverseList() {
        int headData = head.data;
        int endData = end.data;
        deleteHeadNode();
        insertHeadNode(endData);
        deleteEndNode();
        insertEndNode(headData);
        printList();
        reverseMajor();
        printList();
    }

    public void reverseMajor() {
        CycleNode curr = head.next;
        CycleNode newHead = head;
        while (curr != end) {
            CycleNode tmpNext = curr.next;
            curr.next = newHead;
            newHead = curr;
            curr = tmpNext;
        }
    }*/

    public static void main(String args[]) {
        Random r = new Random();
        CycleNode headNode = new CycleNode(r.nextInt(10));
        CycleNode endNode = new CycleNode(r.nextInt(10));
        CycleLinkedList cycleList = new CycleLinkedList(headNode, endNode);
        cycleList.printList();
        cycleList.insertHeadNode(3);
        cycleList.insertEndNode(2);
        for (int i = 0; i < 5; i++)
            cycleList.insertEndNode(r.nextInt(10));
        cycleList.printList();
        //cycleList.deleteHeadNode();
        //cycleList.printList();
        //cycleList.deleteEndNode();
        //cycleList.printList();
        //cycleList.deleteNode(2);
        //cycleList.deleteNode(3);
        //cycleList.printList();
        //cycleList.reverseList();
        //cycleList.printList();
    }
}

class CycleNode {
    public CycleNode next;
    public int data;

    public CycleNode() {}

    public CycleNode(int data) {
        this.data = data;
        this.next = null;
    }

    public CycleNode(CycleNode next, int data) {
        this.next = next;
        this.data = data;
    }
}