//Solution

class Solution {
    public int minimumIndex(List<Integer> nums) {
        int dominant = findDominantElement(nums);
        if (dominant == -1) return -1;

        int leftCount = 0, totalDominantCount = 0;
        for (int num : nums) {
            if (num == dominant) {
                totalDominantCount++;
            }
        }

        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) == dominant) {
                leftCount++;
            }

            int leftSubarrayCount = leftCount;
            int rightSubarrayCount = totalDominantCount - leftCount;

            if (leftSubarrayCount > (i + 1) / 2 && 
                rightSubarrayCount > (nums.size() - i - 1) / 2) {
                return i;
            }
        }

        return -1;
    }

    int findDominantElement(List<Integer> arr) {
        int candidate = -1, count = 0;

       
        for (int num : arr) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        int totalCount = 0;
        for (int num : arr) {
            if (num == candidate) {
                totalCount++;
            }
        }

        return (totalCount > arr.size() / 2) ? candidate : -1;
    }
}

/*

Example 1:
Input: nums = [1,2,2,2]
Output: 2
Explanation: We can split the array at index 2 to obtain arrays [1,2,2] and [2]. 
In array [1,2,2], element 2 is dominant since it occurs twice in the array and 2 * 2 > 3. 
In array [2], element 2 is dominant since it occurs once in the array and 1 * 2 > 1.
Both [1,2,2] and [2] have the same dominant element as nums, so this is a valid split. 
It can be shown that index 2 is the minimum index of a valid split. 

Example 2:
Input: nums = [2,1,3,1,1,1,7,1,2,1]
Output: 4
Explanation: We can split the array at index 4 to obtain arrays [2,1,3,1,1] and [1,7,1,2,1].
In array [2,1,3,1,1], element 1 is dominant since it occurs thrice in the array and 3 * 2 > 5.
In array [1,7,1,2,1], element 1 is dominant since it occurs thrice in the array and 3 * 2 > 5.
Both [2,1,3,1,1] and [1,7,1,2,1] have the same dominant element as nums, so this is a valid split.
It can be shown that index 4 is the minimum index of a valid split.

Example 3:
Input: nums = [3,3,3,3,7,2,2]
Output: -1
Explanation: It can be shown that there is no valid split.

*/
