
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
    // Then when forward node get to the tail, the node next to the follow node is the node to be removed
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode forwardNode=head,followNode=head;
        
        int count=0;
        //1 2 3 4 5
        while(forwardNode.next!=null) {
            if(++count>n) {
                followNode=followNode.next;
            }
                
            forwardNode=forwardNode.next;
        }
        
        // if removeNode is the head node, then special treat
        if(n>count) {
            head=head.next;
        }
        else {
            ListNode removeNode=followNode.next;
            followNode.next=removeNode.next;
            removeNode.next=null;
        }
        
        return head;
    }
}

