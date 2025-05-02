//Solution

class Solution {
     public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int[] forces = new int[n];
        int force = 0;


        for (int i = 0; i < n; i++) {
            if (dominoes.charAt(i) == 'R') {
                force = n; // max force
            } else if (dominoes.charAt(i) == 'L') {
                force = 0; 
            } else {
                force = Math.max(force - 1, 0); 
            }
            forces[i] += force;
        }

        force = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (dominoes.charAt(i) == 'L') {
                force = n;
            } else if (dominoes.charAt(i) == 'R') {
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }
            forces[i] -= force;
        }

        StringBuilder result = new StringBuilder();
        for (int f : forces) {
            if (f > 0) {
                result.append('R');
            } else if (f < 0) {
                result.append('L');
            } else {
                result.append('.');
            }
        }

        return result.toString();
    }
}

/*

Example 1:
Input: dominoes = "RR.L"
Output: "RR.L"
Explanation: The first domino expends no additional force on the second domino.

Example 2:
Input: dominoes = ".L.R...LR..L.."
Output: "LL.RR.LLRRLL.."
 
Constraints:
n == dominoes.length
1 <= n <= 105
dominoes[i] is either 'L', 'R', or '.'.

*/
