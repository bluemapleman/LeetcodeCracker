
/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 

You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Example 1:
Input: root = [3,1,4,null,2], k = 1
Output: 1
Example 2:
Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3
Follow up:

What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?


*/
package medium2;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年5月13日
 */
public class KthSmallestElementinaBST
{
    // count number of nodes in each side to decide which side to explore further
    public int kthSmallest(TreeNode root, int k) {
        if(root!=null) {
            int leftCount=countNodes(root.left);
            if(k==leftCount+1) {
                // exact root node
                return root.val;
            }else if(k<=leftCount) {
                return kthSmallest(root.left, k);
            }else if(k>leftCount+1) {
                return kthSmallest(root.right, k-leftCount-1);
            }
        }
        return -1;
    }
    
    public int countNodes(TreeNode root) {
        int ans=0;
        if(root!=null) {
            ans++;
            ans+=countNodes(root.left)+countNodes(root.right);
            return ans;
        }else
            return 0;
    }
}

