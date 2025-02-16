//Solution

class Solution {
    public int[] constructDistancedSequence(int n) {
        int[] result = new int[2 * n - 1];
        boolean[] used = new boolean[n + 1];
        backtrack(result, used, n, 0);
        return result;
    }
    private boolean backtrack(int[] result, boolean[] used, int n, int index){
        while(index < result.length && result[index] != 0){
            index++;
        }
        if(index == result.length){
            return true;
        }
        for(int i = n; i >= 1; i--){
            if(used[i]) continue;

            if(i == 1){
                result[index] = 1;
                used[1] = true;
                if(backtrack(result, used, n, index + 1)) return true;
                result[index] = 0;
                used[1] = false;
            }
            else{
                if(index + i < result.length && result[index + i] == 0){
                    result[index] = i;
                    result[index + i] = i;
                    used[i] = true;
                    if(backtrack(result, used, n, index + 1)) return true;
                    result[index] = 0;
                    result[index + i] = 0;
                    used[i] = false;
                }
            }
        }
        return false;
    }
}

/*

Example 1:
Input: n = 3
Output: [3,1,2,3,2]
Explanation: [2,3,2,1,3] is also a valid sequence, but [3,1,2,3,2] is the lexicographically largest valid sequence.

Example 2:
Input: n = 5
Output: [5,3,1,4,3,5,2,4,2]

*/
