
/*
There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

For example:
2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

Note:

1.The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.

2.You may assume that there are no duplicate edges in the input prerequisites.
click to show more hints.

Hints:

1.This problem is equivalent to finding if a cycle exists in a directed graph. If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.

2.Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.

3.Topological sort could also be done via BFS.


*/
package medium1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年4月22日
 */
public class CourseSchedule
{
//  This solution from: https://leetcode.com/problems/course-schedule/discuss/58524/Java-DFS-and-BFS-solution
    //BFS
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<Integer>();
        int count=0;
        
        for(int i=0;i<numCourses;i++)
            graph[i] = new ArrayList<Integer>();
            
        for(int i=0; i<prerequisites.length;i++){
            degree[prerequisites[i][1]]++;
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        for(int i=0; i<degree.length;i++){
            if(degree[i] == 0){
                queue.add(i);
                count++;
            }
        }
        
        while(queue.size() != 0){
            int course = (int)queue.poll();
            for(int i=0; i<graph[course].size();i++){
                int pointer = (int)graph[course].get(i);
                degree[pointer]--;
                if(degree[pointer] == 0){
                    queue.add(pointer);
                    count++;
                }
            }
        }
        if(count == numCourses)
            return true;
        else    
            return false;
    }
    
    // DFS
//   public boolean canFinish(int numCourses, int[][] prerequisites) {
//         ArrayList<Integer>[] graph = new ArrayList[numCourses];
//         for(int i=0;i<numCourses;i++)
//             graph[i] = new ArrayList();
//             
//         boolean[] visited = new boolean[numCourses];
//         for(int i=0; i<prerequisites.length;i++){
//             graph[prerequisites[i][1]].add(prerequisites[i][0]);
//         }
//
//         for(int i=0; i<numCourses; i++){
//             if(!dfs(graph,visited,i))
//                 return false;
//         }
//         return true;
//     }
//
//     private boolean dfs(ArrayList[] graph, boolean[] visited, int course){
//         if(visited[course])
//             return false;
//         else
//             visited[course] = true;;
//
//         for(int i=0; i<graph[course].size();i++){
//             if(!dfs(graph,visited,(int)graph[course].get(i)))
//                 return false;
//         }
//         visited[course] = false;
//         return true;
//     }
}


