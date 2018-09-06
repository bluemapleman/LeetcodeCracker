
/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

Example 1:

Input: [[0,30],[5,10],[15,20]]
Output: false
Example 2:

Input: [[7,10],[2,4]]
Output: true
*/
package prime_problems;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年8月9日
 */
public class MeetingRooms
{
    public static void main(String[] args)
    {
        int[][] meetings1= {{0,30},{5,10},{15,20}},meetings2={{2,4},{7,10}};
        System.out.println(canAttendAllMeetings(meetings1));
        System.out.println(canAttendAllMeetings(meetings2));
    }
    
    // If true, it means that all meeting intervals don't intersect with each other
    // How to judge there is intersection between two intervals:
    //   interval1 (i1,i1') interval2 (i2,i2')
    //                         |          |     |               |
    //   If (i1<i2 && i2<i1')  |____|_____|___| |____|______|___|
    //   Or (i2<i1 && i1<i2')

    // time: O(n^2) space: O(1)
    public static boolean canAttendAllMeetings(int[][] meetings) {
        for(int i=0;i<meetings.length;i++) {
            int[] meeting1=meetings[i];
            int i1=meeting1[0],i1end=meeting1[1];
            for(int j=i+1;j<meetings.length;j++) {
                int[] meeting2=meetings[j];
                int i2=meeting2[0],i2end=meeting2[1];
                // has intersection
                if( (i1<i2 && i2<i1end) || (i2<i1 && i1<i2end) ) {
                    return false;
                }
            }
        }
        return true;
    }
}
