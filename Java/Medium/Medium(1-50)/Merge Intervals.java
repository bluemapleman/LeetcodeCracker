
/*
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].


*/
package medium1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年3月30日
 */
public class MergeIntervals
{
    public static List<Interval> merge(List<Interval> intervals) {
        // sort the intervals first, based on property 'start'.
        intervals.sort(new Comparator<Interval>()
        {
            @Override
            public int compare(Interval o1, Interval o2)
            {
                return o1.start-o2.start;
            }
        });
        
        List<Interval> list=new ArrayList<Interval>();
        boolean flag=true;
        while(flag) {
            flag=false;
            for(int i=0;i<intervals.size()-1;i++) {
                Interval int1=intervals.get(i),int2=intervals.get(i+1);
                if(checkOverlapping(int1, int2)) {
                    flag=true;
                    Interval newInt=new Interval(Math.min(int1.start, int2.start),Math.max(int1.end, int2.end));
                    intervals.remove(i);intervals.remove(i);
                    intervals.add(i,newInt);
                    break;
                }
            }
        }
        for(Interval temp:intervals)
            list.add(temp);
        return list;
    }
    
    public static boolean checkOverlapping(Interval interval1,Interval interval2) {
        int s1=interval1.start,e1=interval1.end,s2=interval2.start,e2=interval2.end;
        if(s1<=s2) {
            if(e1>=s2)
                return true;
        }else {
            if(e2>=s1)
                return true;
        }
        return false;
    }
    
    public static void main(String[] args)
    {
        Interval int1=new Interval(3,1),int2=new Interval(2,3),int3= new Interval(5,7);
        List<Interval> intervals=new ArrayList<Interval>();
        intervals.add(int1);intervals.add(int2);intervals.add(int3);
        merge(intervals);
    }
}



//Definition for an interval.
class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
}

