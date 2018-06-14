# Add Two Numbers

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example
```
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
```

- My Answer
```
package medium1;

import java.util.ArrayDeque;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月29日
 */
public class AddTwoNumbers
{
     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            StringBuilder str=new StringBuilder("");
            ArrayDeque<Integer> stack1=new ArrayDeque<Integer>();
            ArrayDeque<Integer> stack2=new ArrayDeque<Integer>();
            
            while(l1!=null){
                stack1.offer(l1.val);
                l1=l1.next;
            }
            while(l2!=null){
                stack2.offer(l2.val);
                l2=l2.next;
            }
            
            boolean jinwei=false;
            while(!stack1.isEmpty() && !stack2.isEmpty()){
                int ele1=stack1.poll(),ele2=stack2.poll();
                int sum;
                if(jinwei==true){
                    sum=ele1+ele2+1;
                }else{
                    sum=ele1+ele2;
                }

                jinwei=false;
                if(sum>=10)
                    jinwei=true;
                str.append(""+sum%10);
            }
            
            while(!stack1.isEmpty()){
                int ele=stack1.poll();
                if(jinwei==true){
                    str.append((ele+1)%10);
                    if(ele+1>=10){
                        jinwei=true;
                    }
                    else{
                        jinwei=false;
                    }
                }else{
                    str.append(ele);
                }
            }
            while(!stack2.isEmpty()){
                int ele=stack2.poll();
                if(jinwei==true){
                    str.append((ele+1)%10);
                    if(ele+1>=10){
                        jinwei=true;
                    }
                    else{
                        jinwei=false;
                    }
                }else{
                    str.append(ele);
                }
            }
            
            if(jinwei==true)
                str.append("1");
            
            
            
            int []arr=new int[str.length()];
            ListNode []nodeArr=new ListNode[arr.length];
            
            for(int i=0;i<str.length();i++){
                arr[i]=Character.digit(str.charAt(i), 10);
                nodeArr[i]=new ListNode(arr[i]);
                
            }
            
            for(int i=0;i<nodeArr.length-1;i++)
                nodeArr[i].next=nodeArr[i+1];
            return nodeArr[0];
        }
}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}
```

# Longest Substring Without Repeating Characters

Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

- My Answer
```
package medium1;

import java.util.ArrayList;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月29日
 */
public class LongestSubstringWithoutRepeatingCharacters
{
    public static void main(String[] args)
    {
        
    }
    
    public int lengthOfLongestSubstring(String s) {
           if(s.equals("")) return 0;
                ArrayList<ArrayList<Character>> bigList=new ArrayList<ArrayList<Character>>(); 
                for(int i=0;i<s.length();i++){
                    ArrayList<Character> list=new ArrayList<Character>();
                    for(int j=i;j<s.length();j++){
                        if(list.contains(s.charAt(j))){
                            break;
                        }else{
                            list.add(s.charAt(j));
                        }
                    }
                    bigList.add(list);
                }
                
                int maxLen=Integer.MIN_VALUE;
                for(int i=0,len=bigList.size();i<len;i++){
                    ArrayList<Character> list=bigList.get(i);
                    if(list.size()>maxLen){
                        maxLen=list.size();
                    }
                }
                
                return maxLen;
      }
}
```

#  Longest Palindromic Substring

Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example:
```
Input: "babad"

Output: "bab"
```
Note: "aba" is also a valid answer.
 

Example:
```
Input: "cbbd"

Output: "bb"
```

- My Answer
```
package medium1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月29日
 */
public class LongestPalindromicSubstring
{
    // This solution from: https://leetcode.com/problems/longest-palindromic-substring/discuss/2928/Very-simple-clean-java-solution
    public static String longestPalindrome(String s) {
         int max = 0, idx = 0;
            for (int i = 0; i < s.length(); i++) {
                int len1 = extend(s, i, i), len2 = extend(s, i, i + 1);
                if (max < Math.max(len1, len2)) {
                    idx = (len1 > len2) ? (i - len1 / 2) : (i - len2 / 2 + 1);
                    max = Math.max(len1, len2);
                }
            }
            return s.substring(idx, idx + max);
     }
        
    private static int extend(String s, int i, int j) {
        for (; i >= 0 && j < s.length(); i--, j++)
            if (s.charAt(i) != s.charAt(j))
                break;
        return j - i - 2 + 1; // 2 means current two unmatched char
    }
    
    //Exceed time limit
//  public static String longestPalindrome(String s) {
//      if(s.length()<=1)
//          return s;
//      String answer="";
//      int len=s.length();
//      int findedPalindromMaxLen=0;
//      for(int i=0;i<len-1;i++) {
//          if(len-i<=findedPalindromMaxLen)
//              break;
//          for(int j=0;j<len-i;j++) {
////                System.out.println("len-j-i:"+(len-j-i));
//              if(len-j-i<=findedPalindromMaxLen)
//                  break;
//              
//              if(s.charAt(i)==s.charAt(len-j-1) && len-j-i>findedPalindromMaxLen) {
//                  String temp=s.substring(i,len-j);
//                  if(judgePalindrome(temp)) {
//                      if(temp.length()>findedPalindromMaxLen) {
//                          answer=temp;
//                          findedPalindromMaxLen=answer.length();
//                          System.out.println("longest:"+findedPalindromMaxLen+"iteration--i:"+i+",j:"+j);
//                      }
//                  }
//              }
//          }
//      }
//        return answer;
//    }
//  
//  public static boolean judgePalindrome(String s) {
//      int half=s.length()/2;
//      int len=s.length();
//      for(int i=0;i<half;i++) {
//          if(!(s.charAt(i)==s.charAt(len-i-1)))
//              return false;
//      }
//      return true;
//  }
}
```


#  ZigZag Conversion

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
```
P   A   H   N
A P L S I I G
Y   I   R
```
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:
```
string convert(string text, int nRows);
```

convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

- My Answer
```
package medium1;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月31日
 */
public class ZigZagConversion
{
    
    // This solution from: https://leetcode.com/problems/zigzag-conversion/discuss/3403
    public String convert(String s, int numRows) {
        //Create numRows StringBuffers, and keep collecting characters from original string to corresponding StringBuffer. Just take care of your index to keep them in bound.

        char[] c = s.toCharArray();
        int len = c.length;
        StringBuffer[] sb = new StringBuffer[numRows];
        for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();
        
        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < numRows && i < len; idx++) // vertically down
                sb[idx].append(c[i++]);
            for (int idx = numRows-2; idx >= 1 && i < len; idx--) // obliquely up
                sb[idx].append(c[i++]);
        }
        for (int idx = 1; idx < sb.length; idx++)
            sb[0].append(sb[idx]);
        return sb[0].toString();
    }
}
```

# String to Integer (atoi)

Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

Update (2015-02-10):

The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.

- My Answer
```
package medium1;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月31日
 */
public class StringtoIntegeratoi
{
    public static void main(String[] args)
    {
        System.out.println(Character.digit('b',10));
    }
    
    
    // This solution from: https://leetcode.com/problems/string-to-integer-atoi/discuss/4654/My-simple-solution
    public static int myAtoi(String str) {
        int index = 0, sign = 1, total = 0;
        //1. Empty string
        if(str.length() == 0) return 0;

        //2. Remove Spaces
        while(str.charAt(index) == ' ' && index < str.length())
            index++;

        //3. Handle signs
        if(str.charAt(index) == '+' || str.charAt(index) == '-'){
            sign = str.charAt(index) == '+' ? 1 : -1;
            index ++;
        }
        
        //4. Convert number and avoid overflow
        while(index < str.length()){
            int digit = str.charAt(index) - '0';
            if(digit < 0 || digit > 9) break;

            //check if total will be overflow after 10 times and add digit
            if(Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            total = 10 * total + digit;
            index ++;
        }
        return total * sign;
    }
    
    // This solution is from Java's library code: Integer.parseInt(String s), but it still can't cover all cases appeared in leetcode 
//  public static int myAtoi(String str) {
//          int radix=10;
//
//          int result = 0;
//          boolean negative = false;
//          int i = 0, len = str.length();
//          int limit = -Integer.MAX_VALUE;
//          int multmin;
//          int digit;
//
//          if (len > 0) {
//              char firstChar = str.charAt(0);
//              if (firstChar < '0') { // Possible leading "+" or "-"
//                  if (firstChar == '-') {
//                      negative = true;
//                      limit = Integer.MIN_VALUE;
//                  }
//
//                  if (len == 1) // Cannot have lone "+" or "-"
//                      return 0;
//                  i++;
//              }
//              multmin = limit / radix;
//              while (i < len) {
//                  // Accumulating negatively avoids surprises near MAX_VALUE
//                  digit = Character.digit(str.charAt(i++),radix);
//                  // illegal non-digit character
//                  if (digit < 0) {
//                          return 0;
//                  }
//                  if (result < multmin) {
//                      return 0;
//                  }
//                  result *= radix;
//                  if (result < limit + digit) {
//                      return 0;
//                  }
//                  result -= digit;
//              }
//          }
//          
//          return negative ? result : -result;
//   }
}
```

