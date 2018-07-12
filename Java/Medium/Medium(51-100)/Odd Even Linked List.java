
/*
Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example:
Given 1->2->3->4->5->NULL,
return 1->3->5->2->4->NULL.

Note:
- The relative order inside both the even and odd groups should remain as it was in the input. 
- The first node is considered odd, the second node even and so on ...


*/
package medium2;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年5月19日
 */
public class OddEvenLinkedList
{
    // this souliton exceeds memory limit, however, I think it's clear and simple enough
    public ListNode oddEvenList(ListNode head) {
        
        int mark=1;
        
        if(head==null || head.next==null || head.next.next==null)
            return head;
        int index=2;
        
        ListNode oddHead=head,evenHead=head.next;
        ListNode oddTemp=head,evenTemp=head.next;
        
        head=head.next;
        while(head.next!=null) {
            // the next node is an even node
            if((++index)%2==0){
                evenTemp.next=head.next;
                evenTemp=head.next;
            }
            // the next node is a odd node
            else{
                oddTemp.next=head.next;
                oddTemp=head.next;
            }
            head=head.next;
        }
        oddTemp.next=evenHead;
        
        return oddHead;
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

