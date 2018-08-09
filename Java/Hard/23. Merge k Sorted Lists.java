/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
		 		return null;
		 	if(lists.length==1)
		 		return lists[0];
		 	
		 	
		 	// find head of merged list first
		 	ListNode headAns=null,tempNode=null;
		 	int min=Integer.MAX_VALUE;
		 	// find min value among all head node
		 	for(int i=0;i<lists.length;i++)
	 			if(lists[i]!=null && lists[i].val<=min)
	 				min=lists[i].val;
		 	
		 	for(int i=0;i<lists.length;i++) {
		 		if(lists[i]!=null && lists[i].val==min) {
		 			if(headAns==null)
		 				headAns=lists[i];
		 			
		 			if(tempNode==null)
		 				tempNode=lists[i];
		 			else {
		 				tempNode.next=lists[i];
		 				tempNode=tempNode.next;
		 			}
		 			
	 				lists[i]=lists[i].next;
	 			}
		 	}
		 	
		 	boolean hasNodeFlag=true;
		 	while(hasNodeFlag) {
		 		min=Integer.MAX_VALUE;
		 		hasNodeFlag=false;
		 		for(int i=0;i<lists.length;i++) {
		 			if(lists[i]!=null && lists[i].val<=min) {
		 				hasNodeFlag=true;
		 				min=lists[i].val;
		 			}
		 		}
		 		
		 		for(int i=0;i<lists.length;i++) {
			 		if(lists[i]!=null && lists[i].val==min) {
			 			tempNode.next=lists[i];
		 				lists[i]=lists[i].next;
		 				tempNode=tempNode.next;
		 			}
			 	}
		 	}
		 	
	        return headAns;
    }
}
     
