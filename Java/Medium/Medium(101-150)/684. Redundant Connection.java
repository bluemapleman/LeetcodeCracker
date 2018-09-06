
/*
In this problem, a tree is an undirected graph that is connected and has no cycles.

The given input is a graph that started as a tree with N nodes (with distinct values 1, 2, ..., N), with one additional edge added. The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.

The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] with u < v, that represents an undirected edge connecting nodes u and v.

Return an edge that can be removed so that the resulting graph is a tree of N nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array. The answer edge [u, v] should be in the same format, with u < v.

Example 1:
Input: [[1,2], [1,3], [2,3]]
Output: [2,3]
Explanation: The given undirected graph will be like this:
  1
 / \
2 - 3
Example 2:
Input: [[1,2], [2,3], [3,4], [1,4], [1,5]]
Output: [1,4]
Explanation: The given undirected graph will be like this:
5 - 1 - 2
    |   |
    4 - 3
Note:
The size of the input 2D-array will be between 3 and 1000.
Every integer represented in the 2D-array will be between 1 and N, where N is the size of the input array.

Update (2017-09-26):
We have overhauled the problem description + test cases and specified clearly the graph is an undirected graph. For the directed graph follow up please see Redundant Connection II). We apologize for any inconvenience caused.
*/

class Solution {
    // try to remove certain connection and see whether all nodes belong to the same set
    // if any node has different ancestor from other, then that means the connection is a necessary connection to make the graph a tree
    // however, for a redundant connection, removing it doens't have an influence on making the graph a tree.
    public int[] findRedundantConnection(int[][] edges) {
        // find N first
        int N=0;
        for(int i=0;i<edges.length;i++) {
            N=Math.max(N, edges[i][1]);
        }
        
        int[] parent=new int[N];
        for(int i=0;i<edges.length;i++) {
            parent[i]=i;
        }
        
        for(int i=edges.length-1;i>=0;i--) {
            if(IsTreeAfterRemovingGivenConnection(edges, edges[i],Arrays.copyOf(parent, parent.length)))
                return edges[i];
        }
        System.out.println("---------");
        return null;
    }
    
    public boolean IsTreeAfterRemovingGivenConnection(int[][] edges,int[] removedConn,int[] parent) {
        for(int i=edges.length-1;i>=0;i--) {
            int[] conn=edges[i]; 
            // union disjoint set
            if(!(conn[0]==removedConn[0] && conn[1]==removedConn[1])) {
                parent[find(conn[0]-1,parent)]=find(conn[1]-1,parent);
            }
        }
        
        // check whether is still a tree
        int root=find(0,parent);
        for(int j=1;j<parent.length;j++) {
            if(root!=find(j,parent))
                return false;
        }
        
        return true;
    }
    
    public int find(int s,int[] parent) {
        int p=parent[s];
        while(p!=parent[p]) {
            parent[p]=find(p,parent);
            p=parent[p];
        }
        return p;
    }
}