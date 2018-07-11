
/*
# Palindrome Number

Determine whether an integer is a palindrome. Do this without extra space.


Some hints:
Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

There is a more generic way of solving this problem.

- My Answer

*/

package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月9日
 */
public class PalindromeNumber
{
    public static void main(String[] args)
    {
        System.out.println(isPalindrome(123));

    }
    
    public static boolean isPalindrome(int x) {
        if(x==0)
            return true;
        if(x<0)
            return false;
        List<Integer> list=new ArrayList<Integer>();
        int reversePart=x;
        while(reversePart!=0){
            int yushu=reversePart%10;
            reversePart/=10;
            list.add(yushu);
        }
        //if reversed number starts with 0, it can't be a palindrome number
        if(list.get(0)==0)
                return false;
        
        int sum=0;
        for(int index=0;index<list.size();index++){
                if(sum>Integer.MAX_VALUE/10)
                    return false;
                sum*=10;
            sum+=list.get(index);
        }
        
        if(sum!=x)
                return false;
        
        return true;
    }

}