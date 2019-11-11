---
title: Merge Intervals
layout: post
categories: [Zhuanti]
---

# Introduction

> Java lambda comparator
https://www.mkyong.com/java8/java-8-lambda-comparator-example/

The key idea is to first sort the intervals based on the start index, and then traverse all the intervals. 
If we find `current interval start index > prev interval end index`, there is NO overlap! 
If we find `current interval start index <= prev interval end index`, there IS overlap! 

# Pattern 
[Merge intervals](https://www.educative.io/courses/grokking-the-coding-interview/3jyVPKRA8yx)

[Given a set of intervals, find out if any two intervals overlap](https://www.educative.io/courses/grokking-the-coding-interview/3jyVPKRA8yx)

[Insert Interval](https://www.educative.io/courses/grokking-the-coding-interview/3jKlyNMJPEM)

[Interval intersections](https://www.educative.io/courses/grokking-the-coding-interview/JExVVqRAN9D)

[Conflict meetings](https://www.educative.io/courses/grokking-the-coding-interview/qVV79nGVgAG)

[Minimum meeting room required](https://www.educative.io/courses/grokking-the-coding-interview/xVoBRZz7RwP)
```
Similar problems

Problem 1: Given a list of intervals, find the point where the maximum number of intervals overlap.

Problem 2: Given a list of intervals representing the arrival and departure times of trains to a train station, our goal is to find the minimum number of platforms required for the train station so no train has to wait. 
```

[Max CPU Load](https://www.educative.io/courses/grokking-the-coding-interview/xVlyyv3rR93)

[Employee free time](https://www.educative.io/courses/grokking-the-coding-interview/YQykDmBnvB0)
MergeSort + interval + missing range, very good!
But wait, it follows `k-way` merge patten, which is EVEN BETTER

# Tips (Mock)
https://leetcode.com/discuss/interview-question/294744/Google-or-Onsite-or-Busy-Traffic



# Leetcode
[Meeting rooms](https://leetcode.com/problems/meeting-rooms/submissions/)

[Meeting rooms ii](https://leetcode.com/problems/meeting-rooms-ii/solution/)

[Meeting Scheduler](https://leetcode.com/problems/meeting-scheduler/submissions/)

[Car Fleet](https://leetcode.com/problems/car-fleet/submissions/)

