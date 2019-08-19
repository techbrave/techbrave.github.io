---
title: Java - Data structure
layout: post
---

Summarize the key points of data structure, based on content from `Elements of the programming interview` 

| Data Structure      | Key                                                          |
| ------------------- | ------------------------------------------------------------ |
| Primitive           | Know how int, char, double, etc. are represented in memory and the primitive operations on them. |
| Arrays              | Fast access for element at an index, slow lookups (unless sorted) and insertions. Be comfortable with iteration, resizing, partitioning, merging, etc. |
| String              | Know how strings are represented in memory. Understand basic operators such as comparison, copying, matching, joining, splitting, etc. |
| Lists               | Understand trade-offs with respect to arrays. Be comfortable with iteration, insertion, and deletion within singly and doubly linked lists. Know how to implement a list with dynamic allocation, and with arrays. |
| Stacks and Queues   | Recognize where last-in first-out (stack) and first-in first-out (queue) semantics are applicable. Know array and linked list implementations. |
| Binary Trees        | Use for representing hierarchical data. Know about depth, height, leaves, search path, traversal sequences, successor/predecessor operations. |
| Heaps               | Key benefit: 0(1)  find-max, O(log n) insertion, and 0(log n) deletion of max. Node and array representations. Min-heap variant. |
| Hash Tables         | Key benefit: 0(1) insertions, deletions and lookups. Key disadvantages: not suitable for order-related queries; need for resizing; poor worst-case performance. Understand implementation using array of buckets and collision chains. Know hash functions for integers, strings, objects. |
| Binary Search Trees | Key benefit: O(logn) insertions, deletions, lookups, find-min, find-max, successor, predecessor when tree is height-balanced. Understand node fields, pointer implementation. Be familiar with notion of balance, and operations maintaining balance. |
|                     |                                                              |



## Primitive

```
        width                     minimum                            maximum
byte:   8 bit                        -128                               +127                   
short: 16 bit                     -32 768                            +32 767
int:   32 bit              -2 147 483 648                      +2 147 483 647
long:  64 bit   -9 223 372 036 854 775 808         +9 223 372 036 854 775 807
char:  16 bit(*)  
float: 32 bit  approximately 3.40282347E+38F       -3.40282347E+38F 
              (6-7 significant decimal digits) 

double:64 bit  1.7976931348623157E308              -1.7976931348623157E308  

```

- char: Java stores all it's "chars" internally as two bytes. However, when they become strings etc, the number of bytes will depend on your encoding. So it can be 1~4 bytes depends



Some characters (ASCII) are single byte, but many others are multi-byte.



### countBits in integer x 

Problem: implement a function countBits(), when input is an integer, return the number of bits set to one in this integer. for example, if input is (0101001)2, return 3 

- Naive solution: use 1 as a bit mask, and loop over all bits in x 

```java
int countBits(int x) {
  int count = 0;
  for (int i = 0; i < 32; i++ ) {
    if (x & 1 == 1) counts++;
    x = x >>> 1;
  }
  return count;
}
```

- Improved solution: use following theorem 

> Lemma: y = x & ~(x-1) computes the number, which represents rightmost (lowest) bit set to 1, in x 
>
> Why? Suppose x is not 0, e.g. x = (0101000)2,  x-1=(0100111), ~(x-1)=(1011000) x&~(x-1) = (0001000) 
>
> z = x ^ y will set the rightmost bit of 1 to 0

```java
int countBits(int x) {
  int count = 0;
  while (x > 0) {
    count++;
    int y = x & (~(x-1));
    x = x ^ y;
  }
  return count;
}
```



## Arrays



| Array                                    | List                                              |
| ---------------------------------------- | ------------------------------------------------- |
| O(1)find by index (get)                  | O(n) find by index (get)                          |
| O(n) insertion and deletion at index (x) | O(1) insertion and deletion given a node as input |

Relation with Hashtable

Relation with String:

A Stirng can be treated as a kind of special array, where all the elements in the array is one character. However, in practice, because there are many String dedicated use case, e.g. parse, split, substring and replacement, in Java there is a `String` class.

Relation with Lists

### Partition array

Problem: given an array A whose elements are comparable, and a given number target. reorder the array elements such that all initial elements are less than target, then equal to target, then greater than target. Use O(n) time, and O(1) space

```java
void partition(int[]A, int target) {
  // maintain two regions on opposite side of array to meet the requirement
  if (A == null || A.length == 0) return;
  int i = 0, j = A.length - 1;
  while (i < j) {
    while (i < j && A[i] < target) i++;
    while (i < j && A[j] < target) j--;
    if (i < j) {
      //swap A[i] and A[j]
    }
  }
}
```

## Lists

List implements an ordered collection of values, may include repetitions. 

In book, List definition: a linear sequence of nodes where each node has a link to the next node. 

List can be the building block of many other datastructures and applications, but itself can have many trickey problems.

### Zipping a list 

Problem: given a list of n nodes `0->1->2->3->4` , convert it into `0->4->1->3->2`using O(1) space. 

```java
ListNode findMid(ListNode head) {
  // find the middle node of a given list
  // 0->1->2->3->4 return 2
  // 0->1->2->3 return 1
}

ListNode reverse(ListNode head) {
  // reverse a given list 
  // 0->1->2 return 2->1->0
}

ListNode join(ListNode l1, ListNode l2) {
  // 0->1, 2->3 return 0->2->1->3
}
```

## Stacks and Queues

| Stack             | Queue                |
| ----------------- | -------------------- |
| LastIn, First Out | FirstIn, FirstOut    |
| Recursion         | Breadth First Search |

### Evaluete Reverse Polish Notation Expression

Problem: You are given the following expression "3, 4, *, 1, 2, +, +", output the result of 

`3 * 4 + 1 + 2 = 15`

## Binary Tree

Represent hierachical relationships (family tree, company employee reporting structure ..)

Binary tree are mostly used in the context of binary search tree, where 

Problem: Design an API interface for locking binary tree nodes

## Heaps

A heap resembles a queue, the difference is that each element has a "priority", based on the priority, the deletion will remove the element with the highest priority. 

Problem: merge k sorted list into one list 

## HashTables

hash table is used to store keys (and for lookup). 

- Good hashing function to achieve the "uniformaly random assignment"
- Good resizing implementation to prevent some insertion of `O(n)` complexity 

Problem: detemine if the given String s is palindromic 

Problem: determine plagiarism: You are given `n` programs, and you need to break every program into overlapping character strings, each of length 100, and report on the number of strings that appear in each pair of programs. 

Details are given in Solution 21.3 (Plagirism Detector). Incremental hashing function design is available Chapter 7. 

Problem: Rolling hash

>  The key to efficiency is using an incremental hash function, such as a function with the property that the hash code of a string is an additive function of each individual character. (Such a hash function is sometimes referred to as a **rolling hash**.) For such a function, getting the hash code of a sliding window of characters is very fast for each shift.

## Binary Search Trees

Binary search trees (BSTs) are used to store objects that are comparable.The underlying idea is to organize the objects in a binary tree in which the nodes satisfy the BST property. Insertion and deletion can be implemented so that the height of the BST is `0(logn)`, leading to fast `O(logn)`lookup and update times. AVL trees and red-black trees are BST implementations that support this form of insertion and deletion.

BSTs are a workhorse of data structures and can be used to solve almost every data structures problem reasonably efficiently. It is common to augment the BST to make it possible to manipulate more complicated data, e.g., intervals, and efficiently support more complex queries, e.g., the number of elements in a range.

Problem: line segment (view from above)