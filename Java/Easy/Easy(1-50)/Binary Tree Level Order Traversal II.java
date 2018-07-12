/*
# Binary Tree Level Order Traversal II

Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
```
    3
   / \
  9  20
    /  \
   15   7
```
return its bottom-up level order traversal as:
```
[
  [15,7],
  [9,20],
  [3]
]
```

- My Answer

*/
package easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月17日
 */
public class BinaryTreeLevelOrderTraversalII
{

    public static void main(String[] args)
    {
        TreeNode root=new TreeNode(3);
        TreeNode left1=new TreeNode(9);
        root.left=left1;
        TreeNode right1=new TreeNode(20),right2=new TreeNode(15),right3=new TreeNode(7);
        root.right=right1;right1.left=right2;right1.right=right3;
        for(List<Integer> list:levelOrderBottom(root)) {
            for(Integer ele:list) {
                System.out.print(ele+",");
            }
            System.out.println();
        }
    }
    
    // Make use of Stack's feature: FILO
    
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root==null)
            return new ArrayList<List<Integer>>();
        
        ArrayDeque<List<Integer>> bigQueue=new ArrayDeque<List<Integer>>();  
        List<Integer> list=new ArrayList<Integer>();
        
        
        ArrayDeque<TreeNode> nodeQueue=new ArrayDeque<TreeNode>();
        nodeQueue.push(root);
        
        ArrayDeque<TreeNode> tempQueue=new ArrayDeque<TreeNode>();
        while(!nodeQueue.isEmpty()) {
            list=new ArrayList<Integer>();
            while(!nodeQueue.isEmpty()) {
                TreeNode node=nodeQueue.poll();
//              System.out.println(node.val);
                if(node.left!=null)
                    tempQueue.add(node.left);
                if(node.right!=null)
                    tempQueue.add(node.right);
                list.add(node.val);
            }
            
            bigQueue.push(list);
            
            while(!tempQueue.isEmpty()) {
                nodeQueue.add(tempQueue.poll());
            }
        }
        
        List<List<Integer>> bigList=new ArrayList<List<Integer>>();
        while(!bigQueue.isEmpty()){
            bigList.add(bigQueue.pop());
        }
        
        return bigList;
    }

}
