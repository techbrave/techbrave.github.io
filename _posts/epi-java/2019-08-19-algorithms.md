---
title: Java - Algorithms
layout: post
categories: [EPI - Java]
---

Summarize the key points of algorithm, based on content from Elements of the programming interview

| Technique (Algorithm)                     | Key                                                          |
| ----------------------------------------- | ------------------------------------------------------------ |
| Sorting (binary search, partitionByPivot) | Reduce the complexity by soring the input. Or, if the input is sorted, we might apply standard divide and conquer algo pattern. |
| Two pointers                              | Two pointer technique is commonly used in Array and List problems. We may have a pair of (slow, fast) pointers, or two pointers, one start from the beginning the other starts from the end. [Leetcode Article](https://leetcode.com/articles/two-pointer-technique/) |
| Divide and conquer                        | - The idea is to divide the original problem into smaller subproblems (often, 2 subproblems), and then further divide  smaller subproblems until it can be solved directly. It then combines the solution to all smaller subproblems to form the answer for the original problem. <br />- Example: [Triomino](https://undergroundmathematics.org/divisibility-and-induction/triominoes/solution) <br />- Divide and Conquer algorithm can be implemented both iteratively and recursively <br />Often, divide into two subproblem, non-overlapping, similar size (complexity) |
| Recursion (BFS, DFS)                      | A recursive function, consists of base cases, and calls to the same function with different arguments. <br />Applicable: searching, enumeration, divide and conquer, and decomposing a complex problem into a set of similar smaller instances... <br />-Often, reduce problem size by 1 (complexity) |
| Dynamic Programming                       | - DP is applicable, when the problem has "optimal substructure", that is the solution for the original problem lies in the solution of same but smaller problem (which is quite different than searching, since you suddenly eliminate the need to search all other possible paths). <br />- DP key: maintian a cache of solutions to subinstances. If implemented recursively, the cache is often a hashtable or BST; if implemented iteratively, the cache is multi dimensional array. <br />- Often, reduce problem size by 1 (complexity) if implemented recursively; Increase the problem complexity by 1 if implemented iteratively <br />- Example: determin the number of combination of score 2, 3, 7  can generate a total of 222 points. |
| **Greedy                                  | Greedy algorithm makes decision which are locally optimum and never changes them. It does not always yield the correct solution. |
| Invariants                                | Binary search, two sum, all uses invariant                   |

## what about NP problems?

- brute-force solutions, including dynamic programming, which have exponential tial time complexity, may be acceptable, if the instances encountered are small, or if the specific parameter that the complexity is exponential in is small;

- search algorithms, such as backtracking, branch-and-bound, and hill-climbing, which prune much of the complexity of a brute-force search;
- approximation algorithms which return a solution that is provably close to optimum;
- heuristics based on insight, common case analysis, and careful tuning that may solve the problem reasonably well;
- parallel algorithms,where large number of computers work simultaneously