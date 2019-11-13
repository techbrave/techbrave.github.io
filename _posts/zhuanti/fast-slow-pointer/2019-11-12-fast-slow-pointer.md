---
title: Fast and Slow Pointer
layout: post
categories: [Zhuanti]
---

# Intro
We use a fast/slow pointer pair, that guarantee to meet again, if the linkedlist/array has a cycle. 
证明：数学归纳法
if fast pointer is one step behind slow => will meet (base)
Our assumption is, fast pointer will meet slow, when it's 1, 2, ... (k-1)step behind. 

let's assume now fast pointer is `k` step behind slow 
we already know, after one iteration, fast pointer will be `k-1` step behind slow. Proved.

# Pattern 

[Linked List Cycle](https://www.educative.io/courses/grokking-the-coding-interview/N7rwVyAZl6D)

[Calculate the length of a linked list cycle](https://www.educative.io/courses/grokking-the-coding-interview/N7rwVyAZl6D)

[Start of linked list cycle](https://www.educative.io/courses/grokking-the-coding-interview/N7pvEn86YrN)

[Happy number](https://www.educative.io/courses/grokking-the-coding-interview/39q3ZWq27jM)

[Middle of a linked list](https://www.educative.io/courses/grokking-the-coding-interview/3j5GD3EQMGM)

[Palindromic linked list](https://www.educative.io/courses/grokking-the-coding-interview/JERG3q0p912)

[Re-arrange Linked List](https://www.educative.io/courses/grokking-the-coding-interview/YQJ4mr7yOrW)
// https://leetcode.com/problems/reorder-list/discuss/44992/Java-solution-with-3-steps

# Mock