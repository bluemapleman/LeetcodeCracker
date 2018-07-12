
/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]


*/
package medium1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年4月12日
 */
public class BinaryTreeLevelOrderTraversal
{
    // Using a queue to store same nodes in the next level, and poll them out one by one inserting their value into list simultaneously.
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        ArrayDeque<TreeNode> queue=new ArrayDeque<>();
        if(root==null)  return ans;
        
        queue.add(root);
        ans.add(Arrays.asList(root.val));
        
        
        
        while(!queue.isEmpty()) {
                List<Integer> list=new ArrayList<>();
                ArrayDeque<TreeNode> tempQueue=new ArrayDeque<>();
                while(!queue.isEmpty()) {
                    TreeNode temp=queue.poll();
                    if(temp.left!=null) {
                        tempQueue.add(temp.left);
                        list.add(temp.left.val);
                    }
                    if(temp.right!=null) {
                        tempQueue.add(temp.right);
                        list.add(temp.right.val);
                    }
                }
                
                while(!tempQueue.isEmpty())
                    queue.add(tempQueue.poll());
                
                if(!list.isEmpty())
                    ans.add(list);
        }
        
        return ans;
    }
}

