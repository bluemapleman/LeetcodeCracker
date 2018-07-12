
/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.


*/
package medium1;

import java.util.ArrayDeque;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月29日
 */
public class AddTwoNumbers
{
     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            StringBuilder str=new StringBuilder("");
            ArrayDeque<Integer> stack1=new ArrayDeque<Integer>();
            ArrayDeque<Integer> stack2=new ArrayDeque<Integer>();
            
            while(l1!=null){
                stack1.offer(l1.val);
                l1=l1.next;
            }
            while(l2!=null){
                stack2.offer(l2.val);
                l2=l2.next;
            }
            
            boolean jinwei=false;
            while(!stack1.isEmpty() && !stack2.isEmpty()){
                int ele1=stack1.poll(),ele2=stack2.poll();
                int sum;
                if(jinwei==true){
                    sum=ele1+ele2+1;
                }else{
                    sum=ele1+ele2;
                }

                jinwei=false;
                if(sum>=10)
                    jinwei=true;
                str.append(""+sum%10);
            }
            
            while(!stack1.isEmpty()){
                int ele=stack1.poll();
                if(jinwei==true){
                    str.append((ele+1)%10);
                    if(ele+1>=10){
                        jinwei=true;
                    }
                    else{
                        jinwei=false;
                    }
                }else{
                    str.append(ele);
                }
            }
            while(!stack2.isEmpty()){
                int ele=stack2.poll();
                if(jinwei==true){
                    str.append((ele+1)%10);
                    if(ele+1>=10){
                        jinwei=true;
                    }
                    else{
                        jinwei=false;
                    }
                }else{
                    str.append(ele);
                }
            }
            
            if(jinwei==true)
                str.append("1");
            
            
            
            int []arr=new int[str.length()];
            ListNode []nodeArr=new ListNode[arr.length];
            
            for(int i=0;i<str.length();i++){
                arr[i]=Character.digit(str.charAt(i), 10);
                nodeArr[i]=new ListNode(arr[i]);
                
            }
            
            for(int i=0;i<nodeArr.length-1;i++)
                nodeArr[i].next=nodeArr[i+1];
            return nodeArr[0];
        }
}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}

