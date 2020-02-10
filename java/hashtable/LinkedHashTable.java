package hashtable;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author shmilyiselephant
 * @date 05.02.20
 * @decription
 */
public class LinkedHashTable<K, V> {
    /*
     * default length of hashtable
     */
    private static final int DEFAULT_TABLE_SIZE = 101;

    /*
     * load factor of the hashtable
     */
    private static final float LOAD_FACTOR = 0.75f;

    /*
     * Initialization of the hashtable array
     */
    private Entry<K, V>[] table;
    private int currentSize;
    private int used;

    public LinkedHashTable() {
        table = (Entry<K, V>[]) new Entry[DEFAULT_TABLE_SIZE];
    }

    static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public void put(K key, V value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new Entry<>(null, null, null);
        }

        Entry<K, V> tmp = table[index];
        if (tmp.next == null) {
            tmp.next = new Entry<>(key, value, null);
            currentSize++;
            used++;
            if (used >= table.length*LOAD_FACTOR) {
                resize();
            }
        } else {
            do {
                tmp = tmp.next;
                if (tmp.key == key) {
                    tmp.value = value;
                    return;
                }
            } while (tmp.next != null);

            Entry<K, V> temp = table[index].next;
            table[index].next = new Entry<>(key, value, temp);
            currentSize++;
        }
    }

    private int hash(Object key) {
        int h;
        return (key == null) ? 0 : ((h = key.hashCode()) ^ (h>>>16)) % table.length;
    }

    private void resize() {
        Entry<K, V>[] oldTable = table;
        table = (Entry<K, V>[]) new Entry[table.length*2];
        used = 0;
        for (int i = 0; i < oldTable.length; i++) {
            if (oldTable[i] == null || oldTable[i].next == null) {
                continue;
            }
            Entry<K, V> e = oldTable[i];
            while(e.next != null) {
                e = e.next;
                int index = hash(e.key);
                if (table[index] == null) {
                    used++;
                    table[index] = new Entry<>(null, null, null);
                }
                table[index].next = new Entry<>(e.key, e.value, table[index].next);
            }
        }
    }

    public void remove(K key) {
        int index = hash(key);
        Entry<K, V> e = table[index];
        if (e == null || e.next == null)
            return;
        Entry<K, V> pre;
        Entry<K, V> headNode = table[index];
        do {
            pre = e;
            e = e.next;
            if (key == e.key) {
                pre.next = e.next;
                currentSize--;
                if (headNode.next == null) used--;
                return;
            }
        } while (e.next != null);
    }

    public V get(K key) {
        int index = hash(key);
        Entry<K, V> e = table[index];
        if (e == null || e.next == null)
            return null;
        while (e.next != null) {
            e = e.next;
            if (key == e.key)
                return e.value;
        }
        return null;
    }

    public static void main(String[] args) {
        LinkedHashTable<Integer, Integer> demo = new LinkedHashTable<>();
        demo.put(1,2);
        System.out.println(demo.get(1));
    }
}

/*
    * 1. what is Entry?
    Map.Entry是Map声明的一个内部接口，此接口为泛型，定义为Entry<K,V>。它表示Map中的一个实体（一个key-value对）。
    * 2. How use enmurate correctly?
    * 3. static class
    * 4. default hashcode()?
    public native int hashcode()
    用native修饰，是一个本地方法，所谓本地方法就是非java代码，这个代码通常用c或c++写成，在java中可以去调用它
    * 5. ^ calculation?
    xor位运算, same => 0, different => 1
    * 6. h>>>16?
    无符号右移16位，左边用0补齐，不像>>会考虑符号
    * 7. put中为什么使用do/while循环?

    reference: https://www.zhihu.com/people/fei-tian-da-xiang-yu-yu-yu
 */