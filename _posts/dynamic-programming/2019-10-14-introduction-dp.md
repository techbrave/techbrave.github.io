---
title: 从np问题说起，动态规划优化了什么？
layout: post
categories: [DynamicProgramming]
---

> In this post, we introduce the motivation behind "dynamic programming" concept. 

# 动机-一个门外汉的理解
```
如果一个问题具有（1）重叠子问题（2）最优子结构

那么这个问题常适用于使用[动态规划]解决。
```

# 动态规划：如何巧记"破题“点？
`转移方程`是个好宝宝。里面既包含了状态，也包含了状态之间的关系，更包含了状态是怎么生成的（边界顺序）。
转移方程，就是动态规划题的破题点和精髓。

# 动态规划四步曲（思路的螺旋式上升）
Usually, solving and fully understanding a dynamic programming problem is a 4 step process:

- Start with the recursive backtracking solution
- Optimize by using a memoization table (top-down3 dynamic programming)
- Remove the need for recursion (bottom-up dynamic programming)
- Apply final tricks to reduce the time / memory complexity

# 几种常见的动态规划
1. counting 计数型
dp(i) = dp(i-1) + ...
2. possibility 可行性
dp(i) = dp(i-1) OR
3. maximum/minimum 最值型
dp(i) = Math.max{ dp(i-1) ... }


# Introduction
- Brute force recursive solution, starting from the last step (end stage). Similar space-state tree (each step choose or not choose.)

- We then need to obviously optimize it. So we add memoization. each key in the memo is reflecting one state (this is top-down memoization)

- If we completely being "smart" here, and observe exactly how the memo hash table is built. We will see that as the recursive call goes deeper, it will reach a "base" case, then then going back into their caller, that's how the sequence of building that table. If we do the similar trick by oursevles, and follow the order by ourselves (meaning, for loops), we can build the exact same table. (this is bottom-up tabulation)


# Tabulation vs memoization
https://www.geeksforgeeks.org/tabulation-vs-memoization/

https://cs.stackexchange.com/questions/10369/upper-bound-on-runtime-of-memoized-dp-algorithms

# Top-down v.s. buttom-up
自顶向下：我的问题就是从大问题开始的。比如，从矩阵左上方出发，走到右下方，一共有多少走法。 In order to solve this big problem, 我必须要走到终点的左方，或者上方(大问题缩小了一步)。 当我每次不断缩小问题的时候，最后问题会变得很平凡（我的当前点就是出发点）。这时候就可以直接解了。
自底向上：我不管我的问题什么时候能解决，我只知道，我现在从左上方出发了，我每一步能做一个选择。我不断地作选择， 最后会距离我的目标越来越近。当我终于通过一次一次的选择到达我的目标时，我的解也就找到了（yeah!