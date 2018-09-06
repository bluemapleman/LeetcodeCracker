/*
Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6
Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
	// transform original complicated problem to simple problem
	// solve simple problem, then solution can be used to solve complicated problem easily.
	// binary tree's problem is really interesting
    public int maxPathSum(TreeNode root) {
        if(root==null)
			return 0;
		
		int ans=maxPathSumPassingRoot(root);
		
		if(root.left!=null) {
			ans=Math.max(ans, maxPathSum(root.left));
		}
		if(root.right!=null) {
			ans=Math.max(ans, maxPathSum(root.right));
		}
		
		return ans;
    }
	
	private static int maxPathSumPassingRoot(TreeNode root) {
		if(root==null)
			return 0;
		
		int ans=root.val;
		
		int left=maxPathStartingFromRoot(root.left),right=maxPathStartingFromRoot(root.right);
		if(left>0) {
			ans+=left;
		}
		
		if(right>0) {
			ans+=right;
		}
		
        return ans;
	}
	
	// get the maximum of sum of the path that starts from the given root
	private static int maxPathStartingFromRoot(TreeNode root) {
		int ans=0;
		if(root==null)
			return ans;
		
		ans+=root.val;
		if(root.left!=null && root.right!=null) {
			int temp=Math.max(maxPathStartingFromRoot(root.left), maxPathStartingFromRoot(root.right));
			temp=Math.max(temp, 0);
			if(temp>0)
				ans+=temp;
		}else if(root.left!=null) {
			int temp=maxPathStartingFromRoot(root.left);
			if(temp>0)
				ans+=temp;
		}else if(root.right!=null) {
			int temp=maxPathStartingFromRoot(root.right);
			if(temp>0)
				ans+=temp;
		}
		
		return ans;
	}
}