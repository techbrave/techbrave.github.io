---
title: HashMap, LinkedHashMap and TreeMap
layout: post
categories: [DataStructures]
---

# HashMap

# LinkedHashMap
motivation: enhance hashmap with `doubly linked list`, such that it will be suitable for `LRU cache`. 

LinkedHashMap offers `insertion order`, and `access order`. 
```java
LinkedHashMap<Integer, Integer> lhm = new LinkedHashMap<>(16, 0.75F, true); 
lhm.put(1, 1); lhm.put(2, 2); lhm.put(3, 3); lhm.put(4, 4); lhm.put(5, 5); 
for (Integer key: lhm.keySet()) System.out.println(key); // 1, 2, 3, 4, 5
lhm.get(4);
for (Integer key: lhm.keySet()) System.out.println(key); // 1, 2, 3, 5, 4
lhm.get(1);
for (Integer key: lhm.keySet()) System.out.println(key); // 2, 3, 5, 4, 1
lhm.get(5);
for (Integer key: lhm.keySet()) System.out.println(key); // 2, 3, 4, 1, 5
```
# TreeMap