# Longest Increasing Subsequence

Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,

Given [10, 9, 2, 5, 3, 7, 101, 18],The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?

- My Answer
```
package medium2;

import java.util.Arrays;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年5月5日
 */
public class LongestIncreasingSubsequence
{
    // This answer from:https://leetcode.com/problems/longest-increasing-subsequence/discuss/127926/java
    public int lengthOfLIS(int[] nums) {
        if(nums.length <= 1)
            return nums.length;
        
        //新建一个数组T，用来标识nums元素前面有多少个连续小于他的，从1开始加
        //比如nums=[10,15,20,11,9,101] 
        //15前面10比他小，所以为2,20前面有10和15都比他小，所以为3，最后101前面有10,15,20这三个比他小，所以为4
        //那么T=[1,2,3,2,1,4]
        int[] T = new int[nums.length];
        Arrays.fill(T,1);
        
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[j] < nums[i]){
                    T[i] = Math.max(T[i],1+T[j]);
                }
            }
        }
        
        int res = 0;
        for(int i=0;i<T.length;i++){
            res = Math.max(res,T[i]);
        }
        return res;
    }
}
```

# Coin Change

You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
```
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)
```

Example 2:
```
coins = [2], amount = 3
return -1.
```

Note:

You may assume that you have an infinite number of each kind of coin.

- My Answer
```
package medium2;

import java.util.Arrays;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年5月6日
 */
public class CoinChange
{
    // One of most typical DP problem
    // Define state: for m amount, we need at least arr[m] coins.
    // transition: arr[m+1]=min{arr[m+1-ki]+1} (ki means all possible coins of different face value)
    // initial state: arr[0]=0,...,arr[kimin]=1
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int miniCoin=coins[0];
        
        if(amount==0)
            return 0;
        if(amount<miniCoin)
            return -1;
        
        int[] arr=new int[amount+1];        
        Arrays.fill(arr, Integer.MAX_VALUE);
        for(int i=0;i<miniCoin;i++)
            arr[i]=-1;
        arr[0]=0;
        arr[miniCoin]=1;
        
        for(int i=miniCoin+1;i<arr.length;i++) {
            for(Integer coin:coins) {
                if(i-coin>=0) {
                    if(arr[i-coin]!=-1)
                        arr[i]=Math.min(arr[i], arr[i-coin]+1);
                }
            }
            // no solution for amount
            if(arr[i]==Integer.MAX_VALUE)
                arr[i]=-1;
        }
        for(Integer ans:arr)
            System.out.print(ans+" ");
        System.out.println();
            
        return arr[amount];
    }
}
```

# Counting Bits

Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example:

For num = 5 you should return [0,1,1,2,1,2].

Follow up:

- It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
- Space complexity should be O(n).
- Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.

- My Answer
```
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
```

# Top K Frequent Elements

Given a non-empty array of integers, return the k most frequent elements.

For example,

Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note: 
- You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
- Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

- My Answer
```
package medium2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年5月6日
 */
public class TopKFrequentElements
{
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res=new ArrayList<>();
        
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            int key=nums[i];
            if(map.containsKey(key)) {
                map.put(key, map.get(key)+1);
            }else {
                map.put(key, 1);
            }
        }
        
        List<Entry<Integer,Integer>> list=new ArrayList<>();
        for(Entry<Integer,Integer> e:map.entrySet()) 
            list.add(e);
        // sort entry list according to entry's value
        Collections.sort(list, new Comparator<Entry<Integer,Integer>>()
        {
            @Override
            public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2)
            {
                if(o1.getValue()>o2.getValue())
                    return -1;
                else if(o1.getValue()==o2.getValue())
                    return 0;
                else
                    return 1;
            }
        });
        
        for(int i=0;i<k;i++)
            res.add(list.get(i).getKey());
        
        return res;
    }
}
```

# Decode String

Given an encoded string, return it's decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:
```
s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
```