# Container With Most Water

Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

- My Answer
```
package medium1;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年2月11日
 */
public class ContainerWithMostWater
{
    // This solution from: https://leetcode.com/problems/container-with-most-water/discuss/6091/Easy-Concise-Java-O(N)-Solution-with-Proof-and-Explanation
    //  AKA, the general idea to find some max is to go through all cases where max value can possibly occur and keep updating the max value. The efficiency of the scan depends on the size of cases you plan to scan.
    //  To increase efficiency, all we need to do is to find a smart way of scan to cut off the useless cases and meanwhile 100% guarantee the max value can be reached through the rest of cases.
    //
    //  In this problem, the smart scan way is to set two pointers initialized at both ends of the array. Every time move the smaller value pointer to inner array. Then after the two pointers meet, all possible max cases have been scanned and the max situation is 100% reached somewhere in the scan. Following is a brief prove of this.
    //
    //  Given a1,a2,a3…an as input array. Lets assume a10 and a20 are the max area situation. We need to prove that a10 can be reached by left pointer and during the time left pointer stays at a10, a20 can be reached by right pointer. That is to say, the core problem is to prove: when left pointer is at a10 and right pointer is at a21, the next move must be right pointer to a20.
    //
    //  Since we are always moving the pointer with the smaller value, i.e. if a10 > a21, we should move pointer at a21 to a20, as we hope. Why a10 >a21? Because if a21>a10, then area of a10 and a20 must be less than area of a10 and a21. Because the area of a10 and a21 is at least height[a10] * (21-10) while the area of a10 and a20 is at most height[a10] * (20-10). So there is a contradiction of assumption a10 and a20 has the max area. So, a10 must be greater than a21, then next move a21 has to be move to a20. The max cases must be reached.
    public int maxArea(int[] height) {
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
    // Still exceed time limit
    // For each line, they should try to find line that is at least as high as it and farthest from it.
//  public int maxArea(int[] height) {
//      int maxWater=0;
//      for(int i=0;i<height.length;i++) {
//          for(int start=0;start<i;start++) {
//              if(height[start]>=height[i]) {
//                  int capacity=height[i]*(i-start);
//                  if(capacity>maxWater)
//                      maxWater=capacity;
//                  break;
//              }
//          }
//          for(int end=height.length-1;end>i;end--) {
//              if(height[end]>=height[i]) {
//                  int capacity=height[i]*(end-i);
//                  if(capacity>maxWater)
//                      maxWater=capacity;
//                  break;
//              }
//          }
//      }
//      return maxWater;
//  }
    
    // Method of Exhaustion surely exceeds time limit!
//  public int maxArea(int[] height) {
//      int maxWater=0;
//      for(int i=0;i<height.length-1;i++) {
//          for(int j=i+1;j<height.length;j++) {
//              int capacity=(j-i)*Math.min(height[i], height[j]);
//              if(capacity>maxWater)
//                  maxWater=capacity;
//          }
//      }
//        return maxWater;
//    }
}
```

# Integer to Roman

Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.

- My Answer
```
package medium1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年2月12日
 */
public class IntegertoRoman
{
    public static void main(String[] args)
    {
        System.out.println(new IntegertoRoman().intToRoman(57));
    }
    
    Map<Integer,String> map=new HashMap<Integer,String>();
    
    public String intToRoman(int num) {
        map.put(1,"I");map.put(5,"V");map.put(10,"X");
        map.put(50,"L");map.put(100,"C");map.put(500,"D");map.put(1000,"M");
        String answer="";
        int radix=1;
        List<String> list=new ArrayList<String>();
        while(num!=0) {
            int digit=num%10;
            list.add(digit(digit,radix));
            radix*=10;
            num/=10;
        }
        
        for(int i=list.size()-1;i>=0;i--)
            answer+=list.get(i);
        
        return answer;
    }
    
    public String digit(int num,int radix) {
        if(num==4)
            return map.get(radix)+map.get(radix*5);
        if(num==9)
            return map.get(radix)+map.get(radix*10);
        if(num<5) {
            String str="";
            for(int i=0;i<num;i++) {
                str+=map.get(radix);
            }
            return str;
        }else {
            String str=map.get(radix*5);
            for(int i=0;i<num-5;i++) {
                str+=map.get(radix);
            }
            return str;
        }
    }
}
```

# 3Sum

Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.
```
For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
```

- My Answer
```
package medium1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年2月12日
 */
public class ThreeSum
{ 
    // This solution from: The idea is to sort an input array and then run through all indices of a possible first element of a triplet. 
    // For each possible first element we make a standard bi-directional 2Sum sweep of the remaining part of the array. 
    // Also we want to skip equal elements to avoid duplicates in the answer without making a set or smth like that.
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>(); 
        for (int i = 0; i < nums.length-2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int lo = i+1, hi = nums.length-1, sum = 0 - nums[i];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo+1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi-1]) hi--;
                        lo++; hi--;
                    } else if (nums[lo] + nums[hi] < sum) lo++;
                    else hi--;
               }
            }
        }
        return res;
    }
    
    // Exceeds time limit
//  public static List<List<Integer>> threeSum(int[] nums) {
//      Arrays.sort(nums);
//        List<List<Integer>> bigList=new ArrayList<List<Integer>>();
//        for(int i=0;i<nums.length-2;i++) {
//              int left=nums[i];
//
//              int leftRemain=-left;
//              for(int j=i+1;j<nums.length-1;j++) {
//                  int middle=nums[j];
//              
//                  int middleRemain=leftRemain-middle;
//                  for(int x=j+1;x<nums.length;x++) {
//                      int right=nums[x];
//                      
//                      if(right==middleRemain) {
//                          List<Integer> list=new ArrayList<Integer>();
//                          list.add(left);list.add(middle);list.add(right);
//                          boolean containFlag=false;
//                          for(List<Integer> temp:bigList) {
//                              if(list.containsAll(temp) && temp.containsAll(list)) {
//                                  containFlag=true;
//                                  break;
//                              }
//                          }
//                          if(containFlag)
//                              break;
//                          else {
//                              bigList.add(list);
//                          }
//                          
//                      }
//                  }
//              }
//        }
//        return bigList;
//    }
}
```

#  3Sum Closest

Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
```
    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
```

- My Answer
```
package medium1;

import java.util.Arrays;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年2月12日
 */
public class ThreeSumClosest
{
    public static void main(String[] args)
    {
        int[] nums= {-1,0,1,1,55};
        System.out.println(threeSumClosest(nums, 3));
    }
    // This can be seen as variant of 3Sum
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min=Integer.MAX_VALUE;
        int answer=0;
        for(int i=0;i<nums.length-2;i++) {
            if(i==0 || (i>0 && nums[i]!=nums[i-1])) {
                int lo=i+1,hi=nums.length-1,sum=target-nums[i];
                while(hi>lo) {
                    System.out.println("i:"+i+",lo:"+lo+",hi:"+hi);
                    int delta=Math.abs(nums[hi]+nums[lo]-sum);
                    if(delta==0) {
                        return target;
                    }else if(delta<min) {
                        answer=nums[i]+nums[hi]+nums[lo];
                        min=delta;
                    }
                    
                    if(nums[hi]+nums[lo]>sum)
                        hi--;
                    else
                        lo++;
                }
            }
        }
        return answer;
    }
}
```

# Letter Combinations of a Phone Number

Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

