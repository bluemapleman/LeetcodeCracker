
/*
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:

Can you solve it without using extra space?


*/
package medium1;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年4月16日
 */
/*
Thought:
For a linked list cycle like below:
111111111
      1 1
      111
a denotes the length before the cycle, 
b denotes the length Slow has walked through measuring from the start of the cycle when it first encounter Fast,
c denotes the total length of circle decreasing b

So, when Slow and Fast meet for the first time:

Slow walks through: a+b
Fast walks through: a+n*(b+c)+b (n=1,2,3,...)

Because Fast walks two times as fast as Slow,so:

a+2b+c=2(a+b) -> a=c

So when Slow and Fast meet, then we can start a pointer from the start of the linked list again, and let it and Slow started walking ahead simultaneously until they meet, then the meeting point must be the start of the cycle.

*/
public class LinkedListCycleII
{
    public ListNode detectCycle(ListNode head) {
        // without extra space
        ListNode slow=head,fast=head;
        while(fast!=null && fast.next!=null) {
            fast=fast.next.next;
            slow=slow.next;
            
            if(slow==fast) {
                ListNode slow2=head;
                while(slow!=slow2) {
                    slow=slow.next;
                    slow2=slow2.next;
                }
                return slow;
            }
        }
        return null;
        
        // with extra space
//      Set<ListNode> set=new HashSet<>();
//      while(head!=null) {
//          if(set.contains(head))
//              return head;
//          else
//              set.add(head);
//          head=head.next;
//      }
//        return null;
    }
}

