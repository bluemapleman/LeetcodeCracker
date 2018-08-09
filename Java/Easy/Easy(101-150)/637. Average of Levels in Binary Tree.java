
/*
Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
Example 1:
Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
Note:
The range of node's value is in the range of 32-bit signed integer.
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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans=new ArrayList<>();
    if(root==null)
      return ans;
    
    List<List<TreeNode>> levelList=new ArrayList<>();
    
    ArrayDeque<TreeNode> queue1=new ArrayDeque<>(),queue2=new ArrayDeque<>();
    queue1.add(root);
    
     
    while(!queue1.isEmpty() | !queue2.isEmpty()) {
      List<TreeNode> tempLevelList=new ArrayList<>();
      while(!queue1.isEmpty()) {
        TreeNode node=queue1.poll();
        tempLevelList.add(node);
        if(node.left!=null)
          queue2.add(node.left);
        if(node.right!=null)
          queue2.add(node.right);
      }
      
      if(!tempLevelList.isEmpty()) {
        levelList.add(tempLevelList);
        tempLevelList=new ArrayList<>();
      }
      
      while(!queue2.isEmpty()) {
        TreeNode node=queue2.poll();
        tempLevelList.add(node);
        if(node.left!=null)
          queue1.add(node.left);
        if(node.right!=null)
          queue1.add(node.right);
      }
      
      if(!tempLevelList.isEmpty()) {
        levelList.add(tempLevelList);
      }
      
    }
    
    double avg=0;
    for(List<TreeNode> nodeList:levelList) {
      avg=0;
      for(TreeNode node:nodeList) {
        avg+=node.val;
      }
      avg/=nodeList.size();
      ans.add(avg);
    }
        return ans;
    }
}