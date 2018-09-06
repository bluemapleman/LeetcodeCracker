
/*
Given a linked list, remove the nth node from the end of list and return its head.

For example,
   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.


*/
package medium1;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年2月14日
 */
public class RemoveNthNodeFromEndofList
{
    // Let a node be forward node, and assign a follow node to keep n node distance from forward node
    // Then when forward node get to the tail, the node next to the follow node is the node to be remove
    // One-pass: time O(n)
    // space: O(1)
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode forward=head,follow=head;
        int i=1;
        while(i++<=n) {
            forward=forward.next;
        }
        // edge case:if removeNode is the head node, then special treat
        if(forward==null) {
            head=head.next;
        }else {
            while(forward.next!=null) {
                forward=forward.next;
                follow=follow.next;
            }
            follow.next=follow.next.next;
        }
            
        return head;
    }
}

