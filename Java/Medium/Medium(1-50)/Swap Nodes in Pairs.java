
/*
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.
Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.


*/
package medium1;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年2月14日
 */
public class SwapNodesinPairs
{
    
    public ListNode swapPairs(ListNode head) {
        //[1,2,3,4]
        //[2,1,3]
        if(head==null || head.next==null)
            return head;
        ListNode left=head,right=head.next;
        head=right;
        while(right!=null) {
            left.next=right.next;
            right.next=left;
            right=left.next;
            System.out.println("left:"+left.val+",right:"+right.val);
            if(right!=null) {
                if(right.next==null) {
                    break;
                }else {
                    left.next=right.next;
                    left=right;
                    right=right.next;
                }
            }
            else
                break;
        }
        return head;
    }
}

