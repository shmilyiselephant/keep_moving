package hashtable;

import java.util.HashMap;

/**
 * @author shmilyiselephant
 * @date 06.02.20
 * @decription
 */
public class LRUHashTable<K, V> {

    private final int DEFAULT_CAPACITY = 23;

    private int capacity;

    private int currSize;

    private Node<K, V> headNode;

    private Node<K, V> tailNode;

    private HashMap<K, Node<K,V>> table;

    static class Node<K, V> {
        private K key;

        private V value;

        private Node<K, V> prev;

        private Node<K, V> next;

        public Node() {}

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUHashTable(int capacity) {
        this.currSize = 0;

        this.capacity = capacity;

        this.headNode = new Node<K, V>();

        this.tailNode = new Node<K, V>();

        headNode.next = tailNode;
        tailNode.prev = headNode;

        this.table = new HashMap<>();
    }

    public LRUHashTable() {
        new LRUHashTable(DEFAULT_CAPACITY); //1
    }

    public void add(K key, V value) {
        Node<K, V> node = table.get(key);
        if (node == null) {
            Node<K, V> newNode = new Node<>(key, value);
            table.put(key, newNode);

        }
    }

    //add newnode after head
    private void addNode(Node<K, V> newNode) {
        newNode.next = headNode.next;
        newNode.prev = headNode;

        headNode.next.prev = newNode;
        headNode.next = newNode;
    }

    //pop tail data
    private Node<K, V> popTail(){
        Node<K, V> node = tailNode.prev;
        removeNode(node);
        return node;
    }

    //remove node
    private void removeNode(Node<K, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(Node<K, V> node) {
        removeNode(node);
        addNode(node);
    }

    public V get(K key) {
        Node<K, V> node = table.get(key);
        if (node == null) {
            return null;
        }
        moveToHead(node);
        return node.value;
    }

    public void remove(K key) {
        Node<K, V> node = table.get(key);
        if (node == null) {
            return;
        }
        removeNode(node);
        currSize--;
        table.remove(node.key);
    }

    private void printAll() {
        Node<K, V> node = headNode;
        while (node.next != null) {
            System.out.print(node.value + ",");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUHashTable<Integer, Integer> cache = new LRUHashTable<>(100);
        for(int i = 0; i < 10; i++) {
            cache.add(i, 100*i);
        }
        cache.printAll();
    }
}

/*
Questions:
* 1. this(DEFAULT_CAPACITY)
 */