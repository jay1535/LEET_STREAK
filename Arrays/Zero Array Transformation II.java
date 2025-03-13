//Solution

class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length ; 
        int m = queries.length ; 
        int curr = 0 ; 
        while( curr<n && nums[curr] == 0 ) curr++ ; 
        if( curr == n ) return 0 ; 
        int[] diff = new int[n+1] ; 
        diff[0] = nums[0] ; 
        for( int i=1 ; i<n ; ++i ){
            diff[i] = nums[i] - nums[i-1] ; 
        }
        int l ,r ,val ; 
        for( int i=0 ; i<m ; ++i ){
            l = queries[i][0] ; 
            r = queries[i][1] ; 
            val = queries[i][2] ; 
            if( l > curr){
                diff[l] -= val ;
                diff[r+1] += val ; 
            }else if( r >= curr ){
                diff[curr] -= val ; 
                diff[r+1] += val ;
            }
            if( diff[curr] <= 0 ){
                while( curr < n && diff[curr] <= 0 ){
                    if(++curr < n ){
                        diff[curr] += diff[curr-1] ; 
                    }
                }
                if( curr == n ) return i+1 ; 
            }
        }
        return -1 ; 
    }
}

/*

Example 1:
Input: nums = [2,0,2], queries = [[0,2,1],[0,2,1],[1,1,3]]
Output: 2
Explanation:
For i = 0 (l = 0, r = 2, val = 1):
Decrement values at indices [0, 1, 2] by [1, 0, 1] respectively.
The array will become [1, 0, 1].
For i = 1 (l = 0, r = 2, val = 1):
Decrement values at indices [0, 1, 2] by [1, 0, 1] respectively.
The array will become [0, 0, 0], which is a Zero Array. Therefore, the minimum value of k is 2.

Example 2:
Input: nums = [4,3,2,1], queries = [[1,3,2],[0,2,1]]
Output: -1
Explanation:
For i = 0 (l = 1, r = 3, val = 2):
Decrement values at indices [1, 2, 3] by [2, 2, 1] respectively.
The array will become [4, 1, 0, 0].
For i = 1 (l = 0, r = 2, val = 1):
Decrement values at indices [0, 1, 2] by [1, 1, 0] respectively.
The array will become [3, 0, 0, 0], which is not a Zero Array.

*/
