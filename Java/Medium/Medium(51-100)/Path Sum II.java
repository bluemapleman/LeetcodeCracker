
/*
[LC113](https://leetcode.com/problems/path-sum-ii/description/)

Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,
      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:
[
   [5,4,11,2],
   [5,8,4,5]
]


*/
package medium2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年6月7日
 */
public class PathSumII
{
    // DFS: make use of recursion to backtrack
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        if(root==null)
            return ans;
        
        int goal=sum-root.val;
        if(goal==0) {
            if(root.left==null && root.right==null) {
                List<Integer> tempList=new ArrayList<>();
                tempList.add(root.val);
                ans.add(tempList);
                return ans;
            }
        }
            
        List<List<Integer>> temp;
        if((temp=pathSum(root.left, goal)).size()!=0) {
            for(List<Integer> list:temp) {
                list.add(0, root.val);
                ans.add(list);
            }
        }
        
        if((temp=pathSum(root.right, goal)).size()!=0) {
            for(List<Integer> list:temp) {
                list.add(0,root.val);
                ans.add(list);
            }
        }
        
        return ans;
    }
    
    
}



