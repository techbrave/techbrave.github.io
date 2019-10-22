---
title: Java - Hash Tables
layout: post
categories: [EPI_Java]
---

Summary: HashMap are often related to trade-offs. If some application can tolerate increasing usage of space and reduce the usage of time, consider if hash tables can help



# Hash Collision

- Selection of good hashing function
- Re-hashing, amortized cost is low (if rehash every time the total size of input doubles)

# Pros and Cons

- Efficient for insertion and deletion

- Does not preserve the ordering relation between elements

- Needs a good hashing function

  - How to design a hash function?

  - ```java
    public static int stringHash(String str, int modulus){ 
      int kMult = 997;
      int val=8;
      for (int i=0;i<str.length();i++) {
        char c = str.charAt(i);
        val = (val * kMult + c) % modulus;
      }
      return val; 
    }
    ```

    

## Java library and syntax 

```java
// The most important methods for HashSet are methods defined in Set
add(144), remove(“Cantor”), contains(24), iterator(), isEmpty(), and size(). 
/*The order in which keys are traversed by the iterator returned by iterator () is unspecified; it may even change with time. The class LinkedHashSet subclasses HashSet—the only difference is that iteratorO returns keys in the order in which they were inserted into the set. This order is not affected if an element is re-insertedintotheset,i.e.,ifs.add(x) iscalledwhens.contains(x) istrue. */
  
//The most important methods for HashMap are methods defined in Map
put ("z" , 26), get(“Hardy”), removef("z"), and containsKey(“Hardy”).
 keySet(), values(), entrySet(), Map.Entry<K, V>
/* To iterate in fixed order, use a LinkedHashMap. A LinkedHashMap is somewhat more complex than a LinkedHashSet—for example, it can be specified that the iteration should proceed in insertion order, or in access order. A LinkedHashMap can also specify capacity constraints, and enable an LRU eviction policy. */
```

## Find the smallest subarray covering all values

```java
//https://stackoverflow.com/questions/5447561/find-shortest-subarray-containing-all-elements
public static Subarray findSmallestSubarrayCoveringSet(List<String> paragraph,
                                                           Set<String> keywords) {
        Map<String, Integer> expand = new HashMap<>();

        Subarray result = new Subarray(-1, -1);
        int uniqueWords = 0;
        for (int left = 0, right = 0; right < paragraph.size(); ++right) {
            String wordToAdd = paragraph.get(right);
            if (keywords.contains(wordToAdd)) {
                if (!expand.containsKey(wordToAdd)) {
                    expand.put(wordToAdd, 0);
                    uniqueWords++;
                }
                expand.put(wordToAdd, expand.get(wordToAdd) + 1);

            }

            //Keeps advancing left until it reaches end or keywordsToCover does not // have all keywords .
            while (uniqueWords == keywords.size()) {
                if ((result.start == -1 && result.end == -1)
                        || right - left < result.end - result.start) {
                    result.start = left;
                    result.end = right;
                }

                String wordToRemove = paragraph.get(left);
                if (keywords.contains(wordToRemove)) {
                    int cnt = expand.get(wordToRemove);
                    expand.put(wordToRemove, --cnt);
                    if (cnt == 0) {
                        uniqueWords--;
                        expand.remove(wordToRemove);
                    }
                }
                ++left;
            }
        }
        return result;
    }
```



## Lowest Common Ancestor with parent node

```java
public static BinaryTree<Integer> LCA(BinaryTree<Integer> n1,
                                      BinaryTree<Integer> n2) {
  Set<BinaryTreeNode<Integer>> set = new HashSet<>();
  while (n1 != null || n2 != null) {
    if (n1 != null) {
      if (set.contains(n1)) {
        return n1;
      }
      n1 = n1.parent;
    }
    if (n2 != null) {
      if (set.contains(n2)) {
        return n2;
      }
      n2 = n2.parent;
    }
  }
  throw new IllegalArgumentException (
          "n1 and n2 are not in the same tree");
}
```



