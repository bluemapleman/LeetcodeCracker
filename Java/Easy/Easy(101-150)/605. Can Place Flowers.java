
/*
Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.

Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.

Example 1:
Input: flowerbed = [1,0,0,0,1], n = 1
Output: True
Example 2:
Input: flowerbed = [1,0,0,0,1], n = 2
Output: False
Note:
The input array won't violate no-adjacent-flowers rule.
The input array size is in the range of [1, 20000].
n is a non-negative integer which won't exceed the input array size.

*/
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
         return canPlaceFlowerinRange(flowerbed, 0, n);
    }
  
  public boolean canPlaceFlowerinRange(int[] flowerbed,int start,int n) {
    if(n==0)
      return true;
    
    if(flowerbed.length==1 && flowerbed[0]==0 && n==1)
      return true;
    
    System.out.println(flowerbed.length);
    System.out.println(flowerbed[0]==0);
    System.out.println(n==1);
    
    // find whether there exists a plot to plant a flower
    for(int j=start;j<flowerbed.length;j++) {
      if(j!=0 && j!=flowerbed.length-1) {
        if(flowerbed[j-1]==0 && flowerbed[j]==0 && flowerbed[j+1]==0)
          return canPlaceFlowerinRange(flowerbed, j+2, n-1);
      }
      else if(j==0) {
        if(flowerbed.length>1 && flowerbed[0]==0 && flowerbed[1]==0)
          return canPlaceFlowerinRange(flowerbed, 2, n-1);
      }else if(j==flowerbed.length-1) {
        if(flowerbed.length>1 && flowerbed[flowerbed.length-1]==0 && flowerbed[flowerbed.length-2]==0)
          if(n==1)
            return true;
          else
            return false;
      }
    }
    return false;
  }
}