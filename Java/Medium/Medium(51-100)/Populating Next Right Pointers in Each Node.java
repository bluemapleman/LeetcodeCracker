
/*
[LC116](https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/)

Given a binary tree
struct TreeLinkNode {
  TreeLinkNode *left;
  TreeLinkNode *right;
  TreeLinkNode *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

- You may only use constant extra space.
- Recursive approach is fine, implicit stack space does not count as extra space for this problem.
- You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
Example:

Given the following perfect binary tree,
     1
   /  \
  2    3
 / \  / \
4  5  6  7
After calling your function, the tree should look like:
     1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \  / \
4->5->6->7 -> NULL


*/
package medium2;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年5月28日
 */
public class PopulatingNextRightPointersinEachNode
{
    public static void connect(TreeLinkNode root) {
        if(root==null)
            return;
        else {
            if(root.left!=null && root.right!=null) {
                root.left.next=root.right;
            }
            
            if(root.next!=null) {
                if(root.right!=null && root.next.left!=null) {
                    root.right.next=root.next.left;
                }
            }
        }
        connect(root.left);
        connect(root.right);
    }
    
    public static void main(String[] args)
    {
        TreeLinkNode node1=new TreeLinkNode(1),node2=new TreeLinkNode(2),node3=new TreeLinkNode(3),node4=new TreeLinkNode(4),node5=new TreeLinkNode(5),node6=new TreeLinkNode(6),node7=new TreeLinkNode(7);
        node1.left=node2;node2.left=node4;node2.right=node5;
        node1.right=node3;node3.left=node6;node3.right=node7;
        connect(node1);
        System.out.println(node1.next);
        System.out.println(node2.next.val);
        System.out.println(node3.next);
        System.out.println(node4.next.val);
        System.out.println(node5.next.val);
        System.out.println(node6.next.val);
        System.out.println(node7.next);
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}