- My Answer
```
package medium2;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年5月6日
 */
public class DecodeString
{
    public static String decodeString(String s) {
        if(!s.contains("["))
            return s;
        
        while(s.contains("[")) {
            int leftBracket=-1;
            while((leftBracket=s.indexOf("[",leftBracket+1))!=-1) {
                int rightBracket=-1;
                boolean decodeFlag=false;
                while((rightBracket=s.indexOf("]",rightBracket+1))!=-1) {
                    String sub=s.substring(leftBracket+1,rightBracket);
                    if(!(sub.contains("[") || sub.contains("]"))) {
                        decodeFlag=true;
                        System.out.println("left:"+leftBracket+",right:"+rightBracket);
                        
                        int count=0;
                        for(int i=leftBracket-1,digit=1;i>=0;i--,digit*=10) {
                            char ch=s.charAt(i);
                            if(Character.isDigit(ch))
                                count+=digit*Character.digit(ch, 10);
                            else
                                break;
                        }
                        String temp=new String(s.substring(0,leftBracket-String.valueOf(count).length()));
                        for(int i=0;i<count;i++)
                            temp+=sub;
                        temp+=s.substring(rightBracket+1,s.length());
                        s=temp;
                        
                        break;
                    }
                }
                if(decodeFlag)
                    break;
            }
        }
    
        
        return s;
    }
    
    public static void main(String[] args)
    {
        String test="2[a3[b2[c]]]ef3[a2[tt]]";
        System.out.println(decodeString(test));
    }
}
```

# Queue Reconstruction by Height

Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.

Note:

The number of people is less than 1,100.


Example
```
Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
```

- My Answer
```
package medium2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年5月6日
 */
public class QueueReconstructionbyHeight
{
    
    // this idea from: https://leetcode.com/problems/queue-reconstruction-by-height/discuss/89345/Easy-concept-with-PythonC++Java-Solution
//  Pick out tallest group of people and sort them in a subarray (S). Since there's no other groups of people taller than them, therefore each guy's index will be just as same as his k value.
//  For 2nd tallest group (and the rest), insert each one of them into (S) by k value. So on and so forth.
//  E.g.
//  input: [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
//  subarray after step 1: [[7,0], [7,1]]
//  subarray after step 2: [[7,0], [6,1], [7,1]]
//  ...
//
//  It's not the most concise code, but I think it well explained the concept.
    public int[][] reconstructQueue(int[][] people) {
        TreeSet<Integer> set=new TreeSet<>();
        for(int i=0;i<people.length;i++)
            set.add(people[i][0]);
        
        for(Integer height:set)
            System.out.print(height+" ");
        
        Map<Integer,List<People>> map=new HashMap<>();
        for(Integer height:set.descendingSet()) {
            List<People> temp=new ArrayList<>();
            for(int i=0;i<people.length;i++) {
                int[] p=people[i];
                int h=p[0];
                int taller=p[1];
                if(h==height) {
                    temp.add(new People(h,taller));
                }
            }
            Collections.sort(temp, new Comparator<People>()
            {
                @Override
                public int compare(People o1, People o2)
                {
                    if(o1.tallerNum>o2.tallerNum)
                        return 1;
                    else if(o1.tallerNum==o2.tallerNum)
                        return 0;
                    else
                        return -1;
                }
            });
            map.put(height,temp);
        }
        
        List<People> res=new ArrayList<>();
        for(Integer height:set.descendingSet()) {
            List<People> temp=map.get(height);
            for(People p:temp) {
                res.add(p.tallerNum,p);
            }
        }
        
        for(int i=0;i<res.size();i++) {
            People p=res.get(i);
            people[i][0]=p.height;
            people[i][1]=p.tallerNum;
        }
        
        
        
        return people;
    }
    
    
}

class People{
    int height,tallerNum;
    public People(int height,int tallerNum) {
        this.height=height;
        this.tallerNum=tallerNum;
    }
}
```

# Pow(x, n)

Implement pow(x, n), which calculates x raised to the power n (xn).

