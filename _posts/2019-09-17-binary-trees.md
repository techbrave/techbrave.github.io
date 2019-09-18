---
title: Java - Binary Trees
layout: post
---

Summary: A binary tree is a data structure that is useful for representing hierarchy. Formally a binary tree is either empty or a root node together with a left binary tree and a right binary tree. The subtrees themselves are binary trees. 

## Tips

- Recursive algorithms are well-suited to problems on trees. Remember to include space implicitly allocated on the function call stack when doing space complexity analysis.
- Some tree problems have simple brute-force solutions that use `O(n)` space solution, but subtler solutions that uses the existing tree nodes to reduce space complexity to `O(1)`
- Consider left- and right-skewed trees when doing complexity analysis. Note that `O(h)` complexity, where h is the tree height, translates into `O(logn)`complexity for balanced trees, but `O(n)` complexity for skewed trees.
- If each node has a parent field, use it to make your code simpler, and to reduce time and space complexity
- It's easy to make the mistake of treating a node that has a single child as a leaf child as a leaf

## IMPLEMENT AN INORDER TRAVERSAL WITH 0(1) SPACE

```java
    public static List<Integer> inorderTraversal(BinaryTree<Integer> root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        BinaryTree<Integer> prev = null;
        BinaryTree<Integer> curr = root;
        while (curr != null) {
            BinaryTree<Integer> next;

            if (curr.parent == prev) {
                // we travel from parent to current
                // if it has left, keep going left
                if (curr.left != null) {
                    next = curr.left;
                } else {
                    res.add(curr.data);
                    // Done with left part, and itself, so go right if right is not empty
                    // if right is empty, keep going up
                    next = curr.right != null ? curr.right : curr.parent;
                }
            } else if (curr.left == prev) {
                res.add(curr.data);
                // Done with left part, so go right if right is not empty
                // if right is empty, keep going up
                next = curr.right != null ? curr.right : curr.parent;
            } else {
                // Done with both left, and right; go up
                next = curr.parent;
            }

            prev = curr;
            curr = next;
        }
        return res;
    }

    //   1
    // 2 3
    //4
    // prev nul curr 1 -> next 2 -> prev 1 curr 2
    // prev 2 curr 2 -> next 4 -> prev 2 curr 4
    // prev 2 curr 4 -> (4) next = 2 -> prev 4 curr 2
    // prev 2 curr 2 -> (4, 2) next = 1 -> prev 2, curr 1
    // prev 2, curr 1 -> (4, 2, 1) next 3 -> prev 1, curr 3
    // prev 3 curr 1 -> (4, 2, 1, 3) next 1 -> prev1  curr 1
    // prev1  curr 1  -> next null -> prev1 curr null
```

