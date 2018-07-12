
/*
[LC109](https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/)

Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:
Given the sorted linked list: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5


*/
package medium2;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年6月11日
 */
public class ConvertSortedListtoBinarySearchTree
{
    // find the middle node of sorted linked list, and take it as the root node of the BST.
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)
            return null;
        
        ListNode slow=head,fast=head,followSlow=head;
        
        boolean moveFlag=false;
        while(fast!=null && fast.next!=null) {
            if(moveFlag)
                followSlow=followSlow.next;
            moveFlag=true;
            slow=slow.next;
            fast=fast.next.next;
        }
        TreeNode root=new TreeNode(slow.val);
        
        if(moveFlag) {
            followSlow.next=null;
            root.left=sortedListToBST(head);
            root.right=sortedListToBST(slow.next);
        }
    
        return root;
    }
}

