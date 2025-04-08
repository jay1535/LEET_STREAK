//Solution

class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int i = n-1; i>=0; i--){
            if(set.contains(nums[i])){
               return (i+3)/3;

            }
            set.add(nums[i]);
        }
        return 0;
    }
}


/*

Example 1:
Input: nums = [1,2,3,4,2,3,3,5,7]
Output: 2
Explanation:
In the first operation, the first 3 elements are removed, resulting in the array [4, 2, 3, 3, 5, 7].
In the second operation, the next 3 elements are removed, resulting in the array [3, 5, 7], which has distinct elements.
Therefore, the answer is 2.

Example 2:
Input: nums = [4,5,6,4,4]
Output: 2
Explanation:
In the first operation, the first 3 elements are removed, resulting in the array [4, 4].
In the second operation, all remaining elements are removed, resulting in an empty array.
Therefore, the answer is 2.

Example 3:
Input: nums = [6,7,8,9]
Output: 0
Explanation:
The array already contains distinct elements. Therefore, the answer is 0.

*/