![](http://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Telephone-keypad2.svg/200px-Telephone-keypad2.svg.png)
```
Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
```
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.

- My Answer
```
package medium1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年2月12日
 */
public class LetterCombinationsofaPhoneNumber
{
    public static void main(String[] args)
    {
        for(String str:letterCombinations("32235235")) {
            System.out.println(str);
        }
    }
    
    public static List<String> letterCombinations(String digits) {
        List<String> list=new ArrayList<String>();
        if(digits.contains("1") || digits.contains("0"))
            return list;
        else {
            Map<Integer, String> map=new HashMap<Integer,String>();
            map.put(2, "abc");map.put(3, "def");map.put(4, "ghi");map.put(5, "jkl");
            map.put(6, "mno");map.put(7, "pqrs");map.put(8, "tuv");map.put(9, "wxyz");
            char[] arr=digits.toCharArray();
            for(int i=0;i<arr.length;i++) {
                int digit=Character.digit(arr[i],10);
                String chars=map.get(digit);
                if(list.size()==0) {
                    for(int j=0;j<chars.length();j++)
                        list.add(chars.substring(j, j+1));
                }else {
                    Object[] strs=list.toArray();
                    list.clear();
                    for(Object str:strs) {
                        for(int j=0;j<chars.length();j++)
                            list.add(str+chars.substring(j,j+1));
                    }
                }
            }
        }
        return list;
    }
}
```

# 4Sum

Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note: The solution set must not contain duplicate quadruplets.
```
For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
```

- My Answer
```
package medium1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年2月13日
 */
public class FourSum
{   
    // In this way, you can review solutions for problem 2Sum and 3Sum at the same time!:-)! 
    public List<List<Integer>> fourSum(int[] nums, int target){
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        
        
        int len=nums.length;
        // boundary case
        if(nums==null || len<4 || nums[0]*4>target || nums[len-1]*4<target)
            return res;
        
        for(int i=0;i<len-3;i++) {
            if(i==0 || (i>0 && nums[i]!=nums[i-1])) {
                List<List<Integer>> tempList=threeSum(nums,i+1,target-nums[i]);
                for(List<Integer> list:tempList) {
                    List<Integer> tempTemplist=new ArrayList<Integer>();
                    tempTemplist.add(nums[i]);
                    for(Integer temp:list) {
                        tempTemplist.add(temp);
                    }
                    res.add(tempTemplist);
                }
            }

        }
        return res;
    }
    
    public List<List<Integer>> threeSum(int[] nums,int start,int target){
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        int size=nums.length-start;
        if(size<3 || nums[start]*3>target || nums[nums.length-1]*3<target) {
            return res;
        }
        
        for(int i=start;i<nums.length-2;i++) {
            if(i==start || (i>start && nums[i]!=nums[i-1])) {
                List<List<Integer>> tempList=twoSum(nums,i+1,target-nums[i]);
                for(List<Integer> list:tempList) {
                    List<Integer> tempTemplist=new ArrayList<Integer>();
                    tempTemplist.add(nums[i]);
                    for(Integer temp:list) {
                        tempTemplist.add(temp);
                    }
                    res.add(tempTemplist);
                }
            }
        }
        return res;
    }
    
    public List<List<Integer>> twoSum(int[] nums,int start,int target){
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        int size=nums.length-start;
        if(size<2 || nums[start]*2>target || nums[nums.length-1]*2<target) {
            return res;
        }

        int i=start;
        if(i==start || (i>start && nums[i]!=nums[i-1])) {
            int lo=i,hi=nums.length-1;
            // -2 -1 0 0 1 2
            while(hi>lo) {
                if(nums[lo]+nums[hi]==target) {
                    res.add(Arrays.asList(nums[lo],nums[hi]));
                    while(hi>lo && nums[hi]==nums[hi-1]) hi--;
                    while(hi>lo && nums[lo]==nums[lo+1]) lo++;
                    lo++;hi--;
                }else if(nums[lo]+nums[hi]>target) hi--;
                else lo++;
            }
        }
        return res;
    }
}
```

# Remove Nth Node From End of List

Given a linked list, remove the nth node from the end of list and return its head.

For example,
```
   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
```
Note:
```
Given n will always be valid.
Try to do this in one pass.
```

- My Answer
```
package medium1;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年2月14日
 */
public class RemoveNthNodeFromEndofList
{
    // Let a node be forward node, and assign a follow node to keep n node distance from forward node
    // Then when forward node get to the tail, the node next to the follow node is the node to be removed
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode forwardNode=head,followNode=head;
        
        int count=0;
        //1 2 3 4 5
        while(forwardNode.next!=null) {
            if(++count>n) {
                followNode=followNode.next;
            }
                
            forwardNode=forwardNode.next;
        }
        
        // if removeNode is the head node, then special treat
        if(n>count) {
            head=head.next;
        }
        else {
            ListNode removeNode=followNode.next;
            followNode.next=removeNode.next;
            removeNode.next=null;
        }
        
        return head;
    }
}
```

# Generate Parentheses

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:
```
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
```
- My Answer
```
package medium1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年2月14日
 */
public class GenerateParentheses
{
    public static void main(String[] args)
    {
        for(String str:generateParenthesis(5))
            System.out.println(str);
    }
    public static List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<String>();
        if(n==0)
                return res;
        else if(n==1) {
                res.add("()");
                return res;
        }else if(n==2) {
                res.add("()()");
                res.add("(())");
                return res;
        }else {
                Set<String> set=new HashSet<String>();
                for(String str:generateParenthesis(n-1)) {
                    str="("+str;
                    StringBuilder builder=new StringBuilder(str);
                    for(int i=1;i<str.length();i++) {
                        builder=new StringBuilder(str).insert(i,')');
                        if(builder.charAt(i-1)==')') continue;
                        set.add(builder.toString());
                    }
                }
                for(String str:set)
                    res.add(str);
        }
        
        
        return res;
    }
}
```

# Swap Nodes in Pairs

Given a linked list, swap every two adjacent nodes and return its head.

For example,
```
Given 1->2->3->4, you should return the list as 2->1->4->3.
```
Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

- My Answer
```
package medium1;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年2月14日
 */
public class SwapNodesinPairs
{
    
    public ListNode swapPairs(ListNode head) {
        //[1,2,3,4]
        //[2,1,3]
        if(head==null || head.next==null)
            return head;
        ListNode left=head,right=head.next;
        head=right;
        while(right!=null) {
            left.next=right.next;
            right.next=left;
            right=left.next;
            System.out.println("left:"+left.val+",right:"+right.val);
            if(right!=null) {
                if(right.next==null) {
                    break;
                }else {
                    left.next=right.next;
                    left=right;
                    right=right.next;
                }
            }
            else
                break;
        }
        return head;
    }
}
```

# Divide Two Integers

Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT.

- My Answer
```
package medium1;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年2月18日
 */
public class DivideTwoIntegers
{
    public static void main(String[] args)
    {
        System.out.println(String.valueOf(-2147483648));
//      System.out.println(divideStr(2147483648,2));
    }
    
    public static int divide(int dividend, int divisor) {
        int sign=1;
        if(divisor==0)
            return Integer.MAX_VALUE;
        // different sign
        if((dividend<0 && divisor>0) || (dividend>0 && divisor<0)) {
            sign=-1;
            divisor=-divisor;
        }       

        return divideStr(dividend, divisor,sign);
    }
    
    // calculate quotient of two numbers with same sign
    public static int divideStr(int dividend,int divisor,int sign) {
        String answer="";
        String dividendStr=String.valueOf(dividend);
        if(dividendStr.startsWith("-")) {
            dividendStr=dividendStr.substring(1);
            divisor=-divisor;
        }
        int left=0;
        for(int i=0;i<dividendStr.length();i++) {
            int digit=Character.digit(dividendStr.charAt(i), 10);
            digit+=left;
            int temp=0;
            while(digit-divisor>=0) {
                digit-=divisor;
                temp++;
            }
            left=digit*10;
            answer+=temp;
        }
        boolean overflowFlag=false;
        if(answer.length()>10) {
            overflowFlag=true;
        }else if(answer.length()==10) {
            int firstNineDigit=Integer.parseInt(answer.substring(0, 9)),lastDigit=Character.digit(answer.charAt(answer.length()-1), 10);
            if(sign==1) {
                if(firstNineDigit>Integer.MAX_VALUE/10 || (firstNineDigit==Integer.MAX_VALUE/10 && lastDigit>Integer.MAX_VALUE%10)) {
                    overflowFlag=true;
                }
            }
            else {
                if(firstNineDigit>Integer.MAX_VALUE/10 || (firstNineDigit==Integer.MAX_VALUE/10 && lastDigit>Integer.MAX_VALUE%10+1)) {
                    overflowFlag=true;
                }
            }
        }
        
        if(sign==1)
            return overflowFlag?Integer.MAX_VALUE:Integer.parseInt(answer);
        else
            return overflowFlag?Integer.MAX_VALUE:Integer.parseInt("-"+answer);
    }
}
```

# Next Permutation

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
```
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
```

- My Answer
```
package medium1;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年2月19日
 */
public class NextPermutation
{
    // this solution from：https://leetcode.com/problems/next-permutation/discuss/13872/Easiest-JAVA-Solution
    public void nextPermutation(int[] nums) {
         if(nums == null || nums.length <= 1) return;
            int i = nums.length - 2;
            while(i >= 0 && nums[i] >= nums[i + 1]) i--; // Find 1st id i that breaks descending order
            if(i >= 0) {                           // If not entirely descending
                int j = nums.length - 1;              // Start from the end
                while(nums[j] <= nums[i]) j--;           // Find rightmost first larger id j
                swap(nums, i, j);                     // Switch i and j
            }
            reverse(nums, i + 1, nums.length - 1);       // Reverse the descending sequence
        }

        public void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

        public void reverse(int[] nums, int i, int j) {
            while(i < j) swap(nums, i++, j--);
        }
}
```


# Search in Rotated Sorted Array

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

- My Answer
```
package medium1;

import java.util.Arrays;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年2月20日
 */
public class SearchinRotatedSortedArray
{
    public static void main(String[] args)
    {
        
    }
    
    public static int search(int[] nums, int target) {
        if(nums.length==0)
            return -1;
        else if(nums.length==1)
            return nums[0]==target?0:-1;
        int ans=-1;
        int boudnaryIndex=findBoundary(nums);
        int min,max;
        if(boudnaryIndex==-1) {
            boudnaryIndex=nums.length-1;
            min=nums[0];max=nums[boudnaryIndex];
        }else {
            min=nums[boudnaryIndex+1];max=nums[boudnaryIndex];
        }
        
        if(target>=min && target<=max) {
            int leftMin=nums[0],rightMax=nums[nums.length-1];
            if(target>=leftMin) {
                ans=binarySearch(nums, target, 0, boudnaryIndex);
            }else if(target<=rightMax){
                ans=binarySearch(nums, target, boudnaryIndex+1, nums.length-1);
            }
        }
        return ans;
    }
    
    public static int findBoundary(int[] nums) {
        int index=-1;
        for(int i=0;i<nums.length-1;i++) {
            if(nums[i]>nums[i+1]) {
                index=i;
                break;
            }
        }
        
        return index;
    }
    
    public static int binarySearch(int[] nums,int target,int start,int end) {
        int middle=(start+end)/2;
        int index=-1;
        while(start<=end) {
            middle=(start+end)/2;
            if(nums[middle]>target) {
                end=middle-1;
            }else if(nums[middle]<target) {
                start=middle+1;
            }else {
                return middle;
            }
        }
        return index;
    }
}
```

# Search for a Range

Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
```
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
```

- My Answer
```
package medium1;

import java.util.Arrays;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年2月20日
 */
public class SearchforaRange
{
    public static void main(String[] args)
    {
        int nums[]= {1,2,3,6,8,45};
        System.out.println(binarySearch(nums, 0, nums.length-1, 3));
    }
    public int[] searchRange(int[] nums, int target) {
        int[] res= {-1,-1};
        int len=nums.length;
        if(len==0) {
            return res;
        }
        
        int firstIndex=binarySearch(nums, 0,len-1,target);
        if(firstIndex==-1) {
            return res;
        }
        res[0]=firstIndex;res[1]=firstIndex;
        if(firstIndex==0) {
            int temp=-1;
            while((temp=binarySearch(nums, temp+1, len-1, target))!=-1) {
                res[1]=temp;
            }
        }else if(firstIndex==len-1) {
            int temp=len;
            while((temp=binarySearch(nums, 0, temp-1, target))!=-1) {
                res[0]=temp;
            }
        }else {
            int temp1=len;
            while((temp1=binarySearch(nums, 0, temp1-1, target))!=-1) {
                res[0]=temp1;
            }
            int temp2=-1;
            while((temp2=binarySearch(nums, temp2+1, len-1, target))!=-1) {
                res[1]=temp2;
            }
        }
        return res;
    }
    
    public static int binarySearch(int nums[],int start,int end,int target) {
        int middle;
        int index=-1;
        while(end>=start) {
            middle=(start+end)/2;
            if(nums[middle]>target) {
                end=middle-1;
            }else if(nums[middle]<target){
                start=middle+1;
            }else {
                index=middle;
                break;
            }
        }
        return index;
    }
}
```


# Valid Sudoku

Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

![](http://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Sudoku-by-L2G-20050714.svg/250px-Sudoku-by-L2G-20050714.svg.png)

A partially filled sudoku which is valid.

Note:

A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.

- My Answer
```
package medium1;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年2月20日
 */
public class ValidSudoku
{
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++)
            for(int j=0;j<9;j++)
                if(board[i][j]!='.') {
                    int num=board[i][j];
                    // check same row
                    for(int temp=0;temp<9;temp++)
                        if(temp!=j)
                            if(board[i][temp]==num)
                                return false;
                        
                    // check same column 
                    for(int temp=0;temp<9;temp++)
                        if(temp!=i)
                            if(board[temp][j]==num)
                                return false;
                    
                    
                    // check same nine-block grid
                    int rowIndex=i/3,columnIndex=j/3;
                    for(int x=rowIndex*3;x<rowIndex*3+3;x++)
                        for(int y=columnIndex*3;y<columnIndex*3+3;y++)
                            if(!(x==i && y==j))
                                if(board[x][y]==num)
                                    return false;
                }
        return true;
    }
}
```

# Permutations

Given a collection of distinct numbers, return all possible permutations.

For example,
```
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
```

- My Answer
```
package medium1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年2月20日
 */
public class Permutations
{
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(nums.length==0)
            return res;
        else if(nums.length==1) {
            res.add(Arrays.asList(nums[0]));
        }
        else if(nums.length==2) {
            res.add(Arrays.asList(nums[0],nums[1]));
            res.add(Arrays.asList(nums[1],nums[0]));
        }else {
            for(List<Integer> list:permute(Arrays.copyOfRange(nums,0,nums.length-1))) {
                for(int i=0;i<=list.size();i++) {
                    List<Integer> temp=new ArrayList<Integer>();
                    temp.addAll(list);
                    temp.add(i,nums[nums.length-1]);
                    res.add(temp);
                }
            }
        }
             
            
        
        return res;
    }
}
```

# Combination Sum

Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
```
[
  [7],
  [2, 2, 3]
]
```

- My Answer
```
package medium1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年3月29日
 */
public class CombinationSum
{
    // backtrack problem
    // This answer from: https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
    
    //[2,3,6,7] 7
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        // start recursion
        backtrack(list, new ArrayList<>(), candidates, target, 0);
        // in recursion process, the list has been filled with correct answers
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        // end condition: if target is negative (namely, target less than minimum in nums, then no need to futher explore)
        if(remain < 0) return;
        // end condition: if target is zero, it means tempList has become a list of combination of target sum, so we add it to the answer list 
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        // recursion part:
        // iterate over each element: we know that the any resolutions in answer list must start with certain element in nums
        //                            so we just iterate over each element
        else{ 
            for(int i = start; i < nums.length; i++){
                tempList.add(nums[i]);
                // key code!!!: tempList remains unchanged, but target changes with the iteration element.
                backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                // for iteration starting from next element
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
```

# Rotate Image
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Note:

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Example 1:
```
Given input matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
```
Example 2:
```
Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
], 

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
```

- My Answer
```
package medium1;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年3月29日
 */
public class RotateImage
{
    // from outside to inside layer-wise
    public static void rotate(int[][] matrix) {
        int n=matrix.length;
        for(int layer=0;layer<n/2;layer++) {
                // rotate corner element first (avoid override)
                // store left top element first
                int temp=matrix[layer][layer];
                matrix[layer][layer]=matrix[n-1-layer][layer];
                matrix[n-1-layer][layer]=matrix[n-1-layer][n-1-layer];
                matrix[n-1-layer][n-1-layer]=matrix[layer][n-1-layer];
                matrix[layer][n-1-layer]=temp;
                // move non-corner element
                int edgeNum=n-layer*2-2;
                System.out.println("layer:"+layer+",edgenum:"+edgeNum);
                // store left down edge elements first
                int[] tempEdge=new int[edgeNum];
                for(int x=0;x<edgeNum;x++) {
                    tempEdge[x]=matrix[layer+x+1][layer];
                }
                for(int i=0;i<edgeNum;i++) {
                    matrix[layer+i+1][layer]=matrix[n-layer-1][layer+i+1];
                }
            for(int i=0;i<edgeNum;i++) {
                matrix[n-layer-1][layer+i+1]=matrix[n-layer-1-i-1][n-1-layer];              
            }
            for(int i=0;i<edgeNum;i++) {
                matrix[n-layer-1-i-1][n-layer-1]=matrix[layer][n-1-layer-i-1];
            }
            for(int i=0;i<edgeNum;i++) {
                matrix[layer][n-1-layer-i-1]=tempEdge[i];
            }
        }
    }
    
    public static void main(String[] args) {
//      1 2 3 4
//      5 6 7 8
//      9 10 11 12
//      13 14 15 16
//      
//      13 9  5 1
//      14 10 6 2
//      15 11 7 3
//      16 12 8 4
        int[][] matrix= {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        rotate(matrix);
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix.length;j++)
                System.out.print(matrix[i][j]+" ");
            System.out.println();
        }
        
    }
}
```

# Group Anagrams

Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:
```
[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
```
Note: All inputs will be in lower-case.

- My Answer
```
package medium1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年3月29日
 */
public class GroupAnagrams
{
     public List<List<String>> groupAnagrams(String[] strs) {
         List<List<String>> bigList=new ArrayList<List<String>>();
         Map<Map<Character,Integer>,List<String>> bigMap=new HashMap<>();
         for(String str:strs) {
             Map<Character, Integer> map=new HashMap<>();
             for(int i=0;i<str.length();i++) {
                 char c=str.charAt(i);
                 if(map.containsKey(c))
                     map.put(c, map.get(c)+1);
                 else
                     map.put(c, 1);
             }
            // tricks: since the map is unique for different anagrams,so we can use map as key in map, and let the value be the answer list element.
             if(bigMap.containsKey(map)) {
                bigMap.get(map).add(str);
             }
             else {
                 List<String> tempList=new ArrayList<>();
                 tempList.add(str);
                 bigList.add(tempList);
                 bigMap.put(map,tempList);
             }
         }
         return bigList;
     }
     
}
```

# Jump Game

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
```
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
```

- My Answer
```
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
```

# Merge Intervals

Given a collection of intervals, merge all overlapping intervals.

For example,
```
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
```

- My Answer
```
package medium1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年3月30日
 */
public class MergeIntervals
{
    public static List<Interval> merge(List<Interval> intervals) {
        // sort the intervals first, based on property 'start'.
        intervals.sort(new Comparator<Interval>()
        {
            @Override
            public int compare(Interval o1, Interval o2)
            {
                return o1.start-o2.start;
            }
        });
        
        List<Interval> list=new ArrayList<Interval>();
        boolean flag=true;
        while(flag) {
            flag=false;
            for(int i=0;i<intervals.size()-1;i++) {
                Interval int1=intervals.get(i),int2=intervals.get(i+1);
                if(checkOverlapping(int1, int2)) {
                    flag=true;
                    Interval newInt=new Interval(Math.min(int1.start, int2.start),Math.max(int1.end, int2.end));
                    intervals.remove(i);intervals.remove(i);
                    intervals.add(i,newInt);
                    break;
                }
            }
        }
        for(Interval temp:intervals)
            list.add(temp);
        return list;
    }
    
    public static boolean checkOverlapping(Interval interval1,Interval interval2) {
        int s1=interval1.start,e1=interval1.end,s2=interval2.start,e2=interval2.end;
        if(s1<=s2) {
            if(e1>=s2)
                return true;
        }else {
            if(e2>=s1)
                return true;
        }
        return false;
    }
    
    public static void main(String[] args)
    {
        Interval int1=new Interval(3,1),int2=new Interval(2,3),int3= new Interval(5,7);
        List<Interval> intervals=new ArrayList<Interval>();
        intervals.add(int1);intervals.add(int2);intervals.add(int3);
        merge(intervals);
    }
}



//Definition for an interval.
class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
}
```

# Unique Paths
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

![picture](https://leetcode.com/static/images/problemset/robot_maze.png)

Above is a 3 x 7 grid. How many possible unique paths are there?

Note: m and n will be at most 100.



- My Answer
```
package medium1;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年3月30日
 */
public class UniquePaths
{
    // DP problem: inverse thought
    public static int uniquePaths(int m, int n) {
        int[][] uniquePathsMatrix=new int[m][n];
        
        // far tight column and lowest row should all be 1
        for(int i=0;i<m;i++) uniquePathsMatrix[i][n-1]=1;
        for(int j=0;j<n;j++) uniquePathsMatrix[m-1][j]=1;
        // fill solutions into other squares
        for(int i=m-2;i>=0;i--) {
            for(int j=n-2;j>=0;j--) {
                uniquePathsMatrix[i][j]=uniquePathsMatrix[i][j+1]+uniquePathsMatrix[i+1][j];
            }
        }
        return uniquePathsMatrix[0][0];
    }
    
    public static void main(String[] args)
    {
        uniquePaths(2, 3);
    }
}
```

# Minimum Path Sum

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example 1:
```
[[1,3,1],
 [1,5,1],
 [4,2,1]]
```

Given the above grid map, return 7. Because the path 1→3→1→1→1 minimizes the sum.

-  My Answer
```
package medium1;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年3月30日
 */
public class MinimumPathSum
{
    public static int minPathSum(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int[][] minPathSumMatrix=new int[m][n];
        
        minPathSumMatrix[m-1][n-1]=grid[m-1][n-1];
        // fill right column and lowest row first
        for(int i=m-2;i>=0;i--) minPathSumMatrix[i][n-1]=minPathSumMatrix[i+1][n-1]+grid[i][n-1];
        for(int j=n-2;j>=0;j--) minPathSumMatrix[m-1][j]=minPathSumMatrix[m-1][j+1]+grid[m-1][j];
        
        for(int i=m-2;i>=0;i--) {
            for(int j=n-2;j>=0;j--) {
                int rightDistance=minPathSumMatrix[i][j+1],downDistance=minPathSumMatrix[i+1][j];
                minPathSumMatrix[i][j]=rightDistance>downDistance?grid[i][j]+downDistance:grid[i][j]+rightDistance;;
            }
        }
        
        return minPathSumMatrix[0][0];
    }
    
    public static void main(String[] args)
    {
        int[][] grid= {{1,2,3,4,5},{6,7,8,9,10}};
        minPathSum(grid);
    }
}
```

# Sort Colors

Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:

You are not suppose to use the library's sort function for this problem.

Follow up:

A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?


- My Answer
```
package medium1;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年3月30日
 */
public class SortColors
{
    //  this answer from: https://leetcode.com/problems/sort-colors/discuss/26472/Share-my-at-most-two-pass-constant-space-10-line-solution
    
    // thought: use low to represent the index of element after end 0, high to represent the index of element before start 2
    public void sortColors(int[] nums) {
       if(nums==null || nums.length<2) return;
       int low = 0; 
       int high = nums.length-1;
       for(int i = low; i<=high;) {
           if(nums[i]==0) {
              // swap nums[i] and nums[low] and i,low both ++
              int temp = nums[i];
              nums[i] = nums[low];
              nums[low]=temp;
              i++;low++;
           }else if(nums[i]==2) {
               //swap nums[i] and nums[high] and high--;
              int temp = nums[i];
              nums[i] = nums[high];
              nums[high]=temp;
              high--;
           }else {
               i++;
           }
       }
    }
}
```

# Subsets

Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:
```
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
```

- My Answer
```
package medium1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年4月2日
 */
public class Subsets
{
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> bigList=new ArrayList<List<Integer>>();
        int len=nums.length;
        if(len==0) {
            bigList.add(new ArrayList<>());
            return bigList;
        }else if(len==1){
            bigList.add(new ArrayList<>());
            bigList.add(Arrays.asList(nums[0]));
        }else {
            List<List<Integer>> subsetAnswer=subsets(Arrays.copyOfRange(nums,1,len));
            for(List<Integer> list:subsetAnswer){
                List<Integer> temp1=new ArrayList<Integer>(Arrays.asList(new Integer[list.size()])),temp2=new ArrayList<Integer>(Arrays.asList(new Integer[list.size()]));
                Collections.copy(temp1,list);
                bigList.add(temp1);
                
                Collections.copy(temp2,temp1);
                temp2.add(nums[0]);
                bigList.add(temp2);
            }
        }
        
        return bigList;
    }
}
```

# Word Search

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =
```
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
```

word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.

- My Answer
```
package medium1;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年4月3日
 */
//[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
//"ABCCED"
//[["A","B","C"],["D","E","F"],["G","H","I"]]
//"DGHIA"
//[["a","a"]]
//"aaa"
//[["C","A","A"],["A","A","A"],["B","C","D"]]
//"AAB"

public class WordSearch
{   
    public boolean exist(char[][] board, String word) {
        if(word.equals(""))
            return true;
        
        int m=board.length,n=board[0].length;
        
        char startLetter=word.charAt(0);
        // try finding the first letter first
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(board[i][j]==startLetter) {
                    if(exist(board, word, i, j))
                        return true;
                }
            }
        }
        return false;
    }
    
    public boolean exist(char[][] board, String word,int x,int y) {
        if(word.equals(""))
            return true;
        
        char goal=word.charAt(0);
        // array out of index boundary
        if(x<0 || y<0 || x>=board.length || y>=board[0].length || board[x][y]!=goal)
            return false;
        
        board[x][y]^=256;
        boolean result=exist(board,word.substring(1),x-1,y) || exist(board,word.substring(1),x+1,y) || exist(board,word.substring(1),x,y-1) || exist(board,word.substring(1),x,y+1);
        board[x][y]^=256;
        return result;
    }

}
```

# Binary Tree Inorder Traversal

Given a binary tree, return the inorder traversal of its nodes' values.

For example:

Given binary tree [1,null,2,3],
```
   1
    \
     2
    /
   3
```

return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?

**attention: I still do it in recursively, and iterative method remains to be explored**

- My Answer
```
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<Integer>();
        
        if(root==null) return list;
        else{
            list.addAll(inorderTraversal(root.left));
            list.add(root.val);
            list.addAll(inorderTraversal(root.right));
        }
        return list;
    }
}
```

# Unique Binary Search Trees

Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.
```
   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
```

- My Answer
```
package medium1;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年4月11日
 */
public class UniqueBinarySearchTrees
{
    // this answer from:https://leetcode.com/problems/unique-binary-search-trees/discuss/31666/DP-Solution-in-6-lines-with-explanation.-F(i-n)-G(i-1)-*-G(n-i)
    // thought: all nodes can be root, so we can sum up all cases by assigning each node to be root.
    // using Dynamic Programming.
    public int numTrees(int n) {
        int numTrees[]=new int[n+1];
        numTrees[0]=1;numTrees[1]=1;
        for(int i=2;i<=n;i++) {
            for(int j=1;j<=i;j++) {
                numTrees[i]+=numTrees[j-1]*numTrees[i-j];
            }
        }
        return numTrees[n];
    }
}
```

# Validate Binary Search Tree

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:
```
    2
   / \
  1   3
```
Binary tree [2,1,3], return true.
```
Example 2:
    1
   / \
  2   3
```
Binary tree [1,2,3], return false.

- My Answer
```
package medium1;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年4月11日
 */
public class ValidateBinarySearchTree
{
    // First validate whether left sub node's val is smaller than root val and right sub node's val is greater than root val
    // Besides! validate that all node vals in left sub trees are smaller that root val and all node vals in right sub trees are greater than root val.
    public boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;
        
        if(root.left==null && root.right==null)
            return true;
        
        int leftMax=findMaxValInBST(root.left, Integer.MIN_VALUE),rightMin=findMinValInBST(root.right, Integer.MAX_VALUE);
        if(root.val!=Integer.MIN_VALUE) {
            if(leftMax>=root.val)
                return false;
        }
        if(root.val!=Integer.MAX_VALUE) {
            if(rightMin<=root.val)
                return false;
        }
        
        if(root.left!=null && root.right==null)
            return root.left.val<root.val && isValidBST(root.left);
        if(root.left==null && root.right!=null)
            return root.right.val>root.val && isValidBST(root.right);
        
        return root.left.val<root.val && root.right.val>root.val && isValidBST(root.left)  && isValidBST(root.right);
        
    }
    
    public int findMaxValInBST(TreeNode root,int maxVal) {
        if(root==null)
            return maxVal;
        
        if(root.val>maxVal)
            maxVal=root.val;

        int leftMax=findMaxValInBST(root.left, maxVal),rightMax=findMaxValInBST(root.right, maxVal);
        
        return leftMax>rightMax?leftMax:rightMax;
    }
    
    public int findMinValInBST(TreeNode root,int minVal) {
        if(root==null)
            return minVal;
        
        if(root.val<minVal)
            minVal=root.val;

        int leftMin=findMinValInBST(root.left, minVal),rightMin=findMinValInBST(root.right, minVal);
        
        return leftMin<rightMin?leftMin:rightMin;
    }
}
```

# Binary Tree Level Order Traversal

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
```
    3
   / \
  9  20
    /  \
   15   7
```
return its level order traversal as:
```
[
  [3],
  [9,20],
  [15,7]
]
```

- My Answer
```
package medium1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年4月12日
 */
public class BinaryTreeLevelOrderTraversal
{
    // Using a queue to store same nodes in the next level, and poll them out one by one inserting their value into list simultaneously.
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        ArrayDeque<TreeNode> queue=new ArrayDeque<>();
        if(root==null)  return ans;
        
        queue.add(root);
        ans.add(Arrays.asList(root.val));
        
        
        
        while(!queue.isEmpty()) {
                List<Integer> list=new ArrayList<>();
                ArrayDeque<TreeNode> tempQueue=new ArrayDeque<>();
                while(!queue.isEmpty()) {
                    TreeNode temp=queue.poll();
                    if(temp.left!=null) {
                        tempQueue.add(temp.left);
                        list.add(temp.left.val);
                    }
                    if(temp.right!=null) {
                        tempQueue.add(temp.right);
                        list.add(temp.right.val);
                    }
                }
                
                while(!tempQueue.isEmpty())
                    queue.add(tempQueue.poll());
                
                if(!list.isEmpty())
                    ans.add(list);
        }
        
        return ans;
    }
}
```

# Construct Binary Tree from Preorder and Inorder Traversal

Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given
```
preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
```
Return the following binary tree:
```
    3
   / \
  9  20
    /  \
   15   7
```

- My Answer
```
package medium1;

import java.util.Arrays;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年4月13日
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal
{
    
    // classical recursive problem
    // notice: any two kinds of binary tree traversal can help construct a unique binary tree (including the left one kind of traversal).  
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0)
            return null;
        
        TreeNode root=new TreeNode(preorder[0]);
        
        if(preorder.length==1)
            return root;
        
        int leftSubTreeNodeNums=-1;
        
        for(int i=0;i<inorder.length;i++)
            if(inorder[i]==root.val) {
                leftSubTreeNodeNums=i;
                break;
            }
        
        root.left=buildTree(Arrays.copyOfRange(preorder, 1, leftSubTreeNodeNums+1), Arrays.copyOfRange(inorder,0,leftSubTreeNodeNums));
        root.right=buildTree(Arrays.copyOfRange(preorder, leftSubTreeNodeNums+1, preorder.length), Arrays.copyOfRange(inorder,leftSubTreeNodeNums+1,inorder.length));
        
        return root;
    }
}
```

# Flatten Binary Tree to Linked List

Given a binary tree, flatten it to a linked list in-place.

For example,

Given
```
         1
        / \
       2   5
      / \   \
     3   4   6
```

The flattened tree should look like:
```
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
```

Hints:

If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.

- My Answer
```
package medium1;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年4月13日
 */
public class FlattenBinaryTreetoLinkedList
{
    // Recursive Method
    // Switch left sub tree to right, and assign root.left to null
    // then store original right tree in variable [temp], and invoke flatten(root.right), finally put temp to right sub tree's right, and flatten it. 
    public void flatten(TreeNode root) {
        if(root==null || (root.left==null && root.right==null))
            return;
        
        TreeNode temp=root.right;
        root.right=root.left;
        root.left=null;
        
        flatten(root.right);
        
        TreeNode rightestNode=root;
        
        while(rightestNode.right!=null)
            rightestNode=rightestNode.right;
        
        rightestNode.right=temp;
        
        flatten(temp);
    }
}
```

# Word Break

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.

For example, given
```
s = "leetcode",
dict = ["leet", "code"].
```

Return true because "leetcode" can be segmented as "leet code".

UPDATE (2017/1/4):

The wordDict parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.

- My Answer
```
package medium1;

import java.util.List;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年4月13日
 */
public class WordBreak
{
    // this answer from: https://leetcode.com/problems/word-break/discuss/43790/Java-implementation-using-DP-in-two-ways
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] f=new boolean[s.length()+1];
        f[0]=true;
        
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(f[j] && wordDict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }
        
        return f[s.length()];
    }
}
```

# Linked List Cycle II

Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:

Can you solve it without using extra space?

- My Answer
```
package medium1;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年4月16日
 */
/*
Thought:
For a linked list cycle like below:
111111111
      1 1
      111
a denotes the length before the cycle, 
b denotes the length Slow has walked through measuring from the start of the cycle when it first encounter Fast,
c denotes the total length of circle decreasing b

So, when Slow and Fast meet for the first time:

Slow walks through: a+b
Fast walks through: a+n*(b+c)+b (n=1,2,3,...)

Because Fast walks two times as fast as Slow,so:

a+2b+c=2(a+b) -> a=c

So when Slow and Fast meet, then we can start a pointer from the start of the linked list again, and let it and Slow started walking ahead simultaneously until they meet, then the meeting point must be the start of the cycle.

*/
public class LinkedListCycleII
{
    public ListNode detectCycle(ListNode head) {
        // without extra space
        ListNode slow=head,fast=head;
        while(fast!=null && fast.next!=null) {
            fast=fast.next.next;
            slow=slow.next;
            
            if(slow==fast) {
                ListNode slow2=head;
                while(slow!=slow2) {
                    slow=slow.next;
                    slow2=slow2.next;
                }
                return slow;
            }
        }
        return null;
        
        // with extra space
//      Set<ListNode> set=new HashSet<>();
//      while(head!=null) {
//          if(set.contains(head))
//              return head;
//          else
//              set.add(head);
//          head=head.next;
//      }
//        return null;
    }
}
```

# Sort List

Sort a linked list in O(n log n) time using constant space complexity.

- My Answer
```
package medium1;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年4月20日
 */


public class SortList
{
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        
        // Learn a clever way to find the half point of a linked list.
        ListNode slow=head,fast=head,middle=null;
        
        while(fast!=null && fast.next!=null) {
            fast=fast.next.next;
            slow=slow.next;
        }
        
        middle=slow.next;
        // only two nodes in the list
        if(middle==null) {
            middle=slow;
            head.next=null;
        }else {
            slow.next=null;
        }
        
        ListNode l1=sortList(head),l2=sortList(middle);
        
        head=merge(l1, l2);

        return head;
    }
    
    public ListNode merge(ListNode l1,ListNode l2) {
        if(l1==l2)
            return l1;
        
        ListNode head=null,pointer=null;
        
        while(l1!=null && l2!=null) {
            if(head==null) {
                if(l1.val<l2.val) {
                    head=l1;
                    pointer=l1;
                    l1=l1.next;
                }
                else {
                    head=l2;
                    pointer=l2;
                    l2=l2.next;
                }
            }else {
                if(l1.val<l2.val) {
                    pointer.next=l1;
                    l1=l1.next;
                    pointer=pointer.next;
                }
                else {
                    pointer.next=l2;
                    l2=l2.next;
                    pointer=pointer.next;
                }
            }
        }
        
        while(l1!=null) {
            pointer.next=l1;
            pointer=pointer.next;
            l1=l1.next;
        }
        
        while(l2!=null) {
            pointer.next=l2;
            pointer=pointer.next;
            l2=l2.next;
        }
        
        // important, or linked list may be a mess
        pointer.next=null;
        
        return head;
    }
}
```

# Maximum Product Subarray

Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.

- My Answer
```
package medium1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年4月21日
 */
public class MaximumProductSubarray
{
    // find negative number and zeros and mark out their indices, pay attention to them
    // two negative numbers together can be regarded as a positive number
    public int maxProduct(int[] nums) {
        if(nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
    
        List<Integer> negaNumIndicesList=new ArrayList<>(),zeroIndicesList=new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
            if(nums[i]==0)
                zeroIndicesList.add(i);
            else if(nums[i]<0)
                negaNumIndicesList.add(i);
        }
        
     // split the whole array by 0, and test each 
        if(zeroIndicesList.isEmpty()) {
            // the subarray that has the maximum product is the whole array
            if(negaNumIndicesList.size()%2==0) {
                return getProductofSubarray(nums, 0, nums.length);
            }else {
                int firstNegaIndex=negaNumIndicesList.get(0),lastNegaIndex=negaNumIndicesList.get(negaNumIndicesList.size()-1);
                int left=getProductofSubarray(nums,0,lastNegaIndex-1),right=getProductofSubarray(nums,firstNegaIndex+1,nums.length-1);
                return left>right?left:right;
            }
        }
        else {
            int firstZeroIndex=zeroIndicesList.get(0);
            int left=maxProduct(Arrays.copyOfRange(nums,0,firstZeroIndex)),right=maxProduct(Arrays.copyOfRange(nums, firstZeroIndex+1,nums.length));
            if(left<0 && right<0)
                return 0;
            else
                return left>right?left:right;
        }
    }
    
    public int getProductofSubarray(int[] nums,int start,int end) {
        if(start>end)
            return 0;
        int res=1;
        for(int i=start;i<=end && i<nums.length;i++) {
            res*=nums[i];
        }
        return res;
    }
}
```

# Number of Islands

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:
```
11110
11010
11000
00000
```
Answer: 1

Example 2:
```
11000
11000
00100
00011
```
Answer: 3

- My Answer
```
package medium1;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年4月22日
 */
public class NumberofIslands
{
    public int numIslands(char[][] grid) {
        int ans=0;
        if(grid.length==0)
            return 0;
        boolean[][] searchedLand=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(searchedLand[i][j]==false) {
                    searchedLand[i][j]=true;
                    char current=grid[i][j];
                    if(current=='1') {
                        ans++;
                        // set searched cell to true
                        furtherSearchLand(grid, searchedLand, i+1, j);
                        furtherSearchLand(grid, searchedLand, i, j+1);
                    }
                }
            }
        }
        return ans;
    }
    
    // Recursively mark the consecutive neighbor '1'
    public void furtherSearchLand(char[][] grid,boolean[][] searchedLand,int i,int j) {
        if(i<grid.length && j<grid[0].length) {
            searchedLand[i][j]=true;
            if(grid[i][j]=='1') {
                if(i+1<grid.length && searchedLand[i+1][j]==false)
                    furtherSearchLand(grid, searchedLand, i+1, j);
                if(i-1>=0 && searchedLand[i-1][j]==false)
                    furtherSearchLand(grid, searchedLand, i-1, j);
                if(j+1<grid[0].length && searchedLand[i][j+1]==false)
                    furtherSearchLand(grid, searchedLand, i, j+1);
                if(j-1>=0 && searchedLand[i][j-1]==false)
                    furtherSearchLand(grid, searchedLand, i, j-1);
            }
        }
    }
}
```

# Course Schedule

There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

For example:
```
2, [[1,0]]
```
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
```
2, [[1,0],[0,1]]
```
There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

Note:

1.The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.

2.You may assume that there are no duplicate edges in the input prerequisites.
click to show more hints.

Hints:

1.This problem is equivalent to finding if a cycle exists in a directed graph. If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.

2.Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.

3.Topological sort could also be done via BFS.

- My Answer
```
package medium1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年4月22日
 */
public class CourseSchedule
{
//  This solution from: https://leetcode.com/problems/course-schedule/discuss/58524/Java-DFS-and-BFS-solution
    //BFS
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<Integer>();
        int count=0;
        
        for(int i=0;i<numCourses;i++)
            graph[i] = new ArrayList<Integer>();
            
        for(int i=0; i<prerequisites.length;i++){
            degree[prerequisites[i][1]]++;
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        for(int i=0; i<degree.length;i++){
            if(degree[i] == 0){
                queue.add(i);
                count++;
            }
        }
        
        while(queue.size() != 0){
            int course = (int)queue.poll();
            for(int i=0; i<graph[course].size();i++){
                int pointer = (int)graph[course].get(i);
                degree[pointer]--;
                if(degree[pointer] == 0){
                    queue.add(pointer);
                    count++;
                }
            }
        }
        if(count == numCourses)
            return true;
        else    
            return false;
    }
    
    // DFS
//   public boolean canFinish(int numCourses, int[][] prerequisites) {
//         ArrayList<Integer>[] graph = new ArrayList[numCourses];
//         for(int i=0;i<numCourses;i++)
//             graph[i] = new ArrayList();
//             
//         boolean[] visited = new boolean[numCourses];
//         for(int i=0; i<prerequisites.length;i++){
//             graph[prerequisites[i][1]].add(prerequisites[i][0]);
//         }
//
//         for(int i=0; i<numCourses; i++){
//             if(!dfs(graph,visited,i))
//                 return false;
//         }
//         return true;
//     }
//
//     private boolean dfs(ArrayList[] graph, boolean[] visited, int course){
//         if(visited[course])
//             return false;
//         else
//             visited[course] = true;;
//
//         for(int i=0; i<graph[course].size();i++){
//             if(!dfs(graph,visited,(int)graph[course].get(i)))
//                 return false;
//         }
//         visited[course] = false;
//         return true;
//     }
}

```

#  Implement Trie (Prefix Tree)

Implement a trie with insert, search, and startsWith methods.

Note:

You may assume that all inputs are consist of lowercase letters a-z.

- My Answer
```
package medium1;

import java.util.HashMap;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年5月2日
 */
public class Trie
{
    TrieNode root;
     /** Initialize your data structure here. */
    public Trie() {
        root=new TrieNode();
        root.children=new HashMap<>();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node=root;
        for(int i=0;i<word.length();i++) {
            char c=word.charAt(i);
            if(node.children==null)
                node.children=new HashMap<>();

            if(node.children.containsKey(c)) {
                node=node.children.get(c);
            }else {
                TrieNode temp=new TrieNode();
                temp.children=new HashMap<>();
                node.children.put(c, temp);
                node=temp;
            }
        }
        node.value=word;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node=root;
        for(int i=0;i<word.length();i++) {
            char c=word.charAt(i);
            if(node.children.get(c)!=null) {
                node=node.children.get(c);
            }else
                return false;
        }
        
        // this node is not a leaf node, i.e. a word
        if(node.value==null)
            return false;
        else
            return true;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node=root;
        for(int i=0;i<prefix.length();i++) {
            char c=prefix.charAt(i);
            if(node.children.get(c)!=null) {
                node=node.children.get(c);
            }else
                return false;
        }
        return true;
    }
}

class TrieNode
{
    public String value;
    public HashMap<Character,TrieNode> children;
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
```

# Kth Largest Element in an Array

Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:
```
Input: [3,2,1,5,6,4] and k = 2
Output: 5
```
Example 2:
```
Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4
```
Note: 

You may assume k is always valid, 1 ≤ k ≤ array's length.


- My Answer
```
package medium1;

import java.util.Arrays;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年5月3日
 */
public class KthLargestElementinanArray
{
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
```

# Maximal Square

Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:
```
Input: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4
```

- My Answer
```
package medium1;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年5月3日
 */
public class MaximalSquare
{
    public int maximalSquare(char[][] matrix) {
        int answer=Integer.MIN_VALUE;
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                char c=matrix[i][j];
                if(c=='1') {
                    int temp=detectSquare(matrix, i, j);
                    if(temp>answer)
                        answer=temp;
                }
            }
        }
        return answer*answer;
    }
    
    /** 
     * @param matrix
     * @param i
     * @param j
     * @return the edge length of detected square, if no square, return 0.
     */
    public int detectSquare(char[][] matrix,int i,int j) {
        int edgeLen=1;
        for(int x=1;;x++) {
            if(i+x<matrix.length && j+x<matrix[0].length) {
                for(int a=0;a<x+1;a++) {
                    if(matrix[i+x][j+a]!='1' || matrix[i+a][j+x]!='1')
                        return edgeLen;
                }
                edgeLen+=1;
            }else
                break;
        }
        return edgeLen;
    }
}
```

# Lowest Common Ancestor of a Binary Tree

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”
```
        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
```
For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

- My Answer
```
package medium1;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年5月4日
 */
public class LowestCommonAncestorofaBinaryTree
{
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(inSubTree(p, q)){
            return p;
        }else if(inSubTree(q, p)) {
            return q;
        }else {
            TreeNode temp=root;
            if(inSubTree(temp.left, p) && inSubTree(temp.left, q)) {
                temp=temp.left;
                return lowestCommonAncestor(temp, p, q);
            }else if (inSubTree(temp.right, p) && inSubTree(temp.right, q))
            {
                temp=temp.right;
                return lowestCommonAncestor(temp, p, q);
            }else if (inSubTree(temp.left, p) && inSubTree(temp.right, q)) {
                return root;
            }else if (inSubTree(temp.right, p) && inSubTree(temp.left, q)) {
                return root;
            }
                
            return null;
        }
    }
    
    public static boolean inSubTree(TreeNode root,TreeNode node) {
        if(root!=null) {
            if(root==node) {
                return true;
            }else {
                return inSubTree(root.left, node) || inSubTree(root.right,node);
            }
        }else {
            return false;
        }
    }
    //stack overflow solution: too many recursive
//  public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//      List<TreeNode> listP=getPathToNode(root, p),listQ=getPathToNode(root, q);
//      for(int i=listP.size()-1;i>=0;i--) {
//          TreeNode temp=listP.get(i);
//          if(listQ.contains(temp))
//              return temp;
//      }
//      return null;
//    }
//  
//  public static List<TreeNode> getPathToNode(TreeNode root,TreeNode des) {
//      List<TreeNode> list=new ArrayList<>();
//      
//      if(root!=null) {
//          list.add(root);
//          List<TreeNode> left=getPathToNode(root.left, des),right=getPathToNode(root.right, des);
//          // no sub node
//          if(!left.isEmpty() && left.get(left.size()-1)==des)
//              list.addAll(left);
//          else
//              list.addAll(right);
//      }else {
//          return list;
//      }
//      
//      return list;
//  }
    
    public static void main(String[] args)
    {
        TreeNode root=new TreeNode(1);
        TreeNode left1=new TreeNode(2),left2=new TreeNode(3);
        TreeNode right1=new TreeNode(4);
        root.left=left1;left1.left=left2;
        root.right=right1;
        System.out.println(lowestCommonAncestor(root, right1, right1).val);
    }
}
```

# Product of Array Except Self

Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:

Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)

- My Answer
```
package medium1;

import java.util.Arrays;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年5月4日
 */
public class ProductofArrayExceptSelf
{
     public int[] productExceptSelf(int[] nums) {
         int len=nums.length;
         
         int[] res=new int[len];
         
         if(len==1) {
             nums[0]=1;
             return nums;
         }
         else if(len==2) {
             int temp=nums[0];
             nums[0]=nums[1];
             nums[1]=temp;
             return nums;
         }else{
             int[] arr1=Arrays.copyOfRange(nums, 0,len/2),arr2=Arrays.copyOfRange(nums, len/2,len);
             
             arr1=productExceptSelf(arr1);
             arr2=productExceptSelf(arr2);
             int leftProduct=nums[0]*arr1[0];
             int rightProduct=nums[len/2]*arr2[0];
             System.out.println("left:"+leftProduct+",right:"+rightProduct);
             
             
             
             //multiply each element in one side by the product of the other side
             for(int i=0;i<arr1.length;i++) {
                 arr1[i]*=rightProduct;
                 res[i]=arr1[i];
             }
             for(int i=0;i<arr2.length;i++) {
                 arr2[i]*=leftProduct;
                 res[arr1.length+i]=arr2[i];
             }
         }
         
         return res;
         
     }
}
```

# Search a 2D Matrix II

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
For example,

Consider the following matrix:
```
[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
```
Given target = 5, return true.

Given target = 20, return false.

- My Answer
```
package medium1;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年5月5日
 */
public class Searcha2DMatrixII
{
     public boolean searchMatrix(int[][] matrix, int target) {
         int i=matrix.length-1,j=0;
         while(i>=0 && j<matrix[0].length) {
             if(matrix[i][j]==target)
                 return true;
             else if(matrix[i][j]>target)
                 i--;
             else
                 j++;
         }
         return false;
     }
}
```

# Perfect Squares

Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.

- My Answer
```
package medium1;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年5月5日
 */
public class PerfectSquares
{
    // dynamic programming
    public int numSquares(int n) {
        int[] arr=new int[n+1];
        for(int i=0;i<n+1;i++)
            arr[i]=Integer.MAX_VALUE;
        arr[0]=0;
        arr[1]=1;
        for(int i=1;i<n+1;i++) {
            for(int j=1;j*j<=i;j++) {
                if(arr[i-j*j]+1<arr[i])
                    arr[i]=arr[i-j*j]+1;
            }
        }
        return arr[n];
    }
}
```

# Find the Duplicate Number

Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Note:

- You must not modify the array (assume the array is read only).
- You must use only constant, O(1) extra space.
- Your runtime complexity should be less than O(n2).
- There is only one duplicate number in the array, but it could be repeated more than once.

- My Answer
```
package medium1;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年5月5日
 */
public class FindtheDuplicateNumber
{
    public int findDuplicate(int[] nums) {
        for(int i=0;i<nums.length;i++) {
            for(int j=i+1;j<nums.length;j++) {
                if(nums[i]==nums[j])
                    return nums[i];
            }
        }
        return -1;
    }
    
}
```

# 
