class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) seen.add(num);
        for (int i = k; i < 1000; i += k)
            if (!seen.contains(i))
                return i;
        return k;
    }
}