---
title: Cyclic sort
layout: post
categories: [Zhuanti]
---

# Introduction

This pattern describes an interesting approach to deal with problems involving arrays containing numbers in a given range. For example, take the following problem:

> You are given an unsorted array containing numbers taken from the range 1 to ‘n’. The array can have duplicates, which means that some numbers will be missing. Find all the missing numbers.

To efficiently solve this problem, we can use the fact that the input array contains numbers in the range of 1 to ‘n’. For example, to efficiently sort the array, we can try placing each number in its correct place, i.e., placing ‘1’ at index ‘0’, placing ‘2’ at index ‘1’, and so on. Once we are done with the sorting, we can iterate the array to find all indices that are missing the correct numbers. These will be our required numbers.

# Pattern
[Cyclic sort](https://www.educative.io/courses/grokking-the-coding-interview/B8qXVqVwDKY)

[Find the missing number](https://www.educative.io/courses/grokking-the-coding-interview/JPnp17NYXE9)

[Find all missing numbers](https://www.educative.io/courses/grokking-the-coding-interview/Y52qNM0ljWK)

[Find the duplicate number](https://www.educative.io/courses/grokking-the-coding-interview/3wEkKy6Pr9A)

[Find all duplicate numbers](https://www.educative.io/courses/grokking-the-coding-interview/RLw1Pjk1GQ0)

[Find the Corrupt Pair](https://www.educative.io/courses/grokking-the-coding-interview/mE2LVDE3wp0)

[Find the smallest Missing Positive Number](https://www.educative.io/courses/grokking-the-coding-interview/3jEXWgB5ZmM)

[Find the k-th missing number](https://www.educative.io/courses/grokking-the-coding-interview/q2LA7G0ANX0)