Example 1:
```
Input: 2.00000, 10
Output: 1024.00000
```
Example 2:
```
Input: 2.10000, 3
Output: 9.26100
```
Example 3:
```
Input: 2.00000, -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
```

Note:
- -100.0 < x < 100.0
- n is a 32-bit signed integer, within the range [−231, 231 − 1]

- My Answer
```
package medium2;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年5月9日
 */
public class Powxn
{
    public double myPow(double x, int n) {
        if(x==0)
            return 0;
        if(n==0 || x==1)
            return 1;
        if(n==1)
            return x;
        
        boolean nsign=n>0?true:false;
        
        // simplify calculation (don't forget to inverse the result according to exponent rule)
        // corner case: n=-Integer.MIN_VALUE
        if(n==Integer.MIN_VALUE) {
            x=1/x;
            n=Integer.MAX_VALUE;
            return x*((n%2==0)?myPow(x*x,n/2):x*myPow(x*x,n/2));
        }else
            if(!nsign) {
                n=-n;
                x=1/x;
            }
        
        // Make the most of exponent multiplication rule
        return (n%2==0)?myPow(x*x,n/2):x*myPow(x*x,n/2);
    }
}
```

# Spiral Matrix

Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:
```
Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
```
Example 2:
```
Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
```

- My Answer
```
package medium2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年5月9日
 */
public class SpiralMatrix
{
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res=new ArrayList<>();
        if(matrix.length!=0)
            res=spiralMatrix(matrix,0,matrix.length-1,0, matrix[0].length-1);
        return res;
    }
    
    public List<Integer> spiralMatrix(int[][] matrix,int startx,int endx,int starty,int endy){
        List<Integer> list=new ArrayList<>();
        
        if(startx==endx || starty==endy) {
            if(startx==endx && starty==endy) {
                list.add(matrix[startx][starty]);
            }else if(startx==endx) {
                // single row
                for(int j=starty;j<=endy;j++)
                    list.add(matrix[startx][j]);
            }else if(starty==endy) {
                // single column
                for(int i=startx;i<=endx;i++)
                    list.add(matrix[i][endy]);
            }
            return list;
        }else if(startx<endx && starty<endy) {
            // upper row
            for(int j=starty;j<=endy;j++)
                list.add(matrix[startx][j]);
            // right column
            for(int i=startx+1;i<=endx;i++)
                list.add(matrix[i][endy]);
            // lower row
            if(startx<endx)
                for(int j=endy-1;j>=starty;j--)
                    list.add(matrix[endx][j]);
            // left column
            if(starty<endy)
                for(int i=endx-1;i>startx;i--)
                    list.add(matrix[i][starty]);
        }

        if(list.isEmpty())
            return list;
        else
            list.addAll(spiralMatrix(matrix, startx+1, endx-1, starty+1, endy-1));
        
        return list;
    }
}
```

#  Set Matrix Zeroes

Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

Example 1:
```
Input: 
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output: 
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
```
Example 2:
```
Input: 
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
Output: 
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
```
Follow up:
- A straight forward solution using O(mn) space is probably a bad idea.
- A simple improvement uses O(m + n) space, but still not the best solution.
- Could you devise a constant space solution?``

- My Answer
```
package medium2;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年5月13日
 */
public class SetMatrixZeroes
{
    public void setZeroes(int[][] matrix) {
        if(matrix.length==0)
            return;
        
        Set<Integer> zeroRowSet=new HashSet<>(),zeroColumnSet=new HashSet<>();
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++)
                if(matrix[i][j]==0) {
                    zeroRowSet.add(i);
                    break;
                }
        }
        for(int j=0;j<matrix[0].length;j++) {
            for(int i=0;j<matrix.length;i++) {
                System.out.println("i:"+i+",j:"+j);
                if(matrix[i][j]==0) {
                    zeroColumnSet.add(j);
                    break;
                }
            }
        }
        
        for(Integer row:zeroRowSet)
            for(int j=0;j<matrix[0].length;j++)
                matrix[row][j]=0;
        
        for(Integer column:zeroColumnSet)
            for(int i=0;i<matrix.length;i++)
                matrix[i][column]=0;
        
    }
}
```

