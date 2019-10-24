---
title: Java - Stack and Queue
layout: post
categories: [EPI_Java]
---

Summary: The key intuition is reflected by the name. imagine a pile of books, you you only take the book at the top, then the second book underneath. Imagine a line at Starbucks, if you come in late, you have to wait.

## Tips
 - Learn to recognize when the stack LIFO property is applicable. For example,parsing typically benefits from a stack. [Problems 9.2 and 9.6]
- Consider augmenting the basic stack or queue data structure to support additional operations, such as finding the maximum element. [Problem 9.1]
- Try to recognize when to use LIFO and FIFO. If you need to preserver order, queue is best (9.7)

## Java Library (Stack)
```java
Stack<T> stack = new Stack<>();
push(); 
pop(); 
peek(); 
isEmpty();

```

## Java Library (Queue)
```java
// it is recommended to use Deque, but I'll just keep using LinkedList 
push(); 
pop(); 
peek(); 
isEmpty();

```

## Max Stack
```java
class MaxStack {
    
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> maxStack = new Stack<>();

    /** initialize your data structure here. */
    public MaxStack() {
        
    }
    
    public void push(int x) {
        if (isEmpty()) {
            stack.push(x); 
            maxStack.push(x);
        } else {
            int currMax = peekMax();
            currMax = Math.max(currMax, x);
            stack.push(x); 
            maxStack.push(currMax);
        }
    }
    
    public int pop() {
        if (isEmpty()) return -1;
        maxStack.pop();
        return stack.pop();
    }
    
    public int top() {
        if (isEmpty()) return -1;
        return stack.peek();
    }
    
    public int peekMax() {
        if (isEmpty()) return -1;
        return maxStack.peek();
    }
    
    public int popMax() {
        if (isEmpty()) return -1;
        int currMax = maxStack.pop();
        Stack<Integer> temp = new Stack<>();
        while (stack.peek() != currMax) {
            temp.push(pop());
        }
        stack.pop();
        while (!temp.isEmpty()) {
            push(temp.pop());
        }
        
        return currMax;
    }
    
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */

```
