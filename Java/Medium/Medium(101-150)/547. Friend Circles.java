
/*
There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature. For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C. And we defined a friend circle is a group of students who are direct or indirect friends.

Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not. And you have to output the total number of friend circles among all the students.

Example 1:
Input: 
[[1,1,0],
 [1,1,0],
 [0,0,1]]
Output: 2
Explanation:The 0th and 1st students are direct friends, so they are in a friend circle. 
The 2nd student himself is in a friend circle. So return 2.
Example 2:
Input: 
[[1,1,0],
 [1,1,1],
 [0,1,1]]
Output: 1
Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends, 
so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.
Note:
N is in range [1,200].
M[i][i] = 1 for all students.
If M[i][j] = 1, then M[j][i] = 1.
*/

class Solution {
    // union find
    public int findCircleNum(int[][] M) {
        if(M.length==0)
            return 0;

        //makeSet
        int[] parent=new int[M.length];
        for(int i=0;i<parent.length;i++)
            parent[i]=i;

        for(int i=0;i<M.length;i++){
            for(int j=0;j<i;j++){
                // direct friend, then union
                // remember: union is to union two set's root element, i.e. set one root's parent as another root.
                if(M[i][j]==1){
                    parent[find(i,parent)]=parent[find(j,parent)];
                }
            }
        }

        Set<Integer> rootSet=new HashSet<Integer>();
        for(int i=0;i<parent.length;i++){
            int root=find(i,parent);
            if(!rootSet.contains(root))
                rootSet.add(root);
        }


        return rootSet.size();
    }

    public int find(int e,int[] parent){
        while(e!=parent[e]){
            // path compression: when find the root recursively, always set current element's parent to the root.
            // to avoid searching chain becoming too long
            parent[e]=find(parent[e],parent);
            e=parent[e];
        }
        return e;
    }
}