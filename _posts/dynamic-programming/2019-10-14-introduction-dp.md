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