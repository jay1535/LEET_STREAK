// Solution

class Solution {
    private static boolean[] prime;
    
    private void seive(int n){
        if(prime == null){
            System.out.println("Creating first seive");
            prime = new boolean[n + 1];
            Arrays.fill(prime, true);
            prime[1] = false;

            for (int p = 2; p * p <= n; p++) {
                if (prime[p] == true) {
                    for (int i = p * p; i <= n; i += p)
                        prime[i] = false;
                }
            }
        }else{    
        }
    }
    public boolean primeSubOperation(int[] nums) {
        seive(1000);
        int j = 0, smallestTillNow = 1;   
        while(j < nums.length){
                 
            int diff = nums[j] - smallestTillNow;
            if(diff < 0){             
                return false;
            }     
            if(prime[diff] || diff == 0){               
                smallestTillNow++;
                j++;
            }else{
                smallestTillNow++;
            }
        }
        return true;
    }
}

/*

Example 1:
Input: nums = [4,9,6,10]
Output: true
Explanation: In the first operation: Pick i = 0 and p = 3, and then subtract 3 from nums[0], so that nums becomes [1,9,6,10].
In the second operation: i = 1, p = 7, subtract 7 from nums[1], so nums becomes equal to [1,2,6,10].
After the second operation, nums is sorted in strictly increasing order, so the answer is true.

Example 2:
Input: nums = [6,8,11,12]
Output: true
Explanation: Initially nums is sorted in strictly increasing order, so we don't need to make any operations.

Example 3:
Input: nums = [5,8,3]
Output: false
Explanation: It can be proven that there is no way to perform operations to make nums sorted in strictly increasing order, so the answer is false.

*/
