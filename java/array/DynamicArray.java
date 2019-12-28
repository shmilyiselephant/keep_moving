package array;

/**
 * @author shmilyiselephant
 * @date 27.12.19
 * @decription A dynamicarray which could be extended.
 */

public class DynamicArray {
    private int capacity;
    private int top;
    private int[] data;

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        data = new int[capacity];
        top = 0;
    }

    public void insertElement(int value) {
        if (top < capacity) {
            data[top] = value;
            top++;
        } else {
            //extends the array
            int[] newArray = new int[2*capacity];
            //copy the element from old to new array
            for (int i = 0; i < data.length; i++)
                newArray[i] = data[i];
            capacity = capacity*2;
            data = newArray;
            data[top] = value;
            top++;
        }
    }

    public String toString(){
        String result = "";
        for (int i: data)
            result = result + i;
        return result;
    }

    public static void main(String args[]) {
        DynamicArray values = new DynamicArray(3);
        int[] tmp = {1,2,3,4,5,6};
        for(int i:tmp)
            values.insertElement(i);
        System.out.println(values.toString());
    }
}