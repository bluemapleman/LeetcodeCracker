
/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

Example 1:

Input: [[0, 30],[5, 10],[15, 20]]
Output: 2
Example 2:

Input: [[7,10],[2,4]]
Output: 1
*/
package prime_problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年8月9日
 */
public class MeetingRoomsII
{   
    // DP: Every time you add a new meeting, and you've known the answer f(n-1) to questions with all previous n-1 meetings
    //     Then just see if there is interval that is no intersection with new meetings
    //        If yes, then no new room needed
    //        If no, then new room needed.
    
    
    // e.g.    |            |
    //         |  |     |   |
    //      |  |  |  |  |   |
    //    |_|__|__|__|__|___|_____|
    
    public static int numberOfRoomsRequired(List<Interval> meetings) {
        int[] ansArr=new int[meetings.size()];
        ansArr[0]=1;
        for(int i=1;i<ansArr.length;i++) {
            Interval newMeeting=meetings.get(i);
            int i1=newMeeting.s,i1end=newMeeting.e;
            boolean hasNoIntersectionIntervalFlag=false;
            for(int j=i-1;j>=0;j--) {
                Interval oldMeeting=meetings.get(j);
                int i2=oldMeeting.s,i2end=oldMeeting.e;
                if(!(i1<i2 && i1end>i2) && !(i2<i1 && i2end>i1) ) {
                    hasNoIntersectionIntervalFlag=true;
                    break;
                }
            }
            ansArr[i]=hasNoIntersectionIntervalFlag?ansArr[i-1]:ansArr[i-1]+1;
            
        }
        return ansArr[ansArr.length-1];
    }
}

class Interval{
    int s,e;
    Interval(int s, int e){
        this.s=s;
        this.e=e;
    }
}

