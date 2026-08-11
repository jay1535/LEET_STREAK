class Solution {
    public int maxSubArray(int[] nums) {
     int max =0;
     int res =nums[0];
     for(int i =0; i< nums.length; i++){
        max+= nums[i];
        res = Math.max(max, res);
        if(max <0) max =0;
     }
     return res;
    }
}