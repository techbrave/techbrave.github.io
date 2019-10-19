---
title: Coin Exchange, a case study
layout: post
categories: [DynamicProgramming]
---

# Case study - Coin change
[LC Problem link](https://leetcode.com/problems/coin-change/)

# Problem

You have `n` coins(`coins[]`), each of them has a value `coins[i]`

Your problem is to pay the money = `amount` with smallest number of coins.

For example,  coins = [2, 3, 5], amount = 15. return 3 because 5+5+5 is the smallest number of coins used

Another example, coins = [2, 3, 5], amount = 1, return -1 because there is no possible solution to this problem.

# Brute force
## 思路
- 思路,终止条件 - 要拼出amount的数量，就必须拼出一个比amount更小的数。这个数=`amount-coins[k] (0<=k<n)`
- 思路,最后一步 - 对于所有可以拼出的(amount-coins[k]), 找出其中的最小值  `f(amount) = MIN{f(amount-coins[0]), f(amount-coins[1]), ..., f(amount-coins[n-1])} + 1`
- 思路,子问题 - 函数f(amount)代表了拼出amount所需要的最小的硬币，-1代表拼不出
## 实现
- 函数f(amount)代表了拼出amount所需要的最小的硬币
- 我直接对每一个函数，返回这个递推公式：f(amount) =  MIN{f(amount-coins[0]), f(amount-coins[1]), ..., f(amount-coins[n-1])} + 1
- 递归函数必须有base 否则会爆栈。于是，在amount=0的时候，我返回0，用0个硬币拼出钱=0.在amount<0的时候，返回-1，因为拼不出。其他情况，对 每一个硬币coins[k]，去求子问题的解`f(amount-coins[k])`.如果子问题的解不为-1（有解），那么与当前全局最小值进行一个比较

# Brute force with memoization (Top-down)
## 思路
- 思路,终止条件 - 要拼出amount的数量，就必须拼出一个比amount更小的数。这个数=`amount-coins[k] (0<=k<n)`
- 思路,最后一步 - 对于所有可以拼出的(amount-coins[k]), 找出其中的最小值  `f(amount) = MIN{f(amount-coins[0]), f(amount-coins[1]), ..., f(amount-coins[n-1])} + 1`
- 思路,子问题 - 函数f(amount)代表了拼出amount所需要的最小的硬币，-1代表拼不出
## 实现
- 函数f(amount)代表了拼出amount所需要的最小的硬币
- 我直接对每一个函数，返回这个递推公式：f(amount) =  MIN{f(amount-coins[0]), f(amount-coins[1]), ..., f(amount-coins[n-1])} + 1
```
在这里，我引入一个数组f[]
f[amount]代表了拼出amount所需要的最小的硬币。
如果f[amount] == null 表示还没有初始化
f[amount] != null 代表已经初始化了，如果有值，直接返回这个值
```
- 递归函数必须有base 否则会爆栈。于是，在amount=0的时候，我返回0，用0个硬币拼出钱=0.在amount<0的时候，返回-1，因为拼不出。其他情况，对 每一个硬币coins[k]，去求子问题的解`f(amount-coins[k])`.如果子问题的解不为-1（有解），那么与当前全局最小值进行一个比较

# Bottom up
## 思路
- 思路,终止条件 - 要拼出amount的数量，就必须拼出一个比amount更小的数。这个数=`amount-coins[k] (0<=k<n)`
- 思路,最后一步 - 对于所有可以拼出的(amount-coins[k]), 找出其中的最小值  `f(amount) = MIN{f(amount-coins[0]), f(amount-coins[1]), ..., f(amount-coins[n-1])} + 1`
- 思路,子问题 - 函数f(amount)代表了拼出amount所需要的最小的硬币，-1代表拼不出
## 实现

在这里，我引入一个数组f[]
f[amount]代表了拼出amount所需要的最小的硬币。
f[0]= 0
对于每一个amount 在求解他的时候 amount-coins[k]已经被求解了
注意，数组越界的问题


