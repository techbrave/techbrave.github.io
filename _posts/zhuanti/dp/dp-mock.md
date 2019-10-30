[LC tips](https://leetcode.com/discuss/interview-question/416381/google-phone-interview-question-dp)
```
You start at index 0 in an array with length 'h'. At each step, you can move to the left, move to the right, or stay in the same place(Note! Stay in the same place also takes one step). How many possible ways are you still at index 0 after you have walked 'n' step?

Example： n = 3
1. right->left->stay
2. right->stay->left
3. stay->right->left
4. stay->stay->stay

Can anyone solve it in n^2
```
# 状态
f(i, n) means we reach index `i`, using `n`step, in `f(i, n)` different ways. 

# 递推公式
then, there are 3 ways to do it 
- last step, we stay
- last step, we are at index `i-1`, and we jump one unit right to reach index `i`
- last step, we are at index `i+1`, and we jump one unit left to reach index `i` 
```java
f(i, n) = f(i, n-1) + f(i-1, n-1) + f(i+1, n-1)
```

# 初始状态
```
f(0, 0) = 1, f(1, 0) = f(2, 0) = ... = f(h-1, 0) = 0
```

# 例子(二维矩阵)
an example walk through (to help we determine the order of the for loops)
> for loop 永远是从小状态到大状态，和时间有关

[Odd Even Jump](https://leetcode.com/problems/odd-even-jump/)