package queue;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import stack.LinkedStack;

/**
 * @author shmilyiselephant
 * @date 10.01.20
 * @decription
 */
public class CycleQueue extends LinkedQueue {
    private Node head;
    private Node tail;

    public CycleQueue(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
        head.next = tail;
        tail.next = head;
    }

    public CycleQueue(Node head) {
        super(head);
    }

    public void enQueue(int data) {
        Node node = new Node(data);
        tail.next = node;
        node.next = head;
        tail = node;
        System.out.println(data + " is the new tail of the cycle queue");
    }

    public int outQueue() {
        Node tmp = head;
        tail.next = head.next; //key 1: sequence of these two sentences are very important
        head = head.next;      //key 2: update the head

        //head = head.next; //only key 2 without key 2 will not reduce the queue length
        return tmp.data;
    }

    public void printQueue() {
        Node curr = head;
        while (curr.next != head) {
            System.out.print(curr.data + "->");
            curr = curr.next;
        }
        System.out.print(curr.data + "->   ");
        System.out.println();
    }

    public static void main(String args[]) {
        CycleQueue aQueue = new CycleQueue(new Node(0), new Node(10));
        for (int i = 1; i < 10; i++) {
            aQueue.enQueue(i);
            aQueue.printQueue();
        }
        for (int i = 0; i < 5;i++)
            System.out.println(aQueue.outQueue() + " dequeued");
        aQueue.printQueue();
    }
}
