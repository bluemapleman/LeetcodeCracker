/*

# Linked List Cycle

Given a linked list, determine if it has a cycle in it.

Follow up:

Can you solve it without using extra space?

- My Answer
*/
package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月21日
 */
public class LinkedListCycle
{
    public static void main(String[] args)
    {
        ListNode head=new ListNode(1);
        ListNode node1=new ListNode(1);ListNode node2=new ListNode(1);
        head.next=node1;node1.next=node2;node2.next=null;
        System.out.println(hasCycle(head));
        
    }
    
     public static boolean hasCycle(ListNode head) {
        Set<ListNode> set=new HashSet<ListNode>();
        while(head!=null) {
            if(!set.contains(head)) {
                set.add(head);
            }else {
                return true;
            }
            head=head.next;
        }
        return false;
     }
}

