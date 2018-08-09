
/*
Given a (singly) linked list with head node root, write a function to split the linked list into k consecutive linked list "parts".

The length of each part should be as equal as possible: no two parts should have a size differing by more than 1. This may lead to some parts being null.

The parts should be in order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal parts occurring later.

Return a List of ListNode's representing the linked list parts that are formed.

Examples 1->2->3->4, k = 5 // 5 equal parts [ [1], [2], [3], [4], null ]
Example 1:
Input: 
root = [1, 2, 3], k = 5
Output: [[1],[2],[3],[],[]]
Explanation:
The input and each element of the output are ListNodes, not arrays.
For example, the input root has root.val = 1, root.next.val = 2, \root.next.next.val = 3, and root.next.next.next = null.
The first element output[0] has output[0].val = 1, output[0].next = null.
The last element output[4] is null, but it's string representation as a ListNode is [].
Example 2:
Input: 
root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
Output: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
Explanation:
The input has been split into consecutive parts with size difference at most 1, and earlier parts are a larger size than the later parts.
Note:

The length of root will be in the range [0, 1000].
Each value of a node in the input will be an integer in the range [0, 999].
k will be an integer in the range [1, 50].
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] ans=new ListNode[k];
        int nodeNum=0;
        ListNode countNode=root;
        while(countNode!=null) {
            nodeNum++;
            countNode=countNode.next;
        }
        
        if(nodeNum<=k) {
            // splited by each ListNode, and the part that k>nodeNum would be filled with null
            int index=0;
            while(root!=null) {
                ans[index++]=root;
                // remove reference to ListNode in next group
                ListNode lastNode=root;
                root=root.next;
                lastNode.next=null;
            }
        }else {
            int splitedNum=nodeNum/k,remainNum=nodeNum%k;
            // assign one more node to each splited group of the first k order
            int groupIndex=0;
            for(;groupIndex<remainNum;groupIndex++) {
                ListNode head=root;
                for(int j=0;j<splitedNum+1;j++) {
                    // remove reference to ListNode in next group
                    if(j==splitedNum) {
                        ListNode lastNode=root;
                        root=root.next;
                        lastNode.next=null;
                    }else
                        root=root.next;
                }
                ans[groupIndex]=head;
            }
            
            // for remaining group
            for(;groupIndex<k;groupIndex++) {
                ListNode head=root;
                for(int j=0;j<splitedNum;j++) {
                    // remove reference to ListNode in next group
                    if(j==splitedNum-1) {
                        ListNode lastNode=root;
                        root=root.next;
                        lastNode.next=null;
                    }else
                        root=root.next;
                }
                ans[groupIndex]=head;
            }
        }
        
        return ans;
    }
}