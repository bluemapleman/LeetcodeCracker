/*
# Remove Linked List Elements

Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5

- My Answer
*/
package easy1;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月25日
 */
public class RemoveLinkedListElements
{
    public static void main(String[] args)
    {
        ListNode head=new ListNode(1);
        ListNode node1=new ListNode(2),node2=new ListNode(6),node3=new ListNode(4),node4=new ListNode(6);
        head.next=node1;node1.next=node2;node2.next=node3;node3.next=node4;
        ListNode node=removeElements(head, 6);
        while(node!=null) {
            System.out.print(node.val+" ");
            node=node.next;
        }
    }
    
    public static ListNode removeElements(ListNode head, int val) {
        if(head==null)
            return head;
        ListNode stayHead=head;
        ListNode lastNode=null;
        while(head!=null) {
            if(head.val==val) {
                //If head node's value is equal to val, then directly assign head to next node
                if(lastNode==null) {
                    head=head.next;
                    stayHead=head;
                }else {
                    lastNode.next=head.next;
                    head.next=null;
                    head=lastNode.next;
                }
            }else {
                lastNode=head;
                head=head.next;
            }
        }
        return stayHead;
    }
}
