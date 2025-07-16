//SOlution

class Solution {
    public int maximumLength(int[] nums) {
        int c = nums[0] % 2;
        int odd = 0, even = 0, both = 0;
        for (int num: nums){
            if (num%2==0){
                even++;
            }
            else{
                odd++;
            }
            if(num%2==c){
                both++;
                c = 1-c;
            }
        }
        return Math.max(both, Math.max(even,odd));
    }
}

/*

Example 1:
Input: nums = [1,2,3,4]
Output: 4
Explanation:
The longest valid subsequence is [1, 2, 3, 4].

Example 2:
Input: nums = [1,2,1,1,2,1,2]
Output: 6
Explanation:
The longest valid subsequence is [1, 2, 1, 2, 1, 2].

Example 3:
Input: nums = [1,3]
Output: 2
Explanation:
The longest valid subsequence is [1, 3].

*/
