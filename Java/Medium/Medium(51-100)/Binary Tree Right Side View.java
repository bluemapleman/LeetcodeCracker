
/*
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example:
Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---


*/
package medium2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年6月12日
 */
public class BinaryTreeRightSideView
{
     public List<Integer> rightSideView(TreeNode root) {
         List<Integer> ans=new ArrayList<>();
         if(root==null)
             return ans;
         
         ans.add(root.val);
         
         ArrayDeque<TreeNode> queue1=new ArrayDeque<>(),queue2=new ArrayDeque<>();;
         queue1.add(root);
         
         while(!queue1.isEmpty() || !queue2.isEmpty()){
             TreeNode rightestNode=null;
             
             if(!queue1.isEmpty()) {
                 while(!queue1.isEmpty()) {
                     TreeNode fatherNode=queue1.poll();
                     
                     if(fatherNode.right!=null) {
                         queue2.add(fatherNode.right);
                         if(rightestNode==null)
                             rightestNode=fatherNode.right;
                     }
                     
                     if(fatherNode.left!=null) {
                         queue2.add(fatherNode.left);
                         if(rightestNode==null)
                             rightestNode=fatherNode.left;
                     }
                 }
             }else{
                 while(!queue2.isEmpty()) {
                     TreeNode fatherNode=queue2.poll();
                     if(fatherNode.right!=null) {
                         queue1.add(fatherNode.right);
                         if(rightestNode==null)
                             rightestNode=fatherNode.right;
                     }
                     if(fatherNode.left!=null) {
                         queue1.add(fatherNode.left);
                         if(rightestNode==null)
                             rightestNode=fatherNode.left;
                     }
                 }
             }
             
             if(rightestNode!=null)
                 ans.add(rightestNode.val);
             
         }
         
         return ans;
     }
}


