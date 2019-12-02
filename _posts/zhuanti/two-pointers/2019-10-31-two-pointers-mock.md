---
title: Two Pointers
layout: post
categories: [Zhuanti]
---


# What is a two pointer technique?

对于求 2 个变量如何组合的问题
可以循环其中一个变量，然后研究另外一个变量如何变化

In problems where we deal with the Two Pointers approach becomes quite useful. The set of elements could be a pair, a triplet or even a subarray. For example, take a look at the following problem (2SUm)

--- 
Pattern 

[Pair with Target sum](https://www.educative.io/courses/grokking-the-coding-interview/xog6q15W9GP)

[Remove duplicates](https://www.educative.io/courses/grokking-the-coding-interview/mEEA22L5mNA)

[Squaring a Sorted Array](https://www.educative.io/courses/grokking-the-coding-interview/R1ppNG3nV9R)

[2sum](https://leetcode.com/problems/two-sum/submissions/)
// return index

[3Sum](https://leetcode.com/problems/3sum/submissions/)

[3Sum Closest](https://leetcode.com/problems/3sum-closest/submissions/)

[3Sum Smaller](https://leetcode.com/problems/3sum-smaller/submissions/)

[Subarray product less than k](https://leetcode.com/problems/subarray-product-less-than-k/submissions/)

[Dutch flag problem](https://www.educative.io/courses/grokking-the-coding-interview/RMBxV6jz6Q0)
```java
class DutchFlag {

  public static void sort(int[] arr) {
    int i = 0; int j = arr.length - 1; 
    for (int k = 0; k <= j; k++) {
      if (arr[k] == 0) {
        swap(arr, i, k); 
        i++;
      }
    }

    for (int k = arr.length - 1; k >= 0; k--) {
      if (arr[k] == 2) {
        swap(arr, j, k); 
        j--;
      }
    }
  }

  private static void swap(int[] arr, int i, int j) {
    int t = arr[i]; arr[i] = arr[j]; arr[j] = t;
  }
}
```

[4Sum](https://leetcode.com/problems/4sum/submissions/)

[4sum II](https://leetcode.com/problems/4sum-ii/submissions/)

[Comparing String containing Backspace](https://www.educative.io/courses/grokking-the-coding-interview/xVKE8MJDlzq)

[Minimum window of array when sorted, the whole array is sorted](https://www.educative.io/courses/grokking-the-coding-interview/N8rOAP6Lmw6)

[Maximum trapping water](https://www.educative.io/courses/grokking-the-coding-interview/Bn22o0PzRoX)

---

[Implement strStr()](https://leetcode.com/problems/implement-strstr/)

// 字符串匹配：KMP算法

[3 sum](https://leetcode.com/problems/3sum/)

[Move Zeros](https://leetcode.com/problems/move-zeroes/)

[3 sum smaller](https://leetcode.com/problems/3sum-smaller/)

[Trapping rain water](https://leetcode.com/problems/trapping-rain-water/)

[Trapping rain water ii](https://leetcode.com/problems/trapping-rain-water-ii/submissions/) // shortest bar so far is the "barrier"

[Interval list intersections](https://leetcode.com/problems/interval-list-intersections/)

[3sum with multiplicity](https://leetcode.com/problems/3sum-with-multiplicity/submissions/)
--- 
九章

LintCode 389. Find the difference