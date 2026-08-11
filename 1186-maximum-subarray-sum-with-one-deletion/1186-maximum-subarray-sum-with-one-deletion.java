class Solution {
    public int maximumSum(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return arr[0];
        }
        // maxNoDelete: Maximum subarray sum ending at index i with ZERO elements deleted.
        // This is the standard Kadane's algorithm state.
        int maxNoDelete = arr[0]; 

        // maxOneDelete: Maximum subarray sum ending at index i with EXACTLY ONE element deleted.
        // Initialized to arr[0] because at index 1, one option is to delete arr[1] 
        // and keep only arr[0].
        int maxOneDelete = arr[0];
        int result = arr[0];

        for (int i = 1; i < n; i++) {
            // We store the 'no-delete' result from the previous index (i-1).
            int prevNoDelete = maxNoDelete;
            /* Standard Kadane's logic: 
               Either extend the previous subarray or start a new one at the current index.
            */
            maxNoDelete = Math.max(maxNoDelete + arr[i], arr[i]);

            /* Two options for a subarray with one deletion:
               Option 1: (maxOneDelete + arr[i]) 
                         We already used our deletion on an earlier element. 
                         Therefore, we MUST include the current element arr[i].
               
               Option 2: (prevNoDelete) 
                         We choose to delete the current element arr[i] right now. 
                         The sum becomes the max sum ending at the previous index (i-1) 
                         where no elements were deleted.
            */
            maxOneDelete = Math.max(maxOneDelete + arr[i], prevNoDelete);
            // The answer is the best sum found across all indices, 
            // whether we deleted an element or not.
            result = Math.max(result, Math.max(maxNoDelete, maxOneDelete));
        }       
        return result;
    }
}