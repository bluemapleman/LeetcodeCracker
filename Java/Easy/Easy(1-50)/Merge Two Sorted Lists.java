/*

# Merge Two Sorted Lists

Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:
```
Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
```

- My Answer

*/

package easy;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月10日
 */

/*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class MergeTwoSortedLists
{

    // O(m+n)
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) {
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode head,temp;
        if(l1.val>l2.val) {
            head=l2;
            l2=l2.next;
        }
        else {
            head=l1;
            l1=l1.next;
        }
        
        temp=head;
        while(l1!=null && l2!=null) {
            if(l1.val>l2.val) {
                temp.next=l2;
                temp=temp.next;
                l2=l2.next;
            }
            else {
                temp.next=l1;
                temp=temp.next;
                l1=l1.next;
            }
        }
        
        while(l1!=null) {
            temp.next=l1;
            l1=l1.next;
            temp=temp.next;
        }
        while(l2!=null) {
            temp.next=l2;
            l2=l2.next;
            temp=temp.next;
        }
        
        return head;
    }

}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}