# Decode Ways

A message containing letters from A-Z is being encoded to numbers using the following mapping:

```
'A' -> 1
'B' -> 2
...
'Z' -> 26
```

Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:
```
Input: "12"
Output: 2
```
Explanation: It could be decoded as "AB" (1 2) or "L" (12).

Example 2:
```
Input: "226"
Output: 3
```
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

- My Answer
```
package medium2;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年5月13日
 */
public class DecodeWays
{
    // dynamic programming:
    /*
     * 1. state definition:
     *   f(i)=number of decoding ways for array which ends with ith element
     * 2. state transferation:
     *   if(arr[i-1]*10+arr[i]<=26) 
     *     you can decode arr[i] with arr[i-1] in two ways, which means: f(i)=f(i-1)+f(i-2)  
     *     (f(i-1) means arr[i] solely represents a letter, f(i-2) means arr[i-1] toghther with arr[i] represent a letter)
     *     
     *   else
     *     f(i)=f(i-1)
     * 3. initial state:
     *     f(0)=1;
     *     
     * But actually, this problem is not a DP problem, since DP problem requires for optimal substructure, but this problem doesn't meet the requeirment.
     * e.g.: answer for "110" would be 2 if we use DP, but in fact it can only be decoded to "1" and "10".
     *       Which means the number after ith array will also influence f(i)'s value. 
     */
    
    public int numDecodings(String s) {
        int[] ans=new int[s.length()];
        if(s.equals("") || s.startsWith("0"))
            return 0;
        if(s.contains("0")) {
            int zeroIndex=-1;
            while((zeroIndex=s.indexOf("0",zeroIndex+1))!=-1){
                if(s.charAt(zeroIndex-1)=='0' || s.charAt(zeroIndex-1)>'2')
                    return 0;
            }
        }
       
        // for single element with index 0, it obviously can only be decoded in only one way.
        ans[0]=1;
        // for element with index i(i>0), we consider whether it can combine with the last element.
        for(int i=1;i<s.length();i++) {
             int lastDigit=Character.digit(s.charAt(i-1), 10);
             int currentDigit=Character.digit(s.charAt(i), 10);
             if(currentDigit==0) {
                 ans[i]=ans[i-1];
             }else if(lastDigit==0) {
                 ans[i]=ans[i-1];
             }else{
                 if(i<s.length()-1 && Character.digit(s.charAt(i+1), 10)==0) {
                         ans[i]=ans[i-1];
                 }else {
                     if(lastDigit*10+currentDigit<=26) {
                         // 3 ways
                         if(i>=2)
                             ans[i]=ans[i-1]+ans[i-2];
                         else
                             ans[i]=2;
                     }else {
                         // 2 ways
                         ans[i]=ans[i-1];
                     }
                 }
             }          
        }
       
        return ans[s.length()-1];
    }
}
```

# Kth Smallest Element in a BST 

Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 

You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Example 1:
```
Input: root = [3,1,4,null,2], k = 1
Output: 1
```
Example 2:
```
Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3
```
Follow up:

What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

- My Answer
```
package medium2;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年5月13日
 */
public class KthSmallestElementinaBST
{
    // count number of nodes in each side to decide which side to explore further
    public int kthSmallest(TreeNode root, int k) {
        if(root!=null) {
            int leftCount=countNodes(root.left);
            if(k==leftCount+1) {
                // exact root node
                return root.val;
            }else if(k<=leftCount) {
                return kthSmallest(root.left, k);
            }else if(k>leftCount+1) {
                return kthSmallest(root.right, k-leftCount-1);
            }
        }
        return -1;
    }
    
    public int countNodes(TreeNode root) {
        int ans=0;
        if(root!=null) {
            ans++;
            ans+=countNodes(root.left)+countNodes(root.right);
            return ans;
        }else
            return 0;
    }
}
```

# Target Sum

