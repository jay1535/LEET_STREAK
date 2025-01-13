//Solution
class Solution {
    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 != 0) return false;

        int min = 0; 
        int max = 0; 

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char lock = locked.charAt(i);

            if (c == '(' && lock == '1') {
                min++; 
                max++;
            } else if (c == ')' && lock == '1') {
                min--; 
                max--; 
            } else { 
                
                min--; 
                max++; 
            }

            if (min < 0) min = 0;

            if (max < 0) return false;
        }

        return min == 0;
    }
}

/*

Example 1:
Input: s = "))()))", locked = "010100"
Output: true
Explanation: locked[1] == '1' and locked[3] == '1', so we cannot change s[1] or s[3].
We change s[0] and s[4] to '(' while leaving s[2] and s[5] unchanged to make s valid.

Example 2:
Input: s = "()()", locked = "0000"
Output: true
Explanation: We do not need to make any changes because s is already valid.

Example 3:
Input: s = ")", locked = "0"
Output: false
Explanation: locked permits us to change s[0]. 
Changing s[0] to either '(' or ')' will not make s valid.
 
*/
