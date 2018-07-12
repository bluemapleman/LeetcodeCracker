
/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]


*/
package medium2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年5月18日
 */
public class BinaryTreeZigzagLevelOrderTraversal
{
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        ArrayDeque<TreeNode> oddStack=new ArrayDeque<>(),evenStack=new ArrayDeque<>();
        if(root!=null) {
            oddStack.push(root);
            while(!oddStack.isEmpty() || !evenStack.isEmpty()) {
                List<Integer> tempList=new ArrayList<>();
                if(!oddStack.isEmpty())
                    while(!oddStack.isEmpty()) {
                        TreeNode temp=oddStack.pop();
                        if(temp.left!=null)
                            evenStack.push(temp.left);
                        if(temp.right!=null)
                            evenStack.push(temp.right);
                        tempList.add(temp.val);
                    }
                else
                    while(!evenStack.isEmpty()) {
                        TreeNode temp=evenStack.pop();
                        if(temp.right!=null)
                            oddStack.push(temp.right);
                        if(temp.left!=null)
                            oddStack.push(temp.left);
                        tempList.add(temp.val);
                    }
                
                if(!tempList.isEmpty())
                    ans.add(tempList);
            }
        }
        
        
        return ans;
    }
}

