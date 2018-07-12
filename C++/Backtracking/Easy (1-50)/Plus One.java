/*
# Plus One

Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.

- My Answer

*/
package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月12日
 */
public class PlusOne
{
    static int index=0;

    public static void main(String[] args)
    {
        int[] digits= {9,9,9,9,9,9,9,9,9,9,9,9,9};
        int nums[]=plusOne(digits);
        for(int i=0;i<nums.length;i++) {
            System.out.print(nums[i]+" ");
        }

    }
    
    public static int[] plusOne(int[] digits) {
        int len=digits.length;
        int count=0;
        for(int i=0;i<digits.length;i++) {
            if(digits[len-i-1]+1==10) {
                count++;
            }
            else
                break;
        }
        int nums[];
        if(count==len) {
            nums=new int[count+1];
            nums[0]=1;
            for(int i=1;i<nums.length;i++)
                nums[i]=0;
        }else{
            nums=new int[len];
            for(int i=0;i<nums.length;i++) {
                if(i<count)
                    nums[len-i-1]=0;
                else {
                    nums[len-i-1]=digits[len-i-1];
                    if(i==0 || i==count)
                        nums[len-i-1]+=1;
                }
            }
        }
        
        return nums;
    }
    
    //  This answer doesn't work when input is greater than Integer.MAX_VALUE;
//  public static int[] plusOne(int[] digits) {
//      int count=1;
//      int sum=digits[0];
//      for(int i=1;i<digits.length;i++) {
//          sum*=10;
//          sum+=digits[i];
//      }
//      sum+=1;
//      List<Integer> list=new ArrayList<Integer>();
//      while(sum/10!=0) {
//          int yushu=sum%10;
//          list.add(yushu);
//          sum/=10;
//      }
//      list.add(sum);
//      int nums[]=new int[list.size()];
//      for(int i=0;i<nums.length;i++)
//          nums[i]=list.get(nums.length-i-1);
//        return nums;
//    }

}

