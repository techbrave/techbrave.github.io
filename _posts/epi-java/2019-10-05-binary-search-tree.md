---
title: Java - Binary Search Tree
layout: post
categories: [EPI_Java]
---

summary: keep elements in sorted manner in an array is computational expensive. Introducing new structure: binary search tree, to optimize the insertion, deletion, searching, find (min/max), successors and predecessors, and enumeration operations. 

# Motivation

keeping the elements in an array, with sorted order, is very expensive. 

BST pros:
- search the key
- find Min/Max element
- find successor (immediate next) and predecessor of a key
- enumerate keys in a range, in sorted order
- unlike arrays, the keys can be added or removed in an efficient manner

Leetcode related problems
- search-in-a-binary-search-tree, closest-binary-search-tree-value
- Second Minimum Node In a Binary Tree, kth-smallest-element-in-a-bst
- inorder-successor-in-bst
- insert-into-a-binary-search-tree

# Bootcamp

* Keys in BST need to respect BST properties
* Common mistake: when updating any mutable object in BST, first remove it, then update it, and finally add it back
Searching

```java
(with recursion)
public static BSTNode<Integer> searchBST(BSTNode<Integer> tree, int key) {
    if (tree == null || tree.data == key) {
        return tree;
    }
    return key < tree.data ? searchBST(tree.left, key) : searchBST(tree.right, key);
}

class BSTNode<T> {
    public T data; 
    public BSTNode<T> left, right; 
}


// time complexity of searching in BST is the height of the tree. With careful implementation, e.g. (red-black tree is a kind of height-balanced-tree), the complexity of searching is O(logn)
Library
```

TreeSet
TreeMap

- iterator()
descendingIterator()
first iterator traverse keys in ascending order

- first()/last()
first-gives the smallest key in the tree
last-gives the biggest key in the tree

- lower(12), higher(3)
lower(12) - return the largest key that is strictly smaller than 12
higher(3) - return the smallest key that is strictly greater than 3 

- floor(4.1), ceiling(5.7)
floor() = gives the largest element less than or equal to the argument
ceiling(3) - return the smallest key that is  greater than or equal to argument

- headSet(10), tailSet(5), subSet(1,12)
returns views of the portion of the keys lying in the given range. It takes (Ologn) time to return the view, and size() on view have O(n) time complexity

# Tips

* You can iterate through elements in sorted order, in O(n) time
* Some problem need to use BST with hashtable. Suppose you want to keep a sorted representation of students by GPA. However, you need to update their GPA, by name. 
* There are more situations to augment BST, for instance, you may add the number of nodes of the subtree in each node. Other cases, you may want to add the range of values stored in the subtree (min, max of each node)
* BST property is a global property, a binary tree could have the property that each node's key is greater than the key at its left child, and smaller than the key at its right child, but it may not be "global"

## 15.5 Reconstruct a BST from traversal data
https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/
https://leetcode.com/problems/recover-binary-search-tree/

## 15.9 Build a minimum height BST from a sorted array

