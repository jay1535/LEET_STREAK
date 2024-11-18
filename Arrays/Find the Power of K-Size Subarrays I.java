// Solution

class Solution {
    public int[] resultsArray(int[] nums, int k) {
            if (nums == null || nums.length < k) {
            return new int[0];
        }

        int arr[]=new int[nums.length-k+1];
        int i=0;
        int j=k-1;
        int a=0;
        while(j<nums.length){
            if(solved(nums,i,j)){
                arr[a]=nums[j];
            }
            else{
                arr[a]=-1;
            }
            i++;
            j++;
            a++;
        }
        return arr;
        
    }

    private boolean solved(int nums[],int start,int end){
        for(int i=start;i<end;i++){
            if(nums[i]+1!=nums[i+1]){
                return false;
            }
        }
        return true;
    }
}

/*

Example 1:
Input: nums = [1,2,3,4,3,2,5], k = 3
Output: [3,4,-1,-1,-1]
Explanation:
There are 5 subarrays of nums of size 3:
[1, 2, 3] with the maximum element 3.
[2, 3, 4] with the maximum element 4.
[3, 4, 3] whose elements are not consecutive.
[4, 3, 2] whose elements are not sorted.
[3, 2, 5] whose elements are not consecutive.

Example 2:
Input: nums = [2,2,2,2,2], k = 4
Output: [-1,-1]

Example 3:
Input: nums = [3,2,3,2,3,2], k = 2
Output: [-1,3,-1,3,-1]

*/
