
/*
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.
   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3


*/
package medium1;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年4月11日
 */
public class UniqueBinarySearchTrees
{
    // this answer from:https://leetcode.com/problems/unique-binary-search-trees/discuss/31666/DP-Solution-in-6-lines-with-explanation.-F(i-n)-G(i-1)-*-G(n-i)
    // thought: all nodes can be root, so we can sum up all cases by assigning each node to be root.
    // using Dynamic Programming.
    public int numTrees(int n) {
        int numTrees[]=new int[n+1];
        numTrees[0]=1;numTrees[1]=1;
        for(int i=2;i<=n;i++) {
            for(int j=1;j<=i;j++) {
                numTrees[i]+=numTrees[j-1]*numTrees[i-j];
            }
        }
        return numTrees[n];
    }
}

