
/*
We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number is higher or lower.

You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
-1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!
Example:
n = 10, I pick 6.

Return 6.


*/
package easy2;

import java.util.Arrays;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年2月2日
 */
public class GuessNumberHigherorLower
{
    public static int answer=2;
    
    public static void main(String[] args)
    {
        System.out.println(guessNumber(2));
    }
    
    /* The guess API is defined in the parent class GuessGame.
       @param num, your guess
       @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
          int guess(int num); */

    // A variant of binary search.
    public static int guessNumber(int n) {
            int start=1,end=n;
            int guess=(int)(start/2.0+end/2.0);
            while(start<end) {
                int guessResult=guess(guess);
                if(guessResult==1) {
                    start=guess+1;
                    guess=(int)(start/2.0+end/2.0);
                }else if(guessResult==-1) {
                    end=guess-1;
                    guess=(int)(start/2.0+end/2.0);
                }else
                    return guess;
            }
            return guess;
    }
    
    public static int guess(int num) {
            if(answer>num)
                return 1;
            else if(answer==num)
                return 0;
            else
                return -1;
    }
}

