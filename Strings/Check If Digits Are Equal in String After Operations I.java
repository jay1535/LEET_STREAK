//Solution

class Solution {
    public boolean hasSameDigits(String s) {

        while(s.length() > 2) {
            s = helper(s);
        }

        if(s.charAt(0)==s.charAt(1))
            return true;
        return false;

    }

    String helper(String s) {
        StringBuilder sb = new StringBuilder();

        for(int i=1; i<s.length(); i++) {
            int a = Character.getNumericValue(s.charAt(i-1));
            int b = Character.getNumericValue(s.charAt(i));
            int ch = (a+b)%10;
            sb.append(ch);
        }

        return sb.toString();
    }
}

/*

Example 1:

Input: s = "3902"

Output: true

Explanation:

Initially, s = "3902"
First operation:
(s[0] + s[1]) % 10 = (3 + 9) % 10 = 2
(s[1] + s[2]) % 10 = (9 + 0) % 10 = 9
(s[2] + s[3]) % 10 = (0 + 2) % 10 = 2
s becomes "292"
Second operation:
(s[0] + s[1]) % 10 = (2 + 9) % 10 = 1
(s[1] + s[2]) % 10 = (9 + 2) % 10 = 1
s becomes "11"
Since the digits in "11" are the same, the output is true.
Example 2:

Input: s = "34789"

Output: false

Explanation:

Initially, s = "34789".
After the first operation, s = "7157".
After the second operation, s = "862".
After the third operation, s = "48".
Since '4' != '8', the output is false.


*/
