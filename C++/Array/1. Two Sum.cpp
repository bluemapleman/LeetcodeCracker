/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/


class Solution {
public:
    // step 1: begin at index of left, iterate variable left toward right to find an element such that: 
    //           nums[left]+nums[right]>=target;
    //        if(left+right==target) return index of left and right;
    //         else  begin at index of right, iterate variable right toward left to find an element such that:
    //           nums[left]+nums[right]>=target;
    // step 2: repeat step1;

    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> ans;

        if(nums.size()==0)
            return ans;

        int left=0,right=nums.size()-1;
        cout<<"----------"<<endl;
        while(right>left){
            cout<<"left:"<<left<<",right:"<<right<<endl;
            cout<<"vec[4]:"<<vec[5]<<endl;
            for(;left<nums.size();left++){
                if(nums[left]+nums[right]==target){
                    ans.push_back(left);
                    ans.push_back(right);
                    return ans;
                }else if(nums[left]+nums[right]>target){
                    break;
                }
            }

            for(;right>=0;right--){
                if(nums[left]+nums[right]==target){
                    ans.push_back(left);
                    ans.push_back(right);
                    return ans;
                }else if(nums[left]+nums[right]<target){
                    break;
                }
            }
        }

        return ans;
    }
};