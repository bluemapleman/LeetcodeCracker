
/*
Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.

Note:

The number of people is less than 1,100.


Example
Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]


*/
package medium2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年5月6日
 */
public class QueueReconstructionbyHeight
{
    
    // this idea from: https://leetcode.com/problems/queue-reconstruction-by-height/discuss/89345/Easy-concept-with-PythonC++Java-Solution
//  Pick out tallest group of people and sort them in a subarray (S). Since there's no other groups of people taller than them, therefore each guy's index will be just as same as his k value.
//  For 2nd tallest group (and the rest), insert each one of them into (S) by k value. So on and so forth.
//  E.g.
//  input: [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
//  subarray after step 1: [[7,0], [7,1]]
//  subarray after step 2: [[7,0], [6,1], [7,1]]
//  ...
//
//  It's not the most concise code, but I think it well explained the concept.
    public int[][] reconstructQueue(int[][] people) {
        TreeSet<Integer> set=new TreeSet<>();
        for(int i=0;i<people.length;i++)
            set.add(people[i][0]);
        
        for(Integer height:set)
            System.out.print(height+" ");
        
        Map<Integer,List<People>> map=new HashMap<>();
        for(Integer height:set.descendingSet()) {
            List<People> temp=new ArrayList<>();
            for(int i=0;i<people.length;i++) {
                int[] p=people[i];
                int h=p[0];
                int taller=p[1];
                if(h==height) {
                    temp.add(new People(h,taller));
                }
            }
            Collections.sort(temp, new Comparator<People>()
            {
                @Override
                public int compare(People o1, People o2)
                {
                    if(o1.tallerNum>o2.tallerNum)
                        return 1;
                    else if(o1.tallerNum==o2.tallerNum)
                        return 0;
                    else
                        return -1;
                }
            });
            map.put(height,temp);
        }
        
        List<People> res=new ArrayList<>();
        for(Integer height:set.descendingSet()) {
            List<People> temp=map.get(height);
            for(People p:temp) {
                res.add(p.tallerNum,p);
            }
        }
        
        for(int i=0;i<res.size();i++) {
            People p=res.get(i);
            people[i][0]=p.height;
            people[i][1]=p.tallerNum;
        }
        
        
        
        return people;
    }
    
    
}

class People{
    int height,tallerNum;
    public People(int height,int tallerNum) {
        this.height=height;
        this.tallerNum=tallerNum;
    }
}

