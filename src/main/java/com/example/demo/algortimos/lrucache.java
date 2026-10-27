package com.example.demo.algortimos;
import java.util.HashMap;
import java.util.Map;


public class lrucache {

    public class LRUCache {
        private final int capacity;
        private final Map<Integer, Node> cache;
        private final Node head;
        private final Node tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.cache = new HashMap<>();
            this.head = new Node(0, 0);
            this.tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (!cache.containsKey(key)) {
                return -1;
            }
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.value;
        }

        public void put(int key, int value) {
            if (cache.containsKey(key)) {
                remove(cache.get(key));
            } else if (cache.size() == capacity) {
                remove(tail.prev);
            }
            Node node = new Node(key, value);
            insert(node);
        }

        private void remove(Node node) {
            cache.remove(node.key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void insert(Node node) {
            cache.put(node.key, node);
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        private static class Node {
            int key;
            int value;
            Node prev;
            Node next;

            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
    }



}
