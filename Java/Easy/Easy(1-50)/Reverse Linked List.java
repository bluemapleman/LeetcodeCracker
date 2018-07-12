/*
# Reverse Linked List

Reverse a singly linked list.

Hint:
A linked list can be reversed either iteratively or recursively. Could you implement both?

- My Answer
*/
package easy1;

import java.util.ArrayDeque;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月25日
 */
public class ReverseLinkedList
{
    public static void main(String[] args)
    {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        node1.next=node2;
        node2.next=node3;
        ListNode head=reverseList(node1);
        while(head!=null) {
            System.out.print(head.val+" ");
            head=head.next;
        }
    }
    
    public static ListNode reverseList(ListNode head) {
        if(head==null)
            return head;
        
        ArrayDeque<ListNode> stack=new ArrayDeque<ListNode>();
        while(head!=null) {
            stack.push(head);
            head=head.next;
        }
        
        ListNode lastNode=stack.pop();
        ListNode reverseHead=lastNode;
        while(!stack.isEmpty()) {
            ListNode node=stack.pop();
            lastNode.next=node;
            node.next=null;
            lastNode=node;
        }
        return reverseHead;
    }
}
