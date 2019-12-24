package linkedList;

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

    public void printList(Node head) {
        for (Node tmp = head; tmp != null; tmp = tmp.next) {
            System.out.printf("%d ", tmp.data);
        }
        System.out.println();
    }

    public Node reverseList(Node head) {
        Node reverseHead = null;
        Node curr = head;
        while (curr != null) {
            Node tmpNext = curr.next;
            curr.next = reverseHead;
            reverseHead = curr;
            curr = tmpNext;
        }
        printList(reverseHead);
        return reverseHead;
    }
    public static void main(String args[]) {
        MyLinkedList myList = new MyLinkedList(new Node(9));
        myList.insertNode(new Node(2));
        myList.insertNode(new Node(3));
        //myList.insertNode(new Node(4));
        //myList.printList(myList.getHead());
        //myList.deleteNode(3);
        myList.printList(myList.getHead());
        myList.reverseList(myList.getHead());
    }
}

class Node {
    public Node next;
    public int data;

    public Node(int value) {
        data = value;
        next = null;
    }
}