
/*
Sort a linked list in O(n log n) time using constant space complexity.


*/
package medium1;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年4月20日
 */


public class SortList
{
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        
        // Learn a clever way to find the half point of a linked list.
        ListNode slow=head,fast=head,middle=null;
        
        while(fast!=null && fast.next!=null) {
            fast=fast.next.next;
            slow=slow.next;
        }
        
        middle=slow.next;
        // only two nodes in the list
        if(middle==null) {
            middle=slow;
            head.next=null;
        }else {
            slow.next=null;
        }
        
        ListNode l1=sortList(head),l2=sortList(middle);
        
        head=merge(l1, l2);

        return head;
    }
    
    public ListNode merge(ListNode l1,ListNode l2) {
        if(l1==l2)
            return l1;
        
        ListNode head=null,pointer=null;
        
        while(l1!=null && l2!=null) {
            if(head==null) {
                if(l1.val<l2.val) {
                    head=l1;
                    pointer=l1;
                    l1=l1.next;
                }
                else {
                    head=l2;
                    pointer=l2;
                    l2=l2.next;
                }
            }else {
                if(l1.val<l2.val) {
                    pointer.next=l1;
                    l1=l1.next;
                    pointer=pointer.next;
                }
                else {
                    pointer.next=l2;
                    l2=l2.next;
                    pointer=pointer.next;
                }
            }
        }
        
        while(l1!=null) {
            pointer.next=l1;
            pointer=pointer.next;
            l1=l1.next;
        }
        
        while(l2!=null) {
            pointer.next=l2;
            pointer=pointer.next;
            l2=l2.next;
        }
        
        // important, or linked list may be a mess
        pointer.next=null;
        
        return head;
    }
}

