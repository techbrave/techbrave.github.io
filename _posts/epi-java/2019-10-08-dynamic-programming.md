---
title: Java - Dynamic Programming
layout: post
---

summary:  DP is a general technique for solving optimization, search, and counting problems that can be decomposed into subproblems. You should consider using DP whenever you have to make choices to arrive at the solution, specifically, when the solution relates to subproblems.

# Motivation

We would like to apply DP, for optimization (max, min), search (exist?), and counting (how many in total?); 

Whenever the problem involves solve sub problems, consider DP as a technique. The same subproblem may occur, thus with caching result (recursion), we will optimize its performance. 

Unlike divide and conquer, where we tend to divide the problems into subproblems of equal sizes, dynamic programming subproblems are focusing on making **one step of choice**.



# Bootcamp

- Fibonacci 
- Climbing stairs

# key

- The original problem, can be solved relatively easy, once you have solved the subproblem (you just have to make one step choice more on top of the already-solved subproblem)
- The subproblem solutions(dynamic programming state, solution) are cached

# Common mistakes

- Trying it to think of the recursive cases, by splitting the original problem into two equal halves
- Combining the solution should `yield a solution`o the original problem. For example, if the longest path without repeated cities from C1 to C2, passes through C3, then the subpaths from C1 to C3, and C3 to C2, may not be individually longest path without repeated cities. 

# Tips

- Consider DP, whenever you need to maker choices to arrive to the solution. Specifically, when the solution relates to subproblems
- In addition to `optimization problems (MIN, MAX)`, DP is applicable to `counting` problems, and `decision` problems

- Although, DP involves recursion, for efficiency, we need to build the cache **bottom-up**, starting from smallest problem, and gradually make it bigger, until we arrive at the final solution
- To save space, the cache space, could be **recycled** (rolling array)
- Sometimes, recursion, may out-perform a bottom-up DP. For example, if the solution is found early or subproblems can be **pruned** using bounding. 

# 17.5 Search for a sequence in 2D array

```java
public static boolean isPatternContainedInGrid(List<List<Integer>> grid,
                                                   List<Integer> pattern) {

        for (int i = 0; i < grid.size(); ++i) {
            for (int j = 0; j < grid.get(i).size(); ++j) {
              // memo cannot be just boolean, it need to have 3 state: not initialized, success(exist), fail (does not exist)
                Set<Attempt> attempts = new HashSet<>();
                if (f(attempts, grid, i, j, pattern, 0)) return true;
            }
        }

        return false;
    }

    static class Attempt{
        int x;
        int y;
        int pos;
        public Attempt(int i, int j, int p) {
            x = i;
            y = j;
            pos = p;
        }
    }

    // the first i items in pattern, is present in the grid? or not
    private static boolean f(Set<Attempt> attempts,
                             List<List<Integer>> grid,
                             int i,
                             int j,
                             List<Integer> pattern,
                             int pos) {
        if (pos == pattern.size()) return true;
        if (i < 0 || i >= grid.size() || j < 0 || j >= grid.get(0).size()) return false;
        if (attempts.contains(new Attempt(i, j, pos))) return false;

        boolean res = grid.get(i).get(j).equals(pattern.get(pos))
                && (f(attempts, grid, i + 1, j, pattern, pos + 1)
                || f(attempts, grid, i - 1, j, pattern, pos + 1)
                || f(attempts, grid, i, j + 1, pattern, pos + 1)
                || f(attempts, grid, i, j - 1, pattern, pos + 1));

        if (!res) attempts.add(new Attempt(i, j, pos));
        return res;
    }
```

# 17.7 The BedBathAndBeyond.com problem

```java
// TODO
decomposeIntoDictionaryWords
```