You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:
```
Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
Explanation: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.
```
Note:
- The length of the given array is positive and will not exceed 20.
- The sum of elements in the given array will not exceed 1000.
- Your output answer is guaranteed to be fitted in a 32-bit integer.

- My Answer
```
package medium2;

import java.util.Arrays;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年5月14日
 */
public class TargetSum
{
    // Divide and Conquer
    public int findTargetSumWays(int[] nums, int S) {
        if(nums.length==0)
            return 0;
        if(nums.length==1) {
            if(nums[0]!=Math.abs(S))
                return 0;
            else
                if(nums[0]==0)
                    return 2;
                else
                    return 1;
        }
        
        int[] newArr=Arrays.copyOfRange(nums, 1, nums.length);
        return findTargetSumWays(newArr, S-nums[0])+findTargetSumWays(newArr, S+nums[0]);
    }
}
```

# Subarray Sum Equals K

Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
```
Input:nums = [1,1,1], k = 2
Output: 2
```
Note:
- The length of the array is in range [1, 20,000].
- The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].

- My Answer
```
package medium2;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年5月15日
 */
public class SubarraySumEqualsK
{
    // recurrence
    public int subarraySum(int[] nums, int k) {
        if(nums.length==0)
            return 0;
        int ans[]=new int[nums.length];
        for(int i=0;i<ans.length;i++) {
            int sum=0;
            for(int x=0;i-x>=0;x++) {
                sum+=nums[i-x];
                if(sum==k)
                    ans[i]+=1;
            }
            if(i>=1)
                ans[i]+=ans[i-1];
        }
    
        return ans[ans.length-1];
    }
}
```

# Palindromic Substrings

Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:
```
Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
```
Example 2:
```
Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
```
Note:
- The input string length won't exceed 1000.

- My Answer
```
package medium2;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年5月18日
 */
public class PalindromicSubstrings
{
    // Recurrence
    // ith element in int[] ans means: The number of palindrome in the String which ends with element i.
    public int countSubstrings(String s) {
        int len=s.length();
        if(len==0)
            return 0;
        int ans[]=new int[len];
        ans[0]=1;
        
        for(int i=1;i<len;i++) {
            int letter=s.charAt(i);
            // add before
            ans[i]+=ans[i-1];
            // itself is a palindrome
            ans[i]+=1;
            for(int j=0;j<i;j++) {
                if(letter==s.charAt(j)) {
                    if(checkPalindrome(s.substring(j,i+1)))
                        ans[i]+=1;
                }
            }
        }
        
        return ans[ans.length-1];
    }
    
    public static boolean checkPalindrome(String s) {
        int len=s.length();
        for(int i=0;i<=len-i-1;i++) {
            if(s.charAt(i)!=s.charAt(len-i-1)) {
                return false;
            }
        }
        return true;
    }
}
```

# Binary Tree Zigzag Level Order Traversal

Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
```
    3
   / \
  9  20
    /  \
   15   7
```
return its zigzag level order traversal as:
```
[
  [3],
  [20,9],
  [15,7]
]
```

- My Answer
```
package medium2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年5月18日
 */
public class BinaryTreeZigzagLevelOrderTraversal
{
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        ArrayDeque<TreeNode> oddStack=new ArrayDeque<>(),evenStack=new ArrayDeque<>();
        if(root!=null) {
            oddStack.push(root);
            while(!oddStack.isEmpty() || !evenStack.isEmpty()) {
                List<Integer> tempList=new ArrayList<>();
                if(!oddStack.isEmpty())
                    while(!oddStack.isEmpty()) {
                        TreeNode temp=oddStack.pop();
                        if(temp.left!=null)
                            evenStack.push(temp.left);
                        if(temp.right!=null)
                            evenStack.push(temp.right);
                        tempList.add(temp.val);
                    }
                else
                    while(!evenStack.isEmpty()) {
                        TreeNode temp=evenStack.pop();
                        if(temp.right!=null)
                            oddStack.push(temp.right);
                        if(temp.left!=null)
                            oddStack.push(temp.left);
                        tempList.add(temp.val);
                    }
                
                if(!tempList.isEmpty())
                    ans.add(tempList);
            }
        }
        
        
        return ans;
    }
}
```

