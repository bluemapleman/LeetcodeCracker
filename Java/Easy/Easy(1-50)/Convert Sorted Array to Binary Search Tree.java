/*
# Convert Sorted Array to Binary Search Tree


Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.


Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
```
      0
     / \
   -3   9
   /   /
 -10  5
```

- My Answer

*/
package easy;

import java.util.Arrays;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月17日
 */
public class ConvertSortedArraytoBinarySearchTree
{

    public static void main(String[] args)
    {
        int[] nums={-10,-3,0,5,9};
        TreeNode root=sortedArrayToBST(nums);
        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.right.val);
        System.out.println(root.left.left.val);
        System.out.println(root.right.left.val);
    }

    // Recursive way
    public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0)
            return null;
        if(nums.length==1)
            return new TreeNode(nums[0]);
        int len=nums.length;
        
        int middle=len/2;
        
        TreeNode root=new TreeNode(nums[middle]);
        
        int[] leftNums=Arrays.copyOfRange(nums, 0, middle);
        int[] rightNums=Arrays.copyOfRange(nums, middle+1, len);
        
        root.left=sortedArrayToBST(leftNums);
        root.right=sortedArrayToBST(rightNums);
        
        return root;
    }

}

