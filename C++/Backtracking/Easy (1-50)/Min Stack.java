/*
# Min Stack

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Example:
```
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
```

- My Answer
*/
package easy;

import java.util.ArrayDeque;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月21日
 */
public class MinStack
{
    private ArrayDeque<Integer> stack;
    public static void main(String[] args)
    {
         MinStack obj = new MinStack();
         obj.push(-3);
         obj.push(-2);
         obj.push(10);
         obj.pop();
         obj.pop();
         int param_3 = obj.top();
         int param_4 = obj.getMin();
         System.out.println("p3:"+param_3+",p4:"+param_4);
    }
    
    /** initialize your data structure here. */
    public MinStack() {
            stack=new ArrayDeque<Integer>();
    }
    
    public void push(int x) {
        stack.push(x);
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
            ArrayDeque<Integer> tempStack=new ArrayDeque<Integer>();
            int min=Integer.MAX_VALUE;
            int size=stack.size();
            
        for(int i=0;i<size;i++) {
                int ele=stack.pop();
                stack.add(ele);
                if(ele<min)
                    min=ele;
        }
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
