---
title: 0/1 Knapsack problem
layout: post
categories: [DynamicProgramming]
---

# 0/1 Knapsack (bounded)
状态：处理完前`i`个物品（决定哪些放到大小为`c`的背包）后，问题要求的解：能不能？最大获利？多少种
              不放      放，前提是不超重
`f(i, c) ~ f(i-1, c), f(i-1, c-w[i])`

[0/1 knapsack](https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/RM1BDv71V60)

[Equal Sum Partition](https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/3jEPRo5PDvx)

[Subset sum](https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/3j64vRY6JnR)

[Minimum Sum difference](https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/xVVNRPPXQGr)
// converting the problem to something else: `a+b=S a-b=d => d=S-2b`

Count of subset sum

Target sum

# Knapsack (Unbounded)

`f(i, c) ~ f(i-1, c), f(i, c-w[i])`

[Unbounded knapsack](https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/qV6RXWME4D3)
// how to print the selected items

[Rod cutting](https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/RM5E56PGnVY)

// how to print the selected item is a big pain.. had to use top-down memoization, and put the selected item into the memoized map as well. not good.

[Coin change](https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/gx763A3x9Pl)

[Minimum coins change](https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/NE0yNJ1rZy6)

[Maximum ribbon cut](https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/YQVZJx1k0WY)

# Fibonacci Numbers
转移方程直接给出来，就和第几个(序列下标）有关
`f[i] = f[i-1] + f[i-2]`

[Fibonacci numbers](https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/gx6jmzrMwgZ)

[Stair case](https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/YQy7Lx79R0K)

[Number of factors](https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/NE52PnMY376)

[Minimum jump to reach the end](https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/7nAKN0Qz67r)

[Minimum jumps, with fee](https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/7nDNy6JDP1G)

[House thief](https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/m2EOxJ0Nkp3)

# Palindromic subsequence
// the longest palindromic subsequence, starting at index `i`, ending at index `j`
```
f[i][j]? ~ if s[i] == s[j] => f[i][j] = 2 + s[i+1][j-1]
           if s[i] != s[j] => f[i][j] = MAX{s[i+1][j], s[i][j-1]}
```

[Longest palindromic subsequence](https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/RMk1D1DY1PL)

[Longest palindromic substring](https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/m2yRjwxBY7A)

[Count of palindromic substring](https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/xV73LEk5rx9)

[Palindromic partition ii](https://leetcode.com/problems/palindrome-partitioning-ii/submissions/)

# Longest common subsequence 

# Longest common substring
[Longest common substring](https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/RMkk7NwE44R)


f[i][j]: the longest common subsequence between s1 first i characters, and s2 first j characters
f[i][j]? ~ if s[i] == s[j] => f[i][j] = 1 + s[i-1][j-1]
           if s[i] != s[j] => f[i][j] = MAX{s[i-1][j], s[i][j-1]}

[Longest common substring](https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/RMkk7NwE44R)

[Longest common subsequence](https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/B8Pq4ZnBN0N)

[Minimum deletion and insertion to make a string into another](https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/m27OkE8D08O)

[Longest increasing subsequence](https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/YQ0y0QOJQ69)

[Maximum sum increasing subsequence](https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/B8rgqKEW05N)

[Shortest common super sequence](https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/3jjLPyLGnAR)

[Minimum deletion to make an array sorted](https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/qV251wjM2ZD)

[Longest repeating subsequence](https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/7npz2VooPl1)
// searching two indexes within itself

[Subsequence pattern matching](https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/JY7yZ2VyJnP)