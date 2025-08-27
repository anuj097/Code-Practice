package com.java.hashMap.problems;

import java.util.LinkedHashMap;
import java.util.Map;


/*
 	Cache implementation using LinkedHashMap<k, v>
 */
class LRUCache<K, V> extends LinkedHashMap<K, V> {
	
    public final int capicity;
    private static final long serialVersionUID = 1L;
    
    LRUCache(int capicity) {
    	super(capicity, 0.75f, true);
    	this.capicity = capicity;
    }
    
    protected boolean removeEldestEntry(Map.Entry<K, V> value) { 	// if we remove value variable from here 
    	return this.size() > capicity;								// the output will print all entries
    }

	public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(2);
        cache.put(1, "A");
        cache.put(2, "B");
        System.out.println(cache.get(1));
        cache.put(3, "C");
        cache.put(4, "C");
        cache.put(5, "C"); // 2 will be evicted

        System.out.println(cache); // Output: {1=A, 3=C}
    }
}
