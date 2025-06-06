//Solution

class Solution {
    public String robotWithString(String s) {
        int n  = s.length();
        int[] suffixMin = new int[n+1];
        suffixMin[n] = Integer.MAX_VALUE;
        for (int i = n-1; i>=0; i--){
            suffixMin[i] = Math.min(s.charAt(i), suffixMin[i+1]);
        }
        StringBuilder res = new StringBuilder();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i< n; i++){
            st.push(s.charAt(i));
            while(!st.isEmpty() && st.peek()<=(char)suffixMin[i+1]){
                res.append(st.pop());

            }
        }
        return res.toString();
    }
}

/*

Example 1:
Input: s = "zza"
Output: "azz"
Explanation: Let p denote the written string.
Initially p="", s="zza", t="".
Perform first operation three times p="", s="", t="zza".
Perform second operation three times p="azz", s="", t="".

Example 2:
Input: s = "bac"
Output: "abc"
Explanation: Let p denote the written string.
Perform first operation twice p="", s="c", t="ba". 
Perform second operation twice p="ab", s="c", t="". 
Perform first operation p="ab", s="", t="c". 
Perform second operation p="abc", s="", t="".

Example 3:
Input: s = "bdda"
Output: "addb"
Explanation: Let p denote the written string.
Initially p="", s="bdda", t="".
Perform first operation four times p="", s="", t="bdda".
Perform second operation four times p="addb", s="", t="".

*/
