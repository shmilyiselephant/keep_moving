package stack;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.lang.reflect.Array;

/**
 * @author shmilyiselephant
 * @date 09.01.20
 * @decription
 */
public class ArrayStack {
    private int count;
    private int[] data;
    private int top;

    public ArrayStack(int size) {
        this.data = new int[size];
        count = 0;
        top = -1;
    }

    public void push(int element) {
        if (count < data.length && top <= count) {
            count++;
            top++;
            data[top] = element;
            System.out.println("push " + element + " into stack");
        } else {
            System.out.println("Stack is full, cannot push!");
        }
    }

    public int pop() {
        int tmp = -1;
        if (top >= 0) {
            tmp = data[top];
            top--;
            count--;
            System.out.println(tmp + " is poped out");
        } else {
            System.out.println("Stack is empty, cannot pop!");
        }
        return tmp;
    }

    public static void main(String args[]) {
        ArrayStack aStack = new ArrayStack(10);
        for (int i = 0; i < 10; i++)
            aStack.push(i);
        for (int i = 0; i < 10; i++)
            aStack.pop();
    }
}

