package queue;

/**
 * @author shmilyiselephant
 * @date 10.01.20
 * @decription
 */
public class LinkedQueue {
    private Node head;

    public LinkedQueue() {}

    public LinkedQueue(Node head) {
        System.out.println("the head is " + head.data);
        this.head = head;
    }

    public void enQueue(int data) {
        Node node = new Node(data);
        Node curr = head;
        while (curr.next != null)
            curr = curr.next;
        curr.next = node;
        System.out.println(data + " enqueued");
    }

    public Node deQueue() {
        Node res = head;
        head = head.next;
        System.out.println("new head: " + head.data);
        return res;
    }

    public void printQueue() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + "->");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        LinkedQueue aQueue = new LinkedQueue(new Node(0));
        for (int i = 1; i < 10; i++)
            aQueue.enQueue(i);
        aQueue.printQueue();
        for (int i = 0; i < 5;i++)
            System.out.println(aQueue.deQueue().data + " dequeued");
        aQueue.printQueue();
    }
}

class Node{
    public Node next;
    public int data;

    public Node(int data) {
        this.next = null;
        this.data = data;
    }
}