
/*
Given a singly linked list, determine if it is a palindrome.

Follow up:

Could you do it in O(n) time and O(1) space?


*/
package easy2;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月28日
 */
public class PalindromeLinkedList
{
    public static void main(String[] args)
    {
        ListNode node1=new ListNode(-129);
        ListNode node2=new ListNode(1232);
        ListNode node3=new ListNode(1232);
        ListNode node4=new ListNode(-129);
        node1.next=node2;node2.next=node3;node3.next=node4;
        System.out.println(isPalindrome(node1));
        
    }
    
    
    
    // If a String is a palindrome, then read it forward or backward would derive same result.
    // Use ArrayDeque
    public static boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null)
            return true;
        ArrayDeque<ListNode> deque=new ArrayDeque<ListNode>();
        
        while(head!=null) {
            deque.add(head);
            head=head.next;
        }
        
        while(deque.size()!=0) {
            if(deque.size()==1) {
                return true;
            }else {
                ListNode front=deque.pollFirst(),back=deque.pollLast();
                    if(front.val==back.val)
                        continue;
                    else
                        return false;
            }
        }
            
        return true;
    }
    
    //This method exceeds time limit;
//  public static boolean isPalindrome(ListNode head) {
//      if(head==null || head.next==null)
//          return true;
//      
//      String str="";
//      
//      long start=System.currentTimeMillis();
//      while(head!=null){
//          str+=head.val+"@";
//          head=head.next;
//      }
//      System.out.println("part1:"+(System.currentTimeMillis()-start)+"s");
//      
//      start=System.currentTimeMillis();
//      
//      str=str.substring(0,str.length()-1);
//      
//      String[] strs=str.split("@");
//      
//      // This part2 and part3 spends most of the time, need improvement
//      System.out.println("part2:"+(System.currentTimeMillis()-start)+"s");
//      
//      str=str.substring(0,str.length()-1);
//      for(int i=0;i<strs.length/2;i++) {
//          if(strs[i].equals(strs[strs.length-i-1]))
//              continue;
//          else
//              return false;
//      }
//      System.out.println("part3:"+(System.currentTimeMillis()-start)+"s");
//
//        return true;
//    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}

