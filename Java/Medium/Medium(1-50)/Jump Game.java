
/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.


*/
package medium1;

import java.util.Arrays;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年3月30日
 */
public class JumpGame
{
    
    // DP Thought
    // inversely search for the answer
//  [1,2,4,0,0,0,2,1,2,1,1,1,1,2,2,0]
//  false false true false false false true true true true true true true true true true
    public boolean canJump(int[] nums) {
        int finalIndex=nums.length-1;
        
        // can't jump at the beginning
        if(nums[0]==0 && finalIndex!=0)
            return false;
        
        boolean[] canJumpArr=new boolean[nums.length];
        for(int index=finalIndex;index>=0;index--) {
            System.out.println("index:"+index);
            if(index==finalIndex) {
                canJumpArr[index]=true;
                continue;
            }
            int maxStep=nums[index];
            if(finalIndex-index<=maxStep)
                canJumpArr[index]=true;
            else {
                // simplify some duplicated search actions
                if(index!=finalIndex) {
                    int nextMaxStep=nums[index+1];
                    if(canJumpArr[index+1]==false) {
                        if(maxStep<=nextMaxStep) {
                            canJumpArr[index]=false;
                        }
                        else {
                            int delta=maxStep-nextMaxStep;
                            for(int i=index+nextMaxStep+1;delta-->0 && i<nums.length;i++) {
                                if(canJumpArr[i]==true) {
                                    canJumpArr[index]=true;
                                    break;
                                }
                            }
                        }
                    }
                    else {
                        if(maxStep>0)
                            canJumpArr[index]=true;
                    }
                }
            }
        }
        
        return canJumpArr[0];
    }
    
    public static void main(String[] args)
    {
        boolean[] test=new boolean[3];
        System.out.println(test[0]+","+test[1]+","+test[2]);
    }
    
    // assume no backward jump, since backward jump is meaningless.
    // This answer exceeds time limit: too many duplicated recursion, use DP instead!
//  public boolean canJump(int[] nums) {
//      int finalIndex=nums.length-1;
//      
//      // can't jump at the beginning
//      if(nums[0]==0 && finalIndex!=0)
//          return false;
//      
//      int index=0;
//      
//      if(index!=finalIndex) {
//          int maxStep=nums[index];
//          // can't jump anymore before getting to the destination
//          if(maxStep==0)
//              return false;
//          // can get to the final index
//          if(finalIndex-index<=maxStep)
//              return true;
//          else {
//              boolean flag=false;
//              for(int i=1;i<=maxStep;i++) {
//                  flag=flag||canJump(Arrays.copyOfRange(nums,index+i, nums.length));
//              }
//              return flag;
//          }
//      }
//      return true;
//    }
}

