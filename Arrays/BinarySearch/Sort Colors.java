//Solution

class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length-1;

        while(mid<=high){
                if(nums[mid]==0){
                    swap(nums,mid,low);
                    low++;
                    mid++;
                }
                else if(nums[mid]==1){
                    mid++;
                }
                else{
                    swap(nums,mid,high);
                    high--;
                }
        }
    }

    private static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp; 
    }
}

/*

Example 1:
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Example 2:
Input: nums = [2,0,1]
Output: [0,1,2]

*/
