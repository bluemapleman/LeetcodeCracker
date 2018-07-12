
/*
Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).

Example 1:
Input: [3, 2, 1]

Output: 1

Explanation: The third maximum is 1.
Example 2:
Input: [1, 2]

Output: 2

Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
Example 3:
Input: [2, 2, 3, 1]

Output: 1

Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.


*/
package easy2;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年2月6日
 */
public class ThirdMaximumNumber
{
    public static void main(String[] args)
    {
        System.out.println(Integer.MIN_VALUE);
    }
    public int thirdMax(int[] nums) {
        int[] maxThreeArr= {Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE};
        
        
        for(int i=0;i<nums.length;i++) {
            int ele=nums[i];
            
            if(ele==maxThreeArr[2] || ele==maxThreeArr[1] || ele==maxThreeArr[0])
                continue;
            if(ele>maxThreeArr[2]) {
                maxThreeArr[0]=maxThreeArr[1];
                maxThreeArr[1]=maxThreeArr[2];
                maxThreeArr[2]=ele;
            }
            else if(ele>maxThreeArr[1]) {
                maxThreeArr[0]=maxThreeArr[1];
                maxThreeArr[1]=ele;
            }
            else if(ele>maxThreeArr[0])
                maxThreeArr[0]=ele;
        }
        
        // Judge whether there are at least three different numbers in array
        boolean threeNumFlag=false;
        Set<Integer> set=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++) {
            set.add(nums[i]);
            if(set.size()>=3) {
                threeNumFlag=true;
                break;
            }
        }
        
        if(threeNumFlag)
            return maxThreeArr[0];
        else
            return maxThreeArr[2];
    }
}

