---
title: Master Theorem 
layout: post
categories: [Zhuanti]
---

# Intro 
[YT Link](https://www.youtube.com/watch?v=kGcO-nAm9Vc)

[Wikipedia](https://en.wikipedia.org/wiki/Master_theorem_(analysis_of_algorithms)#Case_1_example)

# Some examples 

- Merge Sort 
- find kth smallest element in BST
[Link](https://leetcode.com/problems/kth-smallest-element-in-a-bst/discuss/63660/3-ways-implemented-in-JAVA-(Python)%3A-Binary-Search-in-order-iterative-and-recursive)
# Approach 1 
`T(n) = T(n/2) + f(n/2)` => `average O(n), worst case O(n^2)`
