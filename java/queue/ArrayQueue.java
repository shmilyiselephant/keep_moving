package queue;

import java.util.Random;

/**
 * @author shmilyiselephant
 * @date 10.01.20
 * @decription
 */
public class ArrayQueue {
    private int[] data;
    private int tail;

    public ArrayQueue(int size) {
        data = new int[size];
        tail = -1;
    }

    public void enQueue(int value) {
        if (tail < data.length) {
            tail++;
            data[tail] = value;
            System.out.println(value + " is enqueued");
        } else {
            System.out.println("queue is full, cannot enqueue");
        }
    }

    public int deQueue() {
        int res = Integer.MIN_VALUE;
        if (tail >= 0) {
            res = data[0];
            for (int j = 0; j <= tail-1; j++)
                data[j] = data[j+1];
            tail--;
        } else {
            System.out.println("queue is empty, cannot dequeue");
        }
        return res;
    }

    public static void main(String args[]) {
        ArrayQueue aQueue = new ArrayQueue(10);
        for (int i = 0; i < 10; i++)
            aQueue.enQueue(i);
        for (int i = 0; i < 5;i++)
            System.out.println(aQueue.deQueue() + " dequeued");
    }
}
