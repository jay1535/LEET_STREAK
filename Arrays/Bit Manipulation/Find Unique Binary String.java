//Solution

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        int[] base10 = new int[n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n;j++)
                base10[i] = (base10[i] << 1) | (nums[i].charAt(j) == '1' ? 1 : 0);
        int counter = 0;
        while(isInArr(counter++, base10));
        return numToString(counter-1,n);   
    }
    public boolean isInArr(int num, int[] nums){
        for(int i = 0; i < nums.length; i++)
            if(nums[i] == num)
                return true;
        return false;
    }
    public String numToString(int num, int len){
        StringBuilder sb = new StringBuilder(len);
        for(int i = len-1; i >= 0; i--)
            sb.append((char)(((num >>> i) & 1) + 48));
        return sb.toString();
    }
}


/*

Example 1:
Input: nums = ["01","10"]
Output: "11"
Explanation: "11" does not appear in nums. "00" would also be correct.

Example 2:
Input: nums = ["00","01"]
Output: "11"
Explanation: "11" does not appear in nums. "10" would also be correct.

Example 3:
Input: nums = ["111","011","001"]
Output: "101"
Explanation: "101" does not appear in nums. "000", "010", "100", and "110" would also be correct.

*/
