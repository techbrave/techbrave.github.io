---
title: Unique Paths, a case study
layout: post
categories: [DynamicProgramming]
---

# Case study - Unique paths
[LC Problem link](https://leetcode.com/problems/unique-paths/)

# Brute force
## 思路
- 思路,终止条件 - 要到达星星位置，必须先到达星星左边或者星星上边的位置
- 思路,最后一步 - 如果到达星星左边有a种办法，到达星星上边有b种办法，那到达星星就有a+b种办法
- 思路,子问题 - 函数f(i,j)代表了到达任意位置(i,j)有多少种办法。
## 实现
- 函数f(i, j)会告诉我到达位置(i,j)的办法
- 我直接对每一个函数，返回这个递推公式：f(i,j) = f(i,j-1) + f(i-1,j)
- 递归函数必须有base 否则会爆栈。于是，在i=0的时候，我返回1.j=0的时候，返回1

# Brute force with memoization (Top-down)
## 思路
- 思路,终止条件 - 要到达星星位置，必须先到达星星左边或者星星上边的位置
- 思路,最后一步 - 如果到达星星左边有a种办法，到达星星上边有b种办法，那到达星星就有a+b种办法
- 思路,子问题 - 函数f(i,j)代表了到达任意位置(i,j)有多少种办法。

## 实现
- 函数f(i, j)会告诉我到达位置(i,j)的办法
- 我直接对每一个函数，返回这个递推公式：f(i,j) = f(i,j-1) + f(i-1,j)
```
在这里，我优化一下。如果f(i,j)曾经算过了，就不要递归调用这些子函数了，而是直接返回计算过的值。
可以认为是cache, 但一般起名字为memo.
Map<Int[], Integer> memo
你会发现，在Java hashmap以坐标为存储key不方便。
恰好，我们又知道所有可能的key(不会超过矩阵的范围)，所以我们可以用一个二维数组代替这个hashmap
memo[i][j]

最后优化的结果就是，在递归开始前，先查查memo[][]。如果算过了，那就不要递归叫子函数了。
我们函数返回之前，也要update一下memo[i][j]的值
```
- 递归函数必须有base 否则会爆栈。于是，在i=0的时候，我返回1.j=0的时候，返回1

# Bottom up
## 思路
- 思路,终止条件 - 要到达星星位置，必须先到达星星左边或者星星上边的位置
- 思路,最后一步 - 如果到达星星左边有a种办法，到达星星上边有b种办法，那到达星星就有a+b种办法
- 思路,子问题 - 函数f(i,j)代表了到达任意位置(i,j)有多少种办法。
- 思路,转移方程:f(i,j) = f(i,j-1) + f(i-1,j)

## 实现
- 实现,状态(记忆) 把到达(i,j)的方法总数记录在dp[i][j]之中
- 实现,数组越界？初始状态->对i=0的第一行，所有位置都只有一种走法，就是顺着起点一直向右走
- 实现,数组越界？初始状态->对j=0的第一列，所有位置都只有一种走法，就是顺着起点一直向下走
- 实现,递推要求：走到位置(i,j)的时候，他的上面，和左边的结果都必须已经算出来了
- 实现,递推结论：先顺着行走 每一行里顺着列走
- 实现,如何优化空间? 我们发现，每次一行一行update下来，他前一行的信息完全没用
```
具体说来 dp[2][j] = dp[2-1][j] + dp[2][j-1]
那么dp[2-1][j]的值，对于dp[10][j]还有没有用呢？
答案是，没有！
所以我们做了一个很精明的办法，就是每次更新我们dp[i][j]的时候，不把他存在一个全新的位置，而是塞到dp[i-1][j]里。
```

# Follow-up 1: obstacles
[LC Problem link](https://leetcode.com/problems/unique-paths-ii/)


# Follow-up 2: every walk has a cost (最值型)
1. what if every visit, has a "cost" to it. for example,
you start at top-left, and end at bottom right. every cell has a cost grid[i][j]. If grid[i][j] is -1, it means an obstacle
[
    [0, 2, 5],
    [1, -1, 1],
    [4, 1, 0]
]

# Follow-up 3: you can move in all 4 directions, you need to find how many possible walks from start to end (obstacles are in the grid) 

[LC Problem link](https://leetcode.com/problems/unique-paths-iii/)
```java
class Solution {
    private int totalWalks = 0; 
    
    public int uniquePathsIII(int[][] grid) {
        int emptyCnt = 1; 
        int si = -1; int sj = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) emptyCnt++; 
                if (grid[i][j] == 1) {
                    si = i; sj = j; 
                }
            }
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length]; 
        backTrack(si, sj, grid, visited, emptyCnt);
        return totalWalks;
    }
    
    // BruteForce, dfs + backtracking 
    private void backTrack(int i, int j, int[][] grid, boolean[][] visited, int remains) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] == -1) return; 
        // base
        if (grid[i][j] == 2) {
            if (remains == 0) totalWalks++; 
            return; 
        }
        // try 
        visited[i][j] = true;
        backTrack(i-1, j, grid, visited, remains-1); 
        backTrack(i+1, j, grid, visited, remains-1); 
        backTrack(i, j-1, grid, visited, remains-1); 
        backTrack(i, j+1, grid, visited, remains-1); 
        visited[i][j] = false;
    }
}
```

# Follow-up 4: now you can move in all 4 directions, and you need to find shortest path from start to end (obstacles are in the grid)
```java 
// inspired based on leetcode unique paths iii
// now we just want to know the shortest path from start to end, with obstacles
public class UniquePathIV {
    public int uniquePathsIV(int[][] grid) {
        int ei = -1;
        int ej = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    ei = i;
                    ej = j;
                }
            }
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        // Naive backtrack
        // return backTrack(ei, ej, grid, visited);

        Integer[][] memo = new Integer[grid.length][grid[0].length];
        return backTrackWithMemo(ei, ej, grid, visited, memo);
    }

    private int backTrack(int i, int j, int[][] grid, boolean[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] == -1) return -1;
        // base
        if (grid[i][j] == 1) {
            return 0;
        }

        visited[i][j] = true;
        int ans = Integer.MAX_VALUE;
        for (int k = 0; k < 4; k++) {
            int sub = backTrack(i + di[k], j + dj[k], grid, visited);
            if (sub != -1) {
                ans = Math.min(ans, sub + 1);
            }
        }
        if (ans == Integer.MAX_VALUE) ans = -1;
        visited[i][j] = false;
        return ans;
    }

    private int backTrackWithMemo(int i, int j, int[][] grid, boolean[][] visited, Integer[][] memo) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] == -1) return -1;
        // base
        if (grid[i][j] == 1) {
            return 0;
        }
        if (memo[i][j] != null) return memo[i][j];
        visited[i][j] = true;
        int ans = Integer.MAX_VALUE;
        for (int k = 0; k < 4; k++) {
            int sub = backTrackWithMemo(i + di[k], j + dj[k], grid, visited, memo);
            if (sub != -1) {
                ans = Math.min(ans, sub + 1);
            }
        }
        if (ans == Integer.MAX_VALUE) ans = -1;
        visited[i][j] = false;
        memo[i][j] = ans;
        return memo[i][j];
    }

    private int[] di = new int[]{-1, 1, 0, 0};
    private int[] dj = new int[]{0, 0, -1, 1};

    public static void main(String[] args) {
        UniquePathIV uniquePathIV = new UniquePathIV();
        int[][] grid = new int[3][3];
        grid[0] = new int[]{1, 0, 0};
        grid[1] = new int[]{-1, -1, 0};
        grid[2] = new int[]{0, 0, 2};
        int ans = uniquePathIV.uniquePathsIV(grid);
        System.out.println(ans);
    }
}
```