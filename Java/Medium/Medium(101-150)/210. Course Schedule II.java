
/*
There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

Example 1:

Input: 2, [[1,0]] 
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished   
             course 0. So the correct course order is [0,1] .
Example 2:

Input: 4, [[1,0],[2,0],[3,1],[3,2]]
Output: [0,1,2,3] or [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both     
             courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. 
             So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
Note:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
*/

class Solution {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<DirectedGraphNode> nodeList=new ArrayList<>();
        for(int i=0;i<numCourses;i++) 
            nodeList.add(new DirectedGraphNode(i));
        // construct graph
        for(int i=0;i<prerequisites.length;i++) {
            int course=prerequisites[i][0],prere=prerequisites[i][1];
            nodeList.get(course).prerequisites.add(nodeList.get(prere));
            nodeList.get(prere).pointTo.add(nodeList.get(course));
        }
        
        // BFS from all course that has no prerequisite to find possible order to finish all courses
        Set<DirectedGraphNode> closed=new LinkedHashSet<>();
        int temp=0;
        while(closed.size()<numCourses) {
            for(DirectedGraphNode course:nodeList) {
                if(course.prerequisites.isEmpty() && !closed.contains(course)) {
                    closed.add(course);
                    // remove current course from prerequisite list of the required course
                    for(DirectedGraphNode tempNode:course.pointTo) {
                        tempNode.prerequisites.remove(course);
                    }
                }
            }
            
            if(temp==closed.size())
                return new int[] {};
            
            temp=closed.size();
        }
        
        int ans[]=new int[numCourses];
        Iterator<DirectedGraphNode> ite=closed.iterator();
        for(int i=0;i<ans.length;i++)
            ans[i]=ite.next().course;
        
        return ans;
    }
    
    
}

class DirectedGraphNode{
    int course;
    List<DirectedGraphNode> pointTo;
    List<DirectedGraphNode> prerequisites;
    
    public DirectedGraphNode(int course)
    {
        this.course=course;
        this.prerequisites=new ArrayList<>();
        pointTo=new ArrayList<>();
    }
}