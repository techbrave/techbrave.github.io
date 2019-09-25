---
title: Java - Binary Search
layout: post
---

Summary: Fundamentally, binary search is a natural elimination-based strategy for searching a sorted array. The idea is to eliminate half the keys from consideration by keeping the keys in sorted order. If the search key is not equal to the middle element of the array, one of the two sets of keys to the left and to the right of the middle element can be eliminated from further consideration 

## Tips

- Binary search is an effective search tool. It is applicable to more than just searchingin sorted arrays, e.g., it can be used to search an interval of real numbers orintegers
- If your solution uses sorting, and the computation performed after sorting is faster than sorting, e.g., `O(n)` or `O(log n)`, look for solutions that do not performa complete sort. 
- Consider time/space tradeoffs, such as making multiple passes through the data.

## Java library and syntax 

```java
Arrays.binarySearch(A,“Euler”)
Collections.binarySearchflist ,42)
// These return the index of the searched key if it is present, and a negative value if it is not present.
// When there are multiple occurrences of the search key, neither Arrays nor Collections offer any guarantees as to which one will be found by binary search.
// If the search key is not present, both methods return (-(insertion point) - 1), where insertion point is defined as the point at which the key would be inserted into the array, i.e., the index of the first element greater than the key, or the number of elements if all elements are less than the specified value.
```



## Square Root of Real Number 

```java
public static double squareRoot(double x) {
    // 1)first, for number less than 1.0, start, and end is different
    double start, end;
    if (x < 1.0) {
        start = x;
        end = 1.0;
    } else {
        start = 1.0;
        end = x;
    }

    while (compare(start, end) != Order.EQUAL) {
        double mid = start + (end - start) * 0.5;
        Order order = compare(mid * mid, x);  // compare squared result
        if (order == Order.EQUAL) return mid;
        else if (order == Order.SMALLER) start = mid;
        else end = mid;
    }
    return start;
}

enum Order {SMALLER, EQUAL, LARGER}

private static Order compare(double a, double b) {
    final double EPSILON = 0.000000001;
    //3. Uses normalization for precision problem.
    double diff = (a - b) / b;
    if (Math.abs(diff) < EPSILON) return Order.EQUAL;
    else if (a > b) return Order.LARGER;
    else return Order.SMALLER;
}
```

12.10 duplicate or missing ?