# Palindrome Partitioning

Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Example:
```
Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]
```

- My Answer
```
package medium2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年5月19日
 */
public class PalindromePartitioning
{
    // DP solution
    public List<List<String>> partition(String s) {
        
        if(s.length()==0)
            return Arrays.asList(Arrays.asList(""));
        
        ArrayList<List<List<String>>> ansList=new ArrayList<List<List<String>>>();
        ansList.add(Arrays.asList(Arrays.asList(s.substring(0,1))));
        
        for(int i=1;i<s.length();i++) {
            List<List<String>> tempBigList=new ArrayList<>();
            for(int j=0;j<=i;j++) {
                String right=s.substring(j,i+1);
                if(isPalindrome(right)){
                    if(j==0) {
                        tempBigList.add(Arrays.asList(right));
                    }else {
                        List<List<String>> leftPartition=ansList.get(j-1);
                        for(List<String> partition:leftPartition) {
                            List<String> tempList=new ArrayList<>();
                            tempList.addAll(partition);
                            tempList.add(right);

                            tempBigList.add(tempList);
                        }
                    }
                }
            }
            ansList.add(tempBigList);
        }
        
        return ansList.get(ansList.size()-1);
    }
    
    public boolean isPalindrome(String s) {
        int len=s.length();
        if(len==0)
            return false;
        
        for(int i=0;i<len;i++) {
            if(s.charAt(i)!=s.charAt(len-i-1))
                return false;
        }
        return true;
    }
    
}
```

# Find Peak Element

A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞.

Example 1:
```
Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
```
Example 2:
```
Input: nums = [1,2,1,3,5,6,4]
Output: 1 or 5 
Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
```
Note:

Your solution should be in logarithmic complexity.

- My Answer
```
package medium2;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年5月19日
 */
public class FindPeakElement
{
    public int findPeakElement(int[] nums) {
        if(nums.length==1)
            return 0;
        if(nums[0]>nums[1])
            return 0;
        if(nums[nums.length-1]>nums[nums.length-2])
            return nums.length-1;
        
        for(int i=0;i+1<nums.length;i++) {
            if(nums[i]>nums[i+1]) {
                if(nums[i]>nums[i-1]) {
                    return i;
                }
            }
        }
        return 0;
    }
}`
```

# Odd Even Linked List

Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example:
```
Given 1->2->3->4->5->NULL,
return 1->3->5->2->4->NULL.
```

Note:
- The relative order inside both the even and odd groups should remain as it was in the input. 
- The first node is considered odd, the second node even and so on ...

- My Answer
```
package medium2;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年5月19日
 */
public class OddEvenLinkedList
{
    // this souliton exceeds memory limit, however, I think it's clear and simple enough
    public ListNode oddEvenList(ListNode head) {
        
        int mark=1;
        
        if(head==null || head.next==null || head.next.next==null)
            return head;
        int index=2;
        
        ListNode oddHead=head,evenHead=head.next;
        ListNode oddTemp=head,evenTemp=head.next;
        
        head=head.next;
        while(head.next!=null) {
            // the next node is an even node
            if((++index)%2==0){
                evenTemp.next=head.next;
                evenTemp=head.next;
            }
            // the next node is a odd node
            else{
                oddTemp.next=head.next;
                oddTemp=head.next;
            }
            head=head.next;
        }
        oddTemp.next=evenHead;
        
        return oddHead;
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
```

# Construct Binary Tree from Inorder and Postorder Traversal

[LC106](https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/)

Given inorder and postorder traversal of a tree, construct the binary tree.

Note:

You may assume that duplicates do not exist in the tree.

For example, given
```
inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
```
Return the following binary tree:
```
    3
   / \
  9  20
    /  \
   15   7
```

-  My Answer
```
package medium2;

import java.util.Arrays;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年5月26日
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal
{
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0)
            return null;
        if(inorder.length==1)
            return new TreeNode(inorder[0]);
        
        TreeNode root=new TreeNode(postorder[postorder.length-1]);
        int leftTreeNodeSum=0;
        for(int i=0;i<inorder.length;i++)
            if(inorder[i]==root.val){
                leftTreeNodeSum=i;
                break;
            }
        
        root.left=buildTree(Arrays.copyOfRange(inorder, 0, leftTreeNodeSum), Arrays.copyOfRange(postorder, 0, leftTreeNodeSum));
        root.right=buildTree(Arrays.copyOfRange(inorder, leftTreeNodeSum+1, inorder.length), Arrays.copyOfRange(postorder, leftTreeNodeSum, postorder.length-1));
        
        return root;
    }
}
```


# Populating Next Right Pointers in Each Node

[LC116](https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/)

Given a binary tree
```
struct TreeLinkNode {
  TreeLinkNode *left;
  TreeLinkNode *right;
  TreeLinkNode *next;
}
```
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

- You may only use constant extra space.
- Recursive approach is fine, implicit stack space does not count as extra space for this problem.
- You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
Example:

Given the following perfect binary tree,
```
     1
   /  \
  2    3
 / \  / \
