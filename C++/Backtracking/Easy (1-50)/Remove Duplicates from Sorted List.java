/*
# Remove Duplicates from Sorted List

Given a sorted linked list, delete all duplicates such that each element appear only once.

```
For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
```

- My Answer
*/
package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月13日
 */
public class RemoveDuplicatesfromSortedList
{

    public static void main(String[] args)
    {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(1);
        ListNode node3=new ListNode(2);
        ListNode node4=new ListNode(3);
        ListNode node5=new ListNode(3);
        node1.next=node2;node2.next=node3;node3.next=node4;node4.next=node5;
        ListNode head=deleteDuplicates(node1);
        while(head!=null) {
            System.out.println(head.val);
            head=head.next;
        }
        
    }
    
    public static ListNode deleteDuplicates(ListNode head) {
        Set<Integer> set=new HashSet<Integer>();
        
        ListNode lastNode=head,resultHead=head;
        while(head!=null) {
            if(set.contains(head.val)) {
                lastNode.next=head.next;
                head.next=null;
                head=lastNode.next;
            }else {
                set.add(head.val);
                lastNode=head;
                head=head.next;
            }
        }
        return resultHead;
    }
}