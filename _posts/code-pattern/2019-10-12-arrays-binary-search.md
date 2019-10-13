---
title: Arrays - Binary Search
layout: post
---

summary: Binary Search is one of the most important cases, to apply `Divide and conquer` technique, where we break the original problem by half, and solve smaller sub-problems to reach an answer. 

## Invariant
If the property holds even under some transformation. 
Start state: invariant property holds
Induction: invariant property still holds

- 第一重境界
    二分法模板
- 第二重境界
    二分位置(Binary Search On Index) - OOXX
- 第三重境界
    二分位置,保留一半 - 保留有解的一半，去掉无解的另一半
- 第四重境界
    二分答案


# 第一重境界: 二分法模板
- 选择递归实现，还是非递归的实现？
- 二分时三大痛点
- 通用模板

# 第二重境界: 二分查找位置
- 满足条件的第一个位置，或最后一个位置

## Find k closest element

# 第三重境界：二分查找，保留一半
- 二分位置-保留有解的一半，去掉无解的另一半

## Find peak element

```java 
class Solution {
    public int findPeakElement(int[] A) {
        if (A == null || A.length == 0) return -1; 
        if (A.length == 1) return 0; 
        int start = 0; int end = A.length - 1; 
        while (start + 1 < end) {
            int mid = start + (end - start) / 2; 
            if (A[mid] > A[mid-1] && A[mid] > A[mid+1]) return mid;
            else if (A[mid] > A[mid-1]) 
                start = mid;
            else 
                end = mid;
        }
        if (start == 0 && A[start] > A[start+1]) return start; 
        if (start > 0 && A[start] > A[start-1] && A[start] > A[start+1]) return start; 
        if (end == A.length - 1 && A[end] > A[end-1]) return end;
        if (end < A.length && A[end] > A[end-1] && A[end] > A[end+1]) return end;
        return -1;
    }
}
```

## Search in a rotated sorted array
- (1) input validation (empty array check)
- (2) // avoid index out of bound exception
```java
class Solution {
    public int search(int[] A, int target) {
        // (1) input validation (empty array check)
        if (A == null || A.length == 0) return -1; 
        int start = 0; int end = A.length; 
        while (start + 1 < end) { // avoid index out of bound, use this template
            int mid = start + (end - start) / 2;
            int comparator;
            if ( (target >= A[0] && A[mid] >= A[0]) || (target < A[0] && A[mid] < A[0]) ) {
                comparator = A[mid];
            } else {
                if (A[mid] >= A[0])
                    comparator = Integer.MIN_VALUE;
                else 
                    comparator = Integer.MAX_VALUE;
            }
            if (target == comparator)
                return mid;
            else if (target < comparator) 
                end = mid;
            else start = mid;
        }
        if (start >= 0 && A[start] == target) return start;
        if (end < A.length && A[end] == target) return end;
        return -1;
    }
    // the INF, -INF solution aims to convert the problem to a regular binary search problem
    // and the only difference is that, we need to be cerntain, if target is in the same side of A[mid]
    // x in left half: x >= nums[0]
    // x in right half: x > nums[0]
    // if not in the same half, it means we need to make some adjustments
    // if A[mid] in left half, make A[mid] -INF (by inference, we know target in right half, we need to make them go right)
    // if A[mid] in right half, make A[mid] +INF (by inference, we know target in left half)
}
```
## Search in a rotated sorted array

# 其他的LogN算法

## 倍增法: Exponential Backoff

## 快速幂转法
## Pow(n)
```java
class Solution {
    public double myPow(double x, int n) {
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                // overflow
                int half = Integer.MIN_VALUE / 2;
                return 1 / (myPow(x, -half)*myPow(x, -half));
            }
            return 1/myPow(x, -n);
        }
        if (n == 0) return 1.0;
        if (n == 1) return x; 
        else {
            double t = myPow(x, n/2);
            if (n % 2 == 0) return t * t;
            else return x * t * t;
        }
    }
    // ( x^(n/2) ) ^ 2
}
```

## 辗转相除法（GCD）

# 第四重境界：二分答案
