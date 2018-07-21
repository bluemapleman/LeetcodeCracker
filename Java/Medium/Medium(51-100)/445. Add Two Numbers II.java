
/*
You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7
*/

class Solution {
     // Attention: when dealing with List relevant problems, remember to check whether the ListNode you return 
    // is actually the head node, not the tail node you used to iterate.
    
    // for this problem, another point to notice is that the upper boundary of int data type.
    
    // remember, when doing add calculation for int String, there may be one more bit because of carry, don't miss it!!!!
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        String num1Str=constructNumberStr(l1),num2Str=constructNumberStr(l2);
        
        // wrong, the sum of num1 and num2 may exceed Integer.MAX_VALUE.
//      int sum=num1+num2;
        // rewrite add() method for two number represented by String
        String sumStr=addTwoStringInteger(num1Str, num2Str);

        ArrayDeque<ListNode> stack=new ArrayDeque<>();
        for(int i=sumStr.length()-1;i>=0;i--) {
            int digit=Character.digit(sumStr.charAt(i), 10);
            stack.push(new ListNode(digit));
        }
        
        ListNode head=null,ans=null;
        if(stack.isEmpty()) {
            head=new ListNode(0);
            ans=head;
        }
        else {
            head=stack.pop();
            ans=head;
            while(!stack.isEmpty()) {
                head.next=stack.pop();
                head=head.next;
            }
        }
        return ans;
    }
    
    public String constructNumberStr(ListNode head) {
        String res="";
        while(head!=null) {
            res+=head.val;;
            head=head.next;
        }
        return res;
    }
    
    public String addTwoStringInteger(String s1,String s2) {
        StringBuilder ans=new StringBuilder("");
        
        int len=Math.max(s1.length(), s2.length());
        
        // compensate for 0, to make two String the same length
        int delta=len-s1.length();
        for(int i=0;i<delta;i++)
            s1="0"+s1;
        delta=len-s2.length();
        for(int i=0;i<delta;i++)
            s2="0"+s2;
        
        boolean carry=false;
        // add bit-wise
        for(int i=len-1;i>=0;i--) {
            int num1=Character.digit(s1.charAt(i), 10),num2=Character.digit(s2.charAt(i), 10);
            if(carry)
                num1++;
            int sum=num1+num2;
            if(sum>=10)
                carry=true;
            else
                carry=false;
            
            if(carry)
                ans.append(1);
        }
        return ans.reverse().toString();
    }
}