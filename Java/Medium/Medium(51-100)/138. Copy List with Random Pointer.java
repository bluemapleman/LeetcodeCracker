
/*
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.

*/
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null)
            return head;
        
        RandomListNode copyHead=new RandomListNode(head.label);
        // stay head, as its name suggests, would always points to the head of the list
        RandomListNode randomCopyHead=copyHead,stayRandomCopyHead=copyHead,randomHead=head,stayRandomHead=head;
        // first finish copying the normal list
        while(head.next!=null) {
            copyHead.next=new RandomListNode(head.next.label);
            head=head.next;
            copyHead=copyHead.next;
        }
        // then finish assigning 'random' attribute for each node
        while(randomHead!=null) {
            RandomListNode goalNode=randomHead.random;
            // search for the node's index in given list
            int index=0;
            RandomListNode tempGoalNode=stayRandomHead;
            while(tempGoalNode!=goalNode) {
                index++;
                tempGoalNode=tempGoalNode.next;
            }
            
            // find corresponding node in new list, and assign 'random'
            RandomListNode tempCopyGoalNode=stayRandomCopyHead;
            for(int i=0;i<index;i++) {
                tempCopyGoalNode=tempCopyGoalNode.next;
            }
            
            randomCopyHead.random=tempCopyGoalNode;
            
            randomHead=randomHead.next;
            randomCopyHead=randomCopyHead.next;
        }
        
        
        
        return stayRandomCopyHead;
    }
}