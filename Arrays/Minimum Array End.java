// Solution

public class Solution {
    public long minEnd(int n, int x) {
        ArrayList<Integer> shifts = new ArrayList<>();
        
        long cur = x;
        
        long calc = n - 1;
        
        for(int i = 0; i < 32; i++) {
            if((x & (1 << i)) == 0) {
                shifts.add(i);
            }
        }
        
        for(int i = 32; i < 64; i++) {
            shifts.add(i);
        }
        
        for(int i = 0; calc > 0; i++, calc >>= 1) {
            cur += (calc & 1L) << shifts.get(i);
        }
        
        return cur;
    }
}

/*

Example 1:
Input: n = 3, x = 4
Output: 6
Explanation:
nums can be [4,5,6] and its last element is 6.

Example 2:
Input: n = 2, x = 7
Output: 15
Explanation:
nums can be [7,15] and its last element is 15.


Constraints:
1 <= n, x <= 108

*/
