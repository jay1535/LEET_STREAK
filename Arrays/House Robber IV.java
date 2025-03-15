//Solution

class Solution {
    public int minCapability(int[] a, int k) {
        int n = a.length;
        int lo = Integer.MAX_VALUE;

        for(int  x: a) lo = Math.min(lo, x);
        int hi = 0;
        for(int x: a) hi = Math.max(hi, x);

        int ans = 0;
        while(hi >= lo){
            int mid = (lo + hi) / 2;
            int max = 0;

            for(int i = 0; i < n ;i++){
                if(a[i] <= mid){
                    i++;
                    max++;
                }
            }

            if(max >= k){
                hi = mid - 1;
                ans = mid;
            }
            else lo = mid + 1;
        }
        return ans;       
    }
}

/*

Example 1:
Input: nums = [2,3,5,9], k = 2
Output: 5
Explanation: 
There are three ways to rob at least 2 houses:
- Rob the houses at indices 0 and 2. Capability is max(nums[0], nums[2]) = 5.
- Rob the houses at indices 0 and 3. Capability is max(nums[0], nums[3]) = 9.
- Rob the houses at indices 1 and 3. Capability is max(nums[1], nums[3]) = 9.
Therefore, we return min(5, 9, 9) = 5.

Example 2:
Input: nums = [2,7,9,3,1], k = 2
Output: 2
Explanation: There are 7 ways to rob the houses. The way which leads to minimum capability is to rob the house at index 0 and 4. Return max(nums[0], nums[4]) = 2.

*/
