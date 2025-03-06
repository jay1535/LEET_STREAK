//Solution

class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n=grid.length;
        int a=0, b=0;
        int[] arr=new int[n*n+1];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[grid[i][j]]++;
            }
        }

        for(int i=1; i<=n*n; i++){
            if(arr[i]>1){
                a=i;
            }

            if(arr[i]==0){
                b=i;
            }
        }

        return new int[]{a,b};
    }
}

/*

Example 1:
Input: grid = [[1,3],[2,2]]
Output: [2,4]
Explanation: Number 2 is repeated and number 4 is missing so the answer is [2,4].

Example 2:
Input: grid = [[9,1,7],[8,9,2],[3,4,6]]
Output: [9,5]
Explanation: Number 9 is repeated and number 5 is missing so the answer is [9,5].

*/
