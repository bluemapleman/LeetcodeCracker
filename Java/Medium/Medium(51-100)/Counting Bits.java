
/*
Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example:

For num = 5 you should return [0,1,1,2,1,2].

Follow up:

- It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
- Space complexity should be O(n).
- Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.


*/
package medium2;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年5月6日
 */
public class CountingBits
{
    // dynamic programming
    // state: bit counts of n
    // transition: bit counts of n+1= bit counts of n - carry
    public static int[] countBits(int num) {
        int[] arr=new int[num+1];
        arr[0]=0;
        for(int i=1;i<=num;i++) {
            int before=arr[i-1];
            String bin=Integer.toBinaryString(i-1);
            
            boolean carry=true;
            for(int index=bin.length()-1;index>=0;index--){
                char c=bin.charAt(index);
                if(c=='1' && carry) {
                    carry=true;
                    before--;
                    if(index==0)
                        before++;
                }else if(c=='1' && !carry) {
                    before++;
                    break;
                }else if(c=='0' && carry) {
                    before++;
                    break;
                }else {
                    before++;
                    break;
                }
            }
            
            arr[i]=before;
        }
        
        return arr;
    }
}

