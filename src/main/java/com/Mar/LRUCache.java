package com.Mar;

import com.helper.LinkedListNode;

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
    HashMap<Integer, LinkedListNode> cache;
    LinkedList<LinkedListNode> cacheVals;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<Integer, LinkedListNode>(capacity);
        cacheVals = new LinkedList<LinkedListNode>();
    }

}
