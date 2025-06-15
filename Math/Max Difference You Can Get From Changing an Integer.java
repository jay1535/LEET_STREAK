//Solution

class Solution {
    public int maxDiff(int num) {
        String s = Integer.toString(num), a = "", b;
        char c = 0;
        for (char ch : s.toCharArray()) if (ch != '9') { c = ch; a = s; break; }
        if (!a.isEmpty()) a = a.replace(c, '9'); else a = s;
        if (s.charAt(0) != '1') {
            b = s.replace(s.charAt(0), '1');
        } else {
            b = s;
            for (int i = 1; i < s.length(); ++i) {
                char ch = s.charAt(i);
                if (ch != '0' && ch != '1') {
                    b = b.replace(ch, '0');
                    break;
                }
            }
        }
        return Integer.parseInt(a) - Integer.parseInt(b);
    }
}

/*


Example 1:
Input: num = 555
Output: 888
Explanation: The first time pick x = 5 and y = 9 and store the new integer in a.
The second time pick x = 5 and y = 1 and store the new integer in b.
We have now a = 999 and b = 111 and max difference = 888

Example 2:
Input: num = 9
Output: 8
Explanation: The first time pick x = 9 and y = 9 and store the new integer in a.
The second time pick x = 9 and y = 1 and store the new integer in b.
We have now a = 9 and b = 1 and max difference = 8

*/
