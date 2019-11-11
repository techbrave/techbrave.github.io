---
title: K way merge
layout: post
categories: [Zhuanti, PriorityQueue]
---

# Introduction
> A list of sorted arrays

We use a `minHeap` to get the global minimal from all `k` sorted arrays. 
When done processing the top element (global minimum), because we've kept track of where the top element comes from, we will pick one more from that array, and push into the heap.

# Pattern
[Merge k sorted list](https://www.educative.io/courses/grokking-the-coding-interview/Y5n0n3vAgYK)

[Kth smallest number in M sorted list](https://www.educative.io/courses/grokking-the-coding-interview/myAqDMyRXn3)
```
Similar Problems
Problem 1: Given ‘M’ sorted arrays, find the median number among all arrays.

Solution: This problem is similar to our parent problem with K=Median. So if there are ‘N’ total numbers in all the arrays we need to find the K’th minimum number where K=N/2K=N/2.

Problem 2: Given a list of ‘K’ sorted arrays, merge them into one sorted list.

Solution: This problem is similar to Merge K Sorted Lists except that the input is a list of arrays compared to LinkedLists. To handle this, we can use a similar approach as discussed in our parent problem. We will create a Node class which will track the array and the element indices.
```

[Kth smallest number in a 2D matrix](https://www.educative.io/courses/grokking-the-coding-interview/x1NJVYKNvqz)

[Smallest number range](https://www.educative.io/courses/grokking-the-coding-interview/JPGWDNRx3w2)
// hard

[Kth largest pair sum](https://www.educative.io/courses/grokking-the-coding-interview/B1JKxRB8EDJ)
// space complexity analysis, important!
// also, not use maxHeap, useMinHeap