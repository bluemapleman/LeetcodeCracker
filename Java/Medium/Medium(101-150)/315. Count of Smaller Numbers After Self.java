
/*
You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

Example:

Input: [5,2,6,1]
Output: [2,1,1,0] 
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.
*/
class Solution {
    // iterate from right to left
    // for each new element, compare it with elements to the right of it in order of big nubmer to little number
    // (use a list to store elements to the right)
    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        // let big number comes out first
        List<Integer> rightEleList=new ArrayList<>();
 
//        O(n)
        for(int i=nums.length-1;i>=0;i--) {
            int ele=nums[i];
            
            // count elements that are greater than ele
            int count=0;

//          O(n)
            for(int j=0;j<rightEleList.size();j++){
                int temp=rightEleList.get(j);
                if(ele>temp) {
                    ans.add(0,ans.size()-count);
                    break;
                }
                count++;
            }
            // no right elements greater than ele
            if(count==rightEleList.size())
                ans.add(0,0);
            
            rightEleList.add(count,ele);
        }
        
        return ans;
    }
}