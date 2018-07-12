/*
# Two Sum II - Input array is sorted

Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution and you may not use the same element twice.
```
Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
```

- My Answer

*/
package easy;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月23日
 */
public class TwoSumII
{
    public static void main(String[] args)
    {
        int[] numbers= {2,7,11,15};
        int target=9;
        int[] two=twoSum(numbers, target);
        System.out.println(two[0]);
        System.out.println(two[1]);
    }
    
    public static int[] twoSum(int[] numbers, int target) {
        int[] two=new int[2];
        for(int i=0;i<numbers.length;i++) {
                int first=numbers[i];
                for(int j=i+1;j<numbers.length;j++) {
                    int second=numbers[j];
                    if(first+second==target) {
                        two[0]=i+1;
                        two[1]=j+1;
                        return two;
                    }
                }
        }
        return two;
    }
}
