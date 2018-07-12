
/*
You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first turn to remove the stones.

Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap.

For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 stones you remove, the last stone will always be removed by your friend.


*/
package easy2;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月31日
 */
public class NimGame
{
    // Just list out some examples, we can soon find that only when n is a multiple of 4, then we will fail the game. 
    // 1t 2t 3t 4f 5t 6t 7t 8f 9t 10t 11t 12f
    public boolean canWinNim(int n) {
        if(n%4==0 && n/4>=1)
            return false;
        
        else return true;
    }
}

