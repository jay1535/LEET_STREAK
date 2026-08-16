class Solution {
   
    public int subarraysDivByK(int[] nums, int k) {
        int res = 0;
        // freqMap[r] = count of prefixes seen so far with remainder r
        int[] freqMap = new int[k];
        freqMap[0] = 1; // empty prefix, handles subarrays starting at index 0
        int curSum = 0;
        for (int num : nums) {
            curSum += num;
            // normalize remainder into [0, k-1] since Java's % can return negatives
            int r = ((curSum % k) + k) % k;
            res += freqMap[r];
            freqMap[r]++;
        }
        return res;
    }
}