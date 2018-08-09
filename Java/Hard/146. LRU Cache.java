/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 / capacity / );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
*/

class LFUCache {
   int cap;
    HashMap<Integer, Integer> vals;
    LinkedHashSet<Integer> lists;
    public LRUCache(int capacity) {
            cap=capacity;
            vals=new HashMap<>();
            lists=new LinkedHashSet<>();
    }
    
    public int get(int key) {
        if(vals.containsKey(key)) {
            // refresh lists
            lists.remove(key);
            lists.add(key);
            return vals.get(key);
        }else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(cap<=0)
            return;
        // If already exists, update used frequency
        if(vals.containsKey(key)) {
            vals.put(key, value);
            get(key);
            return;
        }
        // remove LRU data
        if(vals.size()>=cap) {
            Integer LRUEntry=lists.iterator().next();
            vals.remove(LRUEntry);
            lists.remove(LRUEntry);
        }
        
        vals.put(key, value);
        lists.add(key);
        return;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */