//Solution

class Solution {
    public int maximumCount(int[] nums) {
               int n=nums.length;
               int neg=0;
               int zero=0;
               for(int i=0;i<nums.length;i++){
                if(nums[i]<0){
                    neg++;;
                }
                else if(nums[i]==0){
                    zero++;
                }
                if(nums[i]>0){
                    break;
                }
               }
               return Math.max(neg,n-(neg+zero));
    }
}

/*

Example 1:
Input: nums = [-2,-1,-1,1,2,3]
Output: 3
Explanation: There are 3 positive integers and 3 negative integers. The maximum count among them is 3.

Example 2:
Input: nums = [-3,-2,-1,0,0,1,2]
Output: 3
Explanation: There are 2 positive integers and 3 negative integers. The maximum count among them is 3.

Example 3:
Input: nums = [5,20,66,1314]
Output: 4
Explanation: There are 4 positive integers and 0 negative integers. The maximum count among them is 4.

*/
