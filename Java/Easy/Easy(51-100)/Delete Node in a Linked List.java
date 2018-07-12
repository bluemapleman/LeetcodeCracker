
/*
Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.

- My  Answer

package easy2;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月28日
 */
public class DeleteNodeinaLinkedList
{
    public static void main(String[] args)
    {
        ListNode node1=new ListNode(1),node2=new ListNode(2),node3=new ListNode(3),node4=new ListNode(4);
        node1.next=node2;node2.next=node3;node3.next=node4;
        deleteNode(node3);
        deleteNode(node2);
        while(node1!=null) {
            System.out.println(node1.val+" ");
            node1=node1.next;
        }
    }
    
    // It's easy to misunderstand the meaning of "deleting the node" here. However, if given only the node to be deleted, we can only change its value and remove later node. 
     public static void deleteNode(ListNode node) {
         node.val=node.next.val;
         node.next=node.next.next;      
     }
}



