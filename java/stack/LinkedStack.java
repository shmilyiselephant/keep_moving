package stack;

import sun.awt.image.ImageWatched;

/**
 * @author shmilyiselephant
 * @date 09.01.20
 * @decription stack based on linkedlist
 */
public class LinkedStack {
    private Node head;
    private Node curr;

    public LinkedStack() {
        head = null;
        curr = null;
    }

    public LinkedStack(Node head) {
        this.head = head;
        this.curr = head;
    }

    public void push(int data) {
        Node tmp = new Node(data);
        if (head != null && curr != null) {
            curr.next = tmp;
            curr = tmp;
        } else {
            head = tmp;
            curr = tmp;
        }
        System.out.println(tmp.data + " pushed!");
    }

    public int pop() {
        if (curr == null) {
            System.out.println("empty stack");
            return Integer.MIN_VALUE;
        }
        int res = curr.data;
        if (curr == head) {
            head = null;
            curr = null;
            System.out.println(res + " poped, stack empty");
        } else {
            Node tmp = head;
            while (tmp.next != curr) {
                tmp = tmp.next;
            }
            curr = tmp;
            System.out.println(res + " poped");
        }
        return res;
    }

    public static void main(String args[]) {
        Node newHead = new Node(3);
        LinkedStack aStack = new LinkedStack(newHead);
        for (int i = 0; i < 10; i++)
            aStack.push(i);
        System.out.println();
        for (int i = 0; i < 15; i++)
            aStack.pop();
    }
}

class Node {
    public Node next;
    public int data;

    public Node(int data) {
        this.data = data;
    }

    public Node(Node next, int data) {
        this.next = next;
        this.data = data;
    }
}