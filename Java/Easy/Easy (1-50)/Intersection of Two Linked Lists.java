/*
# Intersection of Two Linked Lists

Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:
```
A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.
```

Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.

- My Answer

*/
package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月21日
 */
public class IntersectionofTwoLinkedLists
{
    public static void main(String[] args)
    {
//      ListNode list1Head=new ListNode(1);
//      ListNode list1node1=new ListNode(2);
//      list1Head.next=list1node1;
//      ListNode list2Head=new ListNode(1);
//      ListNode intersection=new ListNode(3);
//      list1node1.next=intersection;
//      list2Head.next=intersection;
//      ListNode intersectionNext=new ListNode(4);
//      intersection.next=intersectionNext;
        
        ListNode node1=new ListNode(2);ListNode node2=new ListNode(3);
        node1.next=node2;
        ListNode node3=node2;
        System.out.println(getIntersectionNode(node1,node3).val);
    }
    
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set=new HashSet<ListNode>();
        while(headA!=null && headB!=null) {
            if(set.contains(headA))
                return headA;
            set.add(headA);
            headA=headA.next;
            
            if(set.contains(headB))
                return headB;
            set.add(headB);
            headB=headB.next;
        }
        
        while(headA!=null) {
            if(set.contains(headA))
                return headA;
            set.add(headA);
            headA=headA.next;
        }
        
        while(headB!=null) {
            if(set.contains(headB))
                return headB;
            set.add(headB);
            headB=headB.next;
        }
            
        return null;
    }
}