4  5  6  7
```
After calling your function, the tree should look like:
```
     1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \  / \
4->5->6->7 -> NULL
```

- My Answer
```
package medium2;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年5月28日
 */
public class PopulatingNextRightPointersinEachNode
{
    public static void connect(TreeLinkNode root) {
        if(root==null)
            return;
        else {
            if(root.left!=null && root.right!=null) {
                root.left.next=root.right;
            }
            
            if(root.next!=null) {
                if(root.right!=null && root.next.left!=null) {
                    root.right.next=root.next.left;
                }
            }
        }
        connect(root.left);
        connect(root.right);
    }
    
    public static void main(String[] args)
    {
        TreeLinkNode node1=new TreeLinkNode(1),node2=new TreeLinkNode(2),node3=new TreeLinkNode(3),node4=new TreeLinkNode(4),node5=new TreeLinkNode(5),node6=new TreeLinkNode(6),node7=new TreeLinkNode(7);
        node1.left=node2;node2.left=node4;node2.right=node5;
        node1.right=node3;node3.left=node6;node3.right=node7;
        connect(node1);
        System.out.println(node1.next);
        System.out.println(node2.next.val);
        System.out.println(node3.next);
        System.out.println(node4.next.val);
        System.out.println(node5.next.val);
        System.out.println(node6.next.val);
        System.out.println(node7.next);
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}
```

# Path Sum II

[LC113](https://leetcode.com/problems/path-sum-ii/description/)

Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,
```
      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
```
Return:
```
[
   [5,4,11,2],
   [5,8,4,5]
]
```

- My Answer
```
package medium2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年6月7日
 */
public class PathSumII
{
    // DFS: make use of recursion to backtrack
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        if(root==null)
            return ans;
        
        int goal=sum-root.val;
        if(goal==0) {
            if(root.left==null && root.right==null) {
                List<Integer> tempList=new ArrayList<>();
                tempList.add(root.val);
                ans.add(tempList);
                return ans;
            }
        }
            
        List<List<Integer>> temp;
        if((temp=pathSum(root.left, goal)).size()!=0) {
            for(List<Integer> list:temp) {
                list.add(0, root.val);
                ans.add(list);
            }
        }
        
        if((temp=pathSum(root.right, goal)).size()!=0) {
            for(List<Integer> list:temp) {
                list.add(0,root.val);
                ans.add(list);
            }
        }
        
        return ans;
    }
    
    
}


```

# Convert Sorted List to Binary Search Tree

[LC109](https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/)

Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:
```
Given the sorted linked list: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
```

- My Answer
```
package medium2;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年6月11日
 */
