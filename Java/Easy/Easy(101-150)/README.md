[toc]

# Convert BST to Greater Tree

[LC538](https://leetcode.com/problems/convert-bst-to-greater-tree/description/)

Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.

Example:
```
Input: The root of a Binary Search Tree like this:
              5
            /   \
           2     13

Output: The root of a Greater Tree like this:
             18
            /   \
          20     13
```

- My Answer
```
package easy3;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年6月13日
 */
public class ConvertBSTtoGreaterTree
{
    // Typical way to solve tree problem!
    // Consider how you would deal with a father node with its left sub tree and right sub tree:
    //  1. First, we hope left sub tree to be a tree that has been 'done well'.
    //  2. Then, we would add root.val+getSumOfTreeNode(root.right) to each node in left sub tree.
    //  3. Then, we deal with right sub tree to have it done well too.
    public TreeNode convertBST(TreeNode root) {
        if(root!=null) {
            convertBST(root.left);
            
            int rightSum=getSumOfTreeNode(root.right);
            int addSum=root.val+rightSum;
            
            addValueToEveryTreeNode(root.left, addSum);
            root.val+=rightSum;
            
            convertBST(root.right);
            
        }
        
        return root;
    }
    
    public void addValueToEveryTreeNode(TreeNode root,int value) {
        if(root!=null) {
            root.val+=value;
            addValueToEveryTreeNode(root.left, value);
            addValueToEveryTreeNode(root.right, value);
        }
    }
    
    public int getSumOfTreeNode(TreeNode root) {
        int sum=0;
        if(root!=null) {
            sum+=root.val;
            sum+=getSumOfTreeNode(root.left);
            sum+=getSumOfTreeNode(root.right);
        }
        return sum;
    }
}


class TreeNode{
    int val;
    TreeNode left,right;
    public TreeNode(int val)
    {
        this.val=val;
    }
}
```


# Diameter of Binary Tree

[LC543](https://leetcode.com/problems/diameter-of-binary-tree/description/)

Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
```
Given a binary tree 
          1
         / \
        2   3
       / \     
      4   5    
```
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.

- My Answer
```
package easy3;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年6月13日
 */
public class DiameterofBinaryTree
{
    public int diameterOfBinaryTree(TreeNode root) {
        int ans=0;
        if(root!=null) {
            ans=Math.max(ans, getMaximumDepthSumOfTreeNode(root));
            ans=Math.max(ans, diameterOfBinaryTree(root.left));
            ans=Math.max(ans, diameterOfBinaryTree(root.right));
        }
        
        return ans;
    }
    
    public int getMaximumDepthSumOfTreeNode(TreeNode root) {
        if(root!=null) {
            // add the maximum depth of left sub tree to that of right sub tree
            int leftMaxDepth=getMaximumDepth(root.left),rightMaxDepth=getMaximumDepth(root.right);
            
            return leftMaxDepth+rightMaxDepth;
        }else
            return 0;
    }
    
    public int getMaximumDepth(TreeNode root) {
        if(root==null)
            return 0;
        
        int maxDepth=Math.max(getMaximumDepth(root.left), getMaximumDepth(root.right));
        
        return 1+maxDepth;
    }
}
```

# Subtree of Another Tree

[LC572](https://leetcode.com/problems/subtree-of-another-tree/description/)

Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

Example 1:
Given tree s:
```
     3
    / \
   4   5
  / \
 1   2
```
Given tree t:
```
   4 
  / \
 1   2
```
Return true, because t has the same structure and node values with a subtree of s.

Example 2:

Given tree s:
```
     3
    / \
   4   5
  / \
 1   2
    /
   0
```
Given tree t:
```
   4
  / \
 1   2
```
Return false.

- My Answer
```
package easy3;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年6月13日
 */
public class SubtreeofAnotherTree
{
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null && t==null)
            return true;
        else if(t==null)
            return false;
        
        if(s!=null) {
            if(s.val==t.val) {
                if(sameTree(s,t))
                    return true;
            }
            
            return isSubtree(s.left, t) || isSubtree(s.right, t);
            
        }
        
        return false;
    }
    
    public boolean sameTree(TreeNode t1,TreeNode t2) {
        if(t1==null && t2==null)
            return true;
        else if(t1==null || t2==null)
            return false;
        else {
            if(t1.val==t2.val) {
                return sameTree(t1.left, t2.left) && sameTree(t1.right, t2.right);
            }else
                return false;
        }
    }
}
```

# Merge Two Binary Trees

[LC617](https://leetcode.com/problems/merge-two-binary-trees/description/)

Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.

You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.

Example 1:
```
Input: 
    Tree 1                     Tree 2                  
          1                         2                             
         / \                       / \                            
        3   2                     1   3                        
       /                           \   \                      
      5                             4   7                  
Output: 
Merged tree:
         3
        / \
       4   5
      / \   \ 
     5   4   7
```
Note: The merging process must start from the root nodes of both trees.

- My Answer
```
package easy3;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年6月13日
 */
public class MergeTwoBinaryTrees
{
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode root=null;
        
        if(t1!=null && t2!=null) {
            root=new TreeNode(t1.val+t2.val);
            root.left=mergeTrees(t1.left, t2.left);
            root.right=mergeTrees(t1.right, t2.right);
        }else if(t1==null && t2!=null) {
            root=new TreeNode(t2.val);
            root.left=t2.left;
            root.right=t2.right;
        }else if(t1!=null && t2==null) {
            root=new TreeNode(t1.val);
            root.left=t1.left;
            root.right=t1.right;
        }
        
        return root;
    }
}
```

# Shortest Unsorted Continuous Subarray

[LC581](https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/)

Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.

Example 1:
```
Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
```
Note:

1.Then length of the input array is in range [1, 10,000].

2.The input array may contain duplicates, so ascending order here means <=.

- My Answer
```
package easy3;

import java.util.Arrays;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年6月13日
 */
public class ShortestUnsortedContinuousSubarray
{
    public static int findUnsortedSubarray(int[] nums) {
        if(nums.length==0 || nums.length==1)
            return 0;
        
        int[] copyNums=Arrays.copyOf(nums,nums.length);
        Arrays.sort(copyNums);
        
        
        
        int start=0,end=nums.length-1;
        boolean startFlag=false,endFlag=false;
        for(int i=0;i<nums.length;i++) {
             if(nums[i]!=copyNums[i]) {
                 startFlag=true;
                 start=i;
                 break;
             }
        }
        for(int i=nums.length-1;i>=0;i--) {
            if(nums[i]!=copyNums[i]) {
                 endFlag=true;
                 end=i;
                 break;
             }
        }
        
        // The array is already sorted
        if(!startFlag && !endFlag)
            return 0;
        else
            return end-start+1;
    }
    
    public static void main(String[] args)
    {
        System.out.println(findUnsortedSubarray(new int[] {1,2,3,4}));
    }
}
```

# 
