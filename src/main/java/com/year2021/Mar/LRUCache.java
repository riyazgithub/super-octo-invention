package com.year2021.Mar;

import com.year2021.LinkedListNode;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * If the element exists in the hashmap, our first step is to move the accessed element to the tail of the linked list
 *
 * If the data structure is at its capacity, remove the element at the head of the linked list and the Hash Map.
 * Then, we add the new element at the tail of the linked list and in the Hash Map
 *
 * Finally, we retrieve the element and return
 */
public class LRUCache {
    int capacity;
    HashMap<Integer, LinkedListNode> cacheHT;
    LinkedList<LinkedListNode> cacheVals;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cacheHT = new HashMap<Integer, LinkedListNode>(capacity);
        cacheVals = new LinkedList<LinkedListNode>();
    }
    public void Set(int data, int value) {
        evictIfNeeded(data,value);
        // adding as the last value
        LinkedListNode newNode = new LinkedListNode(data,value);
        cacheHT.put(data, newNode);
        cacheVals.addLast(newNode);
    }

    private void evictIfNeeded(int data, int value) {
        // check if element exists in the hashmap
        System.out.println("Linked list before "+cacheVals);
        if(cacheHT.containsKey(data)){
            LinkedListNode oldNode = cacheHT.get(data);
            cacheVals.remove(oldNode);
            cacheHT.remove(data);
        } else if(cacheHT.size() == capacity){
            // need to remove LRU to add recent addition
            LinkedListNode delNode = cacheVals.removeFirst();
            System.out.println("Deleting Node "+delNode);
            cacheHT.remove(delNode.key);
        }
    }

    public void print() {
        System.out.println("LL Print "+cacheVals);
        System.out.println("HashMap "+cacheHT);
    }

    public LinkedListNode Get(int data) {
        LinkedListNode newNode = null;
        if(cacheHT.containsKey(data)){
            LinkedListNode oldNode = cacheHT.get(data);
            cacheVals.remove(oldNode);
            newNode = new LinkedListNode(data, oldNode.data);
            cacheHT.put(data, newNode);
            cacheVals.addLast(newNode);
        }
        return newNode;
    }

    public static void main(String[] args){
        LRUCache cache = new LRUCache(3);
        System.out.println("The most recently watched titles are: (key, value)");
        cache.Set(10,20);
        cache.print();

        cache.Set(15,25);
        cache.print();

        cache.Set(20,30);
        cache.print();

        cache.Set(25,35);
        cache.print();

        cache.Set(5,40);
        cache.print();

        cache.Set(3,40);
        cache.print();

        cache.Set(15,25);
        cache.print();

        System.out.println(cache.Get(25));
        cache.print();

        System.out.println(cache.Get(5));
        cache.print();

    }
}
