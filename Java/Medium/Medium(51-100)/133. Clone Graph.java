
/*
IClone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
*/

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    // BFS
    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null)
            return null;
        
        UndirectedGraphNode ans=node;
        ArrayDeque<UndirectedGraphNode> openQueue=new ArrayDeque<>();
        // old node : clone node
        Map<UndirectedGraphNode,UndirectedGraphNode> closedMap=new HashMap<>();
        openQueue.add(node);
        
        while(!openQueue.isEmpty()) {
            UndirectedGraphNode current=openQueue.poll();
            // add current to closed set to avoid repeated accessing
            System.out.println("--------------------");
            System.out.print("currnet:"+current.label);
            System.out.println();
            
            System.out.println(closedMap.containsKey(current));
            if(!closedMap.containsKey(current)) {
                ans=new UndirectedGraphNode(current.label);
                closedMap.put(current,ans);
            }
            else {
                ans=closedMap.get(current);
            }

            List<UndirectedGraphNode> neighbors=new ArrayList<>();
            
            for(UndirectedGraphNode otherNode:current.neighbors) {
                if(closedMap.containsKey(otherNode)) {
                    neighbors.add(closedMap.get(otherNode));
                }else {
                    UndirectedGraphNode tempNode=new UndirectedGraphNode(otherNode.label);
                    neighbors.add(tempNode);
                    closedMap.put(otherNode,tempNode);
                    openQueue.add(otherNode);
                }
                
                
            };
            ans.neighbors=neighbors;
        }
        
        return closedMap.get(node);
    }
    
    
    // old node : clone node
    static Map<UndirectedGraphNode, UndirectedGraphNode> map=new HashMap<>();
            
    //DFS
    public static UndirectedGraphNode clone(UndirectedGraphNode node) {
        if(node==null)
            return null;
        
        UndirectedGraphNode copyNode=new UndirectedGraphNode(node.label);
        map.put(node, copyNode);
        
        List<UndirectedGraphNode> copyNeighbors=new ArrayList<>();
        
        List<UndirectedGraphNode> neighbors=node.neighbors;
        for(int i=0;i<neighbors.size();i++) {
            UndirectedGraphNode otherNode=neighbors.get(i);
            if(map.containsKey(otherNode))
                copyNeighbors.add(map.get(otherNode));
            else {
                copyNeighbors.add(clone(otherNode));
            }
        }   
        
        copyNode.neighbors=copyNeighbors;
        
        return copyNode;
    }
}
