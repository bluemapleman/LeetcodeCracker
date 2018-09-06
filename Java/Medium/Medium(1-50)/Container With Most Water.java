
/*
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.


*/
package medium1;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年2月11日
 */
public class ContainerWithMostWater
{
    // brute force: exceeds time limit
    // time: O(n^2)
    public int maxArea1(int[] height) {
        int maxWater=0;
        for(int i=0;i<height.length-1;i++) {
            for(int j=i+1;j<height.length;j++) {
                int capacity=(j-i)*Math.min(height[i], height[j]);
                if(capacity>maxWater)
                    maxWater=capacity;
            }
        }
        return maxWater;
    }
        
    // Still exceed time limit
    // For each line, they should try to find line that is at least as high as it and farthest from it.
    // O(n^2)
    public int maxArea2(int[] height) {
        int maxWater=0;
        for(int i=0;i<height.length;i++) {
            for(int start=0;start<i;start++) {
                if(height[start]>=height[i]) {
                    int capacity=height[i]*(i-start);
                    if(capacity>maxWater)
                        maxWater=capacity;
                    break;
                }
            }
            for(int end=height.length-1;end>i;end--) {
                if(height[end]>=height[i]) {
                    int capacity=height[i]*(end-i);
                    if(capacity>maxWater)
                        maxWater=capacity;
                    break;
                }
            }
        }
        return maxWater;
    }
        
    // Two Pointers
    // Similar idea to problem Two Sum (sorted Array)
    // Two pointers that starts respectively from the start and the end of the array would absolutely come to the answer lines position at the same time
    // As the answer line would be longer than any line that is on the path of the other answer line.
    // time: O(n)
    public int maxArea3(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right])
                    * (right - left));
            if (height[left] < height[right])
                left++;
            else
                right--;
        }

        return maxArea;
    }
    }
    
}