public class ConvertSortedListtoBinarySearchTree
{
    // find the middle node of sorted linked list, and take it as the root node of the BST.
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)
            return null;
        
        ListNode slow=head,fast=head,followSlow=head;
        
        boolean moveFlag=false;
        while(fast!=null && fast.next!=null) {
            if(moveFlag)
                followSlow=followSlow.next;
            moveFlag=true;
            slow=slow.next;
            fast=fast.next.next;
        }
        TreeNode root=new TreeNode(slow.val);
        
        if(moveFlag) {
            followSlow.next=null;
            root.left=sortedListToBST(head);
            root.right=sortedListToBST(slow.next);
        }
    
        return root;
    }
}
```

# Binary Tree Right Side View

Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example:
```
Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
```

- My Answer
```
package medium2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年6月12日
 */
public class BinaryTreeRightSideView
{
     public List<Integer> rightSideView(TreeNode root) {
         List<Integer> ans=new ArrayList<>();
         if(root==null)
             return ans;
         
         ans.add(root.val);
         
         ArrayDeque<TreeNode> queue1=new ArrayDeque<>(),queue2=new ArrayDeque<>();;
         queue1.add(root);
         
         while(!queue1.isEmpty() || !queue2.isEmpty()){
             TreeNode rightestNode=null;
             
             if(!queue1.isEmpty()) {
                 while(!queue1.isEmpty()) {
                     TreeNode fatherNode=queue1.poll();
                     
                     if(fatherNode.right!=null) {
                         queue2.add(fatherNode.right);
                         if(rightestNode==null)
                             rightestNode=fatherNode.right;
                     }
                     
                     if(fatherNode.left!=null) {
                         queue2.add(fatherNode.left);
                         if(rightestNode==null)
                             rightestNode=fatherNode.left;
                     }
                 }
             }else{
                 while(!queue2.isEmpty()) {
                     TreeNode fatherNode=queue2.poll();
                     if(fatherNode.right!=null) {
                         queue1.add(fatherNode.right);
                         if(rightestNode==null)
                             rightestNode=fatherNode.right;
                     }
                     if(fatherNode.left!=null) {
                         queue1.add(fatherNode.left);
                         if(rightestNode==null)
                             rightestNode=fatherNode.left;
                     }
                 }
             }
             
             if(rightestNode!=null)
                 ans.add(rightestNode.val);
             
         }
         
         return ans;
     }
}
```


# 






















































































# Surrounded Regions

Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:
```
X X X X
X O O X
X X O X
X O X X
```
After running your function, the board should be:
```
X X X X
X X X X
X X X X
X O X X
```
Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.

- My Answer
```
```


# Kth Smallest Element in a Sorted Matrix

Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:
```
matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
```
Note: 

You may assume k is always valid, 1 ≤ k ≤ n2.

- My Answer
```

```























































# Word Ladder

Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

- Only one letter can be changed at a time.
- Each transformed word must exist in the word list. Note that beginWord is not a transformed word.

Note:

- Return 0 if there is no such transformation sequence.
- All words have the same length.
- All words contain only lowercase alphabetic characters.
- You may assume no duplicates in the word list.
- You may assume beginWord and endWord are non-empty and are not the same.

Example 1:
```
Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
```
Example 2:
```
Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
```

- My Answer
```

```

# Partition Equal Subset Sum

Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

Note:
- Each of the array element will not exceed 100.
- The array size will not exceed 200.

Example 1:
```
Input: [1, 5, 11, 5]

Output: true

Explanation: The array can be partitioned as [1, 5, 5] and [11].
```
Example 2:
```
Input: [1, 2, 3, 5]

Output: false

Explanation: The array cannot be partitioned into equal sum subsets.
```

- My Answer
```

```


















# House Robber III

The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:
```
     3
    / \
   2   3
    \   \ 
     3   1
```
Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:
```
     3
    / \
   4   5
  / \   \ 
 1   3   1
```
Maximum amount of money the thief can rob = 4 + 5 = 9.

- My Answer
```

```

# Best Time to Buy and Sell Stock with Cooldown

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)

Example:
```
prices = [1, 2, 3, 0, 2]
maxProfit = 3
transactions = [buy, sell, cooldown, buy, sell]
```

- My Answer
```

